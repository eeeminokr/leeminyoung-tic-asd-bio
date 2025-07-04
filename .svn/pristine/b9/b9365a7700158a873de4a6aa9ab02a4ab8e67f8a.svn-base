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
import medical.neuropsy.service.NeuropsyCarsVO;


public class NeuropsyCarsCellReaderMapper implements CellReaderMapper<NeuropsyCarsVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyCarsVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyCarsVO NeuropsyCarsVO = new NeuropsyCarsVO();
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
				}			}
			
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
					NeuropsyCarsVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					NeuropsyCarsVO.setPerformExecDate("#");
				}else {
					NeuropsyCarsVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			NeuropsyCarsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
//			NeuropsyCarsVO.setTargetDisId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(1)).trim().replace("'",""));
			NeuropsyCarsVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			
			NeuropsyCarsVO.setCarsExecDate(execDate.replace("-", ""));
			
			NeuropsyCarsVO.setSubPsRelation(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			NeuropsyCarsVO.setSubImitation(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			NeuropsyCarsVO.setSubEmoRact(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			NeuropsyCarsVO.setSubBodyuse(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			NeuropsyCarsVO.setSubObjuse(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			NeuropsyCarsVO.setSubChgAdapt(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			NeuropsyCarsVO.setSubVisualRact(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			NeuropsyCarsVO.setSubAuditoryRact(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			NeuropsyCarsVO.setSubEtcRactUse(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			NeuropsyCarsVO.setSubFearNervous(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			NeuropsyCarsVO.setSubVerbCommu(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			NeuropsyCarsVO.setSubNonverbCommu(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			NeuropsyCarsVO.setSubActlev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			NeuropsyCarsVO.setSubIntellevCstc(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			NeuropsyCarsVO.setSubGeneralEft(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			
			NeuropsyCarsVO.setCarsTotal(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			NeuropsyCarsVO.setCreateBy("excel_upload");
			NeuropsyCarsVO.setUpdateBy("excel_upload");
			
			
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
		return NeuropsyCarsVO;
	}
}
