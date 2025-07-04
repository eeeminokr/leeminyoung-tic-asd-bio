package medical.survey.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import medical.framework.file.ExcelFile;
import medical.imagingInfo.service.DocFileVO;

public interface SurveyService {
	boolean surveyFileUpload(HttpSession session, MultipartFile file, 
			HttpServletRequest request, DocFileVO oDocFileVO, String taskId) throws Exception;
	int surveyExcelUpload(File file, String taskId) throws Exception;
	int surveyExcelCvUpload(File file) throws Exception;
	int surveyExcelIv4Upload(File file) throws Exception;
	int surveyExcelSrsUpload(File file) throws Exception;
	int surveyExcelYgtssUpload(File file) throws Exception;
//	int surveyExcelCybocsUpload(File file) throws Exception;
	int surveyExcelYbocsUpload(File file) throws Exception;
	int surveyExcelYbocaUpload(File file) throws Exception;
	int surveyExcelArsUpload(File file) throws Exception;
	int surveyExcelKcbclUpload(File file) throws Exception;
	int surveyExcelCbclUpload(File file) throws Exception;
	int surveyExcelDbdsUpload(File file) throws Exception;
	int surveyExcelCmrspUpload(File file) throws Exception;
	int surveyExcelTraumaUpload(File file) throws Exception;
	int surveyExcelCdiChildUpload(File file) throws Exception;
	int surveyExcelIatUpload(File file) throws Exception;
	int surveyExcelKcriterionUpload(File file) throws Exception;
	int surveyExcelRcmasUpload(File file) throws Exception;
	int surveyExcelStaitChildUpload(File file) throws Exception;
	int surveyExcelStaisChildUpload(File file) throws Exception;
	int surveyExcelStaisYouthUpload(File file) throws Exception;
	int surveyExcelStaitYouthUpload(File file) throws Exception;
	int surveyExcelLoicvUpload(File file) throws Exception;
	int surveyExcelKbis11rUpload(File file) throws Exception;
	int surveyExcelBdiParentsUpload(File file) throws Exception;
	int surveyExcelStaitParentsUpload(File file) throws Exception;
	int surveyExcelStaisParentsUpload(File file) throws Exception;
	int surveyExcelMbriUpload(File file) throws Exception;
	int surveyExcelKaadhdsUpload(File file) throws Exception;
	int surveyExcelKpsiUpload(File file) throws Exception;
	int surveyExcelPrdvUpload(File file) throws Exception;
	
	int deleteSurveyAnswer(SurveyVO surveyVO);
	String selectDocNmByDocId(SurveyVO surveyVO);
	
	ExcelFile surveyArsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveySrsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyYgtssExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
//    ExcelFile surveyCybocsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyYbocsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyYbocaExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyKcbclExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
//    ExcelFile surveyCbclExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyDbdsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyCmrspExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyTraumaExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyCdiChildExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyIatExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyKscalExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyRcmasExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyStaitChildExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyStaisChildExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyStaitYouthExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyStaisYouthExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyStaitParentsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyStaisParentsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyLoicvExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyKbis11rExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyBdiParentsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyMbriExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyKaadhdsExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyKpsiExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyPrdvExcelList(SurveyVO surveyVO, List<SurveyVO> SurveyListVO);
    ExcelFile surveyTotalExcelList(SurveyTotalVO surveyTotalVO, List<SurveyTotalVO> surveyTotalListVO);
	
	int selectSurveyDtlListTotal(SurveyVO surveyVO);
	List<SurveyVO> selectSurveyMenuList(SurveyVO surveyVO);
	List<SurveyVO> selectSurveyDtlList(SurveyVO surveyVO);
	List<SurveyVO> selectPerformCntList(SurveyVO surveyVO);
	List<SurveyArsVO> selectSurveyArsList(SurveyVO surveyVO);
	List<SurveySrsVO> selectSurveySrsList(SurveyVO surveyVO);
	List<SurveyYgtssVO> selectSurveyYgtssList(SurveyVO surveyVO);
//	List<SurveyCybocsVO> selectSurveyCybo1List(SurveyVO surveyVO);
	List<SurveyYbocsVO> selectSurveyYbocsList(SurveyVO surveyVO);
	List<SurveyKcbclVO> selectSurveyKcbclList(SurveyVO surveyVO);
	List<SurveyKcriterionVO> selectSurveyKscalList(SurveyVO surveyVO);
	List<SurveyPrdvVO> selectSurveyPrdvList(SurveyVO surveyVO);
//	List<SurveyCbclVO> selectSurveyCbcl1List(SurveyVO surveyVO);
	List<SurveyDbdsVO> selectSurveyDbds1List(SurveyVO surveyVO);
	List<SurveyCmrspVO> selectSurveyCmrspList(SurveyVO surveyVO);
	List<SurveyTraumaVO> selectSurveyTraumList(SurveyVO surveyVO);
	List<SurveyCdiChildVO> selectSurveyCdi01List(SurveyVO surveyVO);
	List<SurveyIatVO> selectSurveyIat01List(SurveyVO surveyVO);
	List<SurveyRcmasVO> selectSurveyRcmasList(SurveyVO surveyVO);
	List<SurveyStaitChildVO> selectSurveyStitcList(SurveyVO surveyVO);
	List<SurveyStaisChildVO> selectSurveyStiscList(SurveyVO surveyVO);
	List<SurveyStaitYouthVO> selectSurveyStityList(SurveyVO surveyVO);
	List<SurveyStaisYouthVO> selectSurveyStisyList(SurveyVO surveyVO);
	List<SurveyStaitParentsVO> selectSurveyStitpList(SurveyVO surveyVO);
	List<SurveyStaisParentsVO> selectSurveyStispList(SurveyVO surveyVO);
	List<SurveyLoicvVO> selectSurveyLoicvList(SurveyVO surveyVO);
	List<SurveyKbis11rVO> selectSurveyKbis1List(SurveyVO surveyVO);
	List<SurveyBdiParentsVO> selectSurveyBdi01List(SurveyVO surveyVO);
	List<SurveyMbriVO> selectSurveyMbri1List(SurveyVO surveyVO);
	List<SurveyKaadhdsVO> selectSurveyKadhdList(SurveyVO surveyVO);
	List<SurveyKpsiVO> selectSurveyKpsi1List(SurveyVO surveyVO);
	List<SurveyTotalVO> selectSurveyTotalList(SurveyTotalVO surveyTotalVO);
	int selectSurveyTotalListTotal(SurveyTotalVO surveyTotalVO);
	int deleteSurveyTotalPm(SurveyVO surveyVO);
	int updateSurveyPerformMstTotal(SurveyVO surveyVO);
	int updateSurveyPerformMst(SurveyVO surveyVO);
	List<SurveyYbocaVO> selectSurveyYbocaList(SurveyVO surveyVO);
	int selectSurveyKcbclListTotal(SurveyVO surveyVO);
	
}
