package medical.survey.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.survey.service.SurveyCbclVO;

public class SurveyCbclWriterMapper implements CellWriterMapper<SurveyCbclVO>{
	@Override
	public void mapHeader(Row row, SurveyCbclVO vo) {
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
		cell.setCellValue("CBCL");
		cell = row.createCell(18);
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("위축 T");
			cell = row.createCell(i++);
			cell.setCellValue("신체증상");
			cell = row.createCell(i++);
			cell.setCellValue("우울/불안");
			cell = row.createCell(i++);
			cell.setCellValue("사회적미성숙");
			cell = row.createCell(i++);
			cell.setCellValue("사고의문제");
			cell = row.createCell(i++);
			cell.setCellValue("주의집중문제");
			cell = row.createCell(i++);
			cell.setCellValue("비행");
			cell = row.createCell(i++);
			cell.setCellValue("공격성");
			cell = row.createCell(i++);
			cell.setCellValue("내재화");
			cell = row.createCell(i++);
			cell.setCellValue("외현화");
			cell = row.createCell(i++);
			cell.setCellValue("총");
			cell = row.createCell(i++);
			cell.setCellValue("성문제");
			cell = row.createCell(i++);
			cell.setCellValue("정서불안정");
			
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyCbclVO vo) {
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
		cell.setCellValue(vo.getCbclExecDate());

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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 18));
		
	}
	
}
