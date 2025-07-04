package medical.analysis.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.analysis.service.AnalysisTAnalEnvMattBlVO;
import medical.analysis.service.AnalysisTAnalEnvMattVO;
import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyAdos1VO;

public class AnalysisEnvMattWriterMapper implements CellWriterMapper<AnalysisTAnalEnvMattVO>{
	@Override
	public void mapHeader(Row row, AnalysisTAnalEnvMattVO vo) {
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
			cell.setCellValue("결과보고일");

			cell = row.createCell(8);
			cell.setCellValue("PHTs 3종 및 COT(소변)\r\n");
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
			cell = row.createCell(i++);
			
			cell = row.createCell(8);
			cell.setCellValue("Creatinine");

			
			cell = row.createCell(9);
			cell.setCellValue("COT\r\n" + 
			"(MDL : 0.149 ug/L)");
			cell = row.createCell(10);
			
			cell = row.createCell(11);

			cell.setCellValue("MEHHP\r\n" + 
			"(MDL : 0.009 ug/L)");
			cell = row.createCell(12);

			
			cell = row.createCell(13);

			cell.setCellValue("MEOHP\r\n" + 
			"(MDL : 0.008 ug/L)");
			cell = row.createCell(14);
			
			cell = row.createCell(15);
			cell.setCellValue("MnBP\r\n" + 
			"(MDL : 0.146 ug/L)");
			cell = row.createCell(16);
			
			cell = row.createCell(17);
			cell.setCellValue("3-PBA\r\n" + 
			"(MDL : 0.013 ug/L)");
			cell = row.createCell(18);


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
			
			cell = row.createCell(17);
			cell = row.createCell(18);


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
			//creatinine
			cell.setCellValue("분석값\r\n" + 
			"(g/L)");
			


			cell = row.createCell(i++);
			//cot
			cell.setCellValue("분석값\r\n" + 
			"(ug/L)");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("분석값\r\n" + 
			"(ug/g creatinine)");
			
			cell = row.createCell(i++);
			//mehhp
			cell.setCellValue("분석값\r\n" + 
			"(ug/L)");
		
			cell = row.createCell(i++);
			cell.setCellValue("분석값\r\n" + 
			"(ug/g creatinine)");
	
			cell = row.createCell(i++);
			//meohp
			cell.setCellValue("분석값\r\n" + 
			"(ug/L)");
		
			cell = row.createCell(i++);
			cell.setCellValue("분석값\r\n" + 
			"(ug/g creatinine)");
		
			
			cell = row.createCell(i++);
			//mnbp
			cell.setCellValue("분석값\r\n" + 
			"(ug/L)");
	
			cell = row.createCell(i++);
			cell.setCellValue("분석값\r\n" + 
			"(ug/g creatinine)");
			//3-pba

			cell = row.createCell(17);
			cell.setCellValue("분석값\r\n" + 
			"(ug/L)");
			cell = row.createCell(18);
			cell.setCellValue("분석값\r\n" + 
			"(ug/g creatinine)");
		


			}

	}

	@Override
	public void mapRow(Row row, AnalysisTAnalEnvMattVO vo) {
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
		cell.setCellValue(vo.getCollectDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAnalDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCreatinine());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCot());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCotCreatinine());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMehhp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMehhpCreatinine());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMeohp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMeohpCreatinine());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMnbp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMnbpCreatinine());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getThreePba());
		
		cell = row.createCell(18);
		cell.setCellValue(vo.getThreePbaCreatinine());
		


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
		
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 2));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 18));		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 12));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 14));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 15, 16));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 17, 18));

		sheet.addMergedRegion(new CellRangeAddress(3, 3, 8, 8));		
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 13, 14));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 14, 14));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 16, 16));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 18, 18));
		
		
	}
	
}
