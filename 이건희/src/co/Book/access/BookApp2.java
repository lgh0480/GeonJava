package co.Book.access;

import java.util.Scanner;

import co.Book.model.Book;
import co.Book.util.BookServiceFind;
import co.Book.util.BookServiceInsert;

public class BookApp2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookList list = new BookList();
		list.insert(new Book("1","자바","자바를 배우자"));
		list.insert(new Book("2","JSP","JSP 기초"));
		list.insert(new Book("3","JSP응용","JSP 심화학습"));
		list.insert(new Book("4","자바웹","JSP 응용"));
		System.out.println("1======================");
		int menu =0;
		do {
			System.out.println("1.등록   2.내용조회  0.종료");
			System.out.println("입력>");
			menu = scanner.nextInt();
			if(menu ==2) {
				BookServiceFind bookServiceFind = new BookServiceFind();
				bookServiceFind.execute(list);
			}else if (menu == 1) {
				BookServiceInsert bookServiceFind = new BookServiceInsert();
				bookServiceFind.execute(list);
			}	
		}while(menu !=0);
	}

}
