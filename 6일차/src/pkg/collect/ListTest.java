package pkg.collect;

import java.util.ArrayList;
import java.util.LinkedList;

import pkg.Friend;
import pkg.friend.ComponyFriend;
import pkg.friend.SchoolFriend;

public class ListTest {
	public static void main(String[] args) {
		LinkedList<Friend> list = new LinkedList<Friend>();
		list.add(new Friend("현대", "홍", "1111"));
		list.add(0, new ComponyFriend("삼성", "김", "222")); // (0,<-인덱스 위치
		list.add(new SchoolFriend("초등", "박", "333"));
		// 전체조회
		for (Friend f : list) {
			System.out.println(f.getName());
		}
		System.out.println("===========");

		// 삭제
		list.remove(0);
		for (Friend f : list) {
			System.out.println(f.getName());
		}
		Friend fr = list.get(0);// 주어진 인덱스에 저장된 객체 리턴
		System.out.println("첫번째 이름 :" + fr.getName());
		System.out.println(list);

		System.out.println("마지막 이름: " + list.get(list.size() - 1).getName());

		list.set(1, new Friend("중학교", "최", "5555"));
		for (Friend f : list) {
			System.out.println();

		}
	}

}
