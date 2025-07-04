package medical.survey.service;

import medical.framework.vo.KoriginCommonVO;

public class SurveyKbis11rVO extends KoriginCommonVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -719887131108583353L;
	private int rownum;
	private String targetId;
	private String docId;
	private String performCnt;
	private String sex;
	private String birthYm;
	private String age;
	private String kbis11rExecDate;
	private String a1;  
	private String a1Rc;		//역코딩 문항당 최고 점수에서 앞의 값을 뺀 나머지 ex) a1문항의 최고점 5점, a1=3점일때 a1역코딩의 값 : 2점    
	private String a2;  
	private String a3;  
	private String a4;  
	private String a5;  
	private String a6;  
	private String a7;  
	private String a7Rc;  
	private String a8;  
	private String a8Rc;  
	private String a9;  
	private String a9Rc;  
	private String a10; 
	private String a10Rc; 
	private String a11; 
	private String a12; 
	private String a12Rc; 
	private String a13; 
	private String a13Rc; 
	private String a14; 
	private String a15; 
	private String a15Rc; 
	private String a16; 
	private String a17; 
	private String a18; 
	private String a19; 
	private String a20; 
	private String a20Rc; 
	private String a21; 
	private String a22; 
	private String a23; 
	private String a24; 
	private String a25; 
	private String a26; 
	private String a27; 
	private String a28; 
	private String a29; 
	private String a29Rc; 
	private String a30;
	private String a30Rc;
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
	public String getKbis11rExecDate() {
		return kbis11rExecDate;
	}
	public void setKbis11rExecDate(String kbis11rExecDate) {
		this.kbis11rExecDate = kbis11rExecDate;
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
	public String getA1Rc() {
		return a1Rc;
	}
	public void setA1Rc(String a1Rc) {
		this.a1Rc = a1Rc;
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
	public String getA7Rc() {
		return a7Rc;
	}
	public void setA7Rc(String a7Rc) {
		this.a7Rc = a7Rc;
	}
	public String getA8() {
		return a8;
	}
	public void setA8(String a8) {
		this.a8 = a8;
	}
	public String getA8Rc() {
		return a8Rc;
	}
	public void setA8Rc(String a8Rc) {
		this.a8Rc = a8Rc;
	}
	public String getA9() {
		return a9;
	}
	public void setA9(String a9) {
		this.a9 = a9;
	}
	public String getA9Rc() {
		return a9Rc;
	}
	public void setA9Rc(String a9Rc) {
		this.a9Rc = a9Rc;
	}
	public String getA10() {
		return a10;
	}
	public void setA10(String a10) {
		this.a10 = a10;
	}
	public String getA10Rc() {
		return a10Rc;
	}
	public void setA10Rc(String a10Rc) {
		this.a10Rc = a10Rc;
	}
	public String getA11() {
		return a11;
	}
	public void setA11(String a11) {
		this.a11 = a11;
	}
	public String getA12() {
		return a12;
	}
	public void setA12(String a12) {
		this.a12 = a12;
	}
	public String getA12Rc() {
		return a12Rc;
	}
	public void setA12Rc(String a12Rc) {
		this.a12Rc = a12Rc;
	}
	public String getA13() {
		return a13;
	}
	public void setA13(String a13) {
		this.a13 = a13;
	}
	public String getA13Rc() {
		return a13Rc;
	}
	public void setA13Rc(String a13Rc) {
		this.a13Rc = a13Rc;
	}
	public String getA14() {
		return a14;
	}
	public void setA14(String a14) {
		this.a14 = a14;
	}
	public String getA15() {
		return a15;
	}
	public void setA15(String a15) {
		this.a15 = a15;
	}
	public String getA15Rc() {
		return a15Rc;
	}
	public void setA15Rc(String a15Rc) {
		this.a15Rc = a15Rc;
	}
	public String getA16() {
		return a16;
	}
	public void setA16(String a16) {
		this.a16 = a16;
	}
	public String getA17() {
		return a17;
	}
	public void setA17(String a17) {
		this.a17 = a17;
	}
	public String getA18() {
		return a18;
	}
	public void setA18(String a18) {
		this.a18 = a18;
	}
	public String getA19() {
		return a19;
	}
	public void setA19(String a19) {
		this.a19 = a19;
	}
	public String getA20() {
		return a20;
	}
	public void setA20(String a20) {
		this.a20 = a20;
	}
	public String getA20Rc() {
		return a20Rc;
	}
	public void setA20Rc(String a20Rc) {
		this.a20Rc = a20Rc;
	}
	public String getA21() {
		return a21;
	}
	public void setA21(String a21) {
		this.a21 = a21;
	}
	public String getA22() {
		return a22;
	}
	public void setA22(String a22) {
		this.a22 = a22;
	}
	public String getA23() {
		return a23;
	}
	public void setA23(String a23) {
		this.a23 = a23;
	}
	public String getA24() {
		return a24;
	}
	public void setA24(String a24) {
		this.a24 = a24;
	}
	public String getA25() {
		return a25;
	}
	public void setA25(String a25) {
		this.a25 = a25;
	}
	public String getA26() {
		return a26;
	}
	public void setA26(String a26) {
		this.a26 = a26;
	}
	public String getA27() {
		return a27;
	}
	public void setA27(String a27) {
		this.a27 = a27;
	}
	public String getA28() {
		return a28;
	}
	public void setA28(String a28) {
		this.a28 = a28;
	}
	public String getA29() {
		return a29;
	}
	public void setA29(String a29) {
		this.a29 = a29;
	}
	public String getA29Rc() {
		return a29Rc;
	}
	public void setA29Rc(String a29Rc) {
		this.a29Rc = a29Rc;
	}
	public String getA30() {
		return a30;
	}
	public void setA30(String a30) {
		this.a30 = a30;
	}
	public String getA30Rc() {
		return a30Rc;
	}
	public void setA30Rc(String a30Rc) {
		this.a30Rc = a30Rc;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
