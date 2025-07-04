package medical.framework.jstl;

import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import medical.common.service.CommonService;
import medical.common.service.PerformTermVO;
import medical.commoninfo.code.service.CodeService;
import medical.commoninfo.code.service.CodeVO;
import medical.framework.util.StringUtil;

public class CodeComboTag extends RequestContextAwareTag {

	private static final long serialVersionUID = 3001003649987320102L;
	CodeService codeService;
	CommonService commonService;

	// attribute
	private String id;
	private String name;
	private String classCd;
	private String value;
	private String title;
	private String performCntYN = "N";
	private boolean classCdDtlNmValue = false;

	private boolean showValue = false;
	private String showValuePrefix = "[";
	private String showValueSuffix = "]";
	
	private boolean allowBlank = true;
	private String allowBlankText = "전체";

	private int valueTextNo = 0;
	
	private String check4Yn;
	
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

	public void setClassCd(String classCd) {
		this.classCd = classCd;
	}

	public void setClassCdDtlNmValue(boolean classCdDtlNmValue) {
		this.classCdDtlNmValue = classCdDtlNmValue;
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
	
	public void setPerformCntYN(String performCntYN) {
		this.performCntYN = performCntYN;
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
		sb.append(">");
		sb.append("\n");

		if (allowBlank == true) {
			sb.append("<option value=\"\">" + allowBlankText + "</option>");
			sb.append("\n");
		}

		
		//T_CODE_DTL comboBox
		if("N".equals(performCntYN)) {
			
			if (codeService == null) {
				WebApplicationContext wac = getRequestContext().getWebApplicationContext();
				codeService = (CodeService) wac.getBean("CodeService");
			}
	
			CodeVO vo = new CodeVO();
			vo.setClassCd(classCd);
			List<CodeVO> list = codeService.selectCodeDetailSearchCondition(vo);
			for (CodeVO d : list) {
				sb.append("<option");
				if(classCdDtlNmValue == true) {
					sb.append(" value=\"" + d.getClassCdDtlNm() + "\"");
				}else {
					sb.append(" value=\"" + d.getClassCdDtl() + "\"");
				}
				if (d.getClassCdDtlNm().equals(value) == true) {
					sb.append(" selected=\"selected\"");
				}
				sb.append(">");
	
				if (showValue == true) {
					sb.append(showValuePrefix);
					sb.append(d.getClassCd());
					sb.append(showValueSuffix);
					sb.append(" ");
				}
				sb.append(d.getClassCdDtlNm());
				sb.append("</option>");
				sb.append("\n");
			}
	
			
		}else if("Y".equals(performCntYN)) {
			//T_PERFORM_TERM comboBox
			if (commonService == null) {
				WebApplicationContext wac = getRequestContext().getWebApplicationContext();
				commonService = (CommonService) wac.getBean("CommonService");
			}
			
			PerformTermVO vo = new PerformTermVO();
			
			//4주간격 포함여부
			if("N".equals(check4Yn))vo.setCheck4Yn("N");
			
			List<PerformTermVO> list = commonService.selectPerformTerm(vo);
			for (PerformTermVO performTermVO : list) {
				sb.append("<option");
				if(classCdDtlNmValue == true) {
					sb.append(" value=\"" + performTermVO.getPerformNm() + "\"");
				}else {
					sb.append(" value=\"" + performTermVO.getPerformCnt() + "\"");
				}
				if (performTermVO.getPerformNm().equals(value) == true) {
					sb.append(" selected=\"selected\"");
				}
				sb.append(">");
	
				if (showValue == true) {
					sb.append(showValuePrefix);
					sb.append(performTermVO.getPerformCnt());
					sb.append(showValueSuffix);
					sb.append(" ");
				}
				sb.append(performTermVO.getPerformNm());
				sb.append("</option>");
				sb.append("\n");
			}
			
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

	public String getCheck4Yn() {
		return check4Yn;
	}

	public void setCheck4Yn(String check4Yn) {
		this.check4Yn = check4Yn;
	}

}
