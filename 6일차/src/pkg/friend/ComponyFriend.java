 package pkg.friend;

import pkg.Friend;

public class ComponyFriend extends Friend {
	String duty;
	public ComponyFriend() {
		super(); 
	}
	
	@Override
	public void print() {
		//super.print();
		//System.out.println("duty: " + duty);
		System.out.printf("회사친구 %20s %20s %20s,%20s\n",gubun, name, tel, duty);
	}

	public ComponyFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);
	}
	
	public ComponyFriend(String gubun, String name, String tel, String duty) {
		super(gubun, name, tel);
		this.duty = duty;
	}
	


}
