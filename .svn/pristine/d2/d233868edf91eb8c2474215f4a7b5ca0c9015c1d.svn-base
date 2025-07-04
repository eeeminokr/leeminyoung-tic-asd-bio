package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyExitiiVO;

public class NeuropsyExitiiWriterMapper2 implements CellWriterMapper<NeuropsyExitiiVO>{
	@Override
	public void mapHeader(Row row, NeuropsyExitiiVO vo) {
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
			cell.setCellValue("EXIT-II (스트룹 검사)");
			
			cell = row.createCell(15);
			cell.setCellValue("EXIT-II (단어유창성)");
			
			cell = row.createCell(21);
			cell.setCellValue("EXIT-II (도안유창성)");	
			
			cell = row.createCell(25);
			cell.setCellValue("EXIT-II (AVLT)");	
			
			cell = row.createCell(29);
			cell.setCellValue("EXIT-II (CFT)");	
			
			cell = row.createCell(33);
			cell.setCellValue("EXIT-II (EFQ)");
			cell = row.createCell(36);
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
			cell = row.createCell(36);
		
			
			
			
			
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyExitiiVO vo) {
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
	
		
		
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 15, 20));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 16, 16));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 20, 20));
		
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 21, 24));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 21, 21));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 22, 22));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 23, 23));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 24, 24));
	

		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 25, 28));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 25, 25));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 26, 26));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 27, 27));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 28, 28));

		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 29, 32));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 29, 29));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 30, 30));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 31, 31));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 32, 32));

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 33, 36));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 33, 33));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 34, 34));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 35, 35));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 36, 36));
	
	}
	
}
