package medical.analysis.service;

import medical.framework.vo.KoriginCommonVO;

public class AnalysisTAnalEnvMattVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3418497693621574116L;
	
	private int rownum;
	private String rndId;
	private String targetId;
	private String targetDisId;
	private String disClassDtl;
	private String docId;
	private String performCnt;
	private	String performCntNm;
	private String performExecDate;
	private String sex;
	private String birthYm;
	private String age;
	private String envMattExecDate;
	private String collectDate;  
	private String analDate;  
	private String creatinine;  
	private String cot;  
	private String cotCreatinine;  
	private String mehhp;  
	private String mehhpCreatinine;  
	private String meohp;
	private String meohpCreatinine;
	private String mnbp;
	private String mnbpCreatinine;
	private String threePba;  
	private String threePbaCreatinine;  
	
	/*
	private String bloodCollectDate; 
	private String tube; 
	private String metalAnalDate; 
	private String BMn; 
	private String BCd; 
	private String BPb; 
	*/
	private String performNm;
	private String protocol;
	
	
	
	public String getMeohp() {
		return meohp;
	}
	public void setMeohp(String meohp) {
		this.meohp = meohp;
	}
	public String getMeohpCreatinine() {
		return meohpCreatinine;
	}
	public void setMeohpCreatinine(String meohpCreatinine) {
		this.meohpCreatinine = meohpCreatinine;
	}
	public String getMnbp() {
		return mnbp;
	}
	public void setMnbp(String mnbp) {
		this.mnbp = mnbp;
	}
	public String getMnbpCreatinine() {
		return mnbpCreatinine;
	}
	public void setMnbpCreatinine(String mnbpCreatinine) {
		this.mnbpCreatinine = mnbpCreatinine;
	}
	public String getPerformExecDate() {
		return performExecDate;
	}
	public void setPerformExecDate(String performExecDate) {
		this.performExecDate = performExecDate;
	}
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
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getTargetDisId() {
		return targetDisId;
	}
	public void setTargetDisId(String targetDisId) {
		this.targetDisId = targetDisId;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getPerformCnt() {
		return performCnt;
	}
	public void setPerformCnt(String performCnt) {
		this.performCnt = performCnt;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthYm() {
		return birthYm;
	}
	public void setBirthYm(String birthYm) {
		this.birthYm = birthYm;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEnvMattExecDate() {
		return envMattExecDate;
	}
	public void setEnvMattExecDate(String envMattExecDate) {
		this.envMattExecDate = envMattExecDate;
	}
	public String getPerformNm() {
		return performNm;
	}
	public void setPerformNm(String performNm) {
		this.performNm = performNm;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public String getAnalDate() {
		return analDate;
	}
	public void setAnalDate(String analDate) {
		this.analDate = analDate;
	}
	public String getCreatinine() {
		return creatinine;
	}
	public void setCreatinine(String creatinine) {
		this.creatinine = creatinine;
	}
	public String getCot() {
		return cot;
	}
	public void setCot(String cot) {
		this.cot = cot;
	}
	public String getCotCreatinine() {
		return cotCreatinine;
	}
	public void setCotCreatinine(String cotCreatinine) {
		this.cotCreatinine = cotCreatinine;
	}
	public String getMehhp() {
		return mehhp;
	}
	public void setMehhp(String mehhp) {
		this.mehhp = mehhp;
	}
	public String getMehhpCreatinine() {
		return mehhpCreatinine;
	}
	public void setMehhpCreatinine(String mehhpCreatinine) {
		this.mehhpCreatinine = mehhpCreatinine;
	}
	public String getThreePba() {
		return threePba;
	}
	public void setThreePba(String threePba) {
		this.threePba = threePba;
	}
	public String getThreePbaCreatinine() {
		return threePbaCreatinine;
	}
	public void setThreePbaCreatinine(String threePbaCreatinine) {
		this.threePbaCreatinine = threePbaCreatinine;
	}
	
	/*
	public String getBloodCollectDate() {
		return bloodCollectDate;
	}
	public void setBloodCollectDate(String bloodCollectDate) {
		this.bloodCollectDate = bloodCollectDate;
	}
	public String getTube() {
		return tube;
	}
	public void setTube(String tube) {
		this.tube = tube;
	}
	public String getMetalAnalDate() {
		return metalAnalDate;
	}
	public void setMetalAnalDate(String metalAnalDate) {
		this.metalAnalDate = metalAnalDate;
	}
	public String getBMn() {
		return BMn;
	}
	public void setBMn(String bMn) {
		BMn = bMn;
	}
	public String getBCd() {
		return BCd;
	}
	public void setBCd(String bCd) {
		BCd = bCd;
	}
	public String getBPb() {
		return BPb;
	}
	public void setBPb(String bPb) {
		BPb = bPb;
	}
	*/
	
}
