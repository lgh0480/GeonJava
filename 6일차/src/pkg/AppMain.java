package pkg;

public class AppMain {
	 static void print() {
		System.out.println("======");
		}
	public static void main(String[] args) { //스태틱 메서드 안에서 라는 뜻
			Count count1 = new Count(); //접근할때 클래스 이름으로 접근하는것이 제일좋다!(알겠나연?)
			count1.cnt1++;
			count1.cnt2++;
			
			Count count2 = new Count();
			count2.cnt1++;
			count2.cnt2++;
			
			Count count3 = new Count();
			count3.cnt1++;
			count3.cnt2++;
			
			System.out.println(count1.cnt1+" : "+count1.cnt2);
			System.out.println(count2.cnt1+" : "+count2.cnt2);
			
			System.out.println(count3.cnt1+" : "+count3.cnt2);
		 //DateUtil dateUtil = new DateUtil();
		//System.out.println(DateUtil.CurDate());
		
		//ProjectInfo info = new ProjectInfo();
		ProjectInfo.uploadpath = "/upload";
	 
	 //System.out.println(info.name);
	// info.name = "ㅋㅋ내꺼임"; //다른데에서 해킹으로 이름을 바꿀수 있으니. Static으로 막아버림.
	 //System.out.println(info.name);
	
		ProjectInfo info = new ProjectInfo();
		System.out.println(info.version);
		
	
	
	}
}
