package com.onlinetest.zycus.staticclasses;

public class B extends A {

	static int i = 20;
	
	static {
		System.out.println("I am static B");
	}
	
	{
		System.out.println("I am {} B");
		
	}
	
	public B() {
		super(i);
		System.out.println("I am constructor B");
	}
	
	public B(int i) {
		System.out.println("I am parameterised constructor A");
	}

}
