package pkg.friend;

import pkg.Friend;

public class AppMain {

	public static void main(String[] args) {
		
		Friend f = new ComponyFriend("학교","홍길동","1111","과장");
		f.print();
		
		Friend f1 = new SchoolFriend("학교","홍길동","1111","1101");
		f1.print();
		
		//FriendAccess manager = new FriendManager();
				//BeanFactory.getBean(FriendAccess.class);
								//new FriendManager();
								//new FriendList();
		//다형성 (상속 오버로딩)
		//1.부모타입의 참조변수가 자식객체를 참조 가능
		//2.메서드 실행하면 참조대상의 메서드가 호출되므로 결과가 다르다.
		FriendManager manager = new FriendManager();
		for(Friend fr :manager.friends) {
			if( fr instanceof SchoolFriend)
			fr.print();
		}
	}

}
