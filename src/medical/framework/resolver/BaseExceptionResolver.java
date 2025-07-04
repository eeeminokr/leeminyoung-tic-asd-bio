package medical.framework.resolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import medical.framework.exception.KoriginException;
import medical.framework.exception.ValidationException;
import medical.framework.util.JsonUtils;

public class BaseExceptionResolver implements HandlerExceptionResolver {
	private String view;

	@Resource(name = "messageSource")
	private MessageSource messageSource;

	@Resource(name = "leaveaTrace")
	public void setView(String view) {
		this.view = view;
	}

	public String getView() {
		return view;
	}

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
			Object obj, Exception exception) {

		exception.printStackTrace();

		Map<String, String> map = new HashMap<String, String>();

		String reason = exception.getMessage();
		String code = "E";

		if (exception instanceof KoriginException) {
			try {
				KoriginException ex = (KoriginException) exception;

				reason = messageSource.getMessage(ex.getMsgKey(), ex.getMsgArgs(), Locale.KOREAN);
			} catch (Exception e) {
				e.printStackTrace();
				reason = e.getMessage();
			}

			reason = StringUtils.defaultIfEmpty(reason, exception.getMessage());

			request.setAttribute("exception", exception);
		} else if ( exception instanceof MaxUploadSizeExceededException ){
			reason ="업로드 파일 용량을 확인하세요.(50M제한)";
		} else {			
			reason = exception.getMessage();
		}

		if (exception instanceof ValidationException) {
			ValidationException e = (ValidationException) exception;
			code = e.getCode();
		}

		map.put("code", code);
		map.put("reason", reason);

		String reqType = request.getHeader("X-Requested-With");
		String uri = request.getRequestURI();

		if ("XMLHttpRequest".equals(reqType) || uri.length() - 3 == uri.lastIndexOf(".do")) {
			// ajax
			return JsonUtils.describeException(map);
		} else {
			throw new RuntimeException(exception);
		}

	}

	protected String getMessage(String messageKey, Object messageParameters[]) {
		return getMessage(messageKey, messageParameters, null);
	}

	protected String getMessage(String messageKey, Object messageParameters[], Locale locale) {
		return messageSource.getMessage(messageKey, messageParameters, null, locale);
	}

}
