package com.onlinetest.zycus.staticclasses;

public class C extends B {
	
	static {
		System.out.println("I am static C");
	}
	
	{
		System.out.println("I am {} C");
	}
	

	static class D {

		static int i = 50;
		
		void function () {
			System.out.println("I am a function C.D");
		}
	}

	class E {
		
		
	}
}
