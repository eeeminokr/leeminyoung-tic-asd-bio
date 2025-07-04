package medical.clinician.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import medical.clinician.service.ClinicianAsdCybocsVO;
import medical.clinician.service.ClinicianAsdSrs01VO;
import medical.clinician.service.ClinicianAsdYbocsVO;
import medical.clinician.service.ClinicianListVO;
import medical.clinician.service.ClinicianS1VO;
import medical.clinician.service.ClinicianService;
import medical.clinician.service.ClinicianTotalVO;
import medical.clinician.service.ClinicianVO;
import medical.common.service.CommonService;

import medical.framework.file.ExcelFile;
import medical.framework.util.StringUtil;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.neuropsy.service.NeuropsyAdos1VO;
import medical.neuropsy.service.NeuropsyAdos2VO;
import medical.neuropsy.service.NeuropsyAdos3VO;
import medical.neuropsy.service.NeuropsyAtaVO;
import medical.neuropsy.service.NeuropsyCarsVO;
import medical.neuropsy.service.NeuropsyCatVO;
import medical.neuropsy.service.NeuropsyCcttVO;
import medical.neuropsy.service.NeuropsyCptVO;
import medical.neuropsy.service.NeuropsyExitiiVO;
import medical.neuropsy.service.NeuropsyPepVO;
import medical.neuropsy.service.NeuropsyS1VO;
import medical.neuropsy.service.NeuropsyService;
import medical.neuropsy.service.NeuropsySmsVO;
import medical.neuropsy.service.NeuropsyStroopVO;
import medical.neuropsy.service.NeuropsyTmtVO;
import medical.neuropsy.service.NeuropsyTotalVO;
import medical.neuropsy.service.NeuropsyVO;
import medical.neuropsy.service.NeuropsyWsctVO;
import medical.surveyAsd.service.SurveyAsdListVO;
import medical.surveyAsd.service.SurveyAsdTotalVO;
import medical.surveyAsd.service.SurveyAsdVO;

