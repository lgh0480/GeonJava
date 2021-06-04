package co.yedam.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileUtil{

	public static void copy(String src,String des) {
		//파일복사
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(des);
			byte[] b = new byte[100]; // 100바이트씩 읽어 낼것임.
			while(true) {   //리드 메서드에 리턴값을 봐야함/ 
			int cnt = fis.read(b); 
					if(cnt == -1) break;  
					fos.write(b);							//한바이트씩 읽어ㅓㅅ
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
