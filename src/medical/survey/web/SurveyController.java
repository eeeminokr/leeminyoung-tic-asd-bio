package medical.survey.web;

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

import medical.framework.file.ExcelFile;
import medical.framework.util.StringUtil;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.ImagingInfoService;
import medical.imagingInfo.service.UploadExcelVO;
import medical.survey.service.SurveyArsVO;
import medical.survey.service.SurveyBdiParentsVO;
import medical.survey.service.SurveyCdiChildVO;
import medical.survey.service.SurveyCmrspVO;
import medical.survey.service.SurveyCybocsVO;
import medical.survey.service.SurveyDbdsVO;
import medical.survey.service.SurveyIatVO;
import medical.survey.service.SurveyKaadhdsVO;
import medical.survey.service.SurveyKbis11rVO;
import medical.survey.service.SurveyKcbclVO;
import medical.survey.service.SurveyKcriterionVO;
import medical.survey.service.SurveyKpsiVO;
import medical.survey.service.SurveyListVO;
import medical.survey.service.SurveyLoicvVO;
import medical.survey.service.SurveyMbriVO;
import medical.survey.service.SurveyRcmasVO;
import medical.survey.service.SurveyService;
import medical.survey.service.SurveySrsVO;
import medical.survey.service.SurveyStaisChildVO;
import medical.survey.service.SurveyStaisParentsVO;
import medical.survey.service.SurveyStaisYouthVO;
import medical.survey.service.SurveyStaitChildVO;
import medical.survey.service.SurveyStaitParentsVO;
import medical.survey.service.SurveyStaitYouthVO;
import medical.survey.service.SurveyTotalVO;
import medical.survey.service.SurveyTraumaVO;
import medical.survey.service.SurveyVO;
import medical.survey.service.SurveyYbocaVO;
import medical.survey.service.SurveyYbocsVO;
import medical.survey.service.SurveyYgtssVO;
import medical.survey.service.impl.SurveyLoicvCellReaderMapper;

