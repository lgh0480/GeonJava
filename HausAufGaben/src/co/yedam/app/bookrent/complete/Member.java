1package co.yedam.app.bookrent.complete;

public class Member {
	String name;
	String phone;

	public Member() {
	}

	public Member(String name, String phone) {
		this.name = name;
		this.phone = phone;

	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", phone=" + phone + "]";
	}
}
