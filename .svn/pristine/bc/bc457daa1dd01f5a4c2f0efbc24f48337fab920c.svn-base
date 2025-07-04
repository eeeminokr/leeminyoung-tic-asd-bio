package medical.clinician.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import medical.clinician.service.ClinicianS1VO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;



public class ClinicianS1CellReaderMapper implements CellReaderMapper<ClinicianS1VO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public ClinicianS1VO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		ClinicianS1VO clinicianS1VO = new ClinicianS1VO();	
		Row sheetRow;
		try{
			//데이터 여부 체크
			boolean dataCheck = true;
			String execDate2 = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","");
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=3; i<188; i++) {
				str = POIUtil.getStringCellValue(sheet.getRow(row).getCell(i)).trim().replace("'","");
				strList.add(str);
				
				if(!"".equals(str) && !"x".equals(str) && !"X".equals(str)){
					dataCheck = false;
				}
			}
			if(dataCheck) {
				Cell cell;
				sheetRow =sheet.getRow(row);
				for(int i=3; i<188; i++) {
					
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			if(!"".equals(execDate2) || execDate2 == null) {
				if(dataCheck || strList.contains("") || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					clinicianS1VO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					clinicianS1VO.setPerformExecDate("#");
				}else {
					clinicianS1VO.setPerformExecDate(execDate2.replace("-", ""));
				}
			}
			
			clinicianS1VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
		//	clinicianS1VO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'",""));
			clinicianS1VO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
//			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
//			clinicianS1VO.set(execDate.replace("-", "")); //ksads 실시일
			//clinicianS1VO.setTicSubtype(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'",""));
			
			clinicianS1VO.setS1ExecDate(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).replace("-", ""));	
			clinicianS1VO.setEnrollAge(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			//clinicianS1VO.setS1ExecDate(execDate2.replace("-", ""));	
			//clinicianS1VO.setFsiq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			
			clinicianS1VO.setKsadsBlues(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			clinicianS1VO.setKsadsAnger(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			clinicianS1VO.setKsadsLossm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			clinicianS1VO.setKsadsDeath(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			clinicianS1VO.setKsadsSuicide(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			clinicianS1VO.setKsadsSuiSeverity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			clinicianS1VO.setKsadsSuiCriticality(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			clinicianS1VO.setKsadsSelfharm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			clinicianS1VO.setKsadsUplift(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			clinicianS1VO.setKsadsDecSleep(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			clinicianS1VO.setKsadsGoalActivity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			clinicianS1VO.setKsadsGallop(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			clinicianS1VO.setKsadsHallucination(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			clinicianS1VO.setKsadsDelusion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			clinicianS1VO.setKsadsPanic(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			clinicianS1VO.setKsadsSeparationFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'",""));
			clinicianS1VO.setKsadsAttachFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("'",""));
			clinicianS1VO.setKsadsRejectSchool(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("'",""));
			clinicianS1VO.setKsadsSleepFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("'",""));
			clinicianS1VO.setKsadsAloneFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("'",""));
			clinicianS1VO.setKsadsAtrophy(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("'",""));
			clinicianS1VO.setKsadsSituationFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("'",""));
			clinicianS1VO.setKsadsPain(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("'",""));
			clinicianS1VO.setKsadsAvoid(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("'",""));
			clinicianS1VO.setKsadsFutureWorry(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("'",""));
			clinicianS1VO.setKsadsBodyComplain(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("'",""));
			clinicianS1VO.setKsadsSelfConsious(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("'",""));
			clinicianS1VO.setKsadsTension(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("'",""));
			clinicianS1VO.setKsadsComplusiveAct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("'",""));
			clinicianS1VO.setKsadsComplusiveThink(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("'",""));
			clinicianS1VO.setKsadsPeeNight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("'",""));
			clinicianS1VO.setKsadsPeeDay(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("'",""));
			clinicianS1VO.setKsadsPeeTotal(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("'",""));
			clinicianS1VO.setKsadsShitNight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("'",""));
			clinicianS1VO.setKsadsShitDay(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("'",""));
			clinicianS1VO.setKsadsShitTotal(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("'",""));
			clinicianS1VO.setKsadsFatFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("'",""));
			clinicianS1VO.setKsadsLowWeight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("'",""));
			clinicianS1VO.setKsadsWeightLoss(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("'",""));
			clinicianS1VO.setKsadsVoracity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("'",""));
			clinicianS1VO.setKsadsAdhdCf(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("'",""));
			clinicianS1VO.setKsadsAdhdEd(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("'",""));
			clinicianS1VO.setKsadsAdhdSf(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("'",""));
			clinicianS1VO.setKsadsAdhdImpulsivity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("'",""));
			clinicianS1VO.setKsadsOddAngry(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("'",""));
			clinicianS1VO.setKsadsOddAa(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("'",""));
			clinicianS1VO.setKsadsOddNotrules(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("'",""));
			clinicianS1VO.setKsadsCdLie(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("'",""));
			clinicianS1VO.setKsadsCdTruancy(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("'",""));
			clinicianS1VO.setKsadsCdFight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("'",""));
			clinicianS1VO.setKsadsCdTorment(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("'",""));
			clinicianS1VO.setKsadsCdThievery(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("'",""));
			clinicianS1VO.setKsadsExerciseTic(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("'",""));
			clinicianS1VO.setKsadsExerciseVoice(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("'",""));
			clinicianS1VO.setGas(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq1Mistake(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq2Notlisten(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq3FollowDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq4ArrangeDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq5AssignAvoid(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq6LostItem(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq7Forgetfulness(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq8Unrest(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq9Overrun(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq10EndlessAct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq11SilentDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq12SuddenAns(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq13WaitDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq14Interrupt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq15Fickle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq16Chatter(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("'",""));
			clinicianS1VO.setAdhdrq17DangerAct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("'",""));
			clinicianS1VO.setDiagnosis(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("'",""));
			clinicianS1VO.setDiagnosisEtc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("'",""));
			
			
			clinicianS1VO.setExctAllIntell(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("'",""));
			clinicianS1VO.setExctShortIntell(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("'",""));
			clinicianS1VO.setExctFluidInfer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("'",""));
			clinicianS1VO.setExctBasicVisual(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("'",""));
		
			clinicianS1VO.setIcidAllIntell(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("'",""));
			clinicianS1VO.setIcidShortIntell(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("'",""));
			clinicianS1VO.setIcidFluidInfer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("'",""));
			clinicianS1VO.setIcidBasicVisual(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("'",""));
			
	   	clinicianS1VO.setVifsForeBack(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("'",""));
	  	clinicianS1VO.setVifsShapeComp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("'",""));
			clinicianS1VO.setVifsMatch(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("'",""));
			clinicianS1VO.setVifsOrderInfer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("'",""));
			clinicianS1VO.setVifsPattFind(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("'",""));
			clinicianS1VO.setVifsDrawInfer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("'",""));
			clinicianS1VO.setVifsCategoriz(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("'",""));
			
			clinicianS1VO.setViexcForeBack(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("'",""));
			clinicianS1VO.setViexcShapeComp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("'",""));
			clinicianS1VO.setViexcMatch(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("'",""));
			clinicianS1VO.setViexcOrderInfer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("'",""));
			clinicianS1VO.setViexcPattFind(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("'",""));
			clinicianS1VO.setViexcDrawInfer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("'",""));
			clinicianS1VO.setViexcCategoriz(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("'",""));
		
			clinicianS1VO.setCexcMemorySelect(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("'",""));
			clinicianS1VO.setCexcRecogMemory(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("'",""));
			
			clinicianS1VO.setCcompMemorySelect(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("'",""));
			clinicianS1VO.setCcompRecogMemory(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("'",""));
			
			clinicianS1VO.setScPairAsso(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("'",""));
			clinicianS1VO.setScImmedRecog(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("'",""));
			clinicianS1VO.setScImmedRemember(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("'",""));
			clinicianS1VO.setScSustainAtt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("'",""));
			clinicianS1VO.setScDelayRecog(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("'",""));
			
			clinicianS1VO.setExcPairAsso(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("'",""));
			clinicianS1VO.setExcImmedRecog(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("'",""));
			clinicianS1VO.setExcImmedRemember(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("'",""));
			clinicianS1VO.setExcSustainAtt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("'",""));
			clinicianS1VO.setExcDelayRecog(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("'",""));
			
			clinicianS1VO.setpRsCompsc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("'",""));
			clinicianS1VO.setpEcCompsc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("'",""));
			
			clinicianS1VO.setScAttention(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("'",""));
			clinicianS1VO.setScActivLevel(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("'",""));
			clinicianS1VO.setScImpuls(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("'",""));
			clinicianS1VO.setScAdaptability(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("'",""));
			clinicianS1VO.setScMoodConfid(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("'",""));
			clinicianS1VO.setScFeelEmo(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("'",""));
			clinicianS1VO.setScSociability(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("'",""));
			clinicianS1VO.setScControl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("'",""));
			
			clinicianS1VO.setExcAttention(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("'",""));
			clinicianS1VO.setExcActivLevel(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("'",""));
			clinicianS1VO.setExcImpuls(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("'",""));
			clinicianS1VO.setExcAdaptability(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("'",""));
			clinicianS1VO.setExcMoodConfid(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("'",""));
			clinicianS1VO.setExcFeelEmo(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("'",""));
			clinicianS1VO.setExcSociability(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("'",""));
			clinicianS1VO.setExcControl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("'",""));
			
			
			
	 		 clinicianS1VO.setKediwaisVocaOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("'",""));
			clinicianS1VO.setKediwaisArithOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("'",""));
			clinicianS1VO.setKediwaisOrderOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("'",""));
			clinicianS1VO.setKediwaisPieceOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("'",""));
			 clinicianS1VO.setKediwaisVocaEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("'",""));
			clinicianS1VO.setKediwaisArithEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("'",""));
			clinicianS1VO.setKediwaisOrderEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("'",""));
			clinicianS1VO.setKediwaisPieceEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("'",""));
					 clinicianS1VO.setKwiscivCos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(141)).trim().replace("'",""));
					 clinicianS1VO.setKwiscivVos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(142)).trim().replace("'",""));
					 clinicianS1VO.setKwiscivUos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(143)).trim().replace("'",""));
					 clinicianS1VO.setKwiscivPos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(144)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivCpos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(145)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivMos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(146)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivNos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(147)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivScos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(148)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivSos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(149)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivStos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(150)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivCes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(151)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivVes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(152)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivUes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(153)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivPes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(154)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivCpes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(155)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivMes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(156)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivNes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(157)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivSces(POIUtil.getStringCellValue(sheet.getRow(row).getCell(158)).trim().replace("'",""));
			     clinicianS1VO.setKwiscivSes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(159)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivStes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(160)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivSios(POIUtil.getStringCellValue(sheet.getRow(row).getCell(161)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivVcos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(162)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivInos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(163)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivBdos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(164)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivMros(POIUtil.getStringCellValue(sheet.getRow(row).getCell(165)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivVpos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(166)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivDsos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(167)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivAros(POIUtil.getStringCellValue(sheet.getRow(row).getCell(168)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivSsos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(169)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivCdos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(170)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivSies(POIUtil.getStringCellValue(sheet.getRow(row).getCell(171)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivVces(POIUtil.getStringCellValue(sheet.getRow(row).getCell(172)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivInes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(173)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivBdes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(174)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivMres(POIUtil.getStringCellValue(sheet.getRow(row).getCell(175)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivVpes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(176)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivDses(POIUtil.getStringCellValue(sheet.getRow(row).getCell(177)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivAres(POIUtil.getStringCellValue(sheet.getRow(row).getCell(178)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivSses(POIUtil.getStringCellValue(sheet.getRow(row).getCell(179)).trim().replace("'",""));
			    clinicianS1VO.setKwiscivCdes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(180)).trim().replace("'",""));
				clinicianS1VO.setCreateBy("excel_upload");
				clinicianS1VO.setUpdateBy("excel_upload");
			
			
		
			/*
			clinicianS1VO.setSactTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("'",""));
			clinicianS1VO.setSactTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("'",""));
			clinicianS1VO.setSactTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("'",""));
			clinicianS1VO.setSactTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("'",""));
			clinicianS1VO.setSactTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("'",""));
			clinicianS1VO.setSactTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("'",""));
			clinicianS1VO.setSactTic4Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("'",""));
			clinicianS1VO.setSactTic4Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("'",""));
			clinicianS1VO.setSactTic5Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("'",""));
			clinicianS1VO.setSactTic5Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("'",""));
			clinicianS1VO.setSactTic6Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("'",""));
			clinicianS1VO.setSactTic6Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("'",""));
			clinicianS1VO.setSactTic7Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("'",""));
			clinicianS1VO.setSactTic7Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(141)).trim().replace("'",""));
			clinicianS1VO.setSactTic8Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(142)).trim().replace("'",""));
			clinicianS1VO.setSactTic8Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(143)).trim().replace("'",""));
			clinicianS1VO.setCactTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(144)).trim().replace("'",""));
			clinicianS1VO.setCactTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(145)).trim().replace("'",""));
			clinicianS1VO.setCactTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(146)).trim().replace("'",""));
			clinicianS1VO.setCactTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(147)).trim().replace("'",""));
			clinicianS1VO.setCactTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(148)).trim().replace("'",""));
			clinicianS1VO.setCactTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(149)).trim().replace("'",""));
			clinicianS1VO.setCactTic4Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(150)).trim().replace("'",""));
			clinicianS1VO.setCactTic4Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(151)).trim().replace("'",""));
			clinicianS1VO.setCactTic5Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(152)).trim().replace("'",""));
			clinicianS1VO.setCactTic5Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(153)).trim().replace("'",""));
			clinicianS1VO.setSvoiceTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(154)).trim().replace("'",""));
			clinicianS1VO.setSvoiceTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(155)).trim().replace("'",""));
			clinicianS1VO.setSvoiceTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(156)).trim().replace("'",""));
			clinicianS1VO.setSvoiceTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(157)).trim().replace("'",""));
			clinicianS1VO.setSvoiceTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(158)).trim().replace("'",""));
			clinicianS1VO.setSvoiceTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(159)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(160)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(161)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(162)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(163)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(164)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(165)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic4Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(166)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic4Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(167)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic5Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(168)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic5Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(169)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic6aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(170)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic6aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(171)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic6bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(172)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic6bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(173)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic6cCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(174)).trim().replace("'",""));
			clinicianS1VO.setCvoiceTic6cMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(175)).trim().replace("'",""));
			clinicianS1VO.setTourette7aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(176)).trim().replace("'",""));
			clinicianS1VO.setTourette7aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(177)).trim().replace("'",""));
			clinicianS1VO.setTourette7bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(178)).trim().replace("'",""));
			clinicianS1VO.setTourette7bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(179)).trim().replace("'",""));
			clinicianS1VO.setChronicTic8aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(180)).trim().replace("'",""));
			clinicianS1VO.setChronicTic8aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(181)).trim().replace("'",""));
			clinicianS1VO.setChronicTic8bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(182)).trim().replace("'",""));
			clinicianS1VO.setChronicTic8bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(183)).trim().replace("'",""));
			clinicianS1VO.setDailyTic9aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(184)).trim().replace("'",""));
			clinicianS1VO.setDailyTic9aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(185)).trim().replace("'",""));
			clinicianS1VO.setDailyTic9bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(186)).trim().replace("'",""));
			clinicianS1VO.setDailyTic9bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(187)).trim().replace("'",""));
			clinicianS1VO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(188)).trim().replace("'",""));
			clinicianS1VO.setCreateBy("excel_upload");
			clinicianS1VO.setUpdateBy("excel_upload");
		*/	
			
		} catch(Exception e) {
			if(logger.isDebugEnabled()){
				logger.error("[Error Message] There is an Exception while mapping between cells and the object!!");
				logger.error("[Error Line] Col : " + col + ", Row : " + (row + 1) );
				logger.error("[Error Detail]");
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			throw new CellReaderMapperException("There is an Exception on CellMapper!!");
		}
		return clinicianS1VO;
	}
}
