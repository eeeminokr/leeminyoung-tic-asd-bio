package medical.imagingInfo.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Sheet;

import medical.dataIntegration.service.DataIntegrationListVO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;

public class ImagingInfoCellReaderMapper implements CellReaderMapper<DataIntegrationListVO>{
	protected final Log logger = LogFactory.getLog(getClass());
	public DataIntegrationListVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		DataIntegrationListVO diVo = new DataIntegrationListVO();
		try {
			diVo.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			diVo.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'","").toUpperCase());
			diVo.setPocral(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","").toLowerCase());
			diVo.setCreateBy("excel_upload");
			diVo.setUpdateBy("excel_upload");
		}catch(Exception e) {
			if(logger.isDebugEnabled()){
				logger.error("[Error Message] There is an Exception while mapping between cells and the object!!");
				logger.error("[Error Line] Col : " + col + ", Row : " + (row + 1) );
				logger.error("[Error Detail]");
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			throw new CellReaderMapperException("There is an Exception on CellMapper!!");
		}
		return diVo;
	}
}
