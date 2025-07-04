package medical.analysis.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.analysis.service.AnalysisTAnalSnpVO;
import medical.framework.file.mapping.CellWriterMapper;

public class AnalysisSnpWriterMapper implements CellWriterMapper<AnalysisTAnalSnpVO>{
	@Override
	public void mapHeader(Row row, AnalysisTAnalSnpVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("뇌원천\n연구번호");
		
		cell = row.createCell(i++);
		cell.setCellValue("뇌질환\n연구번호");
		
		cell = row.createCell(i++);
		cell.setCellValue("성별");
		
		cell = row.createCell(i++);
		cell.setCellValue("프로토콜");
		
		cell = row.createCell(i++);
		cell.setCellValue("나이");

		cell = row.createCell(i++);
		cell.setCellValue("채취일");

		cell = row.createCell(i++);
		cell.setCellValue("실시일");	

		cell = row.createCell(i++);
		cell.setCellValue("OXTR(SNP분석)");	
		
		cell = row.createCell(9);
		cell.setCellValue("CNTNAP2(SNP분석)");
		
		cell = row.createCell(11);
		cell.setCellValue("NRXN1(SNP분석)");
		
		}
		
		//수정되어야함
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
						
			cell.setCellValue("rs2254298 G>A");
			
			cell = row.createCell(i++);
			cell.setCellValue("rs53576 A>G>A");
			
			cell = row.createCell(i++);
			cell.setCellValue("rs7794745 A>T");
			
			cell = row.createCell(i++);
			cell.setCellValue("rs2710126 C>T");
			
			cell = row.createCell(i++);
			cell.setCellValue("rs1045881 C>T");
			
			cell = row.createCell(i++);
			cell.setCellValue("rs858922 C>A, C>G");
		}
		
	}

	@Override
	public void mapRow(Row row, AnalysisTAnalSnpVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetDisId());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCollectDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAnalDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRs2254298());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRs53576());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRs7794745());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRs2710126());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRs1045881());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRs858932());

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
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 8));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 10));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 11, 12));
	}
	
}
