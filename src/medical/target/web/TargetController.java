package medical.target.web;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import medical.common.service.CommonService;
import medical.common.service.PerformTermVO;
import medical.framework.file.ExcelFile;
import medical.framework.util.DateUtil;
import medical.framework.util.FileUtils;
import medical.framework.util.JsonUtils;
import medical.framework.util.ResourceBundleUtil;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.imagingInfo.service.UploadExcelVO;
import medical.target.service.TargetListVO;
import medical.target.service.TargetService;
import medical.target.service.TargetVO;

@Controller
public class TargetController {
	/** Sevice Class */
	@Resource(name = "TargetService")
	private TargetService targetService;
	@Resource(name = "ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/medical/target/updateTargetRemarks.do")
	public ModelAndView updateTargetRemarks(HttpSession session, @ModelAttribute("TargetVO")TargetVO targetVO,
			ModelMap model, HttpServletRequest request) throws Exception {
		String[] targetIdList = request.getParameterValues("targetIdList");
		String[] performCntList = request.getParameterValues("performCntList");
		String[] targetRemarks = request.getParameterValues("targetRemarksList");
		for(int i=0; i<targetIdList.length; i++) {
			targetVO.setTargetId(targetIdList[i]);
			targetVO.setPerformCnt(performCntList[i]);
			targetVO.setTargetRemarks(targetRemarks[i]);
			targetService.updateTargetRemarks(targetVO);
		}
		
		model.put("success", true);
		
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/target/updateNextVisitDate.do")
	public ModelAndView updateNextVisitDate(HttpSession session, @ModelAttribute("TargetVO")TargetVO targetVO,
			ModelMap model, HttpServletRequest request) throws Exception {
		String[] targetIdList = request.getParameterValues("targetIdList");
		String[] performCntList = request.getParameterValues("performCntList");
		String[] nextVisitDateList = request.getParameterValues("nextVisitDateList");
		
		for(int i=0; i<targetIdList.length; i++) {
			targetVO.setTargetId(targetIdList[i]);
			targetVO.setPerformCnt(performCntList[i]);
			targetVO.setNextVisitDate(nextVisitDateList[i]);
			targetService.updateNextVisitDate(targetVO);
		}
		model.put("success", true);
		
		return new ModelAndView("jsonView", model);
	}
	
	
	@RequestMapping("/medical/target/updateTargetList.do")
	public ModelAndView updateTargetList(HttpSession session, @ModelAttribute("TargetVO")TargetVO targetVO
			,ModelMap model, HttpServletRequest request) throws Exception {
		
		String[] targetIdList = request.getParameterValues("targetIdList");
		String[] performCntList = request.getParameterValues("performCntList");
		String[] statusList = request.getParameterValues("statusList");
		
		for(int i=0; i<targetIdList.length; i++) {
			targetVO.setTargetId(targetIdList[i]);
			targetVO.setPerformCnt(performCntList[i]);
			targetVO.setStatus(statusList[i]);
			targetService.updateTargetList(targetVO);
		}
		
		model.put("success", true);
		
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/target/selectTargetList.do")
	public ModelAndView selectTargetList(HttpSession session, @ModelAttribute("TargetVO")TargetVO targetVO
			, ModelMap model) throws Exception {
		
		//대상자정보에 없는 차수 삭제 (V4까지는 고정)
		List<TargetVO> maxCnt = targetService.selectTargetCntMax(targetVO);
		if(maxCnt.get(0).getPerformCnt() != null){
		int targetCntMax = Integer.parseInt(maxCnt.get(0).getPerformCnt()); //대상자차수
		int termCntMax = Integer.parseInt(maxCnt.get(0).getTermCntMax()); //term 차수
		
			if(targetCntMax < termCntMax) {
				PerformTermVO tvo = new PerformTermVO();
				tvo.setPerformCnt(termCntMax);
				tvo.setPerformCntSec(targetCntMax);
				targetService.deletePerformTerm(tvo, session);
			}
		}
		
		List<TargetVO> resultList = targetService.selectTargetList(targetVO);
		int totalCount = targetService.selectTargetListTotal(targetVO);
		
		
		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	

	@RequestMapping("/medical/target/targetExcelDownload.do")
	public ModelAndView targetExcelDownload(@ModelAttribute("TargetVO")TargetVO targetVO)
			throws Exception {
		String disClassDtl = targetVO.getDisClassDtl();
		ExcelFile excelFile = null;
		
		if("DS001".equals(disClassDtl))excelFile = targetService.targetExcelDownload(targetVO);
		else excelFile = targetService.targetExcelDownload2(targetVO); //연구번호 분리
		
		return new ModelAndView("download", "download", excelFile);
	}

	//업로드 엑셀 다운로드
	@RequestMapping("/medical/target/targetUploadExcelDownload.do")
	public ModelAndView targetUploadExcelDownload(@ModelAttribute("UploadExcelVO")UploadExcelVO uploadExcelVO, HttpServletRequest request, HttpServletResponse response)
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
	
	@RequestMapping("/medical/target/targetExcelUpload.do")
	public ModelAndView targetExcelUpload(@RequestParam("excelUploadFile") MultipartFile file,HttpSession session,  HttpServletRequest request
			, DocFileVO oDocFileVO) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();
				String fileExtension = fileName.substring(fileName.lastIndexOf("."));
				String fileNameWOExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
				String docDir = ResourceBundleUtil.getResourceBundle("DorDir");
				String uploadExcelPath = docDir + "Excel";
				if (!FileUtils.makeDir(uploadExcelPath)) {
					throw new Exception(uploadExcelPath + " 폴더 생성이 실패하였습니다. 관리자에게 문의하세요.");
				}

				File temp = new File(ResourceBundleUtil.getResourceBundle("tempDir") + fileNameWOExtenstion + "__"
						+ DateUtil.getShortDateTimeStampString() + fileExtension);

				file.transferTo(temp);

				targetService.targetExcelUpload(session, temp);
				
				//파일삭제
				if( temp.exists() ){
					if(temp.delete()){ System.out.println("파일삭제 성공"); }else{ System.out.println("파일삭제 실패"); }

				}

				
			}
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
			e.printStackTrace();
		}
		return new ModelAndView("jsonView", modelMap);
	}
	
