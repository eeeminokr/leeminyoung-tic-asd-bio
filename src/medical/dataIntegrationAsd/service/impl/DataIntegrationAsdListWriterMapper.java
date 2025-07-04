package medical.dataIntegrationAsd.service.impl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.dataIntegrationAsd.service.DataIntegrationAsdListVO;

public class DataIntegrationAsdListWriterMapper implements CellWriterMapper<DataIntegrationAsdListVO>{
	@Override
	public void mapHeader(Row row, DataIntegrationAsdListVO vo) {
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
		cell.setCellValue("최종차수");	

		cell = row.createCell(5);
		cell.setCellValue("공존진단");

		cell = row.createCell(6);
		cell.setCellValue("영상");

		cell = row.createCell(7);
		cell.setCellValue("임상가평가");	
		
		cell = row.createCell(11);
		cell.setCellValue("심리/발달검사");	
		
		cell = row.createCell(25);
		cell.setCellValue("설문지");
		
		cell = row.createCell(63);
		cell.setCellValue("환경물질 분석");
		
		cell = row.createCell(65);
		cell.setCellValue("유전자정보");
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
			cell.setCellValue("K-SADS-PL");
			cell = row.createCell(i++);
			cell.setCellValue("SRS");
			cell = row.createCell(i++);
			cell.setCellValue("CY-BOCS");
			cell = row.createCell(i++);
			cell.setCellValue("YBOCS");
	
			
			cell = row.createCell(i++);
			cell.setCellValue("지능검사");		
			cell = row.createCell(i++);
			cell.setCellValue("ATA");
			cell = row.createCell(i++);
			cell.setCellValue("STROOP");
			cell = row.createCell(i++);
			cell.setCellValue("CCTT");
			cell = row.createCell(i++);
			cell.setCellValue("WCST");
			cell = row.createCell(i++);
			cell.setCellValue("CAT");
			cell = row.createCell(i++);
			cell.setCellValue("EXTI-II");
			cell = row.createCell(i++);
			cell.setCellValue("CPT-3");
			cell = row.createCell(i++);
			cell.setCellValue("TMT");
			cell = row.createCell(i++);
			cell.setCellValue("ADOS");
			cell = row.createCell(i++);
			cell.setCellValue("ADOS-2");
			cell = row.createCell(i++);
			cell.setCellValue("PEP-R");
			cell = row.createCell(i++);
			cell.setCellValue("SMS");
			cell = row.createCell(i++);
			cell.setCellValue("CARS");
			
			cell = row.createCell(i++);
			cell.setCellValue("부모자녀평가");
            
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
			cell.setCellValue("아동자가평가");
  
            
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
			cell.setCellValue("부모자가평가"); 
             
			 cell = row.createCell(i++);  
			                              
			 cell = row.createCell(i++);  
			                              
			 cell = row.createCell(i++);  
			                              
			 cell = row.createCell(i++);  
			                              
			 cell = row.createCell(i++);  

			 
			 cell = row.createCell(i++);
			 cell.setCellValue("PHTs 3종 및 COT(소변)");
		     
			 cell = row.createCell(i++);
			 cell.setCellValue("중금속(혈액)");
			
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
			cell.setCellValue("주산기발달력");
			cell = row.createCell(i++);
			cell.setCellValue("KMCHAT");
			cell = row.createCell(i++);
			cell.setCellValue("ARS");
			cell = row.createCell(i++);
			cell.setCellValue("ABC");
			cell = row.createCell(i++);
			cell.setCellValue("SIB");
			cell = row.createCell(i++);
			cell.setCellValue("BPI");
			cell = row.createCell(i++);
			cell.setCellValue("SRS");
			cell = row.createCell(i++);
			cell.setCellValue("SCQ");
			cell = row.createCell(i++);
			cell.setCellValue("부모자녀 AQ/EQ/SQ");
			cell = row.createCell(i++);
			cell.setCellValue("K-ASDS");
			cell = row.createCell(i++);
			cell.setCellValue("SSIS");
			cell = row.createCell(i++);
			cell.setCellValue("트라우마");
			cell = row.createCell(i++);
			cell.setCellValue("CMRS-P");
			cell = row.createCell(i++);
			cell.setCellValue("CPCL");
			cell = row.createCell(i++);
			cell.setCellValue("K-CBCL(구버전)");
			cell = row.createCell(i++);
			cell.setCellValue("CBCL 1.5-5");
			cell = row.createCell(i++);
			cell.setCellValue("CBCL 6-18");
			cell = row.createCell(i++);
			cell.setCellValue("LSD");
			cell = row.createCell(i++);
			cell.setCellValue("QPGS-RⅢ");
			cell = row.createCell(i++);
			cell.setCellValue("GSRS");
			cell = row.createCell(i++);
			cell.setCellValue("K-CSHQ");
			cell = row.createCell(i++);
			cell.setCellValue("CDI 아동용");
			cell = row.createCell(i++);
			cell.setCellValue("BDI 성인용");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-T");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-S");
			cell = row.createCell(i++);
			cell.setCellValue("아동자가 AQ/EQ/SQ 아동용");
			cell = row.createCell(i++);
			cell.setCellValue("아동자가 AQ/EQ/SQ 성인용");
			cell = row.createCell(i++);
			cell.setCellValue("IAT");
			cell = row.createCell(i++);
			cell.setCellValue("K-척도");
			cell = row.createCell(i++);
			cell.setCellValue("K-척도 성인용");
			cell = row.createCell(i++);
			cell.setCellValue("RCMAS");
			cell = row.createCell(i++);
			cell.setCellValue("트라우마 성인용");
			cell = row.createCell(i++);
			cell.setCellValue("BDI(부모용)");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-T(부모)");
			cell = row.createCell(i++);
			cell.setCellValue("STAI-S(부모)");
			cell = row.createCell(i++);
			cell.setCellValue("MBRI");
			cell = row.createCell(i++);
			cell.setCellValue("부모자가 AQ/EQ/SQ");
			cell = row.createCell(i++);
			cell.setCellValue("K-PSI");
			
