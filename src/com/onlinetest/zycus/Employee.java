package com.onlinetest.zycus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/*
 *  Online coding test 15 Nov 2020
 */
public class Employee {

	String name;
	double salary;
	Integer id;
	String designation;
	String InsuranceScheme;

	public Employee(String name, double salary, Integer id, String designation) {
		// parameterized constructor
		this.name = name;
		this.salary = salary;
		this.id = id;
		this.designation = designation;
		this.InsuranceScheme = getInsuranceScheme(this.salary);
	}

	public String getInsuranceScheme(double salary) {
		/*
		 * write your code here to return the scheme on the basis of salary if nothing
		 * falls in the range return null
		 */
		String insuranceScheme = null;
		if (salary >= 5000 && salary < 20000) {
			insuranceScheme = "scheme c";
		} else if (salary >= 20000 && salary < 40000) {
			insuranceScheme = "scheme b";
		} else if (salary >= 40000) {
			insuranceScheme = "scheme a";
		} else {
			insuranceScheme = "no scheme";
		}
		return insuranceScheme;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	public String getInsuranceScheme() {
		return InsuranceScheme;
	}
	
	public static void main(String[] args) {
		Employee a = new Employee("A", 5000.00, 23, "Clerk");
		Employee b = new Employee("B", 20000.00, 53, "System Analyst");
		Employee c = new Employee("C", 25000.00, 03, "System Associaute");

		EmployeeServiceImpl.addEmployee(a);
		EmployeeServiceImpl.addEmployee(b);
		EmployeeServiceImpl.addEmployee(c);
		
		EmployeeServiceImpl.deleteEmployee(23);

		System.out.println(EmployeeServiceImpl.showEmpDetails("scheme b"));
	}

}

/*
 * Name: B Salary: 20000.0 Designation: Clerk InsuranceScheme: scheme b
Name: A Salary: 5000.0 Designation: Clerk InsuranceScheme: scheme c
Name: name Id: id Salary: salary Designation: Designation InsuranceScheme: InsuranceScheme

 */
class EmployeeServiceImpl {
	// Declare a Hashmap here where key is an Integer and the value is Employee
	// object
	private static Map<Integer, Employee> employeeMap = new HashMap<>();

	public static void addEmployee(Employee emp) {
		// write your code here to add employee to the hashmap
		employeeMap.put(emp.getId(), emp);
	}

	public static boolean deleteEmployee(int id) {
		// write your code here for returning true if the employee deleted wrt the id
		// passed else false
		if (employeeMap.containsKey(id)) {
			employeeMap.remove(id);
			return true;
		}
		return false;

	}

	public static String showEmpDetails(String InsuranceScheme) {
		/*
		 * Write your code here to return a string i.e the employee details according to
		 * the insurance scheme Format: Name: name Id: id Salary: salary Designation:
		 * Designation InsuranceScheme: InsuranceScheme If multiple results they should
		 * be in a different line
		 */
		Map<Integer, Employee> insuranceEmployeeMap = employeeMap.entrySet().stream()
				.filter(item -> item.getValue().InsuranceScheme.equals(InsuranceScheme))
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

		StringBuilder empStrBuilder = new StringBuilder();

		insuranceEmployeeMap.entrySet().forEach(emp -> {
			empStrBuilder.append("Name: ").append(emp.getValue().getName());
			empStrBuilder.append(" Id: ").append(emp.getValue().getId());
			empStrBuilder.append(" Salary: ").append(emp.getValue().getSalary());
			empStrBuilder.append(" Designation: ").append(emp.getValue().getDesignation());
			empStrBuilder.append(" InsuranceScheme: ").append(emp.getValue().getInsuranceScheme());
			empStrBuilder.append(System.lineSeparator());
		});

		// to remove the last line separator from the builder
		return empStrBuilder.toString().substring(0, empStrBuilder.length() - 1);
	}

}
