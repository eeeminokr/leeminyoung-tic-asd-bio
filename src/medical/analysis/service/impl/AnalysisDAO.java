package medical.analysis.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.analysis.service.AnalysisTAnalGenVO;
import medical.analysis.service.AnalysisTAnalSnpVO;
import medical.analysis.service.AnalysisTotalVO;
import medical.analysis.service.AnalysisVO;

@Repository("AnalysisDAO")
public class AnalysisDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<AnalysisTAnalEnvMattVO> selectTAnalEnvMattList(AnalysisVO analysisVO){
		return sqlSession.selectList("Analysis.selectTAnalEnvMattList",analysisVO);
	}
	
	public List<AnalysisTAnalEnvMattBlVO> selectTAnalEnvMattBlList(AnalysisVO analysisVO){
		return sqlSession.selectList("Analysis.selectTAnalEnvMattBlList",analysisVO);
	}
	
//	public List<AnalysisTAnalSnpVO> selectTAnalSnpList(AnalysisVO analysisVO){
//		return sqlSession.selectList("Analysis.selectTAnalSnpList",analysisVO);
//	}

	public List<AnalysisVO> selectAnalysisMenuList(AnalysisVO analysisVO){
		return sqlSession.selectList("Analysis.selectAnalysisMenuList", analysisVO);
	}
	public int selectTAnalEnvMattListTotal(AnalysisVO analysisVO) {
		return sqlSession.selectOne("Analysis.selectTAnalEnvMattListTotal", analysisVO);
	}
	public int selectTAnalEnvMattBlListTotal(AnalysisVO analysisVO) {
		return sqlSession.selectOne("Analysis.selectTAnalEnvMattBlListTotal", analysisVO);
	}
	

//	public int selectTAnalSnpListTotal(AnalysisVO analysisVO) {
//		return sqlSession.selectOne("Analysis.selectTAnalSnpListTotal", analysisVO);
//	}

	public int insertAnalysisEnvMatt(AnalysisTAnalEnvMattVO analysisTAnalEnvMattVO) {
		return sqlSession.update("Analysis.insertAnalysisEnvMatt", analysisTAnalEnvMattVO);
	}
	
	public int insertAnalysisEnvMattBl(AnalysisTAnalEnvMattBlVO analysisTAnalEnvMattBlVO) {
		return sqlSession.update("Analysis.insertAnalysisEnvMattBl", analysisTAnalEnvMattBlVO);
	}
	

	public int updatePerformMst(AnalysisVO analysisVO) {
		return sqlSession.update("Analysis.updatePerformMst", analysisVO);
	}
	public int deleteAnalysisAnswer(AnalysisVO analysisVO) {
		return sqlSession.update("Analysis.deleteAnalysisAnswer", analysisVO);
	}
	public int deleteAnalysisTotalPm(AnalysisVO analysisVO) {
		return sqlSession.update("Analysis.deleteAnalysisTotalPm", analysisVO);
	}
	public int updateAnalysisPerformMstTotal(AnalysisVO analysisVO) {
		return sqlSession.update("Analysis.updateAnalysisPerformMstTotal", analysisVO);
	}
	public int updateAnalysisPerformMst(AnalysisVO analysisVO) {
		return sqlSession.update("Analysis.updateAnalysisPerformMst", analysisVO);
	}
	public int deleteAnalysisEnvMatt(AnalysisVO analysisVO) {
		return sqlSession.update("Analysis.deleteAnalysisEnvMatt", analysisVO);
	}
	public int deleteAnalysisEnvMattBl(AnalysisVO analysisVO) {
		return sqlSession.update("Analysis.deleteAnalysisEnvMattBl", analysisVO);
	}
	

//	public int deleteAnalysisSnp(AnalysisVO analysisVO) {
//		return sqlSession.update("Analysis.deleteAnalysisSnp", analysisVO);
//	}
	public int selectTAnalTotalListTotal(AnalysisTotalVO analysisTotalVO) {
		return sqlSession.selectOne("Analysis.selectTAnalTotalListTotal", analysisTotalVO);
	}
	public List<AnalysisTotalVO> selectTAnalTotalList(AnalysisTotalVO analysisTotalVO) {
		return sqlSession.selectList("Analysis.selectTAnalTotalList", analysisTotalVO);
	}


	
	
}
