package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdBdiParentsVO;

public class SurveyAsdBdiParentsCellReaderMapper implements CellReaderMapper<SurveyAsdBdiParentsVO>{

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public SurveyAsdBdiParentsVO mapCell(Sheet sheet, int col, int row) throws CellReaderMapperException {

		SurveyAsdBdiParentsVO surveyAsdBdiParentsVO = new SurveyAsdBdiParentsVO();
		try {
			surveyAsdBdiParentsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdBdiParentsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdBdiParentsVO.setBdiParentsExecDate(execDate.replace("-", ""));
			surveyAsdBdiParentsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdBdiParentsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));			
			surveyAsdBdiParentsVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setWeightControl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdBdiParentsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));
			surveyAsdBdiParentsVO.setCreateBy("excel_upload");
			surveyAsdBdiParentsVO.setUpdateBy("excel_upload");	
			
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
		return surveyAsdBdiParentsVO;
	}
	
	
}
