package medical.framework.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestBaseValueInterceptorHandler extends HandlerInterceptorAdapter {

	protected Log log = LogFactory.getLog(this.getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

//		MemberVO vo = (MemberVO) request.getSession().getAttribute("member");
//		if (vo != null) {
//			request.setAttribute("sessionCompanyCode", vo.getCompanyCode());
//			request.setAttribute("sessionCompanyName", vo.getCompanyName());
//			request.setAttribute("sessionUserId", vo.getUserId());
//			request.setAttribute("sessionDivisionCode", vo.getDivisionCode());
//			request.setAttribute("sessionDivisionName", vo.getDivisionName());
//			request.setAttribute("sessionHubMasterId", vo.getHubMasterId());
//			request.setAttribute("loginCompanyCode", vo.getLoginCompanyCode());
//			request.setAttribute("dbSchemaName", vo.getDbSchemaName());
//		}

		return true;
	}
}
