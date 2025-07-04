package medical.neuropsy.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.neuropsy.service.NeuropsyS1VO;

public class NeuropsyS1WriterMapper2 implements CellWriterMapper<NeuropsyS1VO>{
	@Override
	public void mapHeader(Row row, NeuropsyS1VO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		
		if(rowNum==0) {
			
		cell = row.createCell(i++);
		cell.setCellValue("질병군");	
			
		cell = row.createCell(i++);
		cell.setCellValue("연구번호");
		
		
		cell = row.createCell(3);
		cell.setCellValue("성별");

	//	cell = row.createCell(i++);
	//	cell.setCellValue("프로토콜");
		
		cell = row.createCell(4);
		cell.setCellValue("차수");

		cell = row.createCell(5);
		cell.setCellValue("나이");

	//	cell = row.createCell(i++);
	//	cell.setCellValue("K-SADS\r실시일");	
		
		
		cell = row.createCell(6);
		cell.setCellValue("지능검사\r실시일");
		
		cell = row.createCell(7);
		cell.setCellValue("FSIQ");
		
	//	cell = row.createCell(i++);
	//	cell.setCellValue("K-SADS");
		
		cell = row.createCell(8);
		cell.setCellValue("지능-K-Leiter");
		
		cell = row.createCell(62);
		cell.setCellValue("KEDI-WISC");
		
		cell = row.createCell(70);
		cell.setCellValue("K-WISC-IV");
		
		cell = row.createCell(115);
		cell.setCellValue("K-WAIS-IV");
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);//질병군
			cell = row.createCell(i++);//뇌원천
			cell = row.createCell(i++);//뇌질환
			cell = row.createCell(i++);//성별
			cell = row.createCell(i++);//차수
			cell = row.createCell(i++);//나이
			cell = row.createCell(i++);//실시일
			cell = row.createCell(i++);//FISQ
			
			
			cell = row.createCell(i++); //8 
		 	cell.setCellValue("환산점수의\r합계");  
			cell = row.createCell(i++); //9
			cell = row.createCell(i++); //10
			cell = row.createCell(i++); //11
	
			cell = row.createCell(i++); //12 
			cell.setCellValue("지능지수\r복합지수");
			cell = row.createCell(i++); //13
			cell = row.createCell(i++); //14
			cell = row.createCell(i++); //15
			
			cell = row.createCell(i++); //16
			cell.setCellValue("시각화\r및\r추론\r원점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //23
			cell.setCellValue("시각화\r및\r추론\r환산점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
		
			cell = row.createCell(i++); //30
			cell.setCellValue("주의환산합계");
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //32
			cell.setCellValue("주의복합지수");
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //34
			cell.setCellValue("원점수");
			cell = row.createCell(i++); //35
			cell = row.createCell(i++); //36
			cell = row.createCell(i++); //37
			cell = row.createCell(i++); //38
		    
			cell = row.createCell(i++); //39
			cell.setCellValue("환산점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //44
			cell.setCellValue("부모용");
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //46
			cell.setCellValue("원점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //54
			cell.setCellValue("환산점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //62 
			cell.setCellValue("원점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //66
			cell.setCellValue("환산점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //70 
			cell.setCellValue("원점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //80
			cell.setCellValue("환산점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //90
			cell.setCellValue("환산점수합");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //95
			cell.setCellValue("지표점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);  
			
			cell = row.createCell(i++); //100
			cell.setCellValue("백분위");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //105
			cell.setCellValue("95%신뢰구간");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //110
			cell.setCellValue("지적분류(수준)");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++);	 //115
			cell.setCellValue("원점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //125
			cell.setCellValue("환산점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //135
			cell.setCellValue("환산점수합");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //140
			cell.setCellValue("지표점수");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //145
			cell.setCellValue("백분위");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			
			cell = row.createCell(i++); //150
			cell.setCellValue("95%신뢰구간");
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
	

		}
		if(rowNum==2) {
		
			//////////////////////////////////////////////
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
			cell.setCellValue("전체지능");
			cell = row.createCell(i++);
			cell.setCellValue("단축지능");
			cell = row.createCell(i++);
			cell.setCellValue("유동적 추론");
			cell = row.createCell(i++);
			cell.setCellValue("기본적 시각화");
			cell = row.createCell(i++);
			cell.setCellValue("전체지능");
			cell = row.createCell(i++);
			cell.setCellValue("단축지능");
			cell = row.createCell(i++);
			cell.setCellValue("유동적 추론");
			cell = row.createCell(i++);
			cell.setCellValue("기본적 시각화");
			cell = row.createCell(i++);
			cell.setCellValue("전경배경");
			cell = row.createCell(i++);
			cell.setCellValue("형태완성");
			cell = row.createCell(i++);
			cell.setCellValue("짝짓기");
			cell = row.createCell(i++);
			cell.setCellValue("계기적 순서추론");
			cell = row.createCell(i++);
			cell.setCellValue("반복패턴찾기");
			cell = row.createCell(i++);
			cell.setCellValue("그림맥락추론");
			cell = row.createCell(i++);
			cell.setCellValue("범주화");
			cell = row.createCell(i++);
			cell.setCellValue("전경배경");
			cell = row.createCell(i++);
			cell.setCellValue("형태완성");
			cell = row.createCell(i++);
			cell.setCellValue("짝짓기");
			cell = row.createCell(i++);
			cell.setCellValue("계기적 순서추론");
			cell = row.createCell(i++);
			cell.setCellValue("반복패턴찾기");
			cell = row.createCell(i++);
			cell.setCellValue("그림맥락추론");
			cell = row.createCell(i++);
			cell.setCellValue("범주화");
			cell = row.createCell(i++);
			cell.setCellValue("기억선별");
			cell = row.createCell(i++);
			cell.setCellValue("재인기억");
			cell = row.createCell(i++);
			cell.setCellValue("기억선별");
			cell = row.createCell(i++);
			cell.setCellValue("재인기억");
			cell = row.createCell(i++);
			cell.setCellValue("쌍대연합");
			cell = row.createCell(i++);
			cell.setCellValue("즉각재인");
			cell = row.createCell(i++);
			cell.setCellValue("바로 따라기억하기");
			cell = row.createCell(i++);
			cell.setCellValue("지속적주의력");
			cell = row.createCell(i++);
			cell.setCellValue("지연재인");
			cell = row.createCell(i++);
			cell.setCellValue("쌍대연합");
			cell = row.createCell(i++);
			cell.setCellValue("즉각재인");
			cell = row.createCell(i++);
			cell.setCellValue("바로 따라기억하기");
			cell = row.createCell(i++);
			cell.setCellValue("지속적주의력");
			cell = row.createCell(i++);
			cell.setCellValue("지연재인");
			cell = row.createCell(i++);
			cell.setCellValue("인지/사회 복합점수");
			cell = row.createCell(i++);
			cell.setCellValue("정서/조절 복합점수");
			cell = row.createCell(i++);
			cell.setCellValue("주의력");
			cell = row.createCell(i++);
			cell.setCellValue("활동수준");
			cell = row.createCell(i++);
			cell.setCellValue("충동성");
			cell = row.createCell(i++);
			cell.setCellValue("적응능력");
			cell = row.createCell(i++);
			cell.setCellValue("기분과자신감");
			cell = row.createCell(i++);
			cell.setCellValue("활력감정");
			cell = row.createCell(i++);
			cell.setCellValue("사회성");
			cell = row.createCell(i++);
			cell.setCellValue("조절");
			cell = row.createCell(i++);
			cell.setCellValue("주의력");
			cell = row.createCell(i++);
			cell.setCellValue("활동수준");
			cell = row.createCell(i++);
			cell.setCellValue("충동성");
			cell = row.createCell(i++);
			cell.setCellValue("적응능력");
			cell = row.createCell(i++);
			cell.setCellValue("기분과자신감");
			cell = row.createCell(i++);
			cell.setCellValue("활력감정");
			cell = row.createCell(i++);
			cell.setCellValue("사회성");
			cell = row.createCell(i++);
			cell.setCellValue("조절");
			cell = row.createCell(i++);
			cell.setCellValue("어휘");
			cell = row.createCell(i++);
			cell.setCellValue("산수");
			cell = row.createCell(i++);
			cell.setCellValue("차례");
			cell = row.createCell(i++);
			cell.setCellValue("토막");
			cell = row.createCell(i++);
			cell.setCellValue("어휘");
			cell = row.createCell(i++);
			cell.setCellValue("산수");
			cell = row.createCell(i++);
			cell.setCellValue("차례");
			cell = row.createCell(i++);
			cell.setCellValue("토막");
			cell = row.createCell(i++);
			cell.setCellValue("공통성");
			cell = row.createCell(i++);
			cell.setCellValue("어휘");
			cell = row.createCell(i++);
			cell.setCellValue("이해");
			cell = row.createCell(i++);
			cell.setCellValue("토막");
			cell = row.createCell(i++);
			cell.setCellValue("공통그림");
			cell = row.createCell(i++);
			cell.setCellValue("행렬");
			cell = row.createCell(i++);
			cell.setCellValue("숫자");
			cell = row.createCell(i++);
			cell.setCellValue("순차연결");
			cell = row.createCell(i++);
			cell.setCellValue("기호");
			cell = row.createCell(i++);
			cell.setCellValue("동형");
			cell = row.createCell(i++);
			cell.setCellValue("공통성");
			cell = row.createCell(i++);
			cell.setCellValue("어휘");
			cell = row.createCell(i++);
			cell.setCellValue("이해");
			cell = row.createCell(i++);
			cell.setCellValue("토막");
			cell = row.createCell(i++);
			cell.setCellValue("공통그림");
			cell = row.createCell(i++);
			cell.setCellValue("행렬");
			cell = row.createCell(i++);
			cell.setCellValue("숫자");
			cell = row.createCell(i++);
			cell.setCellValue("순차연결");
			cell = row.createCell(i++);
			cell.setCellValue("기호");
			cell = row.createCell(i++);
			cell.setCellValue("동형");

			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("공통성\nSI");
			cell = row.createCell(i++);
			cell.setCellValue("어휘\nVC");
			cell = row.createCell(i++);
			cell.setCellValue("상식\nIN");
			cell = row.createCell(i++);
			cell.setCellValue("토막짜기\nBD");
			cell = row.createCell(i++);
			cell.setCellValue("행렬추론\nMR");
			cell = row.createCell(i++);
			cell.setCellValue("퍼즐\nVP");
			cell = row.createCell(i++);
			cell.setCellValue("숫자\nDS");
			cell = row.createCell(i++);
			cell.setCellValue("산수\nAR");
			cell = row.createCell(i++);
			cell.setCellValue("동형찾기\nSS");
			cell = row.createCell(i++);
			cell.setCellValue("기호쓰기\nCD");
			cell = row.createCell(i++);
			cell.setCellValue("공통성\nSI");
			cell = row.createCell(i++);
			cell.setCellValue("어휘\nVC");
			cell = row.createCell(i++);
			cell.setCellValue("상식\nIN");
			cell = row.createCell(i++);
			cell.setCellValue("토막짜기\nBD");
			cell = row.createCell(i++);
			cell.setCellValue("행렬추론\nMR");
			cell = row.createCell(i++);
			cell.setCellValue("퍼즐\nVP");
			cell = row.createCell(i++);
			cell.setCellValue("숫자\nDS");
			cell = row.createCell(i++);
			cell.setCellValue("산수\nAR");
			cell = row.createCell(i++);
			cell.setCellValue("동형찾기\nSS");
			cell = row.createCell(i++);
			cell.setCellValue("기호쓰기\nCD");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
			
			cell = row.createCell(i++);
			cell.setCellValue("언어이해");
			cell = row.createCell(i++);
			cell.setCellValue("지각추론");
			cell = row.createCell(i++);
			cell.setCellValue("작업기억");
			cell = row.createCell(i++);
			cell.setCellValue("처리속도");
			cell = row.createCell(i++);
			cell.setCellValue("전체IQ");
		}
	}

	@Override
	public void mapRow(Row row, NeuropsyS1VO vo) {
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

		//cell = row.createCell(i++);
		//cell.setCellValue(vo.getProtocol());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformCntNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getS1ExecDate());
		
		//cell = row.createCell(i++);
		//cell.setCellValue(vo.getEnrollAge());

	//	cell = row.createCell(i++);
	//	cell.setCellValue(vo.getS1ExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getFsiq());
	/////////////////////////////////////////////////////////////////////	
	
		//////////////////////////////////////////////////////////
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExctAllIntell());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExctShortIntell());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExctFluidInfer());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExctBasicVisual());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIcidAllIntell());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIcidShortIntell());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIcidFluidInfer());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getIcidBasicVisual());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getVifsForeBack());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getVifsShapeComp());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getVifsMatch());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getVifsOrderInfer());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getVifsPattFind());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getVifsDrawInfer());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getVifsCategoriz());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getViexcForeBack());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getViexcShapeComp());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getViexcMatch());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getViexcOrderInfer());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getViexcPattFind());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getViexcDrawInfer());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getViexcCategoriz());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCexcMemorySelect());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCexcRecogMemory());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCcompMemorySelect());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getCcompRecogMemory());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScPairAsso());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScImmedRecog());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScImmedRemember());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScSustainAtt());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScDelayRecog());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcPairAsso());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcImmedRecog());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcImmedRemember());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcSustainAtt());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcDelayRecog());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getpRsCompsc());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getpEcCompsc());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScAttention());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScActivLevel());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScImpuls());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScAdaptability());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScMoodConfid());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScFeelEmo());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScSociability());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getScControl());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcAttention());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcActivLevel());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcImpuls());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcAdaptability());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcMoodConfid());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcFeelEmo());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcSociability());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getExcControl());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisVocaOs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisArithOs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisOrderOs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisPieceOs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisVocaEs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisArithEs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisOrderEs());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKediwaisPieceEs());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivCos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivVos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivUos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivPos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivCpos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivMos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivNos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivScos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivSos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivStos());
	
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivCes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivVes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivUes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivPes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivCpes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivMes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivNes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivSces());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivSes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivStes());
	
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivEsadlu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivEsadpr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivEsadwr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivEsadps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivEsadalliq());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivIdxslu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivIdxspr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivIdxswr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivIdxsps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivIdxsalliq());
		
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivPercntlu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivPercntpr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivPercntwr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivPercntps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivPercntalliq());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivConfitvllu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivConfitvlpr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivConfitvlwr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivConfitvlps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivConfitvlalliq());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivQdlu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivQdpr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivQdwr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivQdps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivQdalliq());
		
		
		
		
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivSios());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivVcos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivInos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivBdos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivMros());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivVpos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivDsos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivAros());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivSsos());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivCdos());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivSies());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivVces());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivInes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivBdes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivMres());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivVpes());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivDses());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivAres());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivSses());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwiscivCdes());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Esadlu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Esadpr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Esadwr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Esadps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Esadalliq());
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Idxslu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Idxspr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Idxswr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Idxsps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Idxsalliq());
		
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Percntlu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Percntpr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Percntwr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Percntps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Percntalliq());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Confitvllu());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Confitvlpr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Confitvlwr());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Confitvlps());
		cell = row.createCell(i++);
		cell.setCellValue(vo.getKwisciv2Confitvlalliq());
		
	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 2));
	//	sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 1));
		//sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 2));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 2, 7, 7));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 61));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 8, 11));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 12, 15));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 16, 22));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 23, 29));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 30, 31));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 32, 33));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 34, 38));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 39, 43));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 44, 45)); 
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 46, 53));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 54, 61));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0 ,62, 69));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 62, 65));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 66, 69));
		
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 70, 114));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 70, 79));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 80, 89));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 90, 94));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 95, 99));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 100, 104));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 105, 109));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 110, 114));
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 115, 154));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 115, 124));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 125, 134));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 135, 139));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 140, 144));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 145, 149));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 150, 154));
	
		
		

		//enrollAge 추가 안한거
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 82));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 9, 16));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 17, 20));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 21, 22));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 24, 28));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 29, 30));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 31, 32));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 33, 36));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 37, 38));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 39, 44));
//		
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 45, 45));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 46, 46));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 47, 47));
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 48, 48));
//		
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 49, 52));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 53, 55));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 56, 60));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 61, 62));
//		
//		sheet.addMergedRegion(new CellRangeAddress(1, 2, 63, 63));
//		
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 64, 80));
//		
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 83, 136));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 83, 86));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 87, 90));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 91, 97));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 98, 104));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 105, 106));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 107, 108));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 109, 113));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 114, 118));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 119, 120));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 121, 128));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 129, 136));
//		
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 137, 144));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 137, 140));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 141, 144));
//		
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 145, 164));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 145, 154));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 155, 164));
//		
//		sheet.addMergedRegion(new CellRangeAddress(0, 0, 165, 184));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 165, 174));
//		sheet.addMergedRegion(new CellRangeAddress(1, 1, 175, 184));
	}

	
}
