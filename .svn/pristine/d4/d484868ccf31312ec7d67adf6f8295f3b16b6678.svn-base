package medical.framework.jstl;

import java.util.Calendar;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import medical.framework.util.StringUtil;

public class YearComboTag extends RequestContextAwareTag {
	private static final long serialVersionUID = 7734955288262169812L;

	// attribute
	private String id = "yyyy";
	private String name = "yyyy";
	private String value;
	private String title = "기준년";
	

	private boolean allowBlank = false;
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


	@SuppressWarnings("unused")
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

		Calendar c = Calendar.getInstance();
		int currentYear = c.get(Calendar.YEAR);

		String v = value;
		if (StringUtil.isEmptyString(v) == true) {
			value = String.valueOf(currentYear);
		}
		int initYear = currentYear;
		if(11==c.get(Calendar.MONTH)+1||12==c.get(Calendar.MONTH)+1)initYear = currentYear+1;
		for (int y = initYear; y >= currentYear  - 6 ; y-- ) {
			String yyyy = String.valueOf(y);

			sb.append("<option");
			sb.append(" value=\"" + yyyy + "\"");
			
			// 초기치로 현재 년을 선택되게 함
			// 나중에 저장된 검색값으로 년도를 바꾸는 부분은 js 에서 구현됨
			if (allowBlank != true) {
				if (v == null || v.trim().isEmpty() == false) {
					if ( y == currentYear) {
						sb.append(" selected=\"selected\"");
					}
				} else {
					if (yyyy.equals(v) == true) {
						sb.append(" selected=\"selected\"");
					}
				}
			}			
			sb.append(">");
			sb.append(y);
			sb.append("</option>");
			sb.append("\n");
		}

		sb.append("</select>");
		sb.append("\n");

		pageContext.getOut().write(sb.toString());

		return SKIP_BODY;
	}

}
