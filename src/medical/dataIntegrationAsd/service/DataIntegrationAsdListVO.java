package medical.dataIntegrationAsd.service;

import medical.framework.vo.KoriginCommonVO;

public class DataIntegrationAsdListVO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1645879237008552881L;
	/**
	 * 
	 */
	
	
	private String targetId;
	private String targetDisId;
	private String targetOrgId;
	private String docClassDtl;
	private String docId;
	private String sex;
	private String protocol;
	private String performCnt;
	private String cxtDiag;
	private String cxtDetail;
	private String performNm;
	private String mriDate;
	
	//임상가평가
	private String cybocs;
	private String ybocs;
	private String srs01;
	private String exts1; //지능검사 PERFROM_MST 
	
	
	
	//심리/발달검사
	private String s1; //K-SADS-PL
	private String ata;
	private String stroop;
	private String cctt;
	private String wsct;
	private String cat;
	private String exitii;
	private String cpt3;
	private String tmt;
	private String ados1; //ADOS
	private String ados2; //ADOS-S
	private String ados3;
	private String pep; //PEP-R
	private String sms;
	private String cars;
	
	//설문지
	private String prdv1;
	private String kmchat;
	private String oldCbcl;
	private String cbcl2; //부모자녀평가 cbcl
	private String oldCbcl15;
	private String cbcl15;
	private String cpcl;
	private String lsd;
	private String ars;
	private String abc;
	private String sib;
	private String bpi;
	private String srs;
	private String scq;
	private String pc3q;
	private String kAsds;
	private String ssis;
	private String trauma;
	private String cmrsp;
	private String qpgsR3; //QPGS-RIII
	private String gsrs;
	private String kCshq;
	private String cdic; //CDI 아동용
	private String bdia; //BDI 성인용
	private String staitc;
	private String staisc;
	private String cc3qc;
	private String cc3qa;
	private String iat;
	private String kscale;
	private String rcmas;
	private String traumaa;
	private String bdi;
	private String staitp;
	private String staisp;
	private String mbri;
	private String pp3q;
	private String kPsi;
	private String wgs;
	
	private String analEnvMattBl;
	private String analEnvMatt;
	private String analGen;
	private String analSnp;
	private String kscalea;
	private String clinicalValuation;
	
	private String perinatalDevelopmentAbility;
	
	private String performCntMax;
	private String performCntMaxNm;
	private String disClassDtl;
	private String performCntNm;
	private String rndId;
	private String pocral;
	private String fileClassDtl;
	private String birthYm;
	
	private String ptYn;
	private String startAge;
	private String endAge;
	
	private int maxSeq;
	
	private String targetIds;
	
	private String execDate;
	
	//데이터 통합 분석 상세 FILE
	private String bloodFather;				//채혈(부)
	private String bloodMother;				//채혈(모)
	private String bloodChild;				//채혈(아동)
	private String urine;					//소변
	private String imaging;					//영상
	private String humanDerivedMaterialsF;	//인체유래물동의서(부)
	private String humanDerivedMaterialsM;	//인체유래물동의서(모)
	private String humanDerivedMaterialsC;	//인체유래물 동의서(아동)
	private String consentP;			  	//연구참여 동의서(보호자)
	private String consentC;				//연구참여 동의서(아동)
	private String ksads;					//K-SADS 결과보고서
	private String clinicalEvaluation;		//임상가평가
	private String clinicalEvaluation4wk;	//4주 간격 면담지
	private String psychTesting;			//심리검사
	private String questionnaire;			//설문지
	private String fmri;
	private String flair;
	private String t1;
	private String t2;
	private String amri;
	private String dti;
	private String asl;
	private String swi;
	private String etc;
	private String tarFilePath;
	
	private String remarks; //대상자 비고
	
	
	
	private String kcbcl;
	private String cbcl;
	private String dbds;
	private String staity;
	private String staisy;
	private String loicv;
	private String kbis11r;
	
	private String kaadhdsAdult;
	private String kpsi;
	
	private String interval4Interview;

	
	
	
	
	public String getKcbcl() {
		return kcbcl;
	}
	public void setKcbcl(String kcbcl) {
		this.kcbcl = kcbcl;
	}
	public String getCbcl() {
		return cbcl;
	}
	public void setCbcl(String cbcl) {
		this.cbcl = cbcl;
	}
	public String getDbds() {
		return dbds;
	}
	public void setDbds(String dbds) {
		this.dbds = dbds;
	}
	public String getStaisy() {
		return staisy;
	}
	public void setStaisy(String staisy) {
		this.staisy = staisy;
	}
	public String getLoicv() {
		return loicv;
	}
	public void setLoicv(String loicv) {
		this.loicv = loicv;
	}
	public String getKbis11r() {
		return kbis11r;
	}
	public void setKbis11r(String kbis11r) {
		this.kbis11r = kbis11r;
	}
	public String getKaadhdsAdult() {
		return kaadhdsAdult;
	}
	public void setKaadhdsAdult(String kaadhdsAdult) {
		this.kaadhdsAdult = kaadhdsAdult;
	}
	public String getKpsi() {
		return kpsi;
	}
	public void setKpsi(String kpsi) {
		this.kpsi = kpsi;
	}
	public String getInterval4Interview() {
		return interval4Interview;
	}
	public void setInterval4Interview(String interval4Interview) {
		this.interval4Interview = interval4Interview;
	}
	public String getPerinatalDevelopmentAbility() {
		return perinatalDevelopmentAbility;
	}
	public void setPerinatalDevelopmentAbility(String perinatalDevelopmentAbility) {
		this.perinatalDevelopmentAbility = perinatalDevelopmentAbility;
	}
	public String getBirthYm() {
		return birthYm;
	}
	public void setBirthYm(String birthYm) {
		this.birthYm = birthYm;
	}
	public String getTargetIds() {
		return targetIds;
	}
	public void setTargetIds(String targetIds) {
		this.targetIds = targetIds;
	}
	public int getMaxSeq() {
		return maxSeq;
	}
	public void setMaxSeq(int maxSeq) {
		this.maxSeq = maxSeq;
	}
	public String getPerformCntMaxNm() {
		return performCntMaxNm;
	}
	public void setPerformCntMaxNm(String performCntMaxNm) {
		this.performCntMaxNm = performCntMaxNm;
	}
	public String getPtYn() {
		return ptYn;
	}
	public void setPtYn(String ptYn) {
		this.ptYn = ptYn;
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
	public String getFileClassDtl() {
		return fileClassDtl;
	}
	public void setFileClassDtl(String fileClassDtl) {
		this.fileClassDtl = fileClassDtl;
	}
	public String getDisClassDtl() {
		return disClassDtl;
	}
	public void setDisClassDtl(String disClassDtl) {
		this.disClassDtl = disClassDtl;
	}
	public String getPerformCntNm() {
		return performCntNm;
	}
	public void setPerformCntNm(String performCntNm) {
		this.performCntNm = performCntNm;
	}
	public String getRndId() {
		return rndId;
	}
	public void setRndId(String rndId) {
		this.rndId = rndId;
	}
	public String getPocral() {
		return pocral;
	}
	public void setPocral(String pocral) {
		this.pocral = pocral;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
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
	public String getCxtDiag() {
		return cxtDiag;
	}
	public void setCxtDiag(String cxtDiag) {
		this.cxtDiag = cxtDiag;
	}
	public String getCxtDetail() {
		return cxtDetail;
	}
	public void setCxtDetail(String cxtDetail) {
		this.cxtDetail = cxtDetail;
	}
	public String getPerformNm() {
		return performNm;
	}
	public void setPerformNm(String performNm) {
		this.performNm = performNm;
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
	public String getArs() {
		return ars;
	}
	public void setArs(String ars) {
		this.ars = ars;
	}
	
	public String getTrauma() {
		return trauma;
	}
	public void setTrauma(String trauma) {
		this.trauma = trauma;
	}
	public String getCdic() {
		return cdic;
	}
	public void setCdic(String cdic) {
		this.cdic = cdic;
	}
	public String getKscale() {
		return kscale;
	}
	public void setKscale(String kscale) {
		this.kscale = kscale;
	}
	public String getRcmas() {
		return rcmas;
	}
	public void setRcmas(String rcmas) {
		this.rcmas = rcmas;
	}
	public String getStaitc() {
		return staitc;
	}
	public void setStaitc(String staitc) {
		this.staitc = staitc;
	}
	public String getStaisc() {
		return staisc;
	}
	public void setStaisc(String staisc) {
		this.staisc = staisc;
	}
	public String getStaitp() {
		return staitp;
	}
	public void setStaitp(String staitp) {
		this.staitp = staitp;
	}
	public String getStaisp() {
		return staisp;
	}
	public void setStaisp(String staisp) {
		this.staisp = staisp;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	public String getMbri() {
		return mbri;
	}
	public void setMbri(String mbri) {
		this.mbri = mbri;
	}
	public String getPerformCntMax() {
		return performCntMax;
	}
	public void setPerformCntMax(String performCntMax) {
		this.performCntMax = performCntMax;
	}
	public String getMriDate() {
		return mriDate;
	}
	public void setMriDate(String mriDate) {
		this.mriDate = mriDate;
	}
	public String getUrine() {
		return urine;
	}
	public void setUrine(String urine) {
		this.urine = urine;
	}
	public String getImaging() {
		return imaging;
	}
	public void setImaging(String imaging) {
		this.imaging = imaging;
	}
	public String getHumanDerivedMaterialsF() {
		return humanDerivedMaterialsF;
	}
	public void setHumanDerivedMaterialsF(String humanDerivedMaterialsF) {
		this.humanDerivedMaterialsF = humanDerivedMaterialsF;
	}
	public String getHumanDerivedMaterialsM() {
		return humanDerivedMaterialsM;
	}
	public void setHumanDerivedMaterialsM(String humanDerivedMaterialsM) {
		this.humanDerivedMaterialsM = humanDerivedMaterialsM;
	}
	public String getHumanDerivedMaterialsC() {
		return humanDerivedMaterialsC;
	}
	public void setHumanDerivedMaterialsC(String humanDerivedMaterialsC) {
		this.humanDerivedMaterialsC = humanDerivedMaterialsC;
	}
	public String getConsentP() {
		return consentP;
	}
	public void setConsentP(String consentP) {
		this.consentP = consentP;
	}
	public String getConsentC() {
		return consentC;
	}
	public void setConsentC(String consentC) {
		this.consentC = consentC;
	}
	public String getKsads() {
		return ksads;
	}
	public void setKsads(String ksads) {
		this.ksads = ksads;
	}
	public String getClinicalEvaluation() {
		return clinicalEvaluation;
	}
	public void setClinicalEvaluation(String clinicalEvaluation) {
		this.clinicalEvaluation = clinicalEvaluation;
	}
	public String getClinicalEvaluation4wk() {
		return clinicalEvaluation4wk;
	}
	public void setClinicalEvaluation4wk(String clinicalEvaluation4wk) {
		this.clinicalEvaluation4wk = clinicalEvaluation4wk;
	}
	public String getPsychTesting() {
		return psychTesting;
	}
	public void setPsychTesting(String psychTesting) {
		this.psychTesting = psychTesting;
	}
	public String getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(String questionnaire) {
		this.questionnaire = questionnaire;
	}
	public String getFmri() {
		return fmri;
	}
	public void setFmri(String fmri) {
		this.fmri = fmri;
	}
	public String getFlair() {
		return flair;
	}
	public void setFlair(String flair) {
		this.flair = flair;
	}
	public String getT1() {
		return t1;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT2() {
		return t2;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public String getAmri() {
		return amri;
	}
	public void setAmri(String amri) {
		this.amri = amri;
	}
	public String getDti() {
		return dti;
	}
	public void setDti(String dti) {
		this.dti = dti;
	}
	public String getAsl() {
		return asl;
	}
	public void setAsl(String asl) {
		this.asl = asl;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public String getExecDate() {
		return execDate;
	}
	public void setExecDate(String execDate) {
		this.execDate = execDate;
	}
	public String getTarFilePath() {
		return tarFilePath;
	}
	public void setTarFilePath(String tarFilePath) {
		this.tarFilePath = tarFilePath;
	}
	public String getBloodFather() {
		return bloodFather;
	}
	public void setBloodFather(String bloodFather) {
		this.bloodFather = bloodFather;
	}
	public String getBloodMother() {
		return bloodMother;
	}
	public void setBloodMother(String bloodMother) {
		this.bloodMother = bloodMother;
	}
	public String getBloodChild() {
		return bloodChild;
	}
	public void setBloodChild(String bloodChild) {
		this.bloodChild = bloodChild;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getTargetDisId() {
		return targetDisId;
	}
	public void setTargetDisId(String targetDisId) {
		this.targetDisId = targetDisId;
	}
	public String getTargetOrgId() {
		return targetOrgId;
	}
	public void setTargetOrgId(String targetOrgId) {
		this.targetOrgId = targetOrgId;
	}
	public String getAdos1() {
		return ados1;
	}
	public void setAdos1(String ados1) {
		this.ados1 = ados1;
	}
	public String getAdos2() {
		return ados2;
	}
	public void setAdos2(String ados2) {
		this.ados2 = ados2;
	}
	public String getAdos3() {
		return ados3;
	}
	public void setAdos3(String ados3) {
		this.ados3 = ados3;
	}
	public String getPep() {
		return pep;
	}
	public void setPep(String pep) {
		this.pep = pep;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public String getCars() {
		return cars;
	}
	public void setCars(String cars) {
		this.cars = cars;
	}
	public String getKmchat() {
		return kmchat;
	}
	public void setKmchat(String kmchat) {
		this.kmchat = kmchat;
	}
	public String getOldCbcl() {
		return oldCbcl;
	}
	public void setOldCbcl(String oldCbcl) {
		this.oldCbcl = oldCbcl;
	}
	public String getCbcl2() {
		return cbcl2;
	}
	public void setCbcl2(String cbcl2) {
		this.cbcl2 = cbcl2;
	}
	public String getOldCbcl15() {
		return oldCbcl15;
	}
	public void setOldCbcl15(String oldCbcl15) {
		this.oldCbcl15 = oldCbcl15;
	}
	public String getCbcl15() {
		return cbcl15;
	}
	public void setCbcl15(String cbcl15) {
		this.cbcl15 = cbcl15;
	}
	public String getLsd() {
		return lsd;
	}
	public void setLsd(String lsd) {
		this.lsd = lsd;
	}
	public String getAbc() {
		return abc;
	}
	public void setAbc(String abc) {
		this.abc = abc;
	}
	public String getSib() {
		return sib;
	}
	public void setSib(String sib) {
		this.sib = sib;
	}
	public String getBpi() {
		return bpi;
	}
	public void setBpi(String bpi) {
		this.bpi = bpi;
	}
	public String getSrs() {
		return srs;
	}
	public void setSrs(String srs) {
		this.srs = srs;
	}
	public String getScq() {
		return scq;
	}
	public void setScq(String scq) {
		this.scq = scq;
	}
	public String getPc3q() {
		return pc3q;
	}
	public void setPc3q(String pc3q) {
		this.pc3q = pc3q;
	}
	public String getkAsds() {
		return kAsds;
	}
	public void setkAsds(String kAsds) {
		this.kAsds = kAsds;
	}
	public String getSsis() {
		return ssis;
	}
	public void setSsis(String ssis) {
		this.ssis = ssis;
	}
	public String getPp3q() {
		return pp3q;
	}
	public void setPp3q(String pp3q) {
		this.pp3q = pp3q;
	}

	public String getAnalEnvMatt() {
		return analEnvMatt;
	}
	public void setAnalEnvMatt(String analEnvMatt) {
		this.analEnvMatt = analEnvMatt;
	}
	public String getAnalSnp() {
		return analSnp;
	}
	public void setAnalSnp(String analSnp) {
		this.analSnp = analSnp;
	}
	public String getBdia() {
		return bdia;
	}
	public void setBdia(String bdia) {
		this.bdia = bdia;
	}
	public String getCc3qc() {
		return cc3qc;
	}
	public void setCc3qc(String cc3qc) {
		this.cc3qc = cc3qc;
	}
	public String getCc3qa() {
		return cc3qa;
	}
	public void setCc3qa(String cc3qa) {
		this.cc3qa = cc3qa;
	}
	public String getTraumaa() {
		return traumaa;
	}
	public void setTraumaa(String traumaa) {
		this.traumaa = traumaa;
	}
	public String getBdi() {
		return bdi;
	}
	public void setBdi(String bdi) {
		this.bdi = bdi;
	}
	public String getkPsi() {
		return kPsi;
	}
	public void setkPsi(String kPsi) {
		this.kPsi = kPsi;
	}
	public String getCmrsp() {
		return cmrsp;
	}
	public void setCmrsp(String cmrsp) {
		this.cmrsp = cmrsp;
	}
	public String getQpgsR3() {
		return qpgsR3;
	}
	public void setQpgsR3(String qpgsR3) {
		this.qpgsR3 = qpgsR3;
	}
	public String getGsrs() {
		return gsrs;
	}
	public void setGsrs(String gsrs) {
		this.gsrs = gsrs;
	}
	public String getkCshq() {
		return kCshq;
	}
	public void setkCshq(String kCshq) {
		this.kCshq = kCshq;
	}
	public String getKscalea() {
		return kscalea;
	}
	public void setKscalea(String kscalea) {
		this.kscalea = kscalea;
	}
	public String getClinicalValuation() {
		return clinicalValuation;
	}
	public void setClinicalValuation(String clinicalValuation) {
		this.clinicalValuation = clinicalValuation;
	}
	public String getCpcl() {
		return cpcl;
	}
	public void setCpcl(String cpcl) {
		this.cpcl = cpcl;
	}
	public String getWgs() {
		return wgs;
	}
	public void setWgs(String wgs) {
		this.wgs = wgs;
	}
	public String getAnalEnvMattBl() {
		return analEnvMattBl;
	}
	public void setAnalEnvMattBl(String analEnvMattBl) {
		this.analEnvMattBl = analEnvMattBl;
	}
	public String getPrdv1() {
		return prdv1;
	}
	public void setPrdv1(String prdv1) {
		this.prdv1 = prdv1;
	}

	public String getAnalGen() {
		return analGen;
	}
	public void setAnalGen(String analGen) {
		this.analGen = analGen;
	}
	public String getExts1() {
		return exts1;
	}
	public void setExts1(String exts1) {
		this.exts1 = exts1;
	}
	public String getSrs01() {
		return srs01;
	}
	public void setSrs01(String srs01) {
		this.srs01 = srs01;
	}
	public String getYbocs() {
		return ybocs;
	}
	public void setYbocs(String ybocs) {
		this.ybocs = ybocs;
	}
	public String getCybocs() {
		return cybocs;
	}
	public void setCybocs(String cybocs) {
		this.cybocs = cybocs;
	}
	public String getSwi() {
		return swi;
	}
	public void setSwi(String swi) {
		this.swi = swi;
	}
	public String getStaity() {
		return staity;
	}
	public void setStaity(String staity) {
		this.staity = staity;
	}
	public String getDocClassDtl() {
		return docClassDtl;
	}
	public void setDocClassDtl(String docClassDtl) {
		this.docClassDtl = docClassDtl;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}

}
