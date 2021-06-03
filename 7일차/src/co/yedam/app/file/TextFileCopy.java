package co.yedam.app.file;


import java.io.FileReader;
import java.io.FileWriter;

public class TextFileCopy {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("d:/temp/data.txt");
			FileWriter fw = new FileWriter("d:/temp/data1.txt");
			char[] c = new char[100];
			while(true) {
				int cnt= fr.read(c);
				if(cnt == -1) break;
				fw.write(c);
			
//			int c;
//			while(true) {
//				c= fr.read();
//				if(c == -1) break;
//				fw.write(c);
			}
				fr.close();
				fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
