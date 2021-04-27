package com.ezetap.interview;

import java.util.Arrays;

/*
 * 
 *  [1, 0, 2, 1, 2, 0, 2, 1, 1, 0]
 * 
 */
public class SortZeroOneTwo {

	public static void sortArray(int arr[]) {
		
		int pointer = 0;
		
		pointer = sortDigit(arr, 0, pointer);
		
		System.out.println(Arrays.toString(arr));
		
		pointer = sortDigit(arr, 1, pointer);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		
		int arr[] = new int[] {1, 0, 2, 1, 2, 0, 2, 1, 1, 0};
		
		sortArray(arr);
	}
	
	private static int sortDigit(int arr[], int digit, int pointer) {
		for (int i = pointer; i < arr.length; i++) {
			if (arr[i] == digit) {
				int temp = arr[i];
				arr[i] = arr[pointer];
				arr[pointer] = temp;
				pointer++;
			}
		}
		return pointer;
	}
}
