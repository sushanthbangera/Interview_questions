package com.interview.linkedin;

import java.util.Stack;

/*
 *  if str = aabcc  k = 2, then op = b
 *  if str = aaabcddd k = 3, then op = bc
 *  if str = aaabcccbbd k = 3, then op = d 
 * 
 */
public class StringCompressor {
	
	

	public String getCompressedString(String str, int k) {
		
		StringBuilder strBuilder = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		int len = 0;
		
		for (char ch : str.toCharArray()) {
			
			if (stack.isEmpty() || stack.peek() == ch) {
				len++;
			} else {
				len = 1;
			}
			
			if (len == k) {
				while (stack.peek() == ch) {
					stack.pop();
				}
				len = 0;
			} else {
				stack.push(ch);
			}
		}
		
		while (!stack.isEmpty()) {
			
			char ch = stack.pop();
			
			
			
			strBuilder.append(stack.pop());
			
		}
		
		return strBuilder.reverse().toString();
	}
	
	public static void main(String[] args) {
		
		String s = "aabbbac";
		int k = 3;
		
		StringCompressor stringCompressor = new StringCompressor();
		System.out.println(stringCompressor.getCompressedString(s, k));
	}
}
