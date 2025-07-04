package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdStaisParentsVO;

public class SurveyAsdStaisParentsCellReaderMapper implements CellReaderMapper<SurveyAsdStaisParentsVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdStaisParentsVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyAsdStaisParentsVO surveyAsdStaisParentsVO = new SurveyAsdStaisParentsVO();
		
		try {
			
			surveyAsdStaisParentsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdStaisParentsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdStaisParentsVO.setStaisParentsExecDate(execDate.replace("-", ""));
			surveyAsdStaisParentsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA1Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA2Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA5Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA8Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));		
			surveyAsdStaisParentsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA10Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA11Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA15Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA16Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));			
			surveyAsdStaisParentsVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA19Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
			surveyAsdStaisParentsVO.setA20Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));
			surveyAsdStaisParentsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));
			surveyAsdStaisParentsVO.setCreateBy("excel_upload");
			surveyAsdStaisParentsVO.setUpdateBy("excel_upload");	
			
			
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
		return surveyAsdStaisParentsVO;
	}
	

}
