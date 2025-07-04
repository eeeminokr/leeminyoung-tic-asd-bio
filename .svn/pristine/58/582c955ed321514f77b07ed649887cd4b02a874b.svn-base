package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyKcriterionVO;

public class SurveyKcriterionCellReaderMapper implements CellReaderMapper<SurveyKcriterionVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyKcriterionVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyKcriterionVO surveyKcriterionVO = new SurveyKcriterionVO();
		try {
			surveyKcriterionVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyKcriterionVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyKcriterionVO.setKcriterionExecDate(execDate.replace("-", ""));
			surveyKcriterionVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyKcriterionVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyKcriterionVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyKcriterionVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyKcriterionVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyKcriterionVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyKcriterionVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyKcriterionVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyKcriterionVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyKcriterionVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	
			surveyKcriterionVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyKcriterionVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyKcriterionVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyKcriterionVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyKcriterionVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyKcriterionVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyKcriterionVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyKcriterionVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));			
			surveyKcriterionVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyKcriterionVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyKcriterionVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyKcriterionVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyKcriterionVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyKcriterionVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyKcriterionVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyKcriterionVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyKcriterionVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));			
			surveyKcriterionVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	
			surveyKcriterionVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
			surveyKcriterionVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
			surveyKcriterionVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyKcriterionVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));	
			surveyKcriterionVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	
			surveyKcriterionVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	
			surveyKcriterionVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));	
			surveyKcriterionVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));			
			surveyKcriterionVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));	
			surveyKcriterionVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));	
			surveyKcriterionVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	
			surveyKcriterionVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	
			surveyKcriterionVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyKcriterionVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	
			surveyKcriterionVO.setCreateBy("excel_upload");
			surveyKcriterionVO.setUpdateBy("excel_upload");
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
		return surveyKcriterionVO;
	}
}
