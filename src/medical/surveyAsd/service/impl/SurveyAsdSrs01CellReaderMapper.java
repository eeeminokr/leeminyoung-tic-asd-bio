package medical.surveyAsd.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.surveyAsd.service.SurveyAsdSrs01VO;

public class SurveyAsdSrs01CellReaderMapper implements CellReaderMapper<SurveyAsdSrs01VO>{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyAsdSrs01VO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		SurveyAsdSrs01VO surveyAsdSrsVO = new SurveyAsdSrs01VO();
		try {
			surveyAsdSrsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyAsdSrsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("","");
			surveyAsdSrsVO.setSrs01ExecDate(execDate.replace("-", ""));
			surveyAsdSrsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		//약물종류
			surveyAsdSrsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		//용량
			surveyAsdSrsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		//불면
			surveyAsdSrsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		//악몽
			surveyAsdSrsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		//멍함
			surveyAsdSrsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		//말수줌
			surveyAsdSrsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		//관심저하
			surveyAsdSrsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		//식욕저하
			surveyAsdSrsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));		//짜증
			surveyAsdSrsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	//복통
			surveyAsdSrsVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	//두통
			surveyAsdSrsVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	//졸림
			surveyAsdSrsVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	//슬픔	
			surveyAsdSrsVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	//울먹임
			surveyAsdSrsVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	//불안함
			surveyAsdSrsVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	//손톱깨묾
			surveyAsdSrsVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));	//들뜸
			surveyAsdSrsVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	//현기증
			surveyAsdSrsVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	//틱
			surveyAsdSrsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));
			surveyAsdSrsVO.setCreateBy("excel_upload");
			surveyAsdSrsVO.setUpdateBy("excel_upload");
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
		return surveyAsdSrsVO;
	}
}
