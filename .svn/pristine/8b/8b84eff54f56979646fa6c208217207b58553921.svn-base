package medical.imagingInfo.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

//import medical.dataIntegration.service.DataIntegrationListVO;
import medical.framework.file.mapping.CellWriterMapper;
import medical.framework.util.StringUtil;
import medical.imagingInfo.service.ImageInfoVO;

public class ImagingInfoCellWriterMapper2 implements CellWriterMapper<ImageInfoVO>{
	@Override
	public void mapHeader(Row row, ImageInfoVO vo) {
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
			cell.setCellValue("생년월일");

		//	cell = row.createCell(i++);
		//	cell.setCellValue("프로토콜");
			
			cell = row.createCell(5);
			cell.setCellValue("차수");

			cell = row.createCell(6);
			cell.setCellValue("나이");
		
		cell = row.createCell(7);
		cell.setCellValue("실시일");	
		
		cell = row.createCell(8);
		cell.setCellValue("포크랄");		
		
		
		cell = row.createCell(9);
		cell.setCellValue("영상종류");	
		cell = row.createCell(14);
		
		
		
		cell = row.createCell(15);
		cell.setCellValue("업로드 이력관리");		
		}
		if(rowNum==1) {
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
			
			
			cell = row.createCell(9);
			cell.setCellValue("ASL");
			
			cell = row.createCell(10);
			cell.setCellValue("DTI");	
			
			cell = row.createCell(11);
			cell.setCellValue("fMRI");	
			
			cell = row.createCell(12);
			cell.setCellValue("T1");
			
			cell = row.createCell(13);
			cell.setCellValue("T2");
			
			cell = row.createCell(14);
			cell.setCellValue("SWI");
			
			
			cell = row.createCell(15);
		}
	}

	@Override
	public void mapRow(Row row, ImageInfoVO vo) {
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
		cell.setCellValue(vo.getBirthYm());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCnt());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExecDate());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPocral());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAsl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDti());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getFmri());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getT1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getT2());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSwi());
		
//		cell = row.createCell(i++);
//		cell.setCellValue(vo.getAmri());
//		
		cell = row.createCell(i++);
		if(!StringUtil.isEmptyString(vo.getUpdateDate())){
			
			cell.setCellValue(vo.getUpdateDate()+" "+vo.getUpdateBy());
		}else {
			cell.setCellValue(" ");
		}
		
	}
	
	@Override
	public void cellMerge(Sheet sheet) {
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 8, 8));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 14));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 15, 15));
	}
}
