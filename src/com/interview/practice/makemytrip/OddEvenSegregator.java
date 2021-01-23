package com.interview.practice.makemytrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * input: arr[] = {8, 22, 65, 70, 33, 60, 2, 34, 43, 21} 
Output: {8, 22, 70, 60, 2, 34, 65, 33, 43, 21} 

Input: arr[] = {18, 52, 37, 70, 3, 63, 2, 34} 
Output: {18, 52, 70, 2, 34, 37, 3, 63} 
 */
public class OddEvenSegregator {

	public static void main(String[] args) {
		OddEvenSegregator oe = new OddEvenSegregator();

		int[] arr = { 8, 22, 65, 70, 33, 60, 2, 34, 43, 21 };
		oe.segregate(arr);

		int[] arr2 = { 8, 22, 65, 70, 33, 60, 2, 34, 43, 21 };
		oe.segregate2(arr2);
	}

	/*
	 * doesn't take care of the order
	 */
	public void segregate(int arr[]) {

		int left = 0;

		int right = arr.length - 1;

		while (left < right) {

			while (left < right && arr[left] % 2 == 0) {
				left++;
			}

			while (left < right && arr[right] % 2 == 1) {
				right--;
			}

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public void segregate2(int arr[]) {

		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				even.add(arr[i]);
			} else {
				odd.add(arr[i]);
			}
		}

		int k;

		for (k = 0; k < even.size(); k++) {
			arr[k] = even.get(k);
		}

		for (int l = 0; l < odd.size(); l++) {
			arr[k] = odd.get(l);
			k++;
		}

		System.out.println(Arrays.toString(arr));
	}
}
