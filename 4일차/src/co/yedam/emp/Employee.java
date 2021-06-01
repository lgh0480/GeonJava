package co.yedam.emp;

//사원정보 
public class Employee {
	int employeeId; // 사번
	String name; // 이름
	int departmentId; // 부서번호
	String departmentName; // 10:인사 20:개발 30:영업(기본값
	int salary; // 급여
	String email; // 이메일
	// 기본생성자

	Employee() {
		this(0,null,0,0,null);
	}

	Employee(int employeeId, String name) {
		this(employeeId,name, 0 ,0," ");

	}

	Employee(int employeeId, String name, String email) {
		this(employeeId, name ,0,0,"");
	}

	Employee(int employeeId, String name, int salary) {
		this(employeeId, name, 0, 2500,"");
	}
	

	public Employee(int employeeId, String name, int departmentId, int salary, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.email = email;
		
		
		if (departmentId == 0) {
			departmentId = 30;
		}
			
		this.departmentId = departmentId; //필드에 담아 버림 위에서.

		if (departmentId == 10) {
			this.departmentName = "인사";

		} else if (departmentId == 20) {
			this.departmentName = "개발";

		} else if(departmentId ==30) {
			this.departmentName = "영업";
		}
		this.departmentId = departmentId;
		
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", salary=" + salary + ", email=" + email + "]";
	}

	

}