package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyYgtssVO;

public class SurveyYgtssCellReaderMapper implements CellReaderMapper<SurveyYgtssVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyYgtssVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyYgtssVO surveyYgtssVO = new SurveyYgtssVO();
		try {
			surveyYgtssVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyYgtssVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyYgtssVO.setYgtssExecDate(execDate.replace("-", ""));
			surveyYgtssVO.setM1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));
			surveyYgtssVO.setV1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			surveyYgtssVO.setM2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			surveyYgtssVO.setV2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			surveyYgtssVO.setM3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			surveyYgtssVO.setV3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			surveyYgtssVO.setM4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			surveyYgtssVO.setV4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			surveyYgtssVO.setM5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			surveyYgtssVO.setV5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			surveyYgtssVO.setDisabilityDegree(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	//장애도
			surveyYgtssVO.setmScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));			//근육점수
			surveyYgtssVO.setvScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));			//음성점수
			surveyYgtssVO.setTotalTic(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));			//전체틱
			surveyYgtssVO.setTotalYgtss(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));		//전체 YGTSS
			surveyYgtssVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));
			surveyYgtssVO.setCreateBy("excel_upload");
			surveyYgtssVO.setUpdateBy("excel_upload");
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
		return surveyYgtssVO;
	}
}
