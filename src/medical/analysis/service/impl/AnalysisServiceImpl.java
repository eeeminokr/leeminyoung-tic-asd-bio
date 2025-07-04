package medical.analysis.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import medical.analysis.service.AnalysisService;
import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.analysis.service.AnalysisTAnalGenVO;
import medical.analysis.service.AnalysisTAnalSnpVO;
import medical.analysis.service.AnalysisTotalVO;
import medical.analysis.service.AnalysisVO;
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


@Service("AnalysisService")
public class AnalysisServiceImpl extends AbstractService implements AnalysisService {
	
	@Resource(name="AnalysisDAO")
	private AnalysisDAO analysisDAO;
	@Resource(name="ImagingInfoDAO")
	ImagingInfoDAO oImagingInfoDAO;
	@Autowired
	PlatformTransactionManager transactionManager; 
	
	private ExcelFileWriter<AnalysisTAnalEnvMattVO> analysisEnvMattFileWriter;
	private ExcelFileWriter<AnalysisTAnalEnvMattBlVO> analysisEnvMattBlFileWriter;
	
//	private ExcelFileWriter<AnalysisTAnalSnpVO> analysisSnpFileWriter;
	private ExcelFileWriter<AnalysisTotalVO> analysisTotalFileWriter;
	
	private ExcelFileReader<AnalysisTAnalEnvMattVO> analysisEnvMattFileReader;
	private ExcelFileReader<AnalysisTAnalEnvMattBlVO> analysisEnvMattBlFileReader;
	
//	private ExcelFileReader<AnalysisTAnalSnpVO> analysisSnpFileReader;
	
	
	public void setAnalysisTotalFileWriter(ExcelFileWriter<AnalysisTotalVO> analysisTotalFileWriter) {
		this.analysisTotalFileWriter = analysisTotalFileWriter;
	}
	public void setAnalysisEnvMattFileWriter(ExcelFileWriter<AnalysisTAnalEnvMattVO> analysisEnvMattFileWriter) {
		this.analysisEnvMattFileWriter = analysisEnvMattFileWriter;
	}
	public void setAnalysisEnvMattFileReader(ExcelFileReader<AnalysisTAnalEnvMattVO> analysisEnvMattFileReader) {
		this.analysisEnvMattFileReader = analysisEnvMattFileReader;
	}
	public void setAnalysisEnvMattBlFileWriter(ExcelFileWriter<AnalysisTAnalEnvMattBlVO> analysisEnvMattBlFileWriter) {
		this.analysisEnvMattBlFileWriter = analysisEnvMattBlFileWriter;
	}
	public void setAnalysisEnvMattBlFileReader(ExcelFileReader<AnalysisTAnalEnvMattBlVO> analysisEnvMattBlFileReader) {
		this.analysisEnvMattBlFileReader = analysisEnvMattBlFileReader;
	}	
	
	

//	public void setAnalysisSnpFileWriter(ExcelFileWriter<AnalysisTAnalSnpVO> analysisSnpFileWriter) {
//		this.analysisSnpFileWriter = analysisSnpFileWriter;
//	}
//	public void setAnalysisSnpFileReader(ExcelFileReader<AnalysisTAnalSnpVO> analysisSnpFileReader) {
//		this.analysisSnpFileReader = analysisSnpFileReader;
//	}


	boolean dateYn = false;
	
	@Override
	public List<AnalysisTAnalEnvMattVO> selectTAnalEnvMattList(AnalysisVO analysisVO) {
		return analysisDAO.selectTAnalEnvMattList(analysisVO);
	}
	@Override
	public List<AnalysisTAnalEnvMattBlVO> selectTAnalEnvMattBlList(AnalysisVO analysisVO) {
		return analysisDAO.selectTAnalEnvMattBlList(analysisVO);
	}
	
	

//    @Override
//	public List<AnalysisTAnalSnpVO> selectTAnalSnpList(AnalysisVO analysisVO) {
//		return analysisDAO.selectTAnalSnpList(analysisVO);
//	}
	@Override
	public List<AnalysisVO> selectAnalysisMenuList(AnalysisVO analysisVO) {
		return analysisDAO.selectAnalysisMenuList(analysisVO);
	}
	@Override
	public int selectTAnalEnvMattListTotal(AnalysisVO analysisVO) {
		return analysisDAO.selectTAnalEnvMattListTotal(analysisVO);
	}
	
