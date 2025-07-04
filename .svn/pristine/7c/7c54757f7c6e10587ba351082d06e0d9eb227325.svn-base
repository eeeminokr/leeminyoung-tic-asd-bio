package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyStroopVO;

public class NeuropsyStroopWriterMapper2 implements CellWriterMapper<NeuropsyStroopVO>{
	@Override
	public void mapHeader(Row row, NeuropsyStroopVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
			
		cell = row.createCell(0);
		cell.setCellValue("질병군");	
		
		cell = row.createCell(1);
		cell.setCellValue("연구번호");
		cell = row.createCell(2);

		
		cell = row.createCell(3);
		cell.setCellValue("성별");
	

		cell = row.createCell(4);
		cell.setCellValue("차수");

		cell = row.createCell(5);
		cell.setCellValue("나이");

		cell = row.createCell(6);
		cell.setCellValue("실시일");	
		
		cell = row.createCell(7);
		cell.setCellValue("STROOP");
		cell = row.createCell(14);
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("뇌원천");
			cell = row.createCell(i++);
			cell.setCellValue("뇌질환");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++);
			cell.setCellValue("단어R");
			cell = row.createCell(i++);
			cell.setCellValue("색상R");
			cell = row.createCell(i++);
			cell.setCellValue("색상-단어R");
			cell = row.createCell(i++);
			cell.setCellValue("간섭R");
			cell = row.createCell(i++);
			cell.setCellValue("단어T");
			cell = row.createCell(i++);
			cell.setCellValue("색상T");
			cell = row.createCell(i++);
			cell.setCellValue("색상-단어T");
			cell = row.createCell(i++);
			cell.setCellValue("간섭T");
		}
		

		
		
	}

	@Override
	public void mapRow(Row row, NeuropsyStroopVO vo) {
		Cell cell = null;
		int i = 0;
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getDisClassDtl());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetDisId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());



		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getStroopExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getWordR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getColorR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getColorwordR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterferR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getWordT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getColorT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getColorwordT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterferT());
	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
	
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 14));
	}
	
}
