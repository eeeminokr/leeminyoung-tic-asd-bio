package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyStaitParentsVO;

public class SurveyStaitParentsCellReaderMapper implements CellReaderMapper<SurveyStaitParentsVO> {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public SurveyStaitParentsVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {
		
		SurveyStaitParentsVO surveyStaiParentsVO = new SurveyStaitParentsVO();
		
		try {
			surveyStaiParentsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyStaiParentsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyStaiParentsVO.setStaitParentsExecDate(execDate.replace("-", ""));
			surveyStaiParentsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyStaiParentsVO.setA1Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyStaiParentsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyStaiParentsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyStaiParentsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyStaiParentsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyStaiParentsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyStaiParentsVO.setA6Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyStaiParentsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyStaiParentsVO.setA7Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyStaiParentsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));		
			surveyStaiParentsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyStaiParentsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyStaiParentsVO.setA10Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyStaiParentsVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyStaiParentsVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyStaiParentsVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyStaiParentsVO.setA13Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyStaiParentsVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyStaiParentsVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyStaiParentsVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyStaiParentsVO.setA16Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyStaiParentsVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyStaiParentsVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));			
			surveyStaiParentsVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyStaiParentsVO.setA19Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyStaiParentsVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyStaiParentsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));
//			surveyStaiParentsVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));
			surveyStaiParentsVO.setCreateBy("excel_upload");
			surveyStaiParentsVO.setUpdateBy("excel_upload");	
			
			
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
		return surveyStaiParentsVO;
	}
	
}
