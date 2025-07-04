package medical.neuropsy.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import medical.neuropsy.service.NeuropsySmsVO;
import medical.neuropsy.service.NeuropsyStroopVO;
import medical.neuropsy.service.NeuropsyTmtVO;
import medical.neuropsy.service.NeuropsyTotalVO;
import medical.neuropsy.service.NeuropsyVO;
import medical.neuropsy.service.NeuropsyWsctVO;


@Repository("NeuropsyDAO")
public class NeuropsyDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	public List<NeuropsyVO> selectNeuropsyMenuList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyMenuList",neuropsyVO);
	}
	
	public List<NeuropsyS1VO> selectNeuropsyS1List(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyS1List",neuropsyVO);
	}
	
	public List<NeuropsyS1VO> selectNeuropsyS1RowList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyS1RowList",neuropsyVO);
	}
	
	public int selectNeuropsyS1ListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyS1ListTotal",neuropsyVO);
	}
	
	public List<NeuropsyAtaVO> selectNeuropsyAtaList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyAtaList",neuropsyVO);
	}
	
	public int selectNeuropsyAtaListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyAtaListTotal",neuropsyVO);
	}
	
	public List<NeuropsyStroopVO> selectNeuropsyStroopList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyStroopList",neuropsyVO);
	}
	
	public int selectNeuropsyStroopListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyStroopListTotal",neuropsyVO);
	}

	public int insertNeuropsyS1(NeuropsyS1VO neuropsyS1VO) {
		return sqlSession.update("Neuropsy.insertNeuropsyS1", neuropsyS1VO);
	} 
	
	public int insertNeuropsyAta(NeuropsyAtaVO neuropsyAtaVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyAta", neuropsyAtaVO);
	}
	
	public int insertNeuropsyStroop(NeuropsyStroopVO neuropsyStroopVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyStroop", neuropsyStroopVO);
	}
	
	public String selectPerformCntByNm(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectPerformCntByNm",neuropsyVO);
	}

	public int selectNeuropsyCcttListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyCcttListTotal",neuropsyVO);
	}
	
	public List<NeuropsyCcttVO> selectNeuropsyCcttList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyCcttList",neuropsyVO);
	}
	
	public int insertNeuropsyCctt(NeuropsyCcttVO neuropsyCcttVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyCctt", neuropsyCcttVO);
	}
	
	public int selectNeuropsyWsctListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyWsctListTotal",neuropsyVO);
	}
	
	public List<NeuropsyWsctVO> selectNeuropsyWsctList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyWsctList",neuropsyVO);
	}
	
	public int insertNeuropsyWsct(NeuropsyWsctVO neuropsyWsctVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyWsct", neuropsyWsctVO);
	}
	
	public int selectNeuropsyCatListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyCatListTotal",neuropsyVO);
	}
	
	public List<NeuropsyCatVO> selectNeuropsyCatList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyCatList",neuropsyVO);
	}
	
	public int insertNeuropsyCat(NeuropsyCatVO neuropsyCatVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyCat", neuropsyCatVO);
	}
	
	public int selectNeuropsyExitiiListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyExitiiListTotal",neuropsyVO);
	}
	
	public List<NeuropsyExitiiVO> selectNeuropsyExitiiList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyExitiiList",neuropsyVO);
	}
	
	public int insertNeuropsyExitii(NeuropsyExitiiVO neuropsyExitiiVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyExitii", neuropsyExitiiVO);
	}
	
	public int selectNeuropsyCptListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyCptListTotal",neuropsyVO);
	}
	
	public List<NeuropsyCptVO> selectNeuropsyCptList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyCptList",neuropsyVO);
	}
	
	public int insertNeuropsyCpt(NeuropsyCptVO neuropsyCptVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyCpt", neuropsyCptVO);
	}
	
	public int selectNeuropsyTmtListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyTmtListTotal",neuropsyVO);
	}
	
	public List<NeuropsyTmtVO> selectNeuropsyTmtList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyTmtList",neuropsyVO);
	}
	
	public int insertNeuropsyTmt(NeuropsyTmtVO neuropsyTmtVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyTmt", neuropsyTmtVO);
	}
	
	public int selectNeuropsyTotalListTotal(NeuropsyVO neuropsyVO){
		return sqlSession.selectOne("Neuropsy.selectNeuropsyTotalListTotal",neuropsyVO);
	}
	
	public List<NeuropsyTotalVO> selectNeuropsyTotalList(NeuropsyVO neuropsyVO){
		return sqlSession.selectList("Neuropsy.selectNeuropsyTotalList",neuropsyVO);
	}
	
	public int deleteNeuropsyS1(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyS1", neuropsyVO);
	} 
	
	public int deleteNeuropsyAta(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyAta", neuropsyVO);
	}
	
	public int deleteNeuropsyStroop(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyStroop", neuropsyVO);
	}
	
	public int deleteNeuropsyCctt(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyCctt", neuropsyVO);
	}
	
	public int deleteNeuropsyWsct(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyWsct", neuropsyVO);
	}
	
	public int deleteNeuropsyCat(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyCat", neuropsyVO);
	}
	
	public int deleteNeuropsyExitii(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyExitii", neuropsyVO);
	}
	
	public int deleteNeuropsyCpt(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyCpt", neuropsyVO);
	}
	
	public int deleteNeuropsyTmt(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyTmt", neuropsyVO);
	}
	
	public int updatePerformMst(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.updatePerformMst", neuropsyVO);
	}

	public List<NeuropsyPepVO> selectNeuropsyPepList(NeuropsyVO neuropsyVO) {
		return sqlSession.selectList("Neuropsy.selectNeuropsyPepList", neuropsyVO);
	}

	public int selectNeuropsyPepListTotal(NeuropsyVO neuropsyVO) {
		return sqlSession.selectOne("Neuropsy.selectNeuropsyPepListTotal", neuropsyVO);
	}

	public List<NeuropsyAdos1VO> selectNeuropsyAdos1List(NeuropsyVO neuropsyVO) {
		return sqlSession.selectList("Neuropsy.selectNeuropsyAdos1List", neuropsyVO);
	}

	public int selectNeuropsyAdos1ListTotal(NeuropsyVO neuropsyVO) {
		return sqlSession.selectOne("Neuropsy.selectNeuropsyAdos1ListTotal", neuropsyVO);
	}

	public List<NeuropsyAdos2VO> selectNeuropsyAdos2List(NeuropsyVO neuropsyVO) {
		return sqlSession.selectList("Neuropsy.selectNeuropsyAdos2List", neuropsyVO);
	}

	public int selectNeuropsyAdos2ListTotal(NeuropsyVO neuropsyVO) {
		return sqlSession.selectOne("Neuropsy.selectNeuropsyAdos2ListTotal", neuropsyVO);
	}

	public List<NeuropsyAdos3VO> selectNeuropsyAdos3List(NeuropsyVO neuropsyVO) {
		return sqlSession.selectList("Neuropsy.selectNeuropsyAdos3List", neuropsyVO);
	}

	public int selectNeuropsyAdos3ListTotal(NeuropsyVO neuropsyVO) {
		return sqlSession.selectOne("Neuropsy.selectNeuropsyAdos3ListTotal", neuropsyVO);
	}

	public List<NeuropsySmsVO> selectNeuropsySmsList(NeuropsyVO neuropsyVO) {
		return sqlSession.selectList("Neuropsy.selectNeuropsySmsList", neuropsyVO);
	}

	public int selectNeuropsySmsListTotal(NeuropsyVO neuropsyVO) {
		return sqlSession.selectOne("Neuropsy.selectNeuropsySmsListTotal", neuropsyVO);
	}

	public List<NeuropsyCarsVO> selectNeuropsyCarsList(NeuropsyVO neuropsyVO) {
		return sqlSession.selectList("Neuropsy.selectNeuropsyCarsList", neuropsyVO);
	}

	public int selectNeuropsyCarsListTotal(NeuropsyVO neuropsyVO) {
		return sqlSession.selectOne("Neuropsy.selectNeuropsyCarsListTotal", neuropsyVO);
	}

	public List<NeuropsyS1VO> selectNeuropsyS1AsdList(NeuropsyVO neuropsyVO) {
		return sqlSession.selectList("Neuropsy.selectNeuropsyS1AsdList", neuropsyVO);
	}
	
	public int selectNeuropsyS1AsdListTotal(NeuropsyVO neuropsyVO) {
		return sqlSession.selectOne("Neuropsy.selectNeuropsyS1AsdListTotal", neuropsyVO);
	}

	public int insertNeuropsyAdos1(NeuropsyAdos1VO neuropsyAdos1VO) {
		return sqlSession.update("Neuropsy.insertNeuropsyAdos1", neuropsyAdos1VO);
	}

	public int insertNeuropsyAdos2(NeuropsyAdos2VO neuropsyAdos2VO) {
		return sqlSession.update("Neuropsy.insertNeuropsyAdos2", neuropsyAdos2VO);
	}

