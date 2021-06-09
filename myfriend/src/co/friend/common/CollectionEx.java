package co.friend.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Collection ->  (요소 하나하나 값을 인덱스로 처리)List(interface) = ArrayList, Vector, LinkedList 
 *			  ->  (인덱스값을 처리 못하고 중복된값을 처리,허용)set(interface)	-> HashSet , TreeSet 
 */
public class CollectionEx {

	public static void main(String[] args) {
		List<String> list = null;
		// list = new List<String>(); 이렇게 사용 못함
		list = new ArrayList<String>();
		list.add("Hong");
		list.add("Hong");
		list.add("Park");
		list.add("Choi");
		list.remove(0);

		for (String a : list) {
			System.out.println(a);
		}
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}

		Set<String> set = new HashSet<>();
		set.add("Hong");
		set.add("Hong");
		set.add("Park");
		set.add("Choi");
		
	 Iterator<String> iter = set.iterator(); //반복자 rs.next() 이랑 비슷함.
	 while(iter.hasNext()) { //요소 안에 있는지없는지 확인하고
		String value = iter.next(); //iter.next(); 여기에 값을 찾아서 value 쪽에 넣겠습니다. 
		System.out.println(value);
	 }
	 
	}// end of main

} // end of class
