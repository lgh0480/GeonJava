package co.memo.view;

import java.util.List;

import co.memo.access.MemoList;
import co.memo.model.Memo;
import co.memo.util.ScannerUtil;



public class MemoCliApp {

	MemoList memoList = new MemoList();

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
			case 5:	findDate();	break;
			case 6:	findContent();	break;
			
			}
		}while (menunum != 0);
	}

	

	private void insert() {
		Memo memo = ScannerUtil.readMemo();
		memoList.insert(memo);
	}

	// 이름 수정
	private void update() {
		Memo memo = new Memo();
		memo.setDate(ScannerUtil.readDate());
		memo.setContent(ScannerUtil.readStr());
		memoList.update(memo);
	}

	// 날짜 찾아서 메모삭제 
	private void delete() {
		String date = ScannerUtil.readDate();
		memoList.delete(date);
	}

	// 이름검색

	private void selectAll() {
		List<Memo> list = memoList.selectAll();
		for (Memo date : list) {
			System.out.println(date);
		}
	}
	private void findDate() {
		String date = ScannerUtil.readDate();
		Memo memo = memoList.selectOne(date);
		System.out.println(memo);
	}
	private void findContent() {
		String content = ScannerUtil.readStr();
		Memo friend = memoList.findContent(content);
		System.out.println(friend);
	}
	public void menuTitle() {
		System.out.println("|=  메모 관리	 ==|");
		System.out.println("|1. 메모추가	 ==|");
		System.out.println("|2. 메모수정	 ==|");
		System.out.println("|3. 메모삭제	 ==|");
		System.out.println("|4. 메모전체조회 ==|");
		System.out.println("|5. 날짜검색	 ==|");
		System.out.println("|6. 내용검색	  =|");
		System.out.println("|0. 종료===========|");
		
	}
}