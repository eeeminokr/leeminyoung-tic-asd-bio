package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCbc15VO;

public class SurveyAsdCbc15CellReaderMapper implements CellReaderMapper<SurveyAsdCbc15VO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdCbc15VO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdCbc15VO surveyAsdCbc15VO = new SurveyAsdCbc15VO();
		try {
			surveyAsdCbc15VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdCbc15VO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdCbc15VO.setCbc15ExecDate(execDate.replace("-", ""));
		      surveyAsdCbc15VO.setcPcsTts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
				surveyAsdCbc15VO.setcPcsTin2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));	
				surveyAsdCbc15VO.setcPcsTout3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsTemoRact4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsTdeLow5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsTps6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsTshr7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsTsp8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsTafp9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsTatp10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
				surveyAsdCbc15VO.setcPcsTetc11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	//    
	      surveyAsdCbc15VO.setcPcsPcntts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));
				surveyAsdCbc15VO.setcPcsPcntin2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
				surveyAsdCbc15VO.setcPcsPcntout3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsPcntemoRact4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsPcntdeLow5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsPcntps6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsPcntshr7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsPcntsp8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsPcntafp9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsPcntatp10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
				surveyAsdCbc15VO.setcPcsPcntetc11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	//     
	      surveyAsdCbc15VO.setcPcsSts1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));
				surveyAsdCbc15VO.setcPcsSin2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
				surveyAsdCbc15VO.setcPcsSout3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsSemoRact4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsSdeLow5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsSps6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsSshr7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsSsp8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsSafp9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));		
				surveyAsdCbc15VO.setcPcsSatp10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	
				surveyAsdCbc15VO.setcPcsSetc11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	//
	      surveyAsdCbc15VO.setcDsmTemop1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("","")); 
				surveyAsdCbc15VO.setcDsmTdep2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmTdevlp3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmTadhd4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmToppbhv5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	//
	      surveyAsdCbc15VO.setcDsmPcntemop1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("","")); 
				surveyAsdCbc15VO.setcDsmPcntdep2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmPcntdevlp3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmPcntadhd4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmPcntoppbhv5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));	//
	      surveyAsdCbc15VO.setcDsmSemop1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("","")); 
				surveyAsdCbc15VO.setcDsmSdep2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmSdevlp3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmSadhd4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));	
				surveyAsdCbc15VO.setcDsmSoppbhv5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));	//
	      surveyAsdCbc15VO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));
				surveyAsdCbc15VO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));	
				surveyAsdCbc15VO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));		
				surveyAsdCbc15VO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));		
				surveyAsdCbc15VO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));		
				surveyAsdCbc15VO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));		
				surveyAsdCbc15VO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));		
				surveyAsdCbc15VO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));		
				surveyAsdCbc15VO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));		
				surveyAsdCbc15VO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));	
				surveyAsdCbc15VO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));	
				surveyAsdCbc15VO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));	
				surveyAsdCbc15VO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));	
				surveyAsdCbc15VO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));	
				surveyAsdCbc15VO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));	
				surveyAsdCbc15VO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));	
				surveyAsdCbc15VO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));	
				surveyAsdCbc15VO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));			
				surveyAsdCbc15VO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));		
				surveyAsdCbc15VO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));	
				surveyAsdCbc15VO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));	
				surveyAsdCbc15VO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));	
				surveyAsdCbc15VO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));	
				surveyAsdCbc15VO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));
				surveyAsdCbc15VO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));
				surveyAsdCbc15VO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));
				surveyAsdCbc15VO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));
				surveyAsdCbc15VO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));
				surveyAsdCbc15VO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));
				surveyAsdCbc15VO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));
				surveyAsdCbc15VO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));
				surveyAsdCbc15VO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));
				surveyAsdCbc15VO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));
				surveyAsdCbc15VO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));
				surveyAsdCbc15VO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));
				surveyAsdCbc15VO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));
				surveyAsdCbc15VO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));
				surveyAsdCbc15VO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));
				surveyAsdCbc15VO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));
				surveyAsdCbc15VO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));
				surveyAsdCbc15VO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));
				surveyAsdCbc15VO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));
				surveyAsdCbc15VO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));
				surveyAsdCbc15VO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));
				surveyAsdCbc15VO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));
				surveyAsdCbc15VO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));
				surveyAsdCbc15VO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));
				surveyAsdCbc15VO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));
				surveyAsdCbc15VO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));
				surveyAsdCbc15VO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));
				surveyAsdCbc15VO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));
				surveyAsdCbc15VO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));
				surveyAsdCbc15VO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));
				surveyAsdCbc15VO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));
				surveyAsdCbc15VO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));
				surveyAsdCbc15VO.setA56(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));
				surveyAsdCbc15VO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));
				surveyAsdCbc15VO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("",""));
				surveyAsdCbc15VO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("",""));
				surveyAsdCbc15VO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("",""));
				surveyAsdCbc15VO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("",""));
				surveyAsdCbc15VO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("",""));
				surveyAsdCbc15VO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("",""));
				surveyAsdCbc15VO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("",""));
				surveyAsdCbc15VO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("",""));
				surveyAsdCbc15VO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("",""));
				surveyAsdCbc15VO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("",""));
				surveyAsdCbc15VO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("",""));
				surveyAsdCbc15VO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("",""));
				surveyAsdCbc15VO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("",""));
				surveyAsdCbc15VO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("",""));
				surveyAsdCbc15VO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("",""));
				surveyAsdCbc15VO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("",""));
				surveyAsdCbc15VO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("",""));
				surveyAsdCbc15VO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("",""));
				surveyAsdCbc15VO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("",""));
				surveyAsdCbc15VO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("",""));
				surveyAsdCbc15VO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("",""));
				surveyAsdCbc15VO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("",""));
				surveyAsdCbc15VO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("",""));
				surveyAsdCbc15VO.setA81(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("",""));
				surveyAsdCbc15VO.setA82(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("",""));
				surveyAsdCbc15VO.setA83(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("",""));
				surveyAsdCbc15VO.setA84(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("",""));
				surveyAsdCbc15VO.setA85(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("",""));
				surveyAsdCbc15VO.setA86(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("",""));
				surveyAsdCbc15VO.setA87(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("",""));
				surveyAsdCbc15VO.setA88(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("",""));
				surveyAsdCbc15VO.setA89(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("",""));
				surveyAsdCbc15VO.setA90(POIUtil.getStringCellValue(sheet.getRow(row).getCell(141)).trim().replace("",""));
				surveyAsdCbc15VO.setA91(POIUtil.getStringCellValue(sheet.getRow(row).getCell(142)).trim().replace("",""));
				surveyAsdCbc15VO.setA92(POIUtil.getStringCellValue(sheet.getRow(row).getCell(143)).trim().replace("",""));
				surveyAsdCbc15VO.setA93(POIUtil.getStringCellValue(sheet.getRow(row).getCell(144)).trim().replace("",""));
				surveyAsdCbc15VO.setA94(POIUtil.getStringCellValue(sheet.getRow(row).getCell(145)).trim().replace("",""));
				surveyAsdCbc15VO.setA95(POIUtil.getStringCellValue(sheet.getRow(row).getCell(146)).trim().replace("",""));
				surveyAsdCbc15VO.setA96(POIUtil.getStringCellValue(sheet.getRow(row).getCell(147)).trim().replace("",""));
				surveyAsdCbc15VO.setA97(POIUtil.getStringCellValue(sheet.getRow(row).getCell(148)).trim().replace("",""));
				surveyAsdCbc15VO.setA98(POIUtil.getStringCellValue(sheet.getRow(row).getCell(149)).trim().replace("",""));
				surveyAsdCbc15VO.setA99(POIUtil.getStringCellValue(sheet.getRow(row).getCell(150)).trim().replace("",""));
			    surveyAsdCbc15VO.setA100(POIUtil.getStringCellValue(sheet.getRow(row).getCell(151)).trim().replace("",""));
			    surveyAsdCbc15VO.setA101(POIUtil.getStringCellValue(sheet.getRow(row).getCell(152)).trim().replace("",""));
			    surveyAsdCbc15VO.setA102(POIUtil.getStringCellValue(sheet.getRow(row).getCell(153)).trim().replace("",""));
			    surveyAsdCbc15VO.setA103(POIUtil.getStringCellValue(sheet.getRow(row).getCell(154)).trim().replace("",""));
			    surveyAsdCbc15VO.setCreateBy("excel_upload");
			    surveyAsdCbc15VO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdCbc15VO;
	}
}
