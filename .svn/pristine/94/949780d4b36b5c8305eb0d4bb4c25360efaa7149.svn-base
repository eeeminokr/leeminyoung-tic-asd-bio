package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyCptVO;

public class NeuropsyCptWriterMapper2 implements CellWriterMapper<NeuropsyCptVO>{
	@Override
	public void mapHeader(Row row, NeuropsyCptVO vo) {
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
			cell.setCellValue("CPT-3");
			cell = row.createCell(25);
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
			cell.setCellValue("Detectability T");
			cell = row.createCell(i++);
			cell.setCellValue("Detectabilirt Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("Omissions T");
			cell = row.createCell(i++);
			cell.setCellValue("Omissions Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("Comissions T");
			cell = row.createCell(i++);
			cell.setCellValue("Comissions Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("Perserverations T");
			cell = row.createCell(i++);
			cell.setCellValue("Perserverations Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT T");
			cell = row.createCell(i++);
			cell.setCellValue(" HRT Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT SD T ");
			cell = row.createCell(i++);
			cell.setCellValue("HRT SD Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("variability T");
			cell = row.createCell(i++);
			cell.setCellValue("variability Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT Block Change T");
			cell = row.createCell(i++);
			cell.setCellValue("HRT Block Change Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("HRT ISI Change T ");
			cell = row.createCell(i++);
			cell.setCellValue("HRT ISI Change Guideline");
			cell = row.createCell(i++);
			cell.setCellValue("response style");
			
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
			cell = row.createCell(i++);
			
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyCptVO vo) {
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
		cell.setCellValue(vo.getCpt3ExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDetectT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDetectGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getOmissionT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getOmissionGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getComissionT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getComissionGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPreservT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPreservGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtSdT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtSdGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getVariaT());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getVariaGl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtBct());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtBcg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtIct());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getHrtIcg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getResponStyle());

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
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 25));
		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));
		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 14, 14));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 16, 16));
		
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 20, 20));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 21, 21));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 22, 22));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 23, 23));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 24, 24));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 25, 25));
	
		
	}
	
}
