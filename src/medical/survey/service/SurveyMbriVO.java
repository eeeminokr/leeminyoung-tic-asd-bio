package medical.survey.service;

import medical.framework.vo.KoriginCommonVO;

public class SurveyMbriVO extends KoriginCommonVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1577791604263620732L;
	private int rownum;
	private String targetId;
	private String docId;
	private String performCnt;
	private String sex;
	private String birthYm;
	private String age;
	private String mbriExecDate;
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
	private String a11; 
	private String a12; 
	private String a13; 
	private String a14; 
	private String a15; 
	private String a16; 
	private String a17; 
	private String a18; 
	private String a19; 
	private String a20; 
	private String a21; 
	private String a22; 
	private String a23; 
	private String a24; 
	private String a25; 
	private String a26; 
	private String a27; 
	private String a28; 
	private String a29; 
	private String a30; 
	private String a31; 
	private String a32; 
	private String a33; 
	private String a34; 
	private String a35;
	private String a36;
	private String a37;
	private String a38;
	private String a39;
	private String a40;
	private String a41;
	private String a42;
	private String a43;
	private String a44;
	private String a45;
	private String a46;
	private String a47;
	private String a48;
	private String affectionateAttitude;	//애정적 태도
	private String denyAttitude;			//거부적 태도
	private String autonomousAttitude;		//자율적 태도 
	private String controlledAttitude;		//통제적 태도
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
	public String getMbriExecDate() {
		return mbriExecDate;
	}
	public void setMbriExecDate(String mbriExecDate) {
		this.mbriExecDate = mbriExecDate;
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
	public String getA13() {
		return a13;
	}
	public void setA13(String a13) {
		this.a13 = a13;
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
	public String getA30() {
		return a30;
	}
	public void setA30(String a30) {
		this.a30 = a30;
	}
	public String getA31() {
		return a31;
	}
	public void setA31(String a31) {
		this.a31 = a31;
	}
	public String getA32() {
		return a32;
	}
	public void setA32(String a32) {
		this.a32 = a32;
	}
	public String getA33() {
		return a33;
	}
	public void setA33(String a33) {
		this.a33 = a33;
	}
	public String getA34() {
		return a34;
	}
	public void setA34(String a34) {
		this.a34 = a34;
	}
	public String getA35() {
		return a35;
	}
	public void setA35(String a35) {
		this.a35 = a35;
	}
	public String getA36() {
		return a36;
	}
	public void setA36(String a36) {
		this.a36 = a36;
	}
	public String getA37() {
		return a37;
	}
	public void setA37(String a37) {
		this.a37 = a37;
	}
	public String getA38() {
		return a38;
	}
	public void setA38(String a38) {
		this.a38 = a38;
	}
	public String getA39() {
		return a39;
	}
	public void setA39(String a39) {
		this.a39 = a39;
	}
	public String getA40() {
		return a40;
	}
	public void setA40(String a40) {
		this.a40 = a40;
	}
	public String getA41() {
		return a41;
	}
	public void setA41(String a41) {
		this.a41 = a41;
	}
	public String getA42() {
		return a42;
	}
	public void setA42(String a42) {
		this.a42 = a42;
	}
	public String getA43() {
		return a43;
	}
	public void setA43(String a43) {
		this.a43 = a43;
	}
	public String getA44() {
		return a44;
	}
	public void setA44(String a44) {
		this.a44 = a44;
	}
	public String getA45() {
		return a45;
	}
	public void setA45(String a45) {
		this.a45 = a45;
	}
	public String getA46() {
		return a46;
	}
	public void setA46(String a46) {
		this.a46 = a46;
	}
	public String getA47() {
		return a47;
	}
	public void setA47(String a47) {
		this.a47 = a47;
	}
	public String getA48() {
		return a48;
	}
	public void setA48(String a48) {
		this.a48 = a48;
	}
	public String getAffectionateAttitude() {
		return affectionateAttitude;
	}
	public void setAffectionateAttitude(String affectionateAttitude) {
		this.affectionateAttitude = affectionateAttitude;
	}
	public String getDenyAttitude() {
		return denyAttitude;
	}
	public void setDenyAttitude(String denyAttitude) {
		this.denyAttitude = denyAttitude;
	}
	public String getAutonomousAttitude() {
		return autonomousAttitude;
	}
	public void setAutonomousAttitude(String autonomousAttitude) {
		this.autonomousAttitude = autonomousAttitude;
	}
	public String getControlledAttitude() {
		return controlledAttitude;
	}
	public void setControlledAttitude(String controlledAttitude) {
		this.controlledAttitude = controlledAttitude;
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
