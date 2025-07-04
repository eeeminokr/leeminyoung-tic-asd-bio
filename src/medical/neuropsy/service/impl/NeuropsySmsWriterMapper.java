package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsySmsVO;

public class NeuropsySmsWriterMapper implements CellWriterMapper<NeuropsySmsVO>{
	@Override
	public void mapHeader(Row row, NeuropsySmsVO vo) {
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
		cell.setCellValue("Subscale");
		
		cell = row.createCell(15);
		cell.setCellValue("SMS");
		cell = row.createCell(16);
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
			cell.setCellValue("이동 능력");
			
			cell = row.createCell(i++);
			cell.setCellValue("의사소통 능력");
			
			cell = row.createCell(i++);
			cell.setCellValue("사회화 능력");
			
			cell = row.createCell(i++);
			cell.setCellValue("작업 능력");

			cell = row.createCell(i++);
			cell.setCellValue("자기관리 능력");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("기본적인 자조 능력");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
		
			
			
			cell = row.createCell(i++);
			cell.setCellValue("SA");
			cell = row.createCell(i++);
			cell.setCellValue("SQ");
		}
		
		if(rowNum==3) {
			
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
			cell.setCellValue("General");
			cell = row.createCell(i++);
			cell.setCellValue("Dressing");
			cell = row.createCell(i++);
			cell.setCellValue("Eating");

		
			cell = row.createCell(i++);
			cell = row.createCell(i++);
		
			
			
			
		}
		
	}

	@Override
	public void mapRow(Row row, NeuropsySmsVO vo) {
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
		cell.setCellValue(vo.getSmsExecDate());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubMovecap());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubCommucap());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubSocialcap());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubWorkcap());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubSelfmanagecap());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubBasicapGeneral());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubBasicapDressing());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSubBasicapEating());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSmsSa());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSmsSq());
	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 0, 0)); //질병군
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2)); //연구번호
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 1, 1)); //뇌원천
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 2, 2)); //뇌질환
		
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 3, 3)); //성별
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 4, 4)); //차수
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 5, 5)); //나이
		sheet.addMergedRegion(new CellRangeAddress(0, 3, 6, 6)); //실시일
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 7, 14));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 10, 10));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 11, 11));
		
		
		
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 12, 14));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 12, 12));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 13, 13));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 14, 14));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 15, 16));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 15, 15));
		sheet.addMergedRegion(new CellRangeAddress(2, 3, 16, 16));
		
		
	}
	
}
