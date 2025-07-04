package medical.clinician.service;

import medical.framework.vo.KoriginCommonVO;

public class ClinicianTotalVO extends KoriginCommonVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254881084934360894L;
  
	
	private String targetId;
	private String targetDisId; //대상사 뇌질환 ID
	private String docId;
	private String rndId;
	private String disClassDtl;
	private String classCdDtlNm;
	private String protocol;
	private String birthYm;
	private String sex;
	private String performCnt;
	private	String performCntNm;
	private String performNm;
	private String age;
	private String execDate;
	private String visitDate;
	
	
	
	private String s1001;
	private String exts1; //K-SADS-PL
	private String srs01;
	private String cvCgis; //CGI-S
	private String cvCgii;//CGII
	private String cvCgas; // CGS-S
	private String cybo1; // 임상가평가 cy-bocs
	private String ybocs; //YBOCS
	private String startAge;
	private String endAge;
	private int pillCntPercent; //복용율
	private String pillCount;
	private String ptYn;
	private String targetIds;
    private String performCnts;
	
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
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

	public String getStartAge() {
		return startAge;
	}
	public void setStartAge(String startAge) {
		this.startAge = startAge;
	}
	public String getEndAge() {
		return endAge;
	}
	public void setEndAge(String endAge) {
		this.endAge = endAge;
	}
	
	public String getClassCdDtlNm() {
		return classCdDtlNm;
	}
	public void setClassCdDtlNm(String classCdDtlNm) {
		this.classCdDtlNm = classCdDtlNm;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	public String getCvCgis() {
		return cvCgis;
	}
	public void setCvCgis(String cvCgis) {
		this.cvCgis = cvCgis;
	}
	public String getCvCgii() {
		return cvCgii;
	}
	public void setCvCgii(String cvCgii) {
		this.cvCgii = cvCgii;
	}
	public String getCvCgas() {
		return cvCgas;
	}
	public void setCvCgas(String cvCgas) {
		this.cvCgas = cvCgas;
	}
	public String getCybo1() {
		return cybo1;
	}
	public void setCybo1(String cybo1) {
		this.cybo1 = cybo1;
	}
	public String getYbocs() {
		return ybocs;
	}
	public void setYbocs(String ybocs) {
		this.ybocs = ybocs;
	}
	public String getSrs01() {
		return srs01;
	}
	public void setSrs01(String srs01) {
		this.srs01 = srs01;
	}
	public String getPerformNm() {
		return performNm;
	}
	public void setPerformNm(String performNm) {
		this.performNm = performNm;
	}
	
	public String getS1001() {
		return s1001;
	}
	public void setS1001(String s1001) {
		this.s1001 = s1001;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public int getPillCntPercent() {
		return pillCntPercent;
	}
	public void setPillCntPercent(int pillCntPercent) {
		this.pillCntPercent = pillCntPercent;
	}
	public String getPerformCnts() {
		return performCnts;
	}
	public void setPerformCnts(String performCnts) {
		this.performCnts = performCnts;
	}
	public String getTargetIds() {
		return targetIds;
	}
	public void setTargetIds(String targetIds) {
		this.targetIds = targetIds;
	}
	public String getPtYn() {
		return ptYn;
	}
	public void setPtYn(String ptYn) {
		this.ptYn = ptYn;
	}
	public String getPillCount() {
		return pillCount;
	}
	public void setPillCount(String pillCount) {
		this.pillCount = pillCount;
	}
	public String getExts1() {
		return exts1;
	}
	public void setExts1(String exts1) {
		this.exts1 = exts1;
	}
	
	
	
	
	
	
	
	
	
	
	
}
