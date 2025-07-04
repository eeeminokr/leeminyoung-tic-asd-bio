package medical.gene.service;

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


public interface GeneService {
	

	
	
	
	List<TAnalGenVO> selectTAnalGenList(GeneVO geneVO);
	
	
	List<GeneVO> selectGeneMenuList(GeneVO geneVO);
	
	
	
	int selectTAnalGenListTotal(GeneVO geneVO);

	
	boolean GeneFileUpload(HttpSession session, MultipartFile excelUploadFile, HttpServletRequest request,
			DocFileVO oDocFileVO);
	
	
	//ExcelFile analysisTotalExcelList(AnalysisTotalVO analysisTotalVO, List<AnalysisTotalVO> analysisTotalVOList);
	
	ExcelFile GeneExcelList(GeneVO geneVO, List<GeneVO>geneVOList);
	ExcelFile GeneTotalExcelList(GeneTotalVO analysisTotalVO, List<GeneTotalVO> analysisTotalVOList);
	
	
	int deleteGene(GeneVO geneVO);

	
	List<GeneTotalVO> selectGeneTotalList(GeneTotalVO geneTotalVO);
	int selectGeneTotalListTotal(GeneTotalVO geneTotalVO);








	
	
}
