package com.onlinetest.zycus.staticclasses;

public class A {

	int i = 10;
	
	static {
		System.out.println("I am static A");
	}

	{
		System.out.println("I am {} A");
	}

	public A() {
		System.out.println("I am parameterised A");
	}

	public A(int i) {
		this.i = i;
		System.out.println("I am parameterised constructor A");
	}

	void function() {
		System.out.println("I am function A");
		this.i = 30;
	}
}
