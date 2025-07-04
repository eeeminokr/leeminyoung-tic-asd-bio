package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCmrspVO;
import medical.surveyAsd.service.SurveyAsdCpclVO;

public class SurveyAsdCpclCellReaderMapper implements CellReaderMapper<SurveyAsdCpclVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdCpclVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdCpclVO surveyAsdCpclVO = new SurveyAsdCpclVO();
		try {
			surveyAsdCpclVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdCpclVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdCpclVO.setCpclExecDate(execDate.replace("-", ""));
			surveyAsdCpclVO.setSentence(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdCpclVO.settDiagnosis(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
		
			  surveyAsdCpclVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));	
				surveyAsdCpclVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));	
				surveyAsdCpclVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));	
				surveyAsdCpclVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));	
				surveyAsdCpclVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));	
				surveyAsdCpclVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));	
				surveyAsdCpclVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	
				surveyAsdCpclVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
				surveyAsdCpclVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
				surveyAsdCpclVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
				surveyAsdCpclVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
				surveyAsdCpclVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
				surveyAsdCpclVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
				surveyAsdCpclVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
				surveyAsdCpclVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
				surveyAsdCpclVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
				surveyAsdCpclVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
				surveyAsdCpclVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
				surveyAsdCpclVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
				surveyAsdCpclVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
				surveyAsdCpclVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
				surveyAsdCpclVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
				surveyAsdCpclVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
				surveyAsdCpclVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
				surveyAsdCpclVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	
				surveyAsdCpclVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
				surveyAsdCpclVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
				surveyAsdCpclVO.setA28(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
				surveyAsdCpclVO.setA29(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));	
				surveyAsdCpclVO.setA30(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	
				surveyAsdCpclVO.setA31(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	
				surveyAsdCpclVO.setA32(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));	
				surveyAsdCpclVO.setA33(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));	
				surveyAsdCpclVO.setA34(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));	
				surveyAsdCpclVO.setA35(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));
				surveyAsdCpclVO.setA36(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	
				surveyAsdCpclVO.setA37(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	
				surveyAsdCpclVO.setA38(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
				surveyAsdCpclVO.setA39(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	
				surveyAsdCpclVO.setA40(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));	
				surveyAsdCpclVO.setA41(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));	
				surveyAsdCpclVO.setA42(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));	
				surveyAsdCpclVO.setA43(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));	
				surveyAsdCpclVO.setA44(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));
			
			surveyAsdCpclVO.setCreateBy("excel_upload");
			surveyAsdCpclVO.setUpdateBy("excel_upload");	
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
		return surveyAsdCpclVO;
	}
}
