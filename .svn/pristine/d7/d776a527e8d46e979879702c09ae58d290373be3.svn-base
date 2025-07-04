package medical.neuropsy.service.impl;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import medical.common.service.AbstractService;
import medical.commoninfo.member.service.MemberVO;
import medical.framework.exception.BizException;
import medical.framework.file.ExcelFile;
import medical.framework.file.ExcelFileReader;
import medical.framework.file.ExcelFileWriter;
import medical.framework.util.Constant;
import medical.framework.util.FileUtils;
import medical.framework.util.ResourceBundleUtil;
import medical.framework.util.StringUtil;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.UploadExcelVO;
import medical.imagingInfo.service.impl.ImagingInfoDAO;
import medical.neuropsy.service.NeuropsyAdos1VO;
import medical.neuropsy.service.NeuropsyAdos2VO;
import medical.neuropsy.service.NeuropsyAdos3VO;
import medical.neuropsy.service.NeuropsyAtaVO;
import medical.neuropsy.service.NeuropsyCarsVO;
import medical.neuropsy.service.NeuropsyCatVO;
import medical.neuropsy.service.NeuropsyCcttVO;
import medical.neuropsy.service.NeuropsyCptVO;
import medical.neuropsy.service.NeuropsyExitiiVO;
import medical.neuropsy.service.NeuropsyPepVO;
import medical.neuropsy.service.NeuropsyS1VO;
import medical.neuropsy.service.NeuropsyService;
import medical.neuropsy.service.NeuropsySmsVO;
import medical.neuropsy.service.NeuropsyStroopVO;
import medical.neuropsy.service.NeuropsyTmtVO;
import medical.neuropsy.service.NeuropsyTotalVO;
import medical.neuropsy.service.NeuropsyVO;
import medical.neuropsy.service.NeuropsyWsctVO;

@Service("NeuropsyService")
public class NeuropsyServiceImpl extends AbstractService implements NeuropsyService{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/** DAO Class */
	@Resource(name = "NeuropsyDAO")
	private NeuropsyDAO neuropsyDAO;
	@Resource(name = "ImagingInfoDAO")
	ImagingInfoDAO oImagingInfoDAO;
	@Autowired
	PlatformTransactionManager transactionManager;
	
	
	private ExcelFileWriter<NeuropsyS1VO> neuropsyS1ExcelFileWriter;
	private ExcelFileWriter<NeuropsyS1VO> neuropsyS1ExcelFileWriter2; //뇌원천 ASD
	private ExcelFileWriter<NeuropsyAtaVO> neuropsyAtaExcelFileWriter;
	private ExcelFileWriter<NeuropsyStroopVO> neuropsyStroopExcelFileWriter;
	private ExcelFileWriter<NeuropsyCcttVO> neuropsyCcttExcelFileWriter;
	private ExcelFileWriter<NeuropsyWsctVO> neuropsyWsctExcelFileWriter;
	private ExcelFileWriter<NeuropsyCatVO> neuropsyCatExcelFileWriter;
	private ExcelFileWriter<NeuropsyExitiiVO> neuropsyExitiiExcelFileWriter;
	private ExcelFileWriter<NeuropsyCptVO> neuropsyCptExcelFileWriter;
	private ExcelFileWriter<NeuropsyTmtVO> neuropsyTmtExcelFileWriter;
	private ExcelFileWriter<NeuropsyTotalVO> neuropsyTotalExcelFileWriter;
	private ExcelFileWriter<NeuropsyAdos1VO> neuropsyAdos1ExcelFileWriter;
	private ExcelFileWriter<NeuropsyAdos2VO> neuropsyAdos2ExcelFileWriter;
//	private ExcelFileWriter<NeuropsyAdos3VO> neuropsyAdos3ExcelFileWriter;
	private ExcelFileWriter<NeuropsyPepVO> neuropsyPepExcelFileWriter;
	private ExcelFileWriter<NeuropsySmsVO> neuropsySmsExcelFileWriter;
	private ExcelFileWriter<NeuropsyCarsVO> neuropsyCarsExcelFileWriter;
	
	private ExcelFileReader<NeuropsyS1VO> neuropsyS1FileReader;
	private ExcelFileReader<NeuropsyAtaVO> neuropsyAtaFileReader;
	private ExcelFileReader<NeuropsyStroopVO> neuropsyStroopFileReader;
	private ExcelFileReader<NeuropsyCcttVO> neuropsyCcttFileReader;
	private ExcelFileReader<NeuropsyWsctVO> neuropsyWsctFileReader;
	private ExcelFileReader<NeuropsyCatVO> neuropsyCatFileReader;
	private ExcelFileReader<NeuropsyExitiiVO> neuropsyExitiiFileReader;
	private ExcelFileReader<NeuropsyCptVO> neuropsyCptFileReader;
	private ExcelFileReader<NeuropsyTmtVO> neuropsyTmtFileReader;
	private ExcelFileReader<NeuropsyS1VO> neuropsyS1AsdFileReader;
	private ExcelFileReader<NeuropsyAdos1VO> neuropsyAdos1FileReader;
	private ExcelFileReader<NeuropsyAdos2VO> neuropsyAdos2FileReader;
//	private ExcelFileReader<NeuropsyAdos3VO> neuropsyAdos3FileReader;
	private ExcelFileReader<NeuropsyPepVO> neuropsyPepFileReader;
	private ExcelFileReader<NeuropsySmsVO> neuropsySmsFileReader;
	private ExcelFileReader<NeuropsyCarsVO> neuropsyCarsFileReader;
	
