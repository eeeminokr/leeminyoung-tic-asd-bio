package medical.main.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import medical.main.service.DashboardVO;
import medical.commoninfo.authority.service.AuthorityService;
import medical.commoninfo.authority.service.UsrAuthVO;
import medical.commoninfo.code.service.CodeService;
import medical.commoninfo.code.service.CodeVO;
import medical.commoninfo.member.service.MemberListVO;
import medical.commoninfo.member.service.MemberVO;
import medical.commoninfo.menu.service.MenuService;
import medical.commoninfo.menu.service.MenuVO;
import medical.dataIntegration.service.DataIntegrationListVO;
import medical.framework.file.ExcelFile;
import medical.framework.util.AES256Util;
import medical.framework.util.Constant;
import medical.framework.util.JsonUtils;
import medical.main.service.MainService;
import medical.target.service.TargetService;
import medical.target.service.TargetVO;

@Controller
public class MainController {

	/** Sevice Class */
	@Resource(name = "MainService")
	private MainService mainService;
	@Resource(name = "MenuService")
	private MenuService menuService;
	@Resource(name = "CodeService")
	private CodeService codeService;
	@Resource(name = "TargetService")
	private TargetService targetService;
	@Resource(name = "AuthorityService")
	private AuthorityService authorityService;
	
	

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Login session 사용 예)
	 * ((MemberVO)session.getAttribute(Constant.SESSION_MEMBER)).getComCode();
	 * 
	 * @return ModelAndView
	 * @exception Exception
	 */
	@RequestMapping("/medical/main/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, @ModelAttribute("memberVO") MemberVO memberVO,	ModelMap model) throws Exception {

		List<MemberVO> result = mainService.selectMember(memberVO);
		MemberVO obj;
		boolean authCheck = false;
		if(result.size()>0) {
			// 사용자의 권한과 이름을 Session에 저장
			obj = (MemberVO) result.get(0);
			
			//비밀번호 확인
			AES256Util aes = new AES256Util(obj.getIdx());
			String dePw =  aes.decrypt(obj.getUserPwd());
			if(memberVO.getUserPwd().equals(dePw)) {
			}else {
				throw new RuntimeException("아이디 또는 비밀번호가 잘못 입력되었습니다.");
			}
			
			// session 생성 및 사용자 권한 확인
			for(MemberVO vo : result) {
				//if(StringUtil.isEquals(memberVO.getUserAuth(), vo.getUserAuth())) {
					vo.setSessionUserId(vo.getUserId());
					vo.setUserPwd(aes.decrypt(vo.getUserPwd()));
					session.setAttribute(Constant.SESSION_MEMBER, vo);
					authCheck = true;
				//}				
			}	
			if(!authCheck){
				throw new RuntimeException("권한이 없습니다.");
			}
			session.setMaxInactiveInterval(60 * 60);
		
			//로그인 성공
			if (logger.isDebugEnabled()) {
				logger.info("USER:[" + memberVO.getUserId()+ "]");
			}
			
			//menuList
			MenuVO menuVO = new MenuVO();
			List<MenuVO> menuList = menuService.selectMenuList(menuVO);
			if (menuList == null || menuList.size() == 0) {
				throw new RuntimeException("관리자에게 문의하십시오.<br>권한이 없습니다.");
			}
			session.setAttribute("menuList", menuList);
			
			//메뉴별 권한설정
			UsrAuthVO authVO = new UsrAuthVO();
			authVO.setUserId(obj.getUserId());
			List<UsrAuthVO> authList = authorityService.selectUsrAuthList(authVO);
			session.setAttribute("authList", authList);
			
			//session에 disClassDtl 값 추가
			session.setAttribute("disClassDtl", "DS001");
			
			//대상자 Follow up 리스트
			TargetVO targetVO = new TargetVO();
			List<TargetVO> followList = targetService.selectTargetFollowUpList(targetVO);
			session.setAttribute("fllowUpList", followList);
			
		}else {
			
			throw new RuntimeException("아이디 또는 비밀번호가 잘못 입력되었습니다.");
		}
				
		return JsonUtils.processResult("");
	}
	
	/**
	 * Logout
	 * 
	 * @return ModelAndView
	 * @exception Exception
	 */
	@RequestMapping("/medical/main/logout.do")
	public ModelAndView logout(HttpSession session, ModelMap model) throws Exception {

		if (logger.isDebugEnabled()) {
			logger.debug("logout : debug...........");
		}

		if (session != null && session.getAttribute(Constant.SESSION_MEMBER) != null) {
			session.removeAttribute("member");
			session.invalidate();
		}
		return new ModelAndView("redirect:/main.view");
	}
	
	@RequestMapping("/medical/main/selectMenuList.do")
	public ModelAndView selectMenuList(HttpSession session, ModelMap model, @ModelAttribute("menuVO") MenuVO menuVO) throws Exception {
		
		//menuList
		List<MenuVO> menuList = menuService.selectMenuList(menuVO);
		//session에 disClassDtl 값 추가
		session.setAttribute("disClassDtl", menuVO.getDisClassDtl());
		
		model.put("success", true);
		model.put("result", menuList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/main/selectDiseMenuList.do")
	public ModelAndView selectDiseMenuList(HttpSession session, ModelMap model,@ModelAttribute("codeVO") CodeVO codeVO) throws Exception {
		
		List<CodeVO> menuList = codeService.selectCodeDetailSearchCondition(codeVO);
		model.put("success", true);
		model.put("result", menuList);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/basicinfo/selectUser.do")
	public ModelAndView selectUser(HttpServletRequest request, @ModelAttribute("memberVO") MemberVO memberVO,	
			ModelMap model) throws Exception {
		List<MemberVO> result = mainService.selectMember(memberVO);
		MemberVO mVO = result.get(0);;
		//비밀번호 확인
		AES256Util aes = new AES256Util(mVO.getIdx());
		mVO.setUserPwd(aes.decrypt(mVO.getUserPwd()));
		mVO.setPhoneNum(aes.decrypt(mVO.getPhoneNum()));
		mVO.setEmail(aes.decrypt(mVO.getEmail()));
		model.put("success", true);
		model.put("result", mVO);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/basicinfo/selectMemberList.do")
	public ModelAndView selectMemberList(HttpServletRequest request, @ModelAttribute("memberVO") MemberVO memberVO,	
			ModelMap model) throws Exception {
		List<MemberVO> result = mainService.selectMember(memberVO);
		//전화번호, 이메일 복호화
		AES256Util aes;
		for(MemberVO vo : result) {
			aes = new AES256Util(vo.getIdx());
			vo.setUserPwd(aes.decrypt(vo.getUserPwd()));
			vo.setPhoneNum(aes.decrypt(vo.getPhoneNum()));
			vo.setEmail(aes.decrypt(vo.getEmail()));
		}		
		model.put("success", true);
		model.put("result", result);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/basicinfo/selectGrpAuth.do")
	public ModelAndView selectGrpAuth(HttpServletRequest request, @ModelAttribute("memberVO") MemberVO memberVO,	
			ModelMap model) throws Exception {
		MemberVO vo = new MemberVO();
		List<MemberVO> result = mainService.selectGrpAuth(vo);
		
		model.put("success", true);
		model.put("result", result);
		return new ModelAndView("jsonView", model);
	}
	
	@RequestMapping("/medical/basicinfo/updateUser.do")
	public ModelAndView updateUser(HttpServletRequest request, HttpSession session, @ModelAttribute("memberVO") MemberVO memberVO,	
			ModelMap model) throws Exception {
		MemberVO sessionMember = (MemberVO) session.getAttribute(Constant.SESSION_MEMBER);
		List<MemberVO> userAuthVO = mainService.selectGrpAuth(memberVO);
		List<MemberVO> menuListVO = mainService.selectMenuList(memberVO);
		memberVO.setCreateBy(sessionMember.getUserId());
		memberVO.setUpdateBy(sessionMember.getUserId());
		MemberVO menuAuthVO;
		int result = mainService.updateUser(memberVO);
		for(MemberVO menuVO : menuListVO) {
			menuAuthVO = new MemberVO();
			menuAuthVO.setMenuId(menuVO.getMenuId());
			menuAuthVO.setUserId(memberVO.getUserId());
			menuAuthVO.setCreateBy(sessionMember.getUserId());
			menuAuthVO.setUpdateBy(sessionMember.getUserId());
			menuAuthVO.setInsertYn(userAuthVO.get(0).getInsertYn());
			menuAuthVO.setSelectYn(userAuthVO.get(0).getSelectYn());
			menuAuthVO.setModifyYn(userAuthVO.get(0).getModifyYn());
			menuAuthVO.setDeleteYn(userAuthVO.get(0).getDeleteYn());
			menuAuthVO.setUploadYn(userAuthVO.get(0).getUploadYn());
			menuAuthVO.setDownYn(userAuthVO.get(0).getDownYn());
			result += mainService.insertUserMenuAuth(menuAuthVO);
		}
//		result += mainService.deleteUserAuth(memberVO);
//		result += mainService.insertUserAuth(memberVO);
		model.put("success", true);
		model.put("result", result);
		return new ModelAndView("jsonView", model);
	}

	@RequestMapping("/medical/basicinfo/updatePwd.do")
	public ModelAndView updatePwd(HttpSession session,	@ModelAttribute("memberVO") MemberVO memberVO, ModelMap model,
			HttpServletRequest request) throws Exception {
		MemberVO ssesionMember = (MemberVO) session.getAttribute(Constant.SESSION_MEMBER);
		memberVO.setUpdateBy(ssesionMember.getUserId());
		int cnt = mainService.updatePwd(memberVO);
		String message = "";
		if(cnt ==1 ) {
			message = "수정되었습니다.";
		}else {
			message = "수정 실패하였습니다.";
		}
		return JsonUtils.processResult(message);
		
	}
	
	@RequestMapping("/medical/basicinfo/insertUser.do")
	public ModelAndView insertMember(HttpSession session, @ModelAttribute("memberVO") MemberVO memberVO, ModelMap model,
								HttpServletRequest request) throws Exception {
		MemberVO sessionMember = (MemberVO) session.getAttribute(Constant.SESSION_MEMBER);
		List<MemberVO> userAuthVO = mainService.selectGrpAuth(memberVO);
		List<MemberVO> menuListVO = mainService.selectMenuList(memberVO);
		MemberVO menuAuthVO;
		memberVO.setCreateBy(sessionMember.getUserId());
		memberVO.setUpdateBy(sessionMember.getUserId());
		int result = mainService.insertUser(memberVO);
		for(MemberVO menuVO : menuListVO) {
			menuAuthVO = new MemberVO();
			menuAuthVO.setMenuId(menuVO.getMenuId());
			menuAuthVO.setUserId(memberVO.getUserId());
			menuAuthVO.setCreateBy(sessionMember.getUserId());
			menuAuthVO.setUpdateBy(sessionMember.getUserId());
			menuAuthVO.setInsertYn(userAuthVO.get(0).getInsertYn());
			menuAuthVO.setSelectYn(userAuthVO.get(0).getSelectYn());
			menuAuthVO.setModifyYn(userAuthVO.get(0).getModifyYn());
			menuAuthVO.setDeleteYn(userAuthVO.get(0).getDeleteYn());
			menuAuthVO.setUploadYn(userAuthVO.get(0).getUploadYn());
			menuAuthVO.setDownYn(userAuthVO.get(0).getDownYn());
			result += mainService.insertUserMenuAuth(menuAuthVO);
		}
//		cnt += mainService.insertUserAuth(memberVO);
//		String message = "";
//		if(cnt == 2 ) {
//			message = "저장되었습니다.";
//		}else {
//			message = "저장 실패하였습니다.";
//		}
//		return JsonUtils.processResult(message);
		model.put("success", true);
		model.put("result", result);
		return new ModelAndView("jsonView", model);
	}
		
	@RequestMapping("/medical/basicinfo/checkUserId.do")
	public ModelAndView dirtyUserId(HttpSession session,
			@ModelAttribute("memberVO") MemberVO memberVO, ModelMap model) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("success", false);

		int cnt = mainService.uniqueUserId(memberVO); 
		if (cnt == 0) {
			// 존재하지 않음.
			modelMap.put("success", true);
		}
		return JsonUtils.describe(modelMap);
	}
	
	@RequestMapping("/medical/basicinfo/deleteUser.do")
	public ModelAndView deleteUser(HttpSession session,	@RequestBody MemberListVO memberListVO) {
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		try {
			for(MemberVO vo : memberListVO.getMemberList()) {
				mainService.deleteUser(vo);
//				mainService.deleteUserAuth(vo);
				mainService.deleteUserMenuAuth(vo);
			}
			modelMap.put("success", true);
		}catch(Exception e) {
			modelMap.put("success", false);
			e.printStackTrace();
		}finally {
			
		}
		return new ModelAndView("jsonView", modelMap);
	}

	
	@RequestMapping("/medical/main/selectDashboardData.do")
	public ModelAndView selectDashboardData(HttpSession session, @ModelAttribute("dashboardVO") DashboardVO dashboardVO,
			ModelMap model) throws Exception {
		System.out.println("TEST : " + dashboardVO.getClassCdDtl());
		List<DashboardVO> result =  mainService.selectDashboardData(dashboardVO);
		
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/main/selectDashboardBarData.do")
	public ModelAndView selectDashboardBarData(HttpSession session, @ModelAttribute("dashboardVO") DashboardVO dashboardVO,
			ModelMap model) throws Exception {
		
		List<DashboardVO> result =  mainService.selectDashboardBarData(dashboardVO);
		
		model.put("success",true);
		model.put("result", result);
		
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/main/selectDashboardBarDataTotal.do")
	public ModelAndView selectDashboardBarDataTotal(HttpSession session, @ModelAttribute("dashboardVO") DashboardVO dashboardVO,
			ModelMap model) throws Exception {
		List<DashboardVO> result =  mainService.selectDashboardBarDataTotal(dashboardVO);
		
		model.put("success",true);
		model.put("result", result);
		
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/main/selectDashboardList.do")
	public ModelAndView selectDashboardList(HttpSession session, @ModelAttribute("dashboardVO") DashboardVO dashboardVO,
			ModelMap model) throws Exception {
		
		List<DashboardVO> result =  mainService.selectDashboardList(dashboardVO);
		
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/main/selectMaxPerformCnt.do")
	public ModelAndView selectMaxPerformCnt(HttpSession session, @ModelAttribute("dashboardVO") DashboardVO dashboardVO,
			ModelMap model) throws Exception {
		
//		String result = mainService.selectMaxPerformCnt(dashboardVO);
		String classCdDtl = dashboardVO.getClassCdDtl();
		List<DashboardVO> result=null;
		System.out.println(classCdDtl);
		if(classCdDtl.equals("DS003")) {
			result = mainService.selectMaxPerformCntAsd(dashboardVO);
		}else {
			result = mainService.selectMaxPerformCnt(dashboardVO);
		}
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	@RequestMapping("/medical/main/selectDashboardListVcnt.do")
	public ModelAndView selectDashboardListVcnt(HttpSession session, @ModelAttribute("dashboardVO") DashboardVO dashboardVO,
			ModelMap model) throws Exception {
		
		List<DashboardVO> result = mainService.selectDashboardListVcnt(dashboardVO);
		
		model.put("success",true);
		model.put("result",result);
		return JsonUtils.describe(model);
	}
	
	
	@RequestMapping("/medical/main/dashboardListExcelDownload.do")
	public ModelAndView dashboardExcelDownload(HttpServletRequest request, @ModelAttribute("dashboardVO")
	DashboardVO dashboardVO) throws Exception {
		ExcelFile excelFile = mainService.dashboardExcelDownload(dashboardVO);
		
		return new ModelAndView("download", "download", excelFile);
	}
	
}