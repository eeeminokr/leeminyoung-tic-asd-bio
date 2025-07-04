package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyExitiiVO;

public class NeuropsyExitiiWriterMapper implements CellWriterMapper<NeuropsyExitiiVO>{
	@Override
	public void mapHeader(Row row, NeuropsyExitiiVO vo) {
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
		cell.setCellValue("EXIT-II (스트룹 검사)");
		
		cell = row.createCell(14);
		cell.setCellValue("EXIT-II (단어유창성)");
		
		cell = row.createCell(20);
		cell.setCellValue("EXIT-II (도안유창성)");	
		
		cell = row.createCell(24);
		cell.setCellValue("EXIT-II (AVLT)");	
		
		cell = row.createCell(28);
		cell.setCellValue("EXIT-II (CFT)");	
		
		cell = row.createCell(32);
		cell.setCellValue("EXIT-II (EFQ)");
		cell = row.createCell(35);
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("단순시간 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("단순시간T");
			cell = row.createCell(i++);
			cell.setCellValue("단순오류 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("단순오류T");
			cell = row.createCell(i++);
			cell.setCellValue("간섭시간 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("간섭시간T");
			cell = row.createCell(i++);
			cell.setCellValue("간섭오류 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("간섭오류T");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("정반응T");
			cell = row.createCell(i++);
			cell.setCellValue("비어반응 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("비어반응T");
			cell = row.createCell(i++);
			cell.setCellValue("반복반응 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("반복반응T");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("정반응T");
			cell = row.createCell(i++);
			cell.setCellValue("반복반응 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("반복반응T");
			cell = row.createCell(i++);
			cell.setCellValue("지연회상 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("지연회상T");
			cell = row.createCell(i++);
			cell.setCellValue("지연재인 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("지연재인T");
			cell = row.createCell(i++);
			cell.setCellValue("계획성 원점수 ");
			cell = row.createCell(i++);
			cell.setCellValue("계획성T");
			cell = row.createCell(i++);
			cell.setCellValue("보고그리기 원점수");
			cell = row.createCell(i++);
			cell.setCellValue("보고그리기T");
			cell = row.createCell(i++);
			cell.setCellValue("환산점수 합");
			cell = row.createCell(i++);
			cell.setCellValue("지수점수");
			cell = row.createCell(i++);
			cell.setCellValue("백분위");
			cell = row.createCell(i++);
			cell.setCellValue("평가");
			
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyExitiiVO vo) {
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
		cell.setCellValue(vo.getExitiiExecDate());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopStos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopStt());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopSeos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopSet());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopItos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopItt());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopIeos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiStroopIet());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiWordfqRaos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiWordfqRat());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiWordfqBaos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiWordfqBat());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiWordfqLaos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiWordfqLat());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiDesignRaos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiDesignRat());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiDesignLaos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiDesignLat());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiAvltDmos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiAvltDmt());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiAvltDjos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiAvltDjt());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiCftPos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiCftPt());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiCftDos());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiCftDt());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiEfqEss());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiEfqNis());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiEfqPercentile());
			
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitiiEfqEval());
			

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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 14, 19));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 20, 23));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 24, 27));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 28, 31));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 32, 35));
		
	}
	
}
