package medical.clinician.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.clinician.service.ClinicianAsdCybocsVO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdCybocsVO;

public class ClinicianAsdCybocsCellReaderMapper implements CellReaderMapper<ClinicianAsdCybocsVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public ClinicianAsdCybocsVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		ClinicianAsdCybocsVO clinicianAsdCybocsVO = new ClinicianAsdCybocsVO();
		try {
			clinicianAsdCybocsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			clinicianAsdCybocsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			clinicianAsdCybocsVO.setCybocsExecDate(execDate.replace("-", ""));
			clinicianAsdCybocsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			clinicianAsdCybocsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			clinicianAsdCybocsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			clinicianAsdCybocsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			clinicianAsdCybocsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			clinicianAsdCybocsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			clinicianAsdCybocsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			clinicianAsdCybocsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			clinicianAsdCybocsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			clinicianAsdCybocsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));
			clinicianAsdCybocsVO.setCompulsion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));				//강박사고
			clinicianAsdCybocsVO.setCompulsiveBehavior(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		//강박행동
			clinicianAsdCybocsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));
			clinicianAsdCybocsVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));
			clinicianAsdCybocsVO.setCreateBy("excel_upload");
			clinicianAsdCybocsVO.setUpdateBy("excel_upload");	
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
		return clinicianAsdCybocsVO;
	}
}
