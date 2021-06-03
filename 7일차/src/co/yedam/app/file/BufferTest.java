package co.yedam.app.file;

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
				int b = Integer.parseInt(score[0]);
				if(a == null) break;
				out.println(a);
			}
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
