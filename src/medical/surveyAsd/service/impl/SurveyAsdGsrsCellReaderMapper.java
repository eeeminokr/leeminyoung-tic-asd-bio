package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdGsrsVO;

public class SurveyAsdGsrsCellReaderMapper implements CellReaderMapper<SurveyAsdGsrsVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdGsrsVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdGsrsVO SurveyAsdGsrsVO = new SurveyAsdGsrsVO();
		try {
			SurveyAsdGsrsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			SurveyAsdGsrsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			SurveyAsdGsrsVO.setGsrsExecDate(execDate.replace("-", ""));
			SurveyAsdGsrsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			SurveyAsdGsrsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			SurveyAsdGsrsVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			SurveyAsdGsrsVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			SurveyAsdGsrsVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			SurveyAsdGsrsVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			SurveyAsdGsrsVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			SurveyAsdGsrsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			SurveyAsdGsrsVO.setCreateBy("excel_upload");
			SurveyAsdGsrsVO.setUpdateBy("excel_upload");	
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
		return SurveyAsdGsrsVO;
	}
}
