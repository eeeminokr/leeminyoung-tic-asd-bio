package medical.main.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.hamcrest.text.IsEqualIgnoringWhiteSpace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import medical.common.service.AbstractService;
import medical.commoninfo.member.service.MemberVO;
import medical.dataIntegration.service.DataIntegrationListVO;
import medical.framework.file.ExcelFile;
import medical.framework.file.ExcelFileWriter;
import medical.framework.util.AES256Util;
import medical.framework.util.StringUtil;
import medical.main.service.DashboardVO;
import medical.main.service.MainService;

@Service("MainService")
public class MainServiceImpl extends AbstractService implements MainService{

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	private ExcelFileWriter<DashboardVO> dashboardListExcelFileWriter;
	private ExcelFileWriter<DashboardVO> dashboardListAsdExcelFileWriter;
	

	public void setDashboardListExcelFileWriter(
			ExcelFileWriter<DashboardVO> dashboardListExcelFileWriter) {
		this.dashboardListExcelFileWriter = dashboardListExcelFileWriter;
	}
	public void setDashboardListAsdExcelFileWriter(
			ExcelFileWriter<DashboardVO> dashboardListAsdExcelFileWriter) {
		this.dashboardListAsdExcelFileWriter = dashboardListAsdExcelFileWriter;
	}

	/** DAO Class */
	@Resource(name = "MainDAO")
	private MainDAO mainDAO;
	
	public List<MemberVO> selectMember(MemberVO memberVO) {
		return mainDAO.selectMember(memberVO);
	}
	
	public List<MemberVO> selectGrpAuth(MemberVO memberVO) {
		return mainDAO.selectGrpAuth(memberVO);
	}
	
	public List<MemberVO> selectMenuList(MemberVO memberVO) {
		return mainDAO.selectMenuList(memberVO);
	}
	
	public int updateUser(MemberVO memberVO) {
		try {
			AES256Util aes = new AES256Util(memberVO.getIdx());
			//전화번호 , 이메일 암호화하기
			String telNo = memberVO.getPhoneNum();
			String email = memberVO.getEmail();
			String pw = memberVO.getUserPwd();
			memberVO.setPhoneNum(aes.encrypt(telNo));
			memberVO.setEmail(aes.encrypt(email));
			if(!StringUtil.isEmptyString(pw))memberVO.setUserPwd(aes.encrypt(pw));
		}catch(Exception e) {
			e.printStackTrace();
		}
		int result = mainDAO.updateUser(memberVO);
		return result;
	}
	
	public int updatePwd(MemberVO memberVO) {
		try {			
			AES256Util aes = new AES256Util(memberVO.getIdx());
			//비밀번호 암호화하기
			String pw = memberVO.getUserPwd();
			memberVO.setUserPwd(aes.encrypt(pw));
		}catch(Exception e) {
			e.printStackTrace();
		}
		int result = mainDAO.updatePwd(memberVO);
		return result;
	}
	
