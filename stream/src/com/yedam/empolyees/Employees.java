package com.yedam.empolyees;

public class Employees {
	private String lastname;
	private String firstname;
	private String Title;
	private String birthdate;
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "employees [lastname=" + lastname + ", firstname=" + firstname + ", Title=" + Title + ", birthdate="
				+ birthdate + "]";
	}
	
	
}
