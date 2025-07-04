package medical.framework.jstl;

import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import medical.commoninfo.member.service.MemberVO;
import medical.framework.util.StringUtil;
import medical.main.service.MainService;

public class GrpAuthComboTag extends RequestContextAwareTag {

	private static final long serialVersionUID = 3001003649987320102L;
	MainService mainService;
	
	// attribute
	private String id;
	private String name;
	private String value;
	private String title;
	private boolean userAuthNmValue = false;

	private boolean showValue = false;
	private String showValuePrefix = "[";
	private String showValueSuffix = "]";
	
	private boolean allowBlank = true;
	private String allowBlankText = "전체";

	private int valueTextNo = 0;
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setUserAuthNmValue(boolean userAuthNmValue) {
		this.userAuthNmValue = userAuthNmValue;
	}

	public void setShowValue(boolean showValue) {
		this.showValue = showValue;
	}

	public void setShowValuePrefix(String showValuePrefix) {
		this.showValuePrefix = showValuePrefix;
	}

	public void setShowValueSuffix(String showValueSuffix) {
		this.showValueSuffix = showValueSuffix;
	}

	public void setAllowBlank(boolean allowBlank) {
		this.allowBlank = allowBlank;
	}

	public void setAllowBlankText(String allowBlankText) {
		this.allowBlankText = allowBlankText;
	}
	
	

	@Override
	protected int doStartTagInternal() throws Exception {
		if (mainService == null) {
			WebApplicationContext wac = getRequestContext().getWebApplicationContext();
			mainService = (MainService) wac.getBean("MainService");
		}
		MemberVO memberVO = new MemberVO();
		List<MemberVO> list = mainService.selectGrpAuth(memberVO);

		StringBuffer sb = new StringBuffer();
		sb.append("<select");
		if (StringUtil.isEmptyString(id) == false) {
			sb.append(" id=\"" + id + "\"");
		}
		if (StringUtil.isEmptyString(name) == false) {
			sb.append(" name=\"" + name + "\"");
		}
		if (StringUtil.isEmptyString(title) == false) {
			sb.append(" title=\"" + title + "\"");
		}
		sb.append(">");
		sb.append("\n");

		if (allowBlank == true) {
			sb.append("<option value=\"\">" + allowBlankText + "</option>");
			sb.append("\n");
		}

		for (MemberVO d : list) {
			sb.append("<option");
			if(userAuthNmValue == true) {
				sb.append(" value=\"" + d.getUserAuthNm() + "\"");
			}else {
				sb.append(" value=\"" + d.getUserAuth() + "\"");
			}
			if (d.getUserAuthNm().equals(value) == true) {
				sb.append(" selected=\"selected\"");
			}
			sb.append(">");

			if (showValue == true) {
				sb.append(showValuePrefix);
				sb.append(d.getUserAuth());
				sb.append(showValueSuffix);
				sb.append(" ");
			}
			sb.append(d.getUserAuthNm());
			sb.append("</option>");
			sb.append("\n");
		}
		
		sb.append("</select>");
		sb.append("\n");

		pageContext.getOut().write(sb.toString());

		return SKIP_BODY;
	}

	public int getValueTextNo() {
		return valueTextNo;
	}

	public void setValueTextNo(int valueTextNo) {
		this.valueTextNo = valueTextNo;
	}

}