	//==================================
	private ExcelFileWriter<NeuropsyAtaVO> neuropsyAtaExcelFileWriter2;
	private ExcelFileWriter<NeuropsyStroopVO> neuropsyStroopExcelFileWriter2;
	private ExcelFileWriter<NeuropsyCcttVO> neuropsyCcttExcelFileWriter2;
	private ExcelFileWriter<NeuropsyWsctVO> neuropsyWsctExcelFileWriter2;
	private ExcelFileWriter<NeuropsyCatVO> neuropsyCatExcelFileWriter2;
	private ExcelFileWriter<NeuropsyExitiiVO> neuropsyExitiiExcelFileWriter2;
	private ExcelFileWriter<NeuropsyCptVO> neuropsyCptExcelFileWriter2;
	private ExcelFileWriter<NeuropsyTmtVO> neuropsyTmtExcelFileWriter2;
	private ExcelFileWriter<NeuropsyTotalVO> neuropsyTotalExcelFileWriter2;
	
	private ExcelFileReader<NeuropsyAtaVO> neuropsyAtaFileReader2;
	private ExcelFileReader<NeuropsyStroopVO> neuropsyStroopFileReader2;
	private ExcelFileReader<NeuropsyCcttVO> neuropsyCcttFileReader2;
	private ExcelFileReader<NeuropsyWsctVO> neuropsyWsctFileReader2;
	private ExcelFileReader<NeuropsyCatVO> neuropsyCatFileReader2;
	private ExcelFileReader<NeuropsyExitiiVO> neuropsyExitiiFileReader2;
	private ExcelFileReader<NeuropsyCptVO> neuropsyCptFileReader2;
	private ExcelFileReader<NeuropsyTmtVO> neuropsyTmtFileReader2;
	
	public void setNeuropsyAtaExcelFileWriter2(ExcelFileWriter<NeuropsyAtaVO> neuropsyAtaExcelFileWriter2) {
		this.neuropsyAtaExcelFileWriter2 = neuropsyAtaExcelFileWriter2;
	}
	public void setNeuropsyStroopExcelFileWriter2(ExcelFileWriter<NeuropsyStroopVO> neuropsyStroopExcelFileWriter2) {
		this.neuropsyStroopExcelFileWriter2 = neuropsyStroopExcelFileWriter2;
	}
	public void setNeuropsyCcttExcelFileWriter2(ExcelFileWriter<NeuropsyCcttVO> neuropsyCcttExcelFileWriter2) {
		this.neuropsyCcttExcelFileWriter2 = neuropsyCcttExcelFileWriter2;
	}
	public void setNeuropsyWsctExcelFileWriter2(ExcelFileWriter<NeuropsyWsctVO> neuropsyWsctExcelFileWriter2) {
		this.neuropsyWsctExcelFileWriter2 = neuropsyWsctExcelFileWriter2;
	}
	public void setNeuropsyCatExcelFileWriter2(ExcelFileWriter<NeuropsyCatVO> neuropsyCatExcelFileWriter2) {
		this.neuropsyCatExcelFileWriter2 = neuropsyCatExcelFileWriter2;
	}
	public void setNeuropsyExitiiExcelFileWriter2(ExcelFileWriter<NeuropsyExitiiVO> neuropsyExitiiExcelFileWriter2) {
		this.neuropsyExitiiExcelFileWriter2 = neuropsyExitiiExcelFileWriter2;
	}
	public void setNeuropsyCptExcelFileWriter2(ExcelFileWriter<NeuropsyCptVO> neuropsyCptExcelFileWriter2) {
		this.neuropsyCptExcelFileWriter2 = neuropsyCptExcelFileWriter2;
	}
	public void setNeuropsyTmtExcelFileWriter2(ExcelFileWriter<NeuropsyTmtVO> neuropsyTmtExcelFileWriter2) {
		this.neuropsyTmtExcelFileWriter2 = neuropsyTmtExcelFileWriter2;
	}
	public void setNeuropsyTotalExcelFileWriter2(ExcelFileWriter<NeuropsyTotalVO> neuropsyTotalExcelFileWriter2) {
		this.neuropsyTotalExcelFileWriter2 = neuropsyTotalExcelFileWriter2;
	}
	
