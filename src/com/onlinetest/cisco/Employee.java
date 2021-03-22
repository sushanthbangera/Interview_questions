package com.onlinetest.cisco;

/*
 *  No 2 employee should have same Id
 */
public class Employee {

	private int id;

	private String name;

	private boolean male;

	public Employee(int id, String name, boolean male) {
		super();
		this.id = id;
		this.name = name;
		this.male = male;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id; // Since uniqueness is based on Id
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Employee other = (Employee) obj;

		// Since uniqueness is based on Id
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", male=" + male + "]";
	}

}
