package medical.surveyAsd.web;

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

import medical.framework.file.ExcelFile;
import medical.framework.util.StringUtil;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.surveyAsd.service.SurveyAsdAbc01VO;
import medical.surveyAsd.service.SurveyAsdArsVO;
import medical.surveyAsd.service.SurveyAsdBdi02VO;
import medical.surveyAsd.service.SurveyAsdBdiParentsVO;
import medical.surveyAsd.service.SurveyAsdBpi01VO;
import medical.surveyAsd.service.SurveyAsdCbc15VO;
import medical.surveyAsd.service.SurveyAsdCbcl2VO;
import medical.surveyAsd.service.SurveyAsdCc3qaVO;
import medical.surveyAsd.service.SurveyAsdCc3qcVO;
import medical.surveyAsd.service.SurveyAsdCdiChildVO;
import medical.surveyAsd.service.SurveyAsdCmrspVO;
import medical.surveyAsd.service.SurveyAsdCpclVO;
import medical.surveyAsd.service.SurveyAsdCybocsVO;
import medical.surveyAsd.service.SurveyAsdGsrsVO;
import medical.surveyAsd.service.SurveyAsdIatVO;
import medical.surveyAsd.service.SurveyAsdKasdsVO;
import medical.surveyAsd.service.SurveyAsdKcriterionAdultVO;
import medical.surveyAsd.service.SurveyAsdKcriterionVO;
import medical.surveyAsd.service.SurveyAsdKcshqVO;
import medical.surveyAsd.service.SurveyAsdKmchatVO;
import medical.surveyAsd.service.SurveyAsdKpsiVO;
import medical.surveyAsd.service.SurveyAsdListVO;
import medical.surveyAsd.service.SurveyAsdLsd01VO;
import medical.surveyAsd.service.SurveyAsdMbriVO;
import medical.surveyAsd.service.SurveyAsdOcb15VO;
import medical.surveyAsd.service.SurveyAsdOldCbclVO;
import medical.surveyAsd.service.SurveyAsdPc3q1VO;
import medical.surveyAsd.service.SurveyAsdPp3q1VO;
import medical.surveyAsd.service.SurveyAsdPrdvVO;
import medical.surveyAsd.service.SurveyAsdQpgsrVO;
import medical.surveyAsd.service.SurveyAsdRcmasVO;
import medical.surveyAsd.service.SurveyAsdScqVO;
import medical.surveyAsd.service.SurveyAsdService;
import medical.surveyAsd.service.SurveyAsdSib01VO;
import medical.surveyAsd.service.SurveyAsdSrs01VO;
import medical.surveyAsd.service.SurveyAsdSrs03VO;
import medical.surveyAsd.service.SurveyAsdSsis1VO;
import medical.surveyAsd.service.SurveyAsdStaisChildVO;
import medical.surveyAsd.service.SurveyAsdStaisParentsVO;
import medical.surveyAsd.service.SurveyAsdStaitChildVO;
import medical.surveyAsd.service.SurveyAsdStaitParentsVO;
import medical.surveyAsd.service.SurveyAsdTotalVO;
import medical.surveyAsd.service.SurveyAsdTrauaVO;
import medical.surveyAsd.service.SurveyAsdTraumaVO;
import medical.surveyAsd.service.SurveyAsdVO;
import medical.surveyAsd.service.SurveyAsdYbocsVO;