@Controller
public class clinicianController {

	
	@Resource(name = "ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	/** Sevice Class */
	              
	@Resource(name = "ClinicianService")
	private ClinicianService clinicianService;
	
	@Resource(name = "CommonService")
	private CommonService commonService;

	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	
	@RequestMapping("/medical/clinician/selectClinicianMenuList.do")
	public ModelAndView selectNeuropsyTabList(HttpSession session, @ModelAttribute("ClinicianVO")ClinicianVO clinicianVO
	, ModelMap model) throws Exception {
		
		List<ClinicianVO> tabList = clinicianService.selectClinicianMenuList(clinicianVO);
		model.put("success", true);
		model.put("result", tabList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/clinician/selectDocNmByDocId.do")
	public ModelAndView selectDocIdByDocNm(HttpSession session, @ModelAttribute("ClinicianVO")ClinicianVO clinicianVO
			, ModelMap model) throws Exception {
		String docNm = clinicianService.selectDocNmByDocId(clinicianVO);
		model.put("success", true);
		model.put("docNm", docNm);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/clinician/selectPerformCntList.do")
	public ModelAndView selectPerformCntList(HttpSession session, @ModelAttribute("ClinicianVO")ClinicianVO clinicianVO
			, ModelMap model) throws Exception {
		List<ClinicianVO> resultList = clinicianService.selectPerformCntList(clinicianVO);
		model.put("success", true);
		model.put("result", resultList);
		return new ModelAndView("jsonView", model);
	}
	
	
	
	
	@RequestMapping("/medical/clinician/selectClinicianPage.do")
	public ModelAndView selectClinicianPage(HttpSession session, @ModelAttribute("ClinicianVO")ClinicianVO clinicianVO
			, ModelMap model) throws Exception {
		System.out.println("!!!!!!!!!상세페이지 넘어오는컨트롤러!!!");
		String docId = clinicianVO.getDocId().toUpperCase();
		System.out.println(docId+":::srs01아이디값:::::::::넘어왔음");
		String docNm = clinicianVO.getDocNm();
		String schKeyWord = clinicianVO.getSchKeyWord();
		int totalCount = 0;
		String disClassDtl = (String)session.getAttribute("disClassDtl");
	
		
		System.out.println(docId+"임상가평가 docId");
		System.out.println(docNm+"임상가평가 docNm");
		
		//System.out.println(docNm2+"임상가평가 docNm2"

		
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = clinicianVO.getLimit();
			int pageNum,rNum;
			//해당 탭의 TargetID 위치로 이동

			//TargetID 조회
										
			if("S1001".equals(docId)) {
				System.out.println("!!!!!!!!!!!!!!!!!페이지쪽매퍼옴");
				List<ClinicianS1VO> s1List = clinicianService.selectClinicianS1RowList(clinicianVO);
				rownum = s1List.get(0).getRownum();		
			
			}else if("SRS01".equals(docId)) {
				List<ClinicianAsdSrs01VO> srs01List = clinicianService.selectClinicianSrs01List(clinicianVO);			
				rownum = srs01List.get(0).getRownum();			
			}else if("CYBO1".equals(docId)) {
				List<ClinicianAsdCybocsVO> cyb01List = clinicianService.selectClinicianCybocsList(clinicianVO);
				rownum = cyb01List.get(0).getRownum();
			}else if("YBOCS".equals(docId)) {
				List<ClinicianAsdYbocsVO> ybocsList = clinicianService.selectClinicianYbocsList(clinicianVO);
				rownum = ybocsList.get(0).getRownum();
			}
			
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
	
	@RequestMapping("/medical/clinician/selectClinicianList.do")
	public ModelAndView selectClinicianList(HttpSession session, @ModelAttribute("ClinicianVO")ClinicianVO clinicianVO
			,@ModelAttribute("ClinicianTotalVO")ClinicianTotalVO clinicianTotalVO, ModelMap model) throws Exception {
		
		System.out.println("데이터 통합분석에서 Clinician list.do에 들어옴");
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		System.out.println("disClassDtls=====>:"+disClassDtl);
		String docId = clinicianVO.getDocId();
		String docNm = clinicianVO.getDocNm();
		List resultList = new ArrayList();
		int totalCount = 0;
		clinicianVO.setDisClassDtl(disClassDtl);
		clinicianTotalVO.setDisClassDtl(disClassDtl);
		
		
		System.out.println(docId+"임상가평가docId값 !!!");
		System.out.println(docNm+"임상가평가docNm name값!!!");
		System.out.println(disClassDtl+"임상가평가disClassDtl값!!!!");
		System.out.println(clinicianVO.getTargetId()+"임상가평가targetid값!!!");
		
		
		
		
		//리스트 조회
		// K-SADS-PL, SRS, CY-BOCS, Y-BOCS total 
		if("Total".equals(docId)) {
			totalCount = clinicianService.selectClinicianTotalListTotal(clinicianTotalVO); 
			resultList = clinicianService.selectClinicianTotalList(clinicianTotalVO); 
		}else if("S1001".equals(docId)) {
			totalCount = clinicianService.selectClinicianS1AsdListTotal(clinicianVO); 
			System.out.println(totalCount +"s1001 totalcount");
		//	resultList = clinicianService.selectClinicianS1AsdList(clinicianVO);
			List<ClinicianS1VO>  s1List = clinicianService.selectClinicianS1AsdList(clinicianVO);

				
			resultList = s1List;
			System.out.println(resultList+"S1LIST");
		}else if("SRS01".equals(docId)) { //SRS(약)
			totalCount = clinicianService.selectClinicianDtlListTotal(clinicianVO);
			resultList = clinicianService.selectClinicianSrs01List(clinicianVO);
		}else if("CYBO1".equals(docId)) {
			totalCount = clinicianService.selectClinicianDtlListTotal(clinicianVO);
			resultList = clinicianService.selectClinicianCybocsList(clinicianVO);
		}else if("YBOCS".equals(docId)) {
	
			totalCount = clinicianService.selectClinicianDtlListTotal(clinicianVO); 
			resultList = clinicianService.selectClinicianYbocsList(clinicianVO);
		}

		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	
	
	@RequestMapping("/medical/clinician/clinicianAsdExcelUpload.do")
	public ModelAndView clinicianExcelUpload(@RequestParam("uploadZipFile") MultipartFile uploadZipFile,
			@RequestParam("excelUploadFile") MultipartFile excelUploadFile,
			HttpSession session,
			HttpServletRequest request,
			@ModelAttribute("DocFileVO") DocFileVO oDocFileVO) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		boolean uzTf =false;
		boolean euTf =false;
		List<String> oList = new ArrayList<String>();
		try {
			String taskId = request.getParameter("taskId");
			if (uploadZipFile != null && uploadZipFile.getSize() > 0) {
				uzTf = oImagingInfoService.targetPdfUpload(session, uploadZipFile, oDocFileVO);
				oList.add("uzTf");
			}
			if (excelUploadFile != null && excelUploadFile.getSize() > 0) {
				euTf = clinicianService.clinicianFileUpload(session, excelUploadFile, request, oDocFileVO, taskId);
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
	
	
	
	
	
	
	
	
	//임상가평가 엑셀다운로드
	@RequestMapping("/medical/clinician/clinicianExcelDownload.do")
	public ModelAndView clinicianExcelList(@ModelAttribute("ClinicianVO")ClinicianVO clinicianVO,
			@ModelAttribute("ClinicianTotalVO")ClinicianTotalVO clinicianTotalVO) throws Exception {
	
		System.out.println("clinician2번 listmpapping");
		
		
		ExcelFile excelFile = null;
		String docNm = clinicianVO.getDocNm();
		System.out.println(docNm+"docNM");
		
		String docId = clinicianVO.getDocId();
		System.out.println(docId+"docID");
		String disClassDtl = clinicianVO.getDisClassDtl();
		System.out.println(disClassDtl+"DISCLASSDTL");
		  String targetIds = clinicianVO.getTargetIds();
		  System.out.println(targetIds+"TARGETID");
		  String performCnts = clinicianVO.getPerformCnts();
		  System.out.println(performCnts+"PERFORMCNTS");
		  String[] targetIdList = null;
		  String[] performCntList = null;
		  String[] targetIdList2 = null;
		  String[] performCntList2 = null;
		  List<ClinicianVO> clinicianVOList = new ArrayList<ClinicianVO>();
		  List<ClinicianTotalVO> clinicianTotalVOList = new ArrayList<ClinicianTotalVO>();
		  ClinicianVO oClinicianVO = null;
		  ClinicianTotalVO tClinicianVO;
		   
          for(int i=0; i<clinicianTotalVOList.size(); i++ ) {

		         System.out.println(clinicianTotalVOList.get(i)+"totalindex["+i+"]");
		                }
		  
		  
		  
		  if(targetIds != null && performCnts !=null) {
		      targetIdList = targetIds.split("\\|");
		  performCntList = performCnts.split("\\|");
		  
		      targetIdList2 = targetIds.split("\\|");
		  performCntList2 = performCnts.split("\\|");
		      
		      for(int i = 0 ; i < targetIdList.length ; i++) {
		    	  oClinicianVO   = new ClinicianVO();
		    	  oClinicianVO.setTargetId(targetIdList[i]);
		    	  oClinicianVO .setPerformCnt(performCntList[i]);
		    	  oClinicianVO .setDisClassDtl(disClassDtl);
		    	  oClinicianVO .setLimit(60000);
		          clinicianVOList.add(oClinicianVO);
		      }
		      for(int i = 0 ; i < targetIdList2.length ; i++) {
		    	  tClinicianVO  = new ClinicianTotalVO();
		    	  tClinicianVO.setTargetId(targetIdList2[i]);
		    	  tClinicianVO.setPerformCnt(performCntList2[i]);
		    	  tClinicianVO.setDisClassDtl(disClassDtl);
		    	  tClinicianVO.setLimit(60000);
		          clinicianTotalVOList.add(tClinicianVO);
		      }
		  }
		  
		  if("Total".equals(docId)){
				 clinicianTotalVO.setStart(0);
				 clinicianTotalVO.setLimit(60000);
				 excelFile = clinicianService.clinicianTotalExcelList(clinicianTotalVO, clinicianTotalVOList);
				 System.out.println(excelFile+"excelfile");
				 
				 
				  
				
				 
				 
				 
		    }else if("S1001".equals(docId)) {
		    	 	clinicianVO.setStart(0);
		    	 	clinicianVO.setLimit(60000);
		    	 	excelFile = clinicianService.clinicianAsdS1ExcelList(clinicianVO, clinicianVOList);          
		  
		     }else if("SRS01".equals(docId)) {
					 clinicianVO.setStart(0);
					 clinicianVO.setLimit(60000);
					 excelFile = clinicianService.clinicianAsdSrs01ExcelList(clinicianVO, clinicianVOList);
			  }else if("CYBO1".equals(docId)) {
				  	 clinicianVO.setStart(0);
				  	 clinicianVO.setLimit(60000);
					 excelFile = clinicianService.clinicianAsdCybocsExcelList(clinicianVO, clinicianVOList);
			  }else if("YBOCS".equals(docId)) {
					 clinicianVO.setStart(0);
					 clinicianVO.setLimit(60000);
					 excelFile = clinicianService.clinicianAsdYbocsExcelList(clinicianVO, clinicianVOList);
			  }
		
		return new ModelAndView("download", "download", excelFile);
	}

	@RequestMapping("/medical/clinician/deleteClinicianAnswer.do")
	public ModelAndView deleteClinicianAsdAnswer(HttpSession session, @RequestBody ClinicianListVO clinicianList) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		System.out.println("삭제매핑입성");
		try {
			for(ClinicianVO clinicianVO : clinicianList.getClinicianList()) {
				
				String docId = clinicianVO.getDocId();
				System.out.println(docId+": DOCiD");
				System.out.println(docId);
				String rndId = commonService.selectRndId();
				String disClassDtl = (String)session.getAttribute("disClassDtl");
				clinicianVO.setDocClassDtl("DC004");
				clinicianVO.setRndId(rndId);
				System.out.println(rndId +":S1 RNDID");
				
			
				System.out.println(disClassDtl +"S1disClassDtl");
				System.out.println(disClassDtl+": disClassDtl");
				clinicianService.deleteClinicianAsdAnswer(clinicianVO);
			
				if(StringUtil.isEquals("Total", docId)) {
					clinicianService.deleteClinicianAsdTotalPm(clinicianVO);
					clinicianService.updateClinicianAsdPerformMstTotal(clinicianVO);
					clinicianService.deleteClinicianS1(clinicianVO);
				}else if(!StringUtil.isEquals("Total", docId)){
					clinicianVO.setDocId(docId);
					clinicianService.updateClinicianAsdPerformMst(clinicianVO);
					if("S1001".equals(docId) || "DS003".equals(disClassDtl)) {	
						clinicianService.deleteClinicianS1(clinicianVO);
						clinicianService.deleteS1IKLeiter(clinicianVO);
					}
					
					
					
				}
			}
			modelMap.put("success", true);
		}catch(Exception e) {
			modelMap.put("success", true);
			e.printStackTrace();
		}
		
		return new ModelAndView("jsonView", modelMap);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
