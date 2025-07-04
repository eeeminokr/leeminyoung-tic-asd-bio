package medical.surveyAsd.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.surveyAsd.service.SurveyAsdTotalVO;

public class SurveyAsdTotalWriterMapper implements CellWriterMapper<SurveyAsdTotalVO>{
	@Override
	public void mapHeader(Row row, SurveyAsdTotalVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
			cell = row.createCell(0);
			cell.setCellValue("질병군");	
			
			cell = row.createCell(1);
			cell.setCellValue("연구번호");
			
			cell = row.createCell(3);
			cell.setCellValue("성별");


			cell = row.createCell(4);
			cell.setCellValue("차수");

			cell = row.createCell(5);
			cell.setCellValue("나이");

			cell = row.createCell(6);
			cell.setCellValue("실시일");	
			
			cell = row.createCell(7);
			cell.setCellValue("주산기 발달력");	
			
			cell = row.createCell(8);
			cell.setCellValue("부모자녀평가");	
			
			cell = row.createCell(28);
			cell.setCellValue("아동자가평가");	
			
			cell = row.createCell(39);
			cell.setCellValue("부모자가평가");
			cell = row.createCell(44);
		}
		if(rowNum==1) {
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
			cell.setCellValue("KMCHAT");
			
			cell = row.createCell(i++);
			cell.setCellValue("ARS");
			
			cell = row.createCell(i++);
			cell.setCellValue("ABC");
			
			cell = row.createCell(i++);
			cell.setCellValue("SIB");
			
			cell = row.createCell(i++);
			cell.setCellValue("BPI");
			
			cell = row.createCell(i++);
			cell.setCellValue("SRS");
		
			cell = row.createCell(i++);
			cell.setCellValue("SCQ");
		
			cell = row.createCell(i++);
			cell.setCellValue("부모 자녀 AQ/EQ/SQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("K-ASDS");
			
			cell = row.createCell(i++);
			cell.setCellValue("SSIS");
			
			cell = row.createCell(i++);
			cell.setCellValue("트라우마");
			
			cell = row.createCell(i++);
			cell.setCellValue("CMRS");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("CPCL");
			
			cell = row.createCell(i++);
			cell.setCellValue("K-CBCL(구버전)");
			
			cell = row.createCell(i++);
			cell.setCellValue("CBCL 1.5-5");
		
			cell = row.createCell(i++);
			cell.setCellValue("CBCL 6-18");
		
			cell = row.createCell(i++);
			cell.setCellValue("LSD");
		
			cell = row.createCell(i++);
			cell.setCellValue("QPGS-RⅢ");
			
			cell = row.createCell(i++);
			cell.setCellValue("GSRS");
		
			cell = row.createCell(i++);
			cell.setCellValue("K-CSHQ");
			

			cell = row.createCell(i++);
			cell.setCellValue("CDI");
		
			cell = row.createCell(i++);
			cell.setCellValue("BDI 성인용");
		
			cell = row.createCell(i++);
			cell.setCellValue("STAI-T");
		
			cell = row.createCell(i++);
			cell.setCellValue("STAI-S");
		
			cell = row.createCell(i++);
			cell.setCellValue("아동자가 AQ/EQ/SQ 아동용");
		
			cell = row.createCell(i++);
			cell.setCellValue("아동 자가 AQ/EQ/SQ 성인용");
		
			cell = row.createCell(i++);
			cell.setCellValue("IAT");
		
			cell = row.createCell(i++);
			cell.setCellValue("K-척도");
		
			cell = row.createCell(i++);
			cell.setCellValue("K-척도 성인용");
		
			cell = row.createCell(i++);
			cell.setCellValue("RCMAS");
	
			cell = row.createCell(i++);
			cell.setCellValue("트라우마 성인용");
	
			
			cell = row.createCell(i++);
			cell.setCellValue("BDI 부모용");
	
			cell = row.createCell(i++);
			cell.setCellValue("STAI-T 부모용");
		
			cell = row.createCell(i++);
			cell.setCellValue("STAI-S 부모용");
		
			cell = row.createCell(i++);
			cell.setCellValue("MBRI");
		
			cell = row.createCell(i++);
			cell.setCellValue("부모자가 AQ/EQ/SQ");
		
			cell = row.createCell(i++);
			cell.setCellValue("K-PSI");
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyAsdTotalVO vo) {
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
		cell.setCellValue(vo.getPerformNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getExecDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPrdv1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKmcht());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getArs01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAbc01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSib01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBpi01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSrs03());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScq01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPc3q1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKasds());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSsis1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTraum());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCmrsp());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCpcl());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getOcbcl());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCbc15());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getOcb15());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getLsd01());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getQpgsr());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getGsrs1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKcshq());
		
	
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCdi01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBdi02());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStitc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStisc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCc3qc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCc3qa());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIat01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKscal());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKscaa());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRcmas());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTraua());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBdi01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStitp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStisp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMbri1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPp3q1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKpsi1());

	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 27));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 28, 38));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 39, 44));
		
	}
	
}
