package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyTmtVO;

public class NeuropsyTmtWriterMapper implements CellWriterMapper<NeuropsyTmtVO>{
	@Override
	public void mapHeader(Row row, NeuropsyTmtVO vo) {
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
		cell.setCellValue("TMT");
		cell = row.createCell(9);
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("TMT-A(RT)");
			cell = row.createCell(i++);
			cell.setCellValue("error");
			cell = row.createCell(i++);
			cell.setCellValue("TMT-B(RT)");
			cell = row.createCell(i++);
			cell.setCellValue("error");
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyTmtVO vo) {
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
		cell.setCellValue(vo.getTmtExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTmtArt());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTmtAError());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTmtBrt());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTmtBError());


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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 9));
		
	}
	
}
