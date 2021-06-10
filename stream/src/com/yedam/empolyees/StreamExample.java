package com.yedam.empolyees;

import java.util.List;

public class StreamExample {
	public static void main(String[] args) {
		List<Employees> list = null;
		EmployeeDAO dao = new EmployeeDAO();
		list = dao.getEmployeeList();
		

	}
}
