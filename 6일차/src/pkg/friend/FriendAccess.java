package pkg.friend;

import java.util.List;

import pkg.Friend;
/**
 * 
 *인터페이스 : 상수필드 + 추상메서드
 *상수필드: public static final
 *메서드 :public abstract
 */
//친구데이터를 개발 시 표준을 정해줌.
public interface FriendAccess {
	//원래는 public static final이 들어가있다. 생략가능한것이지요.
	String model ="ddd";
	
	//void insert(Friend friend); //->이것이 추상
	
	//등록
	public void insert(Friend friend); //인서트해서 프렌드에 
	//수정
	public void update(Friend friend);
	//삭제
	public void delete(String name);
	//전체조회
	public void selectAll();
	//단건조회
	public Friend selectOne(String name);
}
