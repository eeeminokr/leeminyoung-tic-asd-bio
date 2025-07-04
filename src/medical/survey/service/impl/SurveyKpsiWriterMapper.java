package medical.survey.service.impl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import medical.framework.file.mapping.CellWriterMapper;
import medical.survey.service.SurveyKpsiVO;

public class SurveyKpsiWriterMapper implements CellWriterMapper<SurveyKpsiVO>{
	@Override
	public void mapHeader(Row row, SurveyKpsiVO vo) {
		Cell cell = null;
		int i = 0;
		
		int rowNum = row.getRowNum();
		if(rowNum==0) {
		cell = row.createCell(i++);
		cell.setCellValue("연구번호");
		
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
		cell.setCellValue("K-Psi");
		cell = row.createCell(142);
		
		}
		if(rowNum==1) {
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
			cell = row.createCell(i++);
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
			cell.setCellValue("15");
			cell = row.createCell(i++);
			cell.setCellValue("16");
			cell = row.createCell(i++);
			cell.setCellValue("17");
			cell = row.createCell(i++);
			cell.setCellValue("18");
			cell = row.createCell(i++);
			cell.setCellValue("19");
			cell = row.createCell(i++);
			cell.setCellValue("20");
			cell = row.createCell(i++);
			cell.setCellValue("21");
			cell = row.createCell(i++);
			cell.setCellValue("22");
			cell = row.createCell(i++);
			cell.setCellValue("23");
			cell = row.createCell(i++);
			cell.setCellValue("24");
			cell = row.createCell(i++);
			cell.setCellValue("25");
			cell = row.createCell(i++);
			cell.setCellValue("26");
			cell = row.createCell(i++);
			cell.setCellValue("27");
			cell = row.createCell(i++);
			cell.setCellValue("28");
			cell = row.createCell(i++);
			cell.setCellValue("29");
			cell = row.createCell(i++);
			cell.setCellValue("30");
			cell = row.createCell(i++);
			cell.setCellValue("31");
			cell = row.createCell(i++);
			cell.setCellValue("32");
			cell = row.createCell(i++);
			cell.setCellValue("33");
			cell = row.createCell(i++);
			cell.setCellValue("34");
			cell = row.createCell(i++);
			cell.setCellValue("35");
			cell = row.createCell(i++);
			cell.setCellValue("36");
			cell = row.createCell(i++);
			cell.setCellValue("37");
			cell = row.createCell(i++);
			cell.setCellValue("38");
			cell = row.createCell(i++);
			cell.setCellValue("39");
			cell = row.createCell(i++);
			cell.setCellValue("40");
			cell = row.createCell(i++);
			cell.setCellValue("41");
			cell = row.createCell(i++);
			cell.setCellValue("42");
			cell = row.createCell(i++);
			cell.setCellValue("43");
			cell = row.createCell(i++);
			cell.setCellValue("44");
			cell = row.createCell(i++);
			cell.setCellValue("45");
			cell = row.createCell(i++);
			cell.setCellValue("46");
			cell = row.createCell(i++);
			cell.setCellValue("47");
			cell = row.createCell(i++);
			cell.setCellValue("48");
			cell = row.createCell(i++);
			cell.setCellValue("49");
			cell = row.createCell(i++);
			cell.setCellValue("50");
			cell = row.createCell(i++);
			cell.setCellValue("51");
			cell = row.createCell(i++);
			cell.setCellValue("52");
			cell = row.createCell(i++);
			cell.setCellValue("53");
			cell = row.createCell(i++);
			cell.setCellValue("54");
			cell = row.createCell(i++);
			cell.setCellValue("55");
			cell = row.createCell(i++);
			cell.setCellValue("56");
			cell = row.createCell(i++);
			cell.setCellValue("57");
			cell = row.createCell(i++);
			cell.setCellValue("58");
			cell = row.createCell(i++);
			cell.setCellValue("59");
			cell = row.createCell(i++);
			cell.setCellValue("60");
			cell = row.createCell(i++);
			cell.setCellValue("61");
			cell = row.createCell(i++);
			cell.setCellValue("62");
			cell = row.createCell(i++);
			cell.setCellValue("63");
			cell = row.createCell(i++);
			cell.setCellValue("64");
			cell = row.createCell(i++);
			cell.setCellValue("65");
			cell = row.createCell(i++);
			cell.setCellValue("66");
			cell = row.createCell(i++);
			cell.setCellValue("67");
			cell = row.createCell(i++);
			cell.setCellValue("68");
			cell = row.createCell(i++);
			cell.setCellValue("69");
			cell = row.createCell(i++);
			cell.setCellValue("70");
			cell = row.createCell(i++);
			cell.setCellValue("71");
			cell = row.createCell(i++);
			cell.setCellValue("72");
			cell = row.createCell(i++);
			cell.setCellValue("73");
			cell = row.createCell(i++);
			cell.setCellValue("74");
			cell = row.createCell(i++);
			cell.setCellValue("75");
			cell = row.createCell(i++);
			cell.setCellValue("76");
			cell = row.createCell(i++);
			cell.setCellValue("77");
			cell = row.createCell(i++);
			cell.setCellValue("78");
			cell = row.createCell(i++);
			cell.setCellValue("79");
			cell = row.createCell(i++);
			cell.setCellValue("80");
			cell = row.createCell(i++);
			cell.setCellValue("81");
			cell = row.createCell(i++);
			cell.setCellValue("82");
			cell = row.createCell(i++);
			cell.setCellValue("83");
			cell = row.createCell(i++);
			cell.setCellValue("84");
			cell = row.createCell(i++);
			cell.setCellValue("85");
			cell = row.createCell(i++);
			cell.setCellValue("86");
			cell = row.createCell(i++);
			cell.setCellValue("87");
			cell = row.createCell(i++);
			cell.setCellValue("88");
			cell = row.createCell(i++);
			cell.setCellValue("89");
			cell = row.createCell(i++);
			cell.setCellValue("90");
			cell = row.createCell(i++);
			cell.setCellValue("91");
			cell = row.createCell(i++);
			cell.setCellValue("92");
			cell = row.createCell(i++);
			cell.setCellValue("93");
			cell = row.createCell(i++);
			cell.setCellValue("94");
			cell = row.createCell(i++);
			cell.setCellValue("95");
			cell = row.createCell(i++);
			cell.setCellValue("96");
			cell = row.createCell(i++);
			cell.setCellValue("97");
			cell = row.createCell(i++);
			cell.setCellValue("98");
			cell = row.createCell(i++);
			cell.setCellValue("99");
			cell = row.createCell(i++);
			cell.setCellValue("100");
			cell = row.createCell(i++);
			cell.setCellValue("101");
			cell = row.createCell(i++);
			cell.setCellValue("102");
			cell = row.createCell(i++);
			cell.setCellValue("103");
			cell = row.createCell(i++);
			cell.setCellValue("104");
			cell = row.createCell(i++);
			cell.setCellValue("105");
			cell = row.createCell(i++);
			cell.setCellValue("106");
			cell = row.createCell(i++);
			cell.setCellValue("107");
			cell = row.createCell(i++);
			cell.setCellValue("108");
			cell = row.createCell(i++);
			cell.setCellValue("109");
			cell = row.createCell(i++);
			cell.setCellValue("110");
			cell = row.createCell(i++);
			cell.setCellValue("111");
			cell = row.createCell(i++);
			cell.setCellValue("112");
			cell = row.createCell(i++);
			cell.setCellValue("113");
			cell = row.createCell(i++);
			cell.setCellValue("114");
			cell = row.createCell(i++);
			cell.setCellValue("115");
			cell = row.createCell(i++);
			cell.setCellValue("116");
			cell = row.createCell(i++);
			cell.setCellValue("117");
			cell = row.createCell(i++);
			cell.setCellValue("118");
			cell = row.createCell(i++);
			cell.setCellValue("119");
			cell = row.createCell(i++);
			cell.setCellValue("120");
			cell = row.createCell(i++);
			cell.setCellValue("주의산만/\n과잉행동");
			cell = row.createCell(i++);
			cell.setCellValue("적응");
			cell = row.createCell(i++);
			cell.setCellValue("보상");
			cell = row.createCell(i++);
			cell.setCellValue("요구");
			cell = row.createCell(i++);
			cell.setCellValue("기분");
			cell = row.createCell(i++);
			cell.setCellValue("수용");
			cell = row.createCell(i++);
			cell.setCellValue("아동 영역");
			cell = row.createCell(i++);
			cell.setCellValue("유능감");
			cell = row.createCell(i++);
			cell.setCellValue("고립");
			cell = row.createCell(i++);
			cell.setCellValue("애착");
			cell = row.createCell(i++);
			cell.setCellValue("건강");
			cell = row.createCell(i++);
			cell.setCellValue("역할제한");
			cell = row.createCell(i++);
			cell.setCellValue("우울");
			cell = row.createCell(i++);
			cell.setCellValue("배우자");
			cell = row.createCell(i++);
			cell.setCellValue("부모영역");
			cell = row.createCell(i++);
			cell.setCellValue("총스트레스");
			cell = row.createCell(i++);
			cell.setCellValue("일상스트레스");
			
		}
	}
	
