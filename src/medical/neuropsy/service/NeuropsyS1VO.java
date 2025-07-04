package medical.neuropsy.service;

import medical.framework.vo.KoriginCommonVO;

public class NeuropsyS1VO extends KoriginCommonVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4024427367340832458L;
	
	private int rownum;
	private	String targetId;
	private String targetDisId;
	private String rndId;
	private String disClassDtl;
	private String sex;
	private String birthYm;
	private String protocol;
	private	String performCnt;
	private	String performCntNm;
	private String age;
//	private String k-sads 실시일
	private	String	ticSubtype;
	private	String	s1ExecDate;
	private	String	fsiq;
	private	String	kediwaisRef; //KEDI-WISC
	private	String	kediwaisVocaOs;
	private	String	kediwaisArithOs;
	private	String	kediwaisOrderOs;
	private	String	kediwaisPieceOs;
	private	String	kediwaisVocaEs;
	private	String	kediwaisArithEs;
	private	String	kediwaisOrderEs;
	private	String	kediwaisPieceEs;
	private	String	kwiscivCos;
	private	String	kwiscivVos;
	private	String	kwiscivUos;
	private	String	kwiscivPos;
	private	String	kwiscivCpos;
	private	String	kwiscivMos;
	private	String	kwiscivNos;
	private	String	kwiscivScos;
	private	String	kwiscivSos;
	private	String	kwiscivStos;
	private	String	kwiscivCes;
	private	String	kwiscivVes;
	private	String	kwiscivUes;
	private	String	kwiscivPes;
	private	String	kwiscivCpes;
	private	String	kwiscivMes;
	private	String	kwiscivNes;
	private	String	kwiscivSces;
	private	String	kwiscivSes;
	private	String	kwiscivStes;
	private	String	kwiscivSios;
	private	String	kwiscivVcos;
	private	String	kwiscivInos;
	private	String	kwiscivBdos;
	private	String	kwiscivMros;
	private	String	kwiscivVpos;
	private	String	kwiscivDsos;
	private	String	kwiscivAros;
	private	String	kwiscivSsos;
	private	String	kwiscivCdos;
	private	String	kwiscivSies;
	private	String	kwiscivVces;
	private	String	kwiscivInes;
	private	String	kwiscivBdes;
	private	String	kwiscivMres;
	private	String	kwiscivVpes;
	private	String	kwiscivDses;
	private	String	kwiscivAres;
	private	String	kwiscivSses;
	private	String	kwiscivCdes;
	
	//NEW K-WISC-IV 환산점수,지표점수,백분위,95%신뢰구간,지적분류(수준) 추가컬럼
	private String kwiscivEsadlu;					  
	private String kwiscivEsadpr;					  
	private String kwiscivEsadwr;					  
	private String kwiscivEsadps;           
	private String kwiscivEsadalliq;    		
	                         
	                         
	private String kwiscivIdxslu;						
	private String kwiscivIdxspr;						
	private String kwiscivIdxswr;						
	private String kwiscivIdxsps;						
	private String kwiscivIdxsalliq;				  
	                          
	private String kwiscivPercntlu;				  
	private String kwiscivPercntpr;				  
	private String kwiscivPercntwr;				  
	private String kwiscivPercntps;				  
	private String kwiscivPercntalliq;			
	                        
	                        
	private String kwiscivConfitvllu;			
	private String kwiscivConfitvlpr;			
	private String kwiscivConfitvlwr;			
	private String kwiscivConfitvlps;			
	private String kwiscivConfitvlalliq;	  
	                       
	private String kwiscivQdlu;						  
	private String kwiscivQdpr;						  
	private String kwiscivQdwr;						  
	private String kwiscivQdps;						  
	private String kwiscivQdalliq;			
	
	//NEW K-WAIS-IV 환산점수,지표점수,백분위,95%신뢰구간 추가컬럼

	private String kwisciv2Esadlu;					  
	private String kwisciv2Esadpr;					  
	private String kwisciv2Esadwr;					  
	private String kwisciv2Esadps;           
	private String kwisciv2Esadalliq;   
	
	private String kwisciv2Idxslu;					
	private String kwisciv2Idxspr;					
	private String kwisciv2Idxswr;					
	private String kwisciv2Idxsps;					
	private String kwisciv2Idxsalliq;			  
	                        
	                        
	private String kwisciv2Percntlu;				
	private String kwisciv2Percntpr;				
	private String kwisciv2Percntwr;				
	private String kwisciv2Percntps;				
	private String kwisciv2Percntalliq;		  
	                          
	                          
	private String kwisciv2Confitvllu;		  
	private String kwisciv2Confitvlpr;		  
	private String kwisciv2Confitvlwr;		  
	private String kwisciv2Confitvlps;		  
	private String kwisciv2Confitvlalliq;  
	

	private	String	ksadsBlues;
	private	String	ksadsAnger;
	private	String	ksadsLossm;
	private	String	ksadsDeath;
	private	String	ksadsSuicide;
	private	String	ksadsSuiSeverity;
	private	String	ksadsSuiCriticality;
	private	String	ksadsSelfharm;
	private	String	ksadsUplift;
	private	String	ksadsDecSleep;
	private	String	ksadsGoalActivity;
	private	String	ksadsGallop;
	private	String	ksadsHallucination;
	private	String	ksadsDelusion;
	private	String	ksadsPanic;
	private	String	ksadsSeparationFear;
	private	String	ksadsAttachFear;
	private	String	ksadsRejectSchool;
	private	String	ksadsSleepFear;
	private	String	ksadsAloneFear;
	private	String	ksadsAtrophy;
	private	String	ksadsSituationFear;
	private	String	ksadsPain;
	private	String	ksadsAvoid;
	private	String	ksadsFutureWorry;
	private	String	ksadsBodyComplain;
	private	String	ksadsSelfConsious;
	private	String	ksadsTension;
	private	String	ksadsComplusiveAct;
	private	String	ksadsComplusiveThink;
	private	String	ksadsPeeNight;
	private	String	ksadsPeeDay;
	private	String	ksadsPeeTotal;
	private	String	ksadsShitNight;
	private	String	ksadsShitDay;
	private	String	ksadsShitTotal;
	private	String	ksadsFatFear;
	private	String	ksadsLowWeight;
	private	String	ksadsWeightLoss;
	private	String	ksadsVoracity;
	private	String	ksadsAdhdCf;
	private	String	ksadsAdhdEd;
	private	String	ksadsAdhdSf;
	private	String	ksadsAdhdImpulsivity;
	private	String	ksadsOddAngry;
	private	String	ksadsOddAa;
	private	String	ksadsOddNotrules;
	private	String	ksadsCdLie;
	private	String	ksadsCdTruancy;
	private	String	ksadsCdFight;
	private	String	ksadsCdTorment;
	private	String	ksadsCdThievery;
	private	String	ksadsExerciseTic;
	private	String	ksadsExerciseVoice;
	private	String	gas;
	private	String	adhdrq1Mistake;
	private	String	adhdrq2Notlisten;
	private	String	adhdrq3FollowDiff;
	private	String	adhdrq4ArrangeDiff;
	private	String	adhdrq5AssignAvoid;
	private	String	adhdrq6LostItem;
	private	String	adhdrq7Forgetfulness;
	private	String	adhdrq8Unrest;
	private	String	adhdrq9Overrun;
	private	String	adhdrq10EndlessAct;
	private	String	adhdrq11SilentDiff;
	private	String	adhdrq12SuddenAns;
	private	String	adhdrq13WaitDiff;
	private	String	adhdrq14Interrupt;
	private	String	adhdrq15Fickle;
	private	String	adhdrq16Chatter;
	private	String	adhdrq17DangerAct;
	private	String	diagnosis;
	private	String	diagnosisEtc;
	private	String	ticAppendix;
	private	String	sactTic1Ce;
	private	String	sactTic1Msp;
	private	String	sactTic2Ce;
	private	String	sactTic2Msp;
	private	String	sactTic3Ce;
	private	String	sactTic3Msp;
	private	String	sactTic4Ce;
	private	String	sactTic4Msp;
	private	String	sactTic5Ce;
	private	String	sactTic5Msp;
	private	String	sactTic6Ce;
	private	String	sactTic6Msp;
	private	String	sactTic7Ce;
	private	String	sactTic7Msp;
	private	String	sactTic8Ce;
	private	String	sactTic8Msp;
	private	String	cactTic1Ce;
	private	String	cactTic1Msp;
	private	String	cactTic2Ce;
	private	String	cactTic2Msp;
	private	String	cactTic3Ce;
	private	String	cactTic3Msp;
	private	String	cactTic4Ce;
	private	String	cactTic4Msp;
	private	String	cactTic5Ce;
	private	String	cactTic5Msp;
	private	String	svoiceTic1Ce;
	private	String	svoiceTic1Msp;
	private	String	svoiceTic2Ce;
	private	String	svoiceTic2Msp;
	private	String	svoiceTic3Ce;
	private	String	svoiceTic3Msp;
	private	String	cvoiceTic1Ce;
	private	String	cvoiceTic1Msp;
	private	String	cvoiceTic2Ce;
	private	String	cvoiceTic2Msp;
	private	String	cvoiceTic3Ce;
	private	String	cvoiceTic3Msp;
	private	String	cvoiceTic4Ce;
	private	String	cvoiceTic4Msp;
	private	String	cvoiceTic5Ce;
	private	String	cvoiceTic5Msp;
	private	String	cvoiceTic6aCe;
	private	String	cvoiceTic6aMsp;
	private	String	cvoiceTic6bCe;
	private	String	cvoiceTic6bMsp;
	private	String	cvoiceTic6cCe;
	private	String	cvoiceTic6cMsp;
	private	String	tourette7aCe;
	private	String	tourette7aMsp;
	private	String	tourette7bCe;
	private	String	tourette7bMsp;
	private	String	chronicTic8aCe;
	private	String	chronicTic8aMsp;
	private	String	chronicTic8bCe;
	private	String	chronicTic8bMsp;
	private	String	dailyTic9aCe;
	private	String	dailyTic9aMsp;
	private	String	dailyTic9bCe;
	private	String	dailyTic9bMsp;
	private	String	remarks;
	private String performExecDate;
	
	private String enrollAge;
	//뇌원천 ASD T_S1_IKLEITER
	private String exctAllIntell;
	private String exctShortIntell;
	private String exctFluidInfer;
	private String exctBasicVisual;
	
	private String icidAllIntell;
	private String icidShortIntell;
	private String icidFluidInfer;
	private String icidBasicVisual;
	
	private String vifsForeBack;
	private String vifsShapeComp;
	private String vifsMatch;
	private String vifsOrderInfer;
	private String vifsPattFind;
	private String vifsDrawInfer;
	private String vifsCategoriz;
	
	private String viexcForeBack;
	private String viexcShapeComp;
	private String viexcMatch;
	private String viexcOrderInfer;
	private String viexcPattFind;
	private String viexcDrawInfer;
	private String viexcCategoriz;
	private String cexcMemorySelect;
	private String cexcRecogMemory;
	private String ccompMemorySelect;
	private String ccompRecogMemory;
	private String scPairAsso;
	private String scImmedRecog;
	private String scImmedRemember;
	private String scSustainAtt;
	private String scDelayRecog;
	private String excPairAsso;
	private String excImmedRecog;
	private String excImmedRemember;
	private String excSustainAtt;
	private String excDelayRecog;
	private String pRsCompsc;
	private String pEcCompsc;
	private String scAttention;
	private String scActivLevel;
	private String scImpuls;
	private String scAdaptability;
	private String scMoodConfid;
	private String scFeelEmo;
	private String scSociability;
	private String scControl;
	private String excAttention;
	private String excActivLevel;
	private String excImpuls;
	private String excAdaptability;
	private String excMoodConfid;
	private String excFeelEmo;
	private String excSociability;
	private String excControl;
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public String getRndId() {
		return rndId;
	}
	public void setRndId(String rndId) {
		this.rndId = rndId;
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
	public String getTicSubtype() {
		return ticSubtype;
	}
	public void setTicSubtype(String ticSubtype) {
		this.ticSubtype = ticSubtype;
	}
	public String getS1ExecDate() {
		return s1ExecDate;
	}
	public void setS1ExecDate(String s1ExecDate) {
		this.s1ExecDate = s1ExecDate;
	}
	public String getFsiq() {
		return fsiq;
	}
	public void setFsiq(String fsiq) {
		this.fsiq = fsiq;
	}
	public String getKediwaisRef() {
		return kediwaisRef;
	}
	public void setKediwaisRef(String kediwaisRef) {
		this.kediwaisRef = kediwaisRef;
	}
	public String getKediwaisVocaOs() {
		return kediwaisVocaOs;
	}
	public void setKediwaisVocaOs(String kediwaisVocaOs) {
		this.kediwaisVocaOs = kediwaisVocaOs;
	}
	public String getKediwaisArithOs() {
		return kediwaisArithOs;
	}
	public void setKediwaisArithOs(String kediwaisArithOs) {
		this.kediwaisArithOs = kediwaisArithOs;
	}
	public String getKediwaisOrderOs() {
		return kediwaisOrderOs;
	}
	public void setKediwaisOrderOs(String kediwaisOrderOs) {
		this.kediwaisOrderOs = kediwaisOrderOs;
	}
	public String getKediwaisPieceOs() {
		return kediwaisPieceOs;
	}
	public void setKediwaisPieceOs(String kediwaisPieceOs) {
		this.kediwaisPieceOs = kediwaisPieceOs;
	}
	public String getKediwaisVocaEs() {
		return kediwaisVocaEs;
	}
	public void setKediwaisVocaEs(String kediwaisVocaEs) {
		this.kediwaisVocaEs = kediwaisVocaEs;
	}
	public String getKediwaisArithEs() {
		return kediwaisArithEs;
	}
	public void setKediwaisArithEs(String kediwaisArithEs) {
		this.kediwaisArithEs = kediwaisArithEs;
	}
	public String getKediwaisOrderEs() {
		return kediwaisOrderEs;
	}
	public void setKediwaisOrderEs(String kediwaisOrderEs) {
		this.kediwaisOrderEs = kediwaisOrderEs;
	}
	public String getKediwaisPieceEs() {
		return kediwaisPieceEs;
	}
	public void setKediwaisPieceEs(String kediwaisPieceEs) {
		this.kediwaisPieceEs = kediwaisPieceEs;
	}
	public String getKwiscivCos() {
		return kwiscivCos;
	}
	public void setKwiscivCos(String kwiscivCos) {
		this.kwiscivCos = kwiscivCos;
	}
	public String getKwiscivVos() {
		return kwiscivVos;
	}
	public void setKwiscivVos(String kwiscivVos) {
		this.kwiscivVos = kwiscivVos;
	}
	public String getKwiscivUos() {
		return kwiscivUos;
	}
	public void setKwiscivUos(String kwiscivUos) {
		this.kwiscivUos = kwiscivUos;
	}
	public String getKwiscivPos() {
		return kwiscivPos;
	}
	public void setKwiscivPos(String kwiscivPos) {
		this.kwiscivPos = kwiscivPos;
	}
	public String getKwiscivCpos() {
		return kwiscivCpos;
	}
	public void setKwiscivCpos(String kwiscivCpos) {
		this.kwiscivCpos = kwiscivCpos;
	}
	public String getKwiscivMos() {
		return kwiscivMos;
	}
	public void setKwiscivMos(String kwiscivMos) {
		this.kwiscivMos = kwiscivMos;
	}
	public String getKwiscivNos() {
		return kwiscivNos;
	}
	public void setKwiscivNos(String kwiscivNos) {
		this.kwiscivNos = kwiscivNos;
	}
	public String getKwiscivScos() {
		return kwiscivScos;
	}
	public void setKwiscivScos(String kwiscivScos) {
		this.kwiscivScos = kwiscivScos;
	}
	public String getKwiscivSos() {
		return kwiscivSos;
	}
	public void setKwiscivSos(String kwiscivSos) {
		this.kwiscivSos = kwiscivSos;
	}
	public String getKwiscivStos() {
		return kwiscivStos;
	}
	public void setKwiscivStos(String kwiscivStos) {
		this.kwiscivStos = kwiscivStos;
	}
	public String getKwiscivCes() {
		return kwiscivCes;
	}
	public void setKwiscivCes(String kwiscivCes) {
		this.kwiscivCes = kwiscivCes;
	}
	public String getKwiscivVes() {
		return kwiscivVes;
	}
	public void setKwiscivVes(String kwiscivVes) {
		this.kwiscivVes = kwiscivVes;
	}
	public String getKwiscivUes() {
		return kwiscivUes;
	}
	public void setKwiscivUes(String kwiscivUes) {
		this.kwiscivUes = kwiscivUes;
	}
	public String getKwiscivPes() {
		return kwiscivPes;
	}
	public void setKwiscivPes(String kwiscivPes) {
		this.kwiscivPes = kwiscivPes;
	}
	public String getKwiscivCpes() {
		return kwiscivCpes;
	}
	public void setKwiscivCpes(String kwiscivCpes) {
		this.kwiscivCpes = kwiscivCpes;
	}
	public String getKwiscivMes() {
		return kwiscivMes;
	}
	public void setKwiscivMes(String kwiscivMes) {
		this.kwiscivMes = kwiscivMes;
	}
	public String getKwiscivNes() {
		return kwiscivNes;
	}
	public void setKwiscivNes(String kwiscivNes) {
		this.kwiscivNes = kwiscivNes;
	}
	public String getKwiscivSces() {
		return kwiscivSces;
	}
	public void setKwiscivSces(String kwiscivSces) {
		this.kwiscivSces = kwiscivSces;
	}
	public String getKwiscivSes() {
		return kwiscivSes;
	}
	public void setKwiscivSes(String kwiscivSes) {
		this.kwiscivSes = kwiscivSes;
	}
	public String getKwiscivStes() {
		return kwiscivStes;
	}
	public void setKwiscivStes(String kwiscivStes) {
		this.kwiscivStes = kwiscivStes;
	}
	public String getKwiscivSios() {
		return kwiscivSios;
	}
	public void setKwiscivSios(String kwiscivSios) {
		this.kwiscivSios = kwiscivSios;
	}
	public String getKwiscivVcos() {
		return kwiscivVcos;
	}
	public void setKwiscivVcos(String kwiscivVcos) {
		this.kwiscivVcos = kwiscivVcos;
	}
	public String getKwiscivInos() {
		return kwiscivInos;
	}
	public void setKwiscivInos(String kwiscivInos) {
		this.kwiscivInos = kwiscivInos;
	}
	public String getKwiscivBdos() {
		return kwiscivBdos;
	}
	public void setKwiscivBdos(String kwiscivBdos) {
		this.kwiscivBdos = kwiscivBdos;
	}
	public String getKwiscivMros() {
		return kwiscivMros;
	}
	public void setKwiscivMros(String kwiscivMros) {
		this.kwiscivMros = kwiscivMros;
	}
	public String getKwiscivVpos() {
		return kwiscivVpos;
	}
	public void setKwiscivVpos(String kwiscivVpos) {
		this.kwiscivVpos = kwiscivVpos;
	}
	public String getKwiscivDsos() {
		return kwiscivDsos;
	}
	public void setKwiscivDsos(String kwiscivDsos) {
		this.kwiscivDsos = kwiscivDsos;
	}
	public String getKwiscivAros() {
		return kwiscivAros;
	}
	public void setKwiscivAros(String kwiscivAros) {
		this.kwiscivAros = kwiscivAros;
	}
	public String getKwiscivSsos() {
		return kwiscivSsos;
	}
	public void setKwiscivSsos(String kwiscivSsos) {
		this.kwiscivSsos = kwiscivSsos;
	}
	public String getKwiscivCdos() {
		return kwiscivCdos;
	}
	public void setKwiscivCdos(String kwiscivCdos) {
		this.kwiscivCdos = kwiscivCdos;
	}
	public String getKwiscivSies() {
		return kwiscivSies;
	}
	public void setKwiscivSies(String kwiscivSies) {
		this.kwiscivSies = kwiscivSies;
	}
	public String getKwiscivVces() {
		return kwiscivVces;
	}
	public void setKwiscivVces(String kwiscivVces) {
		this.kwiscivVces = kwiscivVces;
	}
	public String getKwiscivInes() {
		return kwiscivInes;
	}
	public void setKwiscivInes(String kwiscivInes) {
		this.kwiscivInes = kwiscivInes;
	}
	public String getKwiscivBdes() {
		return kwiscivBdes;
	}
	public void setKwiscivBdes(String kwiscivBdes) {
		this.kwiscivBdes = kwiscivBdes;
	}
	public String getKwiscivMres() {
		return kwiscivMres;
	}
	public void setKwiscivMres(String kwiscivMres) {
		this.kwiscivMres = kwiscivMres;
	}
	public String getKwiscivVpes() {
		return kwiscivVpes;
	}
	public void setKwiscivVpes(String kwiscivVpes) {
		this.kwiscivVpes = kwiscivVpes;
	}
	public String getKwiscivDses() {
		return kwiscivDses;
	}
	public void setKwiscivDses(String kwiscivDses) {
		this.kwiscivDses = kwiscivDses;
	}
	public String getKwiscivAres() {
		return kwiscivAres;
	}
	public void setKwiscivAres(String kwiscivAres) {
		this.kwiscivAres = kwiscivAres;
	}
	public String getKwiscivSses() {
		return kwiscivSses;
	}
	public void setKwiscivSses(String kwiscivSses) {
		this.kwiscivSses = kwiscivSses;
	}
	public String getKwiscivCdes() {
		return kwiscivCdes;
	}
	public void setKwiscivCdes(String kwiscivCdes) {
		this.kwiscivCdes = kwiscivCdes;
	}
	public String getKsadsBlues() {
		return ksadsBlues;
	}
	public void setKsadsBlues(String ksadsBlues) {
		this.ksadsBlues = ksadsBlues;
	}
	public String getKsadsAnger() {
		return ksadsAnger;
	}
	public void setKsadsAnger(String ksadsAnger) {
		this.ksadsAnger = ksadsAnger;
	}
	public String getKsadsLossm() {
		return ksadsLossm;
	}
	public void setKsadsLossm(String ksadsLossm) {
		this.ksadsLossm = ksadsLossm;
	}
	public String getKsadsDeath() {
		return ksadsDeath;
	}
	public void setKsadsDeath(String ksadsDeath) {
		this.ksadsDeath = ksadsDeath;
	}
	public String getKsadsSuicide() {
		return ksadsSuicide;
	}
	public void setKsadsSuicide(String ksadsSuicide) {
		this.ksadsSuicide = ksadsSuicide;
	}
	public String getKsadsSuiSeverity() {
		return ksadsSuiSeverity;
	}
	public void setKsadsSuiSeverity(String ksadsSuiSeverity) {
		this.ksadsSuiSeverity = ksadsSuiSeverity;
	}
	public String getKsadsSuiCriticality() {
		return ksadsSuiCriticality;
	}
	public void setKsadsSuiCriticality(String ksadsSuiCriticality) {
		this.ksadsSuiCriticality = ksadsSuiCriticality;
	}
	public String getKsadsSelfharm() {
		return ksadsSelfharm;
	}
	public void setKsadsSelfharm(String ksadsSelfharm) {
		this.ksadsSelfharm = ksadsSelfharm;
	}
	public String getKsadsUplift() {
		return ksadsUplift;
	}
	public void setKsadsUplift(String ksadsUplift) {
		this.ksadsUplift = ksadsUplift;
	}
	public String getKsadsDecSleep() {
		return ksadsDecSleep;
	}
	public void setKsadsDecSleep(String ksadsDecSleep) {
		this.ksadsDecSleep = ksadsDecSleep;
	}
	public String getKsadsGoalActivity() {
		return ksadsGoalActivity;
	}
	public void setKsadsGoalActivity(String ksadsGoalActivity) {
		this.ksadsGoalActivity = ksadsGoalActivity;
	}
	public String getKsadsGallop() {
		return ksadsGallop;
	}
	public void setKsadsGallop(String ksadsGallop) {
		this.ksadsGallop = ksadsGallop;
	}
	public String getKsadsHallucination() {
		return ksadsHallucination;
	}
	public void setKsadsHallucination(String ksadsHallucination) {
		this.ksadsHallucination = ksadsHallucination;
	}
	public String getKsadsDelusion() {
		return ksadsDelusion;
	}
	public void setKsadsDelusion(String ksadsDelusion) {
		this.ksadsDelusion = ksadsDelusion;
	}
	public String getKsadsPanic() {
		return ksadsPanic;
	}
	public void setKsadsPanic(String ksadsPanic) {
		this.ksadsPanic = ksadsPanic;
	}
	public String getKsadsSeparationFear() {
		return ksadsSeparationFear;
	}
	public void setKsadsSeparationFear(String ksadsSeparationFear) {
		this.ksadsSeparationFear = ksadsSeparationFear;
	}
	public String getKsadsAttachFear() {
		return ksadsAttachFear;
	}
	public void setKsadsAttachFear(String ksadsAttachFear) {
		this.ksadsAttachFear = ksadsAttachFear;
	}
	public String getKsadsRejectSchool() {
		return ksadsRejectSchool;
	}
	public void setKsadsRejectSchool(String ksadsRejectSchool) {
		this.ksadsRejectSchool = ksadsRejectSchool;
	}
	public String getKsadsSleepFear() {
		return ksadsSleepFear;
	}
	public void setKsadsSleepFear(String ksadsSleepFear) {
		this.ksadsSleepFear = ksadsSleepFear;
	}
	public String getKsadsAloneFear() {
		return ksadsAloneFear;
	}
	public void setKsadsAloneFear(String ksadsAloneFear) {
		this.ksadsAloneFear = ksadsAloneFear;
	}
	public String getKsadsAtrophy() {
		return ksadsAtrophy;
	}
	public void setKsadsAtrophy(String ksadsAtrophy) {
		this.ksadsAtrophy = ksadsAtrophy;
	}
	public String getKsadsSituationFear() {
		return ksadsSituationFear;
	}
	public void setKsadsSituationFear(String ksadsSituationFear) {
		this.ksadsSituationFear = ksadsSituationFear;
	}
	public String getKsadsPain() {
		return ksadsPain;
	}
	public void setKsadsPain(String ksadsPain) {
		this.ksadsPain = ksadsPain;
	}
	public String getKsadsAvoid() {
		return ksadsAvoid;
	}
	public void setKsadsAvoid(String ksadsAvoid) {
		this.ksadsAvoid = ksadsAvoid;
	}
	public String getKsadsFutureWorry() {
		return ksadsFutureWorry;
	}
	public void setKsadsFutureWorry(String ksadsFutureWorry) {
		this.ksadsFutureWorry = ksadsFutureWorry;
	}
	public String getKsadsBodyComplain() {
		return ksadsBodyComplain;
	}
	public void setKsadsBodyComplain(String ksadsBodyComplain) {
		this.ksadsBodyComplain = ksadsBodyComplain;
	}
	public String getKsadsSelfConsious() {
		return ksadsSelfConsious;
	}
	public void setKsadsSelfConsious(String ksadsSelfConsious) {
		this.ksadsSelfConsious = ksadsSelfConsious;
	}
	public String getKsadsTension() {
		return ksadsTension;
	}
	public void setKsadsTension(String ksadsTension) {
		this.ksadsTension = ksadsTension;
	}
	public String getKsadsComplusiveAct() {
		return ksadsComplusiveAct;
	}
	public void setKsadsComplusiveAct(String ksadsComplusiveAct) {
		this.ksadsComplusiveAct = ksadsComplusiveAct;
	}
	public String getKsadsComplusiveThink() {
		return ksadsComplusiveThink;
	}
	public void setKsadsComplusiveThink(String ksadsComplusiveThink) {
		this.ksadsComplusiveThink = ksadsComplusiveThink;
	}
	public String getKsadsPeeNight() {
		return ksadsPeeNight;
	}
	public void setKsadsPeeNight(String ksadsPeeNight) {
		this.ksadsPeeNight = ksadsPeeNight;
	}
	public String getKsadsPeeDay() {
		return ksadsPeeDay;
	}
	public void setKsadsPeeDay(String ksadsPeeDay) {
		this.ksadsPeeDay = ksadsPeeDay;
	}
	public String getKsadsPeeTotal() {
		return ksadsPeeTotal;
	}
	public void setKsadsPeeTotal(String ksadsPeeTotal) {
		this.ksadsPeeTotal = ksadsPeeTotal;
	}
	public String getKsadsShitNight() {
		return ksadsShitNight;
	}
	public void setKsadsShitNight(String ksadsShitNight) {
		this.ksadsShitNight = ksadsShitNight;
	}
	public String getKsadsShitDay() {
		return ksadsShitDay;
	}
	public void setKsadsShitDay(String ksadsShitDay) {
		this.ksadsShitDay = ksadsShitDay;
	}
	public String getKsadsShitTotal() {
		return ksadsShitTotal;
	}
	public void setKsadsShitTotal(String ksadsShitTotal) {
		this.ksadsShitTotal = ksadsShitTotal;
	}
	public String getKsadsFatFear() {
		return ksadsFatFear;
	}
	public void setKsadsFatFear(String ksadsFatFear) {
		this.ksadsFatFear = ksadsFatFear;
	}
	public String getKsadsLowWeight() {
		return ksadsLowWeight;
	}
	public void setKsadsLowWeight(String ksadsLowWeight) {
		this.ksadsLowWeight = ksadsLowWeight;
	}
	public String getKsadsWeightLoss() {
		return ksadsWeightLoss;
	}
	public void setKsadsWeightLoss(String ksadsWeightLoss) {
		this.ksadsWeightLoss = ksadsWeightLoss;
	}
	public String getKsadsVoracity() {
		return ksadsVoracity;
	}
	public void setKsadsVoracity(String ksadsVoracity) {
		this.ksadsVoracity = ksadsVoracity;
	}
	public String getKsadsAdhdCf() {
		return ksadsAdhdCf;
	}
	public void setKsadsAdhdCf(String ksadsAdhdCf) {
		this.ksadsAdhdCf = ksadsAdhdCf;
	}
	public String getKsadsAdhdEd() {
		return ksadsAdhdEd;
	}
	public void setKsadsAdhdEd(String ksadsAdhdEd) {
		this.ksadsAdhdEd = ksadsAdhdEd;
	}
	public String getKsadsAdhdSf() {
		return ksadsAdhdSf;
	}
	public void setKsadsAdhdSf(String ksadsAdhdSf) {
		this.ksadsAdhdSf = ksadsAdhdSf;
	}
	public String getKsadsAdhdImpulsivity() {
		return ksadsAdhdImpulsivity;
	}
	public void setKsadsAdhdImpulsivity(String ksadsAdhdImpulsivity) {
		this.ksadsAdhdImpulsivity = ksadsAdhdImpulsivity;
	}
	public String getKsadsOddAngry() {
		return ksadsOddAngry;
	}
	public void setKsadsOddAngry(String ksadsOddAngry) {
		this.ksadsOddAngry = ksadsOddAngry;
	}
	public String getKsadsOddAa() {
		return ksadsOddAa;
	}
	public void setKsadsOddAa(String ksadsOddAa) {
		this.ksadsOddAa = ksadsOddAa;
	}
	public String getKsadsOddNotrules() {
		return ksadsOddNotrules;
	}
	public void setKsadsOddNotrules(String ksadsOddNotrules) {
		this.ksadsOddNotrules = ksadsOddNotrules;
	}
	public String getKsadsCdLie() {
		return ksadsCdLie;
	}
	public void setKsadsCdLie(String ksadsCdLie) {
		this.ksadsCdLie = ksadsCdLie;
	}
	public String getKsadsCdTruancy() {
		return ksadsCdTruancy;
	}
	public void setKsadsCdTruancy(String ksadsCdTruancy) {
		this.ksadsCdTruancy = ksadsCdTruancy;
	}
	public String getKsadsCdFight() {
		return ksadsCdFight;
	}
	public void setKsadsCdFight(String ksadsCdFight) {
		this.ksadsCdFight = ksadsCdFight;
	}
	public String getKsadsCdTorment() {
		return ksadsCdTorment;
	}
	public void setKsadsCdTorment(String ksadsCdTorment) {
		this.ksadsCdTorment = ksadsCdTorment;
	}
	public String getKsadsCdThievery() {
		return ksadsCdThievery;
	}
	public void setKsadsCdThievery(String ksadsCdThievery) {
		this.ksadsCdThievery = ksadsCdThievery;
	}
	public String getKsadsExerciseTic() {
		return ksadsExerciseTic;
	}
	public void setKsadsExerciseTic(String ksadsExerciseTic) {
		this.ksadsExerciseTic = ksadsExerciseTic;
	}
	public String getKsadsExerciseVoice() {
		return ksadsExerciseVoice;
	}
	public void setKsadsExerciseVoice(String ksadsExerciseVoice) {
		this.ksadsExerciseVoice = ksadsExerciseVoice;
	}
	public String getGas() {
		return gas;
	}
	public void setGas(String gas) {
		this.gas = gas;
	}
	public String getAdhdrq1Mistake() {
		return adhdrq1Mistake;
	}
	public void setAdhdrq1Mistake(String adhdrq1Mistake) {
		this.adhdrq1Mistake = adhdrq1Mistake;
	}
	public String getAdhdrq2Notlisten() {
		return adhdrq2Notlisten;
	}
	public void setAdhdrq2Notlisten(String adhdrq2Notlisten) {
		this.adhdrq2Notlisten = adhdrq2Notlisten;
	}
	public String getAdhdrq3FollowDiff() {
		return adhdrq3FollowDiff;
	}
	public void setAdhdrq3FollowDiff(String adhdrq3FollowDiff) {
		this.adhdrq3FollowDiff = adhdrq3FollowDiff;
	}
	public String getAdhdrq4ArrangeDiff() {
		return adhdrq4ArrangeDiff;
	}
	public void setAdhdrq4ArrangeDiff(String adhdrq4ArrangeDiff) {
		this.adhdrq4ArrangeDiff = adhdrq4ArrangeDiff;
	}
	public String getAdhdrq5AssignAvoid() {
		return adhdrq5AssignAvoid;
	}
	public void setAdhdrq5AssignAvoid(String adhdrq5AssignAvoid) {
		this.adhdrq5AssignAvoid = adhdrq5AssignAvoid;
	}
	public String getAdhdrq6LostItem() {
		return adhdrq6LostItem;
	}
	public void setAdhdrq6LostItem(String adhdrq6LostItem) {
		this.adhdrq6LostItem = adhdrq6LostItem;
	}
	public String getAdhdrq7Forgetfulness() {
		return adhdrq7Forgetfulness;
	}
	public void setAdhdrq7Forgetfulness(String adhdrq7Forgetfulness) {
		this.adhdrq7Forgetfulness = adhdrq7Forgetfulness;
	}
	public String getAdhdrq8Unrest() {
		return adhdrq8Unrest;
	}
	public void setAdhdrq8Unrest(String adhdrq8Unrest) {
		this.adhdrq8Unrest = adhdrq8Unrest;
	}
	public String getAdhdrq9Overrun() {
		return adhdrq9Overrun;
	}
	public void setAdhdrq9Overrun(String adhdrq9Overrun) {
		this.adhdrq9Overrun = adhdrq9Overrun;
	}
	public String getAdhdrq10EndlessAct() {
		return adhdrq10EndlessAct;
	}
	public void setAdhdrq10EndlessAct(String adhdrq10EndlessAct) {
		this.adhdrq10EndlessAct = adhdrq10EndlessAct;
	}
	public String getAdhdrq11SilentDiff() {
		return adhdrq11SilentDiff;
	}
	public void setAdhdrq11SilentDiff(String adhdrq11SilentDiff) {
		this.adhdrq11SilentDiff = adhdrq11SilentDiff;
	}
	public String getAdhdrq12SuddenAns() {
		return adhdrq12SuddenAns;
	}
	public void setAdhdrq12SuddenAns(String adhdrq12SuddenAns) {
		this.adhdrq12SuddenAns = adhdrq12SuddenAns;
	}
	public String getAdhdrq13WaitDiff() {
		return adhdrq13WaitDiff;
	}
	public void setAdhdrq13WaitDiff(String adhdrq13WaitDiff) {
		this.adhdrq13WaitDiff = adhdrq13WaitDiff;
	}
	public String getAdhdrq14Interrupt() {
		return adhdrq14Interrupt;
	}
	public void setAdhdrq14Interrupt(String adhdrq14Interrupt) {
		this.adhdrq14Interrupt = adhdrq14Interrupt;
	}
	public String getAdhdrq15Fickle() {
		return adhdrq15Fickle;
	}
	public void setAdhdrq15Fickle(String adhdrq15Fickle) {
		this.adhdrq15Fickle = adhdrq15Fickle;
	}
	public String getAdhdrq16Chatter() {
		return adhdrq16Chatter;
	}
	public void setAdhdrq16Chatter(String adhdrq16Chatter) {
		this.adhdrq16Chatter = adhdrq16Chatter;
	}
	public String getAdhdrq17DangerAct() {
		return adhdrq17DangerAct;
	}
	public void setAdhdrq17DangerAct(String adhdrq17DangerAct) {
		this.adhdrq17DangerAct = adhdrq17DangerAct;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDiagnosisEtc() {
		return diagnosisEtc;
	}
	public void setDiagnosisEtc(String diagnosisEtc) {
		this.diagnosisEtc = diagnosisEtc;
	}
	public String getTicAppendix() {
		return ticAppendix;
	}
	public void setTicAppendix(String ticAppendix) {
		this.ticAppendix = ticAppendix;
	}
	public String getSactTic1Ce() {
		return sactTic1Ce;
	}
	public void setSactTic1Ce(String sactTic1Ce) {
		this.sactTic1Ce = sactTic1Ce;
	}
	public String getSactTic1Msp() {
		return sactTic1Msp;
	}
	public void setSactTic1Msp(String sactTic1Msp) {
		this.sactTic1Msp = sactTic1Msp;
	}
	public String getSactTic2Ce() {
		return sactTic2Ce;
	}
	public void setSactTic2Ce(String sactTic2Ce) {
		this.sactTic2Ce = sactTic2Ce;
	}
	public String getSactTic2Msp() {
		return sactTic2Msp;
	}
	public void setSactTic2Msp(String sactTic2Msp) {
		this.sactTic2Msp = sactTic2Msp;
	}
	public String getSactTic3Ce() {
		return sactTic3Ce;
	}
	public void setSactTic3Ce(String sactTic3Ce) {
		this.sactTic3Ce = sactTic3Ce;
	}
	public String getSactTic3Msp() {
		return sactTic3Msp;
	}
	public void setSactTic3Msp(String sactTic3Msp) {
		this.sactTic3Msp = sactTic3Msp;
	}
	public String getSactTic4Ce() {
		return sactTic4Ce;
	}
	public void setSactTic4Ce(String sactTic4Ce) {
		this.sactTic4Ce = sactTic4Ce;
	}
	public String getSactTic4Msp() {
		return sactTic4Msp;
	}
	public void setSactTic4Msp(String sactTic4Msp) {
		this.sactTic4Msp = sactTic4Msp;
	}
	public String getSactTic5Ce() {
		return sactTic5Ce;
	}
	public void setSactTic5Ce(String sactTic5Ce) {
		this.sactTic5Ce = sactTic5Ce;
	}
	public String getSactTic5Msp() {
		return sactTic5Msp;
	}
	public void setSactTic5Msp(String sactTic5Msp) {
		this.sactTic5Msp = sactTic5Msp;
	}
	public String getSactTic6Ce() {
		return sactTic6Ce;
	}
	public void setSactTic6Ce(String sactTic6Ce) {
		this.sactTic6Ce = sactTic6Ce;
	}
	public String getSactTic6Msp() {
		return sactTic6Msp;
	}
	public void setSactTic6Msp(String sactTic6Msp) {
		this.sactTic6Msp = sactTic6Msp;
	}
	public String getSactTic7Ce() {
		return sactTic7Ce;
	}
	public void setSactTic7Ce(String sactTic7Ce) {
		this.sactTic7Ce = sactTic7Ce;
	}
	public String getSactTic7Msp() {
		return sactTic7Msp;
	}
	public void setSactTic7Msp(String sactTic7Msp) {
		this.sactTic7Msp = sactTic7Msp;
	}
	public String getSactTic8Ce() {
		return sactTic8Ce;
	}
	public void setSactTic8Ce(String sactTic8Ce) {
		this.sactTic8Ce = sactTic8Ce;
	}
	public String getSactTic8Msp() {
		return sactTic8Msp;
	}
	public void setSactTic8Msp(String sactTic8Msp) {
		this.sactTic8Msp = sactTic8Msp;
	}
	public String getCactTic1Ce() {
		return cactTic1Ce;
	}
	public void setCactTic1Ce(String cactTic1Ce) {
		this.cactTic1Ce = cactTic1Ce;
	}
	public String getCactTic1Msp() {
		return cactTic1Msp;
	}
	public void setCactTic1Msp(String cactTic1Msp) {
		this.cactTic1Msp = cactTic1Msp;
	}
	public String getCactTic2Ce() {
		return cactTic2Ce;
	}
	public void setCactTic2Ce(String cactTic2Ce) {
		this.cactTic2Ce = cactTic2Ce;
	}
	public String getCactTic2Msp() {
		return cactTic2Msp;
	}
	public void setCactTic2Msp(String cactTic2Msp) {
		this.cactTic2Msp = cactTic2Msp;
	}
	public String getCactTic3Ce() {
		return cactTic3Ce;
	}
	public void setCactTic3Ce(String cactTic3Ce) {
		this.cactTic3Ce = cactTic3Ce;
	}
	public String getCactTic3Msp() {
		return cactTic3Msp;
	}
	public void setCactTic3Msp(String cactTic3Msp) {
		this.cactTic3Msp = cactTic3Msp;
	}
	public String getCactTic4Ce() {
		return cactTic4Ce;
	}
	public void setCactTic4Ce(String cactTic4Ce) {
		this.cactTic4Ce = cactTic4Ce;
	}
	public String getCactTic4Msp() {
		return cactTic4Msp;
	}
	public void setCactTic4Msp(String cactTic4Msp) {
		this.cactTic4Msp = cactTic4Msp;
	}
	public String getCactTic5Ce() {
		return cactTic5Ce;
	}
	public void setCactTic5Ce(String cactTic5Ce) {
		this.cactTic5Ce = cactTic5Ce;
	}
	public String getCactTic5Msp() {
		return cactTic5Msp;
	}
	public void setCactTic5Msp(String cactTic5Msp) {
		this.cactTic5Msp = cactTic5Msp;
	}
	public String getSvoiceTic1Ce() {
		return svoiceTic1Ce;
	}
	public void setSvoiceTic1Ce(String svoiceTic1Ce) {
		this.svoiceTic1Ce = svoiceTic1Ce;
	}
	public String getSvoiceTic1Msp() {
		return svoiceTic1Msp;
	}
	public void setSvoiceTic1Msp(String svoiceTic1Msp) {
		this.svoiceTic1Msp = svoiceTic1Msp;
	}
	public String getSvoiceTic2Ce() {
		return svoiceTic2Ce;
	}
	public void setSvoiceTic2Ce(String svoiceTic2Ce) {
		this.svoiceTic2Ce = svoiceTic2Ce;
	}
	public String getSvoiceTic2Msp() {
		return svoiceTic2Msp;
	}
	public void setSvoiceTic2Msp(String svoiceTic2Msp) {
		this.svoiceTic2Msp = svoiceTic2Msp;
	}
	public String getSvoiceTic3Ce() {
		return svoiceTic3Ce;
	}
	public void setSvoiceTic3Ce(String svoiceTic3Ce) {
		this.svoiceTic3Ce = svoiceTic3Ce;
	}
	public String getSvoiceTic3Msp() {
		return svoiceTic3Msp;
	}
	public void setSvoiceTic3Msp(String svoiceTic3Msp) {
		this.svoiceTic3Msp = svoiceTic3Msp;
	}
	public String getCvoiceTic1Ce() {
		return cvoiceTic1Ce;
	}
	public void setCvoiceTic1Ce(String cvoiceTic1Ce) {
		this.cvoiceTic1Ce = cvoiceTic1Ce;
	}
	public String getCvoiceTic1Msp() {
		return cvoiceTic1Msp;
	}
	public void setCvoiceTic1Msp(String cvoiceTic1Msp) {
		this.cvoiceTic1Msp = cvoiceTic1Msp;
	}
	public String getCvoiceTic2Ce() {
		return cvoiceTic2Ce;
	}
	public void setCvoiceTic2Ce(String cvoiceTic2Ce) {
		this.cvoiceTic2Ce = cvoiceTic2Ce;
	}
	public String getCvoiceTic2Msp() {
		return cvoiceTic2Msp;
	}
	public void setCvoiceTic2Msp(String cvoiceTic2Msp) {
		this.cvoiceTic2Msp = cvoiceTic2Msp;
	}
	public String getCvoiceTic3Ce() {
		return cvoiceTic3Ce;
	}
	public void setCvoiceTic3Ce(String cvoiceTic3Ce) {
		this.cvoiceTic3Ce = cvoiceTic3Ce;
	}
	public String getCvoiceTic3Msp() {
		return cvoiceTic3Msp;
	}
	public void setCvoiceTic3Msp(String cvoiceTic3Msp) {
		this.cvoiceTic3Msp = cvoiceTic3Msp;
	}
	public String getCvoiceTic4Ce() {
		return cvoiceTic4Ce;
	}
	public void setCvoiceTic4Ce(String cvoiceTic4Ce) {
		this.cvoiceTic4Ce = cvoiceTic4Ce;
	}
	public String getCvoiceTic4Msp() {
		return cvoiceTic4Msp;
	}
	public void setCvoiceTic4Msp(String cvoiceTic4Msp) {
		this.cvoiceTic4Msp = cvoiceTic4Msp;
	}
	public String getCvoiceTic5Ce() {
		return cvoiceTic5Ce;
	}
	public void setCvoiceTic5Ce(String cvoiceTic5Ce) {
		this.cvoiceTic5Ce = cvoiceTic5Ce;
	}
	public String getCvoiceTic5Msp() {
		return cvoiceTic5Msp;
	}
	public void setCvoiceTic5Msp(String cvoiceTic5Msp) {
		this.cvoiceTic5Msp = cvoiceTic5Msp;
	}
	public String getCvoiceTic6aCe() {
		return cvoiceTic6aCe;
	}
	public void setCvoiceTic6aCe(String cvoiceTic6aCe) {
		this.cvoiceTic6aCe = cvoiceTic6aCe;
	}
	public String getCvoiceTic6aMsp() {
		return cvoiceTic6aMsp;
	}
	public void setCvoiceTic6aMsp(String cvoiceTic6aMsp) {
		this.cvoiceTic6aMsp = cvoiceTic6aMsp;
	}
	public String getCvoiceTic6bCe() {
		return cvoiceTic6bCe;
	}
	public void setCvoiceTic6bCe(String cvoiceTic6bCe) {
		this.cvoiceTic6bCe = cvoiceTic6bCe;
	}
	public String getCvoiceTic6bMsp() {
		return cvoiceTic6bMsp;
	}
	public void setCvoiceTic6bMsp(String cvoiceTic6bMsp) {
		this.cvoiceTic6bMsp = cvoiceTic6bMsp;
	}
	public String getCvoiceTic6cCe() {
		return cvoiceTic6cCe;
	}
	public void setCvoiceTic6cCe(String cvoiceTic6cCe) {
		this.cvoiceTic6cCe = cvoiceTic6cCe;
	}
	public String getCvoiceTic6cMsp() {
		return cvoiceTic6cMsp;
	}
	public void setCvoiceTic6cMsp(String cvoiceTic6cMsp) {
		this.cvoiceTic6cMsp = cvoiceTic6cMsp;
	}
	public String getTourette7aCe() {
		return tourette7aCe;
	}
	public void setTourette7aCe(String tourette7aCe) {
		this.tourette7aCe = tourette7aCe;
	}
	public String getTourette7aMsp() {
		return tourette7aMsp;
	}
	public void setTourette7aMsp(String tourette7aMsp) {
		this.tourette7aMsp = tourette7aMsp;
	}
	public String getTourette7bCe() {
		return tourette7bCe;
	}
	public void setTourette7bCe(String tourette7bCe) {
		this.tourette7bCe = tourette7bCe;
	}
	public String getTourette7bMsp() {
		return tourette7bMsp;
	}
	public void setTourette7bMsp(String tourette7bMsp) {
		this.tourette7bMsp = tourette7bMsp;
	}
	public String getChronicTic8aCe() {
		return chronicTic8aCe;
	}
	public void setChronicTic8aCe(String chronicTic8aCe) {
		this.chronicTic8aCe = chronicTic8aCe;
	}
	public String getChronicTic8aMsp() {
		return chronicTic8aMsp;
	}
	public void setChronicTic8aMsp(String chronicTic8aMsp) {
		this.chronicTic8aMsp = chronicTic8aMsp;
	}
	public String getChronicTic8bCe() {
		return chronicTic8bCe;
	}
	public void setChronicTic8bCe(String chronicTic8bCe) {
		this.chronicTic8bCe = chronicTic8bCe;
	}
	public String getChronicTic8bMsp() {
		return chronicTic8bMsp;
	}
	public void setChronicTic8bMsp(String chronicTic8bMsp) {
		this.chronicTic8bMsp = chronicTic8bMsp;
	}
	public String getDailyTic9aCe() {
		return dailyTic9aCe;
	}
	public void setDailyTic9aCe(String dailyTic9aCe) {
		this.dailyTic9aCe = dailyTic9aCe;
	}
	public String getDailyTic9aMsp() {
		return dailyTic9aMsp;
	}
	public void setDailyTic9aMsp(String dailyTic9aMsp) {
		this.dailyTic9aMsp = dailyTic9aMsp;
	}
	public String getDailyTic9bCe() {
		return dailyTic9bCe;
	}
	public void setDailyTic9bCe(String dailyTic9bCe) {
		this.dailyTic9bCe = dailyTic9bCe;
	}
	public String getDailyTic9bMsp() {
		return dailyTic9bMsp;
	}
	public void setDailyTic9bMsp(String dailyTic9bMsp) {
		this.dailyTic9bMsp = dailyTic9bMsp;
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
	public String getExctAllIntell() {
		return exctAllIntell;
	}
	public void setExctAllIntell(String exctAllIntell) {
		this.exctAllIntell = exctAllIntell;
	}
	public String getExctShortIntell() {
		return exctShortIntell;
	}
	public void setExctShortIntell(String exctShortIntell) {
		this.exctShortIntell = exctShortIntell;
	}
	public String getExctFluidInfer() {
		return exctFluidInfer;
	}
	public void setExctFluidInfer(String exctFluidInfer) {
		this.exctFluidInfer = exctFluidInfer;
	}
	public String getExctBasicVisual() {
		return exctBasicVisual;
	}
	public void setExctBasicVisual(String exctBasicVisual) {
		this.exctBasicVisual = exctBasicVisual;
	}
	public String getIcidAllIntell() {
		return icidAllIntell;
	}
	public void setIcidAllIntell(String icidAllIntell) {
		this.icidAllIntell = icidAllIntell;
	}
	public String getIcidShortIntell() {
		return icidShortIntell;
	}
	public void setIcidShortIntell(String icidShortIntell) {
		this.icidShortIntell = icidShortIntell;
	}
	public String getIcidFluidInfer() {
		return icidFluidInfer;
	}
	public void setIcidFluidInfer(String icidFluidInfer) {
		this.icidFluidInfer = icidFluidInfer;
	}
	public String getIcidBasicVisual() {
		return icidBasicVisual;
	}
	public void setIcidBasicVisual(String icidBasicVisual) {
		this.icidBasicVisual = icidBasicVisual;
	}
	public String getVifsForeBack() {
		return vifsForeBack;
	}
	public void setVifsForeBack(String vifsForeBack) {
		this.vifsForeBack = vifsForeBack;
	}
	public String getVifsShapeComp() {
		return vifsShapeComp;
	}
	public void setVifsShapeComp(String vifsShapeComp) {
		this.vifsShapeComp = vifsShapeComp;
	}
	public String getVifsMatch() {
		return vifsMatch;
	}
	public void setVifsMatch(String vifsMatch) {
		this.vifsMatch = vifsMatch;
	}
	public String getVifsOrderInfer() {
		return vifsOrderInfer;
	}
	public void setVifsOrderInfer(String vifsOrderInfer) {
		this.vifsOrderInfer = vifsOrderInfer;
	}
	public String getVifsPattFind() {
		return vifsPattFind;
	}
	public void setVifsPattFind(String vifsPattFind) {
		this.vifsPattFind = vifsPattFind;
	}
	public String getVifsDrawInfer() {
		return vifsDrawInfer;
	}
	public void setVifsDrawInfer(String vifsDrawInfer) {
		this.vifsDrawInfer = vifsDrawInfer;
	}
	public String getVifsCategoriz() {
		return vifsCategoriz;
	}
	public void setVifsCategoriz(String vifsCategoriz) {
		this.vifsCategoriz = vifsCategoriz;
	}
	public String getViexcForeBack() {
		return viexcForeBack;
	}
	public void setViexcForeBack(String viexcForeBack) {
		this.viexcForeBack = viexcForeBack;
	}
	public String getViexcShapeComp() {
		return viexcShapeComp;
	}
	public void setViexcShapeComp(String viexcShapeComp) {
		this.viexcShapeComp = viexcShapeComp;
	}
	public String getViexcMatch() {
		return viexcMatch;
	}
	public void setViexcMatch(String viexcMatch) {
		this.viexcMatch = viexcMatch;
	}
	public String getViexcOrderInfer() {
		return viexcOrderInfer;
	}
	public void setViexcOrderInfer(String viexcOrderInfer) {
		this.viexcOrderInfer = viexcOrderInfer;
	}
	public String getViexcPattFind() {
		return viexcPattFind;
	}
	public void setViexcPattFind(String viexcPattFind) {
		this.viexcPattFind = viexcPattFind;
	}
	public String getViexcDrawInfer() {
		return viexcDrawInfer;
	}
	public void setViexcDrawInfer(String viexcDrawInfer) {
		this.viexcDrawInfer = viexcDrawInfer;
	}
	public String getViexcCategoriz() {
		return viexcCategoriz;
	}
	public void setViexcCategoriz(String viexcCategoriz) {
		this.viexcCategoriz = viexcCategoriz;
	}
	public String getCexcMemorySelect() {
		return cexcMemorySelect;
	}
	public void setCexcMemorySelect(String cexcMemorySelect) {
		this.cexcMemorySelect = cexcMemorySelect;
	}
	public String getCexcRecogMemory() {
		return cexcRecogMemory;
	}
	public void setCexcRecogMemory(String cexcRecogMemory) {
		this.cexcRecogMemory = cexcRecogMemory;
	}
	public String getCcompMemorySelect() {
		return ccompMemorySelect;
	}
	public void setCcompMemorySelect(String ccompMemorySelect) {
		this.ccompMemorySelect = ccompMemorySelect;
	}
	public String getCcompRecogMemory() {
		return ccompRecogMemory;
	}
	public void setCcompRecogMemory(String ccompRecogMemory) {
		this.ccompRecogMemory = ccompRecogMemory;
	}
	public String getScPairAsso() {
		return scPairAsso;
	}
	public void setScPairAsso(String scPairAsso) {
		this.scPairAsso = scPairAsso;
	}
	public String getScImmedRecog() {
		return scImmedRecog;
	}
	public void setScImmedRecog(String scImmedRecog) {
		this.scImmedRecog = scImmedRecog;
	}
	public String getScImmedRemember() {
		return scImmedRemember;
	}
	public void setScImmedRemember(String scImmedRemember) {
		this.scImmedRemember = scImmedRemember;
	}
	public String getScSustainAtt() {
		return scSustainAtt;
	}
	public void setScSustainAtt(String scSustainAtt) {
		this.scSustainAtt = scSustainAtt;
	}
	public String getScDelayRecog() {
		return scDelayRecog;
	}
	public void setScDelayRecog(String scDelayRecog) {
		this.scDelayRecog = scDelayRecog;
	}
	public String getExcPairAsso() {
		return excPairAsso;
	}
	public void setExcPairAsso(String excPairAsso) {
		this.excPairAsso = excPairAsso;
	}
	public String getExcImmedRecog() {
		return excImmedRecog;
	}
	public void setExcImmedRecog(String excImmedRecog) {
		this.excImmedRecog = excImmedRecog;
	}
	public String getExcImmedRemember() {
		return excImmedRemember;
	}
	public void setExcImmedRemember(String excImmedRemember) {
		this.excImmedRemember = excImmedRemember;
	}
	public String getExcSustainAtt() {
		return excSustainAtt;
	}
	public void setExcSustainAtt(String excSustainAtt) {
		this.excSustainAtt = excSustainAtt;
	}
	public String getExcDelayRecog() {
		return excDelayRecog;
	}
	public void setExcDelayRecog(String excDelayRecog) {
		this.excDelayRecog = excDelayRecog;
	}
	public String getpRsCompsc() {
		return pRsCompsc;
	}
	public void setpRsCompsc(String pRsCompsc) {
		this.pRsCompsc = pRsCompsc;
	}
	public String getpEcCompsc() {
		return pEcCompsc;
	}
	public void setpEcCompsc(String pEcCompsc) {
		this.pEcCompsc = pEcCompsc;
	}
	public String getScAttention() {
		return scAttention;
	}
	public void setScAttention(String scAttention) {
		this.scAttention = scAttention;
	}
	public String getScActivLevel() {
		return scActivLevel;
	}
	public void setScActivLevel(String scActivLevel) {
		this.scActivLevel = scActivLevel;
	}
	public String getScImpuls() {
		return scImpuls;
	}
	public void setScImpuls(String scImpuls) {
		this.scImpuls = scImpuls;
	}
	public String getScAdaptability() {
		return scAdaptability;
	}
	public void setScAdaptability(String scAdaptability) {
		this.scAdaptability = scAdaptability;
	}
	public String getScMoodConfid() {
		return scMoodConfid;
	}
	public void setScMoodConfid(String scMoodConfid) {
		this.scMoodConfid = scMoodConfid;
	}
	public String getScFeelEmo() {
		return scFeelEmo;
	}
	public void setScFeelEmo(String scFeelEmo) {
		this.scFeelEmo = scFeelEmo;
	}
	public String getScSociability() {
		return scSociability;
	}
	public void setScSociability(String scSociability) {
		this.scSociability = scSociability;
	}
	public String getScControl() {
		return scControl;
	}
	public void setScControl(String scControl) {
		this.scControl = scControl;
	}
	public String getExcAttention() {
		return excAttention;
	}
	public void setExcAttention(String excAttention) {
		this.excAttention = excAttention;
	}
	public String getExcActivLevel() {
		return excActivLevel;
	}
	public void setExcActivLevel(String excActivLevel) {
		this.excActivLevel = excActivLevel;
	}
	public String getExcImpuls() {
		return excImpuls;
	}
	public void setExcImpuls(String excImpuls) {
		this.excImpuls = excImpuls;
	}
	public String getExcAdaptability() {
		return excAdaptability;
	}
	public void setExcAdaptability(String excAdaptability) {
		this.excAdaptability = excAdaptability;
	}
	public String getExcMoodConfid() {
		return excMoodConfid;
	}
	public void setExcMoodConfid(String excMoodConfid) {
		this.excMoodConfid = excMoodConfid;
	}
	public String getExcFeelEmo() {
		return excFeelEmo;
	}
	public void setExcFeelEmo(String excFeelEmo) {
		this.excFeelEmo = excFeelEmo;
	}
	public String getExcSociability() {
		return excSociability;
	}
	public void setExcSociability(String excSociability) {
		this.excSociability = excSociability;
	}
	public String getExcControl() {
		return excControl;
	}
	public void setExcControl(String excControl) {
		this.excControl = excControl;
	}
	public String getEnrollAge() {
		return enrollAge;
	}
	public void setEnrollAge(String enrollAge) {
		this.enrollAge = enrollAge;
	}

	
	public String getKwiscivEsadlu() {
		return kwiscivEsadlu;
	}
	public void setKwiscivEsadlu(String kwiscivEsadlu) {
		this.kwiscivEsadlu = kwiscivEsadlu;
	}
	public String getKwiscivEsadpr() {
		return kwiscivEsadpr;
	}
	public void setKwiscivEsadpr(String kwiscivEsadpr) {
		this.kwiscivEsadpr = kwiscivEsadpr;
	}
	public String getKwiscivEsadwr() {
		return kwiscivEsadwr;
	}
	public void setKwiscivEsadwr(String kwiscivEsadwr) {
		this.kwiscivEsadwr = kwiscivEsadwr;
	}
	public String getKwiscivEsadps() {
		return kwiscivEsadps;
	}
	public void setKwiscivEsadps(String kwiscivEsadps) {
		this.kwiscivEsadps = kwiscivEsadps;
	}
	public String getKwiscivEsadalliq() {
		return kwiscivEsadalliq;
	}
	public void setKwiscivEsadalliq(String kwiscivEsadalliq) {
		this.kwiscivEsadalliq = kwiscivEsadalliq;
	}

	public String getKwiscivIdxslu() {
		return kwiscivIdxslu;
	}
	public void setKwiscivIdxslu(String kwiscivIdxslu) {
		this.kwiscivIdxslu = kwiscivIdxslu;
	}
	public String getKwiscivIdxspr() {
		return kwiscivIdxspr;
	}
	public void setKwiscivIdxspr(String kwiscivIdxspr) {
		this.kwiscivIdxspr = kwiscivIdxspr;
	}
	public String getKwiscivIdxswr() {
		return kwiscivIdxswr;
	}
	public void setKwiscivIdxswr(String kwiscivIdxswr) {
		this.kwiscivIdxswr = kwiscivIdxswr;
	}
	public String getKwiscivIdxsps() {
		return kwiscivIdxsps;
	}
	public void setKwiscivIdxsps(String kwiscivIdxsps) {
		this.kwiscivIdxsps = kwiscivIdxsps;
	}
	public String getKwiscivIdxsalliq() {
		return kwiscivIdxsalliq;
	}
	public void setKwiscivIdxsalliq(String kwiscivIdxsalliq) {
		this.kwiscivIdxsalliq = kwiscivIdxsalliq;
	}
	public String getKwiscivPercntlu() {
		return kwiscivPercntlu;
	}
	public void setKwiscivPercntlu(String kwiscivPercntlu) {
		this.kwiscivPercntlu = kwiscivPercntlu;
	}
	public String getKwiscivPercntpr() {
		return kwiscivPercntpr;
	}
	public void setKwiscivPercntpr(String kwiscivPercntpr) {
		this.kwiscivPercntpr = kwiscivPercntpr;
	}
	public String getKwiscivPercntwr() {
		return kwiscivPercntwr;
	}
	public void setKwiscivPercntwr(String kwiscivPercntwr) {
		this.kwiscivPercntwr = kwiscivPercntwr;
	}
	public String getKwiscivPercntps() {
		return kwiscivPercntps;
	}
	public void setKwiscivPercntps(String kwiscivPercntps) {
		this.kwiscivPercntps = kwiscivPercntps;
	}
	public String getKwiscivPercntalliq() {
		return kwiscivPercntalliq;
	}
	public void setKwiscivPercntalliq(String kwiscivPercntalliq) {
		this.kwiscivPercntalliq = kwiscivPercntalliq;
	}

	public String getKwiscivQdlu() {
		return kwiscivQdlu;
	}
	public void setKwiscivQdlu(String kwiscivQdlu) {
		this.kwiscivQdlu = kwiscivQdlu;
	}
	public String getKwiscivQdpr() {
		return kwiscivQdpr;
	}
	public void setKwiscivQdpr(String kwiscivQdpr) {
		this.kwiscivQdpr = kwiscivQdpr;
	}
	public String getKwiscivQdwr() {
		return kwiscivQdwr;
	}
	public void setKwiscivQdwr(String kwiscivQdwr) {
		this.kwiscivQdwr = kwiscivQdwr;
	}
	public String getKwiscivQdps() {
		return kwiscivQdps;
	}
	public void setKwiscivQdps(String kwiscivQdps) {
		this.kwiscivQdps = kwiscivQdps;
	}
	public String getKwiscivQdalliq() {
		return kwiscivQdalliq;
	}
	public void setKwiscivQdalliq(String kwiscivQdalliq) {
		this.kwiscivQdalliq = kwiscivQdalliq;
	}
	public String getKwisciv2Idxslu() {
		return kwisciv2Idxslu;
	}
	public void setKwisciv2Idxslu(String kwisciv2Idxslu) {
		this.kwisciv2Idxslu = kwisciv2Idxslu;
	}
	public String getKwisciv2Idxspr() {
		return kwisciv2Idxspr;
	}
	public void setKwisciv2Idxspr(String kwisciv2Idxspr) {
		this.kwisciv2Idxspr = kwisciv2Idxspr;
	}
	public String getKwisciv2Idxswr() {
		return kwisciv2Idxswr;
	}
	public void setKwisciv2Idxswr(String kwisciv2Idxswr) {
		this.kwisciv2Idxswr = kwisciv2Idxswr;
	}
	public String getKwisciv2Idxsps() {
		return kwisciv2Idxsps;
	}
	public void setKwisciv2Idxsps(String kwisciv2Idxsps) {
		this.kwisciv2Idxsps = kwisciv2Idxsps;
	}
	public String getKwisciv2Idxsalliq() {
		return kwisciv2Idxsalliq;
	}
	public void setKwisciv2Idxsalliq(String kwisciv2Idxsalliq) {
		this.kwisciv2Idxsalliq = kwisciv2Idxsalliq;
	}
	public String getKwisciv2Percntlu() {
		return kwisciv2Percntlu;
	}
	public void setKwisciv2Percntlu(String kwisciv2Percntlu) {
		this.kwisciv2Percntlu = kwisciv2Percntlu;
	}
	public String getKwisciv2Percntpr() {
		return kwisciv2Percntpr;
	}
	public void setKwisciv2Percntpr(String kwisciv2Percntpr) {
		this.kwisciv2Percntpr = kwisciv2Percntpr;
	}
	public String getKwisciv2Percntwr() {
		return kwisciv2Percntwr;
	}
	public void setKwisciv2Percntwr(String kwisciv2Percntwr) {
		this.kwisciv2Percntwr = kwisciv2Percntwr;
	}
	public String getKwisciv2Percntps() {
		return kwisciv2Percntps;
	}
	public void setKwisciv2Percntps(String kwisciv2Percntps) {
		this.kwisciv2Percntps = kwisciv2Percntps;
	}
	public String getKwisciv2Percntalliq() {
		return kwisciv2Percntalliq;
	}
	public void setKwisciv2Percntalliq(String kwisciv2Percntalliq) {
		this.kwisciv2Percntalliq = kwisciv2Percntalliq;
	}
	public String getKwiscivConfitvllu() {
		return kwiscivConfitvllu;
	}
	public void setKwiscivConfitvllu(String kwiscivConfitvllu) {
		this.kwiscivConfitvllu = kwiscivConfitvllu;
	}
	public String getKwiscivConfitvlpr() {
		return kwiscivConfitvlpr;
	}
	public void setKwiscivConfitvlpr(String kwiscivConfitvlpr) {
		this.kwiscivConfitvlpr = kwiscivConfitvlpr;
	}
	public String getKwiscivConfitvlwr() {
		return kwiscivConfitvlwr;
	}
	public void setKwiscivConfitvlwr(String kwiscivConfitvlwr) {
		this.kwiscivConfitvlwr = kwiscivConfitvlwr;
	}
	public String getKwiscivConfitvlps() {
		return kwiscivConfitvlps;
	}
	public void setKwiscivConfitvlps(String kwiscivConfitvlps) {
		this.kwiscivConfitvlps = kwiscivConfitvlps;
	}
	public String getKwiscivConfitvlalliq() {
		return kwiscivConfitvlalliq;
	}
	public void setKwiscivConfitvlalliq(String kwiscivConfitvlalliq) {
		this.kwiscivConfitvlalliq = kwiscivConfitvlalliq;
	}
	public String getKwisciv2Confitvllu() {
		return kwisciv2Confitvllu;
	}
	public void setKwisciv2Confitvllu(String kwisciv2Confitvllu) {
		this.kwisciv2Confitvllu = kwisciv2Confitvllu;
	}
	public String getKwisciv2Confitvlpr() {
		return kwisciv2Confitvlpr;
	}
	public void setKwisciv2Confitvlpr(String kwisciv2Confitvlpr) {
		this.kwisciv2Confitvlpr = kwisciv2Confitvlpr;
	}
	public String getKwisciv2Confitvlwr() {
		return kwisciv2Confitvlwr;
	}
	public void setKwisciv2Confitvlwr(String kwisciv2Confitvlwr) {
		this.kwisciv2Confitvlwr = kwisciv2Confitvlwr;
	}
	public String getKwisciv2Confitvlps() {
		return kwisciv2Confitvlps;
	}
	public void setKwisciv2Confitvlps(String kwisciv2Confitvlps) {
		this.kwisciv2Confitvlps = kwisciv2Confitvlps;
	}
	public String getKwisciv2Confitvlalliq() {
		return kwisciv2Confitvlalliq;
	}
	public void setKwisciv2Confitvlalliq(String kwisciv2Confitvlalliq) {
		this.kwisciv2Confitvlalliq = kwisciv2Confitvlalliq;
	}


	
	public String getKwisciv2Esadlu() {
		return kwisciv2Esadlu;
	}
	public void setKwisciv2Esadlu(String kwisciv2Esadlu) {
		this.kwisciv2Esadlu = kwisciv2Esadlu;
	}
	public String getKwisciv2Esadpr() {
		return kwisciv2Esadpr;
	}
	public void setKwisciv2Esadpr(String kwisciv2Esadpr) {
		this.kwisciv2Esadpr = kwisciv2Esadpr;
	}
	public String getKwisciv2Esadwr() {
		return kwisciv2Esadwr;
	}
	public void setKwisciv2Esadwr(String kwisciv2Esadwr) {
		this.kwisciv2Esadwr = kwisciv2Esadwr;
	}
	public String getKwisciv2Esadps() {
		return kwisciv2Esadps;
	}
	public void setKwisciv2Esadps(String kwisciv2Esadps) {
		this.kwisciv2Esadps = kwisciv2Esadps;
	}
	public String getKwisciv2Esadalliq() {
		return kwisciv2Esadalliq;
	}
	public void setKwisciv2Esadalliq(String kwisciv2Esadalliq) {
		this.kwisciv2Esadalliq = kwisciv2Esadalliq;
	}
	
}



