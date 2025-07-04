package medical.surveyAsd.service;

import java.util.ArrayList;
import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class SurveyAsdListVO extends KoriginCommonVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3028220998799369811L;
	
	List<SurveyAsdVO> surveyAsdList = new ArrayList<SurveyAsdVO>();
	
	public List<SurveyAsdVO> getSurveyAsdList() {
		return surveyAsdList;
	}
	public void setSurveyAsdList(List<SurveyAsdVO> surveyAsdList) {
		this.surveyAsdList = surveyAsdList;
	}
}
