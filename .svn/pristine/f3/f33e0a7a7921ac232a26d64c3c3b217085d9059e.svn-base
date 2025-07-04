package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyTmtVO;
import medical.neuropsy.service.NeuropsyTotalVO;

public class NeuropsyTotalWriterMapper implements CellWriterMapper<NeuropsyTotalVO>{
	@Override
	public void mapHeader(Row row, NeuropsyTotalVO vo) {
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
		cell.setCellValue("ATA");
		
		cell = row.createCell(i++);
		cell.setCellValue("STROOP");
		
		cell = row.createCell(i++);
		cell.setCellValue("CCTT");
		
		cell = row.createCell(i++);
		cell.setCellValue("WCST");
		
		cell = row.createCell(i++);
		cell.setCellValue("CAT");
		
		cell = row.createCell(i++);
		cell.setCellValue("EXIT-II");
		
		cell = row.createCell(i++);
		cell.setCellValue("CPT-3");
		
		cell = row.createCell(i++);
		cell.setCellValue("TMT");
		
		
		
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyTotalVO vo) {
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
		cell.setCellValue(vo.getExecDate());
		
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

	}

	@Override
	public void cellMerge(Sheet sheet) {
		
	}
	
}
