package medical.neuropsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.neuropsy.service.NeuropsyStroopVO;


public class NeuropsyStroopCellReaderMapper implements CellReaderMapper<NeuropsyStroopVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyStroopVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyStroopVO neuropsyStroopVO = new NeuropsyStroopVO();
		Row sheetRow;
		try{
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=3; i<11; i++) {
				str = POIUtil.getStringCellValue(sheet.getRow(row).getCell(i)).trim().replace("'","");
				strList.add(str);
				
				if(!"".equals(str) && !"x".equals(str) && !"X".equals(str)){
					dataCheck = false;
				}
			}
			//모두 빈값 또는 '.'이면 X로 변경
			if(dataCheck) {
				Cell cell;
				sheetRow =sheet.getRow(row);
				for(int i=3; i<11; i++) {
					
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) && execDate != null) {
				if(dataCheck || strList.contains("") || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					neuropsyStroopVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					neuropsyStroopVO.setPerformExecDate("#");
				}else {
					neuropsyStroopVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			neuropsyStroopVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			neuropsyStroopVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'",""));
			neuropsyStroopVO.setStroopExecDate(execDate.replace("-", ""));
			neuropsyStroopVO.setWordR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'",""));
			neuropsyStroopVO.setColorR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			neuropsyStroopVO.setColorwordR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			neuropsyStroopVO.setInterferR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			neuropsyStroopVO.setWordT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			neuropsyStroopVO.setColorT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			neuropsyStroopVO.setColorwordT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			neuropsyStroopVO.setInterferT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			neuropsyStroopVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			neuropsyStroopVO.setCreateBy("excel_upload");
			neuropsyStroopVO.setUpdateBy("excel_upload");
			
			
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
		return neuropsyStroopVO;
	}
}
