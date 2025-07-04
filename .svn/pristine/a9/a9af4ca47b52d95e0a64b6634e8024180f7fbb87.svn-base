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
import medical.neuropsy.service.NeuropsyCptVO;


public class NeuropsyCptCellReaderMapper implements CellReaderMapper<NeuropsyCptVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyCptVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyCptVO neuropsyCptVO = new NeuropsyCptVO();
		Row sheetRow;
		try{
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=3; i<22; i++) {
				str = POIUtil.getStringCellValue(sheet.getRow(row).getCell(i)).trim().replace("'","");
				strList.add(str);
				
				if(!"".equals(str) && !"x".equals(str) && !"X".equals(str)){
					dataCheck = false;
				}
			}
			if(dataCheck) {
				Cell cell;
				sheetRow =sheet.getRow(row);
				for(int i=3; i<22; i++) {
					
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("") || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					neuropsyCptVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					neuropsyCptVO.setPerformExecDate("#");
				}else {
					neuropsyCptVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			neuropsyCptVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			neuropsyCptVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'",""));
			neuropsyCptVO.setCpt3ExecDate(execDate.replace("-", ""));
			neuropsyCptVO.setDetectT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'",""));
			neuropsyCptVO.setDetectGl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			neuropsyCptVO.setOmissionT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			neuropsyCptVO.setOmissionGl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			neuropsyCptVO.setComissionT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			neuropsyCptVO.setComissionGl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			neuropsyCptVO.setPreservT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			neuropsyCptVO.setPreservGl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			neuropsyCptVO.setHrtT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			neuropsyCptVO.setHrtGl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			neuropsyCptVO.setHrtSdT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			neuropsyCptVO.setHrtSdGl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			neuropsyCptVO.setVariaT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			neuropsyCptVO.setVariaGl(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			neuropsyCptVO.setHrtBct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			neuropsyCptVO.setHrtBcg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			neuropsyCptVO.setHrtIct(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			neuropsyCptVO.setHrtIcg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'",""));
			neuropsyCptVO.setResponStyle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("'",""));
			neuropsyCptVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("'",""));
			neuropsyCptVO.setCreateBy("excel_upload");
			neuropsyCptVO.setUpdateBy("excel_upload");
			
			
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
		return neuropsyCptVO;
	}
}
