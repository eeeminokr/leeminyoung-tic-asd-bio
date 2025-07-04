package medical.surveyAsd.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.survey.service.SurveyVO;
import medical.surveyAsd.service.SurveyAsdPerformMstVO;
import medical.surveyAsd.service.SurveyAsdTotalVO;
import medical.surveyAsd.service.SurveyAsdVO;

@Repository("SurveyAsdDAO")
public class SurveyAsdDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int deleteSurveyAsdAnswer(SurveyAsdVO surveyAsdVO) {
		return sqlSession.update("SurveyAsd.deleteSurveyAsdAnswer", surveyAsdVO);
	}
	public int deleteSurveyAsdTotalPm(SurveyAsdVO surveyAsdVO) {
		return sqlSession.update("SurveyAsd.deleteSurveyAsdTotalPm", surveyAsdVO);
	}
	public int updateSurveyAsdPerformMst(SurveyAsdVO surveyAsdVO) {
		return sqlSession.update("SurveyAsd.updateSurveyAsdPerformMst", surveyAsdVO);
	}
	public int updateSurveyAsdPerformMstTotal(SurveyAsdVO surveyAsdVO) {
		return sqlSession.update("SurveyAsd.updateSurveyAsdPerformMstTotal", surveyAsdVO);
	}
	
	public int selectSurveyTotalListAoTotal(SurveyAsdTotalVO surveyAsdTotalVO) {
		return sqlSession.selectOne("SurveyAsd.selectSurveyTotalListAoTotal", surveyAsdTotalVO);
	}

	public List<SurveyAsdTotalVO> selectSurveyTotalListAo(SurveyAsdTotalVO surveyAsdTotalVO) {
		return sqlSession.selectList("SurveyAsd.selectSurveyTotalListAo", surveyAsdTotalVO);
	}

	public List<SurveyAsdVO> selectPerformCntList(SurveyAsdVO surveyAsdVO) {
		return sqlSession.selectList("SurveyAsd.selectPerformCntList",surveyAsdVO);
	}

	public List<SurveyAsdVO> selectSurveyMenuList(SurveyAsdVO surveyAsdVO) {
		return sqlSession.selectList("SurveyAsd.selectSurveyMenuList",surveyAsdVO);
	}

	public String selectDocNmByDocId(SurveyAsdVO surveyAsdVO) {
		return sqlSession.selectOne("SurveyAsd.selectDocNmByDocId",surveyAsdVO);
	}

	public int selectSurveyDtlListTotal(SurveyAsdVO surveyAsdVO) {
		return sqlSession.selectOne("SurveyAsd.selectSurveyDtlListTotal", surveyAsdVO);
	}

	public List<SurveyAsdVO> selectSurveyDtlList(SurveyAsdVO surveyAsdVO) {
		return sqlSession.selectList("SurveyAsd.selectSurveyDtlList",surveyAsdVO);
	}

	public String selectRndId(SurveyAsdVO surveyAsdVO){
		return sqlSession.selectOne("SurveyAsd.selectRndId",surveyAsdVO);
	}

	public String selectPerformCntByNm(SurveyAsdVO surveyAsdVO){
		return sqlSession.selectOne("SurveyAsd.selectPerformCntByNm",surveyAsdVO);
	}

	public int insertSurveyDocAoAnswer(SurveyAsdVO surveyAsdVO) {
		return sqlSession.update("SurveyAsd.insertSurveyDocAoAnswer", surveyAsdVO);
	}

	public int updatePerformMst(SurveyAsdVO surveyAsdVO) {
		return sqlSession.update("SurveyAsd.updatePerformMst", surveyAsdVO);
	}

	public int updateSurveyCv(SurveyAsdPerformMstVO surveyAsdPerformMstVO) {
		return sqlSession.update("SurveyAsd.updateSurveyCv", surveyAsdPerformMstVO);
	}

}
