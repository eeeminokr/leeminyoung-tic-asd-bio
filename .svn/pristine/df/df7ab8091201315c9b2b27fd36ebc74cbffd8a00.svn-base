package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyCarsVO;

public class NeuropsyCarsWriterMapper implements CellWriterMapper<NeuropsyCarsVO>{
	@Override
	public void mapHeader(Row row, NeuropsyCarsVO vo) {
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

//		cell = row.createCell(i++);
//		cell.setCellValue("프로토콜");	

		cell = row.createCell(4);
		cell.setCellValue("차수");

		cell = row.createCell(5);
		cell.setCellValue("나이");

		cell = row.createCell(6);
		cell.setCellValue("실시일");	

		
		cell = row.createCell(7);
		cell.setCellValue("Subscale");
		
		
		cell = row.createCell(22);
		cell.setCellValue("CARS");
		
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
			cell.setCellValue("뇌원천");
		
			cell = row.createCell(i++);
			cell.setCellValue("뇌질환 ");
			
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
		
			
			cell = row.createCell(i++);
			cell.setCellValue("사람과의 관계");
			
			cell = row.createCell(i++);
			cell.setCellValue("모방");
			
			cell = row.createCell(i++);
			cell.setCellValue("정서반응");
			
			cell = row.createCell(i++);
			cell.setCellValue("신체반응");

			cell = row.createCell(i++);
			cell.setCellValue("물체사용");
			
			cell = row.createCell(i++);
			cell.setCellValue("변화에 대한 적응");
			
			cell = row.createCell(i++);
			cell.setCellValue("시각반응");
			
			cell = row.createCell(i++);
			cell.setCellValue("청각반응");
			
			cell = row.createCell(i++);
			cell.setCellValue("미각,후각,촉각 반응 및 사용");

			cell = row.createCell(i++);
			cell.setCellValue("두려움 또는 신경과민");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("언어적 의사소통");
			
			cell = row.createCell(i++);
			cell.setCellValue("비언어적 의사소통");
			
			cell = row.createCell(i++);
			cell.setCellValue("활동수준");
			
			cell = row.createCell(i++);
			cell.setCellValue("지적 반응의 수준과 항상성");

			cell = row.createCell(i++);
			cell.setCellValue("일반적 인상");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("총점");
			
		
	
		}
		
		
	}

	@Override
	public void mapRow(Row row, NeuropsyCarsVO vo) {
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

//		cell = row.createCell(i++);
//		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCarsExecDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubPsRelation());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubImitation());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubEmoRact());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubBodyuse());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubObjuse());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubChgAdapt());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubVisualRact());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubAuditoryRact());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubEtcRactUse());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubFearNervous());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubVerbCommu());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubNonverbCommu());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubActlev());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubIntellevCstc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubGeneralEft());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCarsTotal());
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
		
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 21));
		
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 11, 11));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 14, 14));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 15, 15)); 
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 16, 16));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 17, 17));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 18, 18));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 19, 19));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 20, 20)); 
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 21, 21));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 22, 22));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 22, 22));
	}
	
}
