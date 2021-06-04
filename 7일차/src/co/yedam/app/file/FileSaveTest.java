package co.yedam.app.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.InputStreamReader;

public class FileSaveTest {

	public static void main(String[] args) {
		// byte:stream - byte단위로 읽어버림 , char(2~3):reader

		try {
			BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter br = new BufferedWriter(new FileWriter("d:/temp/f.dat"));
			while (true) {
				String c = isr.readLine(); // 입출력을 항상 예외처리
				if (c == null)
					break; // 끝내는건 컨트롤+z
				br.write(c);
				br.write("\n"); // 줄바꿈
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
