package medical.clinician.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.clinician.service.ClinicianAsdSrs01VO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdSrs01VO;

public class ClinicianAsdSrs01CellReaderMapper implements CellReaderMapper<ClinicianAsdSrs01VO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public ClinicianAsdSrs01VO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		ClinicianAsdSrs01VO clinicianAsdSrs01VO = new ClinicianAsdSrs01VO();
		try {
			clinicianAsdSrs01VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			clinicianAsdSrs01VO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			clinicianAsdSrs01VO.setSrs01ExecDate(execDate.replace("-", ""));
			clinicianAsdSrs01VO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		//약물종류
			clinicianAsdSrs01VO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		//용량
			clinicianAsdSrs01VO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		//불면
			clinicianAsdSrs01VO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		//악몽
			clinicianAsdSrs01VO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		//멍함
			clinicianAsdSrs01VO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		//말수줌
			clinicianAsdSrs01VO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		//관심저하
			clinicianAsdSrs01VO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		//식욕저하
			clinicianAsdSrs01VO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		//짜증
			clinicianAsdSrs01VO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	//복통
			clinicianAsdSrs01VO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	//두통
			clinicianAsdSrs01VO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	//졸림
			clinicianAsdSrs01VO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	//슬픔	
			clinicianAsdSrs01VO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	//울먹임
			clinicianAsdSrs01VO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	//불안함
			clinicianAsdSrs01VO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	//손톱깨묾
			clinicianAsdSrs01VO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	//들뜸
			clinicianAsdSrs01VO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	//현기증
			clinicianAsdSrs01VO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	//틱
			clinicianAsdSrs01VO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			clinicianAsdSrs01VO.setCreateBy("excel_upload");
			clinicianAsdSrs01VO.setUpdateBy("excel_upload");
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
		return clinicianAsdSrs01VO;
	}
}
