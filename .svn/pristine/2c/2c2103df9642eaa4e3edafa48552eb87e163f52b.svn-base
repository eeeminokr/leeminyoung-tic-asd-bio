package medical.survey.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.survey.service.SurveyCbclVO;

public class SurveyCbclCellReaderMapper implements CellReaderMapper<SurveyCbclVO>{

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public SurveyCbclVO mapCell(Sheet sheet, int col, int row) 
			throws CellReaderMapperException {
		
		SurveyCbclVO surveyCbclVO = new SurveyCbclVO();
		try {
			surveyCbclVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			surveyCbclVO.setPerformCnt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("",""));
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("","");
			surveyCbclVO.setCbclExecDate(execDate.replace("-", ""));
			surveyCbclVO.setA1(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("",""));		  
			surveyCbclVO.setA2(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));		  
			surveyCbclVO.setA3(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));		  
			surveyCbclVO.setA4(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));		  
			surveyCbclVO.setA5(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));		  
			surveyCbclVO.setA6(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));		  
			surveyCbclVO.setA7(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));		  
			surveyCbclVO.setA8(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));		  
			surveyCbclVO.setA9(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));		  
			surveyCbclVO.setA10(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));	  
			surveyCbclVO.setA11(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));	  
			surveyCbclVO.setA12(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));	  
			surveyCbclVO.setA13(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));	  
			surveyCbclVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));	 
			surveyCbclVO.setCreateBy("excel_upload");
			surveyCbclVO.setUpdateBy("excel_upload");	
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
		return surveyCbclVO;
	}
}
