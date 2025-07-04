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
import medical.neuropsy.service.NeuropsyCatVO;


public class NeuropsyCatCellReaderMapper2 implements CellReaderMapper<NeuropsyCatVO> {

	protected final Log logger = LogFactory.getLog(getClass());
	
	@Override
	public NeuropsyCatVO mapCell(Sheet sheet, int col, int row)
			throws CellReaderMapperException {
		
		NeuropsyCatVO neuropsyCatVO = new NeuropsyCatVO();
		Row sheetRow;
		try{
			
			//데이터 여부 체크
			boolean dataCheck = true;
			String execDate = POIUtil.getStringCellValue(sheet.getRow(row).getCell(3)).trim().replace("'","");
			List<String> strList = new ArrayList<String>();
			String str;
			
			
			for(int i=4; i<52; i++) {
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
				for(int i=4; i<52; i++) {
					
					cell = sheetRow.createCell(i);
					cell.setCellValue("x");
				}
			}
			//빈값이 있으면 데이터 통합분석 Z로 표시
			//데이터를 받을 필요가 없는 경우 #
			if(!"".equals(execDate) || execDate == null) {
				if(dataCheck || strList.contains("") || strList.contains(null) || strList.contains("x") || strList.contains("X")) {
					neuropsyCatVO.setPerformExecDate("Z");
				}else if(strList.contains("#")) {
					neuropsyCatVO.setPerformExecDate("#");
				}else {
					neuropsyCatVO.setPerformExecDate(execDate.replace("-", ""));
				}
			}
			
			neuropsyCatVO.setTargetId(POIUtil.getStringCellValue(sheet.getRow(row).getCell(0)).trim().replace("'",""));
			neuropsyCatVO.setPerformCntNm(POIUtil.getStringCellValue(sheet.getRow(row).getCell(2)).trim().replace("'",""));
			neuropsyCatVO.setCatExecDate(execDate.replace("-", ""));
			neuropsyCatVO.setCatvMissr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(4)).trim().replace("'",""));
			neuropsyCatVO.setCatvFalarmr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(5)).trim().replace("'",""));
			neuropsyCatVO.setCatvReactrAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(6)).trim().replace("'",""));
			neuropsyCatVO.setCatvReactrDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(7)).trim().replace("'",""));
			neuropsyCatVO.setCatvMissaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(8)).trim().replace("'",""));
			neuropsyCatVO.setCatvFalarmaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(9)).trim().replace("'",""));
			neuropsyCatVO.setCatvReactaqAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(10)).trim().replace("'",""));
			neuropsyCatVO.setCatvReactaqDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(11)).trim().replace("'",""));
			neuropsyCatVO.setCathMissr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(12)).trim().replace("'",""));
			neuropsyCatVO.setCathFalarmr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(13)).trim().replace("'",""));
			neuropsyCatVO.setCathReactrAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(14)).trim().replace("'",""));
			neuropsyCatVO.setCathReactrDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(15)).trim().replace("'",""));
			neuropsyCatVO.setCathMissaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(16)).trim().replace("'",""));
			neuropsyCatVO.setCathFalarmaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(17)).trim().replace("'",""));
			neuropsyCatVO.setCathReactaqAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(18)).trim().replace("'",""));
			neuropsyCatVO.setCathReactaqDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(19)).trim().replace("'",""));
			neuropsyCatVO.setCatcMissr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(20)).trim().replace("'",""));
			neuropsyCatVO.setCatcFalarmr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(21)).trim().replace("'",""));
			neuropsyCatVO.setCatcReactrAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(22)).trim().replace("'",""));
			neuropsyCatVO.setCatcReactrDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(23)).trim().replace("'",""));
			neuropsyCatVO.setCatcMissaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(24)).trim().replace("'",""));
			neuropsyCatVO.setCatcFalarmaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(25)).trim().replace("'",""));
			neuropsyCatVO.setCatcReactaqAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(26)).trim().replace("'",""));
			neuropsyCatVO.setCatcReactaqDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(27)).trim().replace("'",""));
			neuropsyCatVO.setCatiMissr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(28)).trim().replace("'",""));
			neuropsyCatVO.setCatiFalarmr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(29)).trim().replace("'",""));
			neuropsyCatVO.setCatiReactrAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(30)).trim().replace("'",""));
			neuropsyCatVO.setCatiReactrDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(31)).trim().replace("'",""));
			neuropsyCatVO.setCatiMissaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(32)).trim().replace("'",""));
			neuropsyCatVO.setCatiFalarmaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(33)).trim().replace("'",""));
			neuropsyCatVO.setCatiReactaqAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(34)).trim().replace("'",""));
			neuropsyCatVO.setCatiReactaqDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(35)).trim().replace("'",""));
			neuropsyCatVO.setCatdMissr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(36)).trim().replace("'",""));
			neuropsyCatVO.setCatdFalarmr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(37)).trim().replace("'",""));
			neuropsyCatVO.setCatdReactrAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(38)).trim().replace("'",""));
			neuropsyCatVO.setCatdReactrDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(39)).trim().replace("'",""));
			neuropsyCatVO.setCatdMissaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(40)).trim().replace("'",""));
			neuropsyCatVO.setCatdFalarmaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(41)).trim().replace("'",""));
			neuropsyCatVO.setCatdReactaqAvg(POIUtil.getStringCellValue(sheet.getRow(row).getCell(42)).trim().replace("'",""));
			neuropsyCatVO.setCatdReactaqDev(POIUtil.getStringCellValue(sheet.getRow(row).getCell(43)).trim().replace("'",""));
			neuropsyCatVO.setCatmdReactr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(44)).trim().replace("'",""));
			neuropsyCatVO.setCatmrReactr(POIUtil.getStringCellValue(sheet.getRow(row).getCell(45)).trim().replace("'",""));
			neuropsyCatVO.setCatmdSpacer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(46)).trim().replace("'",""));
			neuropsyCatVO.setCatmrSpacer(POIUtil.getStringCellValue(sheet.getRow(row).getCell(47)).trim().replace("'",""));
			neuropsyCatVO.setCatmdReactaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(48)).trim().replace("'",""));
			neuropsyCatVO.setCatmrReactaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(49)).trim().replace("'",""));
			neuropsyCatVO.setCatmdSpaceaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(50)).trim().replace("'",""));
			neuropsyCatVO.setCatmrSpaceaq(POIUtil.getStringCellValue(sheet.getRow(row).getCell(51)).trim().replace("'",""));
			neuropsyCatVO.setRemarks(POIUtil.getStringCellValue(sheet.getRow(row).getCell(52)).trim().replace("'",""));
			neuropsyCatVO.setCreateBy("excel_upload");
			neuropsyCatVO.setUpdateBy("excel_upload");
			
			
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
		return neuropsyCatVO;
	}
}
