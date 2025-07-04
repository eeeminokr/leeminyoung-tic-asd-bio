package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCdiChildVO;

public class SurveyAsdCdiChildCellReaderMapper implements CellReaderMapper<SurveyAsdCdiChildVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdCdiChildVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdCdiChildVO surveyAsdCdiChildVO = new SurveyAsdCdiChildVO();
		try {
			surveyAsdCdiChildVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdCdiChildVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdCdiChildVO.setCdiChildExecDate(execDate.replace("-", ""));
			surveyAsdCdiChildVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdCdiChildVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdCdiChildVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyAsdCdiChildVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));
			surveyAsdCdiChildVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));
			surveyAsdCdiChildVO.setCreateBy("excel_upload");
			surveyAsdCdiChildVO.setUpdateBy("excel_upload");	
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
		return surveyAsdCdiChildVO;
	}
}
