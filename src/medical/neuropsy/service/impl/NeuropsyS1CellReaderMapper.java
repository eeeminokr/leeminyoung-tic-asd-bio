package medical.neuropsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.neuropsy.service.NeuropsyS1VO;


public class NeuropsyS1CellReaderMapper implements CellReaderMapper<NeuropsyS1VO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyS1VO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyS1VO NeuropsyS1VO = new NeuropsyS1VO();	
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
					NeuropsyS1VO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					NeuropsyS1VO.setPerformExecDate("#");
				}else {
					NeuropsyS1VO.setPerformExecDate(execDate2.replace("-", ""));
				}
			}
			
			NeuropsyS1VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			NeuropsyS1VO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'",""));
//			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
//			NeuropsyS1VO.set(execDate.replace("-", "")); //ksads 실시일
			NeuropsyS1VO.setTicSubtype(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'",""));
			
			NeuropsyS1VO.setS1ExecDate(execDate2.replace("-", ""));	
			NeuropsyS1VO.setFsiq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisVocaOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisArithOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisOrderOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisPieceOs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisVocaEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisArithEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisOrderEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			NeuropsyS1VO.setKediwaisPieceEs(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivCos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivVos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivUos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivPos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivCpos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivMos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivNos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivScos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivSos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivStos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivCes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivVes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivUes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivPes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivCpes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivMes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivNes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivSces(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivSes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivStes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivSios(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivVcos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivInos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivBdos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivMros(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivVpos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivDsos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivAros(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivSsos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivCdos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivSies(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivVces(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivInes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivBdes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivMres(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivVpes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivDses(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivAres(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivSses(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("'",""));
			NeuropsyS1VO.setKwiscivCdes(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsBlues(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAnger(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsLossm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsDeath(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSuicide(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSuiSeverity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSuiCriticality(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSelfharm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsUplift(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsDecSleep(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsGoalActivity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsGallop(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsHallucination(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsDelusion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsPanic(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSeparationFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAttachFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsRejectSchool(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSleepFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAloneFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAtrophy(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSituationFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsPain(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAvoid(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsFutureWorry(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsBodyComplain(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsSelfConsious(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsTension(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsComplusiveAct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsComplusiveThink(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsPeeNight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsPeeDay(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsPeeTotal(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsShitNight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsShitDay(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsShitTotal(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsFatFear(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsLowWeight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsWeightLoss(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsVoracity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAdhdCf(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAdhdEd(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAdhdSf(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsAdhdImpulsivity(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsOddAngry(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsOddAa(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsOddNotrules(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsCdLie(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsCdTruancy(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsCdFight(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsCdTorment(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsCdThievery(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsExerciseTic(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("'",""));
			NeuropsyS1VO.setKsadsExerciseVoice(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("'",""));
			NeuropsyS1VO.setGas(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq1Mistake(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq2Notlisten(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq3FollowDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq4ArrangeDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq5AssignAvoid(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq6LostItem(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq7Forgetfulness(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq8Unrest(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq9Overrun(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq10EndlessAct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq11SilentDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq12SuddenAns(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq13WaitDiff(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq14Interrupt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq15Fickle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq16Chatter(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("'",""));
			NeuropsyS1VO.setAdhdrq17DangerAct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("'",""));
			NeuropsyS1VO.setDiagnosis(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("'",""));
			NeuropsyS1VO.setDiagnosisEtc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic4Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic4Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic5Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic5Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic6Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic6Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic7Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic7Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(141)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic8Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(142)).trim().replace("'",""));
			NeuropsyS1VO.setSactTic8Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(143)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(144)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(145)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(146)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(147)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(148)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(149)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic4Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(150)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic4Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(151)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic5Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(152)).trim().replace("'",""));
			NeuropsyS1VO.setCactTic5Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(153)).trim().replace("'",""));
			NeuropsyS1VO.setSvoiceTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(154)).trim().replace("'",""));
			NeuropsyS1VO.setSvoiceTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(155)).trim().replace("'",""));
			NeuropsyS1VO.setSvoiceTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(156)).trim().replace("'",""));
			NeuropsyS1VO.setSvoiceTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(157)).trim().replace("'",""));
			NeuropsyS1VO.setSvoiceTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(158)).trim().replace("'",""));
			NeuropsyS1VO.setSvoiceTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(159)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic1Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(160)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic1Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(161)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic2Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(162)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic2Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(163)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic3Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(164)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic3Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(165)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic4Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(166)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic4Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(167)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic5Ce(POIUtil.getStringCellValue(sheet.getRow(row).getCell(168)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic5Msp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(169)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic6aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(170)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic6aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(171)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic6bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(172)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic6bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(173)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic6cCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(174)).trim().replace("'",""));
			NeuropsyS1VO.setCvoiceTic6cMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(175)).trim().replace("'",""));
			NeuropsyS1VO.setTourette7aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(176)).trim().replace("'",""));
			NeuropsyS1VO.setTourette7aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(177)).trim().replace("'",""));
			NeuropsyS1VO.setTourette7bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(178)).trim().replace("'",""));
			NeuropsyS1VO.setTourette7bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(179)).trim().replace("'",""));
			NeuropsyS1VO.setChronicTic8aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(180)).trim().replace("'",""));
			NeuropsyS1VO.setChronicTic8aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(181)).trim().replace("'",""));
			NeuropsyS1VO.setChronicTic8bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(182)).trim().replace("'",""));
			NeuropsyS1VO.setChronicTic8bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(183)).trim().replace("'",""));
			NeuropsyS1VO.setDailyTic9aCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(184)).trim().replace("'",""));
			NeuropsyS1VO.setDailyTic9aMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(185)).trim().replace("'",""));
			NeuropsyS1VO.setDailyTic9bCe(POIUtil.getStringCellValue(sheet.getRow(row).getCell(186)).trim().replace("'",""));
			NeuropsyS1VO.setDailyTic9bMsp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(187)).trim().replace("'",""));
			NeuropsyS1VO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(188)).trim().replace("'",""));
			NeuropsyS1VO.setCreateBy("excel_upload");
			NeuropsyS1VO.setUpdateBy("excel_upload");
			
			
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
		return NeuropsyS1VO;
	}
}
