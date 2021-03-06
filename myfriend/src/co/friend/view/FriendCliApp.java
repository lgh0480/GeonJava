package co.friend.view;

import java.util.List;

import co.friend.access.FriendAccess;
import co.friend.access.FriendDAO;
import co.friend.model.Friend;
import co.friend.util.ScannerUtil;

public class FriendCliApp {

	//FriendList friendList = new FriendList();
	  FriendAccess friendList = new FriendDAO(); //호출해서 쓰는 인스턴스만 호출 , DB에 값을 불러오기 위한것
	  
	
	public void start() {
		int menunum;
		do {
			menuTitle(); 				//메뉴 출력
			menunum = ScannerUtil.readInt("입력"); //메뉴선택
			switch(menunum) {
			case 1:	insert();	break;
			case 2:	update();	break;
			case 3:	delete();	break;
			case 4:	selectAll();break;
			case 5:	findName();	break;
			case 6:	findTel();	break;
			
			}
		}while (menunum != 0);
	}

	

	private void insert() {
		Friend friend = ScannerUtil.readFriend();
		friendList.insert(friend);
	}

	// 이름으로 검색해서 숮
	private void update() {
		Friend friend = new Friend();
		System.out.print("이름 >");
		friend.setName(ScannerUtil.readStr());
		System.out.print("전화번호 > ");
		friend.setTel(ScannerUtil.readStr());
		friendList.update(friend);
	}

	// 이름으로 검색해서 삭제
	private void delete() {
		System.out.print("삭제할 이름을 적으시오 >");
		String name = ScannerUtil.readStr();
		friendList.delete(name);
	}

	// 이름검색

	private void selectAll() {
		List<Friend> list = friendList.selectAll();
		for (Friend friend : list) {
			System.out.println(friend);
		}
	}
	private void findName() {
		String name = ScannerUtil.readStr();
		Friend friend = friendList.selectOne(name);
		System.out.println(friend);
	}
	private void findTel() {
		String Tel = ScannerUtil.readStr();
		Friend friend = friendList.findTel(Tel);
		System.out.println(friend);
	}
	public void menuTitle() {
		System.out.println("|=  친구 관리	 ==|");
		System.out.println("|1. 친구추가	 ==|");
		System.out.println("|2. 친구수정	 ==|");
		System.out.println("|3. 친구삭제	 ==|");
		System.out.println("|4. 전체조회	 ==|");
		System.out.println("|5. 이름으로조회 ==|");
		System.out.println("|6. 전화번호로조회=|");
		System.out.println("|0. 종료===========|");
		
	}
}