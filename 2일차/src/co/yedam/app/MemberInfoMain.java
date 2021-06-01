package co.yedam.app;

public class MemberInfoMain {
	public static void main(String[] args) {
		MemberInfo member = new MemberInfo();
		//member.input();   //입력 받아라.
		//member.print();   //출력 받아라.
		member.heightWeightInput();
		member.bmi();
		System.out.println(member.result +":" + member.s);
		
	}
}
