package medical.main.service;

import medical.framework.vo.KoriginCommonVO;

public class DashboardVO extends KoriginCommonVO {
	private static final long serialVersionUID = 1L;
	
	private String yyyy;
	private String sex;
	private String protocol;
	private String performCnt;
	private String performNm;
	private String status;
	private String classCdDtlNm;
	private String classCdDtl;
	
	//막대그래프
	private String pcount;
	private String yyyyTotal;
	
	//라인그래프
	private String ptc01;
	private String ptc02;
	private String ptc03;
	
	//수집현황 표
	private String s3pc1;
	private String s2pc1;
	private String s4pc2;
	private String s3pc2;
	private String s2pc2;
	private String s4pc3;
	private String s3pc3;
	private String s2pc3;
	private String s4pc4;
	private String s3pc4;
	private String s2pc4;
	private String s4pc5;
	private String s3pc5;
	private String s2pc5;
	private String s1pc5;
	
	private String spcList;
	
	//막대&라인차트
	private int yValue1;
	private int yValue2;
	
	//라인차트
	private int yValue3;
	private int yValue4;
	
	public int getyValue1() {
		return yValue1;
	}
	public void setyValue1(int yValue1) {
		this.yValue1 = yValue1;
	}
	public int getyValue2() {
		return yValue2;
	}
	public void setyValue2(int yValue2) {
		this.yValue2 = yValue2;
	}
	public int getyValue3() {
		return yValue3;
	}
	public void setyValue3(int yValue3) {
		this.yValue3 = yValue3;
	}
	public int getyValue4() {
		return yValue4;
	}
	public void setyValue4(int yValue4) {
		this.yValue4 = yValue4;
	}
	public String getSpcList() {
		return spcList;
	}
	public void setSpcList(String spcList) {
		this.spcList = spcList;
	}
	public String getPerformNm() {
		return performNm;
	}
	public void setPerformNm(String performNm) {
		this.performNm = performNm;
	}
	public String getYyyyTotal() {
		return yyyyTotal;
	}
	public void setYyyyTotal(String yyyyTotal) {
		this.yyyyTotal = yyyyTotal;
	}
	public String getClassCdDtl() {
		return classCdDtl;
	}
	public void setClassCdDtl(String classCdDtl) {
		this.classCdDtl = classCdDtl;
	}
	public String getPcount() {
		return pcount;
	}
	public void setPcount(String pcount) {
		this.pcount = pcount;
	}
	
	public String getPtc01() {
		return ptc01;
	}
	public void setPtc01(String ptc01) {
		this.ptc01 = ptc01;
	}
	public String getPtc02() {
		return ptc02;
	}
	public void setPtc02(String ptc02) {
		this.ptc02 = ptc02;
	}
	public String getPtc03() {
		return ptc03;
	}
	public void setPtc03(String ptc03) {
		this.ptc03 = ptc03;
	}
	public String getYyyy() {
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
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
	public String getPerformCnt() {
		return performCnt;
	}
	public void setPerformCnt(String performCnt) {
		this.performCnt = performCnt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClassCdDtlNm() {
		return classCdDtlNm;
	}
	public void setClassCdDtlNm(String classCdDtlNm) {
		this.classCdDtlNm = classCdDtlNm;
	}
	public String getS3pc1() {
		return s3pc1;
	}
	public void setS3pc1(String s3pc1) {
		this.s3pc1 = s3pc1;
	}
	public String getS2pc1() {
		return s2pc1;
	}
	public void setS2pc1(String s2pc1) {
		this.s2pc1 = s2pc1;
	}
	public String getS4pc2() {
		return s4pc2;
	}
	public void setS4pc2(String s4pc2) {
		this.s4pc2 = s4pc2;
	}
	public String getS3pc2() {
		return s3pc2;
	}
	public void setS3pc2(String s3pc2) {
		this.s3pc2 = s3pc2;
	}
	public String getS2pc2() {
		return s2pc2;
	}
	public void setS2pc2(String s2pc2) {
		this.s2pc2 = s2pc2;
	}
	public String getS4pc3() {
		return s4pc3;
	}
	public void setS4pc3(String s4pc3) {
		this.s4pc3 = s4pc3;
	}
	public String getS3pc3() {
		return s3pc3;
	}
	public void setS3pc3(String s3pc3) {
		this.s3pc3 = s3pc3;
	}
	public String getS2pc3() {
		return s2pc3;
	}
	public void setS2pc3(String s2pc3) {
		this.s2pc3 = s2pc3;
	}
	public String getS4pc4() {
		return s4pc4;
	}
	public void setS4pc4(String s4pc4) {
		this.s4pc4 = s4pc4;
	}
	public String getS3pc4() {
		return s3pc4;
	}
	public void setS3pc4(String s3pc4) {
		this.s3pc4 = s3pc4;
	}
	public String getS2pc4() {
		return s2pc4;
	}
	public void setS2pc4(String s2pc4) {
		this.s2pc4 = s2pc4;
	}
	public String getS4pc5() {
		return s4pc5;
	}
	public void setS4pc5(String s4pc5) {
		this.s4pc5 = s4pc5;
	}
	public String getS3pc5() {
		return s3pc5;
	}
	public void setS3pc5(String s3pc5) {
		this.s3pc5 = s3pc5;
	}
	public String getS2pc5() {
		return s2pc5;
	}
	public void setS2pc5(String s2pc5) {
		this.s2pc5 = s2pc5;
	}
	public String getS1pc5() {
		return s1pc5;
	}
	public void setS1pc5(String s1pc5) {
		this.s1pc5 = s1pc5;
	}
//	public String[] getSpcList() {
//		return spcList;
//	}
//	public void setSpcList(String[] spcList) {
//		this.spcList = spcList;
//	}

	
}