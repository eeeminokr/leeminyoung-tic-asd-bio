package medical.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.FileCopyUtils;

import medical.common.progress.ProgressDetails;

public class ZipUtil {
	private static final int COMPRESSION_LEVEL = 8;

    private static final int BUFFER_SIZE = 1024 * 2;

    /**
     * 지정된 폴더를 Zip 파일로 압축한다.
     * @param sourcePath - 압축 대상 디렉토리
     * @param output - 저장 zip 파일 이름
     * @throws Exception
     */
    public static void zip(String sourcePath, String output) throws Exception {

        // 압축 대상(sourcePath)이 디렉토리나 파일이 아니면 리턴한다.
        File sourceFile = new File(sourcePath);
        if (!sourceFile.isFile() && !sourceFile.isDirectory()) {
            throw new Exception("압축 대상의 파일을 찾을 수가 없습니다.");
        }

        // output 의 확장자가 zip이 아니면 리턴한다.
        if (!(StringUtils.substringAfterLast(output, ".")).equalsIgnoreCase("zip")) {
            throw new Exception("압축 후 저장 파일명의 확장자를 확인하세요");
        }

        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ZipOutputStream zos = null;

        try {
            fos = new FileOutputStream(output); // FileOutputStream
            bos = new BufferedOutputStream(fos); // BufferedStream
            zos = new ZipOutputStream(bos); // ZipOutputStream
            zos.setLevel(COMPRESSION_LEVEL); // 압축 레벨 - 최대 압축률은 9, 디폴트 8
            zipEntry(sourceFile, sourcePath, zos); // Zip 파일 생성
            zos.finish(); // ZipOutputStream finish
        } finally {
            if (zos != null) {
                zos.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    /**
     * 압축
     * @param sourceFile
     * @param sourcePath
     * @param zos
     * @throws Exception
     */
    private static void zipEntry(File sourceFile, String sourcePath, ZipOutputStream zos) throws Exception {
        // sourceFile 이 디렉토리인 경우 하위 파일 리스트 가져와 재귀호출
        if (sourceFile.isDirectory()) {
            if (sourceFile.getName().equalsIgnoreCase(".metadata")) { // .metadata 디렉토리 return
                return;
            }
            File[] fileArray = sourceFile.listFiles(); // sourceFile 의 하위 파일 리스트
            for (int i = 0; i < fileArray.length; i++) {
                zipEntry(fileArray[i], sourcePath, zos); // 재귀 호출
            }
        } else { // sourcehFile 이 디렉토리가 아닌 경우
            BufferedInputStream bis = null;
            try {
                String sFilePath = sourceFile.getPath();
                String zipEntryName = sFilePath.substring(sourcePath.length() + 1, sFilePath.length());

                bis = new BufferedInputStream(new FileInputStream(sourceFile));
                ZipEntry zentry = new ZipEntry(zipEntryName);
                zentry.setTime(sourceFile.lastModified());
                zos.putNextEntry(zentry);

                byte[] buffer = new byte[BUFFER_SIZE];
                int cnt = 0;
                while ((cnt = bis.read(buffer, 0, BUFFER_SIZE)) != -1) {
                    zos.write(buffer, 0, cnt);
                }
                zos.closeEntry();
            } finally {
                if (bis != null) {
                    bis.close();
                }
            }
        }
    }
    static int fileCnt = 0;
    static int zipCnt = 0;
    private static void zipEntry2(File sourceFile, 
    		String sourcePath, 
    		ZipOutputStream zos, 
    		ProgressDetails taskProgress,
    		String taskId) throws Exception {
    	if(fileCnt == 0) {
    		System.out.println("sourceFile cnt ################# > " + sourceFile.list().length);
    		taskProgress.setTotal(sourceFile.list().length);	//하위폴더포함 파일갯수
    		ProgressDetails.taskProgressHash.put(taskId, taskProgress);
    	}
        // sourceFile 이 디렉토리인 경우 하위 파일 리스트 가져와 재귀호출
        if (sourceFile.isDirectory()) {
            if (sourceFile.getName().equalsIgnoreCase(".metadata")) { // .metadata 디렉토리 return
                return;
            }
            File[] fileArray = sourceFile.listFiles(); // sourceFile 의 하위 파일 리스트
            for (int i = 0; i < fileArray.length; i++) {
            	fileCnt = 1;
                zipEntry2(fileArray[i], sourcePath, zos, taskProgress, taskId); // 재귀 호출
            }
        } else { // sourcehFile 이 디렉토리가 아닌 경우
            BufferedInputStream bis = null;
            try {
                String sFilePath = sourceFile.getPath();
                String zipEntryName = sFilePath.substring(sourcePath.length() + 1, sFilePath.length());

                bis = new BufferedInputStream(new FileInputStream(sourceFile));
                ZipEntry zentry = new ZipEntry(zipEntryName);
                zentry.setTime(sourceFile.lastModified());
                zos.putNextEntry(zentry);

                byte[] buffer = new byte[BUFFER_SIZE];
                int cnt = 0;
                while ((cnt = bis.read(buffer, 0, BUFFER_SIZE)) != -1) {
                    zos.write(buffer, 0, cnt);
                }
                zos.closeEntry();
                taskProgress.setTotalProcessed(++zipCnt);
				ProgressDetails.taskProgressHash.put(taskId, taskProgress);
            } finally {
                if (bis != null) {
                    bis.close();
                }
            }
        }
    }

    /**
     * Zip 파일의 압축을 푼다.
     *
     * @param zipFile - 압축 풀 Zip 파일
     * @param targetDir - 압축 푼 파일이 들어간 디렉토리
     * @param fileNameToLowerCase - 파일명을 소문자로 바꿀지 여부
     * @throws Exception
     */
    public static void unzip(File zipFile, File targetDir, boolean fileNameToLowerCase) throws Exception {
        FileInputStream fis = null;
        ZipInputStream zis = null;
        ZipEntry zentry = null;

        try {
            fis = new FileInputStream(zipFile); // FileInputStream
//          zis = new ZipInputStream(fis);
            zis = new ZipInputStream(fis, Charset.forName("ISO-8859-1")); // ZipInputStream
          // java.nio.charset	바이트와 Unicode 문자의 상호 변환을 실시하기 (위해)때문에, 캐릭터 세트, 디코더, 및 엔코더를 정의함.
            while ((zentry = zis.getNextEntry()) != null) {
                String fileNameToUnzip = zentry.getName();
                if (fileNameToLowerCase) { // fileName toLowerCase
                    fileNameToUnzip = fileNameToUnzip.toLowerCase();
                }

                File targetFile = new File(targetDir, fileNameToUnzip);

                if (zentry.isDirectory()) {// Directory 인 경우
                    FileUtils.makeDir(targetFile.getAbsolutePath()); // 디렉토리 생성
                } else { // File 인 경우
                    // parent Directory 생성
                    FileUtils.makeDir(targetFile.getParent());
                    unzipEntry(zis, targetFile);
                }
            }
        } finally {
            if (zis != null) {
                zis.close();
            }
            if (fis != null) {
                fis.close();
            }
//            zipFile.delete();
        }
    }
    
    /**
     * gz 파일의 압축을 푼다.
     *
     * @param gzFile - 압축 풀 gz 파일
     * @param targetDir - 압축 푼 파일이 들어간 디렉토리
     * @param bufferSize - 버퍼사이즈
     * @throws Exception
     */
    public static void unGz(File gzFile, File targetDir, int bufferSize) throws Exception {
    	byte[] buffer = new byte[bufferSize];
        FileInputStream fis = null;
        GZIPInputStream gzis = null;
        FileOutputStream fos = null;
        int readLength = 0;
        try {
            fis = new FileInputStream(gzFile); // FileInputStream
            gzis = new GZIPInputStream(fis); // ZipInputStream
            fos = new FileOutputStream(targetDir);
            while((readLength = gzis.read(buffer))>0) {
            	fos.write(buffer,0,readLength);
            	fos.flush();
            }
        } finally {
            if (fos != null) {fos.close();}
            if (gzis != null) {gzis.close();}
            if (fis != null) {fis.close();}
            gzFile.delete();
        }
    }
    
    public static String unGzToNii(File gzFile, String localFileName, String destinationDir){
        OutputStream outStream = null;
        GZIPInputStream zip = null;
        String niiFileFullPath = "";
        try {
            File file = new File(destinationDir+StringUtil.PathSep(localFileName));
            if( !file.getParentFile().isDirectory() ) {
                file.getParentFile().mkdirs();
            }
            outStream = new FileOutputStream(file.getPath());
            zip = new GZIPInputStream(new FileInputStream(gzFile));
            FileCopyUtils.copy(zip, outStream);
            niiFileFullPath = file.getAbsolutePath();
        }catch(Exception e) {
        	e.printStackTrace();
        }
        return niiFileFullPath;
    }


    /**
     * Zip 파일의 한 개 엔트리의 압축을 푼다.
     *
     * @param zis - Zip Input Stream
     * @param filePath - 압축 풀린 파일의 경로
     * @return
     * @throws Exception
     */
    protected static File unzipEntry(ZipInputStream zis, File targetFile) throws Exception {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(targetFile);

            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
        return targetFile;
    }
    
    /**
     * 해당 디렉토리 압축파일 생성
     *
     * @param baseDirectory - 디렉토리
     * @param zipName - 파일명
     * @return
     * @throws Exception
     */
    public static File makeZip(String baseDirectory, String zipName, 
    		ProgressDetails taskProgress, String taskId) throws IOException {
    	baseDirectory = baseDirectory + StringUtil.PathSep("");
		// 디렉토리 위로 zip 생성하기 꺼내기..
		File zipFile = new File(baseDirectory,zipName+".zip");
		if(zipFile.exists()) {
			grantFileAuth(zipFile);
			zipFile.delete();
		}
		boolean tf = zipFile.createNewFile();
		if(tf) {
			File srcDir = new File(baseDirectory + zipName);
			List<String> fileList = listDirectory(srcDir);
			taskProgress.setTotal(fileList.size());
			ProgressDetails.taskProgressHash.put(taskId, taskProgress);
			FileOutputStream fos = new FileOutputStream(zipFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ZipOutputStream zout = new ZipOutputStream(bos);
			
			zout.setLevel(8);
			int cnt = 0;
			for (String fileName : fileList) {
				File file = new File(srcDir.getParent(), fileName);
	
				// Zip always use / as separator
				fileName = fileName.substring(fileName.indexOf("/")+1);
				String zName = new String();
				if (File.separatorChar != '/')zName = fileName.replace(File.separatorChar, '/');
				else zName = fileName;
				ZipEntry ze;
			    if (file.isFile()) {
			    	ze = new ZipEntry(zName);
				    ze.setTime(file.lastModified());
				    zout.putNextEntry(ze);
				    FileInputStream fin = new FileInputStream(file);
				    byte[] buffer = new byte[4096];
				    for (int n; (n = fin.read(buffer)) > 0;)zout.write(buffer, 0, n);
				    fin.close();
			   }else{
				   ze = new ZipEntry(zName + '/');
				   ze.setTime(file.lastModified());
				   zout.putNextEntry(ze);
			   }
			   taskProgress.setTotalProcessed(++cnt);
			   ProgressDetails.taskProgressHash.put(taskId, taskProgress);
		  }
		  zout.close();
		  taskProgress.setTotal(0);
		  taskProgress.setTotalProcessed(0);
		  ProgressDetails.taskProgressHash.put(taskId, taskProgress);
		}
		return zipFile;
    }
    
    public static List<String> listDirectory(File directory) throws IOException {
    	Stack<String> stack = new Stack<String>();
    	List<String> list = new ArrayList<String>();
    	
    	// If it's a file, just return itself
    	if (directory.isFile()) {
    		if (directory.canRead())list.add(directory.getName());
    		return list;
    	}
    	// Traverse the directory in width-first manner, no-recursively
    	String root = directory.getParent();
    	stack.push(directory.getName());
    	String current = new String();
    	while (!stack.empty()) {
    		current = (String) stack.pop();
    		File curDir = new File(root, current);
    		String[] fileList = curDir.list();
    		if(fileList != null){
    			for (String entry : fileList) {
    				File f = new File(curDir, entry);
				    if (f.isFile()) {
				    	if (f.canRead()) {
				    		list.add(current + File.separator + entry);
				    	} else {
				    		System.err.println("File " + f.getPath() + " is unreadable");
				    		throw new IOException("Can't read file: " + f.getPath());
				    	}
				    } else if (f.isDirectory()) {
				    	list.add(current + File.separator + entry);
				    	stack.push(current + File.separator + f.getName());
				    } else {
				    	throw new IOException("Unknown entry: " + f.getPath());
				    }
    			}
    		}
    	}
    	return list;
	 }
    
    public static void deleteDir(String path) {
    	File oldF = new File(path);
    	if(oldF.exists()) {
    		grantAuth(oldF.getAbsolutePath());
			//폴더내 파일을 배열로 가져온다. 
			File[] tempFile = oldF.listFiles();
			if(tempFile != null) {
				if(tempFile.length >0){
				      for (int i = 0; i < tempFile.length; i++) {
				         if(tempFile[i].isFile()){
				            tempFile[i].delete(); // 디렉토리 안의 내용물을 지운다.
				         }else {
				        	 deleteDir(tempFile[i].getPath());
				         }
				         tempFile[i].delete();
				      } // for
				   }
			}
		    oldF.delete();
    	}
    }
    
    public static void deleteDirExceptRoot(String path) {
    	File oldF = new File(path);
    	if(oldF.exists()) {
    		grantAuth(oldF.getAbsolutePath());
			//폴더내 파일을 배열로 가져온다. 
			File[] tempFile = oldF.listFiles();
			if(tempFile != null) {
				if(tempFile.length >0){
				      for (int i = 0; i < tempFile.length; i++) {
				         if(tempFile[i].isFile()){
				            tempFile[i].delete(); // 디렉토리 안의 내용물을 지운다.
				         }else {
				        	 deleteDir(tempFile[i].getPath());
				         }
				         tempFile[i].delete();
				      } // for
				   }
			}
    	}
    }
    
    public static boolean grantAuth(String path) {
		boolean tf = false;
		try {
			String cmd = "chmod 777 -R " + path; //모든 권한 부여 
			Runtime rt = Runtime.getRuntime();
			Process prc = rt.exec(cmd);
			prc.waitFor();
			tf = true;
		}catch(Exception e) {
			tf = false;
			e.printStackTrace();
		}
		return tf;
	}
    public static boolean grantFileAuth(File oFile) {
    	boolean tf = false;
    	try {
    		oFile.setReadable(true, false);
    		oFile.setWritable(true, false);
    		oFile.setExecutable(true, false);
    		tf = true;
    	}catch(Exception e) {
    		tf = false;
    		e.printStackTrace();
    	}
    	
    	return tf;
	}
    public static void deleteExtenstion(String path, String extension) {
    	File oldF = new File(path);
		//폴더내 파일을 배열로 가져온다. 
		File[] tempFile = oldF.listFiles();
		String fileExtension = new String();
		if(tempFile != null) {
			if(tempFile.length >0){
			      for (int i = 0; i < tempFile.length; i++) {
			         if(tempFile[i].isFile()){
			        	 fileExtension = tempFile[i].getName().substring(tempFile[i].getName().lastIndexOf(".")+1);
			        	 if(extension.equals(fileExtension))tempFile[i].delete(); // 디렉토리 안의 내용물을 지운다.
			         }else {
			        	 deleteExtenstion(tempFile[i].getPath(),extension);
			         }
			      } // for
			   }
		}
    }

}
