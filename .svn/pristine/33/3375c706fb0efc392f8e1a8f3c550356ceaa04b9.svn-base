package medical.target.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import medical.common.service.PerformTermVO;
import medical.framework.file.ExcelFile;
import medical.imagingInfo.service.DocFileVO;

public interface TargetService {
	
	
	
	List<TargetVO> selectTargetList(TargetVO targetVO);
	
	int selectTargetListTotal(TargetVO targetVO);
	
	ExcelFile targetExcelDownload(TargetVO targetVO);
	ExcelFile targetExcelDownload2(TargetVO targetVO); //연구번호 분리
	
	int targetExcelUpload(HttpSession session, File file) throws Exception;
	
	int deleteTargetId(HttpSession session, TargetListVO targetListVO);
	
	boolean targetFileUpload(HttpSession session, MultipartFile file, 
			HttpServletRequest request, DocFileVO oDocFileVO) throws Exception;
	
	List<TargetVO> selectTargetFollowUpList(TargetVO targetVO); 
	int updateTargetList(TargetVO targetVO);
	int updateNextVisitDate(TargetVO targetVO);
	int updateTargetRemarks(TargetVO targetVO);

	List<TargetVO> selectTargetCntMax(TargetVO targetVO);

	int selectPerformCntMax(TargetVO targetVO);

	int deletePerformTerm(PerformTermVO tvo, HttpSession session);

	int updateRemarksDataDtl(TargetVO targetVO);

}
