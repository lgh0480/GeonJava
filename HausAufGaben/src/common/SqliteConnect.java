package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SqliteConnect {
	//필드로 선언
	static PreparedStatement psmt;  //사전 컴파일 된 SQL 문을 나타내는 개체입니다.
	static ResultSet rs; //데이터베이스를 쿼리하는 명령문을 실행하여 생성되는 데이터베이스 결과 집합을 나타내는 데이터 테이블입니다.
	static Connection conn; //연결 개체의 데이터베이스는 테이블, 지원되는 SQL 문법
	
	
	
	
	
	
	public static void main(String[] args) {
		// 스캐너 생성 후 -> while문으로 ("1:전체리스트 2:입력 3:수정 4:삭제 5:한건조회 6.이름조회 9:종료")
		// if문 걸어서 1,2,3,4,5,6,9까지 else if 만들기
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int menu = scanner.nextInt();
			
			if (menu == 1) {
				// 전체리스트 기능
			
			}else if(menu == 2 ) {
				//입력
			
			}else if(menu == 3) {
				//수정
				
			}else if(menu ==4) {
				
				//삭제
			}else if(menu ==5) {
				
				//한건조회
			}else if(menu ==6) {
				
				//이름조회
			}else if(menu == 9) {
				break;
			}
		
		}// end of while

	}// end of main();
} // end of class
