package medical.framework.handler;

import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import medical.commoninfo.member.service.MemberVO;
import medical.framework.util.Constant;
import medical.framework.util.StringUtil;

public class SessionInterceptorHandler  extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

//	@Resource(name = "ConfigurationService")
//	private ConfigurationService configurationService;
	
//	@Resource(name = "CompanyService")
//	private CompanyService companyService;
	@Autowired
    private ServletContext servletContext;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		String contextPath = request.getContextPath();
		String requestUri = request.getRequestURI();

		logger.debug("- SessionInterceptorHandler -");
		logger.debug("requestURI = {}", requestUri);
		logger.debug("contextPath = {}", contextPath);
		
		if (requestUri.matches("(\\S)*/directLogin?\\.(do|view)$")
				|| requestUri.matches("(\\S)*/downFile?\\.(do|view)$")
				|| requestUri.matches("(\\S)*/login?\\.(do|view)$")
				|| requestUri.matches("(\\S)*/server/js/configuration\\.do$")
				|| requestUri.matches("(\\S)*/server/js/configUI\\.do$")
				|| requestUri.matches("(\\S)*/logout?\\.(do|view)$")
				|| requestUri.matches("(\\S)*/modifyPassword.do")
				|| requestUri.matches("(\\S)*/loginFrameCheck.(do|view)$")
				) {

			logger.debug(">> {}", requestUri);

			return true;
		}

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute(Constant.SESSION_MEMBER);
		if (member == null || StringUtil.isEmptyString(member.getUserId())) {
			String url = requestUri;

			Enumeration<String> names = request.getParameterNames();
			int i = 0;
			while (names.hasMoreElements()) {
				String name = names.nextElement();

				url += (i == 0) ? '?' : '&';
				url += name + '=' + request.getParameter(name);

				i++;
			}

			url = URLEncoder.encode(url, "UTF-8");
			response.sendRedirect(contextPath + "/loginFrameCheck.view?r=" + url);
			return false;
		}

		return true;
	}
}
