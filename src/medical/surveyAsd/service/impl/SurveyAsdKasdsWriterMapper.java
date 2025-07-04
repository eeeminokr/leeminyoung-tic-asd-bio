package medical.surveyAsd.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.surveyAsd.service.SurveyAsdKasdsVO;

public class SurveyAsdKasdsWriterMapper implements CellWriterMapper<SurveyAsdKasdsVO>{
	
	@Override
	public void mapHeader(Row row, SurveyAsdKasdsVO vo) {
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
			cell.setCellValue("실시일");	
			
			cell = row.createCell(7);
			cell.setCellValue("K-ASDS");
			cell = row.createCell(61);
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			
			cell = row.createCell(i++);
			cell.setCellValue("뇌원천 연구번호");
			
			cell = row.createCell(i++);
			cell.setCellValue("뇌질환 연구번호");
			
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("1");				cell = row.createCell(i++);
			cell.setCellValue("2");				cell = row.createCell(i++);
			cell.setCellValue("3");				cell = row.createCell(i++);
			cell.setCellValue("4");				cell = row.createCell(i++);
			cell.setCellValue("5");				cell = row.createCell(i++);
			cell.setCellValue("6");				cell = row.createCell(i++);
			cell.setCellValue("7");				cell = row.createCell(i++);
			cell.setCellValue("8");				cell = row.createCell(i++);
			cell.setCellValue("9");				cell = row.createCell(i++);
			cell.setCellValue("언어 총점");			cell = row.createCell(i++);
			
			cell.setCellValue("1");				cell = row.createCell(i++);
			cell.setCellValue("2");				cell = row.createCell(i++);
			cell.setCellValue("3");				cell = row.createCell(i++);
			cell.setCellValue("4");				cell = row.createCell(i++);
			cell.setCellValue("5");				cell = row.createCell(i++);
			cell.setCellValue("6");				cell = row.createCell(i++);
			cell.setCellValue("7");				cell = row.createCell(i++);
			cell.setCellValue("8");				cell = row.createCell(i++);
			cell.setCellValue("9");				cell = row.createCell(i++);
			cell.setCellValue("10");			cell = row.createCell(i++);
			cell.setCellValue("11");			cell = row.createCell(i++);
			cell.setCellValue("12");			cell = row.createCell(i++);
			cell.setCellValue("13");			cell = row.createCell(i++);
			cell.setCellValue("사회성 총점");			cell = row.createCell(i++);
			
			cell.setCellValue("1");				cell = row.createCell(i++);
			cell.setCellValue("2");				cell = row.createCell(i++);
			cell.setCellValue("3");				cell = row.createCell(i++);
			cell.setCellValue("4");				cell = row.createCell(i++);
			cell.setCellValue("5");				cell = row.createCell(i++);
			cell.setCellValue("6");				cell = row.createCell(i++);
			cell.setCellValue("7");				cell = row.createCell(i++);
			cell.setCellValue("8");				cell = row.createCell(i++);
			cell.setCellValue("9");				cell = row.createCell(i++);
			cell.setCellValue("10");			cell = row.createCell(i++);
			cell.setCellValue("11");			cell = row.createCell(i++);
			cell.setCellValue("부적응행동 총점");		cell = row.createCell(i++);
			
			cell.setCellValue("1");				cell = row.createCell(i++);
			cell.setCellValue("2");				cell = row.createCell(i++);
			cell.setCellValue("3");				cell = row.createCell(i++);
			cell.setCellValue("4");				cell = row.createCell(i++);
			cell.setCellValue("5");				cell = row.createCell(i++);
			cell.setCellValue("6");				cell = row.createCell(i++);
			cell.setCellValue("7");				cell = row.createCell(i++);
			cell.setCellValue("8");				cell = row.createCell(i++);
			cell.setCellValue("9");				cell = row.createCell(i++);
			cell.setCellValue("10");			cell = row.createCell(i++);
			cell.setCellValue("인지 총점");			cell = row.createCell(i++);
			
			cell.setCellValue("1");				cell = row.createCell(i++);
			cell.setCellValue("2");				cell = row.createCell(i++);
			cell.setCellValue("3");				cell = row.createCell(i++);
			cell.setCellValue("4");				cell = row.createCell(i++);
			cell.setCellValue("5");				cell = row.createCell(i++);
			cell.setCellValue("6");				cell = row.createCell(i++);
			cell.setCellValue("7");				cell = row.createCell(61);
			cell.setCellValue("감각운동 총점");	
			
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyAsdKasdsVO vo) {
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
		cell.setCellValue(vo.getPerformNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getKasdsExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA1());cell = row.createCell(i++);
		cell.setCellValue(vo.getA2());cell = row.createCell(i++);
		cell.setCellValue(vo.getA3());cell = row.createCell(i++);
		cell.setCellValue(vo.getA4());cell = row.createCell(i++);
		cell.setCellValue(vo.getA5());cell = row.createCell(i++);
		cell.setCellValue(vo.getA6());cell = row.createCell(i++);
		cell.setCellValue(vo.getA7());cell = row.createCell(i++);
		cell.setCellValue(vo.getA8());cell = row.createCell(i++);
		cell.setCellValue(vo.getA9());cell = row.createCell(i++);
		cell.setCellValue(vo.getLanguage());cell = row.createCell(i++);
		
		cell.setCellValue(vo.getB1());cell = row.createCell(i++);
		cell.setCellValue(vo.getB2());cell = row.createCell(i++);
		cell.setCellValue(vo.getB3());cell = row.createCell(i++);
		cell.setCellValue(vo.getB4());cell = row.createCell(i++);
		cell.setCellValue(vo.getB5());cell = row.createCell(i++);
		cell.setCellValue(vo.getB6());cell = row.createCell(i++);
		cell.setCellValue(vo.getB7());cell = row.createCell(i++);
		cell.setCellValue(vo.getB8());cell = row.createCell(i++);
		cell.setCellValue(vo.getB9());cell = row.createCell(i++);
		cell.setCellValue(vo.getB10());cell = row.createCell(i++);
		cell.setCellValue(vo.getB11());cell = row.createCell(i++);
		cell.setCellValue(vo.getB12());cell = row.createCell(i++);
		cell.setCellValue(vo.getB13());cell = row.createCell(i++);
		cell.setCellValue(vo.getSociability());cell = row.createCell(i++);
		
		cell.setCellValue(vo.getC1());cell = row.createCell(i++);
		cell.setCellValue(vo.getC2());cell = row.createCell(i++);
		cell.setCellValue(vo.getC3());cell = row.createCell(i++);
		cell.setCellValue(vo.getC4());cell = row.createCell(i++);
		cell.setCellValue(vo.getC5());cell = row.createCell(i++);
		cell.setCellValue(vo.getC6());cell = row.createCell(i++);
		cell.setCellValue(vo.getC7());cell = row.createCell(i++);
		cell.setCellValue(vo.getC8());cell = row.createCell(i++);
		cell.setCellValue(vo.getC9());cell = row.createCell(i++);
		cell.setCellValue(vo.getC10());cell = row.createCell(i++);
		cell.setCellValue(vo.getC11());cell = row.createCell(i++);
		cell.setCellValue(vo.getMaladaptiveBehavior());cell = row.createCell(i++);
		
		cell.setCellValue(vo.getD1());cell = row.createCell(i++);
		cell.setCellValue(vo.getD2());cell = row.createCell(i++);
		cell.setCellValue(vo.getD3());cell = row.createCell(i++);
		cell.setCellValue(vo.getD4());cell = row.createCell(i++);
		cell.setCellValue(vo.getD5());cell = row.createCell(i++);
		cell.setCellValue(vo.getD6());cell = row.createCell(i++);
		cell.setCellValue(vo.getD7());cell = row.createCell(i++);
		cell.setCellValue(vo.getD8());cell = row.createCell(i++);
		cell.setCellValue(vo.getD9());cell = row.createCell(i++);
		cell.setCellValue(vo.getD10());cell = row.createCell(i++);
		cell.setCellValue(vo.getRecognition());cell = row.createCell(i++);
		
		cell.setCellValue(vo.getE1());cell = row.createCell(i++);
		cell.setCellValue(vo.getE2());cell = row.createCell(i++);
		cell.setCellValue(vo.getE3());cell = row.createCell(i++);
		cell.setCellValue(vo.getE4());cell = row.createCell(i++);
		cell.setCellValue(vo.getE5());cell = row.createCell(i++);
		cell.setCellValue(vo.getE6());cell = row.createCell(i++);
		cell.setCellValue(vo.getE7());cell = row.createCell(i++);
		cell.setCellValue(vo.getSensorimotor());cell = row.createCell(i++);
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
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 61));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 61, 61));
	}
}
