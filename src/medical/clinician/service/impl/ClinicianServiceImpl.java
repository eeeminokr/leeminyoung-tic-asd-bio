package medical.clinician.service.impl;

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
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import medical.clinician.service.ClinicianAsdCybocsVO;
import medical.clinician.service.ClinicianAsdPerformMstVO;
import medical.clinician.service.ClinicianAsdSrs01VO;
import medical.clinician.service.ClinicianAsdYbocsVO;
import medical.clinician.service.ClinicianS1VO;
import medical.clinician.service.ClinicianService;
import medical.clinician.service.ClinicianTotalVO;
import medical.clinician.service.ClinicianVO;
import medical.clinician.web.clinicianController;
import medical.common.progress.ProgressDetails;
import medical.common.service.AbstractService;
import medical.common.service.impl.CommonDAO;
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
import medical.surveyAsd.service.SurveyAsdCybocsVO;
import medical.surveyAsd.service.SurveyAsdPerformMstVO;
import medical.surveyAsd.service.SurveyAsdSrs01VO;
import medical.surveyAsd.service.SurveyAsdTotalVO;
import medical.surveyAsd.service.SurveyAsdVO;
import medical.surveyAsd.service.SurveyAsdYbocsVO;

@Service("ClinicianService")
public class ClinicianServiceImpl extends AbstractService implements ClinicianService{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	
	/** DAO Class */
	@Resource(name = "ClinicianDAO")
	private ClinicianDAO clinicianDAO;
	@Resource(name = "ImagingInfoDAO")
	ImagingInfoDAO oImagingInfoDAO;
	@Resource(name = "CommonDAO")
	private CommonDAO commonDAO;
	
	
	
	PlatformTransactionManager transactionManager;
	
	
	
	private ExcelFileReader<ClinicianAsdPerformMstVO> clinicianAsdCvFileReader; //임상가평가//압로드 reader
	private ExcelFileReader<ClinicianS1VO> clinicianS1AsdFileReader;
	private ExcelFileReader<ClinicianAsdSrs01VO> clinicianAsdSrs01FileReader; //SRS(약)
	private ExcelFileReader<ClinicianAsdCybocsVO> clinicianAsdCybocsFileReader;
	private ExcelFileReader<ClinicianAsdYbocsVO> clinicianAsdYbocsFileReader;
	
	



	public void setClinicianS1AsdFileReader(ExcelFileReader<ClinicianS1VO> clinicianS1AsdFileReader) {
		this.clinicianS1AsdFileReader = clinicianS1AsdFileReader;
	}





	public void setClinicianAsdCybocsFileReader(ExcelFileReader<ClinicianAsdCybocsVO> clinicianAsdCybocsFileReader) {
		this.clinicianAsdCybocsFileReader = clinicianAsdCybocsFileReader;
	}




	public void setClinicianAsdYbocsFileReader(ExcelFileReader<ClinicianAsdYbocsVO> clinicianAsdYbocsFileReader) {
		this.clinicianAsdYbocsFileReader = clinicianAsdYbocsFileReader;
	}


	public ExcelFileReader<ClinicianAsdSrs01VO> getClinicianAsdSrs01FileReader() {
		return clinicianAsdSrs01FileReader;
	}


	public void setClinicianAsdSrs01FileReader(ExcelFileReader<ClinicianAsdSrs01VO> clinicianAsdSrs01FileReader) {
		this.clinicianAsdSrs01FileReader = clinicianAsdSrs01FileReader;
	}

	public void setClinicianAsdCvFileReader(ExcelFileReader<ClinicianAsdPerformMstVO> clinicianAsdCvFileReader) {
		this.clinicianAsdCvFileReader = clinicianAsdCvFileReader;
	}
	
	
	
	
	//다운로드 writer
	private ExcelFileWriter<ClinicianAsdSrs01VO>  clinicianAsdSrs01ExcelFileWriter;
	private ExcelFileWriter<ClinicianAsdCybocsVO> clinicianAsdCybocsExcelFileWriter;
	private ExcelFileWriter<ClinicianAsdYbocsVO> clinicianAsdYbocsExcelFileWriter;
	private ExcelFileWriter<ClinicianS1VO> clinicianAsdS1ExcelFileWriter2; //뇌원천 ASD
	//다운로드 writer
	private ExcelFileWriter<ClinicianTotalVO> clinicianTotalExcelFileWriter;
	
	
	
	public void setClinicianTotalExcelFileWriter(ExcelFileWriter<ClinicianTotalVO> clinicianTotalExcelFileWriter) {
		this.clinicianTotalExcelFileWriter = clinicianTotalExcelFileWriter;
	}
	
	public void setClinicianAsdSrs01ExcelFileWriter(ExcelFileWriter<ClinicianAsdSrs01VO> clinicianAsdSrs01FileWriter) {
		this.clinicianAsdSrs01ExcelFileWriter = clinicianAsdSrs01FileWriter;
	}
	public void setClinicianAsdCybocsExcelFileWriter(ExcelFileWriter<ClinicianAsdCybocsVO> clinicianAsdCybocsExcelFileWriter) {
		this.clinicianAsdCybocsExcelFileWriter =  clinicianAsdCybocsExcelFileWriter;
	}
	public void setClinicianAsdYbocsExcelFileWriter(ExcelFileWriter<ClinicianAsdYbocsVO> clinicianAsdYbocsExcelFileWriter) {
		this.clinicianAsdYbocsExcelFileWriter = clinicianAsdYbocsExcelFileWriter;
	}
	public void setClinicianAsdS1ExcelFileWriter2(ExcelFileWriter<ClinicianS1VO> clinicianAsdS1ExcelFileWriter2) {
		this.clinicianAsdS1ExcelFileWriter2 = clinicianAsdS1ExcelFileWriter2;
	}
	
	
	
	@Override
	public List<ClinicianVO> selectClinicianMenuList(ClinicianVO clinicianVO) {
		// TODO Auto-generated method stub
		return clinicianDAO.selectClinicianMenuList(clinicianVO);
	}


