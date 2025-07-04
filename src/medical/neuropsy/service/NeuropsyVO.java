package medical.neuropsy.service;

import medical.framework.vo.KoriginCommonVO;

public class NeuropsyVO extends KoriginCommonVO{


	/**
	 * 
	 */
	private static final long serialVersionUID = 6447873959433602844L;
	private String docId;
	private String rndId;
	private String docNm;
	private String disClassDtl;
	private String docClassDtl;
	private String docHeader;
	private String linkUrl;
	private String performCnt;
	private	String performCntNm;
	private String targetId;
	private String targetDisId; //대상사 뇌질환 ID
	private	String s1ExecDate;
	private String ataExecDate;
	private String catExecDate;
	private String ccttExecDate;
	private String cpt3ExecDate;
	private String exitiiExecDate;
	private String stroopExecDate;
	private String tmtExecDate;
	private	String wsctExecDate;
	private String ados1ExecDate;
	private String ados2ExecDate;
//	private String ados3ExecDate;
	private String pepExecDate;
	private String smsExecDate;
	private String carsExecDate;
	private	String neuropsyKind;
	private String sex;
	private String birthYm;
	private String protocol;
	private String startAge;
	private String endAge;
	private String execDate;
	private String s1;
	private String ata;
	private String stroop;
	private String cctt;
	private String wsct;
	private String cat;
	private String exitii;
	private String cpt3;
	private String tmt;
	
	
	
	
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
	public String getS1ExecDate() {
		return s1ExecDate;
	}
	public void setS1ExecDate(String s1ExecDate) {
		this.s1ExecDate = s1ExecDate;
	}
	public String getAtaExecDate() {
		return ataExecDate;
	}
	public void setAtaExecDate(String ataExecDate) {
		this.ataExecDate = ataExecDate;
	}
	public String getCatExecDate() {
		return catExecDate;
	}
	public void setCatExecDate(String catExecDate) {
		this.catExecDate = catExecDate;
	}
	public String getCcttExecDate() {
		return ccttExecDate;
	}
	public void setCcttExecDate(String ccttExecDate) {
		this.ccttExecDate = ccttExecDate;
	}
	public String getCpt3ExecDate() {
		return cpt3ExecDate;
	}
	public void setCpt3ExecDate(String cpt3ExecDate) {
		this.cpt3ExecDate = cpt3ExecDate;
	}
	public String getExitiiExecDate() {
		return exitiiExecDate;
	}
	public void setExitiiExecDate(String exitiiExecDate) {
		this.exitiiExecDate = exitiiExecDate;
	}
	public String getStroopExecDate() {
		return stroopExecDate;
	}
	public void setStroopExecDate(String stroopExecDate) {
		this.stroopExecDate = stroopExecDate;
	}
	public String getTmtExecDate() {
		return tmtExecDate;
	}
	public void setTmtExecDate(String tmtExecDate) {
		this.tmtExecDate = tmtExecDate;
	}
	public String getWsctExecDate() {
		return wsctExecDate;
	}
	public void setWsctExecDate(String wsctExecDate) {
		this.wsctExecDate = wsctExecDate;
	}
	public String getNeuropsyKind() {
		return neuropsyKind;
	}
	public void setNeuropsyKind(String neuropsyKind) {
		this.neuropsyKind = neuropsyKind;
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
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getAta() {
		return ata;
	}
	public void setAta(String ata) {
		this.ata = ata;
	}
	public String getStroop() {
		return stroop;
	}
	public void setStroop(String stroop) {
		this.stroop = stroop;
	}
	public String getCctt() {
		return cctt;
	}
	public void setCctt(String cctt) {
		this.cctt = cctt;
	}
	public String getWsct() {
		return wsct;
	}
	public void setWsct(String wsct) {
		this.wsct = wsct;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getExitii() {
		return exitii;
	}
	public void setExitii(String exitii) {
		this.exitii = exitii;
	}
	public String getCpt3() {
		return cpt3;
	}
	public void setCpt3(String cpt3) {
		this.cpt3 = cpt3;
	}
	public String getTmt() {
		return tmt;
	}
	public void setTmt(String tmt) {
		this.tmt = tmt;
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
	public String getAdos2ExecDate() {
		return ados2ExecDate;
	}
	public void setAdos2ExecDate(String ados2ExecDate) {
		this.ados2ExecDate = ados2ExecDate;
	}
//	public String getAdos3ExecDate() {
//		return ados3ExecDate;
//	}
//	public void setAdos3ExecDate(String ados3ExecDate) {
//		this.ados3ExecDate = ados3ExecDate;
//	}
	public String getPepExecDate() {
		return pepExecDate;
	}
	public void setPepExecDate(String pepExecDate) {
		this.pepExecDate = pepExecDate;
	}
	public String getSmsExecDate() {
		return smsExecDate;
	}
	public void setSmsExecDate(String smsExecDate) {
		this.smsExecDate = smsExecDate;
	}
	public String getCarsExecDate() {
		return carsExecDate;
	}
	public void setCarsExecDate(String carsExecDate) {
		this.carsExecDate = carsExecDate;
	}
}