	@Override
	public void mapRow(Row row, SurveyKpsiVO vo) {
		Cell cell = null;
		int i = 0;

		cell = row.createCell(i++);
		cell.setCellValue(vo.getTargetId());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getSex());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getProtocol());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getPerformNm());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getAge());

		cell = row.createCell(i++);
		cell.setCellValue(vo.getKpsiExecDate());

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
		cell.setCellValue(vo.getA21());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA22());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA23());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA24());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA25());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA26());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA27());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA28());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA29());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA30());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA31());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA32());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA33());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA34());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA35());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA36());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA37());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA38());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA39());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA40());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA41());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA42());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA43());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA44());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA45());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA46());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA47());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA48());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA49());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA50());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA51());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA52());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA53());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA54());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA55());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA56());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA57());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA58());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA59());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA60());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA61());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA62());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA63());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA64());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA65());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA66());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA67());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA68());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA69());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA70());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA71());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA72());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA73());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA74());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA75());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA76());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA77());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA78());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA79());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA80());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA81());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA82());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA83());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA84());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA85());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA86());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA87());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA88());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA89());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA90());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA91());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA92());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA93());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA94());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA95());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA96());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA97());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA98());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA99());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA100());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA101());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA102());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA103());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA104());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA105());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA106());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA107());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA108());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA109());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA110());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA111());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA112());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA113());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA114());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA115());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA116());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA117());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA118());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA119());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA120());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA121());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA122());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA123());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA124());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA125());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA126());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA127());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA128());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA129());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA130());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA131());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA132());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA133());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA134());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA135());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA136());
		
		cell = row.createCell(i++);
		cell.setCellValue(vo.getA137());
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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 142));
		
	}
	
}
