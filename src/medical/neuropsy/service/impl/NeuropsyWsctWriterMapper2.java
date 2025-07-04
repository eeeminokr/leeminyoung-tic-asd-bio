package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyWsctVO;

public class NeuropsyWsctWriterMapper2 implements CellWriterMapper<NeuropsyWsctVO>{
	@Override
	public void mapHeader(Row row, NeuropsyWsctVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
			cell = row.createCell(0);
			cell.setCellValue("질병군");
				
			cell = row.createCell(1);
			cell.setCellValue("연구번호");
			cell = row.createCell(2);

			cell = row.createCell(3);
			cell.setCellValue("성별");


			cell = row.createCell(4);
			cell.setCellValue("차수");

			cell = row.createCell(5);
			cell.setCellValue("나이");

			cell = row.createCell(6);
			cell.setCellValue("실시일");	
		
			cell = row.createCell(7);
			cell.setCellValue("WSCT");
			cell = row.createCell(22);
		
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
			cell.setCellValue("Total Errors R");
			cell = row.createCell(i++);
			cell.setCellValue("Total Errors S");
			cell = row.createCell(i++);
			cell.setCellValue("Total Errors T");
			cell = row.createCell(i++);
			cell.setCellValue("Total Errors %ile");
			cell = row.createCell(i++);
			cell.setCellValue("Perseverative Respon T");
			cell = row.createCell(i++);
			cell.setCellValue("Perseverative Error T");
			cell = row.createCell(i++);
			cell.setCellValue("Nonperseverative Error T");
			cell = row.createCell(i++);
			cell.setCellValue("Conceprual level Respon T");
			cell = row.createCell(i++);
			cell.setCellValue("Categories Completed\r\n"+"R");
			cell = row.createCell(i++);
			cell.setCellValue("Trials to complete\r\n"+"R");
			cell = row.createCell(i++);
			cell.setCellValue("Failure R");
			cell = row.createCell(i++);
			cell.setCellValue("Learning to Learn");
			cell = row.createCell(i++);
			cell.setCellValue("Categories Completed\r\n"+"%ile");
			cell = row.createCell(i++);
			cell.setCellValue("Trials to complete\r\n"+"%ile");
			cell = row.createCell(i++);
			cell.setCellValue("Failure %ile");
			cell = row.createCell(i++);
			cell.setCellValue("Learning to Learn %ile");
			
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
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);

		}
		
	}

	@Override
	public void mapRow(Row row, NeuropsyWsctVO vo) {
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
		cell.setCellValue(vo.getWsctExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalErrorsR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalErrorsS());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalErrorsT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTotalErrorsIle());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerseverResponT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerseverErrorT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getNonperseverErrorT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getConcepResponT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCategoryCompleteR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTrialCompleteR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getFailureR());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getIngtoLearn());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCategoryCompleteIle());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTrialCompleteIle());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getFailureIle());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIngtoLearnIle());


	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2));
		

		sheet.addMergedRegion(new CellRangeAddress(0, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 6, 6));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 22));
		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));
		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 14, 14));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 16, 16));
		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 20, 20));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 21, 21));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 22, 22));
	

	}
	
}
