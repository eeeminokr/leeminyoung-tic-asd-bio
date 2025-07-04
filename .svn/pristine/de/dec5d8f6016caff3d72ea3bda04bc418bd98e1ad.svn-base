package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyTraumaVO;

public class SurveyTraumaCellReaderMapper implements CellReaderMapper<SurveyTraumaVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyTraumaVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyTraumaVO surveyTraumaVO = new SurveyTraumaVO();
		try {
			surveyTraumaVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyTraumaVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyTraumaVO.setTraumaExecDate(execDate.replace("-", ""));
			surveyTraumaVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyTraumaVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyTraumaVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyTraumaVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyTraumaVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyTraumaVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyTraumaVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyTraumaVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyTraumaVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyTraumaVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	
			surveyTraumaVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyTraumaVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyTraumaVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyTraumaVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyTraumaVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyTraumaVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyTraumaVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyTraumaVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));			
			surveyTraumaVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyTraumaVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyTraumaVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyTraumaVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));
			surveyTraumaVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));
			surveyTraumaVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));
			surveyTraumaVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));
			surveyTraumaVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));
			surveyTraumaVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));
			surveyTraumaVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));		//가장 큰 영향을 준 항목
			surveyTraumaVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));		//공포/무력감
			surveyTraumaVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));		//꿈을 꾸는 느낌
			surveyTraumaVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyTraumaVO.setCreateBy("excel_upload");
			surveyTraumaVO.setUpdateBy("excel_upload");
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
		return surveyTraumaVO;
	}
}
