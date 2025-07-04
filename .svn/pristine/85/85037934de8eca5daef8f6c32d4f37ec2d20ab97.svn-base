package medical.imagingInfo.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

//import medical.dataIntegration.service.DataIntegrationListVO;
import medical.framework.file.mapping.CellWriterMapper;
import medical.framework.util.StringUtil;
import medical.imagingInfo.service.ImageInfoVO;

public class ImagingInfoCellWriterMapper implements CellWriterMapper<ImageInfoVO>{
	@Override
	public void mapHeader(Row row, ImageInfoVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("연구번호");

		cell = row.createCell(i++);
		cell.setCellValue("질병군");

		cell = row.createCell(i++);
		cell.setCellValue("성별");

		cell = row.createCell(i++);
		cell.setCellValue("프로토콜");
		
		cell = row.createCell(i++);
		cell.setCellValue("생년월일");		
	
		cell = row.createCell(i++);
		cell.setCellValue("차수");	
		
		cell = row.createCell(i++);
		cell.setCellValue("나이");	
		
		cell = row.createCell(i++);
		cell.setCellValue("실시일");	
		
		cell = row.createCell(i++);
		cell.setCellValue("포크랄");		
		
		cell = row.createCell(i++);
		cell.setCellValue("aMRI");	
		
		cell = row.createCell(i++);
		cell.setCellValue("DTI");	
		
		cell = row.createCell(i++);
		cell.setCellValue("ASL");	
		
		cell = row.createCell(i++);
		cell.setCellValue("fMRI");	
		
		cell = row.createCell(i++);
		cell.setCellValue("업로드 이력관리");		
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
		}
	}

	@Override
	public void mapRow(Row row, ImageInfoVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getDisClassDtl());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());
		
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
		cell.setCellValue(vo.getAmri());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getDti());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAsl());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getFmri());
		
		cell = row.createCell(i++);
		if(!StringUtil.isEmptyString(vo.getUpdateDate())){
			
			cell.setCellValue(vo.getUpdateDate()+" "+vo.getUpdateBy());
		}else {
			cell.setCellValue(" ");
		}
		
	}
	
	@Override
	public void cellMerge(Sheet sheet) {
		
	}
}
