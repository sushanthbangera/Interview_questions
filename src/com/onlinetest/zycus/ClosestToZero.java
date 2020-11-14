package com.onlinetest.zycus;

public class ClosestToZero {

	public static void main(String[] args) {

		int arr1[] = { -1, 3, 4, 5 };
		System.out.println(getClosestToZero(arr1));

		int arr2[] = { -1, 1, 5, 3, 4, 6 };
		System.out.println(getClosestToZero(arr2));

		int arr3[] = { -2, 2, 5, 4, 3 };
		System.out.println(getClosestToZero(arr3));

		int arr4[] = { 1, 6, 4, 5 };
		System.out.println(getClosestToZero(arr4));

	}

	public static int getClosestToZero(int arr[]) {

		int minDiff = Integer.MAX_VALUE;

		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			int curDiff = Math.abs(arr[i] - 0);

			if (curDiff < minDiff) {
				result = arr[i];
				minDiff = curDiff;
			} else if (curDiff == minDiff) {
				result = Math.max(result, arr[i]);
			}
		}

		return result;
	}
}
