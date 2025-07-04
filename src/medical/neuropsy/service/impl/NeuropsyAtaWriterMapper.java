package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyAtaVO;

public class NeuropsyAtaWriterMapper implements CellWriterMapper<NeuropsyAtaVO>{
	@Override
	public void mapHeader(Row row, NeuropsyAtaVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		
			cell = row.createCell(i++);
			cell.setCellValue("뇌원천 연구번호");
			

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
			cell.setCellValue("ATA(시각)");
			
			cell = row.createCell(14);
			cell.setCellValue("ATA(청각)");	
			cell = row.createCell(21);
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("누락Z");
			cell = row.createCell(i++);
			cell.setCellValue("오경보Z");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n평균Z");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n표준편차Z");
			cell = row.createCell(i++);
			cell.setCellValue("누락T");
			cell = row.createCell(i++);
			cell.setCellValue("오경보T");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n평균T");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n표준편차T");
			cell = row.createCell(i++);
			cell.setCellValue("누락Z");
			cell = row.createCell(i++);
			cell.setCellValue("오경보Z");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n평균Z");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n표준편차Z");
			cell = row.createCell(i++);
			cell.setCellValue("누락T");
			cell = row.createCell(i++);
			cell.setCellValue("오경보T");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n평균T");
			cell = row.createCell(i++);
			cell.setCellValue("반응시간\n표준편차T");
			
		}
		
		
		
	}

	@Override
	public void mapRow(Row row, NeuropsyAtaVO vo) {
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
		cell.setCellValue(vo.getAtaExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavMissz());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavFalarmz());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavReactzAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavReactzDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavMisst());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavFalarmt());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavReacttAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtavReacttDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahMissz());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahFalarmz());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahReactzAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahReactzDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahMisst());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahFalarmt());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahReacttAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAtahReacttDev());
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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 13));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 14, 21));
		
	}
	
}
