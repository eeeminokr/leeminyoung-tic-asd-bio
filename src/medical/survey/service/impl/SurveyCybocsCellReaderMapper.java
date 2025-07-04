package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyCybocsVO;

public class SurveyCybocsCellReaderMapper implements CellReaderMapper<SurveyCybocsVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	@Override
	public SurveyCybocsVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyCybocsVO surveyCybocsVO = new SurveyCybocsVO();
		try {
			surveyCybocsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyCybocsVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyCybocsVO.setCybocsExecDate(execDate.replace("-", ""));
			surveyCybocsVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));
			surveyCybocsVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			surveyCybocsVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			surveyCybocsVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			surveyCybocsVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			surveyCybocsVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			surveyCybocsVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			surveyCybocsVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			surveyCybocsVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			surveyCybocsVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			surveyCybocsVO.setCompulsion(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));				//강박사고
			surveyCybocsVO.setCompulsiveBehavior(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));		//강박행동
			surveyCybocsVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));
			surveyCybocsVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));
			surveyCybocsVO.setCreateBy("excel_upload");
			surveyCybocsVO.setUpdateBy("excel_upload");	
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
		return surveyCybocsVO;
	}
}