	@Override
	public int selectClinicianTotalListTotal(ClinicianTotalVO clinicianTotalVO) {
		
		
		
		return clinicianDAO.selectClinicianTotalListTotal(clinicianTotalVO);
	}
	@Override
	public List<ClinicianS1VO> selectClinicianS1List(ClinicianVO clinicianVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ClinicianS1VO> selectClinicianS1RowList(ClinicianVO clinicianVO){
		return clinicianDAO.selectClinicianS1RowList(clinicianVO);
	}
	
	

	
	public static boolean isNumeric(String s) {                                                                                                             
		try {                                                                                                                                                 
			Double.parseDouble(s);                                                                                                                              
			return true;                                                                                                                                        
		} catch(NumberFormatException e) {                                                                                                                    
			return false;                                                                                                                                       
		}                                                                                                                                                     
	}
	
	
	
	
	
	@Override
	public List<ClinicianAsdSrs01VO> selectClinicianSrs01List(ClinicianVO clinicianVO) {
		  List<ClinicianVO> result = clinicianDAO.selectClinicianDtlList(clinicianVO);
		  List<ClinicianAsdSrs01VO> srsListVO = new ArrayList<ClinicianAsdSrs01VO>();
		  ClinicianAsdSrs01VO srsVO;
		  String[] choiceAnswer = null;                                                                                                                         
		  String[] subjectAnswer = null;                                                                                                                        
		  String[] score = null;  
		  for(ClinicianVO vo : result) {                                                                                                                           
				srsVO = new ClinicianAsdSrs01VO();        
				// 답변내용에 ","가 포함되어있는 경우가있으므로 구분자는 "|" 로 변경 SS.KANG 20200714                                                                                                                          
				if(!StringUtil.isEmptyString(vo.getChoiceAnswer()))choiceAnswer = vo.getChoiceAnswer().split("\\|");                                                  
				if(!StringUtil.isEmptyString(vo.getSubjectAnswer()))subjectAnswer = vo.getSubjectAnswer().split("\\|");    
				score = vo.getScore().split("\\|");
				
				System.out.println(score+"score값!!!");
				System.out.println(vo.getDisClassDtl()+": srs01 disclassdtl 질병군 컬럼");
				srsVO.setRownum(vo.getRownum());
				srsVO.setDisClassDtl(vo.getDisClassDtl());
				srsVO.setTargetId(vo.getTargetId());       
				srsVO.setTargetDisId(vo.getTargetDisId()); 
				srsVO.setSex(vo.getSex());                                                                                                                          
				srsVO.setProtocol(vo.getProtocol());                                                                                                                
				srsVO.setPerformCnt(vo.getPerformCnt());                                                                                                            
				srsVO.setPerformNm(vo.getPerformNm());                                                                                                              
				srsVO.setAge(vo.getAge());                                                                                                                          
				srsVO.setSrs01ExecDate(vo.getExecDate());                                                                                                             
				srsVO.setDocId(vo.getDocId());                                                                                                                      
				srsVO.setA1(!StringUtil.isEquals(subjectAnswer[0], "x")?subjectAnswer[0]:score[0]);                           
				srsVO.setA2(!StringUtil.isEquals(subjectAnswer[1], "x")?subjectAnswer[1]:score[1]);                           
				srsVO.setA3(!StringUtil.isEquals(subjectAnswer[2], "x")?subjectAnswer[2]:score[2]);                           
				srsVO.setA4(!StringUtil.isEquals(subjectAnswer[3], "x")?subjectAnswer[3]:score[3]);                           
				srsVO.setA5(!StringUtil.isEquals(subjectAnswer[4], "x")?subjectAnswer[4]:score[4]);                           
				srsVO.setA6(!StringUtil.isEquals(subjectAnswer[5], "x")?subjectAnswer[5]:score[5]);                           
				srsVO.setA7(!StringUtil.isEquals(subjectAnswer[6], "x")?subjectAnswer[6]:score[6]);                           
				srsVO.setA8(!StringUtil.isEquals(subjectAnswer[7], "x")?subjectAnswer[7]:score[7]);                           
				srsVO.setA9(!StringUtil.isEquals(subjectAnswer[8], "x")?subjectAnswer[8]:score[8]);                           
				srsVO.setA10(!StringUtil.isEquals(subjectAnswer[9], "x")?subjectAnswer[9]:score[9]);                          
				srsVO.setA11(!StringUtil.isEquals(subjectAnswer[10], "x")?subjectAnswer[10]:score[10]);                      
				srsVO.setA12(!StringUtil.isEquals(subjectAnswer[11], "x")?subjectAnswer[11]:score[11]);                      
				srsVO.setA13(!StringUtil.isEquals(subjectAnswer[12], "x")?subjectAnswer[12]:score[12]);                      
				srsVO.setA14(!StringUtil.isEquals(subjectAnswer[13], "x")?subjectAnswer[13]:score[13]);                      
				srsVO.setA15(!StringUtil.isEquals(subjectAnswer[14], "x")?subjectAnswer[14]:score[14]);                      
				srsVO.setA16(!StringUtil.isEquals(subjectAnswer[15], "x")?subjectAnswer[15]:score[15]);                      
				srsVO.setA17(!StringUtil.isEquals(subjectAnswer[16], "x")?subjectAnswer[16]:score[16]);                      
				srsVO.setA18(!StringUtil.isEquals(subjectAnswer[17], "x")?subjectAnswer[17]:score[17]);                      
				srsVO.setA19(!StringUtil.isEquals(subjectAnswer[18], "x")?subjectAnswer[18]:score[18]);                      
				srsVO.setTotalScore(!StringUtil.isEquals(subjectAnswer[19], "x")?subjectAnswer[19]:score[19]);                                                                                                          
				srsListVO.add(srsVO);     
			}
			return srsListVO;

	}
	@Override
	public List<ClinicianAsdCybocsVO> selectClinicianCybocsList(ClinicianVO clinicianVO){
		 List<ClinicianVO> result = clinicianDAO.selectClinicianDtlList(clinicianVO);
		 List<ClinicianAsdCybocsVO> cybocsListVO = new ArrayList<ClinicianAsdCybocsVO>();
		 ClinicianAsdCybocsVO cybocsVO;
			String[] choiceAnswer = null;                                                                                                                         
			String[] subjectAnswer = null;                                                                                                                        
			String[] score = null;                                                                                                                                
			for(ClinicianVO vo : result) {                                                                                                                           
				cybocsVO = new ClinicianAsdCybocsVO();                                                                                                                      
				// 답변내용에 ","가 포함되어있는 경우가있으므로 구분자는 "|" 로 변경 SS.KANG 20200714                                                                                                                          
				if(!StringUtil.isEmptyString(vo.getChoiceAnswer()))choiceAnswer = vo.getChoiceAnswer().split("\\|");                                                  
				if(!StringUtil.isEmptyString(vo.getSubjectAnswer()))subjectAnswer = vo.getSubjectAnswer().split("\\|");                                               
				score = vo.getScore().split("\\|");   
			
				
				
				cybocsVO.setRownum(vo.getRownum());                                                                                                                        
				cybocsVO.setDisClassDtl(vo.getDisClassDtl());
				cybocsVO.setTargetId(vo.getTargetId());                                                                                                                  
				cybocsVO.setTargetDisId(vo.getTargetDisId());                                                                                                            
				cybocsVO.setSex(vo.getSex());                                                                                                                            
				cybocsVO.setProtocol(vo.getProtocol());                                                                                                                  
				cybocsVO.setPerformCnt(vo.getPerformCnt());                                                                                                              
				cybocsVO.setPerformNm(vo.getPerformNm());                                                                                                                
				cybocsVO.setAge(vo.getAge());                                                                                                                            
				cybocsVO.setCybocsExecDate(vo.getExecDate());                                                                                                           
				cybocsVO.setDocId(vo.getDocId());                                                                                                                        
				/*
				cybocsVO.setTotalScore(!StringUtil.isEquals(subjectAnswer[0], "x")?subjectAnswer[0]:score[0]);                                                              
				cybocsVO.setA1(!StringUtil.isEquals(subjectAnswer[1], "x")?subjectAnswer[1]:score[1]);                                                                  
				cybocsVO.setA2(!StringUtil.isEquals(subjectAnswer[2], "x")?subjectAnswer[2]:score[2]);                                                               
				cybocsVO.setA3(!StringUtil.isEquals(subjectAnswer[3], "x")?subjectAnswer[3]:score[3]);                                                               
				cybocsVO.setA4(!StringUtil.isEquals(subjectAnswer[4], "x")?subjectAnswer[4]:score[4]);                                                               
				cybocsVO.setA5(!StringUtil.isEquals(subjectAnswer[5], "x")?subjectAnswer[5]:score[5]);                                                               
				cybocsVO.setA6(!StringUtil.isEquals(subjectAnswer[6], "x")?subjectAnswer[6]:score[6]);                                                               
				cybocsVO.setA7(!StringUtil.isEquals(subjectAnswer[7], "x")?subjectAnswer[7]:score[7]);                                                               
				cybocsVO.setA8(!StringUtil.isEquals(subjectAnswer[8], "x")?subjectAnswer[8]:score[8]);                                                               
				cybocsVO.setA9(!StringUtil.isEquals(subjectAnswer[9], "x")?subjectAnswer[9]:score[9]);                                                               
				cybocsVO.setA10(!StringUtil.isEquals(subjectAnswer[10], "x")?subjectAnswer[10]:score[10]);                                                           
				cybocsVO.setCompulsion(!StringUtil.isEquals(subjectAnswer[11], "x")?subjectAnswer[11]:score[11]);                                                    
				cybocsVO.setCompulsiveBehavior(!StringUtil.isEquals(subjectAnswer[12], "x")?subjectAnswer[12]:score[12]);   
			    */
				
				
				
			
				cybocsVO.setA1(!StringUtil.isEquals(subjectAnswer[0], "x")?subjectAnswer[0]:score[0]);        
					System.out.println(score[0]+"score값");
					
				cybocsVO.setA2(!StringUtil.isEquals(subjectAnswer[1], "x")?subjectAnswer[1]:score[1]);                         
				cybocsVO.setA3(!StringUtil.isEquals(subjectAnswer[2], "x")?subjectAnswer[2]:score[2]);                         
				cybocsVO.setA4(!StringUtil.isEquals(subjectAnswer[3], "x")?subjectAnswer[3]:score[3]);                         
				cybocsVO.setA5(!StringUtil.isEquals(subjectAnswer[4], "x")?subjectAnswer[4]:score[4]);                         
				cybocsVO.setA6(!StringUtil.isEquals(subjectAnswer[5], "x")?subjectAnswer[5]:score[5]);                         
				cybocsVO.setA7(!StringUtil.isEquals(subjectAnswer[6], "x")?subjectAnswer[6]:score[6]);                         
				cybocsVO.setA8(!StringUtil.isEquals(subjectAnswer[7], "x")?subjectAnswer[7]:score[7]);                         
				cybocsVO.setA9(!StringUtil.isEquals(subjectAnswer[8], "x")?subjectAnswer[8]:score[8]);                         
				cybocsVO.setA10(!StringUtil.isEquals(subjectAnswer[9], "x")?subjectAnswer[9]:score[9]);                        
				cybocsVO.setCompulsion(!StringUtil.isEquals(subjectAnswer[10], "x")?subjectAnswer[10]:score[10]);             
				cybocsVO.setCompulsiveBehavior(!StringUtil.isEquals(subjectAnswer[11], "x")?subjectAnswer[11]:score[11]);     
				cybocsVO.setTotalScore(!StringUtil.isEquals(subjectAnswer[12], "x")?subjectAnswer[12]:score[12]);          
	          
				cybocsListVO.add(cybocsVO);                                                                                                                           
			}                                                                                                                                                     
			return cybocsListVO; 
		
	}
	@Override
	public List<ClinicianAsdYbocsVO> selectClinicianYbocsList(ClinicianVO clinicianVO) {
	    List<ClinicianVO> result = clinicianDAO.selectClinicianDtlList(clinicianVO);
	    List<ClinicianAsdYbocsVO> ybocsListVO = new ArrayList<ClinicianAsdYbocsVO>();
	    ClinicianAsdYbocsVO ybocsVO;
		String[] choiceAnswer = null;                                                                                                                         
		String[] subjectAnswer = null;                                                                                                                        
		String[] score = null;
		for(ClinicianVO vo : result) {                                                                                                                           
			ybocsVO = new ClinicianAsdYbocsVO();                                                                                                                      
			// 답변내용에 ","가 포함되어있는 경우가있으므로 구분자는 "|" 로 변경 SS.KANG 20200714                                                                                                                          
			if(!StringUtil.isEmptyString(vo.getChoiceAnswer()))choiceAnswer = vo.getChoiceAnswer().split("\\|");                                                  
			if(!StringUtil.isEmptyString(vo.getSubjectAnswer()))subjectAnswer = vo.getSubjectAnswer().split("\\|");                                               
			score = vo.getScore().split("\\|");   
		

			System.out.println("ybocsSCORE 공간 :"+score.length);
			for(int i=0; i<score.length; i++) {
				System.out.println("yobcs ["+i+"]번 공간 :"+score[i]);
			}
			
			
			ybocsVO.setRownum(vo.getRownum());   
			ybocsVO.setDisClassDtl(vo.getDisClassDtl());
			ybocsVO.setTargetId(vo.getTargetId());  
			ybocsVO.setTargetDisId(vo.getTargetDisId());
			ybocsVO.setSex(vo.getSex());                                                                                                                        
			ybocsVO.setProtocol(vo.getProtocol());                                                                                                              
			ybocsVO.setPerformCnt(vo.getPerformCnt());                                                                                                          
			ybocsVO.setPerformNm(vo.getPerformNm());                                                                                                            
			ybocsVO.setAge(vo.getAge());                                                                                                                        
			ybocsVO.setYbocsExecDate(vo.getExecDate());   
			ybocsVO.setDocId(vo.getDocId());                                                                                                                    
			ybocsVO.setTotalScore(!StringUtil.isEquals(subjectAnswer[0], "x")?subjectAnswer[0]:score[0]);            
			ybocsVO.setA1(!StringUtil.isEquals(subjectAnswer[1], "x")?subjectAnswer[1]:score[1]);                         
			ybocsVO.setA2(!StringUtil.isEquals(subjectAnswer[2], "x")?subjectAnswer[2]:score[2]);                         
			ybocsVO.setA3(!StringUtil.isEquals(subjectAnswer[3], "x")?subjectAnswer[3]:score[3]);                         
			ybocsVO.setA4(!StringUtil.isEquals(subjectAnswer[4], "x")?subjectAnswer[4]:score[4]);                         
			ybocsVO.setA5(!StringUtil.isEquals(subjectAnswer[5], "x")?subjectAnswer[5]:score[5]);                         
			ybocsVO.setA6(!StringUtil.isEquals(subjectAnswer[6], "x")?subjectAnswer[6]:score[6]);                         
			ybocsVO.setA7(!StringUtil.isEquals(subjectAnswer[7], "x")?subjectAnswer[7]:score[7]);                         
			ybocsVO.setA8(!StringUtil.isEquals(subjectAnswer[8], "x")?subjectAnswer[8]:score[8]);                         
			ybocsVO.setA9(!StringUtil.isEquals(subjectAnswer[9], "x")?subjectAnswer[9]:score[9]);                         
			ybocsVO.setA10(!StringUtil.isEquals(subjectAnswer[10], "x")?subjectAnswer[10]:score[10]);                        
			ybocsVO.setCompulsion(!StringUtil.isEquals(subjectAnswer[11], "x")?subjectAnswer[11]:score[11]);             
			ybocsVO.setCompulsiveBehavior(!StringUtil.isEquals(subjectAnswer[12], "x")?subjectAnswer[12]:score[12]);     
			 
			ybocsListVO.add(ybocsVO);                                                                                                                           
		}                                                                                                                                                     
		return ybocsListVO;
		
	}
	@Override
	public int selectClinicianS1ListTotal(ClinicianVO clinicianVO) {
		 
		return clinicianDAO.selectClinicianS1ListTotal(clinicianVO);
	}
	@Override
	public int selectClinicianS1AsdListTotal(ClinicianVO clinicianVO) {
		return clinicianDAO.selectClinicianS1AsdListTotal(clinicianVO);
	}
	@Override
	public List<ClinicianS1VO> selectClinicianS1AsdList(ClinicianVO clinicianVO) {
		
		return clinicianDAO.selectClinicianS1AsdList(clinicianVO);
	}
	@Override
	public String selectDocNmByDocId(ClinicianVO clinicianVO) {
		return clinicianDAO.selectDocNmByDocId(clinicianVO);
	}
	@Override
	public List<ClinicianVO> selectPerformCntList(ClinicianVO clinicianVO) {
		return clinicianDAO.selectPerformCntList(clinicianVO);
	}
	@Override
	public List<ClinicianTotalVO> selectClinicianTotalList(ClinicianVO clinicianVO) {
		// TODO Auto-generated method stub
		return clinicianDAO.selectClinicianTotalList(clinicianVO);
	}
	@Override
	public List<ClinicianTotalVO> selectClinicianTotalList(ClinicianTotalVO clinicianTotalVO) {

		return clinicianDAO.selectClinicianTotalList(clinicianTotalVO);
	}
	@Override
	public int selectClinicianDtlListTotal(ClinicianVO clinicianVO) {
		return clinicianDAO.selectClinicianDtlListTotal(clinicianVO);
	}
	@Override
	public int selectClinicianTotalListTotal(ClinicianVO clinicianVO) {
	
		return clinicianDAO.selectClinicianDtlListTotal(clinicianVO);
	}


	@Override
	public String selectPerformCntByNm(ClinicianVO clinicianVO) {
		// TODO Auto-generated method stub
		return clinicianDAO.selectPerformCntByNm(clinicianVO);
	}

	// 임상가평가 삭제
	@Override
	public int deleteClinicianAsdAnswer(ClinicianVO clinicianVO) {
		return clinicianDAO.deleteClinicianAsdAnswer(clinicianVO); 
	}
	
	@Override
	public int deleteClinicianAsdTotalPm(ClinicianVO clinicianVO) {
		return clinicianDAO.deleteClinicianAsdTotalPm(clinicianVO);
	}
	@Override
	public int updateClinicianAsdPerformMstTotal(ClinicianVO clinicianVO) {
		return clinicianDAO.updateClinicianAsdPerformMstTotal(clinicianVO);
	}
	@Override
	public int updateClinicianAsdPerformMst(ClinicianVO clinicianVO) {
		return clinicianDAO.updateClinicianAsdPerformMst(clinicianVO);
	}
	
	public int deleteClinicianS1(ClinicianVO clinicianVO){
		int result = 0;
		result += clinicianDAO.deleteClinicianS1(clinicianVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		clinicianVO.setClinicianKind("EXTS1");
		result += clinicianDAO.updatePerformMst(clinicianVO);
		
		return result;
	}
	

	

	
	boolean dateYn = false;
	
	@Override
	public boolean clinicianFileUpload(HttpSession session, MultipartFile file, HttpServletRequest request,
			DocFileVO oDocFileVO, String taskId) throws Exception {
		boolean tf = false;
		MemberVO memberVo = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		try {
			if (file != null) {
				String fileName = file.getOriginalFilename();
				String fileExtension = fileName.substring(fileName.lastIndexOf("."));
				String fileNameWOExtenstion = fileName.substring(0, fileName.lastIndexOf("."));
				String docDir = ResourceBundleUtil.getResourceBundle("DorDir");
//				String docDir = ResourceBundleUtil.getResourceBundle("tempDir");
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
				clinicianAsdExcelUpload(temp, taskId,session);
			}
			tf = true;
		} catch (Exception e) {
			e.printStackTrace();
			if(dateYn == true) {
				dateYn = false;
				throw new BizException("실시일을 정확히 작성해주세요.");
				}else {
				throw new BizException("업로드 실패하였습니다.");
				}
		}
		return tf;
	}
	
	
	
	
	private int clinicianAsdExcelUpload(File file, String taskId,HttpSession session) throws Exception {
		int result = 0;            
		int progressCnt = 0;

	
		
		ProgressDetails taskProgress = new ProgressDetails();
		taskProgress.setTaskId(taskId);
		taskProgress.setTaskNum(1);
		taskProgress.setTotal(5);
		ProgressDetails.taskProgressHash.put(taskId, taskProgress);


		//임상가평가
		result += clinicianAsdExcelCvUpload(file);      
		taskProgress.setTotalProcessed(++progressCnt);
		ProgressDetails.taskProgressHash.put(taskId, taskProgress);
		
		//K-SADS-PL (S1)
		result += clinicianAsdExcelS1Upload(file,session);      
		taskProgress.setTotalProcessed(++progressCnt);
		ProgressDetails.taskProgressHash.put(taskId, taskProgress);
		//SRS(약)
		result += clinicianAsdExcelSrs01Upload(file);      
		taskProgress.setTotalProcessed(++progressCnt);
		ProgressDetails.taskProgressHash.put(taskId, taskProgress);			
		//CY-BOCS
		result += clinicianAsdExcelCybocsUpload(file);      
		taskProgress.setTotalProcessed(++progressCnt);
		ProgressDetails.taskProgressHash.put(taskId, taskProgress);  
		//Y-BOCS
		result += clinicianAsdExcelYbocsUpload(file);      
		taskProgress.setTotalProcessed(++progressCnt);
		ProgressDetails.taskProgressHash.put(taskId, taskProgress);



		return result;
		
	}
	
	
	
	//임상가평가 업로드
	private int clinicianAsdExcelCvUpload(File file) throws Exception {
		System.out.println("CV업로드 IMPL입성");
		//CV                                                                                                                                                 
		int result = 0;                                                                                                                                       
		ClinicianVO cVO = new ClinicianVO();                                                                                                                                         
		String rndId = commonDAO.selectRndId();                                                                                                        
		String performCnt = "";                                                                                                                               
		List<ClinicianAsdPerformMstVO> dataCvList = clinicianAsdCvFileReader.excelRead(file);                                                                                  
		
		for(int i =0; i<  dataCvList.size(); i++ ) {
			System.out.println( dataCvList.get(i)+": datacV["+i+"]");
			}
	
		
		
		for (ClinicianAsdPerformMstVO vo : dataCvList) {
			cVO.setPerformCnt(vo.getPerformCnt());
			//차수값                                                                                                                                            
			performCnt = clinicianDAO.selectPerformCntByNm(cVO);                                                                                                   
			vo.setRndId(rndId);                                                                                                                           
			vo.setPerformCnt(performCnt);             
			vo.setClinicalValuation(vo.getExecDate());
		
			result += clinicianDAO.updateSurveyCv(vo);     
			System.out.println(result+"result");
		}                                                                                                                                                     
		return result;    
	}
	
	
	
	
	
	public int clinicianAsdExcelS1Upload(File file,HttpSession session) throws Exception {
		System.out.println("s1업로드입성");
		int result = 0;
		ClinicianVO nVO = new ClinicianVO();
		MemberVO memberVO = (MemberVO)session.getAttribute(Constant.SESSION_MEMBER);
		//String rndId = memberVO.getRndId();
	//	System.out.println(rndId+"S1RNDID");
		String disClassDtl = (String)session.getAttribute("disClassDtl");
		System.out.println(disClassDtl +"S1disClassDtl");
		
		
		//트랜잭션 시작
		//TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
	//  System.out.println(status+"status");
		
		
		int validCnt = 0;
		int validCntPound = 0;
		String performCnt = "";   
		int clinicianCnt = 1;   
		//첫번째 RND_ID 가져와서 insert
		String rndId = commonDAO.selectRndId();
		System.out.println(rndId+"S1RNDID1");

		
		

		try {
			List<ClinicianS1VO> dataS1List = null;
		 
				dataS1List = clinicianS1AsdFileReader.excelRead(file);
		//S1
			for (ClinicianS1VO vo : dataS1List) {
				
				if("".equals(vo.getS1ExecDate()) || "x".equals(vo.getS1ExecDate().toLowerCase())) {
					//실시일이 없는 경우 INSERT X
					continue;
				}else if(".".equals(vo.getS1ExecDate())) {
					dateYn = true;
					throw new Exception("K-SADS-PL");
				}
				
				vo.setRndId(rndId); 
				clinicianDAO.insertClinicianS1(vo);  
				//지능-K-Leiter
				clinicianDAO.insertS1IKLeiter(vo);
			
				
				
				
				
				
				//	performCnt = clinicianDAO.selectPerformCntByNm(nVO);  
				System.out.println(vo.getPerformCntNm()+": performNms1");
			//	System.out.println(performCnt+ ": performcntNM");
				System.out.println(vo.getS1ExecDate()+": s1exedate");
			
				
				if(!StringUtil.isEmptyString(vo.getS1ExecDate())) {                     
					nVO = new ClinicianVO();  
					//T_PERFORM_MST 실시일 UPDATE
					nVO.setTargetId(vo.getTargetId());
					nVO.setDisClassDtl("DS003");  
					nVO.setPerformCntNm(vo.getPerformCntNm());
					nVO.setRndId(rndId);
					nVO.setDocClassDtl("DC004");
					nVO.setClinicianExecDate(vo.getS1ExecDate());
					nVO.setExecDate(vo.getS1ExecDate());
					nVO.setClinicianKind("EXTS1");
					clinicianDAO.updatePerformMst(nVO);
				
				}else if(StringUtil.isEmptyString(vo.getS1ExecDate()) || vo.getS1ExecDate() == "."){
					dateYn = true;
					throw new Exception("K-SADS-PL");
				}
					
				}

		
	//		this.transactionManager.commit(status);
		  
	    }catch(RuntimeException e) {
		//		this.transactionManager.rollback(status);
			
			  throw e;
			}
			
			return result;
		
	}

	
	
	//임상가 평가 CY-BOCS                                                                                                                                          
		public int clinicianAsdExcelCybocsUpload(File file) throws Exception {                                                                                         
			List<ClinicianAsdCybocsVO> dataCybocsList = clinicianAsdCybocsFileReader.excelRead(file);                                                                            
			List<ClinicianVO> clinicianList = new ArrayList<ClinicianVO>();
			int validCnt = 0;
			int validCntPound = 0;
			int result = 0;                                                                                                                                       
			String performCnt = "";                                                                                                                               
			int clinicianCnt = 1;                                                                                                                                    
			ClinicianVO cVO;        
			for (ClinicianAsdCybocsVO vo : dataCybocsList) {                                                                                                              
				cVO = new ClinicianVO();                                                                                                                               
				String rndId = clinicianDAO.selectRndId(cVO);                                                                                                          
				//차수값                                                                                                                                            
				cVO.setPerformCnt(vo.getPerformCnt());                                                                                                              
				performCnt = clinicianDAO.selectPerformCntByNm(cVO);     
				
				//System.out.println(performCnt+": performCnt cybocs01");
				
				vo.setPerformCnt(performCnt);                                                                                                                       
				cVO.setTargetId(vo.getTargetId());                                                                                                                   
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA1()) == false && !StringUtil.isEquals(vo.getA1(), ".") && !StringUtil.isEquals(vo.getA1(), "#")) {//"."이면 숫자자리에 값이 들어감                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA1());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA1());                                                                                                                  
					cVO.setScore(vo.getA1());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA2()) == false && !StringUtil.isEquals(vo.getA2(), ".") && !StringUtil.isEquals(vo.getA2(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA2());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA2());                                                                                                                  
					cVO.setScore(vo.getA2());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                               
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA3()) == false && !StringUtil.isEquals(vo.getA3(), ".") && !StringUtil.isEquals(vo.getA3(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA3());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA3());                                                                                                                  
					cVO.setScore(vo.getA3());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA4()) == false && !StringUtil.isEquals(vo.getA4(), ".") && !StringUtil.isEquals(vo.getA4(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA4());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA4());                                                                                                                  
					cVO.setScore(vo.getA4());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA5()) == false && !StringUtil.isEquals(vo.getA5(), ".") && !StringUtil.isEquals(vo.getA5(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA5());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA5());                                                                                                                  
					cVO.setScore(vo.getA5());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA6()) == false && !StringUtil.isEquals(vo.getA6(), ".") && !StringUtil.isEquals(vo.getA6(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA6());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA6());                                                                                                                  
					cVO.setScore(vo.getA6());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA7()) == false && !StringUtil.isEquals(vo.getA7(), ".") && !StringUtil.isEquals(vo.getA7(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA7());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA7());                                                                                                                  
					cVO.setScore(vo.getA7());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                 
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA8()) == false && !StringUtil.isEquals(vo.getA8(), ".") && !StringUtil.isEquals(vo.getA8(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA8());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA8());                                                                                                                  
					cVO.setScore(vo.getA8());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA9()) == false && !StringUtil.isEquals(vo.getA9(), ".") && !StringUtil.isEquals(vo.getA9(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA9());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA9());                                                                                                                  
					cVO.setScore(vo.getA9());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA10()) == false && !StringUtil.isEquals(vo.getA10(), ".") && !StringUtil.isEquals(vo.getA10(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA10());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA10());                                                                                                                 
					cVO.setScore(vo.getA10());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getCompulsion()) == false && !StringUtil.isEquals(vo.getCompulsion(), ".") && !StringUtil.isEquals(vo.getCompulsion(), "#")) {                                                                                                        
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getCompulsion());                                                                                                         
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getCompulsion());                                                                                                          
					cVO.setScore(vo.getCompulsion());                                                                                                                 
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getCompulsiveBehavior()) == false && !StringUtil.isEquals(vo.getCompulsiveBehavior(), ".") && !StringUtil.isEquals(vo.getCompulsiveBehavior(), "#")) {                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getCompulsiveBehavior());                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getCompulsiveBehavior());                                                                                                  
					cVO.setScore(vo.getCompulsiveBehavior());                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getTotalScore()) == false && !StringUtil.isEquals(vo.getTotalScore(), ".") && !StringUtil.isEquals(vo.getTotalScore(), "#")) {                                                                                                        
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getTotalScore());                                                                                                         
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getTotalScore());                                                                                                          
					cVO.setScore(vo.getTotalScore());                                                                                                                 
					cVO.setSubjectAnswer("x");                                                                                                                        
				}
				clinicianList.add(cVO);  
				
				clinicianCnt = 1;                                                                                                                                      
				for(ClinicianVO cVo : clinicianList) {                                                                                                                    
					cVo.setDocId("CYBO1");
					cVo.setRndId(rndId);                                                                                                                              
					cVo.setTargetId(vo.getTargetId());                                                                                                                
					cVo.setPerformCnt(performCnt);     
					cVo.setDocClassDtl("DC004");
					cVo.setCreateBy(vo.getCreateBy());                                                                                                                
					cVo.setUpdateBy(vo.getUpdateBy());                       
					if(StringUtil.isEquals(cVo.getSubjectAnswer(), ""))validCnt += 1;
					if(StringUtil.isEquals(cVo.getScore(), "#"))validCntPound += 1;
					clinicianDAO.insertClinicianDocAoAnswer(cVo);                                                                                                             
				}          
				
	   			if(!StringUtil.isEmptyString(vo.getCybocsExecDate())) {                                                                                                                                                                        
	   				cVO = new ClinicianVO();                                                                                                                                                                                                       
	   				cVO.setTargetId(vo.getTargetId());                                                                                                                                                                                          
	   				cVO.setRndId(rndId);                                                                                                                                                                                                        
	   				cVO.setPerformCnt(performCnt);                                                                                                                                                                                              
	   				cVO.setDisClassDtl("DS003");    
	   				cVO.setDocClassDtl("DC004");
	   				cVO.setClinicianKind("CYBO1");
	   				if(validCnt > 0) {                                                                                                                                                                                                          
	   					cVO.setExecDate("Z");                                                                                                                                                                                                     
	   				}else if(validCntPound > 0){
						cVO.setExecDate("#");
					}else if(validCnt == 0 && validCntPound == 0) {                                                                                                                                                                                                   
	   					cVO.setExecDate(vo.getCybocsExecDate());                                                                                                                                                                                     
	   				}        
	   				cVO.setClinicianExecDate(vo.getCybocsExecDate());
	   				clinicianDAO.updatePerformMst(cVO);                                                                                                                                                                                            
	   				validCnt = 0;
	   				validCntPound = 0;
	   			} else if(StringUtil.isEmptyString(vo.getCybocsExecDate()) || vo.getCybocsExecDate() == "."){
					dateYn = true;
					throw new Exception("임상가평가 CY-BOCS");
				}      
	   			////////
				clinicianList.clear();
				                                                                                                                                                    
			}                                                                                                                                                     
			return result;                                                                                                                                        
		}
		
	
	
		//Y-BOCS                                                                                                                                          
		public int clinicianAsdExcelYbocsUpload(File file) throws Exception {                                                                                         
			List<ClinicianAsdYbocsVO> dataCybocsList = clinicianAsdYbocsFileReader.excelRead(file);                                                                            
			List<ClinicianVO> clinicianList = new ArrayList<ClinicianVO>();
			int validCnt = 0;
			int validCntPound = 0;
			int result = 0;                                                                                                                                       
			String performCnt = "";                                                                                                                               
			int clinicianCnt = 1;                                                                                                                                    
			ClinicianVO cVO;        
			for (ClinicianAsdYbocsVO vo : dataCybocsList) {                                                                                                              
				cVO = new ClinicianVO();                                                                                                                               
				String rndId = clinicianDAO.selectRndId(cVO);                                                                                                          
				//차수값                                                                                                                                            
				cVO.setPerformCnt(vo.getPerformCnt());                                                                                                              
				performCnt = clinicianDAO.selectPerformCntByNm(cVO);                                                                                                                      
				vo.setPerformCnt(performCnt);                                                                                                                       
				cVO.setTargetId(vo.getTargetId());                                                                                                                   
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA1()) == false && !StringUtil.isEquals(vo.getA1(), ".") && !StringUtil.isEquals(vo.getA1(), "#")) {//"."이면 숫자자리에 값이 들어감                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA1());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA1());                                                                                                                  
					cVO.setScore(vo.getA1());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA2()) == false && !StringUtil.isEquals(vo.getA2(), ".") && !StringUtil.isEquals(vo.getA2(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA2());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA2());                                                                                                                  
					cVO.setScore(vo.getA2());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                               
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA3()) == false && !StringUtil.isEquals(vo.getA3(), ".") && !StringUtil.isEquals(vo.getA3(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA3());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA3());                                                                                                                  
					cVO.setScore(vo.getA3());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA4()) == false && !StringUtil.isEquals(vo.getA4(), ".") && !StringUtil.isEquals(vo.getA4(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA4());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA4());                                                                                                                  
					cVO.setScore(vo.getA4());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA5()) == false && !StringUtil.isEquals(vo.getA5(), ".") && !StringUtil.isEquals(vo.getA5(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA5());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA5());                                                                                                                  
					cVO.setScore(vo.getA5());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA6()) == false && !StringUtil.isEquals(vo.getA6(), ".") && !StringUtil.isEquals(vo.getA6(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA6());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA6());                                                                                                                  
					cVO.setScore(vo.getA6());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA7()) == false && !StringUtil.isEquals(vo.getA7(), ".") && !StringUtil.isEquals(vo.getA7(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA7());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA7());                                                                                                                  
					cVO.setScore(vo.getA7());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                 
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA8()) == false && !StringUtil.isEquals(vo.getA8(), ".") && !StringUtil.isEquals(vo.getA8(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA8());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA8());                                                                                                                  
					cVO.setScore(vo.getA8());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA9()) == false && !StringUtil.isEquals(vo.getA9(), ".") && !StringUtil.isEquals(vo.getA9(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA9());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA9());                                                                                                                  
					cVO.setScore(vo.getA9());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getA10()) == false && !StringUtil.isEquals(vo.getA10(), ".") && !StringUtil.isEquals(vo.getA10(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA10());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA10());                                                                                                                 
					cVO.setScore(vo.getA10());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getCompulsion()) == false && !StringUtil.isEquals(vo.getCompulsion(), ".") && !StringUtil.isEquals(vo.getCompulsion(), "#")) {                                                                                                        
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getCompulsion());                                                                                                         
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getCompulsion());                                                                                                          
					cVO.setScore(vo.getCompulsion());                                                                                                                 
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getCompulsiveBehavior()) == false && !StringUtil.isEquals(vo.getCompulsiveBehavior(), ".") && !StringUtil.isEquals(vo.getCompulsiveBehavior(), "#")) {                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getCompulsiveBehavior());                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getCompulsiveBehavior());                                                                                                  
					cVO.setScore(vo.getCompulsiveBehavior());                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                              
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(clinicianCnt++));                                                                                                        
				if(isNumeric(vo.getTotalScore()) == false && !StringUtil.isEquals(vo.getTotalScore(), ".") && !StringUtil.isEquals(vo.getTotalScore(), "#")) {                                                                                                        
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getTotalScore());                                                                                                         
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getTotalScore());                                                                                                          
					cVO.setScore(vo.getTotalScore());                                                                                                                 
					cVO.setSubjectAnswer("x");                                                                                                                        
				}
				clinicianList.add(cVO);  
				
				clinicianCnt = 1;                                                                                                                                      
				for(ClinicianVO cVo : clinicianList) {                                                                                                                    
					cVo.setDocId("YBOCS");
					cVo.setRndId(rndId);                                                                                                                              
					cVo.setTargetId(vo.getTargetId());                                                                                                                
					cVo.setPerformCnt(performCnt);
					cVo.setDocClassDtl("DC004");
					cVo.setCreateBy(vo.getCreateBy());                                                                                                                
					cVo.setUpdateBy(vo.getUpdateBy());                       
					if(StringUtil.isEquals(cVo.getSubjectAnswer(), ""))validCnt += 1;
					if(StringUtil.isEquals(cVo.getScore(), "#"))validCntPound += 1;
					clinicianDAO.insertClinicianDocAoAnswer(cVo);                                                                                                             
				}          
				
	   			if(!StringUtil.isEmptyString(vo.getYbocsExecDate())) {                                                                                                                                                                        
	   				cVO = new ClinicianVO();                                                                                                                                                                                                       
	   				cVO.setTargetId(vo.getTargetId());                                                                                                                                                                                          
	   				cVO.setRndId(rndId);                                                                                                                                                                                                        
	   				cVO.setPerformCnt(performCnt);                                                                                                                                                                                              
	   				cVO.setDisClassDtl("DS003");    
	   				cVO.setDocClassDtl("DC004");
	   				cVO.setClinicianKind("YBOCS");
	   				if(validCnt > 0) {                                                                                                                                                                                                          
	   					cVO.setExecDate("Z");                                                                                                                                                                                                     
	   				}else if(validCntPound > 0){
						cVO.setExecDate("#");
					}else if(validCnt == 0 && validCntPound == 0) {                                                                                                                                                                                                   
	   					cVO.setExecDate(vo.getYbocsExecDate());                                                                                                                                                                                     
	   				}        
	   				cVO.setClinicianExecDate(vo.getYbocsExecDate());
	   				clinicianDAO.updatePerformMst(cVO);                                                                                                                                                                                            
	   				validCnt = 0;
	   				validCntPound = 0;
	   			} else if(StringUtil.isEmptyString(vo.getYbocsExecDate()) || vo.getYbocsExecDate() == "."){
					dateYn = true;
					throw new Exception("YBOCS 부모");
				}      
	   			////////
				clinicianList.clear();
				                                                                                                                                                    
			}                                                                                                                                                     
			return result;                                                                                                                                        
		}
		
	
		//SRS(약)
		private int clinicianAsdExcelSrs01Upload(File file) throws Exception {
			List<ClinicianAsdSrs01VO> dataSrs01List = clinicianAsdSrs01FileReader.excelRead(file);                                                                                  
			List<ClinicianVO> clinicianList = new ArrayList<ClinicianVO>();        
			int validCnt = 0;
			int validCntPound = 0;
			int result = 0;                                                                                                                                       
			String performCnt = "";                                                                                                                               
			int surveyCnt = 1;                                                                                                                                    
			ClinicianVO cVO;
			for (ClinicianAsdSrs01VO vo : dataSrs01List) {                                                                                                                  
				cVO = new ClinicianVO();                                                                                                                               
				String rndId = clinicianDAO.selectRndId(cVO);
				System.out.println(rndId+"rndId srs01");
				//차수값                                                              
				System.out.println(vo.getPerformCnt()+"srs01list cnt");
	
				cVO.setPerformCnt(vo.getPerformCnt());
				performCnt = clinicianDAO.selectPerformCntByNm(cVO);                                                                                                                                   
				System.out.println(performCnt+": performCnt srs01-1");
				
				vo.setPerformCnt(performCnt);                                                                                                                       
				cVO.setTargetId(vo.getTargetId());                                                                                                                 
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA1()) == false && !StringUtil.isEquals(vo.getA1(), ".") && !StringUtil.isEquals(vo.getA1(), "#") ) { //"."이면 숫자자리에 값이 들어감                                                                                                                 
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA1());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA1());                                                                                                                  
					cVO.setScore(vo.getA1());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA2()) == false && !StringUtil.isEquals(vo.getA2(), ".") && !StringUtil.isEquals(vo.getA2(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA2());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA2());                                                                                                                  
					cVO.setScore(vo.getA2());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                                 
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA3()) == false && !StringUtil.isEquals(vo.getA3(), ".") && !StringUtil.isEquals(vo.getA3(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA3());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA3());                                                                                                                  
					cVO.setScore(vo.getA3());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                                 
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA4()) == false && !StringUtil.isEquals(vo.getA4(), ".") && !StringUtil.isEquals(vo.getA4(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA4());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA4());                                                                                                                  
					cVO.setScore(vo.getA4());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA5()) == false && !StringUtil.isEquals(vo.getA5(), ".") && !StringUtil.isEquals(vo.getA5(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA5());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA5());                                                                                                                  
					cVO.setScore(vo.getA5());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                                 
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA6()) == false && !StringUtil.isEquals(vo.getA6(), ".") && !StringUtil.isEquals(vo.getA6(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA6());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA6());                                                                                                                  
					cVO.setScore(vo.getA6());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                                 
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA7()) == false && !StringUtil.isEquals(vo.getA7(), ".") && !StringUtil.isEquals(vo.getA7(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA7());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA7());                                                                                                                  
					cVO.setScore(vo.getA7());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                                 
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA8()) == false && !StringUtil.isEquals(vo.getA8(), ".") && !StringUtil.isEquals(vo.getA8(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA8());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA8());                                                                                                                  
					cVO.setScore(vo.getA8());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                                
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA9()) == false && !StringUtil.isEquals(vo.getA9(), ".") && !StringUtil.isEquals(vo.getA9(), "#")) {                                                                                                                
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA9());                                                                                                                 
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA9());                                                                                                                  
					cVO.setScore(vo.getA9());                                                                                                                         
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA10()) == false && !StringUtil.isEquals(vo.getA10(), ".") && !StringUtil.isEquals(vo.getA10(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA10());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA10());                                                                                                                 
					cVO.setScore(vo.getA10());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA11()) == false && !StringUtil.isEquals(vo.getA11(), ".") && !StringUtil.isEquals(vo.getA11(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA11());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA11());                                                                                                                 
					cVO.setScore(vo.getA11());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA12()) == false && !StringUtil.isEquals(vo.getA12(), ".") && !StringUtil.isEquals(vo.getA12(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA12());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA12());                                                                                                                 
					cVO.setScore(vo.getA12());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA13()) == false && !StringUtil.isEquals(vo.getA13(), ".") && !StringUtil.isEquals(vo.getA13(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA13());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA13());                                                                                                                 
					cVO.setScore(vo.getA13());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA14()) == false && !StringUtil.isEquals(vo.getA14(), ".") && !StringUtil.isEquals(vo.getA14(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA14());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA14());                                                                                                                 
					cVO.setScore(vo.getA14());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                               
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA15()) == false && !StringUtil.isEquals(vo.getA15(), ".") && !StringUtil.isEquals(vo.getA15(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA15());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA15());                                                                                                                 
					cVO.setScore(vo.getA15());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                            
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA16()) == false && !StringUtil.isEquals(vo.getA16(), ".") && !StringUtil.isEquals(vo.getA16(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA16());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA16());                                                                                                                 
					cVO.setScore(vo.getA16());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA17()) == false && !StringUtil.isEquals(vo.getA17(), ".") && !StringUtil.isEquals(vo.getA17(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA17());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA17());                                                                                                                 
					cVO.setScore(vo.getA17());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                          
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA18()) == false && !StringUtil.isEquals(vo.getA18(), ".") && !StringUtil.isEquals(vo.getA18(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA18());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA18());                                                                                                                 
					cVO.setScore(vo.getA18());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                        
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getA19()) == false && !StringUtil.isEquals(vo.getA19(), ".") && !StringUtil.isEquals(vo.getA19(), "#")) {                                                                                                               
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getA19());                                                                                                                
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getA19());                                                                                                                 
					cVO.setScore(vo.getA19());                                                                                                                        
					cVO.setSubjectAnswer("x");                                                                                                                        
				}                                                                                                                                                   
				clinicianList.add(cVO);                                                                                                                                
				cVO = new ClinicianVO();                                                                                                                              
				cVO.setInqNo(Integer.toString(surveyCnt++));                                                                                                        
				if(isNumeric(vo.getTotalScore()) == false && !StringUtil.isEquals(vo.getTotalScore(), ".") && !StringUtil.isEquals(vo.getTotalScore(), "#")) {                                                                                                        
					cVO.setChoiceAnswer("x");                                                                                                                         
					cVO.setScore("x");                                                                                                                                
					cVO.setSubjectAnswer(vo.getTotalScore());                                                                                                         
				}else{                                                                                                                                              
					cVO.setChoiceAnswer(vo.getTotalScore());                                                                                                          
					cVO.setScore(vo.getTotalScore());                                                                                                                 
					cVO.setSubjectAnswer("x");                                                                                                                        
				}     
				clinicianList.add(cVO);                                                                                                                              
				surveyCnt = 1;                                                                                                                                      
				for(ClinicianVO cVo : clinicianList) {
					cVo.setDocId("SRS01");
					cVo.setRndId(rndId);                                                                                                                              
					cVo.setTargetId(vo.getTargetId());                                                                                                                
					cVo.setPerformCnt(performCnt);    
					cVo.setDocClassDtl("DC004");
					cVo.setCreateBy(vo.getCreateBy());                                                                                                                
					cVo.setUpdateBy(vo.getUpdateBy());
					if(StringUtil.isEquals(cVo.getSubjectAnswer(), ""))validCnt += 1;
					if(StringUtil.isEquals(cVo.getScore(), "#"))validCntPound += 1;
					clinicianDAO.insertClinicianDocAoAnswer(cVo);                                                                                                             
				}                                                                                                                                                   
				if(!StringUtil.isEmptyString(vo.getSrs01ExecDate())) {                                                                                                                                                                          
	   				cVO = new ClinicianVO();                                                                                                                                                                                                       
	   				cVO.setTargetId(vo.getTargetId());                                                                                                                                                                                          
	   				cVO.setRndId(rndId);                                                                                                                                                                                                        
	   				cVO.setPerformCnt(performCnt);    
	   				cVO.setDocClassDtl("DC004");
	   				cVO.setDisClassDtl("DS003");                                                                                                                                                                                                
	   				cVO.setClinicianKind("SRS01");
	   				if(validCnt > 0) {                                                                                                                                                                                                          
	   					cVO.setExecDate("Z");                                                                                                                                                                                                     
	   				}else if(validCntPound > 0){
						cVO.setExecDate("#");
					}else if(validCnt == 0 && validCntPound == 0) {                                                                                                                                                                                                   
	   					cVO.setExecDate(vo.getSrs01ExecDate());                                                                                                                                                                                     
	   				}              
	   				cVO.setClincianExecDate(vo.getSrs01ExecDate());
	   				clinicianDAO.updatePerformMst(cVO);                                                                                                                                                                                            
	   				validCnt = 0;               
	   				validCntPound = 0;
	   			}else if(StringUtil.isEmptyString(vo.getSrs01ExecDate()) || vo.getSrs01ExecDate() == "."){
					dateYn = true;
					throw new Exception("SRS");
				}  
				clinicianList.clear();
				                                                                                                                                                    
			}                                                                                                                                                     
			return result;
		}
		
	
		
		
		//전체페이지다운로드
		public ExcelFile clinicianTotalExcelList(ClinicianTotalVO clinicianTotalVO, List<ClinicianTotalVO> ClinicianTotalListVO ) {
			if(ClinicianTotalListVO.size() == 0) {
				        
				
				
				     
				
	            return clinicianTotalExcelFileWriter.excelWrite(selectClinicianTotalList(clinicianTotalVO), ExcelFile.XLSX);
	            
			}else {
	            List<ClinicianTotalVO> totalVO;
	            List<ClinicianTotalVO> totalVOList = new ArrayList<ClinicianTotalVO>();
	            for(ClinicianTotalVO vo : ClinicianTotalListVO) {
	                      totalVO = new ArrayList<ClinicianTotalVO>();
	                      vo.setDocId(clinicianTotalVO.getDocId());
	                      vo.setDisClassDtl(clinicianTotalVO.getDisClassDtl());
	                      totalVO = selectClinicianTotalList(vo) ;
	                      totalVOList.add(totalVO.get(0));
	            }
	            return clinicianTotalExcelFileWriter.excelWrite(totalVOList, ExcelFile.XLSX);
			}
		}
	
	
		@Override
		public ExcelFile clinicianAsdSrs01ExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList) {
	        if(clinicianVOList.size() == 0) {
	            return clinicianAsdSrs01ExcelFileWriter.excelWrite(selectClinicianSrs01List(clinicianVO), ExcelFile.XLSX);
			 }else {
			        List<ClinicianAsdSrs01VO> srs01VO;
			        List<ClinicianAsdSrs01VO> srs01VOList = new ArrayList<ClinicianAsdSrs01VO>();
			        for(ClinicianVO vo : clinicianVOList) {
			        	srs01VO = new ArrayList<ClinicianAsdSrs01VO>();
		                  vo.setDocId(clinicianVO.getDocId());
		                  vo.setDisClassDtl(clinicianVO.getDisClassDtl());
		                  srs01VO = selectClinicianSrs01List(vo);
		                  srs01VOList.add(srs01VO.get(0));
			        }
			        return clinicianAsdSrs01ExcelFileWriter.excelWrite(srs01VOList, ExcelFile.XLSX);
			 }
		}
		
		@Override
		public ExcelFile clinicianAsdCybocsExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList)  {
	        if(clinicianVOList.size() == 0) {
	            return clinicianAsdCybocsExcelFileWriter.excelWrite(selectClinicianCybocsList(clinicianVO), ExcelFile.XLSX);
			 }else {
			        List<ClinicianAsdCybocsVO> cybocsVO;
			        List<ClinicianAsdCybocsVO> cybocsVOList = new ArrayList<ClinicianAsdCybocsVO>();
			        for(ClinicianVO vo : clinicianVOList) {
			        	cybocsVO = new ArrayList<ClinicianAsdCybocsVO>();
		                  vo.setDocId(clinicianVO.getDocId());
		                  cybocsVO = selectClinicianCybocsList(vo);
		                  cybocsVOList.add(cybocsVO.get(0));
			        }
			        return clinicianAsdCybocsExcelFileWriter.excelWrite(cybocsVOList, ExcelFile.XLSX);
			 }
		}


		@Override
		public ExcelFile clinicianAsdYbocsExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList) {
	        if(clinicianVOList.size() == 0) {
	            return clinicianAsdYbocsExcelFileWriter.excelWrite(selectClinicianYbocsList(clinicianVO), ExcelFile.XLSX);
			 }else {
			        List<ClinicianAsdYbocsVO> ybocsVO;
			        List<ClinicianAsdYbocsVO> ybocsVOList = new ArrayList<ClinicianAsdYbocsVO>();
			        for(ClinicianVO vo : clinicianVOList) {
			        	ybocsVO = new ArrayList<ClinicianAsdYbocsVO>();
		                  vo.setDocId(clinicianVO.getDocId());
		                  ybocsVO = selectClinicianYbocsList(clinicianVO);
		                  ybocsVOList.add(ybocsVO.get(0));
			        }
			        return clinicianAsdYbocsExcelFileWriter.excelWrite(ybocsVOList, ExcelFile.XLSX);
			 }
		}

		
		
		@Override
		public ExcelFile clinicianAsdS1ExcelList(ClinicianVO clinicianVO, List<ClinicianVO> clinicianVOList) {
	        if(clinicianVOList.size() == 0) {
	            return clinicianAsdS1ExcelFileWriter2.excelWrite(selectClinicianS1AsdList(clinicianVO), ExcelFile.XLSX);
			 }else {
			        List<ClinicianS1VO> s1VO;
			        List<ClinicianS1VO> s1VOList = new ArrayList<ClinicianS1VO>();
			        for(ClinicianVO vo : clinicianVOList) {
			        	s1VO = new ArrayList<ClinicianS1VO>();
		                  vo.setDocId(clinicianVO.getDocId());
		                  s1VO = selectClinicianS1AsdList(clinicianVO);
		                  s1VOList.add(s1VO.get(0));
			        }
			        return clinicianAsdS1ExcelFileWriter2.excelWrite(s1VOList, ExcelFile.XLSX);
			 }
		}





		public int deleteS1IKLeiter(ClinicianVO clinicianVO){
			
			int result = 0;
			result += clinicianDAO.deleteS1IKLeiter(clinicianVO);
			
			return result;
		}
		
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	/*
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
	private ExcelFileWriter<NeuropsyAdos3VO> neuropsyAdos3ExcelFileWriter;
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
	private ExcelFileReader<NeuropsyAdos3VO> neuropsyAdos3FileReader;
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
	public void setNeuropsyAdos3ExcelFileWriter(ExcelFileWriter<NeuropsyAdos3VO> neuropsyAdos3ExcelFileWriter) {
		this.neuropsyAdos3ExcelFileWriter = neuropsyAdos3ExcelFileWriter;
	}
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
	public void setNeuropsyAdos3FileReader(ExcelFileReader<NeuropsyAdos3VO> neuropsyAdos3FileReader) {
		this.neuropsyAdos3FileReader = neuropsyAdos3FileReader;
	}
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
	@Override
	public List<NeuropsyAdos3VO> selectNeuropsyAdos3List(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos3List(neuropsyVO);
	}
	@Override
	public int selectNeuropsyAdos3ListTotal(NeuropsyVO neuropsyVO) {
		return neuropsyDAO.selectNeuropsyAdos3ListTotal(neuropsyVO);
	}
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
	@Override
	public ExcelFile neuropsyAdos3ExcelDownload(NeuropsyVO neuropsyVO) {
		return  neuropsyAdos3ExcelFileWriter.excelWrite(neuropsyDAO.selectNeuropsyAdos3List(neuropsyVO), ExcelFile.XLSX);
	}
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

	public int deleteNeuropsyAdos3(NeuropsyVO neuropsyVO){
		
		int result = 0;
		result += neuropsyDAO.deleteNeuropsyAdos3(neuropsyVO);
		
		//T_PERFORM_MST 실시일 빈값으로 UPDATE
		neuropsyVO.setNeuropsyKind("ADOS3");
		result += neuropsyDAO.updatePerformMst(neuropsyVO);
		return result;
	}

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
	*/
}
