package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyStaisParentsVO;

public class SurveyStaisParentCellReaderMapper implements CellReaderMapper<SurveyStaisParentsVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyStaisParentsVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyStaisParentsVO surveyStaisParentsVO = new SurveyStaisParentsVO();
		
		try {
			
			surveyStaisParentsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyStaisParentsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyStaisParentsVO.setStaisParentsExecDate(execDate.replace("-", ""));
			surveyStaisParentsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyStaisParentsVO.setA1Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyStaisParentsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyStaisParentsVO.setA2Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyStaisParentsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyStaisParentsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyStaisParentsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyStaisParentsVO.setA5Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyStaisParentsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyStaisParentsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyStaisParentsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));		
			surveyStaisParentsVO.setA8Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		
			surveyStaisParentsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		
			surveyStaisParentsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyStaisParentsVO.setA10Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyStaisParentsVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyStaisParentsVO.setA11Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyStaisParentsVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyStaisParentsVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyStaisParentsVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyStaisParentsVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyStaisParentsVO.setA15Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyStaisParentsVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyStaisParentsVO.setA16Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyStaisParentsVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyStaisParentsVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));			
			surveyStaisParentsVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyStaisParentsVO.setA19Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	
			surveyStaisParentsVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
			surveyStaisParentsVO.setA20Rc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));
			surveyStaisParentsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));
			surveyStaisParentsVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));
			surveyStaisParentsVO.setCreateBy("excel_upload");
			surveyStaisParentsVO.setUpdateBy("excel_upload");	
			
			
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
		return surveyStaisParentsVO;
	}
	

}
