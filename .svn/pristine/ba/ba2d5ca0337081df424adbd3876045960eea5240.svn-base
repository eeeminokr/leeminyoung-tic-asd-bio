package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyAdos1VO;
import medical.neuropsy.service.NeuropsyTmtVO;

public class NeuropsyAdos1WriterMapper implements CellWriterMapper<NeuropsyAdos1VO>{
	@Override
	public void mapHeader(Row row, NeuropsyAdos1VO vo) {
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
		cell.setCellValue("모듈");	
		
		cell = row.createCell(8);
		cell.setCellValue("ADOS");
		cell = row.createCell(13);
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
			cell.setCellValue("의사소통");
			cell = row.createCell(i++);
			cell.setCellValue("사회적\n상호작용");
			cell = row.createCell(i++);
			cell.setCellValue("의사소통+사회적\n상호작용 총점");
			cell = row.createCell(i++);
			cell.setCellValue("놀이");
			cell = row.createCell(i++);
			cell.setCellValue("상동행동 행동과\n제한된 관심사");
			cell = row.createCell(i++);
			cell.setCellValue("총점");
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
			
		}
		
		
	}

	@Override
	public void mapRow(Row row, NeuropsyAdos1VO vo) {
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
		cell.setCellValue(vo.getAdos1ExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos1Module());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos1Commu());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSocialInteraction());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getLanSocialInter());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos1Play());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA1StereoInterest());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos1Total());
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
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 7, 7));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 13));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 13, 13));
		
		
	}
	
}
