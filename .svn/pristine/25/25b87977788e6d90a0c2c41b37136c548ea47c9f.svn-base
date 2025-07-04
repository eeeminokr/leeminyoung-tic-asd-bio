package medical.analysis.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import medical.framework.file.ExcelFile;
import medical.imagingInfo.service.DocFileVO;
import medical.neuropsy.service.NeuropsyVO;
import medical.surveyAsd.service.SurveyAsdTotalVO;
import medical.surveyAsd.service.SurveyAsdVO;


public interface AnalysisService {
	
	List<AnalysisTAnalEnvMattVO> selectTAnalEnvMattList(AnalysisVO analysisVO);
	List<AnalysisTAnalEnvMattBlVO> selectTAnalEnvMattBlList(AnalysisVO analysisVO);
	
	
	

	//List<AnalysisTAnalSnpVO> selectTAnalSnpList(AnalysisVO analysisVO);
	
	List<AnalysisVO> selectAnalysisMenuList(AnalysisVO analysisVO);
	
	
	int selectTAnalEnvMattListTotal(AnalysisVO analysisVO);
	int selectTAnalEnvMattBlListTotal(AnalysisVO analysisVO);

	//int selectTAnalSnpListTotal(AnalysisVO analysisVO);
	
	
	boolean analysisFileUpload(HttpSession session, MultipartFile excelUploadFile, HttpServletRequest request,
			DocFileVO oDocFileVO);
	
	
	//ExcelFile analysisTotalExcelList(AnalysisTotalVO analysisTotalVO, List<AnalysisTotalVO> analysisTotalVOList);
	ExcelFile analysisEnvMattExcelList(AnalysisVO analysisVO, List<AnalysisVO> analysisVOList);
	ExcelFile analysisEnvMattBlExcelList(AnalysisVO analysisVO, List<AnalysisVO> analysisVOList);
	
	
	
	//ExcelFile analysisSnpExcelList(AnalysisVO analysisVO, List<AnalysisVO> analysisVOList);
	ExcelFile analysisTotalExcelList(AnalysisTotalVO analysisTotalVO, List<AnalysisTotalVO> analysisTotalVOList);
	
	int deleteAnalysisEnvMatt(AnalysisVO analysisVO);
	int deleteAnalysisEnvMattBl(AnalysisVO analysisVO);

	//int deleteAnalysisSnp(AnalysisVO analysisVO);
	
	List<AnalysisTotalVO> selectTAnalTotalList(AnalysisTotalVO analysisTotalVO);
	
	int selectTAnalTotalListTotal(AnalysisTotalVO analysisTotalVO);
	
	
}
