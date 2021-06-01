package co.yedam.score;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreArrApp score = new ScoreArrApp();
		//score.print();
		//score.total();
		System.out.printf("총점:%04d\n",score.total());
		//score.avg();
		System.out.printf("평균은:%-1.2f\n",score.avg()); //p.091 참조. ㅇㅋ?
		score.printH();
	}
	
		
	}
	

