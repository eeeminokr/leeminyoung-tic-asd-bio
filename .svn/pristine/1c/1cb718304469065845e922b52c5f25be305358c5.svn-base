package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdKcshqVO;

public class SurveyAsdKcshqCellReaderMapper implements CellReaderMapper<SurveyAsdKcshqVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdKcshqVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyAsdKcshqVO surveyAsdKcshqVO = new SurveyAsdKcshqVO();
		
		try {
			surveyAsdKcshqVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdKcshqVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdKcshqVO.setKcshqExecDate(execDate.replace("-", ""));
			surveyAsdKcshqVO.setA1Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdKcshqVO.setA2Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdKcshqVO.setA3Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdKcshqVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdKcshqVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdKcshqVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdKcshqVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdKcshqVO.setA8Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdKcshqVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdKcshqVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdKcshqVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyAsdKcshqVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		
			surveyAsdKcshqVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));		
			surveyAsdKcshqVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		
			surveyAsdKcshqVO.setA15Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));		
			surveyAsdKcshqVO.setA16Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));		
			surveyAsdKcshqVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));		
			surveyAsdKcshqVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));		
			surveyAsdKcshqVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));		
			surveyAsdKcshqVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyAsdKcshqVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));		
			surveyAsdKcshqVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));		
			surveyAsdKcshqVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));		
			surveyAsdKcshqVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));		
			surveyAsdKcshqVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));		
			surveyAsdKcshqVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));		
			surveyAsdKcshqVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));		
			surveyAsdKcshqVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));		
			surveyAsdKcshqVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));		
			surveyAsdKcshqVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyAsdKcshqVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));		
			surveyAsdKcshqVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));		
			surveyAsdKcshqVO.setA33Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));		
			surveyAsdKcshqVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));		
			surveyAsdKcshqVO.setA35Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));		
			surveyAsdKcshqVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));		
			surveyAsdKcshqVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));		
			surveyAsdKcshqVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));		
			surveyAsdKcshqVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));		
			surveyAsdKcshqVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyAsdKcshqVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));		
			surveyAsdKcshqVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));		
			surveyAsdKcshqVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));		
			surveyAsdKcshqVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));		
			surveyAsdKcshqVO.setA45(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));		
			surveyAsdKcshqVO.setA46(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));		
			surveyAsdKcshqVO.setA47(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));		
			surveyAsdKcshqVO.setA48(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));		
			surveyAsdKcshqVO.setA49(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));		
			surveyAsdKcshqVO.setA50(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));	
			surveyAsdKcshqVO.setA51(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));		
			surveyAsdKcshqVO.setA52(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));		
			surveyAsdKcshqVO.setA53(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));		
			surveyAsdKcshqVO.setA54(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));		
			surveyAsdKcshqVO.setA55(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));		
			surveyAsdKcshqVO.setA56(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));		
			surveyAsdKcshqVO.setA57(POIUtil.getStringCellValue(sheet.getRow(row).getCell(60)).trim().replace("",""));		
			surveyAsdKcshqVO.setA58(POIUtil.getStringCellValue(sheet.getRow(row).getCell(61)).trim().replace("",""));		
			surveyAsdKcshqVO.setA59(POIUtil.getStringCellValue(sheet.getRow(row).getCell(62)).trim().replace("",""));		
			surveyAsdKcshqVO.setA60(POIUtil.getStringCellValue(sheet.getRow(row).getCell(63)).trim().replace("",""));	
			surveyAsdKcshqVO.setA61(POIUtil.getStringCellValue(sheet.getRow(row).getCell(64)).trim().replace("",""));		
			surveyAsdKcshqVO.setA62(POIUtil.getStringCellValue(sheet.getRow(row).getCell(65)).trim().replace("",""));		
			surveyAsdKcshqVO.setA63(POIUtil.getStringCellValue(sheet.getRow(row).getCell(66)).trim().replace("",""));		
			surveyAsdKcshqVO.setA64(POIUtil.getStringCellValue(sheet.getRow(row).getCell(67)).trim().replace("",""));		
			surveyAsdKcshqVO.setA65(POIUtil.getStringCellValue(sheet.getRow(row).getCell(68)).trim().replace("",""));		
			surveyAsdKcshqVO.setA66(POIUtil.getStringCellValue(sheet.getRow(row).getCell(69)).trim().replace("",""));		
			surveyAsdKcshqVO.setCreateBy("excel_upload");
			surveyAsdKcshqVO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdKcshqVO;
	}
	
	

}
