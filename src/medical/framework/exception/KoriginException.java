package medical.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class KoriginException extends RuntimeException {
	private static final long serialVersionUID = -8332965627809169839L;

	private String msgKey;
	private String msgArgs[];
	private String locale;

	private String code = "E";

	public KoriginException() {
		super();
	}

	public KoriginException(Throwable throwable) {
		super(throwable);
	}

	public KoriginException(String msgKey) {
		super(msgKey);
		this.msgKey = msgKey;
	}

	public KoriginException(String msgKey, String[] msgArgs) {
		super(msgKey);
		this.msgKey = msgKey;
		this.msgArgs = msgArgs;
	}

	public KoriginException(String msgKey, String[] msgArgs, String locale) {
		super(msgKey);
		this.msgKey = msgKey;
		this.msgArgs = msgArgs;
		this.locale = locale;
	}

	public String getStackTraceString() {
		StringWriter s = new StringWriter();
		printStackTrace(new PrintWriter(s));
		return s.toString();
	}

	public void printStackTrace() {
		printStackTrace(System.err);
	}

	public void printStackTrace(java.io.PrintStream s) {
		synchronized (s) {
			super.printStackTrace(s);
		}
	}

	public void printStackTrace(java.io.PrintWriter s) {
		synchronized (s) {
			super.printStackTrace(s);
		}
	}

	/**
	 * @return the msgKey
	 */
	public String getMsgKey() {
		return msgKey;
	}

	/**
	 * @param msgKey
	 *            the msgKey to set
	 */
	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	/**
	 * @return the msgArgs
	 */
	public String[] getMsgArgs() {
		return msgArgs;
	}

	/**
	 * @param msgArgs
	 *            the msgArgs to set
	 */
	public void setMsgArgs(String[] msgArgs) {
		this.msgArgs = msgArgs;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale
	 *            the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
