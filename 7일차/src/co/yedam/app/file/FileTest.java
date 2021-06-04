package co.yedam.app.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void filecreate() throws IOException {
		// 파일생성
		File file = new File("d:/temp/diary.txt");
		boolean result = file.createNewFile();
		System.out.println(result);
	}

	public static void main(String[] args) {
		// fileCreate();
		// makefolder(); //폴더 만들기
		// fileInfo();
		folderlist();
	}

	private static void folderlist() {
		File file = new File("d:/temp");
		if (file.isDirectory()) {
			file.listFiles();
			File[] list = file.listFiles();
			for (File i : list) {
				if (StringUtil.getExtention(i.getName()).equals("png")) {
					System.out.println(i.getName());
					FileUtil.copy(i.getAbsolutePath(), "d:temp/images/" + i.getName());
				}
				
			}
		}
	}

	private static void fileInfo() {
		File file = new File("d:/temp/images.png");
		System.out.println("파일크기 : " + file.length());
		System.out.println(file.getName());
	}

	private static void makefolder() {
		File file = new File("d:/temp/images");
		file.mkdir();

	}

}
