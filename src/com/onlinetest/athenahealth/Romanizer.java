package com.onlinetest.athenahealth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Online coding test question - 1
 */
public class Romanizer {

	private final static String[] thousand = new String[] { "", "M", "MM", "MMM"};
	private final static String[] hundreds = new String[] { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC",
			"CM" };
	private final static String[] tens = new String[] { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	private final static String[] units = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

	public static void main(String[] args) throws IOException {
		Integer value = 3999;
		System.out.println(romanize(value));
		System.out.println(romanize2(value));
	}

	public static List<String> romanizer(List<Integer> numbers) {
		List<String> result = new ArrayList<>();

		numbers.forEach(num -> {
			result.add(romanize(num));
		});
		return result;
	}

	private static String romanize(Integer number) {
		StringBuilder romanStringBuilder = new StringBuilder();

		romanStringBuilder.append(thousand[number / 1000]);
		romanStringBuilder.append(hundreds[(number % 1000) / 100]);
		romanStringBuilder.append(tens[(number % 100) / 10]);
		romanStringBuilder.append(units[number % 10]);

		return romanStringBuilder.toString();
	}

	private final static String[] roman = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
			"IV", "I" };

	private final static int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	private static String romanize2(Integer number) {

		StringBuilder romanStringBuilder = new StringBuilder();

		int i = 0;

		while (number > 0) {
			while (number >= nums[i]) {
				number -= nums[i];
				romanStringBuilder.append(roman[i]);
			}
			i++;
		}
		return romanStringBuilder.toString();
	}
}
