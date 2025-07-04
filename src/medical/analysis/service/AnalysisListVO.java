package medical.analysis.service;

import java.util.ArrayList;
import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class AnalysisListVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3824931668078735996L;
	
	List<AnalysisVO> analysisList = new ArrayList<AnalysisVO>();

	public List<AnalysisVO> getAnalysisList() {
		return analysisList;
	}

	public void setAnalysisList(List<AnalysisVO> analysisList) {
		this.analysisList = analysisList;
	}
	
	
}
