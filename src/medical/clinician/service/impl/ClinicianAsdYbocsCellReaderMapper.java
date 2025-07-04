package medical.clinician.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.clinician.service.ClinicianAsdYbocsVO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdYbocsVO;

public class ClinicianAsdYbocsCellReaderMapper implements CellReaderMapper<ClinicianAsdYbocsVO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public ClinicianAsdYbocsVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		ClinicianAsdYbocsVO clinicianAsdYbocsVO = new ClinicianAsdYbocsVO();
		try {
			clinicianAsdYbocsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			clinicianAsdYbocsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			clinicianAsdYbocsVO.setYbocsExecDate(execDate.replace("-", ""));
			clinicianAsdYbocsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			clinicianAsdYbocsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			clinicianAsdYbocsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			clinicianAsdYbocsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			clinicianAsdYbocsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			clinicianAsdYbocsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			clinicianAsdYbocsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			clinicianAsdYbocsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			clinicianAsdYbocsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			clinicianAsdYbocsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));
			clinicianAsdYbocsVO.setCompulsion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));				//강박사고
			clinicianAsdYbocsVO.setCompulsiveBehavior(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));		//강박행동
			clinicianAsdYbocsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));
			clinicianAsdYbocsVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));
			clinicianAsdYbocsVO.setCreateBy("excel_upload");
			clinicianAsdYbocsVO.setUpdateBy("excel_upload");
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
		return clinicianAsdYbocsVO;
	}
}
