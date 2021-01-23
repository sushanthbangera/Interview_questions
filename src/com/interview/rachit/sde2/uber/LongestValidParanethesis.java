package com.interview.rachit.sde2.uber;

import java.util.Stack;

/*
 *  Given s string containing characters '(' and ')', find the length of the longest
 *  valid (well-formed) paranthesis substring
 *  
 *  ip: (()  ->  op:  2
 *  ip: )()())  ->   op: 4
 */
public class LongestValidParanethesis {

	public int getLongestValidParanthesisLength(String str) {
		
		Stack<Character> stack = new Stack<>();
		int len = 0;
		
		for (Character ch : str.toCharArray()) {
			
			if (stack.isEmpty()) {
				stack.push(ch);
			} else if (ch == ')' && stack.peek() == '(') {
				stack.pop();
				len += 2;
			} else if (ch == '(' && stack.peek() == ')') {
				stack.pop();
				stack.push(ch);
			} else {
				stack.push(ch);
			}
		}
		System.out.println(stack.toString());
		return len;
	}
	
	public static void main(String[] args) {
		
		LongestValidParanethesis lvp = new LongestValidParanethesis();
		System.out.println("len: " + lvp.getLongestValidParanthesisLength("("));
		System.out.println("len: " + lvp.getLongestValidParanthesisLength("(()()"));
		System.out.println("len: " + lvp.getLongestValidParanthesisLength(")()()"));
		System.out.println("len: " + lvp.getLongestValidParanthesisLength("(())"));
	}
}
