package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyStaitYouthVO;

public class SurveyStaitYouthCellReaderMapper implements CellReaderMapper<SurveyStaitYouthVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyStaitYouthVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {
		
		SurveyStaitYouthVO surveyStaiYouthVO = new SurveyStaitYouthVO();
		
		try {
			surveyStaiYouthVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyStaiYouthVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyStaiYouthVO.setStaitYouthExecDate(execDate.replace("-", ""));
			surveyStaiYouthVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyStaiYouthVO.setA1Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyStaiYouthVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyStaiYouthVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyStaiYouthVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyStaiYouthVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyStaiYouthVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyStaiYouthVO.setA6Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyStaiYouthVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyStaiYouthVO.setA7Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyStaiYouthVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));		
			surveyStaiYouthVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyStaiYouthVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyStaiYouthVO.setA10Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyStaiYouthVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyStaiYouthVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyStaiYouthVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyStaiYouthVO.setA13Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyStaiYouthVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyStaiYouthVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyStaiYouthVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyStaiYouthVO.setA16Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyStaiYouthVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyStaiYouthVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));			
			surveyStaiYouthVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyStaiYouthVO.setA19Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyStaiYouthVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyStaiYouthVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));
//			surveyStaiYouthVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));
			surveyStaiYouthVO.setCreateBy("excel_upload");
			surveyStaiYouthVO.setUpdateBy("excel_upload");	
			
			
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
		return surveyStaiYouthVO;
	}
	
}
