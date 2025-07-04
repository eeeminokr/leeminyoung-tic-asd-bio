package medical.survey.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.survey.service.SurveyTotalVO;

public class SurveyTotalWriterMapper implements CellWriterMapper<SurveyTotalVO>{
	@Override
	public void mapHeader(Row row, SurveyTotalVO vo) {
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
		cell.setCellValue("방문일자");	
		
		cell = row.createCell(i++);
		cell.setCellValue("임상가평가");	
		
		cell = row.createCell(13);
		cell.setCellValue("부모자녀평가");	
		
		cell = row.createCell(19);
		cell.setCellValue("아동자가평가");	
		
		cell = row.createCell(29);
		cell.setCellValue("부모자가평가");	
		
		cell = row.createCell(35);
		cell.setCellValue("4주간격면담지");	
		cell = row.createCell(41);
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("CGI-S");
			cell = row.createCell(i++);
			cell.setCellValue("CGI-I");
			cell = row.createCell(i++);
			cell.setCellValue("C-GAS");
			cell = row.createCell(i++);
			cell.setCellValue("SRS");
			cell = row.createCell(i++);
			cell.setCellValue("YGTSS");
			cell = row.createCell(i++);
			cell.setCellValue("YBOCS\n(성인)");
			cell = row.createCell(i++);
			cell.setCellValue("YBOCS\n(부모)");
			cell = row.createCell(i++);
			cell.setCellValue("ARS");
			cell = row.createCell(i++);
			cell.setCellValue("K-CBCL");
			cell = row.createCell(i++);
			cell.setCellValue("CBCL");
			cell = row.createCell(i++);
			cell.setCellValue("DBDS");
			cell = row.createCell(i++);
			cell.setCellValue("CMRS-P");
			cell = row.createCell(i++);
			cell.setCellValue("트라우마");
			cell = row.createCell(i++);
			cell.setCellValue("CDI 아동용");
			cell = row.createCell(i++);
			cell.setCellValue("IAT");
			cell = row.createCell(i++);
			cell.setCellValue("K-척도");
			cell = row.createCell(i++);
			cell.setCellValue("RCMAS");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-T\n(아동)");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-S\n(아동)");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-T\n(청소년)");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-S\n(청소년)");
			cell = row.createCell(i++);
			cell.setCellValue("LOI-CV");
			cell = row.createCell(i++);
			cell.setCellValue("K-BIS-11-R");
			cell = row.createCell(i++);
			cell.setCellValue("BDI");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-T\n(부모)");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-S\n(부모)");
			cell = row.createCell(i++);
			cell.setCellValue("MBRI");
			cell = row.createCell(i++);
			cell.setCellValue("K-AADHDS\n(성인용)");
			cell = row.createCell(i++);
			cell.setCellValue("K-PSI");
			cell = row.createCell(i++);
			cell.setCellValue("CGI-S");
			cell = row.createCell(i++);
			cell.setCellValue("CGI-I");
			cell = row.createCell(i++);
			cell.setCellValue("C-GAS");
			cell = row.createCell(i++);
			cell.setCellValue("SRS");
			cell = row.createCell(i++);
			cell.setCellValue("YGTSS");
			cell = row.createCell(i++);
			cell.setCellValue("CY-BOCS");
			cell = row.createCell(i++);
			cell.setCellValue("Pill Count");
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyTotalVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getVisitDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCvCgis());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCvCgii());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCvCgas());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSrs01());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getYgts1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getYboca());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getYbocs());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getArs01());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getKcbcl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCbcl1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDbds1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCmrsp());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTraum());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCdi01());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getIat01());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getKscal());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRcmas());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStitc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStisc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStity());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStisy());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getLoicv());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKbis1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBdi01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStitp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStisp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMbri1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKadhd());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKpsi1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIv4Cgis());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIv4Cgii());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIv4Cgas());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSrs02());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getYgts2());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCybo2());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPillCount());

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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 12));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 13, 18));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 19, 28));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 29, 34));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 35, 41));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 6, 6));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 14, 14));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 15, 15));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 16, 16));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 17, 17));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 18, 18));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 19, 19));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 20, 20));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 21, 21));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 22, 22));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 23, 23));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 24, 24));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 25, 25));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 26, 26));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 27, 27));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 28, 28));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 29, 29));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 30, 30));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 31, 31));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 32, 32));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 33, 33));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 34, 34));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 35, 35));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 36, 36));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 37, 37));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 38, 38));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 39, 43));
		
	}
	
}
