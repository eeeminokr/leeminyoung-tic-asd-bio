package medical.framework.util;

public class Constant {

	public final static Integer NULL=0;
	
	private static final String storeHome = getResource( "file.home" );
	
	/**
	 * Q&A 게시판 구분
	 */
	public static final String BOARD_QNA = "01";
	
	/** 성공여부-성공 */
	public static final String SUCESS = "S";
	
	/** 성공여부-실패 */
	public static final String FAIL = "F";
	
	/** session 에 저장할때 사용하는 변수명 */
	public static final String SESSION_MEMBER = "member";
	
	/** 공백문자 */
	public static final String BLANK = "";
	
	/** 한칸문자 */
	public static final String SPACE = " ";
	
	/** 기본 회사 코드 */
	public static final String DEFAULT_COMPANY_CODE = "A0001";

	/** Configuration InsightVersion */
	public static final String CONFIG_INSIGHT_VERSION	= "VR001";
	
	public static final String DEFAULT_DB_SCHEMA_NAME = "FTARULES.";
	
	
	public static String contextRealPath = null;

	public static String getContextRealPath() {
		return contextRealPath;
	}

	public static void setContextRealPath(String contextRealPath) {
		if(Constant.contextRealPath == null){
			Constant.contextRealPath = contextRealPath;
		}   
	}
	
	public static String getStoreHome () {
		return storeHome;
	}
	
	public static String getResource( String key ){
		try {
			return ResourceBundleUtil.getResourceBundle(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
