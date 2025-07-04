package medical.framework.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String contextRealPath = arg0.getServletContext().getRealPath("");
		Constant.setContextRealPath(contextRealPath);
	}
}
