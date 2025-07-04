package medical.target.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.target.service.TargetVO;

public class TargetWriterMapper2 implements CellWriterMapper<TargetVO>{
	@Override
	public void mapHeader(Row row, TargetVO vo) {
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
		cell.setCellValue("생년월일");	
		
		cell = row.createCell(5);
		cell.setCellValue("약물");
		
		cell = row.createCell(6);
		cell.setCellValue("차수");

		cell = row.createCell(7);
		cell.setCellValue("공존진단");
		
		cell = row.createCell(8);
		cell.setCellValue("나이");

		cell = row.createCell(9);
		cell.setCellValue("방문일자");	
		
		cell = row.createCell(10);
		cell.setCellValue("다음 방문일자");
		
		cell = row.createCell(11);
		cell.setCellValue("방문상태");
		
		cell = row.createCell(12);
		cell.setCellValue("연구면담");
		
		cell = row.createCell(13);
		cell.setCellValue("심리");
		
		cell = row.createCell(14);
		cell.setCellValue("발달");
		
				
		cell = row.createCell(15);
		cell.setCellValue("채혈");
		
		cell = row.createCell(19);
		cell.setCellValue("채뇨");
		
		cell = row.createCell(20);
		cell.setCellValue("채변");
		
		
		cell = row.createCell(21);
		cell.setCellValue("연구참여 동의서");
		
		cell = row.createCell(23);
		cell.setCellValue("인체유래물 연구 동의서");
		
		cell = row.createCell(26);
		cell.setCellValue("설문지배부");
		
		cell = row.createCell(27);
		cell.setCellValue("설문지회수");
		
		cell = row.createCell(28);
		cell.setCellValue("결과지발송");
		
		cell = row.createCell(29);
		cell.setCellValue("결과면담");
		
		cell = row.createCell(31);
		cell.setCellValue("대상자정보 상세내용");
		
		}
		if(rowNum==1) {
			
			cell = row.createCell(i++);  //질 0
			cell = row.createCell(i++); //뇌 1
			cell.setCellValue("뇌원천");
			cell = row.createCell(i++); //뇌 2
			cell.setCellValue("뇌질환");
			cell = row.createCell(i++); //성3
			cell = row.createCell(i++); //생4
			cell = row.createCell(i++); //약5
			cell = row.createCell(i++); //차6
			cell = row.createCell(i++); //공7
			cell = row.createCell(i++); //나8
			cell = row.createCell(i++); //방일9
			cell = row.createCell(i++); //방다일10
			cell = row.createCell(i++); //방상11
			cell = row.createCell(i++); //연면12
			cell = row.createCell(i++); //심13
			cell = row.createCell(i++); //발14
			
			cell = row.createCell(i++);
			cell.setCellValue("부");
			cell = row.createCell(i++);
			cell.setCellValue("모");
			cell = row.createCell(i++);
			cell.setCellValue("아동");
			cell = row.createCell(i++);
			cell.setCellValue("PAXgene");
		
			cell = row.createCell(i++); //뇨19
			cell = row.createCell(i++); //변20
			
			cell = row.createCell(i++);
			cell.setCellValue("부");
			cell = row.createCell(i++);
			cell.setCellValue("모");
			
			cell = row.createCell(i++);
			cell.setCellValue("부");
			cell = row.createCell(i++);
			cell.setCellValue("모");
			cell = row.createCell(i++);
			cell.setCellValue("아동");
			
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++);
			cell.setCellValue("면담일자");
			cell = row.createCell(i++);
			cell.setCellValue("면담자");
			cell = row.createCell(i++); //비고
			
			
		}
	}

	@Override
	public void mapRow(Row row, TargetVO vo) {
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
		cell.setCellValue(vo.getBirthYm());

		
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
		cell.setCellValue(vo.getDevelopment());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBloodF());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBloodM());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBloodC());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPaxGene());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getUrine());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getFeces());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAgreeRpF());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAgreeRpM());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAgreeRhbmF());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAgreeRhbmM());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAgreeRhbmC());
		
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
		cell.setCellValue(vo.getTargetRemarks());
		
		
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
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 14, 14));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 20, 20));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 15, 18));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 21, 22));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 23, 25));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 26, 26));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 27, 27));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 28, 28));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 29, 30));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 31, 31));
		
	}
	
}
