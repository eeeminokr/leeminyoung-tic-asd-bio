package medical.neuropsy.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import medical.framework.file.ExcelFile;
import medical.imagingInfo.service.DocFileVO;

public interface NeuropsyService {
	
	
	List<NeuropsyVO> selectNeuropsyMenuList(NeuropsyVO neuropsyVO);
	
	List<NeuropsyS1VO> selectNeuropsyS1List(NeuropsyVO neuropsyVO);
	
	List<NeuropsyS1VO> selectNeuropsyS1RowList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyS1ListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyS1ExcelDownload(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyS1ExcelDownload2(NeuropsyVO neuropsyVO);
	
	List<NeuropsyAtaVO> selectNeuropsyAtaList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyAtaListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyAtaExcelDownload(NeuropsyVO neuropsyVO);
	
	List<NeuropsyStroopVO> selectNeuropsyStroopList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyStroopListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyStroopExcelDownload(NeuropsyVO neuropsyVO);
	
	List<NeuropsyCcttVO> selectNeuropsyCcttList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyCcttListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyCcttExcelDownload(NeuropsyVO neuropsyVO);
	
	List<NeuropsyWsctVO> selectNeuropsyWsctList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyWsctListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyWsctExcelDownload(NeuropsyVO neuropsyVO);
	
	List<NeuropsyCatVO> selectNeuropsyCatList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyCatListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyCatExcelDownload(NeuropsyVO neuropsyVO);
	
	List<NeuropsyExitiiVO> selectNeuropsyExitiiList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyExitiiListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyExitiiExcelDownload(NeuropsyVO neuropsyVO);
	
	List<NeuropsyCptVO> selectNeuropsyCptList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyCptListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyCptExcelDownload(NeuropsyVO neuropsyVO);
	
	List<NeuropsyTmtVO> selectNeuropsyTmtList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyTmtListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyTmtExcelDownload(NeuropsyVO neuropsyVO);
	
	public int neuropsyExcelUpload(File file,HttpSession session) throws Exception;
	
	List<NeuropsyTotalVO> selectNeuropsyTotalList(NeuropsyVO neuropsyVO);
	
	int selectNeuropsyTotalListTotal(NeuropsyVO neuropsyVO);
	
	ExcelFile neuropsyTotalExcelDownload(NeuropsyVO neuropsyVO);
	
	String selectPerformCntByNm(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyS1(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyAta(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyStroop(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyCctt(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyWsct(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyCat(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyExitii(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyCpt(NeuropsyVO neuropsyVO);
	
	int deleteNeuropsyTmt(NeuropsyVO neuropsyVO);
	
	boolean neuropsyFileUpload(HttpSession session, MultipartFile file, 
			HttpServletRequest request, DocFileVO oDocFileVO) throws Exception;

	List<NeuropsyPepVO> selectNeuropsyPepList(NeuropsyVO neuropsyVO);

	int selectNeuropsyPepListTotal(NeuropsyVO neuropsyVO);

	List<NeuropsyAdos1VO> selectNeuropsyAdos1List(NeuropsyVO neuropsyVO);

	int selectNeuropsyAdos1ListTotal(NeuropsyVO neuropsyVO);

	List<NeuropsyAdos2VO> selectNeuropsyAdos2List(NeuropsyVO neuropsyVO);

	int selectNeuropsyAdos2ListTotal(NeuropsyVO neuropsyVO);

//	List<NeuropsyAdos3VO> selectNeuropsyAdos3List(NeuropsyVO neuropsyVO);

//	int selectNeuropsyAdos3ListTotal(NeuropsyVO neuropsyVO);

	List<NeuropsySmsVO> selectNeuropsySmsList(NeuropsyVO neuropsyVO);

	int selectNeuropsySmsListTotal(NeuropsyVO neuropsyVO);

	List<NeuropsyCarsVO> selectNeuropsyCarsList(NeuropsyVO neuropsyVO);

	int selectNeuropsyCarsListTotal(NeuropsyVO neuropsyVO);

	int selectNeuropsyS1AsdListTotal(NeuropsyVO neuropsyVO);

	List<NeuropsyS1VO> selectNeuropsyS1AsdList(NeuropsyVO neuropsyVO);

	/*연구/질환 ============================*/
	ExcelFile neuropsyAdos1ExcelDownload(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyAdos2ExcelDownload(NeuropsyVO neuropsyVO);
//	ExcelFile neuropsyAdos3ExcelDownload(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyPepExcelDownload(NeuropsyVO neuropsyVO);
	ExcelFile neuropsySmsExcelDownload(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyCarsExcelDownload(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyAtaExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyStroopExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyCcttExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyWsctExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyCatExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyExitiiExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyCptExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyTmtExcelDownload2(NeuropsyVO neuropsyVO);
	ExcelFile neuropsyTotalExcelDownload2(NeuropsyVO neuropsyVO);
	/*====================================*/

	int deleteNeuropsyAdos1(NeuropsyVO neuropsyVO);

	int deleteNeuropsyAdos2(NeuropsyVO neuropsyVO);

//	int deleteNeuropsyAdos3(NeuropsyVO neuropsyVO);

	int deleteNeuropsyPep(NeuropsyVO neuropsyVO);

	int deleteNeuropsySms(NeuropsyVO neuropsyVO);

	int deleteNeuropsyCars(NeuropsyVO neuropsyVO);

	int deleteS1IKLeiter(NeuropsyVO neuropsyVO);
	
}
