package com.ai24_7.interview;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	static void printPermutn(String str, String ans, List<String> result) {

		// If string is empty
		if (str.length() == 0) {
			result.add(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// Recurvise call
			printPermutn(ros, ans + ch, result);
		}
	}

	public static void main(String[] args) {

		String s = "abc";
		List<String> result = new ArrayList<>();
		printPermutn(s, "", result);

		System.out.println(result);
	}
}
