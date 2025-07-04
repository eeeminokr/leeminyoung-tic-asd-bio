package medical.neuropsy.service;

import medical.framework.vo.KoriginCommonVO;

public class NeuropsyAdos1VO extends KoriginCommonVO{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1012271037283160102L;
	private int rownum;
	private String rndId;
	private String targetId;
	private String targetDisId;
	private String disClassDtl;
	private String sex;
	private String birthYm;
	private String protocol;
	private String performCnt;
	private	String performCntNm;
	private String age;
	private String ados1ExecDate;
	
	private String ados1Module;
	private String ados1Play;
	
	private String ados1Commu;
	private String socialInteraction;
	private String lanSocialInter;
	private String a1StereoInterest;
	private String ados1Total;
	private String remarks;
	private String performExecDate;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getRndId() {
		return rndId;
	}
	public void setRndId(String rndId) {
		this.rndId = rndId;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getBirthYm() {
		return birthYm;
	}
	public void setBirthYm(String birthYm) {
		this.birthYm = birthYm;
	}
	public String getPerformCnt() {
		return performCnt;
	}
	public void setPerformCnt(String performCnt) {
		this.performCnt = performCnt;
	}
	public String getPerformCntNm() {
		return performCntNm;
	}
	public void setPerformCntNm(String performCntNm) {
		this.performCntNm = performCntNm;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPerformExecDate() {
		return performExecDate;
	}
	public void setPerformExecDate(String performExecDate) {
		this.performExecDate = performExecDate;
	}
	public String getTargetDisId() {
		return targetDisId;
	}
	public void setTargetDisId(String targetDisId) {
		this.targetDisId = targetDisId;
	}
	public String getAdos1ExecDate() {
		return ados1ExecDate;
	}
	public void setAdos1ExecDate(String ados1ExecDate) {
		this.ados1ExecDate = ados1ExecDate;
	}

	public String getSocialInteraction() {
		return socialInteraction;
	}
	public void setSocialInteraction(String socialInteraction) {
		this.socialInteraction = socialInteraction;
	}
	public String getLanSocialInter() {
		return lanSocialInter;
	}
	public void setLanSocialInter(String lanSocialInter) {
		this.lanSocialInter = lanSocialInter;
	}
	public String getAdos1Total() {
		return ados1Total;
	}
	public void setAdos1Total(String ados1Total) {
		this.ados1Total = ados1Total;
	}
	public String getA1StereoInterest() {
		return a1StereoInterest;
	}
	public void setA1StereoInterest(String a1StereoInterest) {
		this.a1StereoInterest = a1StereoInterest;
	}

	public String getAdos1Module() {
		return ados1Module;
	}
	public void setAdos1Module(String ados1Module) {
		this.ados1Module = ados1Module;
	}
	public String getAdos1Commu() {
		return ados1Commu;
	}
	public void setAdos1Commu(String ados1Commu) {
		this.ados1Commu = ados1Commu;
	}
	public String getAdos1Play() {
		return ados1Play;
	}
	public void setAdos1Play(String ados1Play) {
		this.ados1Play = ados1Play;
	}
}

