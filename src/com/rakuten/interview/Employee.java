package com.rakuten.interview;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable {

	private String name;

	private int age;

	// Default constructor
	public Employee(String name, int age, int a, int b) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

	/*
	 * To prevent the child class from being serialized write Object and readObject
	 * methods are implemented in parent class
	 * 
	 */
	private void writeObject(ObjectOutputStream objOs) throws IOException {
		throw new NotSerializableException();
	}

	private void readObject(ObjectInputStream ois) throws IOException {
		throw new NotSerializableException();
	}
}
