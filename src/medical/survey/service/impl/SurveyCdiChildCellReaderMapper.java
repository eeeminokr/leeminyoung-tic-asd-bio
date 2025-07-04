package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyCdiChildVO;

public class SurveyCdiChildCellReaderMapper implements CellReaderMapper<SurveyCdiChildVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyCdiChildVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		SurveyCdiChildVO surveyCdiChildVO = new SurveyCdiChildVO();
		try {
			surveyCdiChildVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyCdiChildVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyCdiChildVO.setCdiChildExecDate(execDate.replace("-", ""));
			surveyCdiChildVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		
			surveyCdiChildVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		
			surveyCdiChildVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		
			surveyCdiChildVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		
			surveyCdiChildVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		
			surveyCdiChildVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		
			surveyCdiChildVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		
			surveyCdiChildVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		
			surveyCdiChildVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		
			surveyCdiChildVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	
			surveyCdiChildVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	
			surveyCdiChildVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	
			surveyCdiChildVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	
			surveyCdiChildVO.setA14(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	
			surveyCdiChildVO.setA15(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));	
			surveyCdiChildVO.setA16(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));	
			surveyCdiChildVO.setA17(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));	
			surveyCdiChildVO.setA18(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));			
			surveyCdiChildVO.setA19(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));	
			surveyCdiChildVO.setA20(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));	
			surveyCdiChildVO.setA21(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("",""));	
			surveyCdiChildVO.setA22(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("",""));	
			surveyCdiChildVO.setA23(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("",""));	
			surveyCdiChildVO.setA24(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("",""));	
			surveyCdiChildVO.setA25(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("",""));	
			surveyCdiChildVO.setA26(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("",""));	
			surveyCdiChildVO.setA27(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));
			surveyCdiChildVO.setTotalScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));
			surveyCdiChildVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("",""));
			surveyCdiChildVO.setCreateBy("excel_upload");
			surveyCdiChildVO.setUpdateBy("excel_upload");	
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
		return surveyCdiChildVO;
	}
}
