package medical.clinician.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import medical.framework.file.ExcelFile;
import medical.imagingInfo.service.DocFileVO;
import medical.neuropsy.service.NeuropsyS1VO;
import medical.neuropsy.service.NeuropsyVO;
import medical.surveyAsd.service.SurveyAsdCybocsVO;
import medical.surveyAsd.service.SurveyAsdSrs01VO;
import medical.surveyAsd.service.SurveyAsdTotalVO;
import medical.surveyAsd.service.SurveyAsdVO;
import medical.surveyAsd.service.SurveyAsdYbocsVO;


public interface ClinicianService {
	int deleteS1IKLeiter( ClinicianVO clinicianVO);
	int deleteClinicianAsdAnswer(ClinicianVO clinicianVO);
	int deleteClinicianAsdTotalPm(ClinicianVO clinicianVO);
	int updateClinicianAsdPerformMstTotal(ClinicianVO clinicianVO);
	int updateClinicianAsdPerformMst(ClinicianVO clinicianVO);
	
	int deleteClinicianS1(ClinicianVO clinicianVO);

	
	ExcelFile clinicianTotalExcelList(ClinicianTotalVO clinicianTotalVO, List<ClinicianTotalVO> ClinicianTotalVOList);
	ExcelFile clinicianAsdSrs01ExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList);
	ExcelFile clinicianAsdCybocsExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList);
	
	
	       
	ExcelFile clinicianAsdYbocsExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList);
	ExcelFile clinicianAsdS1ExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList);
	
	
	List<ClinicianVO> selectClinicianMenuList(ClinicianVO clinicianVO);
	
	String selectDocNmByDocId(ClinicianVO clinicianVO);
	
	String selectPerformCntByNm(ClinicianVO clinicianVO);
	
	List<ClinicianVO> selectPerformCntList(ClinicianVO clinicianVO);
	
	List<ClinicianTotalVO> selectClinicianTotalList(ClinicianVO clinicianVO);
	
	List<ClinicianTotalVO> selectClinicianTotalList(ClinicianTotalVO clinicianTotalVO);
	
	
	
	
	int selectClinicianDtlListTotal(ClinicianVO clinicianVO);
	
	
	//List<ClinicianVO> selectClinicianDtlList(ClinicianVO clinicianVO);
	
	
	
	
	int selectClinicianTotalListTotal(ClinicianVO clinicianVO);
	
	int selectClinicianTotalListTotal(ClinicianTotalVO clinicianTotalVO);
	
    List<ClinicianS1VO> selectClinicianS1List(ClinicianVO clinicianVO);
	
	List<ClinicianS1VO> selectClinicianS1RowList(ClinicianVO clinicianVO);
	
	List<ClinicianAsdSrs01VO> selectClinicianSrs01List(ClinicianVO clinicianVO);

	List<ClinicianAsdCybocsVO> selectClinicianCybocsList(ClinicianVO clinicianVO) throws Exception;

	List<ClinicianAsdYbocsVO> selectClinicianYbocsList(ClinicianVO clinicianVO);
	
	int selectClinicianS1ListTotal(ClinicianVO clinicianVO);
	
	int selectClinicianS1AsdListTotal(ClinicianVO clinicianVO);
	
	List<ClinicianS1VO> selectClinicianS1AsdList(ClinicianVO clinicianVO);

	

	
	
	
	boolean clinicianFileUpload(HttpSession session, MultipartFile excelUploadFile, HttpServletRequest request,
			DocFileVO oDocFileVO, String taskId) throws Exception;
	
	
	
	
	
	
	
}
