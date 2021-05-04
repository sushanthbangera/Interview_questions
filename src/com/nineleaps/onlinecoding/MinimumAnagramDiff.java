package com.nineleaps.onlinecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAnagramDiff {
	/*
	 * Complete the 'getMinimumDifference' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. STRING_ARRAY a 2. STRING_ARRAY b
	 */

	public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
		List<Integer> minDiffCounts = new ArrayList<>();

		for (int i = 0; i < a.size(); i++) {
			minDiffCounts.add(findDifference(a.get(i), b.get(i)));
		}

		return minDiffCounts;
	}

	private static int findDifference(String a, String b) {
		int minDiff = -1;

		if (a.length() != b.length()) {
			return minDiff;
		}

		if (isAnagram(a, b)) {
			minDiff = 0;
		} else {
			minDiff = findDiffCount(a, b);
		}

		return minDiff;
	}

	private static boolean isAnagram(String a, String b) {
		char[] arr = a.toCharArray();
		char[] brr = b.toCharArray();

		Arrays.sort(arr);
		Arrays.sort(brr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != brr[i]) {
				return false;
			}
		}
		return true;
	}

	private static int findDiffCount(String a, String b) {

		int freq[] = new int[26];

		for (int i = 0; i < a.length(); i++) {
			freq[a.charAt(i) - 'a']++;
		}

		for (int i = 0; i < b.length(); i++) {
			freq[b.charAt(i) - 'a']--;
		}

		int count = 0;

		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				count += Math.abs(freq[i]);
			}
		}

		return count / 2;
	}
}