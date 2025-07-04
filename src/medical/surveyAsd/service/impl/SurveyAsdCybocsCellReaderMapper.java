package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCybocsVO;

public class SurveyAsdCybocsCellReaderMapper implements CellReaderMapper<SurveyAsdCybocsVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public SurveyAsdCybocsVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdCybocsVO surveyAsdCybocsVO = new SurveyAsdCybocsVO();
		try {
			surveyAsdCybocsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdCybocsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdCybocsVO.setCybocsExecDate(execDate.replace("-", ""));
			surveyAsdCybocsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			surveyAsdCybocsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			surveyAsdCybocsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			surveyAsdCybocsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			surveyAsdCybocsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			surveyAsdCybocsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			surveyAsdCybocsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			surveyAsdCybocsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			surveyAsdCybocsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			surveyAsdCybocsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));
			surveyAsdCybocsVO.setCompulsion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));				//강박사고
			surveyAsdCybocsVO.setCompulsiveBehavior(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		//강박행동
			surveyAsdCybocsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));
			surveyAsdCybocsVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));
			surveyAsdCybocsVO.setCreateBy("excel_upload");
			surveyAsdCybocsVO.setUpdateBy("excel_upload");	
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
		return surveyAsdCybocsVO;
	}
}
