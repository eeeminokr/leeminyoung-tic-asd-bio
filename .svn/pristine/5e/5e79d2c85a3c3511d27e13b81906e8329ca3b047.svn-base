package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyPerformMstVO;

public class SurveyCvCellReaderMapper implements CellReaderMapper<SurveyPerformMstVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyPerformMstVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyPerformMstVO surveyPerformMstVO = new SurveyPerformMstVO();
		try {
			surveyPerformMstVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyPerformMstVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyPerformMstVO.setExecDate(execDate.replace("-", ""));
			surveyPerformMstVO.setCvCgiS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyPerformMstVO.setCvCgiI(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyPerformMstVO.setCvCGas(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyPerformMstVO.setCreateBy("excel_upload");
			surveyPerformMstVO.setUpdateBy("excel_upload");	
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
		return surveyPerformMstVO;
	}
}
