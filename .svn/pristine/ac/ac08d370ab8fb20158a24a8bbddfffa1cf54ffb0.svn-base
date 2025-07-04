package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyWsctVO;

public class NeuropsyWsctWriterMapper implements CellWriterMapper<NeuropsyWsctVO>{
	@Override
	public void mapHeader(Row row, NeuropsyWsctVO vo) {
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
		cell.setCellValue("WSCT");
		cell = row.createCell(21);
		
		}
		if(rowNum==1) {
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
	}

	@Override
	public void mapRow(Row row, NeuropsyWsctVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

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
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 21));

	}
	
}
