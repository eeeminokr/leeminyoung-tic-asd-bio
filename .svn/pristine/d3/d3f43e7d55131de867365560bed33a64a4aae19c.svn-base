<%@page import="medical.framework.util.Constant"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@page import="java.io.*, java.util.*, medical.framework.util.ResourceBundleUtil"%>
<%
	// context path 포함.
	// # 2012.02.02 - yhshin : 업체 upload 파일은 그대로 /upload 하위로 함. (아래코드로 하면 /{vendor_code}/upload 로 됨
	// # 2012.05.14 - yhshin : filePath = ResourceBundleUtil.getResourceBundle(dirKey, ResourceBundleUtil.RBU_UPLOAD); 로 다시 수정함.
	//                         업체코드로 분기하는 로직은 view 단에서 수행하지 않음 필요한 경우 
	//                         getResourceBundle(String loginCompanyCode, String key, int flag) 를 사용함
	//
	String dirKey = request.getParameter("dir");
	String filePath = ResourceBundleUtil.getResourceBundle(dirKey, ResourceBundleUtil.RBU_UPLOAD);
	
	Object pObj2 = request.getParameter("fileName");

	//System.out.println("KEY["+dirKey+"] FILEPATH["+filePath+"] FILENAME["+pObj2+"]");
	//System.out.println("loginCompanyCode ============== " + loginCompanyCode);

	String fileName = "";
	if(pObj2 instanceof String) fileName = (String)pObj2;

	File file = new File(filePath + fileName);
	
	String encodedFileName = new String(fileName.getBytes("euc-kr"),"8859_1");
	
	response.reset();
	response.setContentType("application/octer-stream");
	response.setHeader("Content-Transper-Encoding", "binary");
	response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName + "");
	response.setContentLength((int)file.length());
	response.setHeader("Pargma", "no-cache");
	response.setHeader("Expires", "-1");
	
	out.clear();
	out = pageContext.pushBody();
	
	// 파일 보내기 시작
	if (file.isFile()) {
	
		BufferedInputStream fin = null;
		BufferedOutputStream fos = null;
		try {
			fin = new BufferedInputStream(new FileInputStream(file));
			fos = new BufferedOutputStream( response.getOutputStream() );
			int read = 0;
			byte b[] = new byte[2048];
			while ((read = fin.read(b)) != -1) {
				fos.write(b, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					
				}
			}
			
		}
	}
	
%>