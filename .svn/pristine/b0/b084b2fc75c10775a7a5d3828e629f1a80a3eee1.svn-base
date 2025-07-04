package medical.framework.util;

import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

public class ResourceBundleUtil {

	public final static String DEFAULT_APP_RESOURCE_PATH = "medical.common.config";
	public final static String RESOURCE_NAME = "app_resource";
	public static ResourceBundle appResourceBundle;
	
	public static final int RBU_DOWNLOAD = 0x01;
	public static final int RBU_UPLOAD = 0x02;
	public static final String RUB_NONE = "";
	

	public static ResourceBundle getAppResourceBundle() throws Exception{
		
		if(appResourceBundle == null) {
			try {
				Properties pr = System.getProperties();
				String medicalResource = pr.getProperty("medicalResource");
				if(StringUtils.isEmpty(medicalResource)){
					medicalResource = DEFAULT_APP_RESOURCE_PATH;
				} /* end of if */
				
				appResourceBundle = ResourceBundle.getBundle(medicalResource+"."+RESOURCE_NAME);
				
				System.out.println("resource name : "+medicalResource+"."+RESOURCE_NAME);
			
			} catch(MissingResourceException e) {
				throw new MissingResourceException("[ERROR] There is no properties.", "", "");
			}			
		}
		
		return appResourceBundle;
	}
	
	/**
	 * @param key
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	public static String getResourceBundle(String key, int flag) throws Exception {
//		String value = getResourceBundle(key);
//		return StringUtils.replace(value,"//","/");
		return getResourceBundle("", key, flag);
	}

	public static String getDirIncludedInfo(String key, String path1, String path2, String path3) throws Exception {
		String value = getResourceBundle(key);
		if(!"".equals(path1))value = value + StringUtil.PathSep(path1);
		if(!"".equals(path2))value = value + StringUtil.PathSep(path2);
		if(!"".equals(path3))value = value + StringUtil.PathSep(path3);
		return StringUtils.replace(value,"//","/");
	}
	
	public static String getResourceBundle(String key)  {
		return getResourceBundle(key, "");
	}
	
	public static String getResourceBundle(String key, String defValue)  {
		try {
			String value = getAppResourceBundle().getString(key);
			if (value == null && "".equals(value)) return defValue;

			return value;
		} catch (Exception e) {
			return defValue;
		}
	}
	
	public static String getResourceBundle(String loginCompanyCode, String key, int flag) throws Exception {
		String value = getResourceBundle(key);
	
		value = StringUtils.replace(value, "{loginCompanyCode}", (loginCompanyCode == null)?"":loginCompanyCode);
//		System.out.println("DIR *************************************************");			
//		System.out.println("DIR *************************************************");			
//		System.out.println("DIR *************************************************");			

		// upload일 경우 보관하는 곳의 위치를 옵션에 따라 변경한다.
		if ((flag & RBU_UPLOAD) == RBU_UPLOAD) {
			value = StringUtils.replace(value, "{file.home}", Constant.getStoreHome());
			value = StringUtils.replace(value, "{context.home}", Constant.getContextRealPath());
			value = StringUtils.replace(value, "{store.home}", Constant.getStoreHome());
			
			return StringUtils.replace(value,"//","/");
		}
		
		// RBU_DOWNLOAD와 같은 경우에는 웹 디렉토리를 사용하기 때문에 상대패스로 사용한다.
		value = StringUtils.replace(value, "{file.home}","");
		value = StringUtils.replace(value, "{context.home}","");
		value = StringUtils.replace(value, "{store.home}", "");
		
		return StringUtils.replace(value,"//","/");
	}
}
