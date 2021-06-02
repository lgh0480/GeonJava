package pkg.friend;

import java.util.ArrayList;
import java.util.List;

import pkg.Friend;

public class FriendList implements FriendAccess {
	List<Friend> friends; //리스트로 색출 
	
	public FriendList() {
		friends = new ArrayList<Friend>();   //인터페이스는 객체 생성 안됨 
	}

	@Override
	public void insert(Friend friend) {
		friends.set(0, friend);
		
	}

	@Override
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		friends.add(friend);
	}

	@Override
	public void delete(String name) {
		friends.remove(0);
		
	}

	//전체조회
	public void selectAll() {
		System.out.println("FriendList");
		for(Friend f: friends) {
			 friends.size();
		}
	}

	@Override
	public Friend selectOne(String name) {
		for(Friend f : friends) {
			if(f.getName().equals(name)) { //contains 
				return f;
			}
		}
		return null;
	}
	
	
}
