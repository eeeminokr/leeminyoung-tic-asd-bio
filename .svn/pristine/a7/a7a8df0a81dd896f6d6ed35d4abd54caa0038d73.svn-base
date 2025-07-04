package medical.target.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.target.service.TargetVO;

public class TargetWriterMapper implements CellWriterMapper<TargetVO>{
	@Override
	public void mapHeader(Row row, TargetVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("연구번호");

		cell = row.createCell(i++);
		cell.setCellValue("질병군");

		cell = row.createCell(i++);
		cell.setCellValue("성별");

		cell = row.createCell(i++);
		cell.setCellValue("생년월일");	

		cell = row.createCell(i++);
		cell.setCellValue("프로토콜");
		
		cell = row.createCell(i++);
		cell.setCellValue("약물");
		
		cell = row.createCell(i++);
		cell.setCellValue("차수");

		cell = row.createCell(i++);
		cell.setCellValue("공존진단");
		
		cell = row.createCell(i++);
		cell.setCellValue("나이");

		cell = row.createCell(i++);
		cell.setCellValue("방문일자");	
		
		cell = row.createCell(i++);
		cell.setCellValue("다음 방문일자");
		
		cell = row.createCell(i++);
		cell.setCellValue("방문상태");
		
		cell = row.createCell(i++);
		cell.setCellValue("연구면담");
		
		cell = row.createCell(i++);
		cell.setCellValue("심리");
		
		cell = row.createCell(14);
		cell.setCellValue("소변");
		
		cell = row.createCell(15);
		cell.setCellValue("동의서");
		
		cell = row.createCell(17);
		cell.setCellValue("설문지배부");
		
		cell = row.createCell(18);
		cell.setCellValue("설문지회수");
		
		cell = row.createCell(19);
		cell.setCellValue("결과지발송");
		
		cell = row.createCell(20);
		cell.setCellValue("면담결과");
		
		cell = row.createCell(23);
		cell.setCellValue("대상자정보 상세내용");
		
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
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("보호자");
			cell = row.createCell(i++);
			cell.setCellValue("대상자");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("면담일자");
			cell = row.createCell(i++);
			cell.setCellValue("면담자");
			cell = row.createCell(i++);
			cell.setCellValue("면담방법");
			cell = row.createCell(i++);
			
			
		}
	}

	@Override
	public void mapRow(Row row, TargetVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDisClassDtl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getBirthYm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getDrugKind());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCxtDiag());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getVisitDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getNextVisitDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStatus());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getResearchInterview());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPsychology());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getUrine());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAgreeGuardian());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAgreeTarget());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSurveyDistrib());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSurveyReclam());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSendResult());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterviewDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterviewer());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterviewMethod());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetRemarks());
		
		
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
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 14, 14));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 15, 16));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 20, 22));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 23, 23));
		
	}
	
}
