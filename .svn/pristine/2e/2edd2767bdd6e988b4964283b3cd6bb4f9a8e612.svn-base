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
import medical.neuropsy.service.NeuropsyExitiiVO;


public class NeuropsyExitiiCellReaderMapper implements CellReaderMapper<NeuropsyExitiiVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyExitiiVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyExitiiVO neuropsyExitiiVO = new NeuropsyExitiiVO();
		Row sheetRow;
		try{
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=3; i<33; i++) {
				str = POIUtil.getStringCellValue(sheet.getRow(row).getCell(i)).trim().replace("'","");
				strList.add(str);
				
				if(!"".equals(str) && !"x".equals(str) && !"X".equals(str)){
					dataCheck = false;
				}
			}
			if(dataCheck) {
				Cell cell;
				sheetRow =sheet.getRow(row);
				for(int i=3; i<33; i++) {
					
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("") || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					neuropsyExitiiVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					neuropsyExitiiVO.setPerformExecDate("#");
				}else {
					neuropsyExitiiVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			neuropsyExitiiVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			neuropsyExitiiVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiExecDate(execDate.replace("-", ""));
			neuropsyExitiiVO.setExitiiStroopStos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiStroopStt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiStroopSeos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiStroopSet(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiStroopItos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiStroopItt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiStroopIeos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiStroopIet(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiWordfqRaos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiWordfqRat(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiWordfqBaos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiWordfqBat(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiWordfqLaos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiWordfqLat(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiDesignRaos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiDesignRat(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiDesignLaos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiDesignLat(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiAvltDmos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiAvltDmt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiAvltDjos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiAvltDjt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiCftPos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiCftPt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiCftDos(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiCftDt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiEfqEss(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiEfqNis(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiEfqPercentile(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("'",""));
			neuropsyExitiiVO.setExitiiEfqEval(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("'",""));
			neuropsyExitiiVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("'",""));
			neuropsyExitiiVO.setCreateBy("excel_upload");
			neuropsyExitiiVO.setUpdateBy("excel_upload");
			
			
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
		return neuropsyExitiiVO;
	}
}