	@Override
	public ExcelFile neuropsyAtaExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyAtaExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyAtaList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyStroopExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyStroopExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyStroopList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyCcttExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyCcttExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyCcttList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyWsctExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyWsctExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyWsctList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyCatExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyCatExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyCatList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyExitiiExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyExitiiExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyExitiiList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyCptExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyCptExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyCptList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyTmtExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyTmtExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyTmtList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyTotalExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyTotalExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyTotalList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public void setNeuropsyAtaFileReader2(ExcelFileReader<NeuropsyAtaVO> neuropsyAtaFileReader2) {
		this.neuropsyAtaFileReader2 = neuropsyAtaFileReader2;
	}
	public void setNeuropsyStroopFileReader2(ExcelFileReader<NeuropsyStroopVO> neuropsyStroopFileReader2) {
		this.neuropsyStroopFileReader2 = neuropsyStroopFileReader2;
	}
	public void setNeuropsyCcttFileReader2(ExcelFileReader<NeuropsyCcttVO> neuropsyCcttFileReader2) {
		this.neuropsyCcttFileReader2 = neuropsyCcttFileReader2;
	}
	public void setNeuropsyWsctFileReader2(ExcelFileReader<NeuropsyWsctVO> neuropsyWsctFileReader2) {
		this.neuropsyWsctFileReader2 = neuropsyWsctFileReader2;
	}
	public void setNeuropsyCatFileReader2(ExcelFileReader<NeuropsyCatVO> neuropsyCatFileReader2) {
		this.neuropsyCatFileReader2 = neuropsyCatFileReader2;
	}
	public void setNeuropsyExitiiFileReader2(ExcelFileReader<NeuropsyExitiiVO> neuropsyExitiiFileReader2) {
		this.neuropsyExitiiFileReader2 = neuropsyExitiiFileReader2;
	}
	public void setNeuropsyCptFileReader2(ExcelFileReader<NeuropsyCptVO> neuropsyCptFileReader2) {
		this.neuropsyCptFileReader2 = neuropsyCptFileReader2;
	}
	public void setNeuropsyTmtFileReader2(ExcelFileReader<NeuropsyTmtVO> neuropsyTmtFileReader2) {
		this.neuropsyTmtFileReader2 = neuropsyTmtFileReader2;
	}
	//==========================================
	
	public void setNeuropsyS1ExcelFileWriter(ExcelFileWriter<NeuropsyS1VO> neuropsyS1ExcelFileWriter) {
		this.neuropsyS1ExcelFileWriter = neuropsyS1ExcelFileWriter;
	}
	public void setNeuropsyS1ExcelFileWriter2(ExcelFileWriter<NeuropsyS1VO> neuropsyS1ExcelFileWriter2) {
		this.neuropsyS1ExcelFileWriter2 = neuropsyS1ExcelFileWriter2;
	}
	public void setNeuropsyAtaExcelFileWriter(ExcelFileWriter<NeuropsyAtaVO> neuropsyAtaExcelFileWriter) {
		this.neuropsyAtaExcelFileWriter = neuropsyAtaExcelFileWriter;
	}
	public void setNeuropsyStroopExcelFileWriter(ExcelFileWriter<NeuropsyStroopVO> neuropsyStroopExcelFileWriter) {
		this.neuropsyStroopExcelFileWriter = neuropsyStroopExcelFileWriter;
	}
	public void setNeuropsyCcttExcelFileWriter(ExcelFileWriter<NeuropsyCcttVO> neuropsyCcttExcelFileWriter) {
		this.neuropsyCcttExcelFileWriter = neuropsyCcttExcelFileWriter;
	}
	public void setNeuropsyWsctExcelFileWriter(ExcelFileWriter<NeuropsyWsctVO> neuropsyWsctExcelFileWriter) {
		this.neuropsyWsctExcelFileWriter = neuropsyWsctExcelFileWriter;
	}
	public void setNeuropsyCatExcelFileWriter(ExcelFileWriter<NeuropsyCatVO> neuropsyCatExcelFileWriter) {
		this.neuropsyCatExcelFileWriter = neuropsyCatExcelFileWriter;
	}
	public void setNeuropsyExitiiExcelFileWriter(ExcelFileWriter<NeuropsyExitiiVO> neuropsyExitiiExcelFileWriter) {
		this.neuropsyExitiiExcelFileWriter = neuropsyExitiiExcelFileWriter;
	}
	public void setNeuropsyCptExcelFileWriter(ExcelFileWriter<NeuropsyCptVO> neuropsyCptExcelFileWriter) {
		this.neuropsyCptExcelFileWriter = neuropsyCptExcelFileWriter;
	}
	public void setNeuropsyTmtExcelFileWriter(ExcelFileWriter<NeuropsyTmtVO> neuropsyTmtExcelFileWriter) {
		this.neuropsyTmtExcelFileWriter = neuropsyTmtExcelFileWriter;
	}
	public void setNeuropsyTotalExcelFileWriter(ExcelFileWriter<NeuropsyTotalVO> neuropsyTotalExcelFileWriter) {
		this.neuropsyTotalExcelFileWriter = neuropsyTotalExcelFileWriter;
	}
	
