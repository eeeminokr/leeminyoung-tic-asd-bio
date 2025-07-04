package medical.survey.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.survey.service.SurveyYgtssVO;

public class SurveyYgtssWriterMapper implements CellWriterMapper<SurveyYgtssVO>{
	@Override
	public void mapHeader(Row row, SurveyYgtssVO vo) {
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
		cell.setCellValue("YGTSS");
		cell = row.createCell(20);
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("1 근육");
			cell = row.createCell(i++);
			cell.setCellValue("1 음성");
			cell = row.createCell(i++);
			cell.setCellValue("2 근육");
			cell = row.createCell(i++);
			cell.setCellValue("2 음성");
			cell = row.createCell(i++);
			cell.setCellValue("3 근육");
			cell = row.createCell(i++);
			cell.setCellValue("3 음성");
			cell = row.createCell(i++);
			cell.setCellValue("4 근육");
			cell = row.createCell(i++);
			cell.setCellValue("4 음성");
			cell = row.createCell(i++);
			cell.setCellValue("5 근육");
			cell = row.createCell(i++);
			cell.setCellValue("5 음성");
			cell = row.createCell(i++);
			cell.setCellValue("장애도");
			cell = row.createCell(i++);
			cell.setCellValue("근육점수");
			cell = row.createCell(i++);
			cell.setCellValue("음성점수");
			cell = row.createCell(i++);
			cell.setCellValue("전체틱");
			cell = row.createCell(i++);
			cell.setCellValue("전체 YGTSS");
			
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyYgtssVO vo) {
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
		cell.setCellValue(vo.getYgtssExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getM1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getV1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getM2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getV2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getM3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getV3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getM4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getV4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getM5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getV5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDisabilityDegree());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getmScore());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getvScore());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalTic());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalYgtss());
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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 20));
		
	}
	
}
