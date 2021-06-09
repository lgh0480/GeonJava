package co.yedam.app.file;
/*
 * parseInt()는 문자열 String타입의 숫자를 int타입으로 변환해주는 녀석
 * int 뿐만 아니라 byte,short,long,float,double등 숫자와 관련된 타입은 전부 가능하다.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class BufferTest {
	public static void main(String[] args) {
		try {
			BufferedReader fr = new BufferedReader(
					new FileReader("d:/temp/score.txt"));	
			PrintStream out = System.out;
			String a;
			while(true) {
				a = fr.readLine();
				String[] score = a.split(" ");
				System.out.println(score[0]+score[1]);
				int b = Integer.parseInt(score[0]); //
				if(a == null) break;
				out.println(a);
			}
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