@Controller
public class SurveyController {
	/** Service Class */
	@Resource(name = "SurveyService")
	private SurveyService surveyService;
	@Resource(name = "ImagingInfoService")
	private ImagingInfoService oImagingInfoService;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/medical/survey/selectSurveyMenuList.do")
	public ModelAndView selectSurveyTabList(HttpSession session, @ModelAttribute("SurveyVO")SurveyVO surveyVO
			, ModelMap model) throws Exception {
		
		List<SurveyVO> tabList = surveyService.selectSurveyMenuList(surveyVO);
		model.put("success", true);
		model.put("result", tabList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/survey/selectDocNmByDocId.do")
	public ModelAndView selectDocIdByDocNm(HttpSession session, @ModelAttribute("SurveyVO")SurveyVO surveyVO
			, ModelMap model) throws Exception {
		String docNm = surveyService.selectDocNmByDocId(surveyVO);
		model.put("success", true);
		model.put("docNm", docNm);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/survey/selectSurveyPage.do")
	public ModelAndView selectSurveyPage(HttpSession session, @ModelAttribute("SurveyVO")SurveyVO surveyVO
			, ModelMap model) throws Exception {
		String docId = surveyVO.getDocId().toUpperCase();
		String schKeyWord = surveyVO.getSchKeyWord();
		surveyVO.setDocId(docId);
		if("schTargetId".equals(schKeyWord)) {
			int rownum = 0;
			int pageSize = surveyVO.getLimit();
			int pageNum,rNum;
			//해당 탭의 TargetID 위치로 이동
			
			//TargetID 조회
			if("ARS01".equals(docId)){
				List<SurveyArsVO> arsList = surveyService.selectSurveyArsList(surveyVO);
				rownum = arsList.get(0).getRownum();
			}else if("SRS01".equals(docId)) { 	//SRS 임상가평가
				List<SurveySrsVO> srsList = surveyService.selectSurveySrsList(surveyVO);
				rownum = srsList.get(0).getRownum();
			}else if("SRS02".equals(docId)) { 	//SRS 4주 간격 면담지
				List<SurveySrsVO> srsList = surveyService.selectSurveySrsList(surveyVO);
				rownum = srsList.get(0).getRownum();
			}else if("YGTS1".equals(docId)) {	//YGTSS 임상가평가
				List<SurveyYgtssVO> ygtssList = surveyService.selectSurveyYgtssList(surveyVO);
				rownum = ygtssList.get(0).getRownum();
			}else if("YGTS2".equals(docId)) {	//YGTSS 4주 간격 면담지
				List<SurveyYgtssVO> ygtssList = surveyService.selectSurveyYgtssList(surveyVO);
				rownum = ygtssList.get(0).getRownum();
			}else if("CYBO2".equals(docId)) {	//YBOCS 4주 간격 면담지
				List<SurveyYbocaVO> cybocsList = surveyService.selectSurveyYbocaList(surveyVO);
				rownum = cybocsList.get(0).getRownum();
			}else if("YBOCA".equals(docId)) {	//Y-BOCS 임상가평가
				List<SurveyYbocaVO> ybocaList = surveyService.selectSurveyYbocaList(surveyVO);
				rownum = ybocaList.get(0).getRownum();
			}else if("CYBO3".equals(docId)) {	//YBOCS-부모 4주간격면담지
				List<SurveyYbocsVO> cybocsList = surveyService.selectSurveyYbocsList(surveyVO);
				rownum = cybocsList.get(0).getRownum();
			}else if("YBOCS".equals(docId)) {	//Y-BOCS 부모 임상가평가
				List<SurveyYbocsVO> ybocsList = surveyService.selectSurveyYbocsList(surveyVO);
				rownum = ybocsList.get(0).getRownum();
			}else if("KCBCL".equals(docId)) { //kcbcl + cbcl
				List<SurveyKcbclVO> kcbclList = surveyService.selectSurveyKcbclList(surveyVO);
				rownum = kcbclList.get(0).getRownum();
			}else if("DBDS1".equals(docId)) {
				List<SurveyDbdsVO> dbdsList = surveyService.selectSurveyDbds1List(surveyVO);
				rownum = dbdsList.get(0).getRownum();
			}else if("CMRSP".equals(docId)) {
				List<SurveyCmrspVO> cmrspList = surveyService.selectSurveyCmrspList(surveyVO);
				rownum = cmrspList.get(0).getRownum();
			}else if("TRAUM".equals(docId)) {
				List<SurveyTraumaVO> traumaList = surveyService.selectSurveyTraumList(surveyVO);
				rownum = traumaList.get(0).getRownum();
			}else if("CDI01".equals(docId)) {
				List<SurveyCdiChildVO> cdiList = surveyService.selectSurveyCdi01List(surveyVO);
				rownum = cdiList.get(0).getRownum();
			}else if("IAT01".equals(docId)) {
				List<SurveyIatVO> iatList = surveyService.selectSurveyIat01List(surveyVO);
				rownum = iatList.get(0).getRownum();
			}else if("KSCAL".equals(docId)) {
				List<SurveyKcriterionVO> kscalList = surveyService.selectSurveyKscalList(surveyVO);
				rownum = kscalList.get(0).getRownum();
			}else if("RCMAS".equals(docId)) {
				List<SurveyRcmasVO> rcmasList = surveyService.selectSurveyRcmasList(surveyVO);
				rownum = rcmasList.get(0).getRownum();
			}else if("STITC".equals(docId)) {
				List<SurveyStaitChildVO> stitcList = surveyService.selectSurveyStitcList(surveyVO);
				rownum = stitcList.get(0).getRownum();
			}else if("STISC".equals(docId)) {
				List<SurveyStaisChildVO> stiscList = surveyService.selectSurveyStiscList(surveyVO);
				rownum = stiscList.get(0).getRownum();
			}else if("STITY".equals(docId)) {
				List<SurveyStaitYouthVO> stityList = surveyService.selectSurveyStityList(surveyVO);
				rownum = stityList.get(0).getRownum();
			}else if("STISY".equals(docId)) {
				List<SurveyStaisYouthVO> stisyList = surveyService.selectSurveyStisyList(surveyVO);
				rownum = stisyList.get(0).getRownum();
			}else if("STITP".equals(docId)) {
				List<SurveyStaitParentsVO> stitpList = surveyService.selectSurveyStitpList(surveyVO);
				rownum = stitpList.get(0).getRownum();
			}else if("STISP".equals(docId)) {
				List<SurveyStaisParentsVO> stispList = surveyService.selectSurveyStispList(surveyVO);
				rownum = stispList.get(0).getRownum();
			}else if("LOICV".equals(docId)) {
				List<SurveyLoicvVO> loicvList = surveyService.selectSurveyLoicvList(surveyVO);
				rownum = loicvList.get(0).getRownum();
			}else if("KBIS1".equals(docId)) {
				List<SurveyKbis11rVO> kbisList = surveyService.selectSurveyKbis1List(surveyVO);
				rownum = kbisList.get(0).getRownum();
			}else if("BDI01".equals(docId)) {
				List<SurveyBdiParentsVO> bdiList = surveyService.selectSurveyBdi01List(surveyVO);
				rownum = bdiList.get(0).getRownum();
			}else if("MBRI1".equals(docId)) {
				List<SurveyMbriVO> mbriList = surveyService.selectSurveyMbri1List(surveyVO);
				rownum = mbriList.get(0).getRownum();
			}else if("KADHD".equals(docId)) {
				List<SurveyKaadhdsVO> kaadhdList = surveyService.selectSurveyKadhdList(surveyVO);
				rownum = kaadhdList.get(0).getRownum();
			}else if("KPSI1".equals(docId)) {
				List<SurveyKpsiVO> kpsiList = surveyService.selectSurveyKpsi1List(surveyVO);
				rownum = kpsiList.get(0).getRownum();
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
	
	@RequestMapping("/medical/survey/selectSurveyList.do")
	public ModelAndView selectSurveyList(HttpSession session, @ModelAttribute("SurveyVO")SurveyVO surveyVO
			,@ModelAttribute("SurveyTotalVO")SurveyTotalVO surveyTotalVO, ModelMap model) throws Exception {
		String docId = surveyVO.getDocId();
		List resultList = new ArrayList();
		int totalCount = 0;
		if("Total".equals(docId)) {
			totalCount = surveyService.selectSurveyTotalListTotal(surveyTotalVO); 
			resultList = surveyService.selectSurveyTotalList(surveyTotalVO);
		}else if("PRDV1".equals(docId)){	//주산기 발달력
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyPrdvList(surveyVO);
		}else if("ARS01".equals(docId)){
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyArsList(surveyVO);
		}else if("SRS01".equals(docId)) { 	//SRS 임상가평가
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveySrsList(surveyVO);
		}else if("SRS02".equals(docId)) { 	//SRS 4주 간격 면담지
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveySrsList(surveyVO);
		}else if("YGTS1".equals(docId)) {	//YGTSS 임상가평가
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyYgtssList(surveyVO);
		}else if("YGTS2".equals(docId)) {	//YGTSS 4주 간격 면담지
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyYgtssList(surveyVO);
		}else if("CYBO2".equals(docId)) {	//YBOCS 4주 간격 면담지
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyYbocaList(surveyVO);
		}else if("YBOCA".equals(docId)) {	//YBOCS 임상가평가
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyYbocaList(surveyVO);
		}else if("CYBO3".equals(docId)) {	//YBOCS-부모 4주간격면담지
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyYbocsList(surveyVO);
		}else if("YBOCS".equals(docId)) {	//Y-BOCS 부모 임상가평가
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyYbocsList(surveyVO);
		}else if("KCBCL".equals(docId)) { //kcbcl + cbcl
			totalCount = surveyService.selectSurveyKcbclListTotal(surveyVO);
			resultList = surveyService.selectSurveyKcbclList(surveyVO);
		}else if("DBDS1".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyDbds1List(surveyVO);
		}else if("CMRSP".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyCmrspList(surveyVO);
		}else if("TRAUM".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyTraumList(surveyVO);
		}else if("CDI01".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyCdi01List(surveyVO);
		}else if("IAT01".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyIat01List(surveyVO);
		}else if("KSCAL".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyKscalList(surveyVO);
		}else if("RCMAS".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyRcmasList(surveyVO);
		}else if("STITC".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyStitcList(surveyVO);
		}else if("STISC".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyStiscList(surveyVO);
		}else if("STITY".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyStityList(surveyVO);
		}else if("STISY".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyStisyList(surveyVO);
		}else if("STITP".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyStitpList(surveyVO);
		}else if("STISP".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyStispList(surveyVO);
		}else if("LOICV".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyLoicvList(surveyVO);
		}else if("KBIS1".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyKbis1List(surveyVO);
		}else if("BDI01".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyBdi01List(surveyVO);
		}else if("MBRI1".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyMbri1List(surveyVO);
		}else if("KADHD".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyKadhdList(surveyVO);
		}else if("KPSI1".equals(docId)) {
			totalCount = surveyService.selectSurveyDtlListTotal(surveyVO);
			resultList = surveyService.selectSurveyKpsi1List(surveyVO);
		}
		model.put("success", true);
		model.put("result", resultList);
		model.put("total", totalCount);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/survey/selectPerformCntList.do")
	public ModelAndView selectPerformCntList(HttpSession session, @ModelAttribute("SurveyVO")SurveyVO surveyVO
			, ModelMap model) throws Exception {
		List<SurveyVO> resultList = surveyService.selectPerformCntList(surveyVO);
		model.put("success", true);
		model.put("result", resultList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/survey/surveyExcelList.do")
    public ModelAndView surveyExcelList(@ModelAttribute("SurveyVO")SurveyVO surveyVO, 
    		@ModelAttribute("SurveyTotalVO")SurveyTotalVO surveyTotalVO) throws Exception {
              ExcelFile excelFile = null;
              String docId = surveyVO.getDocId();
              
              String targetIds = surveyVO.getTargetIds();
              String performCnts = surveyVO.getPerformCnts();
              String[] targetIdList = null;
              String[] performCntList = null;
              String[] targetIdList2 = null;
              String[] performCntList2 = null;
              List<SurveyVO> surveyVOList = new ArrayList<SurveyVO>();
              List<SurveyTotalVO> surveyTotalVOList = new ArrayList<SurveyTotalVO>();
              SurveyVO oSurveyVO;
              SurveyTotalVO tSurveyVO;
              
              if(targetIds != null && performCnts !=null) {
	              targetIdList = targetIds.split("\\|");
	              performCntList = performCnts.split("\\|");
              
	              targetIdList2 = targetIds.split("\\|");
	              performCntList2 = performCnts.split("\\|");
	              
	              for(int i = 0 ; i < targetIdList.length ; i++) {
                      oSurveyVO  = new SurveyVO();
                      oSurveyVO.setTargetId(targetIdList[i]);
                      oSurveyVO.setPerformCnt(performCntList[i]);
                      oSurveyVO.setLimit(60000);
                      surveyVOList.add(oSurveyVO);
	              }
	              for(int i = 0 ; i < targetIdList2.length ; i++) {
	                  tSurveyVO  = new SurveyTotalVO();
	                  tSurveyVO.setTargetId(targetIdList2[i]);
	                  tSurveyVO.setPerformCnt(performCntList2[i]);
	                  tSurveyVO.setLimit(60000);
	                  surveyTotalVOList.add(tSurveyVO);
	              }
              }
              
              if("ARS01".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyArsExcelList(surveyVO, surveyVOList);
              }else if("PRDV1".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyPrdvExcelList(surveyVO, surveyVOList);
              }else if("SRS01".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveySrsExcelList(surveyVO, surveyVOList);
              }else if("SRS02".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveySrsExcelList(surveyVO, surveyVOList);
              }else if("YGTS1".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyYgtssExcelList(surveyVO, surveyVOList);
              }else if("YGTS2".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyYgtssExcelList(surveyVO, surveyVOList);
              }else if("CYBO2".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyYbocaExcelList(surveyVO, surveyVOList);
              }else if("CYBO3".equals(docId)){
		                 surveyVO.setStart(0);
		                 surveyVO.setLimit(60000);
		                 excelFile = surveyService.surveyYbocsExcelList(surveyVO, surveyVOList);
              }else if("YBOCS".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyYbocsExcelList(surveyVO, surveyVOList);
              }else if("YBOCA".equals(docId)){
		                 surveyVO.setStart(0);
		                 surveyVO.setLimit(60000);
		                 excelFile = surveyService.surveyYbocaExcelList(surveyVO, surveyVOList);
              }else if("KCBCL".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyKcbclExcelList(surveyVO, surveyVOList);
              }else if("DBDS1".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyDbdsExcelList(surveyVO, surveyVOList);
              }else if("CMRSP".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyCmrspExcelList(surveyVO, surveyVOList);
              }else if("TRAUM".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyTraumaExcelList(surveyVO, surveyVOList);
              }else if("CDI01".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyCdiChildExcelList(surveyVO, surveyVOList);
              }else if("IAT01".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyIatExcelList(surveyVO, surveyVOList);
              }else if("KSCAL".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyKscalExcelList(surveyVO, surveyVOList);
              }else if("RCMAS".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyRcmasExcelList(surveyVO, surveyVOList);
              }else if("STITC".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyStaitChildExcelList(surveyVO, surveyVOList);
              }else if("STISC".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyStaisChildExcelList(surveyVO, surveyVOList);
              }else if("STITY".equals(docId)){
		                 surveyVO.setStart(0);
		                 surveyVO.setLimit(60000);
		                 excelFile = surveyService.surveyStaitYouthExcelList(surveyVO, surveyVOList);
		      }else if("STISY".equals(docId)){
		                 surveyVO.setStart(0);
		                 surveyVO.setLimit(60000);
		                 excelFile = surveyService.surveyStaisYouthExcelList(surveyVO, surveyVOList);
		      }else if("STITP".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyStaitParentsExcelList(surveyVO, surveyVOList);
              }else if("STISP".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyStaisParentsExcelList(surveyVO, surveyVOList);
              }else if("LOICV".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyLoicvExcelList(surveyVO, surveyVOList);
              }else if("KBIS1".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyKbis11rExcelList(surveyVO, surveyVOList);
              }else if("BDI01".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyBdiParentsExcelList(surveyVO, surveyVOList);
              }else if("MBRI1".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyMbriExcelList(surveyVO, surveyVOList);
              }else if("KADHD".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyKaadhdsExcelList(surveyVO, surveyVOList);
              }else if("KPSI1".equals(docId)){
                         surveyVO.setStart(0);
                         surveyVO.setLimit(60000);
                         excelFile = surveyService.surveyKpsiExcelList(surveyVO, surveyVOList);
              }else if("Total".equals(docId)){
		      			 surveyTotalVO.setStart(0);
		      			 surveyTotalVO.setLimit(60000);
		      			 excelFile = surveyService.surveyTotalExcelList(surveyTotalVO, surveyTotalVOList);
      		}
              return new ModelAndView("download", "download", excelFile);
    }
	
	@RequestMapping("/medical/survey/deleteSurveyAnswer.do")
	public ModelAndView deleteSurveyAnswer(HttpSession session, @RequestBody SurveyListVO surveyList) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		try {
			for(SurveyVO surveyVO : surveyList.getSurveyList()) {
				String docId = surveyVO.getDocId();
				surveyService.deleteSurveyAnswer(surveyVO);
				if(StringUtil.isEquals("Total", docId)) {
				surveyService.deleteSurveyTotalPm(surveyVO);
				surveyService.updateSurveyPerformMstTotal(surveyVO);
				}else if(!StringUtil.isEquals("Total", docId) && !StringUtil.isEquals("PRDV1", docId)){
					surveyVO.setDocId(docId);
					surveyService.updateSurveyPerformMst(surveyVO);
				}
			}
			modelMap.put("success", true);
		}catch(Exception e) {
			modelMap.put("success", true);
			e.printStackTrace();
		}
		
		return new ModelAndView("jsonView", modelMap);
	}
	
	@RequestMapping("/medical/survey/surveyExcelUpload.do")
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
				euTf = surveyService.surveyFileUpload(session, excelUploadFile, request, oDocFileVO, taskId);
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
	
}
