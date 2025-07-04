package medical.framework.jstl;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import medical.framework.util.StringUtil;

public class MonthComboTag extends RequestContextAwareTag {
	private static final long serialVersionUID = 7734955288262169812L;

	// attribute
	private String id = "mm";
	private String name = "mm";
	private String value;
	private String title = "기준월";

	private boolean allowBlank = true;
	private String allowBlankText = "전체";
	private String onChange = null;

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

	public void setAllowBlank(boolean allowBlank) {
		this.allowBlank = allowBlank;
	}

	public void setAllowBlankText(String allowBlankText) {
		this.allowBlankText = allowBlankText;
	}
	
	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	@Override
	protected int doStartTagInternal() throws Exception {

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
		if (StringUtil.isEmptyString(onChange) == false){
			sb.append(" onChange=\"" + onChange + "\"");
		}
		sb.append(">");
		sb.append("\n");

		if (allowBlank == true) {
			sb.append("<option value=\"\">" + allowBlankText + "</option>");
			sb.append("\n");
		}

		for (int m = 1; m <= 12; m++) {
			String mm = leftPad(String.valueOf(m), 2, "0");
			sb.append("<option");
			sb.append(" value=\"" + mm + "\"");
			if (mm.equals(value) == true) {
				sb.append(" selected=\"selected\"");
			}
			sb.append(">");
			sb.append(mm);
			sb.append("</option>");
			sb.append("\n");
		}

		sb.append("</select>");
		sb.append("\n");

		pageContext.getOut().write(sb.toString());

		return SKIP_BODY;
	}

	private String leftPad(String s, int length, String pad) {
		String v = "";

		int loop = length - s.length();
		if (loop <= 0) {
			return s;
		}

		for (int i = 0; i < loop; i++) {
			v += pad;
		}

		v += s;

		return v;

	}

	
}
