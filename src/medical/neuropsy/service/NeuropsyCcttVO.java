package medical.neuropsy.service;

import medical.framework.vo.KoriginCommonVO;

public class NeuropsyCcttVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4471530367917346469L;
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
	private String ccttExecDate;
	private String cctt1CompleteTime;
	private String cctt1Tpoint;
	private String cctt1Ile;
	private String cctt1DigseqErr;
	private String cctt1ApproxErr;
	private String cctt1Catalist;
	private String cctt2CompleteTime;
	private String cctt2Tpoint;
	private String cctt2Ile;
	private String cctt2ColseqErr;
	private String cctt2DigseqErr;
	private String cctt2ApproxErr;
	private String cctt2Catalist;
	private String interferARiir;
	private String interferAIle;
	private String interferBRiir;
	private String interferBTpoint;
	private String interferBIle;
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
	public String getBirthYm() {
		return birthYm;
	}
	public void setBirthYm(String birthYm) {
		this.birthYm = birthYm;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
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
	public String getCcttExecDate() {
		return ccttExecDate;
	}
	public void setCcttExecDate(String ccttExecDate) {
		this.ccttExecDate = ccttExecDate;
	}
	public String getCctt1CompleteTime() {
		return cctt1CompleteTime;
	}
	public void setCctt1CompleteTime(String cctt1CompleteTime) {
		this.cctt1CompleteTime = cctt1CompleteTime;
	}
	public String getCctt1Tpoint() {
		return cctt1Tpoint;
	}
	public void setCctt1Tpoint(String cctt1Tpoint) {
		this.cctt1Tpoint = cctt1Tpoint;
	}
	public String getCctt1Ile() {
		return cctt1Ile;
	}
	public void setCctt1Ile(String cctt1Ile) {
		this.cctt1Ile = cctt1Ile;
	}
	public String getCctt1DigseqErr() {
		return cctt1DigseqErr;
	}
	public void setCctt1DigseqErr(String cctt1DigseqErr) {
		this.cctt1DigseqErr = cctt1DigseqErr;
	}
	public String getCctt1ApproxErr() {
		return cctt1ApproxErr;
	}
	public void setCctt1ApproxErr(String cctt1ApproxErr) {
		this.cctt1ApproxErr = cctt1ApproxErr;
	}
	public String getCctt1Catalist() {
		return cctt1Catalist;
	}
	public void setCctt1Catalist(String cctt1Catalist) {
		this.cctt1Catalist = cctt1Catalist;
	}
	public String getCctt2CompleteTime() {
		return cctt2CompleteTime;
	}
	public void setCctt2CompleteTime(String cctt2CompleteTime) {
		this.cctt2CompleteTime = cctt2CompleteTime;
	}
	public String getCctt2Tpoint() {
		return cctt2Tpoint;
	}
	public void setCctt2Tpoint(String cctt2Tpoint) {
		this.cctt2Tpoint = cctt2Tpoint;
	}
	public String getCctt2Ile() {
		return cctt2Ile;
	}
	public void setCctt2Ile(String cctt2Ile) {
		this.cctt2Ile = cctt2Ile;
	}
	public String getCctt2ColseqErr() {
		return cctt2ColseqErr;
	}
	public void setCctt2ColseqErr(String cctt2ColseqErr) {
		this.cctt2ColseqErr = cctt2ColseqErr;
	}
	public String getCctt2DigseqErr() {
		return cctt2DigseqErr;
	}
	public void setCctt2DigseqErr(String cctt2DigseqErr) {
		this.cctt2DigseqErr = cctt2DigseqErr;
	}
	public String getCctt2ApproxErr() {
		return cctt2ApproxErr;
	}
	public void setCctt2ApproxErr(String cctt2ApproxErr) {
		this.cctt2ApproxErr = cctt2ApproxErr;
	}
	public String getCctt2Catalist() {
		return cctt2Catalist;
	}
	public void setCctt2Catalist(String cctt2Catalist) {
		this.cctt2Catalist = cctt2Catalist;
	}
	public String getInterferARiir() {
		return interferARiir;
	}
	public void setInterferARiir(String interferARiir) {
		this.interferARiir = interferARiir;
	}
	public String getInterferAIle() {
		return interferAIle;
	}
	public void setInterferAIle(String interferAIle) {
		this.interferAIle = interferAIle;
	}
	public String getInterferBRiir() {
		return interferBRiir;
	}
	public void setInterferBRiir(String interferBRiir) {
		this.interferBRiir = interferBRiir;
	}
	public String getInterferBTpoint() {
		return interferBTpoint;
	}
	public void setInterferBTpoint(String interferBTpoint) {
		this.interferBTpoint = interferBTpoint;
	}
	public String getInterferBIle() {
		return interferBIle;
	}
	public void setInterferBIle(String interferBIle) {
		this.interferBIle = interferBIle;
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
	


}
