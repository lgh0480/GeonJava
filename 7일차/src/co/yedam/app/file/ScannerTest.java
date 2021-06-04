package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) throws FileNotFoundException {
		String str = "1 hi"; // 백준문제 풀때
		Scanner scanner = new Scanner(new FileInputStream("d:/temp/f.dat"));     //system.in 치는걸 들어는거
		//int a =scanner.nextInt();
		while(true) {
			try {
				String a = scanner.next();	
				System.out.println(a);
			}catch(Exception e) {
				break;
			}
				
		}
	
	}

}
