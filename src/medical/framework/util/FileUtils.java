package medical.framework.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class FileUtils {

	public final static String ORIGINAL_FILE_NAME = "ORIGINAL_FILE_NAME";
	public final static String NEW_FILE_NAME = "NEW_FILE_NAME";
	public final static String FILE_PATH = "FILE_PATH";

	/**
	 * file upload method
	 * 
	 * @param MultipartFile
	 *            file
	 * @param String
	 *            filePathReourceName
	 * @return Map
	 */

	public static Map<String, String> transferTo(MultipartFile file, String filePathReourceName)
			throws Exception {

		if (file == null)
			return null;

		Map<String, String> map = new HashMap<String, String>();


		String originalFilename = file.getOriginalFilename();
		String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));

		String filePath = String.format("%s/%s",
				ResourceBundleUtil.getResourceBundle(filePathReourceName),
				DateUtil.getSimpleDate("yyyyMM"));

		String newfileName = String.format("%s%s", DateUtil.getShortDateTimeStampString(),
				fileExtension);

		File dir = new File(filePath);

		// directory 없을경우
		if (!dir.exists()) {
			dir.mkdirs();
			// File parentDir = new
			// File(ResourceBundleUtil.getResourceBundle("file.cover.dir"));
			// if(!parentDir.exists()){
			// parentDir.mkdir();
			// }
			//
			// if(!dir.mkdir()){
			// throw new Exception("Failed Make Dir ==> "+dir.getName());
			// }
		} /* end of if */

		File uploadFile = new File(filePath + "/" + newfileName);

		file.transferTo(uploadFile);

		map.put(ORIGINAL_FILE_NAME, originalFilename);
		map.put(NEW_FILE_NAME, newfileName);
		map.put(FILE_PATH, filePath + "/");
		return map;
	}

	public static boolean checkFolder(String path) {
		return checkFolder(path, true);
	}

	/**
	 * 폴더가 없는 경우 폴더 유무를 체크하고 옵션에 따라 폴더를 자동 생성시켜준다.
	 * 
	 * @param path
	 * @param autoCreate
	 *            true:생성 false:폴더 생성하지 않음.
	 * @return
	 */
	public static boolean checkFolder(String path, boolean autoCreate) {
		File dir = new File(path);
		if (!dir.exists() && autoCreate) {
			dir.mkdirs();
			return false;
		} else if (!dir.exists()) {
			return false;
		}

		return true;
	}

	public static boolean isFile(String fileName) {
		return new File(fileName).isFile();
	}

	public static File searchMaxNameFile(String pdfFilePath, String pdfFileName) {

		File baseDir = new File(pdfFilePath);
		File[] fileList = baseDir.listFiles();

		if (fileList == null)
			return null;

		File maxNameFile = null;
		for (File f : fileList) {
			if (f.getName().startsWith(pdfFileName.substring(0, pdfFileName.lastIndexOf("_")))) {
				if (maxNameFile == null || compString(maxNameFile.getName(), f.getName()) == -1) {
					maxNameFile = f;
				}
			}
		}
		return maxNameFile;
	}
	
	public static File searchFile(String pdfFilePath, String pdfFileName) {
		File baseDir = new File(pdfFilePath);
		File[] fileList = baseDir.listFiles();
		
		if (fileList == null)
			return null;
		
		File file = null;
		for (File f : fileList) {
			if (compString(pdfFileName, f.getName()) == 0) {
				file = f;
				return file;
			}
		}
		return null;
	}

	/**
	 * 두개의 String을 char 단위로 비교 하여 baseStr이 크면 1을 작으면 -1을 같으면 0을 반환한다. 참고) A 는 B
	 * 보다 작다.
	 * 
	 * @param baseStr
	 * @param tgtStr
	 * @return
	 */
	public static int compString(String baseStr, String tgtStr) {

		for (int i = 0; i < baseStr.length(); i++) {
			if (baseStr.charAt(i) < tgtStr.charAt(i)) {
				return -1;
			} else if (baseStr.charAt(i) > tgtStr.charAt(i)) {
				return 1;
			}
		}

		if (baseStr.length() > tgtStr.length()) {
			return -1;
		} else if (baseStr.length() < tgtStr.length()) {
			return 1;
		}

		return 0;

	}

	public static String readerInputStreamToString(InputStream is) throws IOException {
		if (is == null)
			return null;

		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = is.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		return out.toString();
	}

	public static String readerInputStreamReaderToString(InputStreamReader fis) {
		if (fis == null)
			return null;

		char[] buffer = new char[4096];
		Writer writer = new StringWriter();

		try {
			Reader reader = new BufferedReader(fis);

			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			} /* end of while */
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // 스트림 닫기
		}

		return writer.toString();
	}
	
	/**
	 * 파일내용을 String 타입으로 변환한다.
	 * 
	 * (주의) fileSize 의 Data Type이 int이므로 ch 배열의 한계가 있으므로 주의
	 * 
	 * @param file
	 * @return
	 */
	public static String readerFileToString(File file) {

		int fileSize = (int) file.length();
		char[] ch = new char[fileSize];

		InputStreamReader fis = null;
		try {
			fis = new InputStreamReader(new FileInputStream(file), "UTF-8");

			int pos = 0;
			int size = 10;
			int temp = 0;

			while ((size = fis.read(ch, pos, size)) > 0) { // read() 메서드를 통하여 읽기
				pos += size;
				temp = ch.length - pos;
				if (temp < 10) {
					size = temp;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return String.valueOf(ch);
	}

	/**
	 * PDF 스트림을 ServletResponse에 Write한다.
	 * 
	 * @param response
	 * @param outputStream
	 * @throws IOException
	 */
	public static void runJspWriter(ServletResponse response, OutputStream outputStream)
			throws IOException {
		response.setContentType("application/pdf");
		OutputStream os = response.getOutputStream();
		((ByteArrayOutputStream) outputStream).writeTo(os);
	}

	/**
	 * FDF 스트림을 HttpServletResponse에 Write한다.
	 * 
	 * @param response
	 * @param outputStream
	 * @throws IOException
	 */
	public static void runFileWriter(HttpServletResponse response, OutputStream outputStream)
			throws IOException {
		response.setContentType("application/vnd.adobe.fdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"subscribe.fdf\"");
		OutputStream os = response.getOutputStream();
		((ByteArrayOutputStream) outputStream).writeTo(os);
	}

	public static void createFile(OutputStream outputStream, String filePath) {
		File file = new File(filePath);

		BufferedOutputStream fileOutput = null;

		try {
			fileOutput = new BufferedOutputStream(new FileOutputStream(file), 1024);

			if (outputStream instanceof ByteArrayOutputStream) {
				((ByteArrayOutputStream) outputStream).writeTo(fileOutput);
			} else {
				throw new RuntimeException("지원하지 않는 OutputStream 객체 입니다. : "
						+ outputStream.getClass().getName());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutput != null) {
				try {
					fileOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		return file.delete();
	}

	public static String fileBase64Encoder(String filePath) throws IOException {
		return fileBase64Encoder(new File(filePath));
	}

	public static String fileBase64Encoder(File file) throws IOException {

		BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(file));
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		BASE64Encoder encode = new BASE64Encoder();
		encode.encodeBuffer(inStream, outStream);

		return outStream.toString();
	}
	
	public static String fileBase64Encoder(MultipartFile file) throws IOException {

		BufferedInputStream inStream = new BufferedInputStream(file.getInputStream());
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		BASE64Encoder encode = new BASE64Encoder();
		encode.encodeBuffer(inStream, outStream);

		return outStream.toString();
	}

	public static void createFileBase64Decoder(String text, String filePath) {
		createFileBase64Decoder(text, new File(filePath));
	}

	public static void createFileBase64Decoder(String text, File file) {

		BASE64Decoder decoder = new BASE64Decoder();

		BufferedOutputStream fileOutput = null;

		try {
			byte[] decodeChs = decoder.decodeBuffer(text);

			fileOutput = new BufferedOutputStream(new FileOutputStream(file), 1024);

			fileOutput.write(decodeChs, 0, decodeChs.length);
			fileOutput.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutput != null) {
				try {
					fileOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.gc();
		}
	}

	public static void createFile(String text, File file) {

		BufferedOutputStream fileOutput = null;

		try {
			byte[] decodeChs = text.getBytes("UTF-8");

			fileOutput = new BufferedOutputStream(new FileOutputStream(file), 1024);

			fileOutput.write(decodeChs, 0, decodeChs.length);
			fileOutput.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutput != null) {
				try {
					fileOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// System.gc();
		}

		System.out.println("file >> " + file.getPath() + file.getName() + "....ok");
	}

	public static String getFileNameToExp(String fileName) throws Exception {
		if (fileName == null || fileName.indexOf(".") < 0)
			throw new Exception("file확장자가 없습니다.");

		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos + 1);
	}

	public static byte[] getBytesFromFile(File file) throws IOException {
		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.
		if (length > Integer.MAX_VALUE) {
			// File is too large
			throw new IOException("File is too large!");
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;

		InputStream is = new FileInputStream(file);
		try {
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
		} finally {
			is.close();
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}
		return bytes;
	}

	public static void main(String[] args) throws IOException {
		// String text = fileBase64Encoder(new File("D:/hkmc/img/in.jpg"));
		// createFileBase64Decoder(text, "D:/hkmc/img/t2.jpg");

		File f = new File("d:/aaa.txt");

		String s = readerFileToString(f);

		createFileBase64Decoder(s, new File("d:/aaa.pdf"));

	}
	
	/**
	 * Directory maker
	 * @param createPath
	 */
	public static boolean makeDir(String createPath) {
		Path path = Paths.get(createPath);
		boolean tf = false;
		if(!Files.exists(path)) {
		    try {
		      Files.createDirectories(path);
		      Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("rwxrwxrwx"));
		      tf = true;
		    }catch (IOException e) {
		      e.printStackTrace();
		    }
		}else tf = true;
		return tf;
	}

}

