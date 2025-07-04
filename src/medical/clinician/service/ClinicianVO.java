package medical.clinician.service;

import medical.framework.vo.KoriginCommonVO;

public class ClinicianVO  extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -562168824847310643L;
	private int rownum;
	private String birthYm;
	private String clinicianExecDate;
	private String clinicianKind;
	private String docId;
	private String rndId;
	private String docNm;
	private String disClassDtl;
	private String docClassDtl;
	private String protocol;
	private String docHeader;
	private String linkUrl;
	private String performCnt;
	private	String performCntNm;
	private String performNm;
	private String targetId;
	private String targetDisId; //대상사 뇌질환 ID
	private String sex;
	private String startAge;
	private String endAge;
	private String execDate;
	private String inqNo;
	private	String s1ExecDate;
	private	String neuropsyKind;
	private String age;
	private String clincianExecDate;
	private String choiceAnswer;
	private String subjectAnswer;
	private String score;
	private String remarks;
	private String ptYn;
	private String surveyKind;
	private String status;
	private String targetIds;
    private String performCnts;
    private String scoreA;
    private String scoreB;
    private String scoreC;
    private String s1001;
    private String exts1;
	private String cvCgis;
	private String cvCgii;
	private String cvCgas;
	private String cybo1; // 임상가평가 cy-bocs
	private String ybocs;
	
	
	
	
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	public String getRndId() {
		return rndId;
	}
	public void setRndId(String rndId) {
		this.rndId = rndId;
	}
	public String getDocNm() {
		return docNm;
	}
	public void setDocNm(String docNm) {
		this.docNm = docNm;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public String getDocClassDtl() {
		return docClassDtl;
	}
	public void setDocClassDtl(String docClassDtl) {
		this.docClassDtl = docClassDtl;
	}
	public String getDocHeader() {
		return docHeader;
	}
	public void setDocHeader(String docHeader) {
		this.docHeader = docHeader;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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


	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getBirthYm() {
		return birthYm;
	}
	public void setBirthYm(String birthYm) {
		this.birthYm = birthYm;
	}
	public String getClinicianExecDate() {
		return clinicianExecDate;
	}
	public void setClinicianExecDate(String clinicianExecDate) {
		this.clinicianExecDate = clinicianExecDate;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getInqNo() {
		return inqNo;
	}
	public void setInqNo(String inqNo) {
		this.inqNo = inqNo;
	}
	public String getChoiceAnswer() {
		return choiceAnswer;
	}
	public void setChoiceAnswer(String choiceAnswer) {
		this.choiceAnswer = choiceAnswer;
	}
	public String getSubjectAnswer() {
		return subjectAnswer;
	}
	public void setSubjectAnswer(String subjectAnswer) {
		this.subjectAnswer = subjectAnswer;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPtYn() {
		return ptYn;
	}
	public void setPtYn(String ptYn) {
		this.ptYn = ptYn;
	}
	public String getSurveyKind() {
		return surveyKind;
	}
	public void setSurveyKind(String surveyKind) {
		this.surveyKind = surveyKind;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTargetIds() {
		return targetIds;
	}
	public void setTargetIds(String targetIds) {
		this.targetIds = targetIds;
	}
	public String getPerformCnts() {
		return performCnts;
	}
	public void setPerformCnts(String performCnts) {
		this.performCnts = performCnts;
	}
	public String getScoreA() {
		return scoreA;
	}
	public void setScoreA(String scoreA) {
		this.scoreA = scoreA;
	}
	public String getScoreB() {
		return scoreB;
	}
	public void setScoreB(String scoreB) {
		this.scoreB = scoreB;
	}
	public String getScoreC() {
		return scoreC;
	}
	public void setScoreC(String scoreC) {
		this.scoreC = scoreC;
	}
	
	public String getPerformNm() {
		return performNm;
	}
	public void setPerformNm(String performNm) {
		this.performNm = performNm;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getS1ExecDate() {
		return s1ExecDate;
	}
	public void setS1ExecDate(String s1ExecDate) {
		this.s1ExecDate = s1ExecDate;
	}
	public String getNeuropsyKind() {
		return neuropsyKind;
	}
	public void setNeuropsyKind(String neuropsyKind) {
		this.neuropsyKind = neuropsyKind;
	}
	public String getClincianExecDate() {
		return clincianExecDate;
	}
	public void setClincianExecDate(String clincianExecDate) {
		this.clincianExecDate = clincianExecDate;
	}
	public String getS1001() {
		return s1001;
	}
	public void setS1001(String s1001) {
		this.s1001 = s1001;
	}

	public String getClinicianKind() {
		return clinicianKind;
	}
	public void setClinicianKind(String clinicianKind) {
		this.clinicianKind = clinicianKind;
	}
	public String getExts1() {
		return exts1;
	}
	public void setExts1(String exts1) {
		this.exts1 = exts1;
	}
	
	
}
