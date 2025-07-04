package medical.gene.service;

import java.util.ArrayList;
import java.util.List;

import medical.framework.vo.KoriginCommonVO;

public class GeneListVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3824931668078735996L;
	
	List<GeneVO> geneList = new ArrayList<GeneVO>();

	public List<GeneVO> getgeneList() {
		return geneList;
	}

	public void setgeneList(List<GeneVO> geneList) {
		this.geneList = geneList;
	}
	
	
}
