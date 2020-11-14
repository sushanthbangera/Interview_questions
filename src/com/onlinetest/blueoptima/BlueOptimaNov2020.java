package com.onlinetest.blueoptima;

/*
 * You are given a number n. Find the decimal value of the number formed by the concatenation of the binary representation of the first n positive integers. Print the answer 10^9 + 7.
 
Output format: Print the answer modulo 10^9 + 7
Constraint: 1 <= n <= 10^9

Sample input: 3 Sample Output: 27 The binary representation of 1: 1 The binary representation of 2: 10 The binary representation of 3: 11 Concatenated string: 11011 -> Decimal representation is 27.

 */
public class BlueOptimaNov2020 {

	static long FindBigNum(long n) {
		long result = 0;
		StringBuilder binary = new StringBuilder();
		long binarySumLong;
		long moduloFactor = (long) (Math.pow(10, 9) + 7);

		for (int number = 1; number <= n; number++) {
			binary.append(Long.toBinaryString(number));
			binarySumLong = toInt(binary.toString());

			if (binarySumLong > (moduloFactor)) {
				binarySumLong = binarySumLong % (moduloFactor);
				binary = new StringBuilder(Long.toBinaryString(binarySumLong));
			}
		}
		result = toInt(binary.toString());
		return result;
	}

	public static long binaryToInteger(String binary) {
		char[] numbers = binary.toCharArray();
		long result = 0;
		for (int i = numbers.length - 1; i >= 0; i--)
			if (numbers[i] == '1')
				result += Math.pow(2, (numbers.length - i - 1));
		return result;
	}

	public static long toInt(String binary) {
		long decimal = 0;
		int len = binary.length();
		for (int pow = (binary.length() - 1); pow > -1; pow--) {
			if (binary.charAt(pow) == '1') {
				decimal += 1L << (len - pow - 1);
			}
		}
		return decimal;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long output = FindBigNum((long) Math.pow(10, 4));
		long endTime = System.currentTimeMillis();

		System.out.println("Tine taken is : " + (endTime - startTime));
		System.out.println("output is : " + output);

		startTime = System.currentTimeMillis();
		output = FindBigNum(12345);
	    endTime = System.currentTimeMillis();

		System.out.println("Tine taken is : " + (endTime - startTime));
		System.out.println("output is : " + output);
	}
}
