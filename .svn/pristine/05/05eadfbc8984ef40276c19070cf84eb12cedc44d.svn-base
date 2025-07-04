package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyIatVO;

public class SurveyIatCellReaderMapper implements CellReaderMapper<SurveyIatVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyIatVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyIatVO surveyIatVO = new SurveyIatVO();
		try {
			surveyIatVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyIatVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyIatVO.setIatExecDate(execDate.replace("-", ""));
			surveyIatVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyIatVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyIatVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyIatVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyIatVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyIatVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyIatVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyIatVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyIatVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyIatVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	
			surveyIatVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyIatVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyIatVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyIatVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyIatVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyIatVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyIatVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyIatVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));			
			surveyIatVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyIatVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyIatVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyIatVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyIatVO.setCreateBy("excel_upload");
			surveyIatVO.setUpdateBy("excel_upload");	
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
		return surveyIatVO;
	}
}
