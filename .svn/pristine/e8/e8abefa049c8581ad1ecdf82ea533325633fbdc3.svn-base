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
import medical.neuropsy.service.NeuropsyCcttVO;


public class NeuropsyCcttCellReaderMapper2 implements CellReaderMapper<NeuropsyCcttVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyCcttVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyCcttVO neuropsyCcttVO = new NeuropsyCcttVO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=4; i<22; i++) {
				str = POIUtil.getStringCellValue(sheet.getRow(row).getCell(i)).trim().replace("'","");
				strList.add(str);
				
				if(!"".equals(str) && !"x".equals(str) && !"X".equals(str)){
					dataCheck = false;
				}
			}
			if(dataCheck) {
				Cell cell;
				sheetRow =sheet.getRow(row);
				for(int i=4; i<22; i++) {
					
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("") || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					neuropsyCcttVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					neuropsyCcttVO.setPerformExecDate("#");
				}else {
					neuropsyCcttVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			neuropsyCcttVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("",""));
			neuropsyCcttVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("",""));
			neuropsyCcttVO.setCcttExecDate(execDate.replace("-", ""));
			neuropsyCcttVO.setCctt1CompleteTime(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("",""));
			neuropsyCcttVO.setCctt1Tpoint(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("",""));
			neuropsyCcttVO.setCctt1Ile(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("",""));
			neuropsyCcttVO.setCctt1DigseqErr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("",""));
			neuropsyCcttVO.setCctt1ApproxErr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("",""));
			neuropsyCcttVO.setCctt1Catalist(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("",""));
			neuropsyCcttVO.setCctt2CompleteTime(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("",""));
			neuropsyCcttVO.setCctt2Tpoint(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("",""));
			neuropsyCcttVO.setCctt2Ile(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("",""));
			neuropsyCcttVO.setCctt2ColseqErr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("",""));
			neuropsyCcttVO.setCctt2DigseqErr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("",""));
			neuropsyCcttVO.setCctt2ApproxErr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("",""));
			neuropsyCcttVO.setCctt2Catalist(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("",""));
			neuropsyCcttVO.setInterferARiir(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("",""));
			neuropsyCcttVO.setInterferAIle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("",""));
			neuropsyCcttVO.setInterferBRiir(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("",""));
			neuropsyCcttVO.setInterferBTpoint(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("",""));
			neuropsyCcttVO.setInterferBIle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("",""));
			neuropsyCcttVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("",""));
			neuropsyCcttVO.setCreateBy("excel_upload");
			neuropsyCcttVO.setUpdateBy("excel_upload");
			
			
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
		return neuropsyCcttVO;
	}
}
