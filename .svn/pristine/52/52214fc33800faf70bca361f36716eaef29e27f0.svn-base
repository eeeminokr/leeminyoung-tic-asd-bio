package medical.surveyAsd.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.surveyAsd.service.SurveyAsdCybocsVO;

public class SurveyAsdCybocsWriterMapper implements CellWriterMapper<SurveyAsdCybocsVO>{
	@Override
	public void mapHeader(Row row, SurveyAsdCybocsVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("뇌원천 연구번호");
		
		cell = row.createCell(i++);
		cell.setCellValue("뇌질환 연구번호");
		
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
		cell.setCellValue("CY-BOCS");
		
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
			
			cell.setCellValue("총점");
			cell = row.createCell(i++);
			cell.setCellValue("1");
			cell = row.createCell(i++);
			cell.setCellValue("2");
			cell = row.createCell(i++);
			cell.setCellValue("3");
			cell = row.createCell(i++);
			cell.setCellValue("4");
			cell = row.createCell(i++);
			cell.setCellValue("5");
			cell = row.createCell(i++);
			cell.setCellValue("강박사고 총점");
			cell = row.createCell(i++);
			cell.setCellValue("6");
			cell = row.createCell(i++);
			cell.setCellValue("7");
			cell = row.createCell(i++);
			cell.setCellValue("8");
			cell = row.createCell(i++);
			cell.setCellValue("9");
			cell = row.createCell(i++);
			cell.setCellValue("10");
			cell = row.createCell(i++);
			cell.setCellValue("강박행동 총점");
			
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyAsdCybocsVO vo) {
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
		cell.setCellValue(vo.getPerformNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCybocsExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalScore());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCompulsion());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA10());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCompulsiveBehavior());
		
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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 19));
		
	}
	
}
