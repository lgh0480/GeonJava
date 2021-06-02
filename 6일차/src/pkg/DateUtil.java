package pkg;

/*
 * 정적메서드 안에서는 정적필드만 접근 할수있음. 
 * 접근제어자: private > default >      protected          > public
 * 			  클래스내부 같은패키지   다른패키지-상속
 */
public class DateUtil {
	public static String curDate() {
		return "20210602";

	}

}
