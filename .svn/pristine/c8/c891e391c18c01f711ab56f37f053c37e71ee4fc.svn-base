package medical.main.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import medical.framework.file.mapping.CellWriterMapper;
import medical.main.service.DashboardVO;

public class DashboardListWriterMapper implements CellWriterMapper<DashboardVO>{
	DashboardVO dashboardVo = new DashboardVO();
	
	@Override
	public void mapHeader(Row row, DashboardVO vo) {
		dashboardVo = vo;
		
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		
		String vNm = vo.getPerformNm();
		String[] vNmArr = null;
		
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("항목");

		cell = row.createCell(2);
		cell.setCellValue("V0(baseline)");

		cell = row.createCell(4);
		cell.setCellValue("4wk 약물면담");

		cell = row.createCell(7);
		cell.setCellValue("8wk 약물면담");	

		cell = row.createCell(10);
		cell.setCellValue("12wk 약물면담");
	
		if(vNm != null) vNmArr = vNm.split(",");
		int cellNum = 13;
		String title;
		
			for(int j = 0; j < vNmArr.length; j++) {
				String vNmSplit = vNmArr[j];
				title = vNmSplit+" ("+(j+1)+"년 f/u)";
				
				cell = row.createCell(cellNum);
				cell.setCellValue(title);
				
				cellNum += 4;
			}
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("완료");
			cell = row.createCell(i++);
			cell.setCellValue("예정");
			cell = row.createCell(i++);
			cell.setCellValue("DROP");
			cell = row.createCell(i++);
			cell.setCellValue("완료");
			cell = row.createCell(i++);
			cell.setCellValue("예정");
			cell = row.createCell(i++);
			cell.setCellValue("DROP");
			cell = row.createCell(i++);
			cell.setCellValue("완료");
			cell = row.createCell(i++);
			cell.setCellValue("예정");
			cell = row.createCell(i++);
			cell.setCellValue("DROP");
			cell = row.createCell(i++);
			cell.setCellValue("완료");
			cell = row.createCell(i++);
			cell.setCellValue("예정");
			
			if(vNm != null) vNmArr = vNm.split(",");
			for(int j = 0; j < vNmArr.length; j++) {
				cell = row.createCell(i++);
				cell.setCellValue("DROP");
				cell = row.createCell(i++);
				cell.setCellValue("완료");
				cell = row.createCell(i++);
				cell.setCellValue("예정");
				cell = row.createCell(i++);
				cell.setCellValue("대기");
			}

		}
		
	}

	@Override
	public void mapRow(Row row, DashboardVO vo) {
		
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getClassCdDtlNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());
		
		cell = row.createCell(i++);
		cell.setCellValue(Integer.parseInt(vo.getS3pc1()));

		cell = row.createCell(i++);
		cell.setCellValue(Integer.parseInt(vo.getS2pc1()));
		
		cell = row.createCell(i++);
		if(vo.getS4pc2().indexOf(".") != -1) {
			cell.setCellValue(vo.getS4pc2());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS4pc2()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS3pc2().indexOf(".") != -1) {
			cell.setCellValue(vo.getS3pc2());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS3pc2()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS2pc2().indexOf(".") != -1) {
			cell.setCellValue(vo.getS2pc2());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS2pc2()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS4pc3().indexOf(".") != -1) {
			cell.setCellValue(vo.getS4pc3());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS4pc3()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS3pc3().indexOf(".") != -1) {
			cell.setCellValue(vo.getS4pc3());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS4pc3()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS2pc3().indexOf(".") != -1) {
			cell.setCellValue(vo.getS2pc3());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS2pc3()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS4pc4().indexOf(".") != -1) {
			cell.setCellValue(vo.getS4pc4());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS4pc4()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS3pc4().indexOf(".") != -1) {
			cell.setCellValue(vo.getS3pc4());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS3pc4()));
		}
		
		cell = row.createCell(i++);
		if(vo.getS2pc4().indexOf(".") != -1) {
			cell.setCellValue(vo.getS2pc4());
		}else{
			cell.setCellValue(Integer.parseInt(vo.getS2pc4()));
		}
		
		String val = vo.getSpcList();
		String[] valArr = null;
		valArr = val.split(",");

			for(int m = 0; m < valArr.length; m++) {
				cell = row.createCell(i++);
				cell.setCellValue(Integer.parseInt(valArr[m]));
			}
		
	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 9));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 10, 12));
		
		sheet.addMergedRegion(new CellRangeAddress(2, 4, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(5, 7, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(8, 10, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(11, 11, 0, 1));
		
		String vNm = dashboardVo.getPerformNm();
		String[] vNmArr = null;
		if(vNm != null) vNmArr = vNm.split(",");
		int cellNum = 13;

		for(int l = 0; l<vNmArr.length; l++) {
			sheet.addMergedRegion(new CellRangeAddress(0, 0, cellNum, cellNum+3));
			cellNum += 4;
		}
		
	}

}
