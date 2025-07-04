package medical.framework.resource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextFactory  implements ApplicationContextAware {

	private static ApplicationContextFactory contextFactory;
	
	private ApplicationContext context;
		
	public ApplicationContextFactory(){}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		System.out.println("Set ApplicationContextFactory ..............");
		contextFactory = new ApplicationContextFactory();
		contextFactory.context = context;
		
	}
	public ApplicationContext getApplicationContext(){
		return this.context;
	}

    /**
     * getApplicationContext() short method
     * 
     * @param ApplicationContext
     * @exception
     * @see getApplicationContext()
     */		
	public static ApplicationContext getAppContext(){
		return ApplicationContextFactory.getApplicationContextFactory().getApplicationContext();
	}

	
	public static ApplicationContextFactory getApplicationContextFactory(){
		return contextFactory;
	}

	
}
