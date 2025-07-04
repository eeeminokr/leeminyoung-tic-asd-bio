package medical.clinician.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.clinician.service.ClinicianAsdPerformMstVO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdPerformMstVO;

public class ClinicianAsdCvCellReaderMapper implements CellReaderMapper<ClinicianAsdPerformMstVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public ClinicianAsdPerformMstVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		ClinicianAsdPerformMstVO clinicianAsdPerformMstVO = new ClinicianAsdPerformMstVO();
		try {
			clinicianAsdPerformMstVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			clinicianAsdPerformMstVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			clinicianAsdPerformMstVO.setExecDate(execDate.replace("-", ""));
			clinicianAsdPerformMstVO.setCvCgiS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			clinicianAsdPerformMstVO.setCvCgiI(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			clinicianAsdPerformMstVO.setCvCGas(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			clinicianAsdPerformMstVO.setCreateBy("excel_upload");
			clinicianAsdPerformMstVO.setUpdateBy("excel_upload");	
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
		return clinicianAsdPerformMstVO;
	}
}
