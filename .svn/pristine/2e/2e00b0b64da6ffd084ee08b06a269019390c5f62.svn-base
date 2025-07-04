/**
 * 
 */
package medical.framework.file.mapping;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

public interface CellWriterMapper<T> {
	
	void mapHeader(Row row, T vo);

	void mapRow(Row row, T vo);
	
	void cellMerge(Sheet sheet);

}