			cell = row.createCell(i++);
	
			cell = row.createCell(i++);
			
			cell = row.createCell(i++);
		}
	}

	@Override
	public void mapRow(Row row, DataIntegrationAsdListVO vo) {
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
		cell.setCellValue(vo.getPerformCntMaxNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCxtDiag());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getMriDate());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExts1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSrs01());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCybocs());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getYbocs());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getS1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAta());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getStroop());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCctt());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getWsct());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCat());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExitii());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCpt3());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTmt());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAdos2());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPep());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSms());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCars());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPrdv1());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKmchat());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getArs());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAbc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSib());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBpi());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSrs());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScq());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPc3q());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getkAsds());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getSsis());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTrauma());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCmrsp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCpcl());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getOldCbcl());//K구버전
	
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCbcl15()); //6-18
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getOldCbcl15());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getLsd());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getQpgsR3());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getGsrs());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getkCshq());
	
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCdic());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBdia());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaitc());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaisc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCc3qc());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCc3qa());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIat());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKscale());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKscalea());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getRcmas());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getTraumaa());
	
		cell = row.createCell(i++);
		cell.setCellValue(vo.getBdi());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaitp());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getStaisp());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getMbri());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPp3q());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getkPsi());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAnalEnvMatt());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAnalEnvMattBl());	
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getWgs());
		

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
		

		
		
		//임상가평가
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 10));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 7, 7));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 8, 8));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 9, 9));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 10, 10));
		
		//심리/발달검사
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 11, 24));
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
		
		// 설문지
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 25, 62));
		//부모자녀
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 25, 45));
		
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 25, 25));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 26, 26));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 27, 27));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 28, 28));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 29, 29));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 30, 30));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 31, 31));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 32, 32));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 33, 33));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 34, 34));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 35, 35));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 36, 36));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 37, 37));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 38, 38));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 39, 39));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 40, 40));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 41, 41));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 42, 42));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 43, 43));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 44, 44));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 45, 45));

		//아동자가
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 46, 56));
		
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 46, 46));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 47, 47));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 48, 48));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 49, 49));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 50, 50));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 51, 51));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 52, 52));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 53, 53));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 54, 54));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 55, 55));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 56, 56));
		//부모자가
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 57, 62));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 57, 57));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 58, 58));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 59, 59));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 60, 60));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 61, 61));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 62, 62));
		
		//환경물질 분석
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 63, 64));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 63, 63));
		sheet.addMergedRegion(new CellRangeAddress(1, 2, 64, 64));
		//유전자정보
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 65, 65));
	}
	
}
