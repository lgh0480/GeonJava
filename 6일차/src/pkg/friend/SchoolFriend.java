package pkg.friend;

import pkg.Friend;

public class SchoolFriend extends Friend {
	String birth;
	public SchoolFriend( ) {
		super();		
	}
	@Override
	public void print() {
		//super.print();
		//System.out.println("birth :" + birth);
		System.out.printf("학교친구 %20s %20s %20s,%20s\n",gubun, name, tel, birth);
	}
	public SchoolFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);
	}

	public SchoolFriend(String gubun, String name, String tel, String birth) {
		super(gubun, name, tel);
		this.birth = birth;
	}

}
