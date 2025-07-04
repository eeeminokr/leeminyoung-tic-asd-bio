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
import medical.neuropsy.service.NeuropsyAdos3VO;


public class NeuropsyAdos3CellReaderMapper implements CellReaderMapper<NeuropsyAdos3VO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyAdos3VO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyAdos3VO NeuropsyAdos3VO = new NeuropsyAdos3VO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
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
					NeuropsyAdos3VO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					NeuropsyAdos3VO.setPerformExecDate("#");
				}else {
					NeuropsyAdos3VO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			NeuropsyAdos3VO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			NeuropsyAdos3VO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			
			NeuropsyAdos3VO.setAdos3ExecDate(execDate.replace("-", ""));
			NeuropsyAdos3VO.setCommunication(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			NeuropsyAdos3VO.setRecSocialInter(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			NeuropsyAdos3VO.setCommuSocialInter(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			NeuropsyAdos3VO.setA3StereoInterest(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			NeuropsyAdos3VO.setAdos3Total(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			NeuropsyAdos3VO.setCreateBy("excel_upload");
			NeuropsyAdos3VO.setUpdateBy("excel_upload");
			
			
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
		return NeuropsyAdos3VO;
	}
}
