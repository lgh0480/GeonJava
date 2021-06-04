package co.friend.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.friend.model.Friend;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);

	public static int readInt(String prompt) { // 시그니처 //prompt:명령어 대기 문구
		System.out.print(prompt + ">");
		return readInt(); // 호출

	}

	// 프롬프트 입력받은걸 정수로 변환
	public static int readInt() { // 예외처리
		int result = 0;
		while (true) {
			try {
				String temp = scanner.next();
				result = Integer.parseInt(temp);
				break;
			} catch (Exception e) {
				System.out.println("숫자 형식이 아닙니다.");
			}

		}
		return result;
	}

	// 프롬프트 출력 문자열변환
	public static String readStr(String prompt) {
		System.out.print(prompt);
		System.out.print(">");
		return readStr();
	}

	public static String readStr() {
		String result = "";
		try {
			result = scanner.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 날짜 변경
	public static String readDate() {
		String result = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		do {
			try {
				result = scanner.next();
				df.parse(result.trim()); // trim 공백제거
				break;
			} catch (Exception e) {
				System.out.println("(yyyyMMdd) 날짜 형식이 아닙니다.");
			}
		} while (true);
		return result;
	}
	//Friend 입력
	public static Friend readFriend() {
		System.out.println("구분, 이름, 전화번호 > ");
		String result = scanner.next();
		String[] arr = result.split(",");
		Friend friend = new Friend(arr[0], arr[1], arr[2]); 
//		friend.setGubun(arr[0]);
//		friend.setName(arr[1]);
//		friend.setTel(arr[2]);
		return friend;
	}

}