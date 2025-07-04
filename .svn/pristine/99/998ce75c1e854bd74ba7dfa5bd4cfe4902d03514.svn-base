package medical.framework.util;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletRequestListImpl implements ServletRequestListener {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		ServletRequest request = arg0.getServletRequest();
		if (request.getCharacterEncoding() == null) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
			}
		}

		Enumeration<String> en = request.getParameterNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String value = request.getParameter(key);

			logger.debug("[{} Request Parameter] : key={}, value={}", request.hashCode(), key,
					value);
		}
	}
}
