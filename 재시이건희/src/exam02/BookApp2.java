package exam02;

import java.util.Scanner;

public class BookApp2 {
	public static void main(String[] args) {
		MemoDate books = new MemoDate();
		books.insert(new Memo("1","자바","자바를 배우자"));
		books.insert(new Memo("2","JSP","JSP 기초"));
		books.insert(new Memo("3","JSP응용","JSP 심화학습"));
		books.insert(new Memo("4","자바웹","JSP 응용"));
		MemoService[] service = {null, new BookServiceInsert(),
									   new BookServiceFind(), 
									   new BookServiceFindIsbn(),
									   new BookServiceFindAll(),
										new BookServiceDelete()};
		int menu =0;	
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1.등록   2.내용조회  3.isbn조회 4.전체조회 5.삭제 0.종료");
			System.out.print("입력>");
			menu = scanner.nextInt();
			if(menu==0) break;
			service[menu].execute(books);
		}while(true);
	}

}
