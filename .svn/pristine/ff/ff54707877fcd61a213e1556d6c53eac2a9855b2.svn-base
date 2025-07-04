package medical.gene.service.impl;

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
import medical.gene.service.GeneService;
import medical.gene.service.GeneTotalVO;
import medical.gene.service.GeneVO;
import medical.gene.service.TAnalGenVO;
import medical.imagingInfo.service.DocFileVO;
import medical.imagingInfo.service.UploadExcelVO;
import medical.imagingInfo.service.impl.ImagingInfoDAO;
import medical.surveyAsd.service.SurveyAsdTotalVO;

@Service("GeneService")
public class GeneServiceImpl extends AbstractService implements GeneService {
	
	@Resource(name="GeneDAO")
	private GeneDAO geneDAO;
	@Resource(name="ImagingInfoDAO")
	ImagingInfoDAO oImagingInfoDAO;
	@Autowired
	PlatformTransactionManager transactionManager; 
	

	private ExcelFileWriter<TAnalGenVO> geneFileWriter;
	
	private ExcelFileWriter<GeneTotalVO> geneTotalFileWriter;
	
	
	private ExcelFileReader<TAnalGenVO> geneFileReader;

	
	
	public void setGeneTotalFileWriter(ExcelFileWriter<GeneTotalVO> geneTotalFileWriter) {
		this.geneTotalFileWriter = geneTotalFileWriter;
	}

	public void setGeneFileWriter(ExcelFileWriter<TAnalGenVO> geneFileWriter) {
		this.geneFileWriter = geneFileWriter;
	}

	public void setGeneFileReader(ExcelFileReader<TAnalGenVO> geneFileReader) {
		this.geneFileReader = geneFileReader;
	}


	boolean dateYn = false;

	
	
	
	@Override
	public List<TAnalGenVO> selectTAnalGenList(GeneVO geneVO) {
		return geneDAO.selectTAnalGenList(geneVO);
	}
 
	@Override
	public List<GeneVO> selectGeneMenuList(GeneVO geneVO) {
		return geneDAO.selectGeneMenuList(geneVO);
	}

	@Override
	public int selectTAnalGenListTotal(GeneVO geneVO) {
		return geneDAO.selectTAnalGenListTotal(geneVO);
	}

	@Override
	public List<GeneTotalVO> selectGeneTotalList(GeneTotalVO geneTotalVO) {
		return geneDAO.selectGeneTotalList(geneTotalVO);
	}
	@Override
	public int selectGeneTotalListTotal(GeneTotalVO geneTotalVO) {
		return geneDAO.selectGeneTotalListTotal(geneTotalVO);
	}
	@Override
	public boolean GeneFileUpload(HttpSession session, MultipartFile file, HttpServletRequest request,
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
				
				geneExcelUpload(temp, session);
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
		
		
	public int geneExcelUpload(File file,HttpSession session) throws Exception {
		int result = 0;
		GeneVO gVO = new GeneVO();
		//첫번째 RND_ID 가져와서 insert
		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		String rndId = memberVO.getRndId();
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		
		//트랜잭션 시작
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

		try {
			//Gen
			List<TAnalGenVO> dataGenList = null;
			if("DS003".equals(disClassDtl)) {
				dataGenList = geneFileReader.excelRead(file);
			}
			for (TAnalGenVO vo : dataGenList) {
				if("".equals(vo.getGenExecDate()) || "x".equals(vo.getGenExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getGenExecDate())) {
					dateYn = true;
					throw new Exception("AGEN1");
				}
				
				vo.setRndId(rndId);
				geneDAO.insertGene(vo);
				
				//T_PERFORM_MST 실시일 UPDATE
				gVO.setTargetId(vo.getTargetId());
				gVO.setDisClassDtl(disClassDtl);
				gVO.setRndId(rndId);
				gVO.setGenExecDate(vo.getCollectDate());
				
				gVO.setGeneKind("WGS");
				geneDAO.updatePerformMst(gVO);
			}
			
			
			this.transactionManager.commit(status);
		}catch(RuntimeException e) {
			this.transactionManager.rollback(status);
		
			throw e;
		}
		return result;
	}
	
	
	@Override
	public ExcelFile GeneExcelList(GeneVO geneVO, List<GeneVO> geneVOList) {
		if(geneVOList.size() == 0) {
			ExcelFile x = geneFileWriter.excelWrite(selectTAnalGenList(geneVO), ExcelFile.XLSX);
            return x;
		}else {
            List<TAnalGenVO> totalVO;
            List<TAnalGenVO> totalVOList = new ArrayList<TAnalGenVO>();
            for(GeneVO vo : geneVOList) {
                      totalVO = new ArrayList<TAnalGenVO>();
                      vo.setDocId(geneVO.getDocId());
                      vo.setDisClassDtl(geneVO.getDisClassDtl());
                      totalVO = selectTAnalGenList(vo);
                      totalVOList.add(totalVO.get(0));
            }
            
            return geneFileWriter.excelWrite(totalVOList, ExcelFile.XLSX);
		}
	}
	
	@Override
	public int deleteGene(GeneVO geneVO) {
		int result = 0;
		result += geneDAO.deleteGene(geneVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		geneVO.setGeneKind("유전자정보");
		result += geneDAO.updatePerformMst(geneVO);
		return result;
	}

	@Override
	public ExcelFile GeneTotalExcelList(GeneTotalVO geneTotalVO,
			List<GeneTotalVO> geneTotalVOList) {
		if(geneTotalVOList.size() == 0) {
            return geneTotalFileWriter.excelWrite(selectGeneTotalList(geneTotalVO), ExcelFile.XLSX);
		}else {
            List<GeneTotalVO> totalVO;
            List<GeneTotalVO> totalVOList = new ArrayList<GeneTotalVO>();
            for(GeneTotalVO vo : geneTotalVOList) {
                      totalVO = new ArrayList<GeneTotalVO>();
                      vo.setDocId(geneTotalVO.getDocId());
                      vo.setDisClassDtl(geneTotalVO.getDisClassDtl());
                      vo.setRndId(geneTotalVO.getRndId());
                      totalVO = selectGeneTotalList(vo);
                      totalVOList.add(totalVO.get(0));
            }
            return geneTotalFileWriter.excelWrite(totalVOList, ExcelFile.XLSX);
		}
	}

}
