package medical.analysis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import medical.analysis.service.AnalysisTAnalSnpVO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;

public class AnalysisSnpCellReaderMapper implements CellReaderMapper<AnalysisTAnalSnpVO> {
protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public AnalysisTAnalSnpVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		AnalysisTAnalSnpVO AnalysisSnpVO = new AnalysisTAnalSnpVO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=4; i<9; i++) {
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
				for(int i=4; i<9; i++) {
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("")  || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					AnalysisSnpVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					AnalysisSnpVO.setPerformExecDate("#");
				}else {
					AnalysisSnpVO.setPerformExecDate(execDate);
				}
			}
			
			AnalysisSnpVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			AnalysisSnpVO.setCollectDate(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","").replace("-", ""));
			AnalysisSnpVO.setAnalDate(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","").replace("-", ""));
			AnalysisSnpVO.setRs2254298(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			AnalysisSnpVO.setRs53576(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			AnalysisSnpVO.setRs7794745(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			AnalysisSnpVO.setRs2710126(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			AnalysisSnpVO.setRs1045881(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			AnalysisSnpVO.setRs858932(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			AnalysisSnpVO.setCreateBy("excel_upload");
			AnalysisSnpVO.setUpdateBy("excel_upload");
			AnalysisSnpVO.setSnpExecDate(execDate.replace("-", ""));
			
			
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
		return AnalysisSnpVO;
	}
}
