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
import medical.neuropsy.service.NeuropsyAtaVO;


public class NeuropsyAtaCellReaderMapper2 implements CellReaderMapper<NeuropsyAtaVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyAtaVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyAtaVO neuropsyAtaVO = new NeuropsyAtaVO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=4; i<20; i++) {
				str = POIUtil.getStringCellValue(sheet.getRow(row).getCell(i)).trim().replace("'","");
				strList.add(str);
				
				if(!"".equals(str) && !"x".equals(str) && !"X".equals(str)){
					dataCheck = false;
				}
			}
			
			//모두 빈값 또는 'x'이면 x로 변경
			if(dataCheck) {
				Cell cell;
				sheetRow =sheet.getRow(row);
				for(int i=4; i<20; i++) {
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("")  || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					neuropsyAtaVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					neuropsyAtaVO.setPerformExecDate("#");
				}else {
					neuropsyAtaVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			neuropsyAtaVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			neuropsyAtaVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			
			neuropsyAtaVO.setAtaExecDate(execDate.replace("-", ""));
			neuropsyAtaVO.setAtavMissz(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			neuropsyAtaVO.setAtavFalarmz(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			neuropsyAtaVO.setAtavReactzAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			neuropsyAtaVO.setAtavReactzDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			neuropsyAtaVO.setAtavMisst(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			neuropsyAtaVO.setAtavFalarmt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			neuropsyAtaVO.setAtavReacttAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			neuropsyAtaVO.setAtavReacttDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			neuropsyAtaVO.setAtahMissz(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			neuropsyAtaVO.setAtahFalarmz(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			neuropsyAtaVO.setAtahReactzAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			neuropsyAtaVO.setAtahReactzDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			neuropsyAtaVO.setAtahMisst(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			neuropsyAtaVO.setAtahFalarmt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			neuropsyAtaVO.setAtahReacttAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			neuropsyAtaVO.setAtahReacttDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			neuropsyAtaVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'",""));
			neuropsyAtaVO.setCreateBy("excel_upload");
			neuropsyAtaVO.setUpdateBy("excel_upload");
			
			
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
		return neuropsyAtaVO;
	}
}
