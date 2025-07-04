package medical.main.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import medical.commoninfo.member.service.MemberVO;
import medical.main.service.DashboardVO;


@Repository("MainDAO")
public class MainDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberVO> selectMember(MemberVO memberVO){
		return sqlSession.selectList("Main.selectMember",memberVO);
	}
	
	public List<MemberVO> selectGrpAuth(MemberVO memberVO){
		return sqlSession.selectList("Main.selectGrpAuth", memberVO);
	}
	
	public List<MemberVO> selectMenuList(MemberVO memberVO){
		return sqlSession.selectList("Main.selectMenuList", memberVO);
	}
	
	public int updateUser(MemberVO memberVO){
		return sqlSession.update("Main.updateUser",memberVO);
	}
	
	public int updatePwd(MemberVO memberVO){
		return sqlSession.update("Main.updatePwd",memberVO);
	}
	
	public int insertUser(MemberVO memberVO) {
		return sqlSession.insert("Main.insertUser",memberVO);
	}
	
	public int insertUserAuth(MemberVO memberVO) {
		return sqlSession.insert("Main.insertUserAuth",memberVO);
	}
	
	public int insertUserMenuAuth(MemberVO memberVO) {
		return sqlSession.insert("Main.insertUserMenuAuth",memberVO);
	}
	
	public int deleteUser(MemberVO memberVO) {
		return sqlSession.delete("Main.deleteUser",memberVO);
	}
	
	public int deleteUserAuth(MemberVO memberVO) {
		return sqlSession.delete("Main.deleteUserAuth",memberVO);
	}
	
	public int deleteUserMenuAuth(MemberVO memberVO) {
		return sqlSession.delete("Main.deleteUserMenuAuth",memberVO);
	}
	
	public int uniqueUserId(MemberVO memberVO) {
		return sqlSession.selectOne("Main.uniqueUserId",memberVO);
	}

	public List<DashboardVO> selectDashboardData(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectDashboardData", dashboardVO);
	}

	public List<DashboardVO> selectDashboardBarData(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectDashboardBarData", dashboardVO);
	}

	public List<DashboardVO> selectDashboardList(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectDashboardList", dashboardVO);
	}

	public List<DashboardVO> selectDashboardBarDataTotal(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectDashboardBarDataTotal", dashboardVO);
	}

	public List<DashboardVO> selectMaxPerformCnt(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectMaxPerformCnt", dashboardVO);
	}

	public List<DashboardVO> selectDashboardListVcnt(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectDashboardListVcnt", dashboardVO);
	}

	public List<DashboardVO> selectMaxPerformCntAsd(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectMaxPerformCntAsd", dashboardVO);
	}

	public List<DashboardVO> selectDashboardListAsd(DashboardVO dashboardVO) {
		return sqlSession.selectList("Main.selectDashboardListAsd", dashboardVO);
	}

}
