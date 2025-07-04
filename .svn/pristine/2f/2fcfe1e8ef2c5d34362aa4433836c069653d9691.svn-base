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
import medical.neuropsy.service.NeuropsyAdos2VO;


public class NeuropsyAdos2CellReaderMapper implements CellReaderMapper<NeuropsyAdos2VO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyAdos2VO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyAdos2VO NeuropsyAdos2VO = new NeuropsyAdos2VO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=4; i<14; i++) {
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
				for(int i=4; i<14; i++) {
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("")  || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					NeuropsyAdos2VO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					NeuropsyAdos2VO.setPerformExecDate("#");
				}else {
					NeuropsyAdos2VO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			NeuropsyAdos2VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			NeuropsyAdos2VO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			
			NeuropsyAdos2VO.setAdos2ExecDate(execDate.replace("-", ""));
			NeuropsyAdos2VO.setAdos2Module(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			NeuropsyAdos2VO.setAdos2Line(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
		
			NeuropsyAdos2VO.setAdos2Commu(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			
			NeuropsyAdos2VO.setGivtakeSocialInter(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			NeuropsyAdos2VO.setSocialAffTotal(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			NeuropsyAdos2VO.setRestRepetTotal(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			NeuropsyAdos2VO.setAdos2Total(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			
			NeuropsyAdos2VO.setAdos2Diagnosis(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			NeuropsyAdos2VO.setAdos2SymptomLev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			NeuropsyAdos2VO.setCompareScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			
			
			NeuropsyAdos2VO.setCreateBy("excel_upload");
			NeuropsyAdos2VO.setUpdateBy("excel_upload");
			
			
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
		return NeuropsyAdos2VO;
	}
}
