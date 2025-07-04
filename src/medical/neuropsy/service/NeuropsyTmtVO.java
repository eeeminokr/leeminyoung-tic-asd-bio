package medical.neuropsy.service;

import medical.framework.vo.KoriginCommonVO;

public class NeuropsyTmtVO extends KoriginCommonVO{
	
	
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
	private String tmtExecDate;
	private String tmtArt;
	private String tmtAError;
	private String tmtBrt;
	private String tmtBError;
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
	public String getTmtExecDate() {
		return tmtExecDate;
	}
	public void setTmtExecDate(String tmtExecDate) {
		this.tmtExecDate = tmtExecDate;
	}
	public String getTmtArt() {
		return tmtArt;
	}
	public void setTmtArt(String tmtArt) {
		this.tmtArt = tmtArt;
	}
	public String getTmtAError() {
		return tmtAError;
	}
	public void setTmtAError(String tmtAError) {
		this.tmtAError = tmtAError;
	}
	public String getTmtBrt() {
		return tmtBrt;
	}
	public void setTmtBrt(String tmtBrt) {
		this.tmtBrt = tmtBrt;
	}
	public String getTmtBError() {
		return tmtBError;
	}
	public void setTmtBError(String tmtBError) {
		this.tmtBError = tmtBError;
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

