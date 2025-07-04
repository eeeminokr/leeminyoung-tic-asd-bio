package medical.framework.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import medical.commoninfo.member.service.MemberVO;
import medical.framework.util.Constant;
import medical.framework.util.ResourceBundleUtil;
import medical.framework.util.StringUtil;

public class SimpleForwardController implements Controller {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private SimpleDateFormat sdfYyyy = new SimpleDateFormat("yyyy");
	private SimpleDateFormat sdfYyyymm = new SimpleDateFormat("yyyyMM");

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		MemberVO mv = (MemberVO) session.getAttribute(Constant.SESSION_MEMBER);

		ModelAndView mav = new ModelAndView();
		mav.setViewName(getViewName(request));

		// random int
		mav.addObject("rnd", getRandom());
		// contextPath
		mav.addObject("contextPath", getContextPath(request));

		if (mv != null) {
			// page title
			mav.addObject("pageTitle", getPageTitle(request));

			Map<String, String> parameter = new HashMap<String, String>();

			/**
			 * 쿠키에 있는 데이터 먼저
			 */
			String requestURI = request.getRequestURI();
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				String cookieName = URLDecoder.decode(cookie.getName(), "UTF-8");
				if (cookieName.equals(requestURI) == true) {
					parameter.putAll(convertParameterToObject(cookie.getValue()));
					
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			
			/**
			 * 파라미터
			 */

			Enumeration<String> keys = request.getParameterNames();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = getParameter(request, key);

				if (value != null) {
					parameter.put(key, value);
				}
			}

			parameter.put("pageNum", getParameter(request, "pageNum", "0"));
			parameter.put("sub", getParameter(request, "sub", "-1"));

			// 꼭 있어야 하는 것들
			String yyyy = parameter.get("yyyy");
			if (yyyy == null) {
				parameter.put("yyyy", getYyyymm());
			}
			String fromYyyymm = parameter.get("fromYyyymm");
			if (fromYyyymm == null) {
				parameter.put("fromYyyymm", getFromYyyymm());
			}
			String toYyyymm = parameter.get("toYyyymm");
			if (toYyyymm == null) {
				parameter.put("toYyyymm", getToYyyymm());
			}
			String activePage = parameter.get("activePage");
			if (activePage == null) {
				parameter.put("activePage", "1");
			}
			String pageSize = parameter.get("pageSize");
			if (pageSize == null) {
				parameter.put("pageSize", "50");
			}
			
			// add parameter
			mav.addObject("parameter", parameter);
		}

		// 캐쉬되는 것을 방지
		response.setHeader("Cache-Control", "no-store"); // http 1.1
		response.setHeader("Pragme", "no-cache"); // http 1.0
		// proxy server에 캐쉬되는 것을 막는다
		response.setDateHeader("Expires", -1);

		return mav;
	}

	private Map<String, String> convertParameterToObject(String value) {
		Map<String, String> map = new HashMap<String, String>();

		String[] params = value.split("&");
		for (String param : params) {
			String[] split = param.split("=");
			
			String n = split[0];
			String v = "";

			try {
				v = URLDecoder.decode(split[1], "UTF-8");
			} catch (ArrayIndexOutOfBoundsException e) {
				v = "";
			} catch (UnsupportedEncodingException e) {
				v = split[1];
			}

			map.put(n, v);
		}

		return map;
	}

	private String getFromYyyymm() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -13);
		return sdfYyyymm.format(c.getTime());
	}

	private String getToYyyymm() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		return sdfYyyymm.format(c.getTime());
	}

	private String getYyyymm() {
		Calendar c = Calendar.getInstance();
		return sdfYyyy.format(c.getTime());
	}

	public String getViewName(HttpServletRequest request) {
		String viewName = "";
		viewName = request.getRequestURI();
		viewName = viewName.replaceAll(request.getContextPath(), "");
		viewName = viewName.replaceAll(".view", "");

		String theme = ResourceBundleUtil.getResourceBundle("product.theme", "");
		if ("default".equals(theme))
			return viewName;

		viewName = ResourceBundleUtil.getResourceBundle(
				String.format("product.theme.jsp%s.%s", StringUtils.replace(viewName, "/", "."), theme), viewName);
		return viewName;
	}

	private String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	private String getParameter(HttpServletRequest request, String name) {
		return getParameter(request, name, null);
	}

	/**
	 * 파라미터나 쿠키에서 값을 가져온다. 파라미터가 우선 순위
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	private String getParameter(HttpServletRequest request, String name, String defaultValue) {
		if (StringUtil.isEmptyString(name)) {
			return null;
		}

		String s = null;

		String req = request.getParameter(name);
		String cookie = getCookieValue(request, "ftainsight.compliance." + name);

		String attr = null;
		Object attrObj = request.getAttribute(name);
		if (attrObj != null) {
			attr = attrObj.toString();
		}

		if (!StringUtil.isEmptyString(req)) {
			s = req;
		} else if (!StringUtil.isEmptyString(cookie)) {
			s = cookie;
		} else if (!StringUtil.isEmptyString(attr)) {
			s = attr;
		}

		if (StringUtil.isEmptyString(s) && !StringUtil.isEmptyString(defaultValue)) {
			s = defaultValue;
		}

		return s;
	}

	private String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie.getValue();
			}
		}

		return null;
	}

	private String getPageTitle(HttpServletRequest request) {

		String pageTitle = "";

		try {
			String uri = request.getRequestURI().replaceFirst(request.getContextPath(), "");

			HttpSession session = request.getSession();

//			List<ResourceVO> list = (List<ResourceVO>) session.getAttribute("menuList");
//			if (list != null) {
//				for (ResourceVO rv1 : list) {
//					if (isFind) {
//						break;
//					}
//					for (ResourceVO rv2 : rv1.getResourceList()) {
//						if (uri.equals(rv2.getUri())) {
//							pageTitle = rv2.getName();
//							isFind = true;
//							break;
//						}
//					}
//
//				}
//			}
		} catch (Exception e) {
			logger.warn("setting title error - ", e.getMessage());
		}

		if (StringUtil.isEmptyString(pageTitle)) {
			pageTitle = "";
		}

		return pageTitle;
	}

	private Random rnd = new Random();

	private int getRandom() {
		return rnd.nextInt();
	}
}
