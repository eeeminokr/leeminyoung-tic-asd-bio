package medical.main.service;

import java.util.List;

import medical.commoninfo.member.service.MemberVO;
import medical.framework.file.ExcelFile;

public interface MainService {
	
	List<MemberVO> selectMember(MemberVO memberVO);
	List<MemberVO> selectGrpAuth(MemberVO memberVO);
	List<MemberVO> selectMenuList(MemberVO memberVO);
	int updateUser(MemberVO memberVO);
	int updatePwd(MemberVO memberVO);
	int insertUser(MemberVO memberVO);
	int insertUserAuth(MemberVO memberVO);
	int insertUserMenuAuth(MemberVO memberVO);
	int deleteUser(MemberVO memberVO);
	int deleteUserAuth(MemberVO memberVO);
	int deleteUserMenuAuth(MemberVO memberVO);
	int uniqueUserId(MemberVO memberVO);
	List<DashboardVO> selectDashboardData(DashboardVO dashboardVO);
	List<DashboardVO> selectDashboardBarData(DashboardVO dashboardVO);
	List<DashboardVO> selectDashboardList(DashboardVO dashboardVO);
	ExcelFile dashboardExcelDownload(DashboardVO dashboardVO);
	List<DashboardVO> selectDashboardBarDataTotal(DashboardVO dashboardVO);
	List<DashboardVO> selectMaxPerformCnt(DashboardVO dashboardVO);
	List<DashboardVO> selectDashboardListVcnt(DashboardVO dashboardVO);
	List<DashboardVO> selectMaxPerformCntAsd(DashboardVO dashboardVO);
}
