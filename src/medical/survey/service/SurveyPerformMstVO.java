package medical.survey.service;

import medical.framework.vo.KoriginCommonVO;

public class SurveyPerformMstVO extends KoriginCommonVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8193900406083502005L;
	private String targetId;
	private String performCnt;
	private String performNm;
	private String disClassDtl;
	private String execDate;
	private String rndId;
	private String cvCgiS;		//임상가평가 CGI_S
	private String cvCgiI;		//임상가평가 CGI_I
	private String cvCGas;		//임상가평가 C_GAS
	private String iv4CgiS;		//4주 간격 면담지 CGI_S
 	private String iv4CgiI;		//4주 간격 면담지 CGI_I
	private String iv4CGas;		//4주 간격 면담지 C_CAS
	private String pillCntKind;		//pill count 종류
	private String pillCntUsed;		//pill count 처방한 수량
	private String pillCntTotal;	//pill count 용량
	private String pillCntEaten;  	//pill count 복용수량
	private String clinicalValuation;
	private String fourIntervalInterview;
	private String arsDate;
	private String bdiDate;           
	private String cbclDate;          
	private String cdiDate;           
	private String cmrsPDate;         
	private String dbdsDate;          
	private String iatDate;           
	private String kaadhdsAdultDate;  
	private String kbis11rDate;       
	private String kCbclDate;         
	private String kPsiDate;          
	private String kScaleDate;        
	private String loiCvDate;         
	private String mbriDate;          
	private String rcmasDate;         
	private String staitcDate;        
	private String staiscDate;        
	private String staitpDate;        
	private String staispDate;        
	private String traumaDate;        
	private String srs4intervalDate;  
	private String srsClinicalDate;   
	private String ybocaDate;         
	private String ybocsDate;         
	private String ygtss4intervalDate;
	private String ygtssClinicalDate; 
	private String cybocs4intervalDate;
	private String cybocsClinicalDate;
	
	public String getClinicalValuation() {
		return clinicalValuation;
	}
	public void setClinicalValuation(String clinicalValuation) {
		this.clinicalValuation = clinicalValuation;
	}
	public String getFourIntervalInterview() {
		return fourIntervalInterview;
	}
	public void setFourIntervalInterview(String fourIntervalInterview) {
		this.fourIntervalInterview = fourIntervalInterview;
	}
	public String getArsDate() {
		return arsDate;
	}
	public void setArsDate(String arsDate) {
		this.arsDate = arsDate;
	}
	public String getBdiDate() {
		return bdiDate;
	}
	public void setBdiDate(String bdiDate) {
		this.bdiDate = bdiDate;
	}
	public String getCbclDate() {
		return cbclDate;
	}
	public void setCbclDate(String cbclDate) {
		this.cbclDate = cbclDate;
	}
	public String getCdiDate() {
		return cdiDate;
	}
	public void setCdiDate(String cdiDate) {
		this.cdiDate = cdiDate;
	}
	public String getCmrsPDate() {
		return cmrsPDate;
	}
	public void setCmrsPDate(String cmrsPDate) {
		this.cmrsPDate = cmrsPDate;
	}
	public String getDbdsDate() {
		return dbdsDate;
	}
	public void setDbdsDate(String dbdsDate) {
		this.dbdsDate = dbdsDate;
	}
	public String getIatDate() {
		return iatDate;
	}
	public void setIatDate(String iatDate) {
		this.iatDate = iatDate;
	}
	public String getKaadhdsAdultDate() {
		return kaadhdsAdultDate;
	}
	public void setKaadhdsAdultDate(String kaadhdsAdultDate) {
		this.kaadhdsAdultDate = kaadhdsAdultDate;
	}
	public String getKbis11rDate() {
		return kbis11rDate;
	}
	public void setKbis11rDate(String kbis11rDate) {
		this.kbis11rDate = kbis11rDate;
	}
	public String getkCbclDate() {
		return kCbclDate;
	}
	public void setkCbclDate(String kCbclDate) {
		this.kCbclDate = kCbclDate;
	}
	public String getkPsiDate() {
		return kPsiDate;
	}
	public void setkPsiDate(String kPsiDate) {
		this.kPsiDate = kPsiDate;
	}
	public String getkScaleDate() {
		return kScaleDate;
	}
	public void setkScaleDate(String kScaleDate) {
		this.kScaleDate = kScaleDate;
	}
	public String getLoiCvDate() {
		return loiCvDate;
	}
	public void setLoiCvDate(String loiCvDate) {
		this.loiCvDate = loiCvDate;
	}
	public String getMbriDate() {
		return mbriDate;
	}
	public void setMbriDate(String mbriDate) {
		this.mbriDate = mbriDate;
	}
	public String getRcmasDate() {
		return rcmasDate;
	}
	public void setRcmasDate(String rcmasDate) {
		this.rcmasDate = rcmasDate;
	}
	public String getStaitcDate() {
		return staitcDate;
	}
	public void setStaitcDate(String staitcDate) {
		this.staitcDate = staitcDate;
	}
	public String getStaiscDate() {
		return staiscDate;
	}
	public void setStaiscDate(String staiscDate) {
		this.staiscDate = staiscDate;
	}
	public String getStaitpDate() {
		return staitpDate;
	}
	public void setStaitpDate(String staitpDate) {
		this.staitpDate = staitpDate;
	}
	public String getStaispDate() {
		return staispDate;
	}
	public void setStaispDate(String staispDate) {
		this.staispDate = staispDate;
	}
	public String getTraumaDate() {
		return traumaDate;
	}
	public void setTraumaDate(String traumaDate) {
		this.traumaDate = traumaDate;
	}
	public String getSrs4intervalDate() {
		return srs4intervalDate;
	}
	public void setSrs4intervalDate(String srs4intervalDate) {
		this.srs4intervalDate = srs4intervalDate;
	}
	public String getSrsClinicalDate() {
		return srsClinicalDate;
	}
	public void setSrsClinicalDate(String srsClinicalDate) {
		this.srsClinicalDate = srsClinicalDate;
	}
	public String getYbocaDate() {
		return ybocaDate;
	}
	public void setYbocaDate(String ybocaDate) {
		this.ybocaDate = ybocaDate;
	}
	public String getYbocsDate() {
		return ybocsDate;
	}
	public void setYbocsDate(String ybocsDate) {
		this.ybocsDate = ybocsDate;
	}
	public String getYgtss4intervalDate() {
		return ygtss4intervalDate;
	}
	public void setYgtss4intervalDate(String ygtss4intervalDate) {
		this.ygtss4intervalDate = ygtss4intervalDate;
	}
	public String getYgtssClinicalDate() {
		return ygtssClinicalDate;
	}
	public void setYgtssClinicalDate(String ygtssClinicalDate) {
		this.ygtssClinicalDate = ygtssClinicalDate;
	}
	public String getCybocs4intervalDate() {
		return cybocs4intervalDate;
	}
	public void setCybocs4intervalDate(String cybocs4intervalDate) {
		this.cybocs4intervalDate = cybocs4intervalDate;
	}
	public String getCybocsClinicalDate() {
		return cybocsClinicalDate;
	}
	public void setCybocsClinicalDate(String cybocsClinicalDate) {
		this.cybocsClinicalDate = cybocsClinicalDate;
	}
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getPerformCnt() {
		return performCnt;
	}
	public void setPerformCnt(String performCnt) {
		this.performCnt = performCnt;
	}
	public String getPerformNm() {
		return performNm;
	}
	public void setPerformNm(String performNm) {
		this.performNm = performNm;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public String getRndId() {
		return rndId;
	}
	public void setRndId(String rndId) {
		this.rndId = rndId;
	}
	public String getCvCgiS() {
		return cvCgiS;
	}
	public void setCvCgiS(String cvCgiS) {
		this.cvCgiS = cvCgiS;
	}
	public String getCvCgiI() {
		return cvCgiI;
	}
	public void setCvCgiI(String cvCgiI) {
		this.cvCgiI = cvCgiI;
	}
	public String getCvCGas() {
		return cvCGas;
	}
	public void setCvCGas(String cvCGas) {
		this.cvCGas = cvCGas;
	}
	public String getIv4CgiS() {
		return iv4CgiS;
	}
	public void setIv4CgiS(String iv4CgiS) {
		this.iv4CgiS = iv4CgiS;
	}
	public String getIv4CgiI() {
		return iv4CgiI;
	}
	public void setIv4CgiI(String iv4CgiI) {
		this.iv4CgiI = iv4CgiI;
	}
	public String getIv4CGas() {
		return iv4CGas;
	}
	public void setIv4CGas(String iv4cGas) {
		iv4CGas = iv4cGas;
	}
	public String getPillCntKind() {
		return pillCntKind;
	}
	public void setPillCntKind(String pillCntKind) {
		this.pillCntKind = pillCntKind;
	}
	public String getPillCntUsed() {
		return pillCntUsed;
	}
	public void setPillCntUsed(String pillCntUsed) {
		this.pillCntUsed = pillCntUsed;
	}
	public String getPillCntTotal() {
		return pillCntTotal;
	}
	public void setPillCntTotal(String pillCntTotal) {
		this.pillCntTotal = pillCntTotal;
	}
	public String getPillCntEaten() {
		return pillCntEaten;
	}
	public void setPillCntEaten(String pillCntEaten) {
		this.pillCntEaten = pillCntEaten;
	}
}
