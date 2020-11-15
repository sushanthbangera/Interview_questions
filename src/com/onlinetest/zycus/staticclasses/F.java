package com.onlinetest.zycus.staticclasses;

public class F extends C {
	
	static {
		System.out.println("I am static F");
	}
	
	class H extends D {

		
	}

	class G extends E {

		int i = 60;
		
		G() {
		 new F();
		}
	}
}
