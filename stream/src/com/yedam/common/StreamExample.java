package com.yedam.common;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.yedam.Person;
import com.yedam.PersonDAO;

public class StreamExample {

	public static void main(String[] args) {
		//1.스트림 2.중간처리/최정처리 3.결과.
		List<Person> list = null;
		PersonDAO dao = new PersonDAO();
		list = dao.getPersonList();
		OptionalDouble avg  = list.stream() // 스트림생성.
		.filter((Person t) -> t.getAge()% 2 == 0) //중간처리 람다식.
		//.filter(t -> t.getId() > 900)
		.mapToInt((Person p) -> p.getAge())			//매핑 a -> b
		.average(); //나이평균
		if(avg.isPresent()){
			System.out.println("평균나이:" + avg.getAsDouble()); //Optional 더블타입을 그냥 더블타입으로 주겠다.
		} else {
			System.out.println("만족하는 요소가 없습니다.");
			
		}
		
		
		//.forEach(v -> System.out.println(v));
		
//		.filter(new Predicate<Person>() { //기본 방식
//
//			@Override
//			public boolean test(Person t) {
//				return t.getAge()%2==0;
//			}} )
		
	}

}
