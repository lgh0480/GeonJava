package co.yedam.member;

import java.util.Scanner;

/*
 * 로그인 메서드와 login(id, pw), id가 hong 이고 pw=12345
 * 	logout(id) :"로그아웃"되었다고만 출력
 * 	if (id.equals("hong")
 */
public class MemberService {
	Member[] members = new Member[10];
	int cnt = 0;
	Scanner scanner = new Scanner(System.in);

	// 회원가입
	void insert(String id, String password, String name, int age) {
		// members[cnt++] = new Member(id, password, name, age);
	}

	void insert() {
		String id = scanner.next();
		String password = scanner.next();
		String name = scanner.next();
		int age = scanner.nextInt();
		members[cnt] = new Member(id, password, name, age);
		cnt++;
	}

	// 회원리스트
	void printList() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(members[i]);
			for (int i = 0; i < empNum; i++) {
				System.out.print(i + "\t");
				System.out.print(employees[i].employeeId + "\t");
				System.out.print(employees[i].name + "\t");
				System.out.print(employees[i].departmentId + "\t");
				System.out.print(employees[i].salary + "\t");
				System.out.println(employees[i].email + "\t");
			
		}

	}
	void printMember(int i) {
		System.out.println(members[i].id);
		System.out.println(members[i].name);

		System.out.println(members[i].age);

	}

	void search() {
		int num;
		System.out.print(" 번호입력하시오: ");
		num = scanner.nextInt();
		for (int i = 0; i < cnt; i++) {
			if(num == i) {
				printMember(num);
			
			}
		}

	}
	void Idsearch() {
		String numId;
		System.out.print("조회할 id를 입력하시오: ");
		numId = i
	}

	boolean login(String id, String num) {
		boolean result = false;
		for (int i = 0; i < cnt; i++) {
			if (id.equals(members[i].id) && num.equals(members[i].password)) {
				result = true;
				break;
			}
		}
		return result;
	}

	void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
