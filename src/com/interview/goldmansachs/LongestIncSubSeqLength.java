package com.interview.goldmansachs;

public class LongestIncSubSeqLength {

	public int lengthOfLongestIncreasingSubSequence(int arr[]) {
		if (arr == null && arr.length == 0)
			return 0;

		return auxLengthofLongestIncSubSeq(arr, Integer.MIN_VALUE, 0);
	}

	private int auxLengthofLongestIncSubSeq(int arr[], int prevVal, int curPos) {

		if (curPos == arr.length)
			return 0;

		int include = 0;

		if (arr[curPos] > prevVal) {
			include = 1 + auxLengthofLongestIncSubSeq(arr, arr[curPos], curPos + 1);
		}

		int exclude = auxLengthofLongestIncSubSeq(arr, prevVal, curPos + 1);

		return Math.max(include, exclude);
	}

	public int lengthOfLongestIncreasingSubSequence2(int arr[]) {
		if (arr == null || arr.length == 0)
			return 0;

		int dp[][] = new int[arr.length + 1][arr.length];

		return lengthofLongestIncSubSeqMemo(arr, -1, 0, dp);
	}

	private int lengthofLongestIncSubSeqMemo(int arr[], int prevIndex, int curIndex, int dp[][]) {

		if (curIndex == arr.length)
			return 0;

		if (dp[prevIndex + 1][curIndex] >= 0) {
			return dp[prevIndex + 1][curIndex];
		}

		int include = 0;

		if (prevIndex < 0 || arr[prevIndex] < arr[curIndex]) {
			include = 1 + lengthofLongestIncSubSeqMemo(arr, curIndex, curIndex + 1, dp);
		}

		int exclude = lengthofLongestIncSubSeqMemo(arr, prevIndex, curIndex + 1, dp);
		dp[prevIndex + 1][curIndex] = Math.max(include, exclude);

		return dp[prevIndex + 1][curIndex];
	}
	
	
	public int lenOfLISDp(int arr[]) {
		
		if (arr == null || arr.length == 0) return 0;
		
		int dp[] = new int[arr.length];
		
		int tempLen = 0; int maxLen = 1;
		
		dp[0] = 1;
		
		for (int i = 1; i < arr.length; i++) {

			tempLen = 0;
			
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					tempLen = Math.max(tempLen, dp[j]);
				}
			}
			dp[i] = tempLen + 1; // including the current position
			maxLen = Math.max(maxLen, dp[i]);
		}
		return maxLen;
	}
	
	
}