	public void setNeuropsyAdos1ExcelFileWriter(ExcelFileWriter<NeuropsyAdos1VO> neuropsyAdos1ExcelFileWriter) {
		this.neuropsyAdos1ExcelFileWriter = neuropsyAdos1ExcelFileWriter;
	}
	public void setNeuropsyAdos2ExcelFileWriter(ExcelFileWriter<NeuropsyAdos2VO> neuropsyAdos2ExcelFileWriter) {
		this.neuropsyAdos2ExcelFileWriter = neuropsyAdos2ExcelFileWriter;
	}
//	public void setNeuropsyAdos3ExcelFileWriter(ExcelFileWriter<NeuropsyAdos3VO> neuropsyAdos3ExcelFileWriter) {
//		this.neuropsyAdos3ExcelFileWriter = neuropsyAdos3ExcelFileWriter;
//	}
	public void setNeuropsyPepExcelFileWriter(ExcelFileWriter<NeuropsyPepVO> neuropsyPepExcelFileWriter) {
		this.neuropsyPepExcelFileWriter = neuropsyPepExcelFileWriter;
	}
	public void setNeuropsySmsExcelFileWriter(ExcelFileWriter<NeuropsySmsVO> neuropsySmsExcelFileWriter) {
		this.neuropsySmsExcelFileWriter = neuropsySmsExcelFileWriter;
	}
	public void setNeuropsyCarsExcelFileWriter(ExcelFileWriter<NeuropsyCarsVO> neuropsyCarsExcelFileWriter) {
		this.neuropsyCarsExcelFileWriter = neuropsyCarsExcelFileWriter;
	}
	
	
	public void setNeuropsyS1FileReader(ExcelFileReader<NeuropsyS1VO> neuropsyS1FileReader) {
		this.neuropsyS1FileReader = neuropsyS1FileReader;
	}
	public void setNeuropsyAtaFileReader(ExcelFileReader<NeuropsyAtaVO> neuropsyAtaFileReader) {
		this.neuropsyAtaFileReader = neuropsyAtaFileReader;
	}
	public void setNeuropsyStroopFileReader(ExcelFileReader<NeuropsyStroopVO> neuropsyStroopFileReader) {
		this.neuropsyStroopFileReader = neuropsyStroopFileReader;
	}
	public void setNeuropsyCcttFileReader(ExcelFileReader<NeuropsyCcttVO> neuropsyCcttFileReader) {
		this.neuropsyCcttFileReader = neuropsyCcttFileReader;
	}
	public void setNeuropsyWsctFileReader(ExcelFileReader<NeuropsyWsctVO> neuropsyWsctFileReader) {
		this.neuropsyWsctFileReader = neuropsyWsctFileReader;
	}
	public void setNeuropsyCatFileReader(ExcelFileReader<NeuropsyCatVO> neuropsyCatFileReader) {
		this.neuropsyCatFileReader = neuropsyCatFileReader;
	}
	public void setNeuropsyExitiiFileReader(ExcelFileReader<NeuropsyExitiiVO> neuropsyExitiiFileReader) {
		this.neuropsyExitiiFileReader = neuropsyExitiiFileReader;
	}
	public void setNeuropsyCptFileReader(ExcelFileReader<NeuropsyCptVO> neuropsyCptFileReader) {
		this.neuropsyCptFileReader = neuropsyCptFileReader;
	}
	public void setNeuropsyTmtFileReader(ExcelFileReader<NeuropsyTmtVO> neuropsyTmtFileReader) {
		this.neuropsyTmtFileReader = neuropsyTmtFileReader;
	}
	public void setNeuropsyS1AsdFileReader(ExcelFileReader<NeuropsyS1VO> neuropsyS1AsdFileReader) {
		this.neuropsyS1AsdFileReader = neuropsyS1AsdFileReader;
	}
	public void setNeuropsyAdos1FileReader(ExcelFileReader<NeuropsyAdos1VO> neuropsyAdos1FileReader) {
		this.neuropsyAdos1FileReader = neuropsyAdos1FileReader;
	}
	public void setNeuropsyAdos2FileReader(ExcelFileReader<NeuropsyAdos2VO> neuropsyAdos2FileReader) {
		this.neuropsyAdos2FileReader = neuropsyAdos2FileReader;
	}
//	public void setNeuropsyAdos3FileReader(ExcelFileReader<NeuropsyAdos3VO> neuropsyAdos3FileReader) {
//		this.neuropsyAdos3FileReader = neuropsyAdos3FileReader;
//	}
	public void setNeuropsyPepFileReader(ExcelFileReader<NeuropsyPepVO> neuropsyPepFileReader) {
		this.neuropsyPepFileReader = neuropsyPepFileReader;
	}
	public void setNeuropsySmsFileReader(ExcelFileReader<NeuropsySmsVO> neuropsySmsFileReader) {
		this.neuropsySmsFileReader = neuropsySmsFileReader;
	}
	public void setNeuropsyCarsFileReader(ExcelFileReader<NeuropsyCarsVO> neuropsyCarsFileReader) {
		this.neuropsyCarsFileReader = neuropsyCarsFileReader;
	}
	
