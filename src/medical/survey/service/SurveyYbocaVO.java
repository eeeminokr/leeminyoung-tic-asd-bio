package medical.survey.service;

import medical.framework.vo.KoriginCommonVO;

public class SurveyYbocaVO extends KoriginCommonVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3657043226717005890L;
	private int rownum;
	private String targetId;
	private String docId;
	private String performCnt;
	private String sex;
	private String birthYm;
	private String age;
	private String ybocaExecDate;
	private String a1;  
	private String a2;  
	private String a3;  
	private String a4;  
	private String a5;  
	private String a6;  
	private String a7;  
	private String a8;  
	private String a9;  
	private String a10;
	private String compulsion;		//강박사고
	private String compulsiveBehavior;	//강박행동
	private String totalScore;
	private String remarks;
	private String performNm;
	private String protocol;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
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
	public String getYbocaExecDate() {
		return ybocaExecDate;
	}
	public void setYbocaExecDate(String ybocaExecDate) {
		this.ybocaExecDate = ybocaExecDate;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
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
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = a3;
	}
	public String getA4() {
		return a4;
	}
	public void setA4(String a4) {
		this.a4 = a4;
	}
	public String getA5() {
		return a5;
	}
	public void setA5(String a5) {
		this.a5 = a5;
	}
	public String getA6() {
		return a6;
	}
	public void setA6(String a6) {
		this.a6 = a6;
	}
	public String getA7() {
		return a7;
	}
	public void setA7(String a7) {
		this.a7 = a7;
	}
	public String getA8() {
		return a8;
	}
	public void setA8(String a8) {
		this.a8 = a8;
	}
	public String getA9() {
		return a9;
	}
	public void setA9(String a9) {
		this.a9 = a9;
	}
	public String getA10() {
		return a10;
	}
	public void setA10(String a10) {
		this.a10 = a10;
	}
	public String getCompulsion() {
		return compulsion;
	}
	public void setCompulsion(String compulsion) {
		this.compulsion = compulsion;
	}
	public String getCompulsiveBehavior() {
		return compulsiveBehavior;
	}
	public void setCompulsiveBehavior(String compulsiveBehavior) {
		this.compulsiveBehavior = compulsiveBehavior;
	}
	public String getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
