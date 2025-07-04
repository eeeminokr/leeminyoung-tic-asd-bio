package medical.framework.jstl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import medical.commoninfo.authority.service.AuthorityService;
import medical.commoninfo.authority.service.UsrAuthVO;
import medical.commoninfo.member.service.MemberVO;
import medical.framework.util.Constant;

public class AuthorizeTag extends RequestContextAwareTag {

	private static final long serialVersionUID = 609739387131011758L;
	AuthorityService authorityService;
	// attribute

	private String menuId;
	private String authName;

	public String getMenuId() {
		return menuId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}

	@SuppressWarnings({ "unused", "deprecation" })
	@Override
	public int doStartTagInternal() throws JspException {
		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        HttpSession session = request.getSession();
        String auth="";
        UsrAuthVO authVO = new UsrAuthVO();
        if (authorityService == null) {
			WebApplicationContext wac = getRequestContext().getWebApplicationContext();
			authorityService = (AuthorityService) wac.getBean("AuthorityService");
		}
        try {
        	MemberVO memberVO = (MemberVO) session.getAttribute(Constant.SESSION_MEMBER);
        	authVO.setUserId(memberVO.getUserId());
        	authVO.setMenuId(menuId);
        	@SuppressWarnings("unchecked")
			List<UsrAuthVO> authList = (List<UsrAuthVO>) session.getAttribute("authList");
        	for(UsrAuthVO vo : authList) {
        		if(menuId.equals(vo.getMenuId())) {
        			authVO = vo;
        		}
        	}
        } catch (Exception e) {
            return SKIP_BODY;
        }
        String checkAuth="";
        if("insertYn".equals(authName)) checkAuth = authVO.getInsertYn();
        else if("modifyYn".equals(authName)) checkAuth = authVO.getModifyYn();
        else if("deleteYn".equals(authName)) checkAuth = authVO.getDeleteYn();
        else if("uploadYn".equals(authName)) checkAuth = authVO.getUploadYn();
        else if("downYn".equals(authName)) checkAuth = authVO.getDownYn();
        
        if ("O".equals(checkAuth)) {
				return EVAL_BODY_INCLUDE; // jsp Body에 출력 , private method.
        }
		return SKIP_BODY;
    }

	public void doFinally() {
		
	}
	
}
