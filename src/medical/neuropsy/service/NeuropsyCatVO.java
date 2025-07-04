package medical.neuropsy.service;

import medical.framework.vo.KoriginCommonVO;

public class NeuropsyCatVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6678059028412778968L;
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
	private String catExecDate;
	private String catvMissr;
	private String catvFalarmr;
	private String catvReactrAvg;
	private String catvReactrDev;
	private String catvMissaq;
	private String catvFalarmaq;
	private String catvReactaqAvg;
	private String catvReactaqDev;
	private String cathMissr;
	private String cathFalarmr;
	private String cathReactrAvg;
	private String cathReactrDev;
	private String cathMissaq;
	private String cathFalarmaq;
	private String cathReactaqAvg;
	private String cathReactaqDev;
	private String catcMissr;
	private String catcFalarmr;
	private String catcReactrAvg;
	private String catcReactrDev;
	private String catcMissaq;
	private String catcFalarmaq;
	private String catcReactaqAvg;
	private String catcReactaqDev;
	private String catiMissr;
	private String catiFalarmr;
	private String catiReactrAvg;
	private String catiReactrDev;
	private String catiMissaq;
	private String catiFalarmaq;
	private String catiReactaqAvg;
	private String catiReactaqDev;
	private String catdMissr;
	private String catdFalarmr;
	private String catdReactrAvg;
	private String catdReactrDev;
	private String catdMissaq;
	private String catdFalarmaq;
	private String catdReactaqAvg;
	private String catdReactaqDev;
	private String catmdReactr;
	private String catmrReactr;
	private String catmdSpacer;
	private String catmrSpacer;
	private String catmdReactaq;
	private String catmrReactaq;
	private String catmdSpaceaq;
	private String catmrSpaceaq;
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
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getCatExecDate() {
		return catExecDate;
	}
	public void setCatExecDate(String catExecDate) {
		this.catExecDate = catExecDate;
	}
	public String getCatvMissr() {
		return catvMissr;
	}
	public void setCatvMissr(String catvMissr) {
		this.catvMissr = catvMissr;
	}
	public String getCatvFalarmr() {
		return catvFalarmr;
	}
	public void setCatvFalarmr(String catvFalarmr) {
		this.catvFalarmr = catvFalarmr;
	}
	public String getCatvReactrAvg() {
		return catvReactrAvg;
	}
	public void setCatvReactrAvg(String catvReactrAvg) {
		this.catvReactrAvg = catvReactrAvg;
	}
	public String getCatvReactrDev() {
		return catvReactrDev;
	}
	public void setCatvReactrDev(String catvReactrDev) {
		this.catvReactrDev = catvReactrDev;
	}
	public String getCatvMissaq() {
		return catvMissaq;
	}
	public void setCatvMissaq(String catvMissaq) {
		this.catvMissaq = catvMissaq;
	}
	public String getCatvFalarmaq() {
		return catvFalarmaq;
	}
	public void setCatvFalarmaq(String catvFalarmaq) {
		this.catvFalarmaq = catvFalarmaq;
	}
	public String getCatvReactaqAvg() {
		return catvReactaqAvg;
	}
	public void setCatvReactaqAvg(String catvReactaqAvg) {
		this.catvReactaqAvg = catvReactaqAvg;
	}
	public String getCatvReactaqDev() {
		return catvReactaqDev;
	}
	public void setCatvReactaqDev(String catvReactaqDev) {
		this.catvReactaqDev = catvReactaqDev;
	}
	public String getCathMissr() {
		return cathMissr;
	}
	public void setCathMissr(String cathMissr) {
		this.cathMissr = cathMissr;
	}
	public String getCathFalarmr() {
		return cathFalarmr;
	}
	public void setCathFalarmr(String cathFalarmr) {
		this.cathFalarmr = cathFalarmr;
	}
	public String getCathReactrAvg() {
		return cathReactrAvg;
	}
	public void setCathReactrAvg(String cathReactrAvg) {
		this.cathReactrAvg = cathReactrAvg;
	}
	public String getCathReactrDev() {
		return cathReactrDev;
	}
	public void setCathReactrDev(String cathReactrDev) {
		this.cathReactrDev = cathReactrDev;
	}
	public String getCathMissaq() {
		return cathMissaq;
	}
	public void setCathMissaq(String cathMissaq) {
		this.cathMissaq = cathMissaq;
	}
	public String getCathFalarmaq() {
		return cathFalarmaq;
	}
	public void setCathFalarmaq(String cathFalarmaq) {
		this.cathFalarmaq = cathFalarmaq;
	}
	public String getCathReactaqAvg() {
		return cathReactaqAvg;
	}
	public void setCathReactaqAvg(String cathReactaqAvg) {
		this.cathReactaqAvg = cathReactaqAvg;
	}
	public String getCathReactaqDev() {
		return cathReactaqDev;
	}
	public void setCathReactaqDev(String cathReactaqDev) {
		this.cathReactaqDev = cathReactaqDev;
	}
	public String getCatcMissr() {
		return catcMissr;
	}
	public void setCatcMissr(String catcMissr) {
		this.catcMissr = catcMissr;
	}
	public String getCatcFalarmr() {
		return catcFalarmr;
	}
	public void setCatcFalarmr(String catcFalarmr) {
		this.catcFalarmr = catcFalarmr;
	}
	public String getCatcReactrAvg() {
		return catcReactrAvg;
	}
	public void setCatcReactrAvg(String catcReactrAvg) {
		this.catcReactrAvg = catcReactrAvg;
	}
	public String getCatcReactrDev() {
		return catcReactrDev;
	}
	public void setCatcReactrDev(String catcReactrDev) {
		this.catcReactrDev = catcReactrDev;
	}
	public String getCatcMissaq() {
		return catcMissaq;
	}
	public void setCatcMissaq(String catcMissaq) {
		this.catcMissaq = catcMissaq;
	}
	public String getCatcFalarmaq() {
		return catcFalarmaq;
	}
	public void setCatcFalarmaq(String catcFalarmaq) {
		this.catcFalarmaq = catcFalarmaq;
	}
	public String getCatcReactaqAvg() {
		return catcReactaqAvg;
	}
	public void setCatcReactaqAvg(String catcReactaqAvg) {
		this.catcReactaqAvg = catcReactaqAvg;
	}
	public String getCatcReactaqDev() {
		return catcReactaqDev;
	}
	public void setCatcReactaqDev(String catcReactaqDev) {
		this.catcReactaqDev = catcReactaqDev;
	}
	public String getCatiMissr() {
		return catiMissr;
	}
	public void setCatiMissr(String catiMissr) {
		this.catiMissr = catiMissr;
	}
	public String getCatiFalarmr() {
		return catiFalarmr;
	}
	public void setCatiFalarmr(String catiFalarmr) {
		this.catiFalarmr = catiFalarmr;
	}
	public String getCatiReactrAvg() {
		return catiReactrAvg;
	}
	public void setCatiReactrAvg(String catiReactrAvg) {
		this.catiReactrAvg = catiReactrAvg;
	}
	public String getCatiReactrDev() {
		return catiReactrDev;
	}
	public void setCatiReactrDev(String catiReactrDev) {
		this.catiReactrDev = catiReactrDev;
	}
	public String getCatiMissaq() {
		return catiMissaq;
	}
	public void setCatiMissaq(String catiMissaq) {
		this.catiMissaq = catiMissaq;
	}
	public String getCatiFalarmaq() {
		return catiFalarmaq;
	}
	public void setCatiFalarmaq(String catiFalarmaq) {
		this.catiFalarmaq = catiFalarmaq;
	}
	public String getCatiReactaqAvg() {
		return catiReactaqAvg;
	}
	public void setCatiReactaqAvg(String catiReactaqAvg) {
		this.catiReactaqAvg = catiReactaqAvg;
	}
	public String getCatiReactaqDev() {
		return catiReactaqDev;
	}
	public void setCatiReactaqDev(String catiReactaqDev) {
		this.catiReactaqDev = catiReactaqDev;
	}
	public String getCatdMissr() {
		return catdMissr;
	}
	public void setCatdMissr(String catdMissr) {
		this.catdMissr = catdMissr;
	}
	public String getCatdFalarmr() {
		return catdFalarmr;
	}
	public void setCatdFalarmr(String catdFalarmr) {
		this.catdFalarmr = catdFalarmr;
	}
	public String getCatdReactrAvg() {
		return catdReactrAvg;
	}
	public void setCatdReactrAvg(String catdReactrAvg) {
		this.catdReactrAvg = catdReactrAvg;
	}
	public String getCatdReactrDev() {
		return catdReactrDev;
	}
	public void setCatdReactrDev(String catdReactrDev) {
		this.catdReactrDev = catdReactrDev;
	}
	public String getCatdMissaq() {
		return catdMissaq;
	}
	public void setCatdMissaq(String catdMissaq) {
		this.catdMissaq = catdMissaq;
	}
	public String getCatdFalarmaq() {
		return catdFalarmaq;
	}
	public void setCatdFalarmaq(String catdFalarmaq) {
		this.catdFalarmaq = catdFalarmaq;
	}
	public String getCatdReactaqAvg() {
		return catdReactaqAvg;
	}
	public void setCatdReactaqAvg(String catdReactaqAvg) {
		this.catdReactaqAvg = catdReactaqAvg;
	}
	public String getCatdReactaqDev() {
		return catdReactaqDev;
	}
	public void setCatdReactaqDev(String catdReactaqDev) {
		this.catdReactaqDev = catdReactaqDev;
	}
	public String getCatmdReactr() {
		return catmdReactr;
	}
	public void setCatmdReactr(String catmdReactr) {
		this.catmdReactr = catmdReactr;
	}
	public String getCatmrReactr() {
		return catmrReactr;
	}
	public void setCatmrReactr(String catmrReactr) {
		this.catmrReactr = catmrReactr;
	}
	public String getCatmdSpacer() {
		return catmdSpacer;
	}
	public void setCatmdSpacer(String catmdSpacer) {
		this.catmdSpacer = catmdSpacer;
	}
	public String getCatmrSpacer() {
		return catmrSpacer;
	}
	public void setCatmrSpacer(String catmrSpacer) {
		this.catmrSpacer = catmrSpacer;
	}
	public String getCatmdReactaq() {
		return catmdReactaq;
	}
	public void setCatmdReactaq(String catmdReactaq) {
		this.catmdReactaq = catmdReactaq;
	}
	public String getCatmrReactaq() {
		return catmrReactaq;
	}
	public void setCatmrReactaq(String catmrReactaq) {
		this.catmrReactaq = catmrReactaq;
	}
	public String getCatmdSpaceaq() {
		return catmdSpaceaq;
	}
	public void setCatmdSpaceaq(String catmdSpaceaq) {
		this.catmdSpaceaq = catmdSpaceaq;
	}
	public String getCatmrSpaceaq() {
		return catmrSpaceaq;
	}
	public void setCatmrSpaceaq(String catmrSpaceaq) {
		this.catmrSpaceaq = catmrSpaceaq;
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
