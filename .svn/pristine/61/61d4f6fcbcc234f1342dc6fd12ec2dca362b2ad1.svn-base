package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyTmtVO;
import medical.neuropsy.service.NeuropsyTotalVO;

public class NeuropsyTotalWriterMapper2 implements CellWriterMapper<NeuropsyTotalVO>{
	@Override
	public void mapHeader(Row row, NeuropsyTotalVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(0);
		cell.setCellValue("질병군");	
			
		cell = row.createCell(1);
		cell.setCellValue("뇌원천 연구번호");
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
		cell.setCellValue("지능검사");
		
		cell = row.createCell(8);
		cell.setCellValue("ATA");
		
		cell = row.createCell(9);
		cell.setCellValue("STROOP");
		
		cell = row.createCell(10);
		cell.setCellValue("CCTT");
		
		cell = row.createCell(11);
		cell.setCellValue("WCST");
		
		cell = row.createCell(12);
		cell.setCellValue("CAT");
		
		cell = row.createCell(13);
		cell.setCellValue("EXIT-II");
		
		cell = row.createCell(14);
		cell.setCellValue("CPT-3");
		
		cell = row.createCell(15);
		cell.setCellValue("TMT");
		
		cell = row.createCell(16);
		cell.setCellValue("ADOS");

		cell = row.createCell(17);
		cell.setCellValue("ADOS-2");
		
		
		cell = row.createCell(18);
		cell.setCellValue("PEP-R");
		
		cell = row.createCell(19);
		cell.setCellValue("SMS");
		
		cell = row.createCell(20);
		cell.setCellValue("CARS");
		
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
		cell = row.createCell(i++);
		cell = row.createCell(i++);
		cell = row.createCell(i++);
		cell = row.createCell(i++);
		cell = row.createCell(i++);
		}
		
		if(rowNum==2) {
		cell = row.createCell(i++);
	
			
		cell = row.createCell(i++);
		cell.setCellValue("뇌원천 연구번호");
		
		cell = row.createCell(i++);
		cell.setCellValue("뇌질환 연구번호");

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
	public void mapRow(Row row, NeuropsyTotalVO vo) {
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
		cell.setCellValue(vo.getExecDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getS1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAta());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStroop());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getWsct());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCat());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitii());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCpt3());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTmt());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos2());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPep());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSms());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCars());

	}

	@Override
	public void cellMerge(Sheet sheet) {
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 6, 6));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 11, 11));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 14, 14));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 16, 16));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 20, 20));
	}
	
}
