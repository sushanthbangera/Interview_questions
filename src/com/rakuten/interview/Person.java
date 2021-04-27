package com.rakuten.interview;

/*
 *  Make it Immutable
 */
public final class Person {

	private final int id;

	private final String name;

	private final Address address;

	public Person(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() throws CloneNotSupportedException {
		return (Address) address.clone();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
