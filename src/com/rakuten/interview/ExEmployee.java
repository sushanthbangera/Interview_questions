package com.rakuten.interview;

public class ExEmployee extends Employee {

	private int year;

	public ExEmployee(String name, int age, int a, int b, int year) {
		super(name, age, a, b);
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
