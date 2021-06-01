package co.yedam.member;

public class Member {

	String id;
	String password;
	String name;
	int age;
	//생성자
	Member(String id, String password , String name, int age) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + "]";
	}

	
}
