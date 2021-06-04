package co.friend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	//Date 날짜값 넣어주면 String으로 바꿔주는 메서드로 만들어줄것임
	static String format ="yyyy.MM.dd EEE G 'at' HH:mm:ss z";
	public static String dateToStr(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String s = df.format(date);
		return s;
	}
	public static String dateToStr(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String s = df.format(date);
	
		return s;
	}
	//두 날짜 사이의 일수 계산
		public static long durationDay(Date d1,Date d2) {
			long result = 0;
			if(d1.getTime() > d2.getTime()) {
				result =d1.getTime() - d2.getTime();
			}else {
				result = d2.getTime() - d1.getTime()	;
			}
			result = result/1000/60/60/24;
			return result;
		}
	
		public static long durationDay(String s1, String s2) {
			SimpleDateFormat df = new SimpleDateFormat(format);
			Date  d1;
			Date  d2;
			long result = 0;
			try {
				 d1 = df.parse(s1); //parse:구문 분석
				 d2 = df.parse(s2);
				result = d1.getTime() -d2.getTime();
				result = result/1000/60/60/24;
				
			}catch (ParseException e) {
				e.printStackTrace();
			}
			return result;
		}
		// 그달의 최대 일수
		public static int lastday(int year, int month) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month+1, 1);
			int a = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // getActualMaximum: 날짜가 설정된 켈린더가 가질수있는 값
			
			return a;
		
	}
	
	
}
