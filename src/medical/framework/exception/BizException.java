package medical.framework.exception;

public class BizException extends KoriginException {

	private static final long serialVersionUID = -5359119309104153600L;

	public BizException() {
		super();
	}

	public BizException(String msgKey) {
		super(msgKey);
	}

	public BizException(String msgKey, String[] msgArgs) {
		super(msgKey, msgArgs);
	}

	public BizException(String msgKey, String[] msgArgs, String locale) {
		super(msgKey, msgArgs, locale);
	}

}
