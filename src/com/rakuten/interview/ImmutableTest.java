package com.rakuten.interview;

public class ImmutableTest {

	public static void main(String[] args) throws CloneNotSupportedException {

		Person emp = new Person(34, "Adithya", new Address("Home", "Madhapur", "Hyderabad"));
		Address address = emp.getAddress();
		System.out.println(address);
		address.setAddress("Hi-tech City");
		address.setAddressType("Office");
		address.setCity("Hyderabad");
		System.out.println(emp.getAddress());
	}
}
