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
import medical.neuropsy.service.NeuropsyPepVO;


public class NeuropsyPepCellReaderMapper implements CellReaderMapper<NeuropsyPepVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyPepVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyPepVO NeuropsyPepVO = new NeuropsyPepVO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			boolean dataCheck = true;
			List<String> strList = new ArrayList<String>();
			String str;
			
			for(int i=4; i<41; i++) {
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
				for(int i=4; i<41; i++) {
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("")  || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					NeuropsyPepVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					NeuropsyPepVO.setPerformExecDate("#");
				}else {
					NeuropsyPepVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			NeuropsyPepVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			NeuropsyPepVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			
			NeuropsyPepVO.setPepExecDate(execDate.replace("-", ""));
			NeuropsyPepVO.setBehavRelN(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			NeuropsyPepVO.setBehavRelM(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			NeuropsyPepVO.setBehavRelS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			NeuropsyPepVO.setBehavMateN(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			NeuropsyPepVO.setBehavMateM(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			NeuropsyPepVO.setBehavMateS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			NeuropsyPepVO.setBehavSenseN(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			NeuropsyPepVO.setBehavSenseM(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			NeuropsyPepVO.setBehavSenseS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			NeuropsyPepVO.setBehavLanN(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			NeuropsyPepVO.setBehavLanM(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			NeuropsyPepVO.setBehavLanS(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			NeuropsyPepVO.setDevCopyP(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			NeuropsyPepVO.setDevCopyB(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			NeuropsyPepVO.setDevCopyF(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			NeuropsyPepVO.setDevPerceptP(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			NeuropsyPepVO.setDevPerceptB(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'",""));
			NeuropsyPepVO.setDevPerceptF(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("'",""));
			NeuropsyPepVO.setDevMusclesP(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("'",""));
			NeuropsyPepVO.setDevMusclesB(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("'",""));
			NeuropsyPepVO.setDevMusclesF(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("'",""));
			NeuropsyPepVO.setDevMusclebP(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("'",""));
			NeuropsyPepVO.setDevMusclebB(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("'",""));
			NeuropsyPepVO.setDevMusclebF(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("'",""));
			NeuropsyPepVO.setDevEyehandP(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("'",""));
			NeuropsyPepVO.setDevEyehandB(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("'",""));
			NeuropsyPepVO.setDevEyehandF(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("'",""));
			NeuropsyPepVO.setDevActP(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("'",""));
			NeuropsyPepVO.setDevActB(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("'",""));
			NeuropsyPepVO.setDevActF(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("'",""));
			NeuropsyPepVO.setDevLanP(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("'",""));
			NeuropsyPepVO.setDevLanB(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("'",""));
			NeuropsyPepVO.setDevLanF(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("'",""));
			NeuropsyPepVO.setDevScore(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("'",""));
			
			NeuropsyPepVO.setPepCa(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("'",""));
			NeuropsyPepVO.setPepDa(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("'",""));
			NeuropsyPepVO.setPepDq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("'",""));
			NeuropsyPepVO.setCreateBy("excel_upload");
			NeuropsyPepVO.setUpdateBy("excel_upload");
			
			
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
		return NeuropsyPepVO;
	}
}
