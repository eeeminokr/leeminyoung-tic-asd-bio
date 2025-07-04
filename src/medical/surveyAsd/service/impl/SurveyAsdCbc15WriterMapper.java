package medical.surveyAsd.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.surveyAsd.service.SurveyAsdCbc15VO;


public class SurveyAsdCbc15WriterMapper implements CellWriterMapper<SurveyAsdCbc15VO>{
	@Override
	public void mapHeader(Row row, SurveyAsdCbc15VO vo) {
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
			cell.setCellValue("차수");

			cell = row.createCell(5);
			cell.setCellValue("나이");

			cell = row.createCell(6);
			cell.setCellValue("실시일");	
			
			cell = row.createCell(7);
			cell.setCellValue("문제행동증후군 척도 T");	
			
			cell = row.createCell(18);
			cell.setCellValue("문제행동증후군 척도 백분위");	
			
			cell = row.createCell(29);
			cell.setCellValue("문제행동증후군 척도 원점수");	
			
			cell = row.createCell(40);
			cell.setCellValue("DSM 진단척도 T");	
			
			cell = row.createCell(45);
			cell.setCellValue("DSM 진단척도 백분위");
			
			cell = row.createCell(50);
			cell.setCellValue("DSM 진단척도 원점수");	
			
			cell = row.createCell(55);
			cell.setCellValue("CBCL 1.5-5");	
			cell = row.createCell(157);
		}
		if(rowNum==1) {
			
			cell = row.createCell(i++);
			
			cell = row.createCell(i++);
			cell.setCellValue("뇌원천 연구번호");
			
			cell = row.createCell(i++);
			cell.setCellValue("뇌질환 연구번호");
			
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			

			cell.setCellValue("문제행동총점");
			cell = row.createCell(i++);
			cell.setCellValue("내재화");
			cell = row.createCell(i++);
			cell.setCellValue("외현화");
			cell = row.createCell(i++);
			cell.setCellValue("정서적반응성");
			cell = row.createCell(i++);
			cell.setCellValue("불안/우울");
			cell = row.createCell(i++);
			cell.setCellValue("신체증상");
			cell = row.createCell(i++);
			cell.setCellValue("위축");
			cell = row.createCell(i++);
			cell.setCellValue("수면문제");
			cell = row.createCell(i++);
			cell.setCellValue("주의집중문제");
			cell = row.createCell(i++);
			cell.setCellValue("공격행동");
			cell = row.createCell(i++);
			cell.setCellValue("기타문제");
			
			
			cell = row.createCell(i++);
			

			cell.setCellValue("문제행동총점");
			cell = row.createCell(i++);
			cell.setCellValue("내재화");
			cell = row.createCell(i++);
			cell.setCellValue("외현화");
			cell = row.createCell(i++);
			cell.setCellValue("정서적반응성");
			cell = row.createCell(i++);
			cell.setCellValue("불안/우울");
			cell = row.createCell(i++);
			cell.setCellValue("신체증상");
			cell = row.createCell(i++);
			cell.setCellValue("위축");
			cell = row.createCell(i++);
			cell.setCellValue("수면문제");
			cell = row.createCell(i++);
			cell.setCellValue("주의집중문제");
			cell = row.createCell(i++);
			cell.setCellValue("공격행동");
			cell = row.createCell(i++);
			cell.setCellValue("기타문제");
			
			cell = row.createCell(i++);
			

			cell.setCellValue("문제행동총점");
			cell = row.createCell(i++);
			cell.setCellValue("내재화");
			cell = row.createCell(i++);
			cell.setCellValue("외현화");
			cell = row.createCell(i++);
			cell.setCellValue("정서적반응성");
			cell = row.createCell(i++);
			cell.setCellValue("불안/우울");
			cell = row.createCell(i++);
			cell.setCellValue("신체증상");
			cell = row.createCell(i++);
			cell.setCellValue("위축");
			cell = row.createCell(i++);
			cell.setCellValue("수면문제");
			cell = row.createCell(i++);
			cell.setCellValue("주의집중문제");
			cell = row.createCell(i++);
			cell.setCellValue("공격행동");
			cell = row.createCell(i++);
			cell.setCellValue("기타문제");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("정서문제");
			cell = row.createCell(i++);
			cell.setCellValue("불안문제");
			cell = row.createCell(i++);
			cell.setCellValue("전반적발달문제");
			cell = row.createCell(i++);
			cell.setCellValue("ADHD");
			cell = row.createCell(i++);
			cell.setCellValue("반항행동문제");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("정서문제");
			cell = row.createCell(i++);
			cell.setCellValue("불안문제");
			cell = row.createCell(i++);
			cell.setCellValue("전반적발달문제");
			cell = row.createCell(i++);
			cell.setCellValue("ADHD");
			cell = row.createCell(i++);
			cell.setCellValue("반항행동문제");
			
			
			cell = row.createCell(i++);
			cell.setCellValue("정서문제");
			cell = row.createCell(i++);
			cell.setCellValue("불안문제");
			cell = row.createCell(i++);
			cell.setCellValue("전반적발달문제");
			cell = row.createCell(i++);
			cell.setCellValue("ADHD");
			cell = row.createCell(i++);
			cell.setCellValue("반항행동문제");
			
			cell = row.createCell(i++);
			cell.setCellValue("1");cell = row.createCell(i++);
			cell.setCellValue("2");cell = row.createCell(i++);
			cell.setCellValue("3");cell = row.createCell(i++);
			cell.setCellValue("4");cell = row.createCell(i++);
			cell.setCellValue("5");cell = row.createCell(i++);
			cell.setCellValue("6");cell = row.createCell(i++);
			cell.setCellValue("7");cell = row.createCell(i++);
			cell.setCellValue("8");cell = row.createCell(i++);
			cell.setCellValue("9");cell = row.createCell(i++);
			cell.setCellValue("10");cell = row.createCell(i++);
			cell.setCellValue("11");cell = row.createCell(i++);
			cell.setCellValue("12");cell = row.createCell(i++);
			cell.setCellValue("13");cell = row.createCell(i++);
			cell.setCellValue("14");cell = row.createCell(i++);
			cell.setCellValue("15");cell = row.createCell(i++);
			cell.setCellValue("16");cell = row.createCell(i++);
			cell.setCellValue("17");cell = row.createCell(i++);
			cell.setCellValue("18");cell = row.createCell(i++);
			cell.setCellValue("19");cell = row.createCell(i++);
			cell.setCellValue("20");cell = row.createCell(i++);
			cell.setCellValue("21");cell = row.createCell(i++);
			cell.setCellValue("22");cell = row.createCell(i++);
			cell.setCellValue("23");cell = row.createCell(i++);
			cell.setCellValue("24");cell = row.createCell(i++);
			cell.setCellValue("25");cell = row.createCell(i++);
			cell.setCellValue("26");cell = row.createCell(i++);
			cell.setCellValue("27");cell = row.createCell(i++);
			cell.setCellValue("28");cell = row.createCell(i++);
			cell.setCellValue("29");cell = row.createCell(i++);
			cell.setCellValue("30");cell = row.createCell(i++);
			cell.setCellValue("31");cell = row.createCell(i++);
			cell.setCellValue("32");cell = row.createCell(i++);
			cell.setCellValue("33");cell = row.createCell(i++);
			cell.setCellValue("34");cell = row.createCell(i++);
			cell.setCellValue("35");cell = row.createCell(i++);
			cell.setCellValue("36");cell = row.createCell(i++);
			cell.setCellValue("37");cell = row.createCell(i++);
			cell.setCellValue("38");cell = row.createCell(i++);
			cell.setCellValue("39");cell = row.createCell(i++);
			cell.setCellValue("40");cell = row.createCell(i++);
			cell.setCellValue("41");cell = row.createCell(i++);
			cell.setCellValue("42");cell = row.createCell(i++);
			cell.setCellValue("43");cell = row.createCell(i++);
			cell.setCellValue("44");cell = row.createCell(i++);
			cell.setCellValue("45");cell = row.createCell(i++);
			cell.setCellValue("46");cell = row.createCell(i++);
			cell.setCellValue("47");cell = row.createCell(i++);
			cell.setCellValue("48");cell = row.createCell(i++);
			cell.setCellValue("49");cell = row.createCell(i++);
			cell.setCellValue("50");cell = row.createCell(i++);
			cell.setCellValue("51");cell = row.createCell(i++);
			cell.setCellValue("52");cell = row.createCell(i++);
			cell.setCellValue("53");cell = row.createCell(i++);
			cell.setCellValue("54");cell = row.createCell(i++);
			cell.setCellValue("55");cell = row.createCell(i++);
			cell.setCellValue("56");cell = row.createCell(i++);
			cell.setCellValue("57");cell = row.createCell(i++);
			cell.setCellValue("58");cell = row.createCell(i++);
			cell.setCellValue("59");cell = row.createCell(i++);
			cell.setCellValue("60");cell = row.createCell(i++);
			cell.setCellValue("61");cell = row.createCell(i++);
			cell.setCellValue("62");cell = row.createCell(i++);
			cell.setCellValue("63");cell = row.createCell(i++);
			cell.setCellValue("64");cell = row.createCell(i++);
			cell.setCellValue("65");cell = row.createCell(i++);
			cell.setCellValue("66");cell = row.createCell(i++);
			cell.setCellValue("67");cell = row.createCell(i++);
			cell.setCellValue("68");cell = row.createCell(i++);
			cell.setCellValue("69");cell = row.createCell(i++);
			cell.setCellValue("70");cell = row.createCell(i++);
			cell.setCellValue("71");cell = row.createCell(i++);
			cell.setCellValue("72");cell = row.createCell(i++);
			cell.setCellValue("73");cell = row.createCell(i++);
			cell.setCellValue("74");cell = row.createCell(i++);
			cell.setCellValue("75");cell = row.createCell(i++);
			cell.setCellValue("76");cell = row.createCell(i++);
			cell.setCellValue("77");cell = row.createCell(i++);
			cell.setCellValue("78");cell = row.createCell(i++);
			cell.setCellValue("79");cell = row.createCell(i++);
			cell.setCellValue("80");cell = row.createCell(i++);
			cell.setCellValue("81");cell = row.createCell(i++);
			cell.setCellValue("82");cell = row.createCell(i++);
			cell.setCellValue("83");cell = row.createCell(i++);
			cell.setCellValue("84");cell = row.createCell(i++);
			cell.setCellValue("85");cell = row.createCell(i++);
			cell.setCellValue("86");cell = row.createCell(i++);
			cell.setCellValue("87");cell = row.createCell(i++);
			cell.setCellValue("88");cell = row.createCell(i++);
			cell.setCellValue("89");cell = row.createCell(i++);
			cell.setCellValue("90");cell = row.createCell(i++);
			cell.setCellValue("91");cell = row.createCell(i++);
			cell.setCellValue("92");cell = row.createCell(i++);
			cell.setCellValue("93");cell = row.createCell(i++);
			cell.setCellValue("94");cell = row.createCell(i++);
			cell.setCellValue("95");cell = row.createCell(i++);
			cell.setCellValue("96");cell = row.createCell(i++);
			cell.setCellValue("97");cell = row.createCell(i++);
			cell.setCellValue("98");cell = row.createCell(i++);
			cell.setCellValue("99");cell = row.createCell(i++);
			cell.setCellValue("100");cell = row.createCell(i++);
			cell.setCellValue("기타 1");cell = row.createCell(i++);
			cell.setCellValue("기타 2");cell = row.createCell(i++);
			cell.setCellValue("기타 3");
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyAsdCbc15VO vo) {
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
		cell.setCellValue(vo.getPerformNm());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getCbc15ExecDate());

		
		
		
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTts1());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTin2());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTout3());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTemoRact4());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSdeLow5());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTps6());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTshr7());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTsp8());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTafp9());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTatp10());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsTetc11());cell = row.createCell(i++);
	
		cell.setCellValue(vo.getcPcsPcntts1());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntin2());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntout3());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntemoRact4());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntdeLow5());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntps6());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntshr7());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntsp8());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntafp9());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntatp10());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsPcntetc11());cell = row.createCell(i++);
		
		
		cell.setCellValue(vo.getcPcsSts1());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSin2());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSout3());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSemoRact4());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSdeLow5());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSps6());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSshr7());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSsp8());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSafp9());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSatp10());cell = row.createCell(i++);
		cell.setCellValue(vo.getcPcsSetc11());cell = row.createCell(i++);
		
		
		cell.setCellValue(vo.getcDsmTemop1());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmTdep2());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmTdevlp3());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmTadhd4());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmToppbhv5());cell = row.createCell(i++);
		
		cell.setCellValue(vo.getcDsmPcntemop1());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmPcntdep2());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmPcntdevlp3());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmPcntadhd4());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmPcntoppbhv5());cell = row.createCell(i++);
		
		cell.setCellValue(vo.getcDsmSemop1());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmSdep2());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmSdevlp3());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmSadhd4());cell = row.createCell(i++);
		cell.setCellValue(vo.getcDsmSoppbhv5());cell = row.createCell(i++);
		
		
		cell.setCellValue(vo.getA1());cell = row.createCell(i++);
		cell.setCellValue(vo.getA2());cell = row.createCell(i++);
		cell.setCellValue(vo.getA3());cell = row.createCell(i++);
		cell.setCellValue(vo.getA4());cell = row.createCell(i++);
		cell.setCellValue(vo.getA5());cell = row.createCell(i++);
		cell.setCellValue(vo.getA6());cell = row.createCell(i++);
		cell.setCellValue(vo.getA7());cell = row.createCell(i++);
		cell.setCellValue(vo.getA8());cell = row.createCell(i++);
		cell.setCellValue(vo.getA9());cell = row.createCell(i++);
		cell.setCellValue(vo.getA10());cell = row.createCell(i++);
		cell.setCellValue(vo.getA11());cell = row.createCell(i++);
		cell.setCellValue(vo.getA12());cell = row.createCell(i++);
		cell.setCellValue(vo.getA13());cell = row.createCell(i++);
		cell.setCellValue(vo.getA14());cell = row.createCell(i++);
		cell.setCellValue(vo.getA15());cell = row.createCell(i++);
		cell.setCellValue(vo.getA16());cell = row.createCell(i++);
		cell.setCellValue(vo.getA17());cell = row.createCell(i++);
		cell.setCellValue(vo.getA18());cell = row.createCell(i++);
		cell.setCellValue(vo.getA19());cell = row.createCell(i++);
		cell.setCellValue(vo.getA20());cell = row.createCell(i++);
		cell.setCellValue(vo.getA21());cell = row.createCell(i++);
		cell.setCellValue(vo.getA22());cell = row.createCell(i++);
		cell.setCellValue(vo.getA23());cell = row.createCell(i++);
		cell.setCellValue(vo.getA24());cell = row.createCell(i++);
		cell.setCellValue(vo.getA25());cell = row.createCell(i++);
		cell.setCellValue(vo.getA26());cell = row.createCell(i++);
		cell.setCellValue(vo.getA27());cell = row.createCell(i++);
		cell.setCellValue(vo.getA28());cell = row.createCell(i++);
		cell.setCellValue(vo.getA29());cell = row.createCell(i++);
		cell.setCellValue(vo.getA30());cell = row.createCell(i++);
		cell.setCellValue(vo.getA31());cell = row.createCell(i++);
		cell.setCellValue(vo.getA32());cell = row.createCell(i++);
		cell.setCellValue(vo.getA33());cell = row.createCell(i++);
		cell.setCellValue(vo.getA34());cell = row.createCell(i++);
		cell.setCellValue(vo.getA35());cell = row.createCell(i++);
		cell.setCellValue(vo.getA36());cell = row.createCell(i++);
		cell.setCellValue(vo.getA37());cell = row.createCell(i++);
		cell.setCellValue(vo.getA38());cell = row.createCell(i++);
		cell.setCellValue(vo.getA39());cell = row.createCell(i++);
		cell.setCellValue(vo.getA40());cell = row.createCell(i++);
		cell.setCellValue(vo.getA41());cell = row.createCell(i++);
		cell.setCellValue(vo.getA42());cell = row.createCell(i++);
		cell.setCellValue(vo.getA43());cell = row.createCell(i++);
		cell.setCellValue(vo.getA44());cell = row.createCell(i++);
		cell.setCellValue(vo.getA45());cell = row.createCell(i++);
		cell.setCellValue(vo.getA46());cell = row.createCell(i++);
		cell.setCellValue(vo.getA47());cell = row.createCell(i++);
		cell.setCellValue(vo.getA48());cell = row.createCell(i++);
		cell.setCellValue(vo.getA49());cell = row.createCell(i++);
		cell.setCellValue(vo.getA50());cell = row.createCell(i++);
		cell.setCellValue(vo.getA51());cell = row.createCell(i++);
		cell.setCellValue(vo.getA52());cell = row.createCell(i++);
		cell.setCellValue(vo.getA53());cell = row.createCell(i++);
		cell.setCellValue(vo.getA54());cell = row.createCell(i++);
		cell.setCellValue(vo.getA55());cell = row.createCell(i++);
		cell.setCellValue(vo.getA56());cell = row.createCell(i++);
		cell.setCellValue(vo.getA57());cell = row.createCell(i++);
		cell.setCellValue(vo.getA58());cell = row.createCell(i++);
		cell.setCellValue(vo.getA59());cell = row.createCell(i++);
		cell.setCellValue(vo.getA60());cell = row.createCell(i++);
		cell.setCellValue(vo.getA61());cell = row.createCell(i++);
		cell.setCellValue(vo.getA62());cell = row.createCell(i++);
		cell.setCellValue(vo.getA63());cell = row.createCell(i++);
		cell.setCellValue(vo.getA64());cell = row.createCell(i++);
		cell.setCellValue(vo.getA65());cell = row.createCell(i++);
		cell.setCellValue(vo.getA66());cell = row.createCell(i++);
		cell.setCellValue(vo.getA67());cell = row.createCell(i++);
		cell.setCellValue(vo.getA68());cell = row.createCell(i++);
		cell.setCellValue(vo.getA69());cell = row.createCell(i++);
		cell.setCellValue(vo.getA70());cell = row.createCell(i++);
		cell.setCellValue(vo.getA71());cell = row.createCell(i++);
		cell.setCellValue(vo.getA72());cell = row.createCell(i++);
		cell.setCellValue(vo.getA73());cell = row.createCell(i++);
		cell.setCellValue(vo.getA74());cell = row.createCell(i++);
		cell.setCellValue(vo.getA75());cell = row.createCell(i++);
		cell.setCellValue(vo.getA76());cell = row.createCell(i++);
		cell.setCellValue(vo.getA77());cell = row.createCell(i++);
		cell.setCellValue(vo.getA78());cell = row.createCell(i++);
		cell.setCellValue(vo.getA79());cell = row.createCell(i++);
		cell.setCellValue(vo.getA80());cell = row.createCell(i++);
		cell.setCellValue(vo.getA81());cell = row.createCell(i++);
		cell.setCellValue(vo.getA82());cell = row.createCell(i++);
		cell.setCellValue(vo.getA83());cell = row.createCell(i++);
		cell.setCellValue(vo.getA84());cell = row.createCell(i++);
		cell.setCellValue(vo.getA85());cell = row.createCell(i++);
		cell.setCellValue(vo.getA86());cell = row.createCell(i++);
		cell.setCellValue(vo.getA87());cell = row.createCell(i++);
		cell.setCellValue(vo.getA88());cell = row.createCell(i++);
		cell.setCellValue(vo.getA89());cell = row.createCell(i++);
		cell.setCellValue(vo.getA90());cell = row.createCell(i++);
		cell.setCellValue(vo.getA91());cell = row.createCell(i++);
		cell.setCellValue(vo.getA92());cell = row.createCell(i++);
		cell.setCellValue(vo.getA93());cell = row.createCell(i++);
		cell.setCellValue(vo.getA94());cell = row.createCell(i++);
		cell.setCellValue(vo.getA95());cell = row.createCell(i++);
		cell.setCellValue(vo.getA96());cell = row.createCell(i++);
		cell.setCellValue(vo.getA97());cell = row.createCell(i++);
		cell.setCellValue(vo.getA98());cell = row.createCell(i++);
		cell.setCellValue(vo.getA99());cell = row.createCell(i++);
		cell.setCellValue(vo.getA100());cell = row.createCell(i++);
		cell.setCellValue(vo.getA101());cell = row.createCell(i++);
		cell.setCellValue(vo.getA102());cell = row.createCell(i++);
		cell.setCellValue(vo.getA103());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA104());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA105());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA106());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA107());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA108());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA109());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA110());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA111());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA112());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA113());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA114());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA115());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA116());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA117());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA118());cell = row.createCell(i++);
//		cell.setCellValue(vo.getA119());cell = row.createCell(i++);
		
	}

	@Override
	public void cellMerge(Sheet sheet) {
		//병합 영역 설정
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 3, 3));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 4, 4));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 5, 5));
		sheet.addMergedRegion(new CellRangeAddress(0, 1, 6, 6));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 17));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 18, 28));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 29, 39));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 40, 44));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 45, 49));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 50, 54));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 55, 157));
		
	}
}
