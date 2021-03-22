package com.onlinetest.cisco;

import java.util.HashSet;
import java.util.Set;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Set<Employee> employeeSet = new HashSet<>();
		
		Employee a = new Employee(1, "Ram", true);
		Employee b = new Employee(1, "Sita", false);
		Employee c = new Employee(3, "Sita", false);
		
		employeeSet.add(a);
		employeeSet.add(b);
		employeeSet.add(c);
		
		System.out.println("employeeSet: " + employeeSet.toString());
	}
}
