package medical.clinician.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.clinician.service.ClinicianTotalVO;
import medical.framework.file.mapping.CellWriterMapper;
import medical.surveyAsd.service.SurveyAsdTotalVO;

public class ClinicianTotalWriterMapper implements CellWriterMapper<ClinicianTotalVO>{
	@Override
	public void mapHeader(Row row, ClinicianTotalVO vo) {
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
		cell.setCellValue("임상가평가");	
	
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++); //질병군
			
			
			cell = row.createCell(i++);
			cell.setCellValue("뇌원천");
			
			cell = row.createCell(i++);
			cell.setCellValue("뇌질환");
			
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
			cell.setCellValue("K-SADS-PL");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("SRS");
			
			
			
			cell = row.createCell(i++);
			cell.setCellValue("CY-BOCS");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("Y-BOCS");
		}
	}
	
	@Override
	public void mapRow(Row row, ClinicianTotalVO vo) {
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
		cell.setCellValue(vo.getCvCgis());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCvCgii());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCvCgas());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExts1());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSrs01());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCybo1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getYbocs());
		
		/*
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKmcht());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getOcbcl());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCbcl2());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getOcb15());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCbc15());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getLsd01());
		
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
*/
	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0)); //질병군
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2)); //연구번호 뇌원천 뇌질환
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3)); // 성별
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4)); //차수
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5)); //나이
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6)); //실시일
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 13)); //임상가평가 

		
	}
	
}
