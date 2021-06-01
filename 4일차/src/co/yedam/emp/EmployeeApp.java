package co.yedam.emp;

import java.util.Scanner;

import co.yedam.member.Member;

public class EmployeeApp {

	int empNum;
	Employee[] arr; // arr는 Employee이라는 존재하는 배열.

	Scanner scanner = new Scanner(System.in);

	EmployeeApp() {

	}

	void init() {

		System.out.println("인원수 > ");
		empNum = scanner.nextInt();
		arr = new Employee[empNum]; // 새로 객체 생성 arr쪽으로.
	}

	void input() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print("사번 > ");
			int employeeId = scanner.nextInt();
			System.out.print("이름 > ");
			String name = scanner.next();
			System.out.print("부서번호 > ");
			int departmentId = scanner.nextInt();
			System.out.println("급여 > ");
			int salary = scanner.nextInt();
			System.out.println("이메일 > ");
			String email = scanner.next();
			arr[i] = new Employee(employeeId, name, departmentId, salary, email);
			// Employee에 선언된 생성자를 호출해서 사용
		}

	}

	// 사원 정보 입력
	void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + "\t");
			System.out.print(arr[i].employeeId + "\t");
			System.out.print(arr[i].name + "\t");
			System.out.print(arr[i].departmentId + "\t");
			System.out.print(arr[i].salary + "\t");
			System.out.println(arr[i].email + "\t");

		}
	}

	String search(int id) {
		String result; 
		for (Employee i : arr) {
			 
			
		}
		return result;
	}
}