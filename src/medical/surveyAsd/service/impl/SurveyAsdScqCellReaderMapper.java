package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdScqVO;

public class SurveyAsdScqCellReaderMapper implements CellReaderMapper<SurveyAsdScqVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdScqVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyAsdScqVO surveyAsdScqVO = new SurveyAsdScqVO();
		
		try {
			surveyAsdScqVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdScqVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdScqVO.setScqExecDate(execDate.replace("-", ""));
			surveyAsdScqVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdScqVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdScqVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdScqVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdScqVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdScqVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdScqVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdScqVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdScqVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdScqVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdScqVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyAsdScqVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		
			surveyAsdScqVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));		
			surveyAsdScqVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		
			surveyAsdScqVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));		
			surveyAsdScqVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));		
			surveyAsdScqVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		
			surveyAsdScqVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));		
			surveyAsdScqVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));		
			surveyAsdScqVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyAsdScqVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));		
			surveyAsdScqVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));		
			surveyAsdScqVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));		
			surveyAsdScqVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));		
			surveyAsdScqVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));		
			surveyAsdScqVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		
			surveyAsdScqVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));		
			surveyAsdScqVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));		
			surveyAsdScqVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));		
			surveyAsdScqVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyAsdScqVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));		
			surveyAsdScqVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));		
			surveyAsdScqVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));		
			surveyAsdScqVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));		
			surveyAsdScqVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));		
			surveyAsdScqVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));		
			surveyAsdScqVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));		
			surveyAsdScqVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));		
			surveyAsdScqVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));		
			surveyAsdScqVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyAsdScqVO.setcTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	
			
			surveyAsdScqVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));		
			surveyAsdScqVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));		
			surveyAsdScqVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));		
			surveyAsdScqVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));		
			surveyAsdScqVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));		
			surveyAsdScqVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));		
			surveyAsdScqVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));		
			surveyAsdScqVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));		
			surveyAsdScqVO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));		
			surveyAsdScqVO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));	
			surveyAsdScqVO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));		
			surveyAsdScqVO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));		
			surveyAsdScqVO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));		
			surveyAsdScqVO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));		
			surveyAsdScqVO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));		
			surveyAsdScqVO.setA56(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));		
			surveyAsdScqVO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));		
			surveyAsdScqVO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));		
			surveyAsdScqVO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));		
			surveyAsdScqVO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));	
			surveyAsdScqVO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));		
			surveyAsdScqVO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));		
			surveyAsdScqVO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));		
			surveyAsdScqVO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));		
			surveyAsdScqVO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));		
			surveyAsdScqVO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(70)).trim().replace("",""));		
			surveyAsdScqVO.setA67(POIUtil.getStringCellValue(sheet.getRow(row).getCell(71)).trim().replace("",""));		
			surveyAsdScqVO.setA68(POIUtil.getStringCellValue(sheet.getRow(row).getCell(72)).trim().replace("",""));		
			surveyAsdScqVO.setA69(POIUtil.getStringCellValue(sheet.getRow(row).getCell(73)).trim().replace("",""));		
			surveyAsdScqVO.setA70(POIUtil.getStringCellValue(sheet.getRow(row).getCell(74)).trim().replace("",""));	
			surveyAsdScqVO.setA71(POIUtil.getStringCellValue(sheet.getRow(row).getCell(75)).trim().replace("",""));		
			surveyAsdScqVO.setA72(POIUtil.getStringCellValue(sheet.getRow(row).getCell(76)).trim().replace("",""));		
			surveyAsdScqVO.setA73(POIUtil.getStringCellValue(sheet.getRow(row).getCell(77)).trim().replace("",""));		
			surveyAsdScqVO.setA74(POIUtil.getStringCellValue(sheet.getRow(row).getCell(78)).trim().replace("",""));		
			surveyAsdScqVO.setA75(POIUtil.getStringCellValue(sheet.getRow(row).getCell(79)).trim().replace("",""));		
			surveyAsdScqVO.setA76(POIUtil.getStringCellValue(sheet.getRow(row).getCell(80)).trim().replace("",""));		
			surveyAsdScqVO.setA77(POIUtil.getStringCellValue(sheet.getRow(row).getCell(81)).trim().replace("",""));		
			surveyAsdScqVO.setA78(POIUtil.getStringCellValue(sheet.getRow(row).getCell(82)).trim().replace("",""));		
			surveyAsdScqVO.setA79(POIUtil.getStringCellValue(sheet.getRow(row).getCell(83)).trim().replace("",""));		
			surveyAsdScqVO.setA80(POIUtil.getStringCellValue(sheet.getRow(row).getCell(84)).trim().replace("",""));
			surveyAsdScqVO.setlTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(85)).trim().replace("",""));
			
			surveyAsdScqVO.setCreateBy("excel_upload");
			surveyAsdScqVO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdScqVO;
	}
	
	

}
