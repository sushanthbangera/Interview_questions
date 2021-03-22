package com.onlinetest.cisco;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBraces {

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		String inputString = scan.nextLine();
		scan.close();

		boolean isBalanced = false;

		/* Enter your code here */
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < inputString.length(); i++) {
			char c = inputString.charAt(i);

			switch (c) {
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;

			case ')':
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					break;
				}
				break;
			case '}':
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					break;
				}
				break;
			case ']':
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					break;
				}
				break;
			}
		}

		isBalanced = stack.isEmpty();

		if (isBalanced) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
	}

	private void isBalanaced() {

	}
}
