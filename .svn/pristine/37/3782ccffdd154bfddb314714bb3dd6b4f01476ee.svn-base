package medical.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Collection;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.pack200.Pack200CompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FilenameUtils;

import com.ice.tar.TarArchive;
import com.ice.tar.TarBuffer;
import com.ice.tar.TarEntry;

public class TarUtil {
	private TarUtil() {

    }

    public static final int BUFFER_SIZE = 2048;

    public static enum CompressionType {
        BZIP2, GZIP, NONE
    }

    public static void tar(File dir, File tarFile, CompressionType compressionType) throws Throwable {

        tar(dir, true, tarFile, compressionType);

    }

    public static void tar(File dir, boolean self, File tarFile, CompressionType compressionType) throws Throwable {

        if (self) {
            // Find the parent directory. If 'dir' was supplied as a relative
            // path originally it will fail to find the parent directory. Work
            // around this by remaking from the absolute path
            File t = new File(dir.getAbsolutePath());
            tar(new File[] { dir }, t.getParentFile(), tarFile, compressionType);
        } else {
            tar(dir.listFiles(), dir, tarFile, compressionType);
        }
    }

    public static void tar(Collection<File> filesToTar, File baseDir, File tarFile, CompressionType compressionType)
            throws Throwable {

        File[] files = new File[filesToTar.size()];
        int i = 0;
        for (File f : filesToTar) {
            files[i++] = f;
        }
        tar(files, baseDir, tarFile, compressionType);
    }

