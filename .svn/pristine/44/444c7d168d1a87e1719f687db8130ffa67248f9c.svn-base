package medical.framework.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import medical.commoninfo.member.service.MemberVO;
import medical.framework.util.Constant;

public class KoriginCommonVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String createDate;
	private String createBy;
	private String updateDate;
	private String updateBy;
	private BigDecimal totalCount;
	private String defaultLanguage;
	private int start;
	private int limit;
	private int total;
	private String schKeyWord;
	private String schKeyField;
	private String sessionUserId;
	
	public void defaultValue(HttpServletRequest request) {
		defaultValue(request.getSession());
	}

	public void defaultValue(HttpSession session) {
		MemberVO vo = (MemberVO) session.getAttribute(Constant.SESSION_MEMBER);
		this.sessionUserId = vo.getUserId();
	}
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public BigDecimal getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(BigDecimal totalCount) {
		this.totalCount = totalCount;
	}
	public String getDefaultLanguage() {
		return defaultLanguage;
	}
	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getSchKeyWord() {
		return schKeyWord;
	}
	public void setSchKeyWord(String schKeyWord) {
		this.schKeyWord = schKeyWord;
	}
	public String getSchKeyField() {
		return schKeyField;
	}
	public void setSchKeyField(String schKeyField) {
		this.schKeyField = schKeyField;
	}
	public String getSessionUserId() {
		return sessionUserId;
	}
	public void setSessionUserId(String sessionUserId) {
		this.sessionUserId = sessionUserId;
	}
	
}