//	public int insertNeuropsyAdos3(NeuropsyAdos3VO neuropsyAdos3VO) {
//		return sqlSession.update("Neuropsy.insertNeuropsyAdos3", neuropsyAdos3VO);
//	}

	public int insertNeuropsyPep(NeuropsyPepVO neuropsyPepVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyPep", neuropsyPepVO);
	}

	public int insertNeuropsySms(NeuropsySmsVO neuropsySmsVO) {
		return sqlSession.update("Neuropsy.insertNeuropsySms", neuropsySmsVO);
	}

	public int insertNeuropsypCars(NeuropsyCarsVO neuropsyCarsVO) {
		return sqlSession.update("Neuropsy.insertNeuropsyCars", neuropsyCarsVO);
	}

	public int insertS1IKLeiter(NeuropsyS1VO neuropsyS1VO) {
		return sqlSession.update("Neuropsy.insertS1IKLeiter", neuropsyS1VO);
	}

	public int deleteNeuropsyAdos1(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyAdos1", neuropsyVO);
	}

	public int deleteNeuropsyAdos2(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyAdos2", neuropsyVO);
	}

	public int deleteNeuropsyAdos3(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyAdos3", neuropsyVO);
	}

	public int deleteNeuropsyPep(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyPep", neuropsyVO);
	}

	public int deleteNeuropsySms(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsySms", neuropsyVO);
	}

	public int deleteNeuropsyCars(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteNeuropsyCars", neuropsyVO);
	}

	public int deleteS1IKLeiter(NeuropsyVO neuropsyVO) {
		return sqlSession.update("Neuropsy.deleteS1IKLeiter", neuropsyVO);
	}
	
}
