package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdRcmasVO;

public class SurveyAsdRcmasCellReaderMapper implements CellReaderMapper<SurveyAsdRcmasVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdRcmasVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdRcmasVO surveyAsdRcmasVO = new SurveyAsdRcmasVO();
		try {
			surveyAsdRcmasVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdRcmasVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdRcmasVO.setRcmasExecDate(execDate.replace("-", ""));
			surveyAsdRcmasVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdRcmasVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdRcmasVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdRcmasVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdRcmasVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdRcmasVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdRcmasVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdRcmasVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdRcmasVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdRcmasVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdRcmasVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdRcmasVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdRcmasVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdRcmasVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdRcmasVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdRcmasVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdRcmasVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdRcmasVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdRcmasVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdRcmasVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdRcmasVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdRcmasVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdRcmasVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyAsdRcmasVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyAsdRcmasVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyAsdRcmasVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyAsdRcmasVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));			
			surveyAsdRcmasVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
			surveyAsdRcmasVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
			surveyAsdRcmasVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyAsdRcmasVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));	
			surveyAsdRcmasVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	
			surveyAsdRcmasVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	
			surveyAsdRcmasVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));	
			surveyAsdRcmasVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));	
			surveyAsdRcmasVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));			
			surveyAsdRcmasVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));	
			surveyAsdRcmasVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	
			surveyAsdRcmasVO.setCreateBy("excel_upload");
			surveyAsdRcmasVO.setUpdateBy("excel_upload");
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
		return surveyAsdRcmasVO;
	}
}
