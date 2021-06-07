package API;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SystemTest {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		System.out.println(System.currentTimeMillis());
		// 파일명을 rename 할때 ,실행시간

		// System.exit(1);

		Map<String, String> map = System.getenv();
		System.out.println(map.get("Java_HOME"));
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + " : " + map.get(key));
		}

		// 메모리 회수를 자동으로 해줌

		// System.gc(); //가비쥐 콜렉터 그리고 이게자동이다.
		Field[] fields = Book.class.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName() + ":" + f.getType());
		}
		URI uri = Book.class.getResource("/resources/menu.txt").toURI(); //상대경로
		//Scanner scanner = new Scanner(new File(uri));
		Scanner scanner = new Scanner(new File(uri));
		System.out.println(scanner.next());

	}
}