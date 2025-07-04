package medical.analysis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.neuropsy.service.NeuropsyAdos1VO;


public class AnalysisEnvMattCellReaderMapper implements CellReaderMapper<AnalysisTAnalEnvMattVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public AnalysisTAnalEnvMattVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		AnalysisTAnalEnvMattVO analysisEnvMattVO = new AnalysisTAnalEnvMattVO();
		Row sheetRow;
		try{
			
			
			
			
			
			//데이터 여부 체크
			String execDate1 = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			String execDate2 = POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=4; i<16; i++) {
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
				for(int i=4; i<16; i++) {
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate1) || execDate1 == null) {
				if(dataCheck || strList.contains("")  || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					analysisEnvMattVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					analysisEnvMattVO.setPerformExecDate("#");
				}else {
					analysisEnvMattVO.setPerformExecDate(execDate1.replace("-", ""));
				
				}
			}
			
			
			
			analysisEnvMattVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			analysisEnvMattVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			analysisEnvMattVO.setCollectDate(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","").replace("-",""));
			

			
			
			analysisEnvMattVO.setAnalDate(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'","").replace("-",""));
			
			
			analysisEnvMattVO.setCreatinine(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			analysisEnvMattVO.setCot(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			analysisEnvMattVO.setCotCreatinine(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			analysisEnvMattVO.setMehhp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			analysisEnvMattVO.setMehhpCreatinine(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			analysisEnvMattVO.setMeohp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			analysisEnvMattVO.setMeohpCreatinine(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			analysisEnvMattVO.setMnbp(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			analysisEnvMattVO.setMnbpCreatinine(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			analysisEnvMattVO.setThreePba(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			analysisEnvMattVO.setThreePbaCreatinine(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			analysisEnvMattVO.setCreateBy("excel_upload");
			analysisEnvMattVO.setUpdateBy("excel_upload");
			analysisEnvMattVO.setEnvMattExecDate(execDate1.replace("-",""));
			
			
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
		return analysisEnvMattVO;
		}
}
