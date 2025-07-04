package medical.survey.service;

import medical.framework.vo.KoriginCommonVO;

public class SurveyLoicvVO extends KoriginCommonVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2924144214592170283L;
	private int rownum;
	private String targetId;
	private String docId;
	private String performCnt;
	private String currentTime;
	private String sex;
	private String birthYm;
	private String age;
	private String loicvExecDate;
	private String a1;  
	private String a1Feeling;		//느낌  
	private String a1Encumbrance;  	//지장
	private String a2;  
	private String a2Feeling;		//느낌  
	private String a2Encumbrance;  	//지장
	private String a3;  
	private String a3Feeling;		//느낌  
	private String a3Encumbrance;  	//지장
	private String a4;  
	private String a4Feeling;		//느낌  
	private String a4Encumbrance;  	//지장
	private String a5;  
	private String a5Feeling;		//느낌  
	private String a5Encumbrance;  	//지장
	private String a6;  
	private String a6Feeling;		//느낌  
	private String a6Encumbrance;  	//지장
	private String a7;  
	private String a7Feeling;		//느낌  
	private String a7Encumbrance;  	//지장
	private String a8;  
	private String a8Feeling;		//느낌  
	private String a8Encumbrance;  	//지장
	private String a9;  
	private String a9Feeling;		//느낌  
	private String a9Encumbrance;  	//지장
	private String a10;  
	private String a10Feeling;		//느낌  
	private String a10Encumbrance;  //지장
	private String a11;  
	private String a11Feeling;		//느낌  
	private String a11Encumbrance;  //지장
	private String a12;  
	private String a12Feeling;		//느낌  
	private String a12Encumbrance;  //지장
	private String a13;  
	private String a13Feeling;		//느낌  
	private String a13Encumbrance;  //지장
	private String a14;  
	private String a14Feeling;		//느낌  
	private String a14Encumbrance;  //지장
	private String a15;  
	private String a15Feeling;		//느낌  
	private String a15Encumbrance;  //지장
	private String a16;  
	private String a16Feeling;		//느낌  
	private String a16Encumbrance;  //지장
	private String a17;  
	private String a17Feeling;		//느낌  
	private String a17Encumbrance;  //지장
	private String a18;  
	private String a18Feeling;		//느낌  
	private String a18Encumbrance;  //지장
	private String a19;  
	private String a19Feeling;		//느낌  
	private String a19Encumbrance;  //지장
	private String a20;  
	private String a20Feeling;		//느낌  
	private String a20Encumbrance;  //지장
	private String a21;  
	private String a21Feeling;		//느낌  
	private String a21Encumbrance;  //지장
	private String a22;  
	private String a22Feeling;		//느낌  
	private String a22Encumbrance;  //지장
	private String a23;  
	private String a23Feeling;		//느낌  
	private String a23Encumbrance;  //지장
	private String a24;  
	private String a24Feeling;		//느낌  
	private String a24Encumbrance;  //지장
	private String a25;  
	private String a25Feeling;		//느낌  
	private String a25Encumbrance;  //지장
	private String a26;  
	private String a26Feeling;		//느낌  
	private String a26Encumbrance;  //지장
	private String a27;  
	private String a27Feeling;		//느낌  
	private String a27Encumbrance;  //지장
	private String a28;  
	private String a28Feeling;		//느낌  
	private String a28Encumbrance;  //지장
	private String a29;  
	private String a29Feeling;		//느낌  
	private String a29Encumbrance;  //지장
	private String a30;  
	private String a30Feeling;		//느낌  
	private String a30Encumbrance;  //지장
	private String a31;  
	private String a31Feeling;		//느낌  
	private String a31Encumbrance;  //지장
	private String a32;  
	private String a32Feeling;		//느낌  
	private String a32Encumbrance;  //지장
	private String a33;  
	private String a33Feeling;		//느낌  
	private String a33Encumbrance;  //지장
	private String a34;  
	private String a34Feeling;		//느낌  
	private String a34Encumbrance;  //지장
	private String a35;  
	private String a35Feeling;		//느낌  
	private String a35Encumbrance;  //지장
	private String a36;  
	private String a36Feeling;		//느낌  
	private String a36Encumbrance;  //지장
	private String a37;  
	private String a37Feeling;		//느낌  
	private String a37Encumbrance;  //지장
	private String a38;  
	private String a38Feeling;		//느낌  
	private String a38Encumbrance;  //지장
	private String a39;  
	private String a39Feeling;		//느낌  
	private String a39Encumbrance;  //지장
	private String a40;  
	private String a40Feeling;		//느낌  
	private String a40Encumbrance;  //지장
	private String a41;  
	private String a41Feeling;		//느낌  
	private String a41Encumbrance;  //지장
	private String a42;  
	private String a42Feeling;		//느낌  
	private String a42Encumbrance;  //지장
	private String a43;  
	private String a43Feeling;		//느낌  
	private String a43Encumbrance;  //지장
	private String a44;  
	private String a44Feeling;		//느낌  
	private String a44Encumbrance;  //지장
	private String totalYnScore;
	private String totalFeelingScore;
	private String totalEncumbranceScore;
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
	public String getLoicvExecDate() {
		return loicvExecDate;
	}
	public void setLoicvExecDate(String loicvExecDate) {
		this.loicvExecDate = loicvExecDate;
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
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getA1Feeling() {
		return a1Feeling;
	}
	public void setA1Feeling(String a1Feeling) {
		this.a1Feeling = a1Feeling;
	}
	public String getA1Encumbrance() {
		return a1Encumbrance;
	}
	public void setA1Encumbrance(String a1Encumbrance) {
		this.a1Encumbrance = a1Encumbrance;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getA2Feeling() {
		return a2Feeling;
	}
	public void setA2Feeling(String a2Feeling) {
		this.a2Feeling = a2Feeling;
	}
	public String getA2Encumbrance() {
		return a2Encumbrance;
	}
	public void setA2Encumbrance(String a2Encumbrance) {
		this.a2Encumbrance = a2Encumbrance;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = a3;
	}
	public String getA3Feeling() {
		return a3Feeling;
	}
	public void setA3Feeling(String a3Feeling) {
		this.a3Feeling = a3Feeling;
	}
	public String getA3Encumbrance() {
		return a3Encumbrance;
	}
	public void setA3Encumbrance(String a3Encumbrance) {
		this.a3Encumbrance = a3Encumbrance;
	}
	public String getA4() {
		return a4;
	}
	public void setA4(String a4) {
		this.a4 = a4;
	}
	public String getA4Feeling() {
		return a4Feeling;
	}
	public void setA4Feeling(String a4Feeling) {
		this.a4Feeling = a4Feeling;
	}
	public String getA4Encumbrance() {
		return a4Encumbrance;
	}
	public void setA4Encumbrance(String a4Encumbrance) {
		this.a4Encumbrance = a4Encumbrance;
	}
	public String getA5() {
		return a5;
	}
	public void setA5(String a5) {
		this.a5 = a5;
	}
	public String getA5Feeling() {
		return a5Feeling;
	}
	public void setA5Feeling(String a5Feeling) {
		this.a5Feeling = a5Feeling;
	}
	public String getA5Encumbrance() {
		return a5Encumbrance;
	}
	public void setA5Encumbrance(String a5Encumbrance) {
		this.a5Encumbrance = a5Encumbrance;
	}
	public String getA6() {
		return a6;
	}
	public void setA6(String a6) {
		this.a6 = a6;
	}
	public String getA6Feeling() {
		return a6Feeling;
	}
	public void setA6Feeling(String a6Feeling) {
		this.a6Feeling = a6Feeling;
	}
	public String getA6Encumbrance() {
		return a6Encumbrance;
	}
	public void setA6Encumbrance(String a6Encumbrance) {
		this.a6Encumbrance = a6Encumbrance;
	}
	public String getA7() {
		return a7;
	}
	public void setA7(String a7) {
		this.a7 = a7;
	}
	public String getA7Feeling() {
		return a7Feeling;
	}
	public void setA7Feeling(String a7Feeling) {
		this.a7Feeling = a7Feeling;
	}
	public String getA7Encumbrance() {
		return a7Encumbrance;
	}
	public void setA7Encumbrance(String a7Encumbrance) {
		this.a7Encumbrance = a7Encumbrance;
	}
	public String getA8() {
		return a8;
	}
	public void setA8(String a8) {
		this.a8 = a8;
	}
	public String getA8Feeling() {
		return a8Feeling;
	}
	public void setA8Feeling(String a8Feeling) {
		this.a8Feeling = a8Feeling;
	}
	public String getA8Encumbrance() {
		return a8Encumbrance;
	}
	public void setA8Encumbrance(String a8Encumbrance) {
		this.a8Encumbrance = a8Encumbrance;
	}
	public String getA9() {
		return a9;
	}
	public void setA9(String a9) {
		this.a9 = a9;
	}
	public String getA9Feeling() {
		return a9Feeling;
	}
	public void setA9Feeling(String a9Feeling) {
		this.a9Feeling = a9Feeling;
	}
	public String getA9Encumbrance() {
		return a9Encumbrance;
	}
	public void setA9Encumbrance(String a9Encumbrance) {
		this.a9Encumbrance = a9Encumbrance;
	}
	public String getA10() {
		return a10;
	}
	public void setA10(String a10) {
		this.a10 = a10;
	}
	public String getA10Feeling() {
		return a10Feeling;
	}
	public void setA10Feeling(String a10Feeling) {
		this.a10Feeling = a10Feeling;
	}
	public String getA10Encumbrance() {
		return a10Encumbrance;
	}
	public void setA10Encumbrance(String a10Encumbrance) {
		this.a10Encumbrance = a10Encumbrance;
	}
	public String getA11() {
		return a11;
	}
	public void setA11(String a11) {
		this.a11 = a11;
	}
	public String getA11Feeling() {
		return a11Feeling;
	}
	public void setA11Feeling(String a11Feeling) {
		this.a11Feeling = a11Feeling;
	}
	public String getA11Encumbrance() {
		return a11Encumbrance;
	}
	public void setA11Encumbrance(String a11Encumbrance) {
		this.a11Encumbrance = a11Encumbrance;
	}
	public String getA12() {
		return a12;
	}
	public void setA12(String a12) {
		this.a12 = a12;
	}
	public String getA12Feeling() {
		return a12Feeling;
	}
	public void setA12Feeling(String a12Feeling) {
		this.a12Feeling = a12Feeling;
	}
	public String getA12Encumbrance() {
		return a12Encumbrance;
	}
	public void setA12Encumbrance(String a12Encumbrance) {
		this.a12Encumbrance = a12Encumbrance;
	}
	public String getA13() {
		return a13;
	}
	public void setA13(String a13) {
		this.a13 = a13;
	}
	public String getA13Feeling() {
		return a13Feeling;
	}
	public void setA13Feeling(String a13Feeling) {
		this.a13Feeling = a13Feeling;
	}
	public String getA13Encumbrance() {
		return a13Encumbrance;
	}
	public void setA13Encumbrance(String a13Encumbrance) {
		this.a13Encumbrance = a13Encumbrance;
	}
	public String getA14() {
		return a14;
	}
	public void setA14(String a14) {
		this.a14 = a14;
	}
	public String getA14Feeling() {
		return a14Feeling;
	}
	public void setA14Feeling(String a14Feeling) {
		this.a14Feeling = a14Feeling;
	}
	public String getA14Encumbrance() {
		return a14Encumbrance;
	}
	public void setA14Encumbrance(String a14Encumbrance) {
		this.a14Encumbrance = a14Encumbrance;
	}
	public String getA15() {
		return a15;
	}
	public void setA15(String a15) {
		this.a15 = a15;
	}
	public String getA15Feeling() {
		return a15Feeling;
	}
	public void setA15Feeling(String a15Feeling) {
		this.a15Feeling = a15Feeling;
	}
	public String getA15Encumbrance() {
		return a15Encumbrance;
	}
	public void setA15Encumbrance(String a15Encumbrance) {
		this.a15Encumbrance = a15Encumbrance;
	}
	public String getA16() {
		return a16;
	}
	public void setA16(String a16) {
		this.a16 = a16;
	}
	public String getA16Feeling() {
		return a16Feeling;
	}
	public void setA16Feeling(String a16Feeling) {
		this.a16Feeling = a16Feeling;
	}
	public String getA16Encumbrance() {
		return a16Encumbrance;
	}
	public void setA16Encumbrance(String a16Encumbrance) {
		this.a16Encumbrance = a16Encumbrance;
	}
	public String getA17() {
		return a17;
	}
	public void setA17(String a17) {
		this.a17 = a17;
	}
	public String getA17Feeling() {
		return a17Feeling;
	}
	public void setA17Feeling(String a17Feeling) {
		this.a17Feeling = a17Feeling;
	}
	public String getA17Encumbrance() {
		return a17Encumbrance;
	}
	public void setA17Encumbrance(String a17Encumbrance) {
		this.a17Encumbrance = a17Encumbrance;
	}
	public String getA18() {
		return a18;
	}
	public void setA18(String a18) {
		this.a18 = a18;
	}
	public String getA18Feeling() {
		return a18Feeling;
	}
	public void setA18Feeling(String a18Feeling) {
		this.a18Feeling = a18Feeling;
	}
	public String getA18Encumbrance() {
		return a18Encumbrance;
	}
	public void setA18Encumbrance(String a18Encumbrance) {
		this.a18Encumbrance = a18Encumbrance;
	}
	public String getA19() {
		return a19;
	}
	public void setA19(String a19) {
		this.a19 = a19;
	}
	public String getA19Feeling() {
		return a19Feeling;
	}
	public void setA19Feeling(String a19Feeling) {
		this.a19Feeling = a19Feeling;
	}
	public String getA19Encumbrance() {
		return a19Encumbrance;
	}
	public void setA19Encumbrance(String a19Encumbrance) {
		this.a19Encumbrance = a19Encumbrance;
	}
	public String getA20() {
		return a20;
	}
	public void setA20(String a20) {
		this.a20 = a20;
	}
	public String getA20Feeling() {
		return a20Feeling;
	}
	public void setA20Feeling(String a20Feeling) {
		this.a20Feeling = a20Feeling;
	}
	public String getA20Encumbrance() {
		return a20Encumbrance;
	}
	public void setA20Encumbrance(String a20Encumbrance) {
		this.a20Encumbrance = a20Encumbrance;
	}
	public String getA21() {
		return a21;
	}
	public void setA21(String a21) {
		this.a21 = a21;
	}
	public String getA21Feeling() {
		return a21Feeling;
	}
	public void setA21Feeling(String a21Feeling) {
		this.a21Feeling = a21Feeling;
	}
	public String getA21Encumbrance() {
		return a21Encumbrance;
	}
	public void setA21Encumbrance(String a21Encumbrance) {
		this.a21Encumbrance = a21Encumbrance;
	}
	public String getA22() {
		return a22;
	}
	public void setA22(String a22) {
		this.a22 = a22;
	}
	public String getA22Feeling() {
		return a22Feeling;
	}
	public void setA22Feeling(String a22Feeling) {
		this.a22Feeling = a22Feeling;
	}
	public String getA22Encumbrance() {
		return a22Encumbrance;
	}
	public void setA22Encumbrance(String a22Encumbrance) {
		this.a22Encumbrance = a22Encumbrance;
	}
	public String getA23() {
		return a23;
	}
	public void setA23(String a23) {
		this.a23 = a23;
	}
	public String getA23Feeling() {
		return a23Feeling;
	}
	public void setA23Feeling(String a23Feeling) {
		this.a23Feeling = a23Feeling;
	}
	public String getA23Encumbrance() {
		return a23Encumbrance;
	}
	public void setA23Encumbrance(String a23Encumbrance) {
		this.a23Encumbrance = a23Encumbrance;
	}
	public String getA24() {
		return a24;
	}
	public void setA24(String a24) {
		this.a24 = a24;
	}
	public String getA24Feeling() {
		return a24Feeling;
	}
	public void setA24Feeling(String a24Feeling) {
		this.a24Feeling = a24Feeling;
	}
	public String getA24Encumbrance() {
		return a24Encumbrance;
	}
	public void setA24Encumbrance(String a24Encumbrance) {
		this.a24Encumbrance = a24Encumbrance;
	}
	public String getA25() {
		return a25;
	}
	public void setA25(String a25) {
		this.a25 = a25;
	}
	public String getA25Feeling() {
		return a25Feeling;
	}
	public void setA25Feeling(String a25Feeling) {
		this.a25Feeling = a25Feeling;
	}
	public String getA25Encumbrance() {
		return a25Encumbrance;
	}
	public void setA25Encumbrance(String a25Encumbrance) {
		this.a25Encumbrance = a25Encumbrance;
	}
	public String getA26() {
		return a26;
	}
	public void setA26(String a26) {
		this.a26 = a26;
	}
	public String getA26Feeling() {
		return a26Feeling;
	}
	public void setA26Feeling(String a26Feeling) {
		this.a26Feeling = a26Feeling;
	}
	public String getA26Encumbrance() {
		return a26Encumbrance;
	}
	public void setA26Encumbrance(String a26Encumbrance) {
		this.a26Encumbrance = a26Encumbrance;
	}
	public String getA27() {
		return a27;
	}
	public void setA27(String a27) {
		this.a27 = a27;
	}
	public String getA27Feeling() {
		return a27Feeling;
	}
	public void setA27Feeling(String a27Feeling) {
		this.a27Feeling = a27Feeling;
	}
	public String getA27Encumbrance() {
		return a27Encumbrance;
	}
	public void setA27Encumbrance(String a27Encumbrance) {
		this.a27Encumbrance = a27Encumbrance;
	}
	public String getA28() {
		return a28;
	}
	public void setA28(String a28) {
		this.a28 = a28;
	}
	public String getA28Feeling() {
		return a28Feeling;
	}
	public void setA28Feeling(String a28Feeling) {
		this.a28Feeling = a28Feeling;
	}
	public String getA28Encumbrance() {
		return a28Encumbrance;
	}
	public void setA28Encumbrance(String a28Encumbrance) {
		this.a28Encumbrance = a28Encumbrance;
	}
	public String getA29() {
		return a29;
	}
	public void setA29(String a29) {
		this.a29 = a29;
	}
	public String getA29Feeling() {
		return a29Feeling;
	}
	public void setA29Feeling(String a29eeling) {
		this.a29Feeling = a29eeling;
	}
	public String getA29Encumbrance() {
		return a29Encumbrance;
	}
	public void setA29Encumbrance(String a29Encumbrance) {
		this.a29Encumbrance = a29Encumbrance;
	}
	public String getA30() {
		return a30;
	}
	public void setA30(String a30) {
		this.a30 = a30;
	}
	public String getA30Feeling() {
		return a30Feeling;
	}
	public void setA30Feeling(String a30Feeling) {
		this.a30Feeling = a30Feeling;
	}
	public String getA30Encumbrance() {
		return a30Encumbrance;
	}
	public void setA30Encumbrance(String a30Encumbrance) {
		this.a30Encumbrance = a30Encumbrance;
	}
	public String getA31() {
		return a31;
	}
	public void setA31(String a31) {
		this.a31 = a31;
	}
	public String getA31Feeling() {
		return a31Feeling;
	}
	public void setA31Feeling(String a31Feeling) {
		this.a31Feeling = a31Feeling;
	}
	public String getA31Encumbrance() {
		return a31Encumbrance;
	}
	public void setA31Encumbrance(String a31Encumbrance) {
		this.a31Encumbrance = a31Encumbrance;
	}
	public String getA32() {
		return a32;
	}
	public void setA32(String a32) {
		this.a32 = a32;
	}
	public String getA32Feeling() {
		return a32Feeling;
	}
	public void setA32Feeling(String a32Feeling) {
		this.a32Feeling = a32Feeling;
	}
	public String getA32Encumbrance() {
		return a32Encumbrance;
	}
	public void setA32Encumbrance(String a32Encumbrance) {
		this.a32Encumbrance = a32Encumbrance;
	}
	public String getA33() {
		return a33;
	}
	public void setA33(String a33) {
		this.a33 = a33;
	}
	public String getA33Feeling() {
		return a33Feeling;
	}
	public void setA33Feeling(String a33Feeling) {
		this.a33Feeling = a33Feeling;
	}
	public String getA33Encumbrance() {
		return a33Encumbrance;
	}
	public void setA33Encumbrance(String a33Encumbrance) {
		this.a33Encumbrance = a33Encumbrance;
	}
	public String getA34() {
		return a34;
	}
	public void setA34(String a34) {
		this.a34 = a34;
	}
	public String getA34Feeling() {
		return a34Feeling;
	}
	public void setA34Feeling(String a34Feeling) {
		this.a34Feeling = a34Feeling;
	}
	public String getA34Encumbrance() {
		return a34Encumbrance;
	}
	public void setA34Encumbrance(String a34Encumbrance) {
		this.a34Encumbrance = a34Encumbrance;
	}
	public String getA35() {
		return a35;
	}
	public void setA35(String a35) {
		this.a35 = a35;
	}
	public String getA35Feeling() {
		return a35Feeling;
	}
	public void setA35Feeling(String a35Feeling) {
		this.a35Feeling = a35Feeling;
	}
	public String getA35Encumbrance() {
		return a35Encumbrance;
	}
	public void setA35Encumbrance(String a35Encumbrance) {
		this.a35Encumbrance = a35Encumbrance;
	}
	public String getA36() {
		return a36;
	}
	public void setA36(String a36) {
		this.a36 = a36;
	}
	public String getA36Feeling() {
		return a36Feeling;
	}
	public void setA36Feeling(String a36Feeling) {
		this.a36Feeling = a36Feeling;
	}
	public String getA36Encumbrance() {
		return a36Encumbrance;
	}
	public void setA36Encumbrance(String a36Encumbrance) {
		this.a36Encumbrance = a36Encumbrance;
	}
	public String getA37() {
		return a37;
	}
	public void setA37(String a37) {
		this.a37 = a37;
	}
	public String getA37Feeling() {
		return a37Feeling;
	}
	public void setA37Feeling(String a37Feeling) {
		this.a37Feeling = a37Feeling;
	}
	public String getA37Encumbrance() {
		return a37Encumbrance;
	}
	public void setA37Encumbrance(String a37Encumbrance) {
		this.a37Encumbrance = a37Encumbrance;
	}
	public String getA38() {
		return a38;
	}
	public void setA38(String a38) {
		this.a38 = a38;
	}
	public String getA38Feeling() {
		return a38Feeling;
	}
	public void setA38Feeling(String a38Feeling) {
		this.a38Feeling = a38Feeling;
	}
	public String getA38Encumbrance() {
		return a38Encumbrance;
	}
	public void setA38Encumbrance(String a38Encumbrance) {
		this.a38Encumbrance = a38Encumbrance;
	}
	public String getA39() {
		return a39;
	}
	public void setA39(String a39) {
		this.a39 = a39;
	}
	public String getA39Feeling() {
		return a39Feeling;
	}
	public void setA39Feeling(String a39Feeling) {
		this.a39Feeling = a39Feeling;
	}
	public String getA39Encumbrance() {
		return a39Encumbrance;
	}
	public void setA39Encumbrance(String a39Encumbrance) {
		this.a39Encumbrance = a39Encumbrance;
	}
	public String getA40() {
		return a40;
	}
	public void setA40(String a40) {
		this.a40 = a40;
	}
	public String getA40Feeling() {
		return a40Feeling;
	}
	public void setA40Feeling(String a40Feeling) {
		this.a40Feeling = a40Feeling;
	}
	public String getA40Encumbrance() {
		return a40Encumbrance;
	}
	public void setA40Encumbrance(String a40Encumbrance) {
		this.a40Encumbrance = a40Encumbrance;
	}
	public String getA41() {
		return a41;
	}
	public void setA41(String a41) {
		this.a41 = a41;
	}
	public String getA41Feeling() {
		return a41Feeling;
	}
	public void setA41Feeling(String a41Feeling) {
		this.a41Feeling = a41Feeling;
	}
	public String getA41Encumbrance() {
		return a41Encumbrance;
	}
	public void setA41Encumbrance(String a41Encumbrance) {
		this.a41Encumbrance = a41Encumbrance;
	}
	public String getA42() {
		return a42;
	}
	public void setA42(String a42) {
		this.a42 = a42;
	}
	public String getA42Feeling() {
		return a42Feeling;
	}
	public void setA42Feeling(String a42Feeling) {
		this.a42Feeling = a42Feeling;
	}
	public String getA42Encumbrance() {
		return a42Encumbrance;
	}
	public void setA42Encumbrance(String a42Encumbrance) {
		this.a42Encumbrance = a42Encumbrance;
	}
	public String getA43() {
		return a43;
	}
	public void setA43(String a43) {
		this.a43 = a43;
	}
	public String getA43Feeling() {
		return a43Feeling;
	}
	public void setA43Feeling(String a43Feeling) {
		this.a43Feeling = a43Feeling;
	}
	public String getA43Encumbrance() {
		return a43Encumbrance;
	}
	public void setA43Encumbrance(String a43Encumbrance) {
		this.a43Encumbrance = a43Encumbrance;
	}
	public String getA44() {
		return a44;
	}
	public void setA44(String a44) {
		this.a44 = a44;
	}
	public String getA44Feeling() {
		return a44Feeling;
	}
	public void setA44Feeling(String a44Feeling) {
		this.a44Feeling = a44Feeling;
	}
	public String getA44Encumbrance() {
		return a44Encumbrance;
	}
	public void setA44Encumbrance(String a44Encumbrance) {
		this.a44Encumbrance = a44Encumbrance;
	}
	public String getTotalYnScore() {
		return totalYnScore;
	}
	public void setTotalYnScore(String totalYnScore) {
		this.totalYnScore = totalYnScore;
	}
	public String getTotalFeelingScore() {
		return totalFeelingScore;
	}
	public void setTotalFeelingScore(String totalFeelingScore) {
		this.totalFeelingScore = totalFeelingScore;
	}
	public String getTotalEncumbranceScore() {
		return totalEncumbranceScore;
	}
	public void setTotalEncumbranceScore(String totalEncumbranceScore) {
		this.totalEncumbranceScore = totalEncumbranceScore;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
