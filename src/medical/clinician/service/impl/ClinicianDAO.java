package medical.clinician.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.clinician.service.ClinicianAsdPerformMstVO;
import medical.clinician.service.ClinicianS1VO;
import medical.clinician.service.ClinicianTotalVO;
import medical.clinician.service.ClinicianVO;

import medical.neuropsy.service.NeuropsyS1VO;
import medical.neuropsy.service.NeuropsyTotalVO;
import medical.neuropsy.service.NeuropsyVO;
import medical.surveyAsd.service.SurveyAsdPerformMstVO;
import medical.surveyAsd.service.SurveyAsdVO;

@Repository("ClinicianDAO")
public class ClinicianDAO {
  @Autowired
  private SqlSession sqlSession;
  
    public int deleteClinicianAsdAnswer(ClinicianVO clinicianVO) {
		return sqlSession.update("Clinician.deleteClinicianAsdAnswer", clinicianVO);
	}
	public int deleteClinicianAsdTotalPm(ClinicianVO clinicianVO) {
		return sqlSession.update("Clinician.deleteClinicianAsdTotalPm", clinicianVO);
	}
	public int updateClinicianAsdPerformMst(ClinicianVO clinicianVO) {
		return sqlSession.update("Clinician.updateClinicianAsdPerformMst", clinicianVO);
	}
	public int updateClinicianAsdPerformMstTotal(ClinicianVO clinicianVO) {
		return sqlSession.update("Clinician.updateClinicianAsdPerformMstTotal", clinicianVO);
	}
	public int deleteClinicianS1(ClinicianVO clinicianVO) {
		return sqlSession.update("Clinician.deleteClinicianS1", clinicianVO);
	} 
	

	public List<NeuropsyS1VO> Clinician(ClinicianVO clinicianVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyS1RowList",clinicianVO);
	}
	
  
  
	public List<ClinicianVO> selectClinicianMenuList(ClinicianVO clinicianVO){
		return sqlSession.selectList("Clinician.selectClinicianMenuList",clinicianVO);
	}
	
	

	public String selectDocNmByDocId(ClinicianVO clinicianVO) {
		return sqlSession.selectOne("Clinician.selectDocNmByDocId",clinicianVO);
	}
	
	public String selectPerformCntByNm(ClinicianVO clinicianVO){
		return sqlSession.selectOne("Clinician.selectPerformCntByNm",clinicianVO);
	}
	
	
	public List<ClinicianVO> selectPerformCntList(ClinicianVO clinicianVO) {
		return sqlSession.selectList("Clinician.selectPerformCntList",clinicianVO);
	}

	public int insertS1IKLeiter(ClinicianS1VO clinicianS1VO ) {
		return sqlSession.update("Clinician.insertS1IKLeiter", clinicianS1VO);
	}
	public int deleteS1IKLeiter(ClinicianVO clinicianVO) {
		return sqlSession.update("Clinician.deleteS1IKLeiter", clinicianVO);
	}
	
	
	public int selectClinicianDtlListTotal(ClinicianVO clinicianVO) {
		return sqlSession.selectOne("Clinician.selectClinicianDtlListTotal", clinicianVO);
	}

	public List<ClinicianVO> selectClinicianDtlList(ClinicianVO clinicianVO) {
		return sqlSession.selectList("Clinician.selectClinicianDtlList",clinicianVO);
	}
	
	
		public int selectClinicianTotalListTotal(ClinicianTotalVO clinicianTotalVO){
			return sqlSession.selectOne("Clinician.selectClinicianTotalListTotal",clinicianTotalVO);
		}

		
		
		public List<ClinicianTotalVO> selectClinicianTotalList(ClinicianTotalVO  clinicianTotalVO){
			return sqlSession.selectList("Clinician.selectClinicianTotalList",clinicianTotalVO);
		}
		
		public List<ClinicianTotalVO> selectClinicianTotalList(ClinicianVO  clinicianVO){
			return sqlSession.selectList("Clinician.selectClinicianTotalList",clinicianVO);
		}
		public List<ClinicianS1VO> selectClinicianS1List(ClinicianVO clinicianVO){
			return sqlSession.selectList("Clinician.selectNeuropsyS1List",clinicianVO);
		}
		
		public int selectClinicianS1ListTotal(ClinicianVO clinicianVO){
			return sqlSession.selectOne("Clinician.selectClinicianS1ListTotal",clinicianVO);
		}
		public List<ClinicianS1VO> selectClinicianS1AsdList(ClinicianVO clinicianVO) {
			return sqlSession.selectList("Clinician.selectClinicianS1AsdList",clinicianVO);
		}
		
		public int selectClinicianS1AsdListTotal(ClinicianVO clinicianVO) {
			return sqlSession.selectOne("Clinician.selectClinicianS1AsdListTotal", clinicianVO);
		}
		
		
	
		public int insertClinicianS1(ClinicianS1VO clinicianS1VO) {
			return sqlSession.update("Clinician.insertClinicianS1", clinicianS1VO);
		} 
		
		public int updatePerformMst(ClinicianVO clinicianVO) {
			return sqlSession.update("Clinician.updatePerformMst", clinicianVO);
		}
	
		public String selectRndId(ClinicianVO clinicianVO){
			return sqlSession.selectOne("Clinician.selectRndId",clinicianVO);
		}
		
		public int insertClinicianDocAoAnswer(ClinicianVO clinicianVO) {
			return sqlSession.update("Clinician.insertClinicianDocAoAnswer", clinicianVO);
		}
		public int updateSurveyCv(ClinicianAsdPerformMstVO clinicianAsdPerformMstVO) {
			return sqlSession.update("Clinician.updateSurveyCv", clinicianAsdPerformMstVO);
		}
		public List<ClinicianS1VO> selectClinicianS1RowList(ClinicianVO clinicianVO) {
			// TODO Auto-generated method stub
			return sqlSession.selectList("Clinician.selectClinicianS1RowList",clinicianVO);
		}
		
	
}
