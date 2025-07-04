package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCbcl2VO;

public class SurveyAsdCbcl2CellReaderMapper implements CellReaderMapper<SurveyAsdCbcl2VO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdCbcl2VO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdCbcl2VO surveyAsdCbcl2VO = new SurveyAsdCbcl2VO();
		try {
			surveyAsdCbcl2VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdCbcl2VO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdCbcl2VO.setCbclExecDate(execDate.replace("-", ""));
			surveyAsdCbcl2VO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdCbcl2VO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdCbcl2VO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyAsdCbcl2VO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));
			surveyAsdCbcl2VO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));
			surveyAsdCbcl2VO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));
			surveyAsdCbcl2VO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));
			surveyAsdCbcl2VO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));
			surveyAsdCbcl2VO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));
			surveyAsdCbcl2VO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));
			surveyAsdCbcl2VO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));
			surveyAsdCbcl2VO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));
			surveyAsdCbcl2VO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));
			surveyAsdCbcl2VO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));
			surveyAsdCbcl2VO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));
			surveyAsdCbcl2VO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));
			surveyAsdCbcl2VO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));
			surveyAsdCbcl2VO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));
			surveyAsdCbcl2VO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));
			surveyAsdCbcl2VO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));
			surveyAsdCbcl2VO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));
			surveyAsdCbcl2VO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));
			surveyAsdCbcl2VO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));
			surveyAsdCbcl2VO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));
			surveyAsdCbcl2VO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));
			surveyAsdCbcl2VO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));
			surveyAsdCbcl2VO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));
			surveyAsdCbcl2VO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));
			surveyAsdCbcl2VO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));
			surveyAsdCbcl2VO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));
			surveyAsdCbcl2VO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));
			surveyAsdCbcl2VO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));
			surveyAsdCbcl2VO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));
			surveyAsdCbcl2VO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));
			surveyAsdCbcl2VO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));
			surveyAsdCbcl2VO.setA56(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));
			surveyAsdCbcl2VO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));
			surveyAsdCbcl2VO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));
			surveyAsdCbcl2VO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));
			surveyAsdCbcl2VO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));
			surveyAsdCbcl2VO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));
			surveyAsdCbcl2VO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));
			surveyAsdCbcl2VO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));
			surveyAsdCbcl2VO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));
			surveyAsdCbcl2VO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));
			surveyAsdCbcl2VO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));
			surveyAsdCbcl2VO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));
			surveyAsdCbcl2VO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));
			surveyAsdCbcl2VO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));
			surveyAsdCbcl2VO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));
			surveyAsdCbcl2VO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));
			surveyAsdCbcl2VO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));
			surveyAsdCbcl2VO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));
			surveyAsdCbcl2VO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));
			surveyAsdCbcl2VO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));
			surveyAsdCbcl2VO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));
			surveyAsdCbcl2VO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));
			surveyAsdCbcl2VO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));
			surveyAsdCbcl2VO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));
			surveyAsdCbcl2VO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));
			surveyAsdCbcl2VO.setA81(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));
			surveyAsdCbcl2VO.setA82(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));
			surveyAsdCbcl2VO.setA83(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));
			surveyAsdCbcl2VO.setA84(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));
			surveyAsdCbcl2VO.setA85(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));
			surveyAsdCbcl2VO.setA86(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));
			surveyAsdCbcl2VO.setA87(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));
			surveyAsdCbcl2VO.setA88(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));
			surveyAsdCbcl2VO.setA89(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));
			surveyAsdCbcl2VO.setA90(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));
			surveyAsdCbcl2VO.setA91(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));
			surveyAsdCbcl2VO.setA92(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));
			surveyAsdCbcl2VO.setA93(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));
			surveyAsdCbcl2VO.setA94(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));
			surveyAsdCbcl2VO.setA95(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));
			surveyAsdCbcl2VO.setA96(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));
			surveyAsdCbcl2VO.setA97(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));
			surveyAsdCbcl2VO.setA98(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));
			surveyAsdCbcl2VO.setA99(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));
			surveyAsdCbcl2VO.setA100(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));
			surveyAsdCbcl2VO.setA101(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));
			surveyAsdCbcl2VO.setA102(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));
			surveyAsdCbcl2VO.setA103(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));
			surveyAsdCbcl2VO.setA104(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));
			surveyAsdCbcl2VO.setA105(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));
			surveyAsdCbcl2VO.setA106(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("",""));
			surveyAsdCbcl2VO.setA107(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("",""));
			surveyAsdCbcl2VO.setA108(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("",""));
			surveyAsdCbcl2VO.setA109(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("",""));
			surveyAsdCbcl2VO.setA110(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("",""));
			surveyAsdCbcl2VO.setA111(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("",""));
			surveyAsdCbcl2VO.setA112(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("",""));
			surveyAsdCbcl2VO.setA113(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("",""));
			surveyAsdCbcl2VO.setA114(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("",""));
			surveyAsdCbcl2VO.setA115(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("",""));
			surveyAsdCbcl2VO.setA116(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("",""));
			surveyAsdCbcl2VO.setA117(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("",""));
			surveyAsdCbcl2VO.setA118(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("",""));
			surveyAsdCbcl2VO.setA119(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("",""));
			surveyAsdCbcl2VO.setA120(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("",""));
			surveyAsdCbcl2VO.setA121(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("",""));
			surveyAsdCbcl2VO.setA122(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("",""));
			surveyAsdCbcl2VO.setA123(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("",""));
			surveyAsdCbcl2VO.setA124(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("",""));
			surveyAsdCbcl2VO.setA125(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("",""));
			surveyAsdCbcl2VO.setA126(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("",""));
			surveyAsdCbcl2VO.setA127(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("",""));
			surveyAsdCbcl2VO.setA128(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("",""));
			surveyAsdCbcl2VO.setA129(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("",""));
			surveyAsdCbcl2VO.setA130(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("",""));
			surveyAsdCbcl2VO.setA131(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("",""));
			surveyAsdCbcl2VO.setA132(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("",""));
			surveyAsdCbcl2VO.setA133(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("",""));
			surveyAsdCbcl2VO.setA134(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("",""));
			surveyAsdCbcl2VO.setA135(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("",""));
			surveyAsdCbcl2VO.setA136(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("",""));
			surveyAsdCbcl2VO.setA137(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("",""));
			surveyAsdCbcl2VO.setA138(POIUtil.getStringCellValue(sheet.getRow(row).getCell(141)).trim().replace("",""));
			surveyAsdCbcl2VO.setA139(POIUtil.getStringCellValue(sheet.getRow(row).getCell(142)).trim().replace("",""));
			surveyAsdCbcl2VO.setA140(POIUtil.getStringCellValue(sheet.getRow(row).getCell(143)).trim().replace("",""));
			surveyAsdCbcl2VO.setA141(POIUtil.getStringCellValue(sheet.getRow(row).getCell(144)).trim().replace("",""));
			surveyAsdCbcl2VO.setA142(POIUtil.getStringCellValue(sheet.getRow(row).getCell(145)).trim().replace("",""));
			surveyAsdCbcl2VO.setA143(POIUtil.getStringCellValue(sheet.getRow(row).getCell(146)).trim().replace("",""));
			surveyAsdCbcl2VO.setA144(POIUtil.getStringCellValue(sheet.getRow(row).getCell(147)).trim().replace("",""));
			surveyAsdCbcl2VO.setA145(POIUtil.getStringCellValue(sheet.getRow(row).getCell(148)).trim().replace("",""));
			surveyAsdCbcl2VO.setA146(POIUtil.getStringCellValue(sheet.getRow(row).getCell(149)).trim().replace("",""));
			surveyAsdCbcl2VO.setA147(POIUtil.getStringCellValue(sheet.getRow(row).getCell(150)).trim().replace("",""));

			surveyAsdCbcl2VO.setCreateBy("excel_upload");
			surveyAsdCbcl2VO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdCbcl2VO;
	}
}
