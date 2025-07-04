package medical.imagingInfo.service;

import medical.framework.vo.KoriginCommonVO;

public class ImagingTarFileVO extends KoriginCommonVO{
	private static final long serialVersionUID = 1L;
	private String rndId;
	private String disClassDtl;
	private String performNm;
	private String performCntNm;
	private String targetId;
	private String filePath;
	
	
	public String getPerformCntNm() {
		return performCntNm;
	}
	public void setPerformCntNm(String performCntNm) {
		this.performCntNm = performCntNm;
	}
	public String getRndId() {
		return rndId;
	}
	public void setRndId(String rndId) {
		this.rndId = rndId;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public String getPerformNm() {
		return performNm;
	}
	public void setPerformNm(String performNm) {
		this.performNm = performNm;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
