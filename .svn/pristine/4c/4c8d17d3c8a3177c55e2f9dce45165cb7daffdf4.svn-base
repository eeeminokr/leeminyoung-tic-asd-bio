package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyAtaVO;

public class NeuropsyAtaWriterMapper2 implements CellWriterMapper<NeuropsyAtaVO>{
	@Override
	public void mapHeader(Row row, NeuropsyAtaVO vo) {
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
		cell.setCellValue("ATA(시각)");
		
		cell = row.createCell(15);
		cell.setCellValue("ATA(청각)");	
		cell = row.createCell(22);
		
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
		
		
		if(rowNum==2) {
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
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
		}
		
		
		
	}

	@Override
	public void mapRow(Row row, NeuropsyAtaVO vo) {
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
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2));
	
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 6, 6));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 14));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 14, 14));
		
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 15, 22));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 16, 16));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 20, 20));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 21, 21));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 22, 22));
		
	}
	
}
