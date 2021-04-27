package com.wallmart.interview.algo;

/*
 * Given an array check if it can be partitioned into 2 sub arrays of equal sum
 * 
 * Input: [5, 1, 5, 11]  Output: true
 * Input: [1, 2, 3, 5]  Output: false
 */
public class ParitionCheck {

	public boolean canPartition(int arr[]) {

		boolean canPartition = false;

		int totalSum = 0;

		for (int a : arr) {
			totalSum += a;
		}

		int subArraySum = 0;

		for (int i = arr.length - 1; i >= 0; i--) {
			subArraySum += arr[i];
			totalSum -= subArraySum;

			if (subArraySum == totalSum) {
				canPartition = true;
				break;
			}

			if (totalSum < subArraySum) {
				canPartition = false;
				break;
			}

		}
		return canPartition;
	}
}
