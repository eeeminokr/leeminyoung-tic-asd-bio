/**
 * 
 */
package medical.framework.file;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import medical.framework.file.mapping.CellReaderMapper;

/**
 * @author jaechulhan
 *
 */
public abstract class ExcelFileReader<T> implements InitializingBean {
	protected final Log logger = LogFactory.getLog(super.getClass());

	protected CellReaderMapper<T> cellMapper;

	protected File file;
	protected int numberOfSheet = 0;
	protected int rowsToSkip = 0;
	protected int colsToSkip = 0;
	protected int rowsOfStart = 0;
	protected int rowsOfEnd = 0;
	protected int cntOfReadRow = 10;
	/**
	 * @param file
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * @return
	 */
	public int getNumberOfSheet() {
		return this.numberOfSheet;
	}

	/**
	 * @param numberOfSheet
	 */
	public void setNumberOfSheet(int numberOfSheet) {
		this.numberOfSheet = numberOfSheet;
	}

	/**
	 * @return
	 */
	public int getRowsToSkip() {
		return this.rowsToSkip;
	}

	/**
	 * @param rowsToSkip
	 */
	public void setRowsToSkip(int rowsToSkip) {
		this.rowsToSkip = rowsToSkip;
	}

	/**
	 * @return
	 */
	public int getColsToSkip() {
		return this.colsToSkip;
	}

	/**
	 * @param colsToSkip
	 */
	public void setColsToSkip(int colsToSkip) {
		this.colsToSkip = colsToSkip;
	}
	
	/**
	 * @return the rowsOfStart
	 */
	public int getRowsOfStart() {
		return rowsOfStart;
	}

	/**
	 * @param rowsOfStart the rowsOfStart to set
	 */
	public void setRowsOfStart(int rowsOfStart) {
		this.rowsOfStart = rowsOfStart;
	}

	/**
	 * @return the rowsOfEnd
	 */
	public int getRowsOfEnd() {
		return this.rowsOfEnd;
	}

	/**
	 * @param rowsOfEnd the rowsOfEnd to set
	 */
	public void setRowsOfEnd(int rowsOfEnd) {
		this.rowsOfEnd = rowsOfEnd;
	}

	/**
	 * @return the cntOfReadRow
	 */
	public int getCntOfReadRow() {
		return this.cntOfReadRow;
	}

	/**
	 * @param cntOfReadRow the cntOfReadRow to set
	 */
	public void setCntOfReadRow(int cntOfReadRow) {
		this.cntOfReadRow = cntOfReadRow;
	}

	/**
	 * @param cellMapper
	 */
	public void setCellMapper(CellReaderMapper<T> cellMapper) {
		this.cellMapper = cellMapper;
	}

	/**
	 * @param file
	 * @return
	 * @throws ExcelFileReaderException
	 */
	public abstract List<T> excelRead(File file) throws ExcelFileReaderException;

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cellMapper, "CellMapper is required");
	}
	
}