	@RequestMapping("/medical/target/targetFileUpload.do")
	public ModelAndView neuropsyFileUpload(@RequestParam("uploadZipFile") MultipartFile uploadZipFile,
			@RequestParam("excelUploadFile") MultipartFile excelUploadFile,
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("DocFileVO") DocFileVO oDocFileVO) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		boolean uzTf =false;
		boolean euTf =false;
		List<String> oList = new ArrayList<String>();
		
		try {
			if (uploadZipFile != null && uploadZipFile.getSize() > 0) {
				uzTf = oImagingInfoService.targetPdfUpload(session, uploadZipFile, oDocFileVO);
				oList.add("uzTf");
			}
			if (excelUploadFile != null && excelUploadFile.getSize() > 0) {
				euTf = targetService.targetFileUpload(session, excelUploadFile, request, oDocFileVO);
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
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
			e.printStackTrace();
		}
		return new ModelAndView("jsonView", modelMap);
	}
	
	@RequestMapping("/medical/target/deleteTargetId.do")
	public ModelAndView deleteTargetId( @RequestBody TargetListVO targetListVO ,ModelMap model
					,HttpServletRequest request,HttpSession session)throws Exception {

		
		targetService.deleteTargetId(session, targetListVO);
		
		
		model.put("success",true);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/target/targetSelectExcelDownload.do")
	public ModelAndView targetExtargetSelectExcelDownloadcelDownload(HttpServletRequest request,@ModelAttribute("TargetVO")TargetVO targetVO)
			throws Exception {
		
		String[] targetIdList = request.getParameterValues("targetId");
		String[] performCntList = request.getParameterValues("performCnt");
		String rndId = targetVO.getRndId();
		String disClassDtl = targetVO.getDisClassDtl();
		
		String schKeyWord = "";
		TargetVO vo =  new TargetVO();
		
		for(int i=0; i < targetIdList.length; i++) {
			schKeyWord += "('"+targetIdList[i]+"','"+disClassDtl+"','"+performCntList[i]+"','"+rndId+"')";
			if((i+1)!=targetIdList.length) schKeyWord += ",";
			
		}
		vo.setSchKeyField("selectDown");
		vo.setSchKeyWord(schKeyWord);
		
		ExcelFile excelFile = targetService.targetExcelDownload(vo);
		
		return new ModelAndView("download", "download", excelFile);
	}
	
	@RequestMapping("/medical/target/selectTargetFollowUpList.do")
	public ModelAndView selectTargetFollowUpList(HttpSession session, @ModelAttribute("TargetVO")TargetVO targetVO
			, ModelMap model) throws Exception {
		
		List<TargetVO> resultList = targetService.selectTargetFollowUpList(targetVO);
		
		
		model.put("success", true);
		model.put("result", resultList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/target/selectTargetPage.do")
	public ModelAndView selectTargetPage(HttpSession session,@ModelAttribute("TargetVO")TargetVO targetVO
			, ModelMap model) throws Exception {
		
		String schKeyWord = targetVO.getSchKeyWord();
		
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = targetVO.getLimit();
			int pageNum,rNum;

			//TargetID 조회
			List<TargetVO> resultList = targetService.selectTargetList(targetVO);
			if(resultList.size()>0) rownum = resultList.get(0).getRownum();
			else rownum=0;
			
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
	
	//데이터 통합 정보 상세 비고란(T_TARGET_MST : REMARKS)
	@RequestMapping("/medical/target/updateRemarksDataDtl.do")
	public ModelAndView updateRemarksDataDtl(HttpSession session, @ModelAttribute("TargetVO")TargetVO targetVO,
			ModelMap model, HttpServletRequest request) throws Exception {
		
		String remarks = request.getParameter("remarks");
		String targetId = request.getParameter("targetId");
		String rndId = request.getParameter("rndId");	
		String disClassDtl = request.getParameter("disClassDtl");
		
		try {
		targetVO.setRemarks(remarks);
		targetVO.setTargetId(targetId);
		targetVO.setRndId(rndId);
		targetVO.setDisClassDtl(disClassDtl);
		
		targetService.updateRemarksDataDtl(targetVO);
		model.put("success", true);
		
		} catch (Exception e) {
			model.put("success", false);
			model.put("errMsg", e.getMessage());
			e.printStackTrace();
		}
		
//		return JsonUtils.describe(model);
		return new ModelAndView("jsonView", model);
	}
}
