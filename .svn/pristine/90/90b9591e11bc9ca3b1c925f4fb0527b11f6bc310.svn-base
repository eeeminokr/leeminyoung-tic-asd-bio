package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyYbocaVO;

public class SurveyYbocaCellReaderMapper implements CellReaderMapper<SurveyYbocaVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public SurveyYbocaVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyYbocaVO surveyYbocaVO = new SurveyYbocaVO();
		try {
			surveyYbocaVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyYbocaVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyYbocaVO.setYbocaExecDate(execDate.replace("-", ""));
			surveyYbocaVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));
			surveyYbocaVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			surveyYbocaVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			surveyYbocaVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			surveyYbocaVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			surveyYbocaVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			surveyYbocaVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			surveyYbocaVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			surveyYbocaVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			surveyYbocaVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			surveyYbocaVO.setCompulsion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));				//강박사고
			surveyYbocaVO.setCompulsiveBehavior(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		//강박행동
			surveyYbocaVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));
			surveyYbocaVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));
			surveyYbocaVO.setCreateBy("excel_upload");
			surveyYbocaVO.setUpdateBy("excel_upload");
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
		return surveyYbocaVO;
	}
}
