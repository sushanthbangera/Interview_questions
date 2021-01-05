package com.onlinetest.athenahealth;

import java.util.Stack;

public class BracketBalanceCheck {

	public static void main(String[] args) {

		String values[] = { "{}[]()", "{[}]}" };
		String[] res = braces(values);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	private final static String YES = "YES";
	private final static String NO = "NO";

	// Complete the braces function below.
	static String[] braces(String[] values) {

		String[] result = new String[values.length];

		for (int i = 0; i < values.length; i++) {
			result[i] = isBalanced2(values[i]) ? YES : NO;
		}

		return result;
	}

	static boolean isBalanced(String value) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);

			switch (ch) {
			case '{':
			case '[':
			case '(':
				stack.push(ch);
				break;

			case '}':
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
				break;
			case ']':
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
				break;
			case ')':
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}

	static boolean isBalanced2(String value) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);

			if (ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty() && isMatch(ch, stack.peek())) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	private static boolean isMatch(Character curBracket, Character topBracket) {
		boolean isMatch = false;
		switch(curBracket) {
		case '}':
			if (topBracket == '{') {
				isMatch = true;
			}
			break;
		case ']':
			if (topBracket == '[') {
				isMatch = true;
			}
			break;
		case ')':
			if (topBracket == '(') {
				isMatch = true;
			}
			break;
		}
		return isMatch;
	}
}
