package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdPerformMstVO;

public class SurveyAsdCvCellReaderMapper implements CellReaderMapper<SurveyAsdPerformMstVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdPerformMstVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyAsdPerformMstVO surveyAsdPerformMstVO = new SurveyAsdPerformMstVO();
		try {
			surveyAsdPerformMstVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdPerformMstVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdPerformMstVO.setExecDate(execDate.replace("-", ""));
			surveyAsdPerformMstVO.setCvCgiS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyAsdPerformMstVO.setCvCgiI(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyAsdPerformMstVO.setCvCGas(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyAsdPerformMstVO.setCreateBy("excel_upload");
			surveyAsdPerformMstVO.setUpdateBy("excel_upload");	
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
		return surveyAsdPerformMstVO;
	}
}
