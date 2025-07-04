/**
 * 
 */
package medical.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author jaechulhan
 *
 */
public class DateUtil {

	public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
	
	public DateUtil() {
		
	}
	/**
	 * 현재일자 조회
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		return df.format(new Date());		
	}
	
	/**
	 * 전일자 조회
	 * @return
	 */
	public static Date SubtractDate (int subTract) {
		Date subTractDay = new Date( );
		subTractDay.setTime ( subTractDay.getTime ( ) - ( (long) 1000 * 60 * 60 * 24 ) * subTract);
		return subTractDay;
	}
	
	/**
	 * @return
	 */
	public static String getShortDateTimeStampString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date());
	}

	/**
	 * @return
	 */
	public static String getShortDateTimeString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HHmmssSSS");
		return df.format(new Date());
	}

	/**
	 * @return
	 */
	public static String getShortTimeStampString() {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(new Date());
	}
	
	/**
	 * @return
	 */
	public static String getSimpleDate(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}
	
	/**
	 * get today by format (ex : yyyyMM -> )
	 * @param format
	 * @return
	 */
	public static String getTodayByFormat(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * get End Day of Month (말일 구하기)
	 * 
	 * @param year
	 * @param month
	 * @return 말일
	 */
	public static int getEndDayOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * get date by format
	 * 
	 * @param date
	 * @param format
	 * @return date
	 */
	public static String getDateByFormat(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * convert string to date
	 * 
	 * @param date
	 * @param format
	 * @return Date
	 */
	public static Date convertStringToDate(String date, String format) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 현재 일자 및 시간을 String yyyyMMddHHmmssSSS 형태로 반환 한다.
	 * @return
	 */
	public static String getToDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	
	/**
	 * 월 연산
	 * @param dateStr
	 * @return
	 */
	public static String addMonth(String yearMonth, int add) {
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMM");
		String resultYearMonth = null;
		
		try {
			Date dt = fmt.parse(yearMonth);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			
			cal.add(Calendar.MONTH, add);
			resultYearMonth = fmt.format(cal.getTime()).substring(0,6);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return resultYearMonth;
	}
	
	/**
	 * 년 연산
	 * @param dateStr
	 * @return
	 */
	public static String addYear(String yearMonth, int add) {
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMM");
		String resultYearMonth = null;
		
		try {
			Date dt = fmt.parse(yearMonth);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			
			cal.add(Calendar.YEAR, add);
			resultYearMonth = fmt.format(cal.getTime()).substring(0,6);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return resultYearMonth;
	}
	
	public class PerformTermVO{
		private String yyyy;
		private int performCnt;
		private String fromDate;
		private String toDate;
		
		public String getFromDate() {
			return fromDate;
		}
		public void setFromDate(String fromDate) {
			this.fromDate = fromDate;
		}
		public int getPerformCnt() {
			return performCnt;
		}
		public void setPerformCnt(int performCnt) {
			this.performCnt = performCnt;
		}
		public String getYyyy() {
			return yyyy;
		}
		public void setYyyy(String yyyy) {
			this.yyyy = yyyy;
		}
		
		public String getToDate() {
			return toDate;
		}
		public void setToDate(String toDate) {
			this.toDate = toDate;
		}
		
		
	}
	
	public static List<PerformTermVO> rndPerformTermSort(String fromYyyyMmDd,
			String toYyyyMmDd,
			int yearPerformTotal){
		List<PerformTermVO> oList = new ArrayList<PerformTermVO>();
		try {
			int fromYyyy = Integer.valueOf(fromYyyyMmDd.substring(0, 4));
			int toYyyy = Integer.valueOf(toYyyyMmDd.substring(0, 4));
			int yyyyGap = toYyyy - fromYyyy;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date fromDate = new Date();
			Date toDate = new Date();
			long calDate = 0L; 
			long calDateDays = 0L; 
			calDateDays = Math.abs(calDateDays);	// 일수
			int divideDays = 0;
			int remainder = 0;
			DateUtil oDateUtil = new DateUtil();
			PerformTermVO oPerformTermVO = null;
			String fromDtStr = new String();
			String toDtStr = new String();
			int performCnt = 0;
			if(yyyyGap != 0) {
				int tmpYyyy = 0;
				for(int s = 0; s <= yyyyGap; s++) {
					tmpYyyy = fromYyyy + s;
					if(tmpYyyy == fromYyyy) {
						fromDtStr = fromYyyyMmDd;
						toDtStr = String.valueOf(tmpYyyy)+"1231";
					}else if(tmpYyyy > fromYyyy && tmpYyyy < toYyyy){
						fromDtStr = String.valueOf(tmpYyyy)+"0101";
						toDtStr = String.valueOf(tmpYyyy)+"1231";
					}else {
						fromDtStr = String.valueOf(tmpYyyy)+"0101";
						toDtStr = toYyyyMmDd;
					}			
					fromDate = sdf.parse(fromDtStr);
					toDate = sdf.parse(toDtStr);
					/**일수구하기*/
					// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
					// 연산결과 -950400000. long type 으로 return 된다.
					calDate = toDate.getTime() - fromDate.getTime(); 

					// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
					// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
					calDateDays = calDate / ( 24*60*60*1000); 
					calDateDays = Math.abs(calDateDays);	// 일수
					divideDays = (int) (calDateDays / yearPerformTotal);
					remainder = (int) (calDateDays % yearPerformTotal);
					
//					System.out.println("차이일수 ===> " + calDateDays);
//					System.out.println("배분일수 ===> " + divideDays);
//					System.out.println("나머지일수 ===> " + remainder);
//					System.out.println("연수행횟수 ===> " + yearPerformTotal);
//					System.out.println("연도차이 ===> " + yyyyGap);
					
					if(yearPerformTotal > calDateDays) {
						performCnt = (int) remainder+1;
						divideDays = 0;
					}else performCnt = yearPerformTotal;
					List<PerformTermVO> sList = new ArrayList<PerformTermVO>();
					for(int i = 1; i <= performCnt; i++) {
						oPerformTermVO = oDateUtil.new PerformTermVO();
						oPerformTermVO.setPerformCnt(i);
						oPerformTermVO.setYyyy(String.valueOf(tmpYyyy));
						oPerformTermVO.setFromDate(sList.size()==0?fromDtStr:getAddDate(
								sdf.parse(sList.get(i-2).getToDate())
								,1));
						if(yearPerformTotal > calDateDays)oPerformTermVO.setToDate(oPerformTermVO.getFromDate());
						else oPerformTermVO.setToDate(sList.size()==0?getAddDate(fromDate, divideDays)
								:getAddDate(sdf.parse(sList.get(i-2).getToDate())
								,i==yearPerformTotal?divideDays+remainder:divideDays));
						sList.add(oPerformTermVO);
						oList.add(oPerformTermVO);
					} // days divide for end
					if(performCnt < yearPerformTotal) {
						for(int m = performCnt+1; m <= yearPerformTotal; m++) {
							oPerformTermVO = oDateUtil.new PerformTermVO();
							oPerformTermVO.setPerformCnt(m);
							oPerformTermVO.setYyyy(String.valueOf(tmpYyyy));
							oList.add(oPerformTermVO);
						}
					}
				} //year divide for end
			}else {
				fromDate = sdf.parse(fromYyyyMmDd);
				toDate = sdf.parse(toYyyyMmDd);
				/**일수구하기*/
				// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
				// 연산결과 -950400000. long type 으로 return 된다.
				calDate = toDate.getTime() - fromDate.getTime(); 

				// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다. 
				// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
				calDateDays = calDate / ( 24*60*60*1000); 
				calDateDays = Math.abs(calDateDays);	// 일수
				if(yearPerformTotal >= calDateDays) {
					performCnt = (int) remainder;
					divideDays = 1;
				}else performCnt = yearPerformTotal;
				
				divideDays = (int) (calDateDays / yearPerformTotal);
				remainder = (int) (calDateDays % yearPerformTotal);
				
//				System.out.println("차이일수 ===> " + calDateDays);
//				System.out.println("배분일수 ===> " + divideDays);
//				System.out.println("나머지일수 ===> " + remainder);
//				System.out.println("연수행횟수 ===> " + yearPerformTotal);
//				System.out.println("연도차이 ===> " + yyyyGap);
				
				for(int i = 1; i <= performCnt; i++) {
					oPerformTermVO = oDateUtil.new PerformTermVO();
					oPerformTermVO.setPerformCnt(i);
					oPerformTermVO.setYyyy(String.valueOf(fromYyyy));
					if(i == 1) {
						oPerformTermVO.setFromDate(fromYyyyMmDd);
						oPerformTermVO.setToDate(getAddDate(fromDate, divideDays));
						oList.add(oPerformTermVO);
					}else {
						oPerformTermVO.setFromDate(getAddDate(
								sdf.parse(oList.get(i-2).getToDate())
								,1));
						if(i==yearPerformTotal)oPerformTermVO.setToDate(toYyyyMmDd);
						else oPerformTermVO.setToDate(getAddDate(
								sdf.parse(oList.get(i-2).getToDate())
								,divideDays));
						oList.add(oPerformTermVO);
					}
				}
				if(performCnt < yearPerformTotal) {
					for(int m = performCnt+1; m <= yearPerformTotal; m++) {
						oPerformTermVO = oDateUtil.new PerformTermVO();
						oPerformTermVO.setPerformCnt(m);
						oPerformTermVO.setYyyy(String.valueOf(fromYyyy));
						oList.add(oPerformTermVO);
					}
				}
			}
//			for(PerformTermVO fPerformTermVO : oList) {
//				System.out.println("연도 : " + fPerformTermVO.getYyyy());
//				System.out.println("수행회차 : " + fPerformTermVO.getPerformCnt());
//				System.out.println("시작일자 : " + fPerformTermVO.getFromDate());
//				System.out.println("종료일자 : " + fPerformTermVO.getToDate());
//			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return oList;
	}
	
	public static String getAddDate(Date oDate, int days) {
		String yyyyMmDd = new String();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(oDate); 
			cal.add(Calendar.DATE, days); 
			yyyyMmDd = sdf.format(cal.getTime()); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return yyyyMmDd;
	}
	public static void main(String args[]) {
		List<PerformTermVO> oList = rndPerformTermSort(args[0], args[1], Integer.valueOf(args[2]));
		
	}
}
