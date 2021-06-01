package co.yedam.emp;

public class EmployeeExample {

	public static void main(String[] args) {
		//사번 :100 이름: 홍길동 초기화
	Employee emp0 = new Employee();
	System.out.println(emp0);
		
	Employee emp1 = new Employee(100,"홍길동");
	System.out.println(emp1);
	
	// 사번:101,이름:김유신, 이메일:a@a.c 초기화
	Employee emp2 = new Employee(101,"김유신","a@a.c"); 
	System.out.println(emp2);
	
	Employee emp3 = new Employee(102,"유관순", 2500);
	System.out.println(emp3);
	
	Employee emp4 = new Employee(103,"이건희",10,2800,"lgh0480@gmail.com");
	System.out.println(emp4);
	
	

	
	//모든 필드를 초기화
	}
	

}
