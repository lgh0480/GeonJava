package Wrapper;

import java.util.ArrayList;
import java.util.List;

//1. 기본 데이터형을 객체화
//2. 타입변환
public class WrapperTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(10));
		list.add(new Integer("10")); // Nomal 박싱 
		list.add(100); 				// Interger 객체로 오토박싱
		
		Integer a = 100;
		int b = a.intValue(); //언박싱 
		b = a ;   // 오토 언박싱이오!
		
		String s = Integer.toString(a); // int -> Stirng 으로 변환 
	}

}
