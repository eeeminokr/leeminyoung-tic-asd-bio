package medical.clinician.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.clinician.service.ClinicianAsdSrs01VO;
import medical.framework.file.mapping.CellWriterMapper;
import medical.surveyAsd.service.SurveyAsdSrs01VO;

public class ClinicianAsdSrs01WriterMapper implements CellWriterMapper<ClinicianAsdSrs01VO>{
	@Override
	public void mapHeader(Row row, ClinicianAsdSrs01VO vo) {
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
		cell.setCellValue("SRS");
		
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
			cell.setCellValue("약물종류");
			cell = row.createCell(i++);
			cell.setCellValue("용량");
			cell = row.createCell(i++);
			cell.setCellValue("불면");
			cell = row.createCell(i++);
			cell.setCellValue("악몽");
			cell = row.createCell(i++);
			cell.setCellValue("멍함");
			cell = row.createCell(i++);
			cell.setCellValue("말수줌");
			cell = row.createCell(i++);
			cell.setCellValue("관심저하");
			cell = row.createCell(i++);
			cell.setCellValue("식욕저하");
			cell = row.createCell(i++);
			cell.setCellValue("짜증");
			cell = row.createCell(i++);
			cell.setCellValue("복통");
			cell = row.createCell(i++);
			cell.setCellValue("두통");
			cell = row.createCell(i++);
			cell.setCellValue("졸림");
			cell = row.createCell(i++);
			cell.setCellValue("슬픔");
			cell = row.createCell(i++);
			cell.setCellValue("울먹임");
			cell = row.createCell(i++);
			cell.setCellValue("불안함");
			cell = row.createCell(i++);
			cell.setCellValue("손톱깨묾");
			cell = row.createCell(i++);
			cell.setCellValue("들뜸");
			cell = row.createCell(i++);
			cell.setCellValue("현기증");
			cell = row.createCell(i++);
			cell.setCellValue("틱");
		}
	}
	
	@Override
	public void mapRow(Row row, ClinicianAsdSrs01VO vo) {
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
		cell.setCellValue(vo.getSrs01ExecDate());

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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 26));
		
	}
	
}
