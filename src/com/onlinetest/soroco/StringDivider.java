package com.onlinetest.soroco;


/*
 *  String s = "bcdbcdbcdbcd"
 *  String t = "bcdbcd"
 *  
 *  Output: 3
 *  
 *  String t on appending becomes s, which means t divides s
 *  From the String t "bcdbcd" the smallest divisor is "bcd" which is of length 3
 * 
 */
public class StringDivider {

	public static int findSmallestDivisor(String s, String t) {
		StringBuilder str = new StringBuilder(t);
		boolean isDivisible = false;
		int strLen = 0;

		while (str.length() <= s.length()) {
			if (s.equals(str.toString())) {
				isDivisible = true;
				break;
			}
			str.append(t);
		}

		if (isDivisible) {
			strLen = getRepeatingStringLength(t);
			strLen = strLen > 0 ? strLen : t.length();
		} else {
			strLen = -1;
		}

		return strLen;
	}

	private static int getRepeatingStringLength(String input) {

		int n = input.length();

		for (int i = 0; i < n; i++) {

			if (i == n - 1) {
				return -1;
			} else if (n % (i + 1) == 0) { // sub String should divide the string equally
				int size = i + 1;

				// String size should be same for comparison
				if (input.substring(0, i + 1).equals(input.substring(i + 1, i + 1 + size))) {
					return input.substring(0, i + 1).length();
				}
			}
		}

		return -1;
	}
}
