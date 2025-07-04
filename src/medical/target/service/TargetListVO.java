package medical.target.service;

import java.util.ArrayList;
import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class TargetListVO extends KoriginCommonVO{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2299569973258253796L;
	
	private List<TargetVO> targetList = new ArrayList<TargetVO>();
	
	public List<TargetVO> getTargetList() {
		return targetList;
	}
	public void setTargetList(List<TargetVO> targetList) {
		this.targetList = targetList;
	}
	

}

