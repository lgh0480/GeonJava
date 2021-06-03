package 클래스;

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

	@Override
	public boolean equals(Object obj) {
		Member
		s = (Member)obj;
		return this.id.equals(s.id) && this.name.equals(s.name);
	
//		Member m = (Member)obj;
//		return m.id == this.id && m.name == this.name;
	}

	
}