	public int insertUser(MemberVO memberVO) {
		String idx = generateIdx();
		memberVO.setIdx(idx);
		try {
			AES256Util aes = new AES256Util(idx);
			
			//전화번호 , 이메일, 비밀번호 암호화하기
			String telNo = memberVO.getPhoneNum();
			String email = memberVO.getEmail();
			String pw = memberVO.getUserPwd();
			memberVO.setPhoneNum(aes.encrypt(telNo));
			memberVO.setEmail(aes.encrypt(email));
			memberVO.setUserPwd(aes.encrypt(pw));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		int result = mainDAO.insertUser(memberVO);
		return result;
	}

	public int insertUserAuth(MemberVO memberVO) {
		return mainDAO.insertUserAuth(memberVO);
	}
	
	public int insertUserMenuAuth(MemberVO memberVO) {
		return mainDAO.insertUserMenuAuth(memberVO);
	}
	
	private String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
	private String generateIdx() {
		return generateUUID().replaceAll("-", "").toUpperCase();
	}	
	
	public int deleteUser(MemberVO memberVO) {
		return mainDAO.deleteUser(memberVO);
	}
		
	public int deleteUserAuth(MemberVO memberVO) {
		return mainDAO.deleteUserAuth(memberVO);
	}
	
	public int deleteUserMenuAuth(MemberVO memberVO) {
		return mainDAO.deleteUserMenuAuth(memberVO);
	}
	
	public int uniqueUserId(MemberVO memberVO) {
		return mainDAO.uniqueUserId(memberVO);
	}

	@Override
	public List<DashboardVO> selectDashboardData(DashboardVO dashboardVO) {
		List<DashboardVO> list = mainDAO.selectDashboardData(dashboardVO);
		
		int val1 = Integer.parseInt(list.get(list.size()-1).getPtc01());
		int val2 = Integer.parseInt(list.get(list.size()-1).getPtc02());
		int val3 = Integer.parseInt(list.get(list.size()-1).getPtc03());
		
		int yvalue3 = val1;
		int yvalue4 = 10;
		
		if(yvalue3 < val2) {yvalue3 = val2;}
		if(yvalue3 < val3) {yvalue3 = val3;}
		
		if((yvalue3 % 50) == 0) {yvalue3 += 50;}
		
			while(yvalue3 % 50 != 0) {
				yvalue3++;
			}
		
		if(yvalue3 > 500) {
			yvalue4 = 100;
		}else if(yvalue3 >= 200) {
			yvalue4 = 50;
		}
		
		if(list!=null) {
			list.get(0).setyValue3(yvalue3);
			list.get(0).setyValue4(yvalue4);
		}
		
		return list;
	}

	@Override
	public List<DashboardVO> selectDashboardBarData(DashboardVO dashboardVO) {
		return mainDAO.selectDashboardBarData(dashboardVO);
	}

	@Override
	public List<DashboardVO> selectDashboardList(DashboardVO dashboardVO) {
		return mainDAO.selectDashboardList(dashboardVO);
	}

	@Override
	public ExcelFile dashboardExcelDownload(DashboardVO dashboardVO) {
		List<DashboardVO> result = new ArrayList<DashboardVO>();
		String maxCnt = dashboardVO.getPerformCnt();
		int max = Integer.parseInt(maxCnt); // 7 (차수가 v3까지 임) 
		String classCdDtl = dashboardVO.getClassCdDtl();
		System.out.println("classCdDtl :" + classCdDtl);
		List<DashboardVO> list = null;
		DashboardVO dashboardHeaderVO = null;
		if(StringUtil.trim(classCdDtl).equals(StringUtil.trim("DS003"))) {
			dashboardHeaderVO = mainDAO.selectMaxPerformCntAsd(dashboardVO).get(0);
			list = mainDAO.selectDashboardListAsd(dashboardVO);
		}else{ 
		//DashboardVO dashboardHeaderVO = mainDAO.selectMaxPerformCnt(dashboardVO).get(0);
			dashboardHeaderVO = mainDAO.selectMaxPerformCnt(dashboardVO).get(0);
		//List<DashboardVO> list = mainDAO.selectDashboardList(dashboardVO);
			list = mainDAO.selectDashboardList(dashboardVO);	
		}
		//차수 max , 차수명 리스트
		list.get(0).setPerformCnt(dashboardHeaderVO.getPerformCnt());
		list.get(0).setPerformNm(dashboardHeaderVO.getPerformNm());
		
		int vCnt = 5;
		
		String[] sArr = new String[10];
		
		for(int i = 0; i < max-4; i++) {
			
			String pCnt = String.valueOf(vCnt);
			dashboardVO.setPerformCnt(pCnt);
			List<DashboardVO> vCntList = mainDAO.selectDashboardListVcnt(dashboardVO);

			for(int j = 0; j < vCntList.size(); j++) {
				String arr = "";
				
				if(i == 0) {
					arr = vCntList.get(j).getS4pc5();
					arr += ",";
					arr += vCntList.get(j).getS3pc5();
					arr += ",";
					arr += vCntList.get(j).getS2pc5();
					arr += ",";
					arr += vCntList.get(j).getS1pc5();
					sArr[j] = arr;
				}else {
					arr += ",";
					arr += vCntList.get(j).getS4pc5();
					arr += ",";
					arr += vCntList.get(j).getS3pc5();
					arr += ",";
					arr += vCntList.get(j).getS2pc5();
					arr += ",";
					arr += vCntList.get(j).getS1pc5();
					sArr[j] += arr;
				}
			}
			vCnt++;
		}
		
			for(int k = 0; k < 10; k++) {
				list.get(k).setSpcList(sArr[k]);
			}
			
			result.addAll(list);
	
		if(classCdDtl.equals("DS003")) {
			return  dashboardListAsdExcelFileWriter.excelWrite(result, ExcelFile.XLSX);
		}else {
			return  dashboardListExcelFileWriter.excelWrite(result, ExcelFile.XLSX);
		}
		
	}

	@Override
	public List<DashboardVO> selectDashboardBarDataTotal(DashboardVO dashboardVO) {
		List<DashboardVO> list = mainDAO.selectDashboardBarDataTotal(dashboardVO);
		
		int yvalue1 = 1;
		int yvalue2 = 10;
		
		for(DashboardVO vo : list) {
			int val = Integer.parseInt(vo.getYyyyTotal());
			if(yvalue1 < val) {yvalue1 = val;}
		}
		
		if((yvalue1 % 50) == 0) {yvalue1 += 50;}
		
			while((yvalue1 % 50) != 0) {
				yvalue1++;
			}
			
		if(yvalue1 >= 200) {
			yvalue2 = 50;
		}
		
		if(list!=null) {
			list.get(0).setyValue1(yvalue1);
			list.get(0).setyValue2(yvalue2);
		}
		
		return list;

	}

	@Override
	public List<DashboardVO> selectMaxPerformCnt(DashboardVO dashboardVO) {
		return mainDAO.selectMaxPerformCnt(dashboardVO);
	}
	
	@Override
	public List<DashboardVO> selectMaxPerformCntAsd(DashboardVO dashboardVO) {
		return mainDAO.selectMaxPerformCntAsd(dashboardVO);
	}

	@Override
	public List<DashboardVO> selectDashboardListVcnt(DashboardVO dashboardVO) {
		List<DashboardVO> result = new ArrayList<DashboardVO>();
		String maxCnt = dashboardVO.getPerformCnt();
		int max = Integer.parseInt(maxCnt);
				
		for(int i = 5; i <= max; i++) {
			String pCnt = String.valueOf(i);
			dashboardVO.setPerformCnt(pCnt);
			result.addAll(mainDAO.selectDashboardListVcnt(dashboardVO));
		}
		
		return result;
	}
}
