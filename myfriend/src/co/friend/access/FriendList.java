package co.friend.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.friend.model.Friend;

public class FriendList implements FriendAccess {
	ArrayList<Friend> friends; // 리스트로 색출
	String path = "d:/temp/friend.txt"; //저장할 타입
	public void open() {
		try {
			Scanner scanner =new Scanner(new File(path));
			while(true) {
				if(! scanner.hasNext()) break;
				String str = scanner.next();
				String[] arr = str.split(",");
				friends.add(new Friend(arr[0],arr[1],arr[2]));
			}
			scanner.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for(Friend f : friends) {
				fw.write(String.format("%s,%s,%s\n", f.getGubun(),
													 f.getName(),
													 f.getTel()));
			}
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public FriendList() {
		friends = new ArrayList<Friend>(); // 인터페이스는 객체 생성 안됨
		open(); // 파일 정보를 읽어서 리스트에 추가함
	}

	// 삽입
	public void insert(Friend friend) {
		friends.add(friend);
		save();
	}

	//수정
	public void update(Friend friend) {
		for (Friend f : friends) {
			if (f.getName().equals(friend.getName())) {
				f.setTel(friend.getTel());
				save();
			}
		}
	}

	//삭제
	public void delete(String name) {
		for (Friend f : friends) {
			if (f.getName().equals(name)) { //
				friends.remove(f);
				save();
				break;
			}

		}
	}

	// 전체조회
	public ArrayList<Friend> selectAll() {
		return friends;
	}

	@Override
	public Friend selectOne(String name) {
		for (Friend f : friends) {
			if (f.getName().equals(name)) { // contains
				return f;
			}
		}
		return null;
	}
	public Friend findTel(String Tel) {
		for (Friend f : friends) {
			if (f.getTel().contains(Tel)) { // contains: Tel안에 많은 글자중 한개라도 포함되어있으면 사용가능
				return f;
			}
		}
		return null;
	}	
}
