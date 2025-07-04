package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdYbocsVO;

public class SurveyAsdYbocsCellReaderMapper implements CellReaderMapper<SurveyAsdYbocsVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public SurveyAsdYbocsVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdYbocsVO surveyAsdYbocsVO = new SurveyAsdYbocsVO();
		try {
			surveyAsdYbocsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdYbocsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdYbocsVO.setYbocsExecDate(execDate.replace("-", ""));
			surveyAsdYbocsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			surveyAsdYbocsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			surveyAsdYbocsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			surveyAsdYbocsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			surveyAsdYbocsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			surveyAsdYbocsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			surveyAsdYbocsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			surveyAsdYbocsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			surveyAsdYbocsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			surveyAsdYbocsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));
			surveyAsdYbocsVO.setCompulsion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));				//강박사고
			surveyAsdYbocsVO.setCompulsiveBehavior(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		//강박행동
			surveyAsdYbocsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));
			surveyAsdYbocsVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));
			surveyAsdYbocsVO.setCreateBy("excel_upload");
			surveyAsdYbocsVO.setUpdateBy("excel_upload");
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
		return surveyAsdYbocsVO;
	}
}
