package medical.survey.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.survey.service.SurveyPrdvVO;

public class SurveyPrdvWriterMapper implements CellWriterMapper<SurveyPrdvVO>{
	@Override
	public void mapHeader(Row row, SurveyPrdvVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("연구번호");
		
		cell = row.createCell(i++);
		cell.setCellValue("성별");
		
		cell = row.createCell(i++);
		cell.setCellValue("차수");

		cell = row.createCell(i++);
		cell.setCellValue("나이");

		cell = row.createCell(i++);
		cell.setCellValue("실시일");	
		
		cell = row.createCell(i++);
		cell.setCellValue("부모 및 가족 가정환경");	

		cell = row.createCell(25);
		cell.setCellValue("가족의 건강");	
		
		cell = row.createCell(80);
		cell.setCellValue("임신 관련 정보");	
		
		cell = row.createCell(140);
		cell.setCellValue("출산");	
		
		cell = row.createCell(168);
		cell.setCellValue("육아관련");	
		
		cell = row.createCell(206);
		cell.setCellValue("발달력");	
		
		cell = row.createCell(264);
		cell.setCellValue("아이의 건강");	
		
		cell = row.createCell(320);
		cell.setCellValue("학습 및 사회성");	
		
		cell = row.createCell(336);
		cell.setCellValue("사춘기여부");	
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell.setCellValue("조부");
			cell = row.createCell(i++);
			cell.setCellValue("조모");
			cell = row.createCell(i++);
			cell.setCellValue("외조부");
			cell = row.createCell(i++);
			cell.setCellValue("외조모");
			cell = row.createCell(i++);
			cell.setCellValue("부");
			cell = row.createCell(i++);
			cell.setCellValue("모");
			cell = row.createCell(i++);
			cell.setCellValue("그 외");
			cell = row.createCell(i++);
			cell.setCellValue("부학력");
			cell = row.createCell(i++);
			cell.setCellValue("모학력");
			cell = row.createCell(i++);
			cell.setCellValue("부종교");
			cell = row.createCell(i++);
			cell.setCellValue("모종교");
			cell = row.createCell(i++);
			cell.setCellValue("경제수준");
			cell = row.createCell(i++);
			cell.setCellValue("모손잡이");
			cell = row.createCell(i++);
			cell.setCellValue("부손잡이");
			cell = row.createCell(i++);
			cell.setCellValue("부출생연도");
			cell = row.createCell(i++);
			cell.setCellValue("부현재키");
			cell = row.createCell(i++);
			cell.setCellValue("모출생연도");
			cell = row.createCell(i++);
			cell.setCellValue("모현재키");
			cell = row.createCell(i++);
			cell.setCellValue("부직업");
			cell = row.createCell(i++);
			cell.setCellValue("모직업");
			cell = row.createCell(i++);
			cell.setCellValue("ADHD");						//2 가족의 건강
			cell = row.createCell(i++);
			cell.setCellValue("학습장애");
			cell = row.createCell(i++);
			cell.setCellValue("언어");
			cell = row.createCell(i++);
			cell.setCellValue("정신지체");
			cell = row.createCell(i++);
			cell.setCellValue("OCD");
			cell = row.createCell(i++);
			cell.setCellValue("지나친걱정");
			cell = row.createCell(i++);
			cell.setCellValue("틱");
			cell = row.createCell(i++);
			cell.setCellValue("정신병");
			cell = row.createCell(i++);
			cell.setCellValue("우울증");
			cell = row.createCell(i++);
			cell.setCellValue("불안증");
			cell = row.createCell(i++);
			cell.setCellValue("공황장애");
			cell = row.createCell(i++);
			cell.setCellValue("자살");
			cell = row.createCell(i++);
			cell.setCellValue("알콜중독");
			cell = row.createCell(i++);
			cell.setCellValue("야노증");
			cell = row.createCell(i++);
			cell.setCellValue("자폐증");
			cell = row.createCell(i++);
			cell.setCellValue("행동장애");
			cell = row.createCell(i++);
			cell.setCellValue("도둑질 등");
			cell = row.createCell(i++);
			cell.setCellValue("법적문제");
			cell = row.createCell(i++);
			cell.setCellValue("감옥");
			cell = row.createCell(i++);
			cell.setCellValue("조울증");
			cell = row.createCell(i++);
			cell.setCellValue("기타");
			cell = row.createCell(i++);
			cell.setCellValue("누가(1)");
			cell = row.createCell(i++);
			cell.setCellValue("자세히(1)");
			cell = row.createCell(i++);
			cell.setCellValue("누가(2)");
			cell = row.createCell(i++);
			cell.setCellValue("자세히(2)");
			cell = row.createCell(i++);
			cell.setCellValue("누가(3)");
			cell = row.createCell(i++);
			cell.setCellValue("자세히(3)");
			cell = row.createCell(i++);
			cell.setCellValue("누가(4)");
			cell = row.createCell(i++);
			cell.setCellValue("자세히(4)");
			cell = row.createCell(i++);
			cell.setCellValue("(부)복용 약물명");
			cell = row.createCell(i++);
			cell.setCellValue("복용량");
			cell = row.createCell(i++);
			cell.setCellValue("복용기간");
			cell = row.createCell(i++);
			cell.setCellValue("(모)복용 약물명");
			cell = row.createCell(i++);
			cell.setCellValue("복용량");
			cell = row.createCell(i++);
			cell.setCellValue("복용기간");
			cell = row.createCell(i++);
			cell.setCellValue("(부)흡연여부");
			cell = row.createCell(i++);
			cell.setCellValue("시작연도");
			cell = row.createCell(i++);
			cell.setCellValue("끊은연도");
			cell = row.createCell(i++);
			cell.setCellValue("흡연량");
			cell = row.createCell(i++);
			cell.setCellValue("(모)흡연여부");
			cell = row.createCell(i++);
			cell.setCellValue("시작연도");
			cell = row.createCell(i++);
			cell.setCellValue("끊은연도");
			cell = row.createCell(i++);
			cell.setCellValue("흡연량");
			cell = row.createCell(i++);
			cell.setCellValue("(부)음주여부");
			cell = row.createCell(i++);
			cell.setCellValue("시작연도");
			cell = row.createCell(i++);
			cell.setCellValue("끊은연도");
			cell = row.createCell(i++);
			cell.setCellValue("마시는 횟수");
			cell = row.createCell(i++);
			cell.setCellValue("주종");
			cell = row.createCell(i++);
			cell.setCellValue("양");
			cell = row.createCell(i++);
			cell.setCellValue("(모)음주여부");
			cell = row.createCell(i++);
			cell.setCellValue("시작연도");
			cell = row.createCell(i++);
			cell.setCellValue("끊은연도");
			cell = row.createCell(i++);
			cell.setCellValue("마시는 횟수");
			cell = row.createCell(i++);
			cell.setCellValue("주종");
			cell = row.createCell(i++);
			cell.setCellValue("양");
			cell = row.createCell(i++);
			cell.setCellValue("기분");            //3
			cell = row.createCell(i++);
			cell.setCellValue("의학적도움 여부");
			cell = row.createCell(i++);
			cell.setCellValue("사전임신");
			cell = row.createCell(i++);
			cell.setCellValue("사전출산");
			cell = row.createCell(i++);
			cell.setCellValue("사전유산");
			cell = row.createCell(i++);
			cell.setCellValue("유산개월");
			cell = row.createCell(i++);
			cell.setCellValue("사전 낙태");
			cell = row.createCell(i++);
			cell.setCellValue("사전 사산");
			cell = row.createCell(i++);
			cell.setCellValue("피임방법");
			cell = row.createCell(i++);
			cell.setCellValue("계획임신");
			cell = row.createCell(i++);
			cell.setCellValue("원하던임신");
			cell = row.createCell(i++);
			cell.setCellValue("(모)나이");
			cell = row.createCell(i++);
			cell.setCellValue("(부)나이");
			cell = row.createCell(i++);
			cell.setCellValue("산전검진");
			cell = row.createCell(i++);
			cell.setCellValue("간격");
			cell = row.createCell(i++);
			cell.setCellValue("입덧");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("오심");
			cell = row.createCell(i++);
			cell.setCellValue("구토");
			cell = row.createCell(i++);
			cell.setCellValue("체중감소");
			cell = row.createCell(i++);
			cell.setCellValue("기타");
			cell = row.createCell(i++);
			cell.setCellValue("스트레스 여부");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("술");
			cell = row.createCell(i++);
			cell.setCellValue("담배");
			cell = row.createCell(i++);
			cell.setCellValue("커피");
			cell = row.createCell(i++);
			cell.setCellValue("한약");
			cell = row.createCell(i++);
			cell.setCellValue("다른약물");
			cell = row.createCell(i++);
			cell.setCellValue("기타");
			cell = row.createCell(i++);
			cell.setCellValue("언제(1)");
			cell = row.createCell(i++);
			cell.setCellValue("기간(1)");
			cell = row.createCell(i++);
			cell.setCellValue("양(1)");
			cell = row.createCell(i++);
			cell.setCellValue("언제(2)");
			cell = row.createCell(i++);
			cell.setCellValue("기간(2)");
			cell = row.createCell(i++);
			cell.setCellValue("양(2)");
			cell = row.createCell(i++);
			cell.setCellValue("질환명");
			cell = row.createCell(i++);
			cell.setCellValue("약물이름");
			cell = row.createCell(i++);
			cell.setCellValue("용량");
			cell = row.createCell(i++);
			cell.setCellValue("복용기간");
			cell = row.createCell(i++);
			cell.setCellValue("입덧");
			cell = row.createCell(i++);
			cell.setCellValue("통증");
			cell = row.createCell(i++);
			cell.setCellValue("고혈압");
			cell = row.createCell(i++);
			cell.setCellValue("유산방지");
			cell = row.createCell(i++);
			cell.setCellValue("체중증가");
			cell = row.createCell(i++);
			cell.setCellValue("건강위해");
			cell = row.createCell(i++);
			cell.setCellValue("산전비타민");
			cell = row.createCell(i++);
			cell.setCellValue("기타");
			cell = row.createCell(i++);
			cell.setCellValue("태아위치");
			cell = row.createCell(i++);
			cell.setCellValue("양수터짐");
			cell = row.createCell(i++);
			cell.setCellValue("하혈");
			cell = row.createCell(i++);
			cell.setCellValue("피비침");
			cell = row.createCell(i++);
			cell.setCellValue("풍진");
			cell = row.createCell(i++);
			cell.setCellValue("임신중독증");
			cell = row.createCell(i++);
			cell.setCellValue("경련");
			cell = row.createCell(i++);
			cell.setCellValue("정신적문제");
			cell = row.createCell(i++);
			cell.setCellValue("가정문제");
			cell = row.createCell(i++);
			cell.setCellValue("사고부상");
			cell = row.createCell(i++);
			cell.setCellValue("변비 등");
			cell = row.createCell(i++);
			cell.setCellValue("심리적스트레스");
			cell = row.createCell(i++);
			cell.setCellValue("스트레스 정도");
			cell = row.createCell(i++);						
			cell.setCellValue("출산 달");			//4 출산
			cell = row.createCell(i++);
			cell.setCellValue("주수");
			cell = row.createCell(i++);
			cell.setCellValue("진통후 분만 시간");
			cell = row.createCell(i++);
			cell.setCellValue("양수터진 후 출산시간");
			cell = row.createCell(i++);
			cell.setCellValue("출산방식");
			cell = row.createCell(i++);
			cell.setCellValue("관장여부");
			cell = row.createCell(i++);
			cell.setCellValue("쌍둥이여부");
			cell = row.createCell(i++);
			cell.setCellValue("마취여부");
			cell = row.createCell(i++);
			cell.setCellValue("전신/부분");
			cell = row.createCell(i++);
			cell.setCellValue("제왕절개 계획여부");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("난산");
			cell = row.createCell(i++);
			cell.setCellValue("심폐이상");
			cell = row.createCell(i++);
			cell.setCellValue("탯줄감김");
			cell = row.createCell(i++);
			cell.setCellValue("호흡곤란");
			cell = row.createCell(i++);
			cell.setCellValue("태반문제");
			cell = row.createCell(i++);
			cell.setCellValue("탯줄문제");
			cell = row.createCell(i++);
			cell.setCellValue("기타건강");
			cell = row.createCell(i++);
			cell.setCellValue("체중");
			cell = row.createCell(i++);
			cell.setCellValue("머리둘레");
			cell = row.createCell(i++);
			cell.setCellValue("인큐베이터 여부");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("신체적 문제여부");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("모의 우울기분");
			cell = row.createCell(i++);
			cell.setCellValue("정도");
			cell = row.createCell(i++);
			cell.setCellValue("출산 후 입원여부");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("ㄱ-1");					//5 육아관련
			cell = row.createCell(i++);
			cell.setCellValue("ㄱ-2");
			cell = row.createCell(i++);
			cell.setCellValue("ㄱ-3");
			cell = row.createCell(i++);
			cell.setCellValue("ㄱ-4");
			cell = row.createCell(i++);
			cell.setCellValue("ㄱ-5");
			cell = row.createCell(i++);
			cell.setCellValue("ㄱ-6");
			cell = row.createCell(i++);
			cell.setCellValue("ㄱ합계");
			cell = row.createCell(i++);
			cell.setCellValue("ㄴ-1");
			cell = row.createCell(i++);
			cell.setCellValue("ㄴ-2");
			cell = row.createCell(i++);
			cell.setCellValue("ㄴ-3");
			cell = row.createCell(i++);
			cell.setCellValue("ㄴ-4");
			cell = row.createCell(i++);
			cell.setCellValue("ㄴ합계");
			cell = row.createCell(i++);
			cell.setCellValue("ㄷ-1");
			cell = row.createCell(i++);
			cell.setCellValue("ㄷ-2");
			cell = row.createCell(i++);
			cell.setCellValue("ㄷ-3");
			cell = row.createCell(i++);
			cell.setCellValue("ㄷ합계");
			cell = row.createCell(i++);
			cell.setCellValue("ㄹ-1");
			cell = row.createCell(i++);
			cell.setCellValue("ㄹ-2");
			cell = row.createCell(i++);
			cell.setCellValue("ㄹ-3");
			cell = row.createCell(i++);
			cell.setCellValue("ㄹ합계");
			cell = row.createCell(i++);
			cell.setCellValue("ㅁ-1");
			cell = row.createCell(i++);
			cell.setCellValue("ㅁ-2");
			cell = row.createCell(i++);
			cell.setCellValue("ㅁ-3");
			cell = row.createCell(i++);
			cell.setCellValue("ㅁ-4");
			cell = row.createCell(i++);
			cell.setCellValue("ㅁ-5");
			cell = row.createCell(i++);
			cell.setCellValue("ㅁ합계");
			cell = row.createCell(i++);
			cell.setCellValue("ㅂ-1");
			cell = row.createCell(i++);
			cell.setCellValue("ㅂ-2");
			cell = row.createCell(i++);
			cell.setCellValue("ㅂ-3");
			cell = row.createCell(i++);
			cell.setCellValue("ㅂ-4");
			cell = row.createCell(i++);
			cell.setCellValue("ㅂ-5");
			cell = row.createCell(i++);
			cell.setCellValue("ㅂ합계");
			cell = row.createCell(i++);
			cell.setCellValue("ㅅ-1");
			cell = row.createCell(i++);
			cell.setCellValue("ㅅ-2");
			cell = row.createCell(i++);
			cell.setCellValue("ㅅ-3");
			cell = row.createCell(i++);
			cell.setCellValue("ㅅ-4");
			cell = row.createCell(i++);
			cell.setCellValue("ㅅ-5");
			cell = row.createCell(i++);
			cell.setCellValue("ㅅ합계");
			cell = row.createCell(i++);				
			cell.setCellValue("손잡이");			//6 발달력
			cell = row.createCell(i++);
			cell.setCellValue("주양육자");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("양육자변화");
			cell = row.createCell(i++);
			cell.setCellValue("횟수");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("유년기 사는 장소");
			cell = row.createCell(i++);
			cell.setCellValue("1");
			cell = row.createCell(i++);
			cell.setCellValue("2");
			cell = row.createCell(i++);
			cell.setCellValue("3");
			cell = row.createCell(i++);
			cell.setCellValue("4");
			cell = row.createCell(i++);
			cell.setCellValue("5");
			cell = row.createCell(i++);
			cell.setCellValue("6");
			cell = row.createCell(i++);
			cell.setCellValue("7");
			cell = row.createCell(i++);
			cell.setCellValue("8");
			cell = row.createCell(i++);
			cell.setCellValue("9");
			cell = row.createCell(i++);
			cell.setCellValue("10");
			cell = row.createCell(i++);
			cell.setCellValue("11");
			cell = row.createCell(i++);
			cell.setCellValue("12");
			cell = row.createCell(i++);
			cell.setCellValue("13");
			cell = row.createCell(i++);
			cell.setCellValue("14");
			cell = row.createCell(i++);
			cell.setCellValue("낮가림");
			cell = row.createCell(i++);
			cell.setCellValue("목가누기 등");
			cell = row.createCell(i++);
			cell.setCellValue("옹알이");
			cell = row.createCell(i++);
			cell.setCellValue("문장 말하기");
			cell = row.createCell(i++);
			cell.setCellValue("대소변 가리기");
			cell = row.createCell(i++);
			cell.setCellValue("야뇨증");
			cell = row.createCell(i++);
			cell.setCellValue("(야노증)나이");
			cell = row.createCell(i++);
			cell.setCellValue("분리불안");
			cell = row.createCell(i++);
			cell.setCellValue("또래관계");
			cell = row.createCell(i++);
			cell.setCellValue("(예)라면 시기");
			cell = row.createCell(i++);
			cell.setCellValue("학업성취");
			cell = row.createCell(i++);
			cell.setCellValue("학교적응정도");
			cell = row.createCell(i++);
			cell.setCellValue("상담받은적");
			cell = row.createCell(i++);
			cell.setCellValue("1");
			cell = row.createCell(i++);
			cell.setCellValue("2");
			cell = row.createCell(i++);
			cell.setCellValue("3");
			cell = row.createCell(i++);
			cell.setCellValue("4");
			cell = row.createCell(i++);
			cell.setCellValue("5");
			cell = row.createCell(i++);
			cell.setCellValue("6");
			cell = row.createCell(i++);
			cell.setCellValue("7");
			cell = row.createCell(i++);
			cell.setCellValue("8");
			cell = row.createCell(i++);
			cell.setCellValue("9");
			cell = row.createCell(i++);
			cell.setCellValue("10");
			cell = row.createCell(i++);
			cell.setCellValue("11");
			cell = row.createCell(i++);
			cell.setCellValue("12");
			cell = row.createCell(i++);
			cell.setCellValue("1");
			cell = row.createCell(i++);
			cell.setCellValue("2");
			cell = row.createCell(i++);
			cell.setCellValue("3");
			cell = row.createCell(i++);
			cell.setCellValue("4");
			cell = row.createCell(i++);
			cell.setCellValue("5");
			cell = row.createCell(i++);
			cell.setCellValue("6");
			cell = row.createCell(i++);
			cell.setCellValue("7");
			cell = row.createCell(i++);
			cell.setCellValue("8");
			cell = row.createCell(i++);
			cell.setCellValue("9");
			cell = row.createCell(i++);
			cell.setCellValue("10");
			cell = row.createCell(i++);
			cell.setCellValue("11");
			cell = row.createCell(i++);
			cell.setCellValue("12");
			cell = row.createCell(i++);
			cell.setCellValue("입원, 수술여부");			//7 아이의 건강
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("현재건강");
			cell = row.createCell(i++);
			cell.setCellValue("외상여부");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("돌 이전 설사");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("돌 이전 고열 횟수");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("돌 이전 항생제 치료");
			cell = row.createCell(i++);
			cell.setCellValue("돌 이전 두드러기");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("돌 이전 전신마취");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("머리 다친적");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("뇌성마비");
			cell = row.createCell(i++);
			cell.setCellValue("자폐증");
			cell = row.createCell(i++);
			cell.setCellValue("언어장애");
			cell = row.createCell(i++);
			cell.setCellValue("정신지체");
			cell = row.createCell(i++);
			cell.setCellValue("학습장애");
			cell = row.createCell(i++);
			cell.setCellValue("ADHD");
			cell = row.createCell(i++);
			cell.setCellValue("불안증");
			cell = row.createCell(i++);
			cell.setCellValue("우울증");
			cell = row.createCell(i++);
			cell.setCellValue("천식");
			cell = row.createCell(i++);
			cell.setCellValue("아토피");
			cell = row.createCell(i++);
			cell.setCellValue("알레르기 비염");
			cell = row.createCell(i++);
			cell.setCellValue("외상성 뇌손상");
			cell = row.createCell(i++);
			cell.setCellValue("기타 뇌신경질환");
			cell = row.createCell(i++);
			cell.setCellValue("기타 신체질환");
			cell = row.createCell(i++);
			cell.setCellValue("나이");
			cell = row.createCell(i++);
			cell.setCellValue("내용");
			cell = row.createCell(i++);
			cell.setCellValue("나이(2)");
			cell = row.createCell(i++);
			cell.setCellValue("내용(2)");
			cell = row.createCell(i++);
			cell.setCellValue("나이(3)");
			cell = row.createCell(i++);
			cell.setCellValue("내용(3)");
			cell = row.createCell(i++);
			cell.setCellValue("나이(4)");
			cell = row.createCell(i++);
			cell.setCellValue("내용(4)");
			cell = row.createCell(i++);
			cell.setCellValue("나이(5)");
			cell = row.createCell(i++);
			cell.setCellValue("내용(5)");
			cell = row.createCell(i++);
			cell.setCellValue("예방접종");
			cell = row.createCell(i++);
			cell.setCellValue("정서행동문제로 상담소 방문");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("motor틱");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("음성틱");
			cell = row.createCell(i++);
			cell.setCellValue("시기");
			cell = row.createCell(i++);
			cell.setCellValue("이유");
			cell = row.createCell(i++);
			cell.setCellValue("놀이방/유치원 시작연령");				//8 학습 및 사회성
			cell = row.createCell(i++);
			cell.setCellValue("분리불안");
			cell = row.createCell(i++);
			cell.setCellValue("또래사귐");
			cell = row.createCell(i++);
			cell.setCellValue("평가");
			cell = row.createCell(i++);
			cell.setCellValue("학습문제");
			cell = row.createCell(i++);
			cell.setCellValue("발달지연");
			cell = row.createCell(i++);
			cell.setCellValue("특수교육수업");
			cell = row.createCell(i++);
			cell.setCellValue("언어치료");
			cell = row.createCell(i++);
			cell.setCellValue("정서행동문제");
			cell = row.createCell(i++);
			cell.setCellValue("결석일");
			cell = row.createCell(i++);
			cell.setCellValue("(평일)컴퓨터게임시간");
			cell = row.createCell(i++);
			cell.setCellValue("(평일)집밖에서 노는시간");
			cell = row.createCell(i++);
			cell.setCellValue("(주말)밖에서 노는시간");
			cell = row.createCell(i++);
			cell.setCellValue("식사속도");
			cell = row.createCell(i++);
			cell.setCellValue("움직이는 놀이 횟수");
			cell = row.createCell(i++);
			cell.setCellValue("매회 놀이시간");
			cell = row.createCell(i++);
			cell.setCellValue("사춘기여부");
			cell = row.createCell(i++);
			cell.setCellValue("음모여부");
			cell = row.createCell(i++);
			cell.setCellValue("(남아)변성");
			cell = row.createCell(i++);
			cell.setCellValue("(남아)수염");
			cell = row.createCell(i++);
			cell.setCellValue("(여아)젖몽우리");
			cell = row.createCell(i++);
			cell.setCellValue("시작나이");
			cell = row.createCell(i++);
			cell.setCellValue("(여아)초경");
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyPrdvVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPrdvExecDate());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA16());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA17());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA18());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA19());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getA20());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB16());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB17());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB18());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB19());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB20());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB21());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB22());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB23());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB24());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB25());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB26());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB27());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB28());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB29());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB30());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB31());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB32());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB33());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB34());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB35());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB36());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB37());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB38());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB39());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB40());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB41());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB42());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB43());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB44());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB45());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB46());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB47());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getB48());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB49());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB50());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB51());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB52());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB53());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB54());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getB55());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getC1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC16());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC17());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC18());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC19());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC20());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC21());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC22());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC23());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC24());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC25());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC26());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC27());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC28());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC29());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC30());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC31());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC32());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC33());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC34());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC35());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC36());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC37());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC38());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC39());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC40());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC41());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC42());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC43());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC44());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC45());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC46());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC47());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC48());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC49());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC50());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC51());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC52());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC53());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getC54());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getC55());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getC56());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getC57());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getC58());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getC59());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getC60());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getD1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD16());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD17());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD18());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD19());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD20());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD21());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD22());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD23());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD24());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD25());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD26());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getD27());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getD28());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getE1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE16());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE17());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE18());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE19());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE20());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE21());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE22());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE23());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE24());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE25());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE26());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE27());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE28());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE29());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE30());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE31());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE32());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE33());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE34());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE35());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE36());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE37());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getE38());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getF1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF16());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF17());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF18());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF19());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF20());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF21());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF22());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF23());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF24());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF25());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF26());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF27());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF28());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF29());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF30());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF31());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF32());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF33());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF34());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF35());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF36());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF37());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF38());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF39());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF40());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF41());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF42());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF43());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF44());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF45());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF46());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF47());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF48());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF49());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF50());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF51());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF52());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF53());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF54());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF55());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF56());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF57());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getF58());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getG1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG16());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG17());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG18());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG19());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG20());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG21());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG22());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG23());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG24());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG25());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG26());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG27());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG28());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG29());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG30());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG31());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG32());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG33());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG34());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG35());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG36());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG37());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG38());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG39());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG40());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG41());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG42());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG43());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG44());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG45());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG46());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG47());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG48());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG49());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG50());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG51());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG52());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG53());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG54());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG55());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getG56());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH7());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH8());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH9());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH10());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH11());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH12());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH13());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH14());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH15());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getH16());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getI1());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getI2());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getI3());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getI4());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getI5());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getI6());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getI7());

	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 1, 1));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 5, 24)); 		//a
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 25, 79)); 		//b
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 80, 139)); 	//c 
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 140, 167)); 	//d
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 168, 205)); 	//e
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 206, 263)); 	//f
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 264, 319)); 	//g
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 320, 335)); 	//h
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 336, 342)); 	//i
	}
}
