package com.interview.goldmansachs;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {

	public List<Integer> getLongestIncreasingSubSequence() {

		List<Integer> result = new ArrayList<>();

		int arr[] = { 1, 3, 4, 2, 7, 6 }; // (1, 3, 4, 7)

		return result;

	}

	private int auxLengthofLongestIncSubSeq(int arr[], int prevVal, int curPos) {

		if (curPos >= arr.length)
			return 0;

		int include = 0;

		if (arr[curPos] > prevVal) {
			include = 1 + auxLengthofLongestIncSubSeq(arr, arr[curPos], curPos + 1);
		}

		int exclude = auxLengthofLongestIncSubSeq(arr, prevVal, curPos + 1);

		return Math.max(include, exclude);

	}
}
