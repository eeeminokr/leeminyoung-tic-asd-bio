package medical.framework.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import medical.framework.file.mapping.CellWriterMapper;

public class ExcelFileWriterImpl<T> extends ExcelFileWriter<T> implements InitializingBean {
	private CellWriterMapper<T> cellMapper = null;

	@Override
	public ExcelFile excelWrite(List<T> list, int version) {
		boolean isXlsx = version == ExcelFile.XLSX;
		Workbook workbook = null;

		if (isXlsx == true) {
			workbook = new SXSSFWorkbook();
		} else {
			workbook = new HSSFWorkbook();
		}

		// init style
		createCellStyle(workbook);
		// create sheet
		Sheet sheet = workbook.createSheet();
		//행고정
		sheet.createFreezePane(0, getMapHeaderRow());
		
				
		
		
		int rowIdx = 0;
		for (T t : list) {
			if (isXlsx == false && rowIdx == 65535) {
				sheet = workbook.createSheet();
				rowIdx = 0;
			}

			for(;rowIdx < getMapHeaderRow(); rowIdx++) {
				// header
						
				Row headerRow = sheet.createRow(rowIdx);	
				cellMapper.mapHeader(headerRow, t);
				applyHeaderStyle(headerRow);
					
				
				headerCellStyle(workbook,headerRow);
				if(rowIdx == (getMapHeaderRow()-1) ) {
					cellMapper.cellMerge(sheet);
				}
			}

			Row row = sheet.createRow(rowIdx);
			cellMapper.mapRow(row, t);
			applyStyle(row);

			rowIdx++;
		}

		ByteArrayOutputStream out = null;

		try {
			out = new ByteArrayOutputStream();
			workbook.write(out);

			ExcelFile excelFile = new ExcelFile();
			excelFile.setBytes(out.toByteArray());
			excelFile.setVersion(isXlsx ? ExcelFile.XLSX : ExcelFile.XLS);

			return excelFile;
		} catch (IOException e) {
			throw new ExcelFileWriterException(e.getMessage());
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {

				}
			}
		}

	}

	private void applyHeaderStyle(Row row) {
		Iterator<Cell> headerCells = row.cellIterator();
		while (headerCells.hasNext()) {
			Cell cell = headerCells.next();
			cell.setCellStyle(super.getHeaderStyle());
		}
	}

	private void applyStyle(Row row) {
		Iterator<Cell> cells = row.cellIterator();
		while (cells.hasNext()) {
			Cell cell = cells.next();
			cell.setCellStyle(super.getDefaultStyle());
		}
	}

	public void setCellMapper(CellWriterMapper<T> cellMapper) {
		this.cellMapper = cellMapper;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.cellMapper, "CellMapper is required.");
	}

	private void applySetStyle(Row row, CellStyle cellStyle) {
		Iterator<Cell> headerCells = row.cellIterator();
		while (headerCells.hasNext()) {
			Cell cell = headerCells.next();
			cell.setCellStyle(cellStyle);
		}
	}
	private void headerCellStyle(Workbook workbook, Row row) {
		//셀 스타일
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setAlignment(CellStyle.ALIGN_CENTER);
		headerStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		headerStyle.setFillPattern((short) 17);
		headerStyle.setFillForegroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
		headerStyle.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
		//테두리 선 (우,좌,위,아래)
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		applySetStyle(row,headerStyle);
		
	}
}
