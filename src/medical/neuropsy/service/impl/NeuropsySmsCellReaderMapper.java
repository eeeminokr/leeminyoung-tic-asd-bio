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
import medical.neuropsy.service.NeuropsySmsVO;


public class NeuropsySmsCellReaderMapper implements CellReaderMapper<NeuropsySmsVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsySmsVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsySmsVO NeuropsySmsVO = new NeuropsySmsVO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			System.out.println("sms업로드 파일 입성!!!!!!!!!!!!!!!!!!!");
			
			
			System.out.println(execDate+" :SMS READER 엑셀 EXECDATE");
			
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
				for(int j=4; j<14; j++) {
					cell = sheetRow.createCell(j);
					cell.setCellValue("x");
				}
			}
			
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("")  || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					NeuropsySmsVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					NeuropsySmsVO.setPerformExecDate("#");
				}else {
					NeuropsySmsVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			NeuropsySmsVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			NeuropsySmsVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			
			NeuropsySmsVO.setSmsExecDate(execDate.replace("-", ""));
			
			
			
			NeuropsySmsVO.setSubMovecap(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			NeuropsySmsVO.setSubCommucap(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			NeuropsySmsVO.setSubSocialcap(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			NeuropsySmsVO.setSubWorkcap(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			NeuropsySmsVO.setSubSelfmanagecap(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			NeuropsySmsVO.setSubBasicapGeneral(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			NeuropsySmsVO.setSubBasicapDressing(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			NeuropsySmsVO.setSubBasicapEating(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));

			NeuropsySmsVO.setSmsSa(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			NeuropsySmsVO.setSmsSq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			NeuropsySmsVO.setCreateBy("excel_upload");
			NeuropsySmsVO.setUpdateBy("excel_upload");
			
			
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
		return NeuropsySmsVO;
	}
}