    public static void tar(File[] files, File baseDir, File tarFile, CompressionType compressionType) throws Throwable {

        TarArchiveOutputStream os = null;
        try {
            if (compressionType == CompressionType.NONE) {
                os = new TarArchiveOutputStream(new BufferedOutputStream(new FileOutputStream(tarFile), BUFFER_SIZE));
            } else {
                new TarArchiveOutputStream(new CompressorStreamFactory().createCompressorOutputStream(
                        compressionType.toString(),
                        new BufferedOutputStream(new FileOutputStream(tarFile), BUFFER_SIZE)));
            }
            // Set handler to support large files (>8GB)
            os.setBigNumberMode(TarArchiveOutputStream.BIGNUMBER_POSIX);

            // Generate
            tar(files, baseDir, os);

        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    private static void tar(File[] files, File baseDir, TarArchiveOutputStream os) throws Throwable {

        String base = baseDir.getAbsolutePath();
        byte buffer[] = new byte[BUFFER_SIZE];
        for (File f : files) {
            String name = f.getAbsolutePath();
            if (name.startsWith(base)) {
                name = name.substring(base.length());
            }
            if (name.startsWith(System.getProperty("file.separator"))) {
                name = name.substring(1);
            }
            if (f.isDirectory()) {
                TarArchiveEntry entry = new TarArchiveEntry(f, name + "/");
                os.putArchiveEntry(entry);
                os.closeArchiveEntry();
                tar(f.listFiles(), baseDir, os);
            } else {
                TarArchiveEntry entry = new TarArchiveEntry(f, name);
                entry.setSize(f.length());
                os.putArchiveEntry(entry);
                BufferedInputStream is = new BufferedInputStream(new FileInputStream(f), BUFFER_SIZE);
                int count;
                while ((count = is.read(buffer, 0, BUFFER_SIZE)) != -1) {
                    os.write(buffer, 0, count);
                }
                is.close();
                os.closeArchiveEntry();
            }
        }

    }

    /**
     * Extract the tar archive file to the given directory. It works even if the
     * tar file is compressed with gzip or bzip2.
     * 
     * @param tarFile
     *            the tar archive file (can be compressed tar file e.g. .tar.gz
     *            or .tar.bz2).
     * @param toDir
     *            the destined directory
     * @throws Throwable
     */
    public static void untar(File tarFile, File toDir) throws Throwable {

        untar(tarFile, toDir, null);
    }

    /**
     * Extract the tar archive file to the given directory and save the list of
     * files extracted into the given collection object if it is supplied.
     * 
     * @param tarFile
     *            the tar archive file (can be compressed tar file e.g. .tar.gz
     *            or .tar.bz2).
     * @param toDir
     *            the destined directory
     * @param files
     *            the collection to save the extracted file list.
     * @throws Throwable
     */
    public static void untar(File tarFile, File toDir, Collection<File> files) throws Throwable {

        TarArchiveInputStream tin = null;
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(tarFile), BUFFER_SIZE);
            final byte[] signature = new byte[12];
            in.mark(signature.length);
            int signatureLength = IOUtils.readFully(in, signature);
            in.reset();
            if (BZip2CompressorInputStream.matches(signature, signatureLength)) {
                tin = new TarArchiveInputStream(new BZip2CompressorInputStream(in));
            } else if (GzipCompressorInputStream.matches(signature, signatureLength)) {
                tin = new TarArchiveInputStream(new GzipCompressorInputStream(in));
            } else if (XZUtils.isXZCompressionAvailable()
                    && XZCompressorInputStream.matches(signature, signatureLength)) {
                tin = new TarArchiveInputStream(new XZCompressorInputStream(in));
            } else if (Pack200CompressorInputStream.matches(signature, signatureLength)) {
                tin = new TarArchiveInputStream(new Pack200CompressorInputStream(in));
            } else {
                tin = new TarArchiveInputStream(in);
            }
            TarArchiveEntry entry;
            while ((entry = tin.getNextTarEntry()) != null) {
                File destFile = new File(toDir.getAbsolutePath() + "/" + entry.getName());
                if (entry.isDirectory()) {
                    destFile.mkdirs();
                } else {
                    File parentDir = destFile.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }
                    BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(destFile), BUFFER_SIZE);
                    long size = entry.getSize();
                    long n = 0;
                    int count;
                    byte buffer[] = new byte[BUFFER_SIZE];
                    while ((count = in.read(buffer)) != -1 && n < size) {
                        os.write(buffer, 0, count);
                        n += count;
                    }
                    os.flush();
                    os.close();
                }
                if (files != null) {
                    files.add(destFile);
                }
            }
        } finally {
            if (tin != null) {
                tin.close();
            }
        }
    }
    
    /**
     * 파일을 Tar로 묶는다.
     * @param archiveFile
     * @param tobeTarFiles
     * @return
     */
    public static boolean createTarArchive( File archiveFile, File[] tobeTarFiles ){
        boolean bRet = false;
        try{
         FileOutputStream outStream = new FileOutputStream(archiveFile);
         //GZIPOutputStream outStream = new GZIPOutputStream(outStream); //압축할때 jar로 만들때..
         
         
         int blockSize = TarBuffer.DEFAULT_BLKSIZE;
         TarArchive archive = new TarArchive( outStream, blockSize );
         if( archive != null) {
//          archive.setDebug( false );
//          archive.setVerbose( true );
//          archive.setKeepOldFiles( false );
//          archive.setAsciiTranslation( false );
//          archive.setUserInfo( 0,"", 0, "" );
         
          TarEntry entry = null;
          String fileName = null;
          for( int i = 0 ; i < tobeTarFiles.length ; i ++ ){
           if (tobeTarFiles[i] == null || !tobeTarFiles[i].exists() || tobeTarFiles[i].isDirectory() )
            continue;
           
           entry = new TarEntry( tobeTarFiles[i] );
           
           if( entry.getName().lastIndexOf("/") > -1 ){
            fileName = entry.getName().substring( entry.getName().lastIndexOf("/") +1 );  //이건 파일이 폴더째 저장되는 경우 폴더를 없애고 한 곳에 파일을 넣기 위해서 이다.. 삭제 가능..
            entry.setName( fileName );
           }
//           System.out.println( "Add File: " + entry.getName() );
           
           // TAR압축 시 자신인 TAR파일은 제외한다. 20200402 MartinJang
           if(!"TAR".equals(FilenameUtils.getExtension(entry.getName()).toUpperCase()))
        	   archive.writeEntry( entry, true );
          }
         
          archive.closeArchive();
         }
         
         outStream.close();
//         System.out.println("Adding completed OK");
         bRet = true;
        }catch (Exception e){
         e.printStackTrace();
         System.out.println( "Error: " + e.getMessage() );
         return false;
        }
        return bRet;
       }
    
//    public static void main( String[] args ) throws Exception {
//	  String tarFileName = "D:/Test.tar";     //압축파일 이름..
//	  String archiveFilePath = "D:/test/";    //이 폴더 안에 있는 데이터를 압축하자..
//	  File file = new File(tarFileName);
//	  File filePath = new File(archiveFilePath);
//	 
//	  createTarArchive( file, filePath.listFiles() );
//	 }
}
