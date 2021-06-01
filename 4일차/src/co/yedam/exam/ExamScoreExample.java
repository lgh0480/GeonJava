package co.yedam.exam;

public class ExamScoreExample {

	public static void main(String[] args) {
		ExamScore examScore = new ExamScore("이건희", 60, 60, 80);
			System.out.println(examScore.isPass()?"합격":"불합격");
		
	}
	
	
	

}
