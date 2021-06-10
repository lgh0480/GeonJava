package com.yedam.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.yedam.Person;
import com.yedam.PersonDAO;

public class IteratorExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hong","Park","Choi");
		Iterator<String> iter = list.iterator(); // 반복된 요소를 지정 사용하기위한 반복자.
		while(iter.hasNext()) {
		String val = iter.next(); // String 타입의 변수에다가 담을수 있음.
		System.out.println(val.toUpperCase().length()); //toUpperCase -> 대문자로 출력
		}
	
		// stream 사용 		stream =forEach는 Java8에서 추가된 메소드이며, List, Map 등을 순회(Iterate)하는데 된다.
		Stream<String> stream = list.stream();
		stream.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		});   	//forEach(기능) function  값이 아닌 기능이 들어온다.
				//Consumer는 1개의 인자를 받고 리턴 값이 없는 함수형 인터페이스입니다.
	
		
		// sample 요소를 database에서 갖고 오도록 한다.
		PersonDAO dao = new PersonDAO();
		List<Person> persons = dao.getPersonList();
		Stream<Person> pStream = persons.stream();
		long cnt = pStream
												// .filter는 요소를 특정 기준으로 걸러낼 수 있습니다.
		.filter((Person t) -> t.getAge() > 20) //return 값이 참인 요소들만 통과 (20살 이상인것들만 통과)
		.filter((t) -> t.getName().startsWith("이")) //이씨만 대꼬 옵니다.
 		//.forEach( (t) -> System.out.println(t.toString())); // 람다식으로 변환 
		.count(); //자바스크립트에서 졸라라라라라 많이 쓴당~
		System.out.println("최종처리 건수 : " + cnt+"건 입니다.");
	

	}// end of main

} // end of Class
