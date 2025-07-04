package medical.imagingInfo.web;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import medical.common.progress.ProgressDetails;
import medical.common.service.CommonService;
import medical.commoninfo.code.service.CodeService;
import medical.dataIntegration.service.DataIntegrationListVO;
import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;
import medical.framework.file.ExcelFile;
import medical.framework.util.JsonUtils;
import medical.imagingInfo.service.ImageInfoVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.imagingInfo.service.UploadExcelVO;
import medical.target.service.TargetVO;


@Controller
public class ImagingInfoController {
	@Resource(name = "CommonService")
	private CommonService oCommonService;
	@Resource(name = "CodeService")
	private CodeService oCodeService;
	@Resource(name = "ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	//영상메뉴 전체 리스트
	@RequestMapping("/medical/imagingInfo/selectImageList.do")
	public ModelAndView selectImagingList(HttpSession session, @ModelAttribute("ImageInfoVO")ImageInfoVO imageInfoVO
			, ModelMap model)throws Exception {
		
		List<ImageInfoVO> resultList = oImagingInfoService.selectImageList(imageInfoVO);
		int totalCount = oImagingInfoService.selectImageListTotal(imageInfoVO);
		 
		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	
	//영상 삭제
	@RequestMapping("/medical/imagingInfo/deleteImaging.do")
	public ModelAndView deleteImaging(@ModelAttribute("ImageInfoVO")ImageInfoVO imageInfoVO, ModelMap model
			, HttpServletRequest request, HttpSession session)throws Exception {
		
		String[] targetIdList = request.getParameterValues("targetIdList");
		String[] performCntList = request.getParameterValues("performCntList");
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		String rndId = request.getParameter("loginRndId");
		
		
		for(int i =0; i<targetIdList.length; i++) {
			imageInfoVO.setTargetId(targetIdList[i]);
			imageInfoVO.setPerformCntNm(performCntList[i]);
			imageInfoVO.setDisClassDtl(disClassDtl);
			imageInfoVO.setRndId(rndId);
			oImagingInfoService.deleteImagingInfoByPerformCnt(imageInfoVO);
			oImagingInfoService.updateBlankMriDate(imageInfoVO);
			oImagingInfoService.deleteImagingInfo(imageInfoVO);
		}
		model.put("success", true);
		return JsonUtils.describe(model);
	}
	
	//화면 엑셀 다운로드
	@RequestMapping("/medical/imagingInfo/imagingExcelDownload.do") 
	public ModelAndView imagingExcelDownload(@ModelAttribute("ImageInfoVO")ImageInfoVO imageInfoVO)
	throws Exception {
		String disClassDtl = imageInfoVO.getDisClassDtl();
		ExcelFile excelFile = null;
		
		if("DS001".equals(disClassDtl))excelFile = oImagingInfoService.imagingExcelDownload(imageInfoVO);
		else excelFile = oImagingInfoService.imagingExcelDownload2(imageInfoVO);
		return new ModelAndView("download", "download", excelFile);
	}
	//선택 엑셀 다운로드
	@RequestMapping("/medical/imagingInfo/imagingSelectExcelDownload.do")
	public ModelAndView ImagingSelectExcelDownload(HttpServletRequest request, @ModelAttribute("ImageInfoVO")ImageInfoVO imageInfoVO) 
	throws Exception {

		String[] targetIdList = request.getParameterValues("targetId");
		String[] performCntList = request.getParameterValues("performCnt");
		String rndId = imageInfoVO.getRndId();
		String disClassDtl = imageInfoVO.getDisClassDtl();
		
		String schKeyWord = "";
		ImageInfoVO vo =  new ImageInfoVO();
		for(int i=0; i < targetIdList.length; i++) {
			schKeyWord += "('"+targetIdList[i]+"','"+disClassDtl+"','"+performCntList[i]+"','"+rndId+"')";
			if((i+1)!=targetIdList.length) schKeyWord += ",";
			
		}
		vo.setSchKeyField("selectDown");
		vo.setSchKeyWord(schKeyWord);
		
		
		ExcelFile excelFile = oImagingInfoService.imagingExcelDownload(vo);
		
		return new ModelAndView("download", "download", excelFile);
	}
	
	//업로드 엑셀 다운로드
	@RequestMapping("/medical/imagingInfo/imagingUploadExcelDownload.do")
	public ModelAndView imagingUploadExcelDownload(@ModelAttribute("UploadExcelVO")UploadExcelVO uploadExcelVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	 List<UploadExcelVO> uploadDownd = oImagingInfoService.selectUploadExcelInfo(uploadExcelVO);
	 String uploadDownload = uploadDownd.get(0).getFilePath();
	 uploadDownload = uploadDownload.replace("c:", "").toString();
	 
	 File file2 = new File("",uploadDownload);
	 BufferedInputStream in = new BufferedInputStream(new FileInputStream(file2));
	 String fileName = file2.getName();
	 if(uploadDownd != null) {
		 	//형식을 모르는 파일첨부용 contentType
		    response.setContentType("application/octet-stream");
		    //다운로드와 다운로드될 파일이름
		    response.setHeader("Content-Disposition", "attachment; filename=\""+ java.net.URLEncoder.encode(fileName, "utf-8") + "\"");
		    //파일복사
		    FileCopyUtils.copy(in, response.getOutputStream());
		    in.close();
		    response.getOutputStream().flush();
		    response.getOutputStream().close();
		 
	 }else {
		 throw new Exception("업로드 파일이 없습니다. 관리자에게 문의하세요.");
	 }
		return new ModelAndView("download", "download", uploadDownload);
	 }
	@RequestMapping("/medical/imagingInfo/imagingFileUpload.do")
	public ModelAndView imagingFileUpload(@RequestParam("dataFile") MultipartFile[] dataFile,
			@RequestParam("excelUploadFile") MultipartFile excelUploadFile,
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("DataIntegrationListVO") DataIntegrationListVO oDataIntegrationListVO,
			@ModelAttribute("DataIntegrationAsdListVO") DataIntegrationAsdListVO dataIntegrationAsdListVO
			) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		boolean uzTf =false;
		boolean euTf =false;
		List<String> oList = new ArrayList<String>();
		// create an object of ProgressDetails and set the total items to be processed
		ProgressDetails taskProgress = new ProgressDetails();
		// read the tadkId;
		String taskId = request.getParameter("taskIdentity");
		String disClassDtl1 = oDataIntegrationListVO.getDisClassDtl();
		String disClassDtl2 = dataIntegrationAsdListVO.getDisClassDtl();
		List<MultipartFile> file = new ArrayList<MultipartFile>();
		try {
			if (dataFile[0].getSize() > 0) {
				String fileName = "";
				String fileExtension = "";
				for(int i=0; i<dataFile.length; i++) {
					fileName = dataFile[i].getOriginalFilename();
					fileExtension = FilenameUtils.getExtension(fileName).toUpperCase();
					if("ZIP".equals(fileExtension)||"GZ".equals(fileExtension)||"TAR".equals(fileExtension)){
						file.add(dataFile[i]);
					}
				}
				if(file.size() == 0) {
					throw new Exception("<strong>조건에 맞는 파일이 없습니다.</strong>"
							+ "<br>"
							+ "ex) 파일명 : 연구번호_차수_파일구분명"
							+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							+ "확장자 : zip, gz, tar");
				}else if("DS001".equals(disClassDtl1)){
					
					ImageInfoVO oImageInfoVO = new ImageInfoVO();
					oImageInfoVO.defaultValue(session);
					oImageInfoVO.setRndId(oDataIntegrationListVO.getRndId());
					oImageInfoVO.setDisClassDtl(oDataIntegrationListVO.getDisClassDtl());
					oImageInfoVO.setTaskIdentity(taskId);
					uzTf = oImagingInfoService.dataUpload(file, oImageInfoVO, taskProgress);
					oList.add("uzTf");
				}else {
					ImageInfoVO oImageInfoVO = new ImageInfoVO();
					oImageInfoVO.defaultValue(session);
					oImageInfoVO.setRndId(dataIntegrationAsdListVO.getRndId());
					oImageInfoVO.setDisClassDtl(dataIntegrationAsdListVO.getDisClassDtl());
					oImageInfoVO.setTaskIdentity(taskId);
					uzTf = oImagingInfoService.dataUpload(file, oImageInfoVO, taskProgress);
					oList.add("uzTf");
				}
				
			}
			if (excelUploadFile != null && excelUploadFile.getSize() > 0) {
				oDataIntegrationListVO.defaultValue(session);
				euTf = oImagingInfoService.imagingExcelFileUpload(excelUploadFile, oDataIntegrationListVO,dataIntegrationAsdListVO,taskProgress);
				oList.add("euTf");
			}
			if(oList.size() > 0) {
				if(oList.size()==1) {
					if(oList.contains("uzTf") && uzTf)modelMap.put("success", true);
					else if(oList.contains("euTf") && euTf)modelMap.put("success", true);
					else modelMap.put("success", false);
				}else {
					if(uzTf && euTf)modelMap.put("success", true);
					else modelMap.put("success", false);
				}
			}else modelMap.put("success", false);
		}catch(Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
			e.printStackTrace();
		}finally {
			taskProgress.reset();
		}
		return new ModelAndView("jsonView", modelMap);
	}
	
/*	
	@RequestMapping("/medical/imagingInfo/imagingAsdFileUpload.do")
	public ModelAndView imagingAsdFileUpload(@RequestParam("dataFile") MultipartFile[] dataFile,
			@RequestParam("excelUploadFile") MultipartFile excelUploadFile,
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("DataIntegrationAsdListVO") DataIntegrationAsdListVO dataIntegrationAsdListVO) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		boolean uzTf =false;
		boolean euTf =false;
		List<String> oList = new ArrayList<String>();
		// create an object of ProgressDetails and set the total items to be processed
		ProgressDetails taskProgress = new ProgressDetails();
		// read the tadkId;
		String taskId = request.getParameter("taskIdentity");
		List<MultipartFile> file = new ArrayList<MultipartFile>();
		try {
			if (dataFile[0].getSize() > 0) {
				String fileName = "";
				String fileExtension = "";
				for(int i=0; i<dataFile.length; i++) {
					fileName = dataFile[i].getOriginalFilename();
					fileExtension = FilenameUtils.getExtension(fileName).toUpperCase();
					if("ZIP".equals(fileExtension)||"GZ".equals(fileExtension)||"TAR".equals(fileExtension)){
						file.add(dataFile[i]);
					}
				}
				if(file.size() == 0) {
					throw new Exception("<strong>조건에 맞는 파일이 없습니다.</strong>"
							+ "<br>"
							+ "ex) 파일명 : 연구번호_차수_파일구분명"
							+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							+ "확장자 : zip, gz, tar");
				}else {
					ImageInfoVO oImageInfoVO = new ImageInfoVO();
					oImageInfoVO.defaultValue(session);
					oImageInfoVO.setRndId(dataIntegrationAsdListVO.getRndId());
					oImageInfoVO.setDisClassDtl(dataIntegrationAsdListVO.getDisClassDtl());
					oImageInfoVO.setTaskIdentity(taskId);
					uzTf = oImagingInfoService.dataUpload(file, oImageInfoVO, taskProgress);
					oList.add("uzTf");
				}
			}
			if (excelUploadFile != null && excelUploadFile.getSize() > 0) {
				dataIntegrationAsdListVO.defaultValue(session);
				euTf = oImagingInfoService.imagingAsdExcelFileUpload(excelUploadFile, dataIntegrationAsdListVO,taskProgress);
				oList.add("euTf");
			}
			if(oList.size() > 0) {
				if(oList.size()==1) {
					if(oList.contains("uzTf") && uzTf)modelMap.put("success", true);
					else if(oList.contains("euTf") && euTf)modelMap.put("success", true);
					else modelMap.put("success", false);
				}else {
					if(uzTf && euTf)modelMap.put("success", true);
					else modelMap.put("success", false);
				}
			}else modelMap.put("success", false);
		}catch(Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
			e.printStackTrace();
		}finally {
			taskProgress.reset();
		}
		return new ModelAndView("jsonView", modelMap);
	}
	
	*/
	
	@RequestMapping("/medical/imagingInfo/selectImagingPage.do")
	public ModelAndView selectImagingPage(HttpSession session,@ModelAttribute("ImageInfoVO")ImageInfoVO imageInfoVO
			, ModelMap model) throws Exception {
		
		String schKeyWord = imageInfoVO.getSchKeyWord();
		
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = imageInfoVO.getLimit();
			int pageNum,rNum;

			//TargetID 조회
			List<ImageInfoVO> resultList = oImagingInfoService.selectImageList(imageInfoVO);
			rownum = resultList.get(0).getRownum();
			
			//페이지 수 계산
			pageNum = rownum/pageSize;
			if(rownum%pageSize != 0) pageNum += 1;
			rNum = rownum%pageSize;
			model.put("pageNum", pageNum);
			model.put("rNum", rNum);
			
		}

		model.put("success", true);
		return new ModelAndView("jsonView", model);
	}
}
