package medical.survey.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.survey.service.SurveyPerformMstVO;
import medical.survey.service.SurveyTotalVO;
import medical.survey.service.SurveyVO;

@Repository("SurveyDAO")
public class SurveyDAO {
	@Autowired
	private SqlSession sqlSession;

	public String selectRndId(SurveyVO surveyVO){
		return sqlSession.selectOne("Survey.selectRndId",surveyVO);
	}
	public String selectDocNmByDocId(SurveyVO surveyVO){
		return sqlSession.selectOne("Survey.selectDocNmByDocId",surveyVO);
	}
	public String selectPerformCntByNm(SurveyVO surveyVO){
		return sqlSession.selectOne("Survey.selectPerformCntByNm",surveyVO);
	}
	public int insertSurveyDocAnswer(SurveyVO surveyVO) {
		return sqlSession.update("Survey.insertSurveyDocAnswer", surveyVO);
	}
	public int updateSurveyCv(SurveyPerformMstVO surveyPerformMstVO) {
		return sqlSession.update("Survey.updateSurveyCv", surveyPerformMstVO);
	}
	public int updateSurveyIv4(SurveyPerformMstVO surveyPerformMstVO) {
		return sqlSession.update("Survey.updateSurveyIv4", surveyPerformMstVO);
	}
	public int deleteSurveyAnswer(SurveyVO surveyVO) {
		return sqlSession.update("Survey.deleteSurveyAnswer", surveyVO);
	}
	
	public List<SurveyVO> selectPerformCntByIv4(){
		return sqlSession.selectList("Survey.selectPerformCntByIv4");
	}
	
	public List<SurveyVO> selectSurveyMenuList(SurveyVO surveyVO){
		return sqlSession.selectList("Survey.selectSurveyMenuList",surveyVO);
	}
	
	public List<SurveyVO> selectSurveyDtlList(SurveyVO surveyVO){
		return sqlSession.selectList("Survey.selectSurveyDtlList",surveyVO);
	}
	
	public List<SurveyVO> selectPerformCntList(SurveyVO surveyVO){
		return sqlSession.selectList("Survey.selectPerformCntList",surveyVO);
	}
	
	public List<SurveyVO> selectSurveyDtlExcelList(SurveyVO surveyVO){
		return sqlSession.selectList("Survey.selectSurveyDtlExcelList",surveyVO);
	}

	public int selectSurveyDtlListTotal(SurveyVO surveyVO) {
		return sqlSession.selectOne("Survey.selectSurveyDtlListTotal", surveyVO);
	}
	public List<SurveyTotalVO> selectSurveyTotalList(SurveyTotalVO surveyTotalVO) {
		return sqlSession.selectList("Survey.selectSurveyTotalList", surveyTotalVO);
	}
	public int selectSurveyTotalListTotal(SurveyTotalVO surveyTotalVO) {
		return sqlSession.selectOne("Survey.selectSurveyTotalListTotal", surveyTotalVO);
	}
	public int deleteSurveyTotalPm(SurveyVO surveyVO) {
		return sqlSession.update("Survey.deleteSurveyTotalPm", surveyVO);
	}
	public int updatePerformMst(SurveyVO surveyVO) {
		return sqlSession.update("Survey.updatePerformMst", surveyVO);
	}
	public int updateSurveyPerformMstTotal(SurveyVO surveyVO) {
		return sqlSession.update("Survey.updateSurveyPerformMstTotal", surveyVO);
	}
	public int updateSurveyPerformMst(SurveyVO surveyVO) {
		return sqlSession.update("Survey.updateSurveyPerformMst", surveyVO);
	}
	public List<SurveyVO> selectSurveyKcbclList(SurveyVO surveyVO) {
		return sqlSession.selectList("Survey.selectSurveyKcbclList",surveyVO);
	}
	public int selectSurveyKcbclListTotal(SurveyVO surveyVO) {
		return sqlSession.selectOne("Survey.selectSurveyKcbclListTotal", surveyVO);
	}

}