	@Override
	public int selectTAnalEnvMattBlListTotal(AnalysisVO analysisVO) {
		return analysisDAO.selectTAnalEnvMattBlListTotal(analysisVO);
	}
	
	
	@Override
	public List<AnalysisTotalVO> selectTAnalTotalList(AnalysisTotalVO analysisTotalVO) {
		return analysisDAO.selectTAnalTotalList(analysisTotalVO);
	}
	@Override
	public int selectTAnalTotalListTotal(AnalysisTotalVO analysisTotalVO) {
		return analysisDAO.selectTAnalTotalListTotal(analysisTotalVO);
	}
	@Override
	public boolean analysisFileUpload(HttpSession session, MultipartFile file, HttpServletRequest request,
			DocFileVO oDocFileVO) {
		boolean tf = false;
		MemberVO memberVo = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);;
		try {
			if(file != null) {
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
				
				analysisExcelUpload(temp, session);
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
		
		
	public int analysisExcelUpload(File file,HttpSession session) throws Exception {
		int result = 0;
		AnalysisVO aVO = new AnalysisVO();
		//첫번째 RND_ID 가져와서 insert
		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		String rndId = memberVO.getRndId();
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		
		//트랜잭션 시작
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

		try {

			//envMatt
			List<AnalysisTAnalEnvMattVO> dataEnvMattList = null;
			if("DS003".equals(disClassDtl)) {
				dataEnvMattList = analysisEnvMattFileReader.excelRead(file);
			}
			for (AnalysisTAnalEnvMattVO vo : dataEnvMattList) {
				if("".equals(vo.getCollectDate()) || "x".equals(vo.getCollectDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getCollectDate())) {
					dateYn = true;
					throw new Exception("AENT1");
				}
				
				vo.setRndId(rndId);
				
				analysisDAO.insertAnalysisEnvMatt(vo);
				//T_PERFORM_MST 실시일 UPDATE
				aVO.setTargetId(vo.getTargetId());
				aVO.setDisClassDtl(disClassDtl);
				aVO.setRndId(rndId);
				aVO.setPerformCntNm(vo.getPerformCntNm());
				aVO.setEnvMattExecDate(vo.getCollectDate());
				aVO.setAnalysisKind("ANAL_ENV_MATT");
				analysisDAO.updatePerformMst(aVO);
			}
		
			//envMatt
			List<AnalysisTAnalEnvMattBlVO> dataEnvMattBlList = null;
			if("DS003".equals(disClassDtl)) {
				dataEnvMattBlList = analysisEnvMattBlFileReader.excelRead(file);
			}
			for (AnalysisTAnalEnvMattBlVO vo : dataEnvMattBlList) {
				if("".equals(vo.getBloodCollectDate()) || "x".equals(vo.getBloodCollectDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getBloodCollectDate())) {
					dateYn = true;
					throw new Exception("AENTB1");
				}
				
				vo.setRndId(rndId);
				
			
				analysisDAO.insertAnalysisEnvMattBl(vo);
				//T_PERFORM_MST 실시일 UPDATE
				aVO.setTargetId(vo.getTargetId());
				aVO.setDisClassDtl(disClassDtl);
				aVO.setRndId(rndId);
				aVO.setPerformCntNm(vo.getPerformCntNm());
				aVO.setEnvMattBlExecDate(vo.getBloodCollectDate());
				aVO.setAnalysisKind("ANAL_ENV_MATT_BL");
				analysisDAO.updatePerformMst(aVO);
			}
			
			
			/*
			//Snp
			List<AnalysisTAnalSnpVO> dataSnpList = null;
			if("DS003".equals(disClassDtl)) {
				dataSnpList = analysisSnpFileReader.excelRead(file);
			}
			for (AnalysisTAnalSnpVO vo : dataSnpList) {
				if("".equals(vo.getSnpExecDate()) || "x".equals(vo.getSnpExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getSnpExecDate())) {
					dateYn = true;
					throw new Exception("ASNP1");
				}
				
				vo.setRndId(rndId);
				
				analysisDAO.insertAnalysisSnp(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				aVO.setTargetId(vo.getTargetId());
				aVO.setDisClassDtl(disClassDtl);
				aVO.setRndId(rndId);
				aVO.setSnpExecDate(vo.getCollectDate());
				
				aVO.setAnalysisKind("ANAL_SNP");
				analysisDAO.updatePerformMst(aVO);
			}
			*/
			
			
			this.transactionManager.commit(status);
		}catch(RuntimeException e) {
			this.transactionManager.rollback(status);
		
			throw e;
		}
		return result;
	}
	
	
	@Override
	public ExcelFile analysisEnvMattExcelList(AnalysisVO analysisVO, List<AnalysisVO> analysisVOList) {
		if(analysisVOList.size() == 0) {
			ExcelFile x = analysisEnvMattFileWriter.excelWrite(selectTAnalEnvMattList(analysisVO), ExcelFile.XLSX);
            return x;
		}else {
            List<AnalysisTAnalEnvMattVO> totalVO;
            List<AnalysisTAnalEnvMattVO> totalVOList = new ArrayList<AnalysisTAnalEnvMattVO>();
            for(AnalysisVO vo : analysisVOList) {
                      totalVO = new ArrayList<AnalysisTAnalEnvMattVO>();
                      vo.setDocId(analysisVO.getDocId());
                      vo.setDisClassDtl(analysisVO.getDisClassDtl());
                      totalVO = selectTAnalEnvMattList(vo);
                      totalVOList.add(totalVO.get(0));
            }
            
            return analysisEnvMattFileWriter.excelWrite(totalVOList, ExcelFile.XLSX);
		}
	}
	
	@Override
	public ExcelFile analysisEnvMattBlExcelList(AnalysisVO analysisVO, List<AnalysisVO> analysisVOList) {
		if(analysisVOList.size() == 0) {
			ExcelFile x = analysisEnvMattBlFileWriter.excelWrite(selectTAnalEnvMattBlList(analysisVO), ExcelFile.XLSX);
            return x;
		}else {
            List<AnalysisTAnalEnvMattBlVO> totalVO;
            List<AnalysisTAnalEnvMattBlVO> totalVOList = new ArrayList<AnalysisTAnalEnvMattBlVO>();
            for(AnalysisVO vo : analysisVOList) {
                      totalVO = new ArrayList<AnalysisTAnalEnvMattBlVO>();
                      vo.setDocId(analysisVO.getDocId());
                      vo.setDisClassDtl(analysisVO.getDisClassDtl());
                      totalVO = selectTAnalEnvMattBlList(vo);
                      totalVOList.add(totalVO.get(0));
            }
            
            return analysisEnvMattBlFileWriter.excelWrite(totalVOList, ExcelFile.XLSX);
		}
	}
	
	/*
	@Override
	public ExcelFile analysisSnpExcelList(AnalysisVO analysisVO, List<AnalysisVO> analysisVOList) {
		if(analysisVOList.size() == 0) {
			ExcelFile x = analysisSnpFileWriter.excelWrite(selectTAnalSnpList(analysisVO), ExcelFile.XLSX);
            return x;
		}else {
            List<AnalysisTAnalSnpVO> totalVO;
            List<AnalysisTAnalSnpVO> totalVOList = new ArrayList<AnalysisTAnalSnpVO>();
            for(AnalysisVO vo : analysisVOList) {
                      totalVO = new ArrayList<AnalysisTAnalSnpVO>();
                      vo.setDocId(analysisVO.getDocId());
                      vo.setDisClassDtl(analysisVO.getDisClassDtl());
                      totalVO = selectTAnalSnpList(vo);
                      totalVOList.add(totalVO.get(0));
            }
            
            return analysisSnpFileWriter.excelWrite(totalVOList, ExcelFile.XLSX);
		}
	}
	*/
	
	@Override
	public int deleteAnalysisEnvMatt(AnalysisVO analysisVO) {
		int result = 0;
		result += analysisDAO.deleteAnalysisEnvMatt(analysisVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		analysisVO.setAnalysisKind("PHTs 3종 및 COT(소변)");
		result += analysisDAO.updatePerformMst(analysisVO);
		return result;
	}
	
	@Override
	public int deleteAnalysisEnvMattBl(AnalysisVO analysisVO) {
		int result = 0;
		result += analysisDAO.deleteAnalysisEnvMattBl(analysisVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		analysisVO.setAnalysisKind("중금속(혈액)");
		result += analysisDAO.updatePerformMst(analysisVO);
		return result;
	}
	
	
/*
	@Override
	public int deleteAnalysisSnp(AnalysisVO analysisVO) {
		int result = 0;
		result += analysisDAO.deleteAnalysisSnp(analysisVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		analysisVO.setAnalysisKind("SNP분석");
		result += analysisDAO.updatePerformMst(analysisVO);
		return result;
	}
*/	
	
	@Override
	public ExcelFile analysisTotalExcelList(AnalysisTotalVO analysisTotalVO,
			List<AnalysisTotalVO> analysisTotalVOList) {
		if(analysisTotalVOList.size() == 0) {
            return analysisTotalFileWriter.excelWrite(selectTAnalTotalList(analysisTotalVO), ExcelFile.XLSX);
		}else {
            List<AnalysisTotalVO> totalVO;
            List<AnalysisTotalVO> totalVOList = new ArrayList<AnalysisTotalVO>();
            for(AnalysisTotalVO vo : analysisTotalVOList) {
                      totalVO = new ArrayList<AnalysisTotalVO>();
                      vo.setDocId(analysisTotalVO.getDocId());
                      vo.setDisClassDtl(analysisTotalVO.getDisClassDtl());
                      vo.setRndId(analysisTotalVO.getRndId());
                      totalVO = selectTAnalTotalList(vo);
                      totalVOList.add(totalVO.get(0));
            }
            return analysisTotalFileWriter.excelWrite(totalVOList, ExcelFile.XLSX);
		}
	}



}
