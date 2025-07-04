/**
 * 
 */
package medical.framework.util;

import java.math.BigDecimal;
//import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.util.NumberToTextConverter;

public class POIUtil {
	
	private static final String EMPTY_STRING = "";
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//private static DecimalFormat nf = new DecimalFormat("########################.####################");

	private static DataFormatter formatter = new DataFormatter();

	public static synchronized String getStringCellValue(Cell cell) throws Exception {

		if(cell == null) {
			return "";
		} else {

			String cellValue = "";
			
			switch(cell.getCellType()) {
							
				case Cell.CELL_TYPE_STRING:
					cellValue = cell.getStringCellValue();
					break;
	
				case Cell.CELL_TYPE_NUMERIC:
					if( DateUtil.isCellDateFormatted(cell) ) {
						cellValue = df.format(cell.getDateCellValue());
					} else {
						//java와 excel의 소수점 표현이 다른 형식을 가지고 있기에 엑셀의 소수점을 똑같이 표현하고자 NumberToTextConverter 클래스 사용
						cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
						//cellValue = nf.format(cell.getNumericCellValue());
					}
					break;
	
				case Cell.CELL_TYPE_BLANK:
					cellValue = EMPTY_STRING;
					break;
	
				case Cell.CELL_TYPE_BOOLEAN:
					cellValue = cell.getBooleanCellValue()?"Y":"N";
					break;
	
				case Cell.CELL_TYPE_ERROR:
					cellValue = ErrorEval.getText(cell.getErrorCellValue());
					break;	

				case Cell.CELL_TYPE_FORMULA:
					
					switch(cell.getCachedFormulaResultType()) {	
	
						case Cell.CELL_TYPE_BLANK:
							cellValue = EMPTY_STRING;
							break;
		
						case Cell.CELL_TYPE_STRING:
							RichTextString str = cell.getRichStringCellValue();
							if(str != null && str.length() > 0) {
								cellValue = str.toString();
							}
							break;
		
						case Cell.CELL_TYPE_NUMERIC:
							CellStyle style = cell.getCellStyle();
							if(style == null) {
								cellValue = String.valueOf( cell.getNumericCellValue() );
							} else {
								cellValue = String.valueOf(formatter.formatRawCellContents(cell.getNumericCellValue(), style.getDataFormat(), style.getDataFormatString())
								);
							}
							break;
		
						case Cell.CELL_TYPE_BOOLEAN:
							cellValue = cell.getBooleanCellValue()?"Y":"N";
							break;
							
						case Cell.CELL_TYPE_ERROR:
							cellValue = ErrorEval.getText(cell.getErrorCellValue());
							break;
					}
	
					break;
					
				default:
					throw new RuntimeException("Unexpected cell type (" + cell.getCellType() + ")");
			}			
			return cellValue;
		}

	}	

	public static BigDecimal getNumericCellValue(Cell cell){
		return BigDecimal.valueOf(cell.getNumericCellValue());
	}
	
}