@Controller
public class SurveyAsdController {
	/** Service Class */
	@Resource(name = "SurveyAsdService")
	private SurveyAsdService surveyAsdService;
	@Resource(name = "ImagingInfoService")
	private ImagingInfoService oImagingInfoService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/medical/surveyAsd/selectSurveyMenuList.do")
	public ModelAndView selectSurveyTabList(HttpSession session, @ModelAttribute("SurveyVO")SurveyAsdVO surveyAsdVO
			, ModelMap model) throws Exception {
		
		List<SurveyAsdVO> tabList = surveyAsdService.selectSurveyMenuList(surveyAsdVO);
		model.put("success", true);
		model.put("result", tabList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/surveyAsd/selectDocNmByDocId.do")
	public ModelAndView selectDocIdByDocNm(HttpSession session, @ModelAttribute("SurveyVO")SurveyAsdVO surveyAsdVO
			, ModelMap model) throws Exception {
		String docNm = surveyAsdService.selectDocNmByDocId(surveyAsdVO);
		model.put("success", true);
		model.put("docNm", docNm);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/surveyAsd/selectPerformCntList.do")
	public ModelAndView selectPerformCntList(HttpSession session, @ModelAttribute("SurveyVO")SurveyAsdVO surveyAsdVO
			, ModelMap model) throws Exception {
		List<SurveyAsdVO> resultList = surveyAsdService.selectPerformCntList(surveyAsdVO);
		model.put("success", true);
		model.put("result", resultList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/surveyAsd/selectSurveyListAo.do")
	public ModelAndView selectSurveyListAo(HttpSession session, @ModelAttribute("SurveyAsdVO")SurveyAsdVO surveyAsdVO
			,@ModelAttribute("SurveyAsdTotalVO")SurveyAsdTotalVO surveyAsdTotalVO, ModelMap model) throws Exception {
		String docId = surveyAsdVO.getDocId();
		
		//String OdisClassDtl = surveyAsdVO.getOdisClassDtl();
		String OdisClassDtl = (String)session.getAttribute("disClassDtl");
		System.out.println("OdisClassDtl(DS003)값:=====>"+OdisClassDtl);
		surveyAsdVO.setOdisClassDtl(OdisClassDtl);
		List resultList = new ArrayList();
		int totalCount = 0;
		
		if("Total".equals(docId)) {
			totalCount = surveyAsdService.selectSurveyTotalListAoTotal(surveyAsdTotalVO); 
			resultList = surveyAsdService.selectSurveyTotalListAo(surveyAsdTotalVO);
		}else if("PRDV1".equals(docId)){	//주산기 발달력
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyPrdvList(surveyAsdVO);
//		}else if("CYBO1".equals(docId)){	//CY-BOCS
//			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
//			resultList = surveyAsdService.selectSurveyCybocsList(surveyAsdVO);
		}else if("KMCHT".equals(docId)){	//KMCHAT
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyKmchatList(surveyAsdVO);
		}else if("OCBCL".equals(docId)){	//구 CBCL
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyOldCbclList(surveyAsdVO);
		}else if("CBCL2".equals(docId)){	//CBCL
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyCbcl2List(surveyAsdVO);
		}else if("OCB15".equals(docId)){	//구 CBCL 1.5-5
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyOcb15List(surveyAsdVO);
		}else if("CBC15".equals(docId)){	 //CBCL 1.5-5
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyCbc15List(surveyAsdVO);
		}else if("CPCL".equals(docId)){	 //CBCL 1.5-5
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyCpclList(surveyAsdVO);
			
//		}else if("SRS01".equals(docId)){	//SRS(약)
//			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
//			resultList = surveyAsdService.selectSurveySrs01List(surveyAsdVO);
//		}else if("YBOCS".equals(docId)){	//Y-BOCS
//			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
//			resultList = surveyAsdService.selectSurveyYbocsList(surveyAsdVO);
		}else if("ARS01".equals(docId)){	//ARS
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyArsList(surveyAsdVO);
		}else if("TRAUM".equals(docId)){	//트라우마
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyTraumList(surveyAsdVO);
		}else if("CDI01".equals(docId)){	//CDI 아동용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyCdi01List(surveyAsdVO);
		}else if("STITC".equals(docId)){	//STAI-T 아동용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyStitcList(surveyAsdVO);
		}else if("STISC".equals(docId)){	//STAI-S 아동용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyStiscList(surveyAsdVO);
		}else if("IAT01".equals(docId)){	//IAT
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyIatList(surveyAsdVO);
		}else if("KSCAL".equals(docId)){	//K-척도
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyKscalList(surveyAsdVO);
		}else if("RCMAS".equals(docId)){	//RCMAS
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyRcmasList(surveyAsdVO);
		}else if("BDI01".equals(docId)){	//BDI 부모용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyBdi01List(surveyAsdVO);
		}else if("STITP".equals(docId)){	//STAI-T 부모용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyStitpList(surveyAsdVO);
		}else if("STISP".equals(docId)){	//STAI-S 부모용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyStispList(surveyAsdVO);
		}else if("MBRI1".equals(docId)){	//MBRI
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyMbriList(surveyAsdVO);
		}else if("KPSI1".equals(docId)){	//K-PSI
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyKpsiList(surveyAsdVO);
		}else if("SIB01".equals(docId)){	//SIB 하위항목
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveySib01List(surveyAsdVO);
		}else if("BPI01".equals(docId)){	//BPI
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyBpi01List(surveyAsdVO);
		}else if("BDI02".equals(docId)){	//BDI_A 성인용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyBdi02List(surveyAsdVO);
		}else if("CC3QC".equals(docId)){	//CC3Q_C 아동용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyCc3qcList(surveyAsdVO);
		}else if("CC3QA".equals(docId)){	//CC3Q_A 성인용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyCc3qaList(surveyAsdVO);
		}else if("SRS03".equals(docId)){	//SRS(부모자녀)
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveySrs03List(surveyAsdVO);
		}else if("SCQ01".equals(docId)){	//SCQ(current,lifetime)
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyScqList(surveyAsdVO);
		}else if("LSD01".equals(docId)){	//LSD언어발달검사
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyLsd01List(surveyAsdVO);
		}else if("ABC01".equals(docId)){	//ABC
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyAbc01List(surveyAsdVO);
		}else if("SSIS1".equals(docId)){	//SSIS
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveySsis1List(surveyAsdVO);
		}else if("TRAUA".equals(docId)){	//TRAUMA_A
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyTrauaList(surveyAsdVO);
		}else if("PP3Q1".equals(docId)){	//PP3Q1
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyPp3q1List(surveyAsdVO);
		}else if("PC3Q1".equals(docId)){	//PC3Q1
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyPc3q1List(surveyAsdVO);
		}else if("KASDS".equals(docId)){	//KASDS
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyKasdsList(surveyAsdVO);
		}else if("CMRSP".equals(docId)){	//CMRS-P
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyCmrspList(surveyAsdVO);
		}else if("QPGSR".equals(docId)){	//QPGS-RⅢ
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyQpgsrList(surveyAsdVO);
		}else if("GSRS1".equals(docId)){	//GSRS
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyGsrsList(surveyAsdVO);
		}else if("KCSHQ".equals(docId)){	//K-CSHQ
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyKcshqList(surveyAsdVO);
		}else if("KSCAA".equals(docId)){	//K-척도 성인용
			totalCount = surveyAsdService.selectSurveyDtlListTotal(surveyAsdVO);
			resultList = surveyAsdService.selectSurveyKscaleAdultList(surveyAsdVO);
		}
		
		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/surveyAsd/surveyAsdExcelUpload.do")
	public ModelAndView surveyExcelUpload(@RequestParam("uploadZipFile") MultipartFile uploadZipFile,
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
				euTf = surveyAsdService.surveyFileUpload(session, excelUploadFile, request, oDocFileVO, taskId);
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
	
	@RequestMapping("/medical/surveyAsd/surveyExcelList.do")
	public ModelAndView surveyExcelList(@ModelAttribute("SurveyAsdVO")SurveyAsdVO surveyAsdVO, 
	@ModelAttribute("SurveyAsdTotalVO")SurveyAsdTotalVO surveyAsdTotalVO) throws Exception {
		
		System.out.println("2번 listmpapping");
		
		ExcelFile excelFile = null;
		  String docId = surveyAsdVO.getDocId();
		  String disClassDtl = surveyAsdVO.getDisClassDtl();
		  
		  String targetIds = surveyAsdVO.getTargetIds();
		  System.out.println(targetIds+"TARGETID");
		  String performCnts = surveyAsdVO.getPerformCnts();
		  System.out.println(performCnts+"PERFORMCNTS");
		  String[] targetIdList = null;
		  String[] performCntList = null;
		  String[] targetIdList2 = null;
		  String[] performCntList2 = null;
		  List<SurveyAsdVO> surveyVOList = new ArrayList<SurveyAsdVO>();
		  List<SurveyAsdTotalVO> surveyTotalVOList = new ArrayList<SurveyAsdTotalVO>();
		  SurveyAsdVO oSurveyVO = null;
		  SurveyAsdTotalVO tSurveyVO;
		  
		  if(targetIds != null && performCnts !=null) {
		      targetIdList = targetIds.split("\\|");
		  performCntList = performCnts.split("\\|");
		  
		      targetIdList2 = targetIds.split("\\|");
		  performCntList2 = performCnts.split("\\|");
		      
		      for(int i = 0 ; i < targetIdList.length ; i++) {
		          oSurveyVO  = new SurveyAsdVO();
		          oSurveyVO.setTargetId(targetIdList[i]);
		          oSurveyVO.setPerformCnt(performCntList[i]);
		          oSurveyVO.setDisClassDtl(disClassDtl);
		          oSurveyVO.setLimit(60000);
		          surveyVOList.add(oSurveyVO);
		      }
		      for(int i = 0 ; i < targetIdList2.length ; i++) {
		          tSurveyVO  = new SurveyAsdTotalVO();
		          tSurveyVO.setTargetId(targetIdList2[i]);
		          tSurveyVO.setPerformCnt(performCntList2[i]);
		          tSurveyVO.setDisClassDtl(disClassDtl);
		          tSurveyVO.setLimit(60000);
		          surveyTotalVOList.add(tSurveyVO);
		      }
		  }
		  
		  if("Total".equals(docId)){
			 surveyAsdTotalVO.setStart(0);
			 surveyAsdTotalVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdTotalExcelList(surveyAsdTotalVO, surveyTotalVOList);
		  }else if("CBCL2".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdCbcl2ExcelList(surveyAsdVO, surveyVOList);
		  }else if("OCB15".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdOcb15ExcelList(surveyAsdVO, surveyVOList);
		  }else if("CPCL".equals(docId)) {
				 surveyAsdVO.setStart(0);
				 surveyAsdVO.setLimit(60000);
				 excelFile = surveyAsdService.surveyAsdCpclExcelList(surveyAsdVO, surveyVOList);
		
		  }else if("CBC15".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdCbc15ExcelList(surveyAsdVO, surveyVOList);
		  }else if("PRDV1".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdPrdvExcelList(surveyAsdVO, surveyVOList);
		  }else if("SRS01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdSrs01ExcelList(surveyAsdVO, surveyVOList);
		  }else if("CYBO1".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdCybocsExcelList(surveyAsdVO, surveyVOList);
		  }else if("YBOCS".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdYbocsExcelList(surveyAsdVO, surveyVOList);
		  }else if("KMCHT".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdKmchatExcelList(surveyAsdVO, surveyVOList);
		  }else if("OCBCL".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdOldCbclExcelList(surveyAsdVO, surveyVOList);
		  }else if("ARS01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdArsExcelList(surveyAsdVO, surveyVOList);
		  }else if("TRAUM".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdTraumaExcelList(surveyAsdVO, surveyVOList);
		  }else if("CDI01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdCdiChildExcelList(surveyAsdVO, surveyVOList);
		  }else if("STITC".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdStaitChildExcelList(surveyAsdVO, surveyVOList);
		  }else if("STISC".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdStaisChildExcelList(surveyAsdVO, surveyVOList);
		  }else if("IAT01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdIatExcelList(surveyAsdVO, surveyVOList);
		  }else if("KSCAL".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdKcriterionExcelList(surveyAsdVO, surveyVOList);
		  }else if("RCMAS".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdRcmasExcelList(surveyAsdVO, surveyVOList);
		  }else if("BDI01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdBdiParentsExcelList(surveyAsdVO, surveyVOList);
		  }else if("STITP".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdStaitParentsExcelList(surveyAsdVO, surveyVOList);
		  }else if("STISP".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdStaisParentsExcelList(surveyAsdVO, surveyVOList);
		  }else if("MBRI1".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdMbriExcelList(surveyAsdVO, surveyVOList);
		  }else if("KPSI1".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdKpsiExcelList(surveyAsdVO, surveyVOList);
		  }else if("SIB01".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdSib01ExcelList(surveyAsdVO, surveyVOList);
		  }else if("BPI01".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdBpi01ExcelList(surveyAsdVO, surveyVOList);
		  }else if("SRS03".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdSrs03ExcelList(surveyAsdVO, surveyVOList);
		  }else if("SCQ01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdScqExcelList(surveyAsdVO, surveyVOList);
		  }else if("ABC01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdAbc01ExcelList(surveyAsdVO, surveyVOList);
		  }else if("LSD01".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdLsd01ExcelList(surveyAsdVO, surveyVOList);
		  }else if("BDI02".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdBdi02ExcelList(surveyAsdVO, surveyVOList);
		  }else if("CC3QC".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdCc3qcExcelList(surveyAsdVO, surveyVOList);
		  }else if("CC3QA".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdCc3qaExcelList(surveyAsdVO, surveyVOList);
		  }else if("SSIS1".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdSsis1ExcelList(surveyAsdVO, surveyVOList);
		  }else if("TRAUA".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdTrauaExcelList(surveyAsdVO, surveyVOList);
		  }else if("PP3Q1".equals(docId)) {
			 surveyAsdVO.setStart(0);
			 surveyAsdVO.setLimit(60000);
			 excelFile = surveyAsdService.surveyAsdPp3q1ExcelList(surveyAsdVO, surveyVOList);
		  }else if("PC3Q1".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdPc3q1ExcelList(surveyAsdVO, surveyVOList);
		  }else if("KASDS".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdKasdsExcelList(surveyAsdVO, surveyVOList);
		  }else if("CMRSP".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdCmrspExcelList(surveyAsdVO, surveyVOList);
		  }else if("QPGSR".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdQpgsrExcelList(surveyAsdVO, surveyVOList);
		  }else if("GSRS1".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdGsrsExcelList(surveyAsdVO, surveyVOList);
		  }else if("KCSHQ".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdKcshqExcelList(surveyAsdVO, surveyVOList);
		  }else if("KSCAA".equals(docId)) {
			  surveyAsdVO.setStart(0);
			  surveyAsdVO.setLimit(60000);
			  excelFile = surveyAsdService.surveyAsdKcriterionAdultExcelList(surveyAsdVO, surveyVOList);
		  }
		  
		  return new ModelAndView("download", "download", excelFile);
	}
	
	@RequestMapping("/medical/surveyAsd/selectSurveyAoPage.do")
	public ModelAndView selectSurveyPage(HttpSession session, @ModelAttribute("SurveyAsdVO")SurveyAsdVO surveyAsdVO
			, ModelMap model) throws Exception {
		String docId = surveyAsdVO.getDocId().toUpperCase();
		String schKeyWord = surveyAsdVO.getSchKeyWord();
		surveyAsdVO.setDocId(docId);
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = surveyAsdVO.getLimit();
			int pageNum,rNum;
			//해당 탭의 TargetID 위치로 이동
			
			//TargetID 조회
			if("PRDV1".equals(docId)){	//주산기 발달력
				List<SurveyAsdPrdvVO> prdvList = surveyAsdService.selectSurveyPrdvList(surveyAsdVO);
				rownum = prdvList.get(0).getRownum();
//			}else if("CYBO1".equals(docId)){	//CY-BOCS
//				List<SurveyAsdCybocsVO> cybocsList = surveyAsdService.selectSurveyCybocsList(surveyAsdVO);
//				rownum = cybocsList.get(0).getRownum();
			}else if("KMCHT".equals(docId)){	//KMCHAT
				List<SurveyAsdKmchatVO> kmchatList = surveyAsdService.selectSurveyKmchatList(surveyAsdVO);
				rownum = kmchatList.get(0).getRownum();
			}else if("OCBCL".equals(docId)){	//구 CBCL
				List<SurveyAsdOldCbclVO> ocbclList = surveyAsdService.selectSurveyOldCbclList(surveyAsdVO);
				rownum = ocbclList.get(0).getRownum();
			}else if("CBCL2".equals(docId)){	//CBCL
				List<SurveyAsdCbcl2VO> cbcl2List = surveyAsdService.selectSurveyCbcl2List(surveyAsdVO);
				rownum = cbcl2List.get(0).getRownum();
			}else if("OCB15".equals(docId)){	//구 CBCL 1.5-5
				List<SurveyAsdOcb15VO> ocb15List = surveyAsdService.selectSurveyOcb15List(surveyAsdVO);
				rownum = ocb15List.get(0).getRownum();
			}else if("CBC15".equals(docId)){	//CBCL 1.5-5
				List<SurveyAsdCbc15VO> cbc15List = surveyAsdService.selectSurveyCbc15List(surveyAsdVO);
				rownum = cbc15List.get(0).getRownum();
			}else if("CPCL".equals(docId)){	//CPCL
				List<SurveyAsdCpclVO> cpclList = surveyAsdService.selectSurveyCpclList(surveyAsdVO);
				rownum = cpclList.get(0).getRownum();	
				
//			}else if("SRS01".equals(docId)){	//SRS(약)
//				List<SurveyAsdSrs01VO> srs01List = surveyAsdService.selectSurveySrs01List(surveyAsdVO);
//				rownum = srs01List.get(0).getRownum();
//			}else if("YBOCS".equals(docId)){	//Y-BOCS
//				List<SurveyAsdYbocsVO> ybocsList = surveyAsdService.selectSurveyYbocsList(surveyAsdVO);
//				rownum = ybocsList.get(0).getRownum();
			}else if("ARS01".equals(docId)){	//ARS
				List<SurveyAsdArsVO> arsList = surveyAsdService.selectSurveyArsList(surveyAsdVO);
				rownum = arsList.get(0).getRownum();
			}else if("TRAUM".equals(docId)){	//트라우마
				List<SurveyAsdTraumaVO> traumaList = surveyAsdService.selectSurveyTraumList(surveyAsdVO);
				rownum = traumaList.get(0).getRownum();
			}else if("CDI01".equals(docId)){	//CDI 아동용
				List<SurveyAsdCdiChildVO> cdicList = surveyAsdService.selectSurveyCdi01List(surveyAsdVO);
				rownum = cdicList.get(0).getRownum();
			}else if("STITC".equals(docId)){	//STAI-T 아동용
				List<SurveyAsdStaitChildVO> stitcList = surveyAsdService.selectSurveyStitcList(surveyAsdVO);
				rownum = stitcList.get(0).getRownum();
			}else if("STISC".equals(docId)){	//STAI-S 아동용
				List<SurveyAsdStaisChildVO> stiscList = surveyAsdService.selectSurveyStiscList(surveyAsdVO);
				rownum = stiscList.get(0).getRownum();
			}else if("IAT01".equals(docId)){	//IAT
				List<SurveyAsdIatVO> iatList = surveyAsdService.selectSurveyIatList(surveyAsdVO);
				rownum = iatList.get(0).getRownum();
			}else if("KSCAL".equals(docId)){	//K-척도
				List<SurveyAsdKcriterionVO> kscalList = surveyAsdService.selectSurveyKscalList(surveyAsdVO);
				rownum = kscalList.get(0).getRownum();
			}else if("RCMAS".equals(docId)){	//RCMAS
				List<SurveyAsdRcmasVO> rcmasList = surveyAsdService.selectSurveyRcmasList(surveyAsdVO);
				rownum = rcmasList.get(0).getRownum();
			}else if("BDI01".equals(docId)){	//BDI 부모용
				List<SurveyAsdBdiParentsVO> bdi01List = surveyAsdService.selectSurveyBdi01List(surveyAsdVO);
				rownum = bdi01List.get(0).getRownum();
			}else if("STITP".equals(docId)){	//STAI-T 부모용
				List<SurveyAsdStaitParentsVO> stitpList = surveyAsdService.selectSurveyStitpList(surveyAsdVO);
				rownum = stitpList.get(0).getRownum();
			}else if("STISP".equals(docId)){	//STAI-S 부모용
				List<SurveyAsdStaisParentsVO> stispList = surveyAsdService.selectSurveyStispList(surveyAsdVO);
				rownum = stispList.get(0).getRownum();
			}else if("MBRI1".equals(docId)){	//MBRI
				List<SurveyAsdMbriVO> mbriList = surveyAsdService.selectSurveyMbriList(surveyAsdVO);
				rownum = mbriList.get(0).getRownum();
			}else if("KPSI1".equals(docId)){	//K-PSI
				List<SurveyAsdKpsiVO> kpsiList = surveyAsdService.selectSurveyKpsiList(surveyAsdVO);
				rownum = kpsiList.get(0).getRownum();
			}else if("SIB01".equals(docId)){	//SIB 하위항목
				List<SurveyAsdSib01VO> sibList = surveyAsdService.selectSurveySib01List(surveyAsdVO);
				rownum = sibList.get(0).getRownum();
			}else if("BPI01".equals(docId)){	//BPI
				List<SurveyAsdBpi01VO> bpiList = surveyAsdService.selectSurveyBpi01List(surveyAsdVO);
				rownum = bpiList.get(0).getRownum();
			}else if("BDI02".equals(docId)){	//BDI_A 성인용
				List<SurveyAsdBdi02VO> bdi02List = surveyAsdService.selectSurveyBdi02List(surveyAsdVO);
				rownum = bdi02List.get(0).getRownum();
			}else if("CC3QC".equals(docId)){	//CC3Q_C 아동용
				List<SurveyAsdCc3qcVO> cc3qcList = surveyAsdService.selectSurveyCc3qcList(surveyAsdVO);
				rownum = cc3qcList.get(0).getRownum();
			}else if("CC3QA".equals(docId)){	//CC3Q_A 성인용
				List<SurveyAsdCc3qaVO> cc3qaList = surveyAsdService.selectSurveyCc3qaList(surveyAsdVO);
				rownum = cc3qaList.get(0).getRownum();
			}else if("SRS03".equals(docId)){	//SRS(부모자녀)
				List<SurveyAsdSrs03VO> srs03List = surveyAsdService.selectSurveySrs03List(surveyAsdVO);
				rownum = srs03List.get(0).getRownum();
			}else if("SCQ01".equals(docId)){	//SCQ(current,lifetime)
				List<SurveyAsdScqVO> scqList = surveyAsdService.selectSurveyScqList(surveyAsdVO);
				rownum = scqList.get(0).getRownum();
			}else if("LSD01".equals(docId)){	//LSD언어발달검사
				List<SurveyAsdLsd01VO> lsdList = surveyAsdService.selectSurveyLsd01List(surveyAsdVO);
				rownum = lsdList.get(0).getRownum();
			}else if("ABC01".equals(docId)){	//ABC
				List<SurveyAsdAbc01VO> abcList = surveyAsdService.selectSurveyAbc01List(surveyAsdVO);
				rownum = abcList.get(0).getRownum();
			}else if("SSIS1".equals(docId)){	//SSIS
				List<SurveyAsdSsis1VO> ssisList = surveyAsdService.selectSurveySsis1List(surveyAsdVO);
				rownum = ssisList.get(0).getRownum();
			}else if("TRAUA".equals(docId)){	//TRAUMA_A
				List<SurveyAsdTrauaVO> traumaAList = surveyAsdService.selectSurveyTrauaList(surveyAsdVO);
				rownum = traumaAList.get(0).getRownum();
			}else if("PP3Q1".equals(docId)){	//PP3Q1
				List<SurveyAsdPp3q1VO> pp3qList = surveyAsdService.selectSurveyPp3q1List(surveyAsdVO);
				rownum = pp3qList.get(0).getRownum();
			}else if("PC3Q1".equals(docId)){	//PC3Q1
				List<SurveyAsdPc3q1VO> pc3qList = surveyAsdService.selectSurveyPc3q1List(surveyAsdVO);
				rownum = pc3qList.get(0).getRownum();
			}else if("KASDS".equals(docId)){	//K-ASDS
				List<SurveyAsdKasdsVO> kasdsList = surveyAsdService.selectSurveyKasdsList(surveyAsdVO);
				rownum = kasdsList.get(0).getRownum();
			}else if("CMRSP".equals(docId)){	//CMRS-P
				List<SurveyAsdCmrspVO> cmrspList = surveyAsdService.selectSurveyCmrspList(surveyAsdVO);
				rownum = cmrspList.get(0).getRownum();
			}else if("QPGSR".equals(docId)){	//QPGS-RⅢ
				List<SurveyAsdQpgsrVO> qpgsrList = surveyAsdService.selectSurveyQpgsrList(surveyAsdVO);
				rownum = qpgsrList.get(0).getRownum();
			}else if("GSRS1".equals(docId)){	//GSRS
				List<SurveyAsdGsrsVO> gsrsList = surveyAsdService.selectSurveyGsrsList(surveyAsdVO);
				rownum = gsrsList.get(0).getRownum();
			}else if("KCSHQ".equals(docId)){	//K-CSHQ
				List<SurveyAsdKcshqVO> kcshqList = surveyAsdService.selectSurveyKcshqList(surveyAsdVO);
				rownum = kcshqList.get(0).getRownum();
			}else if("KSCAA".equals(docId)){	//K-CSHQ
				List<SurveyAsdKcriterionAdultVO> kscaleList = surveyAsdService.selectSurveyKscaleAdultList(surveyAsdVO);
				rownum = kscaleList.get(0).getRownum();
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
	
	@RequestMapping("/medical/surveyAsd/deleteSurveyAnswer.do")
	public ModelAndView deleteSurveyAsdAnswer(HttpSession session, @RequestBody SurveyAsdListVO surveyAsdList) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		try {
			for(SurveyAsdVO surveyAsdVO : surveyAsdList.getSurveyAsdList()) {
				String docId = surveyAsdVO.getDocId();
				System.out.println("DELETE docID:::>"+docId);
				surveyAsdVO.setDocClassDtl("DC002");
				surveyAsdService.deleteSurveyAsdAnswer(surveyAsdVO);
				if(StringUtil.isEquals("Total", docId)) {
				//	surveyAsdService.deleteSurveyAsdTotalPm(surveyAsdVO);
					surveyAsdService.updateSurveyAsdPerformMstTotal(surveyAsdVO);
				}else if(!StringUtil.isEquals("Total", docId) && !StringUtil.isEquals("PRDV1", docId)){
					surveyAsdVO.setDocId(docId);
					surveyAsdService.updateSurveyAsdPerformMst(surveyAsdVO);
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
