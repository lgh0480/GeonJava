package co.yedam.app.date;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Date date =new Date();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int day_year = calendar.get(Calendar.DAY_OF_YEAR);
		int hour = calendar.get(Calendar.HOUR);
		int minute =calendar.get(Calendar.MINUTE);
		int second =calendar.get(Calendar.SECOND);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(day_year);
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		
		//살아온 일수
		Calendar birth= Calendar.getInstance();
		birth.set(1993,1-1,28);
		long dur = calendar.getTimeInMillis() -birth.getTimeInMillis();
		dur = dur/1000/60/60/24;
		System.out.println("일수"+ dur);
		System.out.println(System.currentTimeMillis());
		//기념일 계산
		Calendar kommen = Calendar.getInstance();
		kommen.set(2020,5-1,20);
		long due = calendar.getTimeInMillis() -kommen.getTimeInMillis();
		due = due/1000/60/60/24;
		System.out.println("귀국 일수"+ due);
		System.out.println(System.currentTimeMillis());
		
		//Date -> String
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd EEE G 'at' HH:mm:ss z");
		df.format(calendar.getTime());
		System.out.println(df.format(calendar.getTime()));
		
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate.getYear() +"/" 
							+ currentDate.getMonthValue() + "/"+
							currentDate.getDayOfMonth());
		System.out.println(currentDate.plusDays(100)); //100일 후 
		
		//Duration duration = Duration.between(start, end);
		
		//System.out.println("Seconds" + duration.getSeconds());
		//System.out.println("Nano Seconds: " + duration.getNano());
													
	}
		
		
}

