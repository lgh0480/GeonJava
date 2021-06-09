package co.friend.common;

import java.util.Map;
import java.util.Set;

import co.friend.access.FriendDAO;

public class CollectionEx4 {

	public static void main(String[] args) {
		// 이름과 연락처 구현하세요.
		FriendDAO dao = new FriendDAO();
		Map<String,String> map =dao.getNmaeTel();
		Set<String> keys =	map.keySet();
		for(String s :keys) {
			System.out.println(s+"," + map.get(s));
		}
	}

}
