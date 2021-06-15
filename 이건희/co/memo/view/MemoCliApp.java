package co.memo.view;

import java.util.List;
import java.util.Scanner;

import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;
import co.memo.model.Memo;

public class MemoCliApp {

	MemoAccess access = new MemoDAO(); // 데이터베이스 입출력 처리하세요.
	Scanner scanner = new Scanner(System.in);

	public void start() {
		int menuNum;

		do {
			menuTitle();

			System.out.print("입력 > ");
			menuNum = scanner.nextInt();
			switch (menuNum) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				selectAll();
				break;
			case 5:
				findByDate();
				break;
			case 6:
				findByContent();
				break;
			}
		} while (menuNum != 0);

	}

	// 날짜, 제목, 내용 삽입
	private void insert() {
		scanner.nextLine();
		System.out.println("입력할 날짜를 입력하시오 > ");
		String date = scanner.nextLine();
		System.out.println("입력할 제목를 입력하시오 > ");
		String title = scanner.nextLine();
		
		System.out.println("입력할 내용를 입력하시오 > ");
		String content = scanner.nextLine();

		access.write(date, title, content);

	}

	// 내용 변경
	private void update() {
		scanner.nextLine();
		System.out.println("조회할 날짜를 입력하세요 > ");
		String date = scanner.nextLine();
		System.out.println("변경할 제목 > ");
		String title = scanner.nextLine();
		System.out.println("변경할 내용 > ");
		String content = scanner.nextLine();
		
		access.update(date, title, content);
	}

	private void delete() {
		scanner.nextLine();
		System.out.println("삭제할 제목을 입력하세요 >");
		String title = scanner.nextLine();
		
		access.delete(title);
		
	}

	// 전체조회
	private void selectAll() {
		System.out.println("전체조회");
		List<Memo> list = access.FindAll();
		for (Memo board : list) {
			System.out.println(board);
		}
	}

	private void findByDate() {
		scanner.nextLine();
		System.out.println("조회할 날짜를 입력하시오. > ");
		String date = scanner.nextLine();
		Memo m = access.FindByDate(date);
		System.out.println(m);
		
		
	}

	private void findByContent() {
		scanner.nextLine();
		System.out.println("조회할 내용을 입력하세요 >");
		String content = scanner.nextLine();
		
		access.FindByContent(content);
	}

	private void menuTitle() {
		System.out.println("== 메모 관리 ==");
		System.out.println("=1. 메모 추가");
		System.out.println("=2. 메모 수정");
		System.out.println("=3. 메모 삭제");
		System.out.println("=4. 전체 조회");
		System.out.println("=5. 날짜로 조회");
		System.out.println("=6. 내용으로 조회");
		System.out.println("=0. 종료");
		System.out.println("===============");

	}

}
