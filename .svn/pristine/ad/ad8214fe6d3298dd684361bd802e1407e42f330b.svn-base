package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdOldCbclVO;

public class SurveyAsdOldCbclCellReaderMapper implements CellReaderMapper<SurveyAsdOldCbclVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdOldCbclVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		
		SurveyAsdOldCbclVO SurveyAsdOldCbclVO = new SurveyAsdOldCbclVO();
		try {
			SurveyAsdOldCbclVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			SurveyAsdOldCbclVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			SurveyAsdOldCbclVO.setOldCbclExecDate(execDate.replace("-", ""));
			
		        SurveyAsdOldCbclVO.setCs1(POIUtil.getStringCellValue(sheet.getRow(row). getCell(4)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs2(POIUtil.getStringCellValue(sheet.getRow(row). getCell(5)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs3(POIUtil.getStringCellValue(sheet.getRow(row). getCell(6)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs4(POIUtil.getStringCellValue(sheet.getRow(row). getCell(7)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs5(POIUtil.getStringCellValue(sheet.getRow(row). getCell(8)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs6(POIUtil.getStringCellValue(sheet.getRow(row). getCell(9)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs7(POIUtil.getStringCellValue(sheet.getRow(row). getCell(10)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs8(POIUtil.getStringCellValue(sheet.getRow(row). getCell(11)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs9(POIUtil.getStringCellValue(sheet.getRow(row). getCell(12)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));
				SurveyAsdOldCbclVO.setCs13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("","")); //
			
				SurveyAsdOldCbclVO.setcPcnt1(POIUtil.getStringCellValue(sheet.getRow(row). getCell(17)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt2(POIUtil.getStringCellValue(sheet.getRow(row). getCell(18)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt3(POIUtil.getStringCellValue(sheet.getRow(row). getCell(19)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt4(POIUtil.getStringCellValue(sheet.getRow(row). getCell(20)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt5(POIUtil.getStringCellValue(sheet.getRow(row). getCell(21)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt6(POIUtil.getStringCellValue(sheet.getRow(row). getCell(22)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt7(POIUtil.getStringCellValue(sheet.getRow(row). getCell(23)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt8(POIUtil.getStringCellValue(sheet.getRow(row). getCell(24)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt9(POIUtil.getStringCellValue(sheet.getRow(row). getCell(25)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcPcnt13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("","")); //	
				
				SurveyAsdOldCbclVO.setcTs1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));
				SurveyAsdOldCbclVO.setcTs13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	//	                                                                                
				
				SurveyAsdOldCbclVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56a(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56b(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56c(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56d(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56e(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56f(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56g(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA56h(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA81(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA82(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA83(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA84(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA85(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA86(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA87(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA88(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA89(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA90(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA91(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA92(POIUtil.getStringCellValue(sheet.getRow(row).getCell(141)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA93(POIUtil.getStringCellValue(sheet.getRow(row).getCell(142)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA94(POIUtil.getStringCellValue(sheet.getRow(row).getCell(143)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA95(POIUtil.getStringCellValue(sheet.getRow(row).getCell(144)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA96(POIUtil.getStringCellValue(sheet.getRow(row).getCell(145)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA97(POIUtil.getStringCellValue(sheet.getRow(row).getCell(146)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA98(POIUtil.getStringCellValue(sheet.getRow(row).getCell(147)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA99(POIUtil.getStringCellValue(sheet.getRow(row).getCell(148)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA100(POIUtil.getStringCellValue(sheet.getRow(row).getCell(149)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA101(POIUtil.getStringCellValue(sheet.getRow(row).getCell(150)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA102(POIUtil.getStringCellValue(sheet.getRow(row).getCell(151)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA103(POIUtil.getStringCellValue(sheet.getRow(row).getCell(152)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA104(POIUtil.getStringCellValue(sheet.getRow(row).getCell(153)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA105(POIUtil.getStringCellValue(sheet.getRow(row).getCell(154)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA106(POIUtil.getStringCellValue(sheet.getRow(row).getCell(155)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA107(POIUtil.getStringCellValue(sheet.getRow(row).getCell(156)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA108(POIUtil.getStringCellValue(sheet.getRow(row).getCell(157)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA109(POIUtil.getStringCellValue(sheet.getRow(row).getCell(158)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA110(POIUtil.getStringCellValue(sheet.getRow(row).getCell(159)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA111(POIUtil.getStringCellValue(sheet.getRow(row).getCell(160)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA112(POIUtil.getStringCellValue(sheet.getRow(row).getCell(161)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA113(POIUtil.getStringCellValue(sheet.getRow(row).getCell(162)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA114(POIUtil.getStringCellValue(sheet.getRow(row).getCell(163)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA115(POIUtil.getStringCellValue(sheet.getRow(row).getCell(164)).trim().replace("",""));
				SurveyAsdOldCbclVO.setA116(POIUtil.getStringCellValue(sheet.getRow(row).getCell(165)).trim().replace("",""));

			SurveyAsdOldCbclVO.setCreateBy("excel_upload");
			SurveyAsdOldCbclVO.setUpdateBy("excel_upload");
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
		return SurveyAsdOldCbclVO;
	}
}
