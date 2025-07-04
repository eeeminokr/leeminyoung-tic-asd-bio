package medical.framework.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import medical.framework.exception.BizException;
import medical.framework.file.mapping.CellReaderMapper;
import medical.framework.util.POIUtil;

public class ExcelFileReaderImpl<T> extends ExcelFileReader<T> implements InitializingBean {
	protected final Log logger = LogFactory.getLog(getClass());

	private CellReaderMapper<T> cellMapper;
 	
	public List<T> excelRead(File file) throws ExcelFileReaderException {
		Workbook workBook = null;
		List<T> list = new ArrayList<T>();
		
		try {
			workBook = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			throw new ExcelFileReaderException("정상적인 엑셀 파일이 아닙니다.");
		} catch (IOException e) {
			throw new ExcelFileReaderException("파일을 읽지 못했습니다.");
		}

		Sheet sheet = workBook.getSheetAt(getNumberOfSheet());

		if (sheet == null) {
			return list;
		}
		
		String column ="";
		String insertColumn ="";
		int columnCnt=0;
		
		
		//ExcelFileReaderImpl 의 실제 인스턴스 확인
		if(column != null){
			for (int cnt=0; cnt < sheet.getRow(0).getLastCellNum(); cnt++ ){
				try {
					insertColumn = insertColumn +  POIUtil.getStringCellValue( sheet.getRow(0).getCell(cnt))+",";
				} catch (Exception e) {
					throw new ExcelFileReaderException("There is an Exception on ExcelFileReader!!");
				}
			}
			
			if(logger.isDebugEnabled()){
				logger.debug("[cehckColumn]: "+ column);
				logger.debug("[insertColumn]: "+ insertColumn);
			}

			if((insertColumn.replaceAll(" ", "").contains(column))){
				if(logger.isDebugEnabled()){
					logger.debug("[insertColumnCheck]: TRUE");
				}
			}else{
				throw new BizException("업로드 양식파일을 확인하세요. insertColumnCheck!!");
			}
		}
		//ExcelFileReaderImpl 의 실제 컬럼 수 확인
		if(columnCnt != 0){
			if(logger.isDebugEnabled()){
				logger.debug("[ColumnCnt]: "+ columnCnt);
				logger.debug("[SheetColumnCnt]: "+ sheet.getRow(0).getLastCellNum());
			}

			if(sheet.getRow(0).getLastCellNum() == columnCnt){
				if(logger.isDebugEnabled()){
					logger.debug("[ColumnCntCheck]: TRUE");
				}
			}else{
				throw new BizException("업로드 양식파일을 확인하세요. insertColumnCheck!!");
			}
		}

		int row = 0;
		int col = getColsToSkip();
		try {
			for (row = getRowsToSkip(); row < sheet.getLastRowNum() + 1; row++) {
				
				
				logger.debug("[Excel row]:" + row);
				Row rowCheck = sheet.getRow(row);
				String chkValue1 = "";
				String chkValue11 = "";
				if(rowCheck != null) {
					chkValue1 = POIUtil.getStringCellValue(sheet.getRow(row).getCell(col));
					chkValue11 = POIUtil.getStringCellValue(sheet.getRow(row).getCell(col+1));
				}
				logger.debug("[Cell value1 ]:" + chkValue1);
				logger.debug("[Cell value11 ]:" +  chkValue11 );
				
				if ((chkValue1 == null || chkValue1.trim().length() == 0)
					 && (chkValue11 == null || chkValue11.trim().length() == 0)){
					if (row < sheet.getLastRowNum()) {
						Row rowCheck2 = sheet.getRow(row + 1);
						String chkValue2 = "";
						if(rowCheck2 != null) {
							chkValue2 =	POIUtil.getStringCellValue(sheet.getRow(row + 1).getCell(col));
						}
						if (chkValue2 == null || chkValue2.trim().length() == 0)
							break;
						else
							continue;
					} else {
						break;
					}
				}
				list.add(cellMapper.mapCell(sheet, col, row));
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.error("[Error Message] There is an Exception while mapping between cells and the object!!");
				logger.error("[Error Line] Row : " + (row + 1));
				logger.error("[Error Detail]");
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			throw new ExcelFileReaderException("There is an Exception on ExcelFileReader!!");
		}
		return list;
	}

	public void setCellMapper(CellReaderMapper<T> cellMapper) {
		this.cellMapper = cellMapper;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cellMapper, "CellMapper is required.");
	}

}
