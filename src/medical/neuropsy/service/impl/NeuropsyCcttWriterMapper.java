package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyCcttVO;

public class NeuropsyCcttWriterMapper implements CellWriterMapper<NeuropsyCcttVO>{
	@Override
	public void mapHeader(Row row, NeuropsyCcttVO vo) {
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
		cell.setCellValue("실시일");	
		
		cell = row.createCell(i++);
		cell.setCellValue("CCTT-1");
		
		cell = row.createCell(12);
		cell.setCellValue("CCTT-2");	
		
		cell = row.createCell(19);
		cell.setCellValue("Interference A");	
		
		cell = row.createCell(21);
		cell.setCellValue("Interference B");	
		cell = row.createCell(23);
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("완성시간");
			cell = row.createCell(i++);
			cell.setCellValue("T점");
			cell = row.createCell(i++);
			cell.setCellValue("%ile");
			cell = row.createCell(i++);
			cell.setCellValue("숫자순서오류");
			cell = row.createCell(i++);
			cell.setCellValue("근사오류");
			cell = row.createCell(i++);
			cell.setCellValue("촉진");
			cell = row.createCell(i++);
			cell.setCellValue("완성시간");
			cell = row.createCell(i++);
			cell.setCellValue("T점");
			cell = row.createCell(i++);
			cell.setCellValue("%ile");
			cell = row.createCell(i++);
			cell.setCellValue("색순서오류");
			cell = row.createCell(i++);
			cell.setCellValue("숫자순서오류");
			cell = row.createCell(i++);
			cell.setCellValue("근사오류");
			cell = row.createCell(i++);
			cell.setCellValue("촉진");
			cell = row.createCell(i++);
			cell.setCellValue("비율간섭지표R");
			cell = row.createCell(i++);
			cell.setCellValue("%ile");
			cell = row.createCell(i++);
			cell.setCellValue("차이간섭지표R");
			cell = row.createCell(i++);
			cell.setCellValue("T점");
			cell = row.createCell(i++);
			cell.setCellValue("%ile");
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyCcttVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCcttExecDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt1CompleteTime());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt1Tpoint());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt1Ile());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt1DigseqErr());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt1ApproxErr());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt1Catalist());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt2CompleteTime());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt2Tpoint());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt2Ile());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt2ColseqErr());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt2DigseqErr());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt2ApproxErr());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt2Catalist());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterferARiir());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterferAIle());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterferBRiir());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterferBTpoint());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getInterferBIle());
		
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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 11));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 12, 18));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 19, 20));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 21, 23));
	}

	
}
