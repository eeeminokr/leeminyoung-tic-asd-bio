package medical.framework.file;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import medical.framework.file.mapping.CellWriterMapper;

public abstract class ExcelFileWriter<T> implements InitializingBean {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected CellWriterMapper<T> cellMapper;
	protected int mapHeaderRow = 1;
	
	private Font defaultFont;
	private CellStyle defaultStyle;
	private CellStyle headerStyle;
	private List<String> header = new ArrayList<String>();

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public void setHeader(String[] header) {
		this.header.clear();
		for (String column : header) {
			this.header.add(column);
		}
	}

	public int getMapHeaderRow() {
		return this.mapHeaderRow;
	}
	
	public void setMapHeaderRow(int mapHeaderRow) {
		this.mapHeaderRow = mapHeaderRow;
	}
	
	public List<String> getHeader() {
		return this.header;
	}

	protected void createCellStyle(Workbook workbook) {
		// default font
		defaultFont = workbook.createFont();
		defaultFont.setFontHeightInPoints((short) 10);
		defaultFont.setFontName("Gothic");
		// default style
		defaultStyle = workbook.createCellStyle();
		defaultStyle.setFont(defaultFont);
		defaultStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// header style
		headerStyle = workbook.createCellStyle();
		headerStyle.setFont(defaultFont);
		headerStyle.setFillPattern((short) 17);
		headerStyle.setFillForegroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
		headerStyle.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT().getIndex());
		headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	}

	protected CellStyle getDefaultStyle() {
		return defaultStyle;
	}

	protected CellStyle getHeaderStyle() {
		return headerStyle;
	}

	public void setCellMapper(CellWriterMapper<T> cellMapper) {
		this.cellMapper = cellMapper;
	}

	public abstract ExcelFile excelWrite(List<T> list, int version);
	
	public ExcelFile excelWrite(List<T> list) {
		return excelWrite(list, ExcelFile.XLSX);
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cellMapper, "CellMapper is required");
	}

}
