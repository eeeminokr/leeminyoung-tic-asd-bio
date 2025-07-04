package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyTmtVO;

public class NeuropsyTmtWriterMapper2 implements CellWriterMapper<NeuropsyTmtVO>{
	@Override
	public void mapHeader(Row row, NeuropsyTmtVO vo) {
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
			cell.setCellValue("TMT");
			cell = row.createCell(10);
		
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
			cell.setCellValue("TMT-A(RT)");
			cell = row.createCell(i++);
			cell.setCellValue("error");
			cell = row.createCell(i++);
			cell.setCellValue("TMT-B(RT)");
			cell = row.createCell(i++);
			cell.setCellValue("error");
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
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2));

		sheet.addMergedRegion(new CellRangeAddress(0, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 6, 6));

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		
		
		
		
	}
	
}