	public List<NeuropsyVO> selectNeuropsyMenuList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyMenuList(neuropsyVO);
	}
	
	public List<NeuropsyS1VO> selectNeuropsyS1List(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyS1List(neuropsyVO);
	}
	
	public List<NeuropsyS1VO> selectNeuropsyS1RowList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyS1RowList(neuropsyVO);
	}
	
	public int selectNeuropsyS1ListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyS1ListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyS1ExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyS1ExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyS1List(neuropsyVO), ExcelFile.XLSX);
	}
	
	public ExcelFile neuropsyS1ExcelDownload2(NeuropsyVO neuropsyVO) {
		return  neuropsyS1ExcelFileWriter2.excelWrite(neuropsyDAO.selectNeuropsyS1AsdList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyAtaVO> selectNeuropsyAtaList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyAtaList(neuropsyVO);
	}
	
	public int selectNeuropsyAtaListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyAtaListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyAtaExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyAtaExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyAtaList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyStroopVO> selectNeuropsyStroopList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyStroopList(neuropsyVO);
	}
	
	public int selectNeuropsyStroopListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyStroopListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyStroopExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyStroopExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyStroopList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyCcttVO> selectNeuropsyCcttList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyCcttList(neuropsyVO);
	}
	
	public int selectNeuropsyCcttListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyCcttListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyCcttExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyCcttExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyCcttList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyWsctVO> selectNeuropsyWsctList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyWsctList(neuropsyVO);
	}
	
	public int selectNeuropsyWsctListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyWsctListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyWsctExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyWsctExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyWsctList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyCatVO> selectNeuropsyCatList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyCatList(neuropsyVO);
	}
	
	public int selectNeuropsyCatListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyCatListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyCatExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyCatExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyCatList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyExitiiVO> selectNeuropsyExitiiList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyExitiiList(neuropsyVO);
	}
	
	public int selectNeuropsyExitiiListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyExitiiListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyExitiiExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyExitiiExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyExitiiList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyCptVO> selectNeuropsyCptList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyCptList(neuropsyVO);
	}
	
	public int selectNeuropsyCptListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyCptListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyCptExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyCptExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyCptList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public List<NeuropsyTmtVO> selectNeuropsyTmtList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyTmtList(neuropsyVO);
	}
	
	public int selectNeuropsyTmtListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyTmtListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyTmtExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyTmtExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyTmtList(neuropsyVO), ExcelFile.XLSX);
	}
	
	boolean dateYn = false;
	
	public int neuropsyExcelUpload(File file,HttpSession session) throws Exception {
		int result = 0;
		NeuropsyVO nVO = new NeuropsyVO();
		//첫번째 RND_ID 가져와서 insert
		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		String rndId = memberVO.getRndId();
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		
		//트랜잭션 시작
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

		try {
			List<NeuropsyS1VO> dataS1List = null;
			if("DS001".equals(disClassDtl)) {
				dataS1List = neuropsyS1FileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataS1List = neuropsyS1AsdFileReader.excelRead(file);
			}
			//S1
			for (NeuropsyS1VO vo : dataS1List) {
				if("".equals(vo.getS1ExecDate()) || "x".equals(vo.getS1ExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getS1ExecDate())) {
					dateYn = true;
					throw new Exception("K-SADS");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyS1(vo);
				
				if("DS003".equals(disClassDtl)) { //지능-K-Leiter
					neuropsyDAO.insertS1IKLeiter(vo);
				}
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setS1ExecDate(vo.getPerformExecDate());
				
				nVO.setNeuropsyKind("S1");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//ATA
			List<NeuropsyAtaVO> dataAtaList = null;
			if("DS001".equals(disClassDtl)) {
				dataAtaList = neuropsyAtaFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataAtaList = neuropsyAtaFileReader2.excelRead(file);
			}
			for (NeuropsyAtaVO vo : dataAtaList) {
				
				if("".equals(vo.getAtaExecDate()) || "x".equals(vo.getAtaExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getAtaExecDate())) {
					dateYn = true;
					throw new Exception("ATA");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyAta(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setAtaExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("ATA");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//STROOP
			List<NeuropsyStroopVO> dataStroopList = null;
			if("DS001".equals(disClassDtl)) {
				dataStroopList = neuropsyStroopFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataStroopList = neuropsyStroopFileReader2.excelRead(file);
			}
			for (NeuropsyStroopVO vo : dataStroopList) {
				
				if("".equals(vo.getStroopExecDate()) || "x".equals(vo.getStroopExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getStroopExecDate())) {
					dateYn = true;
					throw new Exception("STROOP");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyStroop(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setStroopExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("STROOP");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//CCTT
			List<NeuropsyCcttVO> dataCcttList = null;
			if("DS001".equals(disClassDtl)) {
				dataCcttList = neuropsyCcttFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataCcttList = neuropsyCcttFileReader2.excelRead(file);
			}
			for (NeuropsyCcttVO vo : dataCcttList) {
				
				if("".equals(vo.getCcttExecDate()) || "x".equals(vo.getCcttExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getCcttExecDate())) {
					dateYn = true;
					throw new Exception("CCTT");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyCctt(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setCcttExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("CCTT");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//WSCT
			List<NeuropsyWsctVO> dataWsctList = null;
			if("DS001".equals(disClassDtl)) {
				dataWsctList = neuropsyWsctFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataWsctList = neuropsyWsctFileReader2.excelRead(file);
			}
			for (NeuropsyWsctVO vo : dataWsctList) {
				
				if("".equals(vo.getWsctExecDate()) || "x".equals(vo.getWsctExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getWsctExecDate())) {
					dateYn = true;
					throw new Exception("WSCT");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyWsct(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setWsctExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("WSCT");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//CAT
			List<NeuropsyCatVO> dataCatList = null;
			if("DS001".equals(disClassDtl)) {
				dataCatList = neuropsyCatFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataCatList = neuropsyCatFileReader2.excelRead(file);
			}
			for (NeuropsyCatVO vo : dataCatList) {
				
				if("".equals(vo.getCatExecDate()) || "x".equals(vo.getCatExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getCatExecDate())) {
					dateYn = true;
					throw new Exception("CAT");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyCat(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setCatExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("CAT");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//EXIT-II
			List<NeuropsyExitiiVO> dataExitiiList = null;
			if("DS001".equals(disClassDtl)) {
				dataExitiiList = neuropsyExitiiFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataExitiiList = neuropsyExitiiFileReader2.excelRead(file);
			}
			for (NeuropsyExitiiVO vo : dataExitiiList) {
				
				if("".equals(vo.getExitiiExecDate()) || "x".equals(vo.getExitiiExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getExitiiExecDate())) {
					dateYn = true;
					throw new Exception("EXIT-II");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyExitii(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setExitiiExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("EXIT_II");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//CPT
			List<NeuropsyCptVO> dataCptList = null;
			if("DS001".equals(disClassDtl)) {
				dataCptList = neuropsyCptFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataCptList = neuropsyCptFileReader2.excelRead(file);
			}
			for (NeuropsyCptVO vo : dataCptList) {
				
				if("".equals(vo.getCpt3ExecDate()) || "x".equals(vo.getCpt3ExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getCpt3ExecDate())) {
					dateYn = true;
					throw new Exception("CPT");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyCpt(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setCpt3ExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("CPT_3");
				neuropsyDAO.updatePerformMst(nVO);
			}
			//TMT
			List<NeuropsyTmtVO> dataTmtList = null;
			if("DS001".equals(disClassDtl)) {
				dataTmtList = neuropsyTmtFileReader.excelRead(file);
			}else if("DS003".equals(disClassDtl)) {
				dataTmtList = neuropsyTmtFileReader2.excelRead(file);
			}
			for (NeuropsyTmtVO vo : dataTmtList) {
				
				if("".equals(vo.getTmtExecDate()) || "x".equals(vo.getTmtExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getTmtExecDate())) {
					dateYn = true;
					throw new Exception("TMT");
				}
				
				vo.setRndId(rndId);
				neuropsyDAO.insertNeuropsyTmt(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				nVO.setTargetId(vo.getTargetId());
				nVO.setDisClassDtl(disClassDtl);
				nVO.setPerformCntNm(vo.getPerformCntNm());
				nVO.setRndId(rndId);
				nVO.setTmtExecDate(vo.getPerformExecDate());
				nVO.setNeuropsyKind("TMT");
				neuropsyDAO.updatePerformMst(nVO);
			}
			
			if("DS003".equals(disClassDtl)) {
				//ADOS1
				List<NeuropsyAdos1VO> dataAdos1List = neuropsyAdos1FileReader.excelRead(file);
				for (NeuropsyAdos1VO vo : dataAdos1List) {
					
					if("".equals(vo.getAdos1ExecDate()) || "x".equals(vo.getAdos1ExecDate().toLowerCase())) {
						//실시일이 없는 경우 INSERT X
						continue;
					}else if(".".equals(vo.getAdos1ExecDate())) {
						dateYn = true;
						throw new Exception("ADOS1");
					}
					
					vo.setRndId(rndId);
					neuropsyDAO.insertNeuropsyAdos1(vo);
					
					//T_PERFORM_MST 실시일 UPDATE
					nVO.setTargetId(vo.getTargetId());
					nVO.setDisClassDtl(disClassDtl);
					nVO.setPerformCntNm(vo.getPerformCntNm());
					nVO.setRndId(rndId);
					nVO.setAdos1ExecDate(vo.getPerformExecDate());
					nVO.setNeuropsyKind("ADOS1");
					neuropsyDAO.updatePerformMst(nVO);
				}	
				//ADOS2
				List<NeuropsyAdos2VO> dataAdos2List = neuropsyAdos2FileReader.excelRead(file);
				for (NeuropsyAdos2VO vo : dataAdos2List) {
					
					if("".equals(vo.getAdos2ExecDate()) || "x".equals(vo.getAdos2ExecDate().toLowerCase())) {
						//실시일이 없는 경우 INSERT X
						continue;
					}else if(".".equals(vo.getAdos2ExecDate())) {
						dateYn = true;
						throw new Exception("ADOS2");
					}
					
					vo.setRndId(rndId);
					neuropsyDAO.insertNeuropsyAdos2(vo);
					
					//T_PERFORM_MST 실시일 UPDATE
					nVO.setTargetId(vo.getTargetId());
					nVO.setDisClassDtl(disClassDtl);
					nVO.setPerformCntNm(vo.getPerformCntNm());
					nVO.setRndId(rndId);
					nVO.setAdos2ExecDate(vo.getPerformExecDate());
					nVO.setNeuropsyKind("ADOS2");
					neuropsyDAO.updatePerformMst(nVO);
				}	
				//ADOS3
/*
				List<NeuropsyAdos3VO> dataAdos3List = neuropsyAdos3FileReader.excelRead(file);
				for (NeuropsyAdos3VO vo : dataAdos3List) {
					
					if("".equals(vo.getAdos3ExecDate()) || "x".equals(vo.getAdos3ExecDate().toLowerCase())) {
						//실시일이 없는 경우 INSERT X
						continue;
					}else if(".".equals(vo.getAdos3ExecDate())) {
						dateYn = true;
						throw new Exception("ADOS3");
					}
					
					vo.setRndId(rndId);
					neuropsyDAO.insertNeuropsyAdos3(vo);
					
					//T_PERFORM_MST 실시일 UPDATE
					nVO.setTargetId(vo.getTargetId());
					nVO.setDisClassDtl(disClassDtl);
					nVO.setPerformCntNm(vo.getPerformCntNm());
					nVO.setRndId(rndId);
					nVO.setAdos3ExecDate(vo.getPerformExecDate());
					nVO.setNeuropsyKind("ADOS3");
					neuropsyDAO.updatePerformMst(nVO);
				}
*/
				//PEP
				List<NeuropsyPepVO> dataPepList = neuropsyPepFileReader.excelRead(file);
				for (NeuropsyPepVO vo : dataPepList) {
					
					if("".equals(vo.getPepExecDate()) || "x".equals(vo.getPepExecDate().toLowerCase())) {
						//실시일이 없는 경우 INSERT X
						continue;
					}else if(".".equals(vo.getPepExecDate())) {
						dateYn = true;
						throw new Exception("PEP");
					}
					
					vo.setRndId(rndId);
					neuropsyDAO.insertNeuropsyPep(vo);
					
					//T_PERFORM_MST 실시일 UPDATE
					nVO.setTargetId(vo.getTargetId());
					nVO.setDisClassDtl(disClassDtl);
					nVO.setPerformCntNm(vo.getPerformCntNm());
					nVO.setRndId(rndId);
					nVO.setPepExecDate(vo.getPerformExecDate());
					nVO.setNeuropsyKind("PEP");
					neuropsyDAO.updatePerformMst(nVO);
				}
				//SMS
				System.out.println("sms라인까지왔다 ");
				List<NeuropsySmsVO> dataSmsList = neuropsySmsFileReader.excelRead(file);
				for (NeuropsySmsVO vo : dataSmsList) {
					
					if("".equals(vo.getSmsExecDate()) || "x".equals(vo.getSmsExecDate().toLowerCase())) {
						//실시일이 없는 경우 INSERT X
						continue;
					}else if(".".equals(vo.getSmsExecDate())) {
						dateYn = true;
						throw new Exception("SMS");
					}
					
					vo.setRndId(rndId);
					neuropsyDAO.insertNeuropsySms(vo);
					
					//T_PERFORM_MST 실시일 UPDATE
					nVO.setTargetId(vo.getTargetId());
					nVO.setDisClassDtl(disClassDtl);
					nVO.setPerformCntNm(vo.getPerformCntNm());
					nVO.setRndId(rndId);
					nVO.setSmsExecDate(vo.getPerformExecDate());
					nVO.setNeuropsyKind("SMS");
					neuropsyDAO.updatePerformMst(nVO);
				}
				//CARS
				List<NeuropsyCarsVO> dataCarsList = neuropsyCarsFileReader.excelRead(file);
				for (NeuropsyCarsVO vo : dataCarsList) {
					
					if("".equals(vo.getCarsExecDate()) || "x".equals(vo.getCarsExecDate().toLowerCase())) {
						//실시일이 없는 경우 INSERT X
						continue;
					}else if(".".equals(vo.getCarsExecDate())) {
						dateYn = true;
						throw new Exception("CARS");
					}
					
					vo.setRndId(rndId);
					neuropsyDAO.insertNeuropsypCars(vo);
					
					//T_PERFORM_MST 실시일 UPDATE
					nVO.setTargetId(vo.getTargetId());
					nVO.setDisClassDtl(disClassDtl);
					nVO.setPerformCntNm(vo.getPerformCntNm());
					nVO.setRndId(rndId);
					nVO.setCarsExecDate(vo.getPerformExecDate());
					nVO.setNeuropsyKind("CARS");
					neuropsyDAO.updatePerformMst(nVO);
				}
			}

			this.transactionManager.commit(status);
		}catch(RuntimeException e) {
			this.transactionManager.rollback(status);
		
			throw e;
		}
		return result;
	}
	
	public List<NeuropsyTotalVO> selectNeuropsyTotalList(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyTotalList(neuropsyVO);
	}
	
	public int selectNeuropsyTotalListTotal(NeuropsyVO neuropsyVO){
		return neuropsyDAO.selectNeuropsyTotalListTotal(neuropsyVO);
	}
	
	public ExcelFile neuropsyTotalExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyTotalExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyTotalList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public String selectPerformCntByNm(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectPerformCntByNm(neuropsyVO);
	}
	
	public int deleteNeuropsyS1(NeuropsyVO neuropsyVO){
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyS1(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("S1");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		
		return result;
	}
	
	public int deleteNeuropsyAta(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyAta(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("ATA");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public int deleteNeuropsyStroop(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyStroop(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("STROOP");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public int deleteNeuropsyCctt(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyCctt(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("CCTT");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public int deleteNeuropsyWsct(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyWsct(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("WSCT");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public int deleteNeuropsyCat(NeuropsyVO neuropsyVO){
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyCat(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("CAT");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
		
	}
	
	public int deleteNeuropsyExitii(NeuropsyVO neuropsyVO){
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyExitii(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("EXIT_II");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public int deleteNeuropsyCpt(NeuropsyVO neuropsyVO){
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyCpt(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("CPT_3");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
		
	}
	
	public int deleteNeuropsyTmt(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyTmt(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("TMT");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public boolean neuropsyFileUpload(HttpSession session, MultipartFile file, 
			HttpServletRequest request, DocFileVO oDocFileVO) throws Exception {
		boolean tf = false;
		MemberVO memberVo = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();
				String fileExtension = fileName.substring(fileName.lastIndexOf("."));
				String fileNameWOExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
				String docDir = ResourceBundleUtil.getResourceBundle("DorDir");
				String uploadExcelPath = docDir + "Excel";
				if (!FileUtils.makeDir(uploadExcelPath)) {
					throw new Exception(uploadExcelPath + " 폴더 생성이 실패하였습니다. 관리자에게 문의하세요.");
				}
				UploadExcelVO oUploadExcelVO = new UploadExcelVO();
				oUploadExcelVO.setRndId(oDocFileVO.getRndId());
				oUploadExcelVO.setDisClassDtl(oDocFileVO.getDisClassDtl());
				oUploadExcelVO.setFileClassDtl(oDocFileVO.getFileClassDtl());
				List<UploadExcelVO> oList = new ArrayList<UploadExcelVO>();
				oList = oImagingInfoDAO.selectUploadExcelInfo(oUploadExcelVO);
				if(oList.size() != 0) {
					new File(oList.get(0).getFilePath()).delete();
					oImagingInfoDAO.deleteUploadExcelInfo(oUploadExcelVO);
					
				}
				File temp = new File(uploadExcelPath + StringUtil.PathSep(fileNameWOExtenstion) + "__"
						+ oDocFileVO.getFileClassDtl() + fileExtension);
				
				file.transferTo(temp);
				
				oUploadExcelVO.setFilePath(temp.getAbsolutePath());
				oUploadExcelVO.setSessionUserId(memberVo.getUserId());
				oImagingInfoDAO.insertUploadExcelInfo(oUploadExcelVO);
				
				neuropsyExcelUpload(temp, session);
			}
			tf = true;
		} catch (Exception e) {
			e.printStackTrace();
			if(dateYn == true) {
			dateYn = false;
			throw new BizException("실시일에 '.'을 기재할 수 없습니다. 올바른 날짜형식으로 작성해주세요.");
			}else {
			throw new BizException("업로드 실패하였습니다.");
			}
		}
		return tf;
	}
	@Override
	public List<NeuropsyPepVO> selectNeuropsyPepList(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyPepList(neuropsyVO);
	}
	@Override
	public int selectNeuropsyPepListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyPepListTotal(neuropsyVO);
	}
	@Override
	public List<NeuropsyAdos1VO> selectNeuropsyAdos1List(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos1List(neuropsyVO);
	}
	@Override
	public int selectNeuropsyAdos1ListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos1ListTotal(neuropsyVO);
	}
	@Override
	public List<NeuropsyAdos2VO> selectNeuropsyAdos2List(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos2List(neuropsyVO);
	}
	@Override
	public int selectNeuropsyAdos2ListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos2ListTotal(neuropsyVO);
	}
/*	
	@Override
	public List<NeuropsyAdos3VO> selectNeuropsyAdos3List(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos3List(neuropsyVO);
	}
	@Override
	public int selectNeuropsyAdos3ListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos3ListTotal(neuropsyVO);
	}
*/	
	@Override
	public List<NeuropsySmsVO> selectNeuropsySmsList(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsySmsList(neuropsyVO);
	}
	@Override
	public int selectNeuropsySmsListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsySmsListTotal(neuropsyVO);
	}
	@Override
	public List<NeuropsyCarsVO> selectNeuropsyCarsList(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyCarsList(neuropsyVO);
	}
	@Override
	public int selectNeuropsyCarsListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyCarsListTotal(neuropsyVO);
	}
	@Override
	public int selectNeuropsyS1AsdListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyS1AsdListTotal(neuropsyVO);
	}
	@Override
	public List<NeuropsyS1VO> selectNeuropsyS1AsdList(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyS1AsdList(neuropsyVO);
	}
	@Override
	public ExcelFile neuropsyAdos1ExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyAdos1ExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyAdos1List(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyAdos2ExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyAdos2ExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyAdos2List(neuropsyVO), ExcelFile.XLSX);
	}
/*	
	@Override
	public ExcelFile neuropsyAdos3ExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyAdos3ExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyAdos3List(neuropsyVO), ExcelFile.XLSX);
	}
*/	
	@Override
	public ExcelFile neuropsyPepExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyPepExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyPepList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsySmsExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsySmsExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsySmsList(neuropsyVO), ExcelFile.XLSX);
	}
	@Override
	public ExcelFile neuropsyCarsExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyCarsExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyCarsList(neuropsyVO), ExcelFile.XLSX);
	}
	
	public int deleteNeuropsyAdos1(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyAdos1(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("ADOS1");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public int deleteNeuropsyAdos2(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyAdos2(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("ADOS2");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
/*
	public int deleteNeuropsyAdos3(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyAdos3(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("ADOS3");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
*/
	public int deleteNeuropsyPep(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyPep(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("PEP");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}

	public int deleteNeuropsySms(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsySms(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("SMS");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}

	public int deleteNeuropsyCars(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyCars(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("CARS");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}
	
	public int deleteS1IKLeiter(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteS1IKLeiter(neuropsyVO);
		
		return result;
	}
	
}
