package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyKcbclVO;

public class SurveyKcbclCellReaderMapper implements CellReaderMapper<SurveyKcbclVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyKcbclVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		
		SurveyKcbclVO surveyKcbclVO = new SurveyKcbclVO();
		try {
			surveyKcbclVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyKcbclVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyKcbclVO.setKcbclExecDate(execDate.replace("-", ""));
			surveyKcbclVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		  
			surveyKcbclVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		  
			surveyKcbclVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		  
			surveyKcbclVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		  
			surveyKcbclVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		  
			surveyKcbclVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		  
			surveyKcbclVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		  
			surveyKcbclVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		  
			surveyKcbclVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		  
			surveyKcbclVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	  
			surveyKcbclVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	  
			surveyKcbclVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	  
			surveyKcbclVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	  
			surveyKcbclVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	  
			surveyKcbclVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	  
			surveyKcbclVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	  
			surveyKcbclVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	  
			surveyKcbclVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		
			surveyKcbclVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	  
			surveyKcbclVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	  
			surveyKcbclVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	  
			surveyKcbclVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	  
			surveyKcbclVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	  
			surveyKcbclVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	  
			surveyKcbclVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	  
			surveyKcbclVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	  
			surveyKcbclVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		
			surveyKcbclVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	  
			surveyKcbclVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	  
			surveyKcbclVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	  
			surveyKcbclVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	  
			surveyKcbclVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));	  
			surveyKcbclVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	  
			surveyKcbclVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	  
			surveyKcbclVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));	  
			surveyKcbclVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));		
			surveyKcbclVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));	  
			surveyKcbclVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));	  
			surveyKcbclVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	  
			surveyKcbclVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	  
			surveyKcbclVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	  
			surveyKcbclVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	  
			surveyKcbclVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));	  
			surveyKcbclVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));	  
			surveyKcbclVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));		
			surveyKcbclVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));	  
			surveyKcbclVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));	  
			surveyKcbclVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));	  
			surveyKcbclVO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));	  
			surveyKcbclVO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));	  
			surveyKcbclVO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));	  
			surveyKcbclVO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));	  
			surveyKcbclVO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));	  
			surveyKcbclVO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));		
			surveyKcbclVO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));	   
			surveyKcbclVO.setA56a(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));	   
			surveyKcbclVO.setA56b(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));	   
			surveyKcbclVO.setA56c(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));	   
			surveyKcbclVO.setA56d(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));	   
			surveyKcbclVO.setA56e(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));	   
			surveyKcbclVO.setA56f(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));	   
			surveyKcbclVO.setA56g(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));	   
			surveyKcbclVO.setA56h(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));	   
			surveyKcbclVO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));	   
			surveyKcbclVO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));	   
			surveyKcbclVO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));	   
			surveyKcbclVO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));	   
			surveyKcbclVO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));	   
			surveyKcbclVO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));	   
			surveyKcbclVO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));		 
			surveyKcbclVO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));	   
			surveyKcbclVO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));	   
			surveyKcbclVO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));	   
			surveyKcbclVO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));	   
			surveyKcbclVO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));	   
			surveyKcbclVO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));	   
			surveyKcbclVO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));	   
			surveyKcbclVO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));	   
			surveyKcbclVO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));		 
			surveyKcbclVO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));	   
			surveyKcbclVO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));	   
			surveyKcbclVO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));	   
			surveyKcbclVO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));	   
			surveyKcbclVO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(86)).trim().replace("",""));	   
			surveyKcbclVO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(87)).trim().replace("",""));	   
			surveyKcbclVO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(88)).trim().replace("",""));	   
			surveyKcbclVO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(89)).trim().replace("",""));	   
			surveyKcbclVO.setA81(POIUtil.getStringCellValue(sheet.getRow(row).getCell(90)).trim().replace("",""));		 
			surveyKcbclVO.setA82(POIUtil.getStringCellValue(sheet.getRow(row).getCell(91)).trim().replace("",""));	   
			surveyKcbclVO.setA83(POIUtil.getStringCellValue(sheet.getRow(row).getCell(92)).trim().replace("",""));	   
			surveyKcbclVO.setA84(POIUtil.getStringCellValue(sheet.getRow(row).getCell(93)).trim().replace("",""));	   
			surveyKcbclVO.setA85(POIUtil.getStringCellValue(sheet.getRow(row).getCell(94)).trim().replace("",""));	   
			surveyKcbclVO.setA86(POIUtil.getStringCellValue(sheet.getRow(row).getCell(95)).trim().replace("",""));	   
			surveyKcbclVO.setA87(POIUtil.getStringCellValue(sheet.getRow(row).getCell(96)).trim().replace("",""));	   
			surveyKcbclVO.setA88(POIUtil.getStringCellValue(sheet.getRow(row).getCell(97)).trim().replace("",""));	   
			surveyKcbclVO.setA89(POIUtil.getStringCellValue(sheet.getRow(row).getCell(98)).trim().replace("",""));	   
			surveyKcbclVO.setA90(POIUtil.getStringCellValue(sheet.getRow(row).getCell(99)).trim().replace("",""));		 
			surveyKcbclVO.setA91(POIUtil.getStringCellValue(sheet.getRow(row).getCell(100)).trim().replace("",""));	   
			surveyKcbclVO.setA92(POIUtil.getStringCellValue(sheet.getRow(row).getCell(101)).trim().replace("",""));	   
			surveyKcbclVO.setA93(POIUtil.getStringCellValue(sheet.getRow(row).getCell(102)).trim().replace("",""));	   
			surveyKcbclVO.setA94(POIUtil.getStringCellValue(sheet.getRow(row).getCell(103)).trim().replace("",""));	   
			surveyKcbclVO.setA95(POIUtil.getStringCellValue(sheet.getRow(row).getCell(104)).trim().replace("",""));	   
			surveyKcbclVO.setA96(POIUtil.getStringCellValue(sheet.getRow(row).getCell(105)).trim().replace("",""));	   
			surveyKcbclVO.setA97(POIUtil.getStringCellValue(sheet.getRow(row).getCell(106)).trim().replace("",""));	   
			surveyKcbclVO.setA98(POIUtil.getStringCellValue(sheet.getRow(row).getCell(107)).trim().replace("",""));	   
			surveyKcbclVO.setA99(POIUtil.getStringCellValue(sheet.getRow(row).getCell(108)).trim().replace("",""));	   
			surveyKcbclVO.setA100(POIUtil.getStringCellValue(sheet.getRow(row).getCell(109)).trim().replace("",""));	 
			surveyKcbclVO.setA101(POIUtil.getStringCellValue(sheet.getRow(row).getCell(110)).trim().replace("",""));	 
			surveyKcbclVO.setA102(POIUtil.getStringCellValue(sheet.getRow(row).getCell(111)).trim().replace("",""));	 
			surveyKcbclVO.setA103(POIUtil.getStringCellValue(sheet.getRow(row).getCell(112)).trim().replace("",""));	 
			surveyKcbclVO.setA104(POIUtil.getStringCellValue(sheet.getRow(row).getCell(113)).trim().replace("",""));	 
			surveyKcbclVO.setA105(POIUtil.getStringCellValue(sheet.getRow(row).getCell(114)).trim().replace("",""));	 
			surveyKcbclVO.setA106(POIUtil.getStringCellValue(sheet.getRow(row).getCell(115)).trim().replace("",""));	 
			surveyKcbclVO.setA107(POIUtil.getStringCellValue(sheet.getRow(row).getCell(116)).trim().replace("",""));	 
			surveyKcbclVO.setA108(POIUtil.getStringCellValue(sheet.getRow(row).getCell(117)).trim().replace("",""));	 
			surveyKcbclVO.setA109(POIUtil.getStringCellValue(sheet.getRow(row).getCell(118)).trim().replace("",""));	 
			surveyKcbclVO.setA110(POIUtil.getStringCellValue(sheet.getRow(row).getCell(119)).trim().replace("",""));	 
			surveyKcbclVO.setA111(POIUtil.getStringCellValue(sheet.getRow(row).getCell(120)).trim().replace("",""));	 
			surveyKcbclVO.setA112(POIUtil.getStringCellValue(sheet.getRow(row).getCell(121)).trim().replace("",""));	 
			surveyKcbclVO.setA113(POIUtil.getStringCellValue(sheet.getRow(row).getCell(122)).trim().replace("",""));	 
			surveyKcbclVO.setA114(POIUtil.getStringCellValue(sheet.getRow(row).getCell(123)).trim().replace("",""));	 
			surveyKcbclVO.setA115(POIUtil.getStringCellValue(sheet.getRow(row).getCell(124)).trim().replace("",""));	 
//			surveyKcbclVO.setA116(POIUtil.getStringCellValue(sheet.getRow(row).getCell(125)).trim().replace("",""));	 
			surveyKcbclVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(126)).trim().replace("",""));
	
			surveyKcbclVO.setCreateBy("excel_upload");
			surveyKcbclVO.setUpdateBy("excel_upload");
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
		return surveyKcbclVO;
	}
}
