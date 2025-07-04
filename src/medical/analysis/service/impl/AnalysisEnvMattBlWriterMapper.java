package medical.analysis.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyAdos1VO;

public class AnalysisEnvMattBlWriterMapper implements CellWriterMapper<AnalysisTAnalEnvMattBlVO>{
	@Override
	public void mapHeader(Row row, AnalysisTAnalEnvMattBlVO vo) {
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
			cell.setCellValue("채취일");	
			
			cell = row.createCell(7);
			cell.setCellValue("튜브");	
			
			
			cell = row.createCell(8);
			cell.setCellValue("결과보고일");
			
			cell = row.createCell(9);
			cell.setCellValue("중금속(혈액)");
			cell = row.createCell(11);
		
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

			cell.setCellValue("B_Mn\r\n" + 
					"(MDL 0.07ug/L)");
			cell = row.createCell(10);
			
			cell.setCellValue("B_Cd\r\n" + 
					"(MDL 0.10ug/L)");
		
			cell = row.createCell(11);
			cell.setCellValue("B_Pb\r\n" + 
					"(MDL 0.18ug/L)");
			
		}
		if(rowNum == 2) {
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
			cell = row.createCell(11);
		
			
	
		}
		
		
		if(rowNum == 3) {
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
			cell.setCellValue("분석값\r\n" + 
					"(μg/L)");
			cell = row.createCell(10);
			
			cell.setCellValue("분석값\r\n" + 
					"(μg/L)");
			
			cell = row.createCell(11);		
			cell.setCellValue("분석값\r\n" + 
					"(μg/L)");
	
		}
		
		
	}

	@Override
	public void mapRow(Row row, AnalysisTAnalEnvMattBlVO vo) {
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
		cell.setCellValue(vo.getBloodCollectDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTube());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMetalAnalDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBMn());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBCd());
		
		cell = row.createCell(11);
		cell.setCellValue(vo.getBPb());
		
	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 8, 8));
		
		
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 2));
		
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 1, 1));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 11));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));
		
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 11, 11));
		
		
		
	
		
	}
	
}
