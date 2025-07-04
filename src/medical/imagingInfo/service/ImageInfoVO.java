package medical.imagingInfo.service;

import medical.framework.vo.KoriginCommonVO;

public class ImageInfoVO extends KoriginCommonVO{
	private static final long serialVersionUID = 1L;
	private int rownum;
	private String rndId;
	private String performCntNm;
	private String targetId;
	private String targetDisId; //대상자 뇌질환 id
	private String seriesId;
	private String path;
	private String modality;
	private String mnuFactr;
	private String instNm;
	private String seriesDesc;
	private String mnufactrMdnm;
	private String mgfStrength;
	private String studyDate;
	private String patientId;
	private String patientSex;
	private String patientAge;
	
	private String testKindDtlCd;
	private String classCdDtlNm;
	private String zipPath;
	private String niiPath;
	private String qcStatus;
	private String remarks;
	private String pngUrl;
	private String pngTitle;
	private String niiZipPath;
	private String qcUpdateDate;
	private String qcUpdateBy;
	private String qcInfo;
	
	private String watchClass;
	private String watchClassKr;
	private String watchItem;
	private String watchItemKr;
	private String chkYn;
	private String qcwatchYn;
	private int activePage;
	private String disClassDtl;
	private String taskIdentity;
	
	//영상 페이지
	private String sex;
	private String birthYm;
	private String performCnt;
	private String protocol;
	private String age;
	private String execDate;
	private String visitDate;
	private String pocral;
	
	private String amri;
	private String dti;
	private String asl;
	private String fmri;
	private String t1;
	private String t2;
	private String swi;
	
	private String startAge;
	private String endAge;
	private String updateDate;
	
	
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getTaskIdentity() {
		return taskIdentity;
	}
	public void setTaskIdentity(String taskIdentity) {
		this.taskIdentity = taskIdentity;
	}
	public String getPerformCntNm() {
		return performCntNm;
	}
	public void setPerformCntNm(String performCntNm) {
		this.performCntNm = performCntNm;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public int getActivePage() {
		return activePage;
	}
	public void setActivePage(int activePage) {
		this.activePage = activePage;
	}
	public String getPngUrl() {
		return pngUrl;
	}
	public void setPngUrl(String pngUrl) {
		this.pngUrl = pngUrl;
	}
	public String getPngTitle() {
		return pngTitle;
	}
	public void setPngTitle(String pngTitle) {
		this.pngTitle = pngTitle;
	}
	public String getQcInfo() {
		return qcInfo;
	}
	public void setQcInfo(String qcInfo) {
		this.qcInfo = qcInfo;
	}
	public String getQcUpdateDate() {
		return qcUpdateDate;
	}
	public void setQcUpdateDate(String qcUpdateDate) {
		this.qcUpdateDate = qcUpdateDate;
	}
	public String getQcUpdateBy() {
		return qcUpdateBy;
	}
	public void setQcUpdateBy(String qcUpdateBy) {
		this.qcUpdateBy = qcUpdateBy;
	}
	public String getQcStatus() {
		return qcStatus;
	}
	public void setQcStatus(String qcStatus) {
		this.qcStatus = qcStatus;
	}
	public String getNiiZipPath() {
		return niiZipPath;
	}
	public void setNiiZipPath(String niiZipPath) {
		this.niiZipPath = niiZipPath;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getZipPath() {
		return zipPath;
	}
	public void setZipPath(String zipPath) {
		this.zipPath = zipPath;
	}
	public String getNiiPath() {
		return niiPath;
	}
	public void setNiiPath(String niiPath) {
		this.niiPath = niiPath;
	}
	public String getTestKindDtlCd() {
		return testKindDtlCd;
	}
	public void setTestKindDtlCd(String testKindDtlCd) {
		this.testKindDtlCd = testKindDtlCd;
	}
	public String getClassCdDtlNm() {
		return classCdDtlNm;
	}
	public void setClassCdDtlNm(String classCdDtlNm) {
		this.classCdDtlNm = classCdDtlNm;
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
	public String getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getModality() {
		return modality;
	}
	public void setModality(String modality) {
		this.modality = modality;
	}
	public String getMnuFactr() {
		return mnuFactr;
	}
	public void setMnuFactr(String mnuFactr) {
		this.mnuFactr = mnuFactr;
	}
	public String getInstNm() {
		return instNm;
	}
	public void setInstNm(String instNm) {
		this.instNm = instNm;
	}
	public String getSeriesDesc() {
		return seriesDesc;
	}
	public void setSeriesDesc(String seriesDesc) {
		this.seriesDesc = seriesDesc;
	}
	public String getMnufactrMdnm() {
		return mnufactrMdnm;
	}
	public void setMnufactrMdnm(String mnufactrMdnm) {
		this.mnufactrMdnm = mnufactrMdnm;
	}
	public String getMgfStrength() {
		return mgfStrength;
	}
	public void setMgfStrength(String mgfStrength) {
		this.mgfStrength = mgfStrength;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(String patientSex) {
		this.patientSex = patientSex;
	}
	public String getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}
	public String getWatchClass() {
		return watchClass;
	}
	public void setWatchClass(String watchClass) {
		this.watchClass = watchClass;
	}
	public String getWatchClassKr() {
		return watchClassKr;
	}
	public void setWatchClassKr(String watchClassKr) {
		this.watchClassKr = watchClassKr;
	}
	public String getWatchItem() {
		return watchItem;
	}
	public void setWatchItem(String watchItem) {
		this.watchItem = watchItem;
	}
	public String getWatchItemKr() {
		return watchItemKr;
	}
	public void setWatchItemKr(String watchItemKr) {
		this.watchItemKr = watchItemKr;
	}
	public String getChkYn() {
		return chkYn;
	}
	public void setChkYn(String chkYn) {
		this.chkYn = chkYn;
	}
	public String getQcwatchYn() {
		return qcwatchYn;
	}
	public void setQcwatchYn(String qcwatchYn) {
		this.qcwatchYn = qcwatchYn;
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
	public String getPerformCnt() {
		return performCnt;
	}
	public void setPerformCnt(String performCnt) {
		this.performCnt = performCnt;
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
	public String getPocral() {
		return pocral;
	}
	public void setPocral(String pocral) {
		this.pocral = pocral;
	}
	public String getAmri() {
		return amri;
	}
	public void setAmri(String amri) {
		this.amri = amri;
	}
	public String getDti() {
		return dti;
	}
	public void setDti(String dti) {
		this.dti = dti;
	}
	public String getAsl() {
		return asl;
	}
	public void setAsl(String asl) {
		this.asl = asl;
	}
	public String getFmri() {
		return fmri;
	}
	public void setFmri(String fmri) {
		this.fmri = fmri;
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
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getTargetDisId() {
		return targetDisId;
	}
	public void setTargetDisId(String targetDisId) {
		this.targetDisId = targetDisId;
	}
	public String getSwi() {
		return swi;
	}
	public void setSwi(String swi) {
		this.swi = swi;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
}
