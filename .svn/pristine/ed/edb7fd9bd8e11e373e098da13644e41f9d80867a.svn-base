package medical.gene.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalGenVO;
import medical.framework.file.mapping.CellWriterMapper;
import medical.gene.service.TAnalGenVO;
import medical.neuropsy.service.NeuropsyAdos1VO;

public class GeneWriterMapper implements CellWriterMapper<TAnalGenVO>{
	@Override
	public void mapHeader(Row row, TAnalGenVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
			cell = row.createCell(0);
			cell.setCellValue("질병군");	
			
			cell = row.createCell(1);
			cell.setCellValue("연구번호");
			
			cell = row.createCell(3);
			cell.setCellValue("성별");


			cell = row.createCell(4);
			cell.setCellValue("차수");

			cell = row.createCell(5);
			cell.setCellValue("나이");

			cell = row.createCell(6);
			cell.setCellValue("채취일");	
			
			cell = row.createCell(7);
			cell.setCellValue("분석일");	
		
	
	
		
		}
		
		//수정되어야함
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
		}
	
	}

	@Override
	public void mapRow(Row row, TAnalGenVO vo) {
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
		cell.setCellValue(vo.getCollectDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAnalDate());

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
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
		
	}
	
}
