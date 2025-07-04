package medical.dataIntegration.service.impl;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.dataIntegration.service.DataIntegrationListVO;

public class DataIntegrationListWriterMapper implements CellWriterMapper<DataIntegrationListVO>{
	@Override
	public void mapHeader(Row row, DataIntegrationListVO vo) {
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
		cell.setCellValue("최종차수");	

		cell = row.createCell(i++);
		cell.setCellValue("공존진단");

		cell = row.createCell(i++);
		cell.setCellValue("영상");

		cell = row.createCell(i++);
		cell.setCellValue("심리검사");	
		
		cell = row.createCell(14);
		cell.setCellValue("설문지");	
		
		cell = row.createCell(34);
		cell.setCellValue("임상가평가");
		
		cell = row.createCell(35);
		cell.setCellValue("4주 간격 면담지");
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
			cell.setCellValue("부모자녀평가");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("아동자가평가");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("부모자가평가");
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
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
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
			cell = row.createCell(i++);

		}
	}

	@Override
	public void mapRow(Row row, DataIntegrationListVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntMaxNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCxtDiag());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getMriDate());
		
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
		cell.setCellValue(vo.getArs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKcbcl());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCbcl());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getDbds());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCmrsp());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTrauma());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCdic());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIat());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKscale());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRcmas());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaitc());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaisc());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getLoicv());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKbis11r());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBdi());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaitp());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaisp());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMbri());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKaadhdsAdult());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKpsi());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getClinicalValuation());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterval4Interview());

	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 34, 34));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 35, 35));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 13));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 14, 33));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 14, 19));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 20, 27));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 28, 33));
	}
	
}
