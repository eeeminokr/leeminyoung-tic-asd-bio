package medical.survey.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.survey.service.SurveyStaisChildVO;

public class SurveyStaisChildWriterMapper implements CellWriterMapper<SurveyStaisChildVO>{
	@Override
	public void mapHeader(Row row, SurveyStaisChildVO vo) {
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
		cell.setCellValue("STAI-T");
		cell = row.createCell(26);
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
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
			cell.setCellValue("11");
			cell = row.createCell(i++);
			cell.setCellValue("12");
			cell = row.createCell(i++);
			cell.setCellValue("13");
			cell = row.createCell(i++);
			cell.setCellValue("14");
			cell = row.createCell(i++);
			cell.setCellValue("15");
			cell = row.createCell(i++);
			cell.setCellValue("16");
			cell = row.createCell(i++);
			cell.setCellValue("17");
			cell = row.createCell(i++);
			cell.setCellValue("18");
			cell = row.createCell(i++);
			cell.setCellValue("19");
			cell = row.createCell(i++);
			cell.setCellValue("20");
			cell = row.createCell(i++);
			cell.setCellValue("총점");
			
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyStaisChildVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaisChildExecDate());

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
		cell.setCellValue(vo.getA11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA16());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA17());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA18());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA19());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA20());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalScore());
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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 26));
		
	}
	
}
