package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyCatVO;

public class NeuropsyCatWriterMapper2 implements CellWriterMapper<NeuropsyCatVO>{
	@Override
	public void mapHeader(Row row, NeuropsyCatVO vo) {
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
		cell.setCellValue("CAT(단순선택-시각)");
		
		cell = row.createCell(14);
		cell.setCellValue("CAT(단순선택-청각)");	
		
		cell = row.createCell(22);
		cell.setCellValue("CAT(억제지속)");	
		
		cell = row.createCell(30);
		cell.setCellValue("CAT(간섭선택)");
		
		cell = row.createCell(38);
		cell.setCellValue("CAT(분할)");
		
		cell = row.createCell(46);
		cell.setCellValue("CAT(작업기억)");
		cell = row.createCell(53);
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
			cell.setCellValue("누락 R");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 R");
			cell = row.createCell(i++);
			cell.setCellValue("누락 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("누락 R");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 R");
			cell = row.createCell(i++);
			cell.setCellValue("누락 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("누락 R");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 R");
			cell = row.createCell(i++);
			cell.setCellValue("누락 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("누락 R");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 R");
			cell = row.createCell(i++);
			cell.setCellValue("누락 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("누락 R");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 R");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 R");
			cell = row.createCell(i++);
			cell.setCellValue("누락 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("오경보 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 평균 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("정반응 표준편차 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("순방향  정반응 R");
			cell = row.createCell(i++);
			cell.setCellValue("역방향 정반응 R");
			cell = row.createCell(i++);
			cell.setCellValue("순방향 공간폭 R");
			cell = row.createCell(i++);
			cell.setCellValue("역방향 공간폭 R");
			cell = row.createCell(i++);
			cell.setCellValue("순방향 정반응 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("역방향 정반응 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("순방향 공간폭 AQ");
			cell = row.createCell(i++);
			cell.setCellValue("역방향 공간폭 AQ");
			
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyCatVO vo) {
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
		cell.setCellValue(vo.getCatExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvMissr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvFalarmr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvReactrAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvReactrDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvMissaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvFalarmaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvReactaqAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatvReactaqDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathMissr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathFalarmr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathReactrAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathReactrDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathMissaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathFalarmaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathReactaqAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCathReactaqDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcMissr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcFalarmr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcReactrAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcReactrDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcMissaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcFalarmaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcReactaqAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatcReactaqDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiMissr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiFalarmr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiReactrAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiReactrDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiMissaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiFalarmaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiReactaqAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatiReactaqDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdMissr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdFalarmr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdReactrAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdReactrDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdMissaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdFalarmaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdReactaqAvg());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatdReactaqDev());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmdReactr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmrReactr());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmdSpacer());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmrSpacer());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmdReactaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmrReactaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmdSpaceaq());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCatmrSpaceaq());

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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 14));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 15, 22));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 23, 30));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 31, 38));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 39, 46));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 47, 54));
		
	}
	
}
