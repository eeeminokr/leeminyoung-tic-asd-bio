package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyKpsiVO;

public class SurveyKpsiCellReaderMapper implements CellReaderMapper<SurveyKpsiVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyKpsiVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyKpsiVO surveyKpsiVO = new SurveyKpsiVO();
		
		try {
			surveyKpsiVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyKpsiVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyKpsiVO.setKpsiExecDate(execDate.replace("-", ""));
			surveyKpsiVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyKpsiVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyKpsiVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyKpsiVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyKpsiVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyKpsiVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyKpsiVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyKpsiVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyKpsiVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyKpsiVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	
			surveyKpsiVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));		
			surveyKpsiVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyKpsiVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		
			surveyKpsiVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));		
			surveyKpsiVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		
			surveyKpsiVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));		
			surveyKpsiVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));		
			surveyKpsiVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		
			surveyKpsiVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));		
			surveyKpsiVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));
			surveyKpsiVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));		
			surveyKpsiVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));		
			surveyKpsiVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));		
			surveyKpsiVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));		
			surveyKpsiVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));		
			surveyKpsiVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));		
			surveyKpsiVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		
			surveyKpsiVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));		
			surveyKpsiVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));		
			surveyKpsiVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
			surveyKpsiVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));		
			surveyKpsiVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));		
			surveyKpsiVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));		
			surveyKpsiVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));		
			surveyKpsiVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));		
			surveyKpsiVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));		
			surveyKpsiVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));		
			surveyKpsiVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));		
			surveyKpsiVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));		
			surveyKpsiVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	
			surveyKpsiVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));		
			surveyKpsiVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));		
			surveyKpsiVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));		
			surveyKpsiVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));		
			surveyKpsiVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));		
			surveyKpsiVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));		
			surveyKpsiVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));		
			surveyKpsiVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));		
			surveyKpsiVO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));		
			surveyKpsiVO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));	
			surveyKpsiVO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));		
			surveyKpsiVO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));		
			surveyKpsiVO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));		
			surveyKpsiVO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));		
			surveyKpsiVO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));		
			surveyKpsiVO.setA56(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));		
			surveyKpsiVO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));		
			surveyKpsiVO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));		
			surveyKpsiVO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));		
			surveyKpsiVO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));	
			surveyKpsiVO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));		
			surveyKpsiVO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));		
			surveyKpsiVO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));		
			surveyKpsiVO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));		
			surveyKpsiVO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));		
			surveyKpsiVO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));		
			surveyKpsiVO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));		
			surveyKpsiVO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));		
			surveyKpsiVO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));		
			surveyKpsiVO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));	
			surveyKpsiVO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));		
			surveyKpsiVO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));		
			surveyKpsiVO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));		
			surveyKpsiVO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));		
			surveyKpsiVO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));		
			surveyKpsiVO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));		
			surveyKpsiVO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));		
			surveyKpsiVO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));		
			surveyKpsiVO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));		
			surveyKpsiVO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));	
			surveyKpsiVO.setA81(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));		
			surveyKpsiVO.setA82(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));		
			surveyKpsiVO.setA83(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));		
			surveyKpsiVO.setA84(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));		
			surveyKpsiVO.setA85(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));		
			surveyKpsiVO.setA86(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));		
			surveyKpsiVO.setA87(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));		
			surveyKpsiVO.setA88(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));		
			surveyKpsiVO.setA89(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));		
			surveyKpsiVO.setA90(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));	
			surveyKpsiVO.setA91(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));		
			surveyKpsiVO.setA92(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));		
			surveyKpsiVO.setA93(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));		
			surveyKpsiVO.setA94(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));		
			surveyKpsiVO.setA95(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));		
			surveyKpsiVO.setA96(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));		
			surveyKpsiVO.setA97(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));		
			surveyKpsiVO.setA98(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));		
			surveyKpsiVO.setA99(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));		
			surveyKpsiVO.setA100(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));	
			surveyKpsiVO.setA101(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));		
			surveyKpsiVO.setA102(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));		
			surveyKpsiVO.setA103(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));		
			surveyKpsiVO.setA104(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));		
			surveyKpsiVO.setA105(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));		
			surveyKpsiVO.setA106(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));		
			surveyKpsiVO.setA107(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("",""));		
			surveyKpsiVO.setA108(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("",""));		
			surveyKpsiVO.setA109(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("",""));		
			surveyKpsiVO.setA110(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("",""));	
			surveyKpsiVO.setA111(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("",""));		
			surveyKpsiVO.setA112(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("",""));		
			surveyKpsiVO.setA113(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("",""));		
			surveyKpsiVO.setA114(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("",""));		
			surveyKpsiVO.setA115(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("",""));		
			surveyKpsiVO.setA116(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("",""));		
			surveyKpsiVO.setA117(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("",""));		
			surveyKpsiVO.setA118(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("",""));		
			surveyKpsiVO.setA119(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("",""));		
			surveyKpsiVO.setA120(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("",""));	
			surveyKpsiVO.setA121(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("",""));	
			surveyKpsiVO.setA122(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("",""));	
			surveyKpsiVO.setA123(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("",""));	
			surveyKpsiVO.setA124(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("",""));	
			surveyKpsiVO.setA125(POIUtil.getStringCellValue(sheet.getRow(row).getCell(127)).trim().replace("",""));	
			surveyKpsiVO.setA126(POIUtil.getStringCellValue(sheet.getRow(row).getCell(128)).trim().replace("",""));	
			surveyKpsiVO.setA127(POIUtil.getStringCellValue(sheet.getRow(row).getCell(129)).trim().replace("",""));	
			surveyKpsiVO.setA128(POIUtil.getStringCellValue(sheet.getRow(row).getCell(130)).trim().replace("",""));	
			surveyKpsiVO.setA129(POIUtil.getStringCellValue(sheet.getRow(row).getCell(131)).trim().replace("",""));	
			surveyKpsiVO.setA130(POIUtil.getStringCellValue(sheet.getRow(row).getCell(132)).trim().replace("",""));	
			surveyKpsiVO.setA131(POIUtil.getStringCellValue(sheet.getRow(row).getCell(133)).trim().replace("",""));	
			surveyKpsiVO.setA132(POIUtil.getStringCellValue(sheet.getRow(row).getCell(134)).trim().replace("",""));	
			surveyKpsiVO.setA133(POIUtil.getStringCellValue(sheet.getRow(row).getCell(135)).trim().replace("",""));	
			surveyKpsiVO.setA134(POIUtil.getStringCellValue(sheet.getRow(row).getCell(136)).trim().replace("",""));	
			surveyKpsiVO.setA135(POIUtil.getStringCellValue(sheet.getRow(row).getCell(137)).trim().replace("",""));	
			surveyKpsiVO.setA136(POIUtil.getStringCellValue(sheet.getRow(row).getCell(138)).trim().replace("",""));	
			surveyKpsiVO.setA137(POIUtil.getStringCellValue(sheet.getRow(row).getCell(139)).trim().replace("",""));	
			surveyKpsiVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(140)).trim().replace("",""));
			surveyKpsiVO.setCreateBy("excel_upload");
			surveyKpsiVO.setUpdateBy("excel_upload");	
			
		} catch (Exception e) {
			if(logger.isDebugEnabled()){
				logger.error("[Error Message] There is an Exception while mapping between cells and the object!!");
				logger.error("[Error Line] Col : " + col + ", Row : " + (row + 1) );
				logger.error("[Error Detail]");
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			throw new CellReaderMapperException("There is an Exception on CellMapper!!");
		}
		return surveyKpsiVO;
	}
	
	

}
