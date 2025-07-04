package medical.gene.service;

import medical.framework.vo.KoriginCommonVO;

public class GeneVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1471395791814328080L;
	
	private String docId;
	private String rndId;
	private String docNm;
	private String disClassDtl;
	private String docClassDtl;
	private String docHeader;
	private String linkUrl;
	private String performCnt;
	private String performCnts;
	private	String performCntNm;
	private String targetId;
	private String targetIds;
	
	private String targetDisId; //대상사 뇌질환 ID
	private	String geneKind;
	private String sex;
	private String birthYm;
	private String protocol;
	private String startAge;
	private String endAge;
	private String envMattExecDate;
	private String envMattBlExecDate;
	private String genExecDate;
	private String snpExecDate;
	private String envMatt;
	private String envMattBl;
	private String gen;
	private String snp;
	
	
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

	public String getEnvMattExecDate() {
		return envMattExecDate;
	}
	public void setEnvMattExecDate(String envMattExecDate) {
		this.envMattExecDate = envMattExecDate;
	}
	public String getGenExecDate() {
		return genExecDate;
	}
	public void setGenExecDate(String genExecDate) {
		this.genExecDate = genExecDate;
	}
	public String getSnpExecDate() {
		return snpExecDate;
	}
	public void setSnpExecDate(String snpExecDate) {
		this.snpExecDate = snpExecDate;
	}
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
	public String getEnvMatt() {
		return envMatt;
	}
	public void setEnvMatt(String envMatt) {
		this.envMatt = envMatt;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getSnp() {
		return snp;
	}
	public void setSnp(String snp) {
		this.snp = snp;
	}
	public String getEnvMattBlExecDate() {
		return envMattBlExecDate;
	}
	public void setEnvMattBlExecDate(String envMattBlExecDate) {
		this.envMattBlExecDate = envMattBlExecDate;
	}
	public String getEnvMattBl() {
		return envMattBl;
	}
	public void setEnvMattBl(String envMattBl) {
		this.envMattBl = envMattBl;
	}
	public String getGeneKind() {
		return geneKind;
	}
	public void setGeneKind(String geneKind) {
		this.geneKind = geneKind;
	}
	
}
