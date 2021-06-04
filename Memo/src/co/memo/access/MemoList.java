package co.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


import co.memo.model.Memo;

//구현클래스
public class MemoList implements MemoAccess {
	ArrayList<Memo> memos; // 리스트로 색출
	String path = "d:/temp/memo.txt";

	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while (true) {
				if (!scanner.hasNext())
					break;
				String str = scanner.next();
				String[] arr = str.split(",");
				memos.add(new Memo(arr[0], arr[1]));
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for (Memo f : memos) {
				fw.write(String.format("%s,%s\n", f.getDate(), f.getContent()));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemoList() {
		memos = new ArrayList<Memo>();
		open();
	}

	// 등록
	public void insert(Memo memo) {
		memos.add(memo);
		save();
	}

	// 수정
	public void update(Memo memo) {
		for (Memo m : memos) {
			if (m.getDate().equals(memo.getDate())) {
				m.setContent(memo.getContent());
				save();
			}
		}
	}

	// 삭제
	public void delete(String date) { 
		for (Memo m : memos) {
			if (m.getDate().equals(date)) { //
				memos.remove(m);
				save();
				break;
			}
		}
	}
	// 메모전체조회
	public ArrayList<Memo> selectAll(){
		return memos;
	}
		
	// 날짜검색
	public Memo selectOne(String date)	{
		for (Memo  m : memos) {
			if (m.getDate().equals(date)) { // contains
				return m;
			}
		}
		return null;
	}

	// 내용검색
	public Memo findContent(String content) {
		for(Memo m: memos) {
			if(m.getContent().contains(content)) { //contains
				return m;
			}
		}
		return null;
	}

}
