package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ScoreInputTest {

	public static void main(String[] args) {
		try {
			BufferedReader fr = new BufferedReader(new FileReader("d:/temp/score.txt"));
			PrintStream out = System.out;
			String a;
			while (true) {
				a = fr.readLine();
				if (a == null)
					break;
				String[] score = a.split(" ");
				System.out.println(Integer.parseInt(score[0]) + Integer.parseInt(score[1]));
				out.println(a);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace(); //에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.


		}

	}
}