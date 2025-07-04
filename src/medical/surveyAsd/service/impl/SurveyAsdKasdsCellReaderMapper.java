package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdKasdsVO;

public class SurveyAsdKasdsCellReaderMapper implements CellReaderMapper<SurveyAsdKasdsVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdKasdsVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdKasdsVO surveyAsdKasdsVO = new SurveyAsdKasdsVO();
		try {
			surveyAsdKasdsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdKasdsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdKasdsVO.setKasdsExecDate(execDate.replace("-", ""));
			surveyAsdKasdsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdKasdsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdKasdsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdKasdsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyAsdKasdsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyAsdKasdsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyAsdKasdsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyAsdKasdsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyAsdKasdsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		
			surveyAsdKasdsVO.setB1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyAsdKasdsVO.setB2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyAsdKasdsVO.setB3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));			
			surveyAsdKasdsVO.setB4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyAsdKasdsVO.setB5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyAsdKasdsVO.setB6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyAsdKasdsVO.setB7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyAsdKasdsVO.setB8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	
			surveyAsdKasdsVO.setB9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyAsdKasdsVO.setB10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyAsdKasdsVO.setB11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyAsdKasdsVO.setB12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));			
			surveyAsdKasdsVO.setB13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyAsdKasdsVO.setC1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyAsdKasdsVO.setC2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyAsdKasdsVO.setC3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));			
			surveyAsdKasdsVO.setC4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));	
			surveyAsdKasdsVO.setC5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("",""));	
			surveyAsdKasdsVO.setC6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("",""));	
			surveyAsdKasdsVO.setC7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("",""));	
			surveyAsdKasdsVO.setC8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("",""));	
			surveyAsdKasdsVO.setC9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("",""));	
			surveyAsdKasdsVO.setC10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("",""));	
			surveyAsdKasdsVO.setC11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("",""));	
			surveyAsdKasdsVO.setD1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("",""));	
			surveyAsdKasdsVO.setD2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("",""));	
			surveyAsdKasdsVO.setD3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("",""));			
			surveyAsdKasdsVO.setD4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("",""));	
			surveyAsdKasdsVO.setD5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("",""));	
			surveyAsdKasdsVO.setD6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("",""));	
			surveyAsdKasdsVO.setD7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("",""));	
			surveyAsdKasdsVO.setD8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("",""));	
			surveyAsdKasdsVO.setD9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("",""));	
			surveyAsdKasdsVO.setD10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("",""));	
			surveyAsdKasdsVO.setE1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("",""));	
			surveyAsdKasdsVO.setE2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("",""));	
			surveyAsdKasdsVO.setE3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("",""));			
			surveyAsdKasdsVO.setE4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("",""));	
			surveyAsdKasdsVO.setE5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("",""));	
			surveyAsdKasdsVO.setE6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("",""));	
			surveyAsdKasdsVO.setE7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(53)).trim().replace("",""));
			surveyAsdKasdsVO.setLanguage(POIUtil.getStringCellValue(sheet.getRow(row).getCell(54)).trim().replace("",""));
			surveyAsdKasdsVO.setSociability(POIUtil.getStringCellValue(sheet.getRow(row).getCell(55)).trim().replace("",""));
			surveyAsdKasdsVO.setMaladaptiveBehavior(POIUtil.getStringCellValue(sheet.getRow(row).getCell(56)).trim().replace("",""));
			surveyAsdKasdsVO.setRecognition(POIUtil.getStringCellValue(sheet.getRow(row).getCell(57)).trim().replace("",""));
			surveyAsdKasdsVO.setSensorimotor(POIUtil.getStringCellValue(sheet.getRow(row).getCell(58)).trim().replace("",""));
//			surveyAsdKasdsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(59)).trim().replace("",""));	
			surveyAsdKasdsVO.setCreateBy("excel_upload");
			surveyAsdKasdsVO.setUpdateBy("excel_upload");
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
		return surveyAsdKasdsVO;
	}
}
