package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdKcriterionAdultVO;

public class SurveyAsdKcriterionAdultCellReaderMapper implements CellReaderMapper<SurveyAsdKcriterionAdultVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdKcriterionAdultVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdKcriterionAdultVO surveyAsdKcriterionAdultVO = new SurveyAsdKcriterionAdultVO();
		try {
			surveyAsdKcriterionAdultVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdKcriterionAdultVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdKcriterionAdultVO.setKcriterionAdultExecDate(execDate.replace("-", ""));
			surveyAsdKcriterionAdultVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdKcriterionAdultVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdKcriterionAdultVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyAsdKcriterionAdultVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdKcriterionAdultVO.setCreateBy("excel_upload");
			surveyAsdKcriterionAdultVO.setUpdateBy("excel_upload");
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
		return surveyAsdKcriterionAdultVO;
	}
}
