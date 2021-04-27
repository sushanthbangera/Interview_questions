package com.ezetap.onlinetest;

/*
 *  the number of 1s and 0s in the binary String should be same
 *  
 *  the prefix should have atleast the same number of 1s as 0s in the right
 */
public class MagicBinary {

	public void magicBinary(String binary) {

		boolean isValidPrefix = true;
		int zeroCount = 0;
		int oneCount = 0;

		int len = binary.length();

		for (int i = 0; i < len; i++) {

			if (binary.charAt(i) == '0') {
				zeroCount++;
			} else {
				oneCount++;
			}

			if (zeroCount > oneCount) {
				isValidPrefix = false;
			}
		}

		System.out.println(zeroCount == oneCount && isValidPrefix);
	}
}
