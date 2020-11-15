package com.onlinetest.zycus.inheritence;

/*
 *  Online coding test 15 Nov 2020
 */
public class InheriteceTest {

	public static void main(String[] args) {

		System.out.println("__________________1");
		A a = new F();
		
		System.out.println("__________________2");
		a.function();
		
		System.out.println("__________________3");
		System.out.println(a.i);
		
		System.out.println("__________________4");
		a = new A();
		
		System.out.println("__________________5");
		System.out.println(a.i);
		
		System.out.println("__________________6");
		System.out.println(B.i);
		
		System.out.println("__________________7");
		System.out.println(C.D.i);
		
		System.out.println("__________________8");
		F f = new F();
		
		System.out.println("__________________9");
		F.H b = f.new H();
		
		System.out.println("__________________10");
		b.function();
		
		System.out.println("__________________11");
		F.G c = f.new G();
		
		System.out.println("__________________12");
		System.out.println(c.i);
		
		System.out.println("__________________13");
	}
	
/*
 * 
Had to create the classes to get the below output
* __________________1
I am static A
I am static B
I am static C
I am static F
I am {} A
I am parameterised constructor A
I am {} B
I am constructor B
I am {} C
__________________2
I am function A
__________________3
30
__________________4
I am {} A
I am parameterised A
__________________5
10
__________________6
20
__________________7
50
__________________8
I am {} A
I am parameterised constructor A
I am {} B
I am constructor B
I am {} C
__________________9
__________________10
I am function C.D
__________________11
I am {} A
I am parameterised constructor A
I am {} B
I am constructor B
I am {} C
__________________12
60
__________________13
	 */
}
