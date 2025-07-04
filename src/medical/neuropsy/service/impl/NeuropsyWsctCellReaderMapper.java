package medical.neuropsy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.file.mapping.CellReaderMapperException;
import medical.framework.util.POIUtil;
import medical.neuropsy.service.NeuropsyWsctVO;


public class NeuropsyWsctCellReaderMapper implements CellReaderMapper<NeuropsyWsctVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyWsctVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyWsctVO NeuropsyWsctVO = new NeuropsyWsctVO();
		Row sheetRow;
		try{
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=3; i<19; i++) {
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
				for(int i=3; i<19; i++) {
					
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("")|| strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					NeuropsyWsctVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					NeuropsyWsctVO.setPerformExecDate("#");
				}else {
					NeuropsyWsctVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			NeuropsyWsctVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			NeuropsyWsctVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'",""));
			NeuropsyWsctVO.setWsctExecDate(execDate.replace("-", ""));
			NeuropsyWsctVO.setTotalErrorsR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'",""));
			NeuropsyWsctVO.setTotalErrorsS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			NeuropsyWsctVO.setTotalErrorsT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			DataFormatter formatter = new DataFormatter();
			String TotalErrorIle = formatter.formatCellValue(sheet.getRow(row).getCell(6));
			NeuropsyWsctVO.setTotalErrorsIle(TotalErrorIle);
			NeuropsyWsctVO.setPerseverResponT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			NeuropsyWsctVO.setPerseverErrorT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			NeuropsyWsctVO.setNonperseverErrorT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			NeuropsyWsctVO.setConcepResponT(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			NeuropsyWsctVO.setCategoryCompleteR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			NeuropsyWsctVO.setTrialCompleteR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			NeuropsyWsctVO.setFailureR(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			NeuropsyWsctVO.setIngtoLearn(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			NeuropsyWsctVO.setCategoryCompleteIle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			NeuropsyWsctVO.setTrialCompleteIle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			NeuropsyWsctVO.setFailureIle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			NeuropsyWsctVO.setIngtoLearnIle(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			NeuropsyWsctVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			NeuropsyWsctVO.setCreateBy("excel_upload");
			NeuropsyWsctVO.setUpdateBy("excel_upload");
			
			
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
		return NeuropsyWsctVO;
	}
}
