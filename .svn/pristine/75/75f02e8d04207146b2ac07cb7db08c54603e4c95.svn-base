package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyCptVO;

public class NeuropsyCptWriterMapper implements CellWriterMapper<NeuropsyCptVO>{
	@Override
	public void mapHeader(Row row, NeuropsyCptVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("연구번호");

		cell = row.createCell(i++);
		cell.setCellValue("성별");

		cell = row.createCell(i++);
		cell.setCellValue("프로토콜");	

		cell = row.createCell(i++);
		cell.setCellValue("차수");

		cell = row.createCell(i++);
		cell.setCellValue("나이");

		cell = row.createCell(i++);
		cell.setCellValue("실시일");	
		
		cell = row.createCell(i++);
		cell.setCellValue("CPT-3");
		
		cell = row.createCell(13);
		cell.setCellValue("Cpt(청각)");	
		cell = row.createCell(24);
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("Detectability T");
			cell = row.createCell(i++);
			cell.setCellValue("Detectabilirt Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("Omissions T");
			cell = row.createCell(i++);
			cell.setCellValue("Omissions Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("Comissions T");
			cell = row.createCell(i++);
			cell.setCellValue("Comissions Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("Perserverations T");
			cell = row.createCell(i++);
			cell.setCellValue("Perserverations Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT T");
			cell = row.createCell(i++);
			cell.setCellValue(" HRT Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT SD T ");
			cell = row.createCell(i++);
			cell.setCellValue("HRT SD Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("variability T");
			cell = row.createCell(i++);
			cell.setCellValue("variability Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT Block Change T");
			cell = row.createCell(i++);
			cell.setCellValue("HRT Block Change Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT ISI Change T ");
			cell = row.createCell(i++);
			cell.setCellValue("HRT ISI Change Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("response style");
			
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyCptVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCpt3ExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDetectT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDetectGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getOmissionT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getOmissionGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getComissionT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getComissionGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPreservT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPreservGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtSdT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtSdGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getVariaT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getVariaGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtBct());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtBcg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtIct());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtIcg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getResponStyle());

	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 24));
		
	}
	
}
