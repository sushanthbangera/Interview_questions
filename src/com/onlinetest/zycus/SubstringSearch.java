package com.onlinetest.zycus;

/*
 * Online coding test 15 Nov 2020
 * 
 * Similar: https://leetcode.com/problems/repeated-string-match/
 */
public class SubstringSearch {

	//return 1 if toFind is a substring obtained by concatenation of infStr
	
	// else return 0
	
	/*
	 * Time: O(n) when infStr is single character. n is length of toFind
	 */
	public static int find_string(String infStr, String toFind) {

		StringBuilder str = new StringBuilder(infStr);

		while (str.length() < toFind.length()) {
			str.append(infStr);
		}

		if (str.indexOf(toFind) > -1)
			return 1;

		str.append(infStr);

		if (str.indexOf(toFind) > -1)
			return 1;

		return 0;
	}

	public static void main(String[] args) {

		String a = "abcdf";

		String f = "abce";

		String c = "cdfab";

		System.out.println(find_string(a, f));

		System.out.println(find_string(a, c));
	}
}
