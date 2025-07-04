package medical.surveyAsd.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import medical.framework.file.ExcelFile;
import medical.imagingInfo.service.DocFileVO;

public interface SurveyAsdService {
	
	int deleteSurveyAsdAnswer(SurveyAsdVO surveyAsdVO);
	//int deleteSurveyAsdTotalPm(SurveyAsdVO suSrveyAsdVO);
	int updateSurveyAsdPerformMstTotal(SurveyAsdVO surveyAsdVO);
	int updateSurveyAsdPerformMst(SurveyAsdVO surveyAsdVO);
	
	ExcelFile surveyAsdTotalExcelList(SurveyAsdTotalVO surveyAsdTotalVO, List<SurveyAsdTotalVO> surveyTotalVOList);
	ExcelFile surveyAsdCbcl2ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdOcb15ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdCbc15ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdPrdvExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdSrs01ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdCybocsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdYbocsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdKmchatExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdOldCbclExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdArsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdTraumaExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdCdiChildExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdStaitChildExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdStaisChildExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdIatExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdKcriterionExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdRcmasExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdBdiParentsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdStaitParentsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdStaisParentsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdMbriExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdKpsiExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdSib01ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdBpi01ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdSrs03ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdScqExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdAbc01ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdLsd01ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdBdi02ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdCc3qcExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdCc3qaExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdSsis1ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdTrauaExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdPp3q1ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdPc3q1ExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdKasdsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdCmrspExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdQpgsrExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdGsrsExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdKcshqExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdKcriterionAdultExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	ExcelFile surveyAsdCpclExcelList(SurveyAsdVO surveyAsdVO, List<SurveyAsdVO> surveyVOList);
	
	int selectSurveyTotalListAoTotal(SurveyAsdTotalVO surveyAsdTotalVO);

	List<SurveyAsdTotalVO> selectSurveyTotalListAo(SurveyAsdTotalVO surveyAsdTotalVO);

	List<SurveyAsdVO> selectPerformCntList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdVO> selectSurveyMenuList(SurveyAsdVO surveyAsdVO);

	String selectDocNmByDocId(SurveyAsdVO surveyAsdVO);

	int selectSurveyDtlListTotal(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdPrdvVO> selectSurveyPrdvList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdCybocsVO> selectSurveyCybocsList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdKmchatVO> selectSurveyKmchatList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdOldCbclVO> selectSurveyOldCbclList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdCbcl2VO> selectSurveyCbcl2List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdOcb15VO> selectSurveyOcb15List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdCbc15VO> selectSurveyCbc15List(SurveyAsdVO surveyAsdVO);
	
	boolean surveyFileUpload(HttpSession session, MultipartFile excelUploadFile, HttpServletRequest request,
			DocFileVO oDocFileVO, String taskId) throws Exception;

	List<SurveyAsdSrs01VO> selectSurveySrs01List(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdYbocsVO> selectSurveyYbocsList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdTraumaVO> selectSurveyTraumList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdCdiChildVO> selectSurveyCdi01List(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdStaitChildVO> selectSurveyStitcList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdStaisChildVO> selectSurveyStiscList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdArsVO> selectSurveyArsList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdIatVO> selectSurveyIatList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdKcriterionVO> selectSurveyKscalList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdRcmasVO> selectSurveyRcmasList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdBdiParentsVO> selectSurveyBdi01List(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdStaitParentsVO> selectSurveyStitpList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdStaisParentsVO> selectSurveyStispList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdMbriVO> selectSurveyMbriList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdKpsiVO> selectSurveyKpsiList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdSib01VO> selectSurveySib01List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdBpi01VO> selectSurveyBpi01List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdBdi02VO> selectSurveyBdi02List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdCc3qcVO> selectSurveyCc3qcList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdCc3qaVO> selectSurveyCc3qaList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdSrs03VO> selectSurveySrs03List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdScqVO> selectSurveyScqList(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdLsd01VO> selectSurveyLsd01List(SurveyAsdVO surveyAsdVO);

	List<SurveyAsdAbc01VO> selectSurveyAbc01List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdSsis1VO> selectSurveySsis1List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdTrauaVO> selectSurveyTrauaList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdPp3q1VO> selectSurveyPp3q1List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdPc3q1VO> selectSurveyPc3q1List(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdKasdsVO> selectSurveyKasdsList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdCmrspVO> selectSurveyCmrspList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdQpgsrVO> selectSurveyQpgsrList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdGsrsVO> selectSurveyGsrsList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdKcshqVO> selectSurveyKcshqList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdKcriterionAdultVO> selectSurveyKscaleAdultList(SurveyAsdVO surveyAsdVO);
	
	List<SurveyAsdCpclVO> selectSurveyCpclList(SurveyAsdVO surveyAsdVO);
	
}
