package pkg.friend;

import java.util.List;

import pkg.Friend;

public class FriendManager implements FriendAccess {
	Friend[] friends = new Friend[5];

	public FriendManager() {
		friends[0] = new ComponyFriend("예담주식회사","동호","010-2222-1342");
		friends[1] = new SchoolFriend("영남대성악과","대규","010-3333-2424");
		friends[2] = new SchoolFriend("영남대성악과","재훈","010-5555-2424");
		friends[3] = new ComponyFriend("테슬라","일론머스크","010-1343-2415");
		friends[4] = new ComponyFriend("카카오","라이언","010-3673-2324");
	}	
	public void insert(Friend friend) {
		
	}

	@Override
	public void update(Friend friend) {
		
	}

	@Override
	public void delete(String name) {
		
	}

	@Override
	public void selectAll() {
		System.out.println(" FriendManager");
		
	}

	@Override
	public Friend selectOne(Object key) {
		return null;
	}
		
	
	
}
