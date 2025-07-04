package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyAdos3VO;
import medical.neuropsy.service.NeuropsyTmtVO;

public class NeuropsyAdos3WriterMapper implements CellWriterMapper<NeuropsyAdos3VO>{
	@Override
	public void mapHeader(Row row, NeuropsyAdos3VO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("뇌원천 연구번호");
		
		cell = row.createCell(i++);
		cell.setCellValue("뇌질환 연구번호");

		cell = row.createCell(i++);
		cell.setCellValue("성별");

		cell = row.createCell(i++);
		cell.setCellValue("프로토콜");	

		cell = row.createCell(i++);
		cell.setCellValue("차수");

		cell = row.createCell(i++);
		cell.setCellValue("나이");

		cell = row.createCell(i++);
		cell.setCellValue("실시일");	
		
		cell = row.createCell(i++);
		cell.setCellValue("ADOS3");
		
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
			cell.setCellValue("Communication");
			cell = row.createCell(i++);
			cell.setCellValue("Reciprocal Social\rInteraction");
			cell = row.createCell(i++);
			cell.setCellValue("Communication+\rSocial interaction");
			cell = row.createCell(i++);
			cell.setCellValue("Stereotyped Behaviours\rand Restricted Interests");
			cell = row.createCell(i++);
			cell.setCellValue("총점");
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyAdos3VO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetDisId());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos3ExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCommunication());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRecSocialInter());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCommuSocialInter());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA3StereoInterest());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos3Total());
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
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 11));
	}
	
}
