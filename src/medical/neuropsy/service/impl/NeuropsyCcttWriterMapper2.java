package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyCcttVO;

public class NeuropsyCcttWriterMapper2 implements CellWriterMapper<NeuropsyCcttVO>{
	@Override
	public void mapHeader(Row row, NeuropsyCcttVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
			
		cell = row.createCell(0);
		cell.setCellValue("질병군");
			
		cell = row.createCell(1);
		cell.setCellValue("연구번호");
		cell = row.createCell(2);

		cell = row.createCell(3);
		cell.setCellValue("성별");


		cell = row.createCell(4);
		cell.setCellValue("차수");

		cell = row.createCell(5);
		cell.setCellValue("나이");

		cell = row.createCell(6);
		cell.setCellValue("실시일");	
		
		cell = row.createCell(7);
		cell.setCellValue("CCTT-1");
		
		cell = row.createCell(13);
		cell.setCellValue("CCTT-2");	
		
		cell = row.createCell(20);
		cell.setCellValue("Interference A");	
		
		cell = row.createCell(22);
		cell.setCellValue("Interference B");	
		cell = row.createCell(24);
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
		
		if(rowNum==2) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("뇌원천");
			cell = row.createCell(i++);
			cell.setCellValue("뇌질환");
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
		
			cell = row.createCell(i++);
		
			cell = row.createCell(i++);

			cell = row.createCell(i++);

			cell = row.createCell(i++);
	
			cell = row.createCell(i++);
		
			cell = row.createCell(i++);

			cell = row.createCell(i++);
	
		}
		
		
	}

	@Override
	public void mapRow(Row row, NeuropsyCcttVO vo) {
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
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2));
	
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 6, 6));
	
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 12));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
		
		
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 13, 19));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 14, 14));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 16, 16));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 19, 19));
		
	
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 20, 21));
		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 20, 20));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 21, 21));

		
		
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 22, 24));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 22, 22));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 23, 23));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 24, 24));
	
		

	}

	
}
