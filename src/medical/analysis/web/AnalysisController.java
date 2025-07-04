package medical.analysis.web;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import medical.analysis.service.AnalysisService;
import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.analysis.service.AnalysisTotalVO;
import medical.analysis.service.AnalysisVO;
import medical.common.service.CommonService;
import medical.framework.file.ExcelFile;
import medical.framework.util.JsonUtils;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImagingInfoService;

@Controller
public class AnalysisController {
	
	/** Service Class */
	@Resource(name="AnalysisService")
	private AnalysisService analysisService;
	
	@Resource(name="ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	@Resource(name="CommonService")
	private CommonService commonService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/medical/analysis/selectAnalysisList.do")
	public ModelAndView selectAnalysisList(HttpSession session, @ModelAttribute("AnalysisVO") AnalysisVO analysisVO,
			 @ModelAttribute("AnalysisTotalVO") AnalysisTotalVO analysisTotalVO
	, ModelMap model) throws Exception { 
		
		String docNm = analysisVO.getDocNm(); 
		List resultList = new ArrayList<>();
		int totalCount = 0;
		String disClassDtl = analysisVO.getDisClassDtl();
		
		//리스트 조회
		
		if("PHTs 3종 및 COT(소변)".equals(docNm)) {
			List<AnalysisTAnalEnvMattVO> envMattList = analysisService.selectTAnalEnvMattList(analysisVO);
			totalCount = analysisService.selectTAnalEnvMattListTotal(analysisVO);
			resultList = envMattList;
		}else if("중금속(혈액)".equals(docNm)) {
			List<AnalysisTAnalEnvMattBlVO> envMattBlList = analysisService.selectTAnalEnvMattBlList(analysisVO);
			totalCount = analysisService.selectTAnalEnvMattBlListTotal(analysisVO);
			resultList = envMattBlList;
//		}else if("SNP분석".equals(docNm)) {
//			List<AnalysisTAnalSnpVO> snpList = analysisService.selectTAnalSnpList(analysisVO);
//			totalCount = analysisService.selectTAnalSnpListTotal(analysisVO);
//			resultList = snpList;
		}else if("Total".equals(docNm)) {
			List<AnalysisTotalVO> totalList = analysisService.selectTAnalTotalList(analysisTotalVO);
			totalCount = analysisService.selectTAnalTotalListTotal(analysisTotalVO);
			resultList = totalList;
		}
		
		
		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	
	
	@RequestMapping("/medical/analysis/selectAnalysisMenuList.do")
	public ModelAndView selectAnalysisTabList(HttpSession session, @ModelAttribute("AnalysisVO")AnalysisVO analysisVO
			, ModelMap model) throws Exception {
		
		List<AnalysisVO> tabList = analysisService.selectAnalysisMenuList(analysisVO);
		model.put("success", true);
		model.put("result", tabList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/analysis/analysisFileUpload.do")
	public ModelAndView AnalysisFileUpload(@RequestParam("uploadZipFile") MultipartFile uploadZipFile,
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
				euTf = analysisService.analysisFileUpload(session, excelUploadFile, request, oDocFileVO);
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
	
	
	@RequestMapping("/medical/analysis/analysisExcelList.do")
	public ModelAndView surveyExcelList(@ModelAttribute("AnalysisVO")AnalysisVO analysisVO, 
	@ModelAttribute("analysisTotalVO")AnalysisTotalVO analysisTotalVO) throws Exception {
		
		  ExcelFile excelFile = null;
		  String docId = analysisVO.getDocId();
		  String disClassDtl = analysisVO.getDisClassDtl();
		  
		  String targetIds = analysisVO.getTargetIds();
		  String performCnts = analysisVO.getPerformCnts();
		  String[] targetIdList = null;
		  String[] performCntList = null;
		  String[] targetIdList2 = null;
		  String[] performCntList2 = null;
		  List<AnalysisVO> analysisVOList = new ArrayList<AnalysisVO>();
		  List<AnalysisTotalVO> analysisTotalVOList = new ArrayList<AnalysisTotalVO>();
		  AnalysisVO oAnalysisVO = null;
		  AnalysisTotalVO tAnalysisVO;
		  
		  if(targetIds != null && performCnts !=null) {
		      targetIdList = targetIds.split("\\|");
		  performCntList = performCnts.split("\\|");
		  
		      targetIdList2 = targetIds.split("\\|");
		  performCntList2 = performCnts.split("\\|");
		      
		      for(int i = 0 ; i < targetIdList.length ; i++) {
		    	  oAnalysisVO  = new AnalysisVO();
		          oAnalysisVO.setTargetId(targetIdList[i]);
		          oAnalysisVO.setPerformCnt(performCntList[i]);
		          oAnalysisVO.setDisClassDtl(disClassDtl);
		          oAnalysisVO.setLimit(60000);
		          analysisVOList.add(oAnalysisVO);
		      }
		      for(int i = 0 ; i < targetIdList2.length ; i++) {
		    	  tAnalysisVO  = new AnalysisTotalVO();
		          tAnalysisVO.setTargetId(targetIdList2[i]);
		          tAnalysisVO.setPerformCnt(performCntList2[i]);
		          tAnalysisVO.setDisClassDtl(disClassDtl);
		          tAnalysisVO.setLimit(60000);
		          analysisTotalVOList.add(tAnalysisVO);
		      }
		  }
		  
		  
		  if("Total".equals(docId)){
			 analysisTotalVO.setStart(0);
			 analysisTotalVO.setLimit(60000);
			 excelFile = analysisService.analysisTotalExcelList(analysisTotalVO, analysisTotalVOList);
		  }else if("PHTs 3종 및 COT(소변)".equals(docId)) {
			 analysisVO.setStart(0);
			 analysisVO.setLimit(60000);
			 excelFile = analysisService.analysisEnvMattExcelList(analysisVO, analysisVOList);
		  }else if("중금속(혈액)".equals(docId)) {
				 analysisVO.setStart(0);
				 analysisVO.setLimit(60000);
			 excelFile = analysisService.analysisEnvMattBlExcelList(analysisVO, analysisVOList);
			  }
//		  }else if("SNP분석".equals(docId)) {
//			 analysisVO.setStart(0);
//			 analysisVO.setLimit(60000);
//			 excelFile = analysisService.analysisSnpExcelList(analysisVO, analysisVOList);
//		  }
		 
		  return new ModelAndView("download", "download", excelFile);
	}
	
	
	@RequestMapping("/medical/analysis/deleteAnalysis.do")
	public ModelAndView deleteAnalysis(@ModelAttribute("AnalysisVO")AnalysisVO analysisVO ,ModelMap model
					,HttpServletRequest request, HttpSession session)throws Exception {

		String[] targetIdList = request.getParameterValues("targetIdList");
		String[] performCntList = request.getParameterValues("performCntList");
		String[] performNmList = request.getParameterValues("performNmList");
		String docNm = analysisVO.getDocNm();
		String rndId = commonService.selectRndId();
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		
		for(int i=0; i<targetIdList.length; i++) {
			analysisVO.setTargetId(targetIdList[i]);
			analysisVO.setPerformCnt(performCntList[i]);
			analysisVO.setPerformCntNm(performNmList[i]);
			analysisVO.setRndId(rndId);
			analysisVO.setDisClassDtl(disClassDtl);
			
			
			if("PHTs 3종 및 COT(소변)".equals(docNm)) {
				analysisService.deleteAnalysisEnvMatt(analysisVO);
			}else if("중금속(혈액)".equals(docNm)) {
				analysisService.deleteAnalysisEnvMattBl(analysisVO);

//			}else if("SNP분석".equals(docNm)) {
//				analysisService.deleteAnalysisSnp(analysisVO);
			}else if("Total".equals(docNm)) {
				analysisService.deleteAnalysisEnvMatt(analysisVO);
				analysisService.deleteAnalysisEnvMattBl(analysisVO);
			//	analysisService.deleteAnalysisSnp(analysisVO);
			}
		}
		
		model.put("success",true);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/analysis/selectAnalysisPage.do")
	public ModelAndView selectNeuropsyPage(HttpSession session, @ModelAttribute("AnalysisVO")AnalysisVO analysisVO
			, ModelMap model) throws Exception {
		
		String docNm = analysisVO.getDocNm();
		String schKeyWord = analysisVO.getSchKeyWord();
		int totalCount = 0;
		
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = analysisVO.getLimit();
			int pageNum,rNum;
			//해당 탭의 TargetID 위치로 이동
			if("PHTs 3종 및 COT(소변)".equals(docNm)) {
				List<AnalysisTAnalEnvMattVO> envMattList = analysisService.selectTAnalEnvMattList(analysisVO);
				rownum = envMattList.get(0).getRownum();
			}else if("중금속(혈액)".equals(docNm)) {
				List<AnalysisTAnalEnvMattBlVO> envMattBlList = analysisService.selectTAnalEnvMattBlList(analysisVO);
				rownum = envMattBlList.get(0).getRownum();
			}
//			}else if("SNP분석".equals(docNm)) {
//				List<AnalysisTAnalSnpVO> snpList = analysisService.selectTAnalSnpList(analysisVO);
//				rownum = snpList.get(0).getRownum();
//			}
			
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
