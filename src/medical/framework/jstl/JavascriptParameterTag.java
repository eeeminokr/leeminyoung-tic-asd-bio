package medical.framework.jstl;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import medical.framework.util.StringUtil;

public class JavascriptParameterTag extends RequestContextAwareTag {
	private static final long serialVersionUID = -5287701939816192855L;

	@Override
	protected int doStartTagInternal() throws Exception {

		StringBuffer sb = new StringBuffer();
		sb.append("<script type=\"text/javascript\">");
		sb.append("\n");
		sb.append("var parameter = {};");
		sb.append("\n");

		Object o = pageContext.findAttribute("parameter");
		if (o != null) {
			@SuppressWarnings("unchecked")
			Map<String, String> parameter = (Map<String, String>) o;

			for (Entry<String, String> entry : parameter.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();

				if (value == null || value.trim().isEmpty()) {
					continue;
				}
				
				//숫자처리 필요한 속성
				if ( StringUtil.isEquals("pageSize", key)) {
					sb.append("parameter['" + key + "'] = " + value + ";");
				} else {
					sb.append("parameter['" + key + "'] = '" + value + "';");
				}

//				try {
//					int integer = Integer.parseInt(value);
//					sb.append("parameter['" + key + "'] = " + integer + ";");
//				} catch (NumberFormatException e) {
//					sb.append("parameter['" + key + "'] = '" + value + "';");
//				}

				sb.append("\n");

			}

		}

		sb.append("</script>");
		sb.append("\n");

		pageContext.getOut().write(sb.toString());

		return SKIP_BODY;
	}

}
