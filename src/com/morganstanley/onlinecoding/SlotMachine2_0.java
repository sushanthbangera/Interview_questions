package com.morganstanley.onlinecoding;

import java.util.Arrays;
import java.util.List;

/*
 * Find the count of moves made by the wheels of slot machine
 * 
 * "712", "246", "365", "312"
 * 
 * 7 1 2
 * 2 4 6
 * 3 6 5
 * 3 1 2
 * 
 * Max is 7. So 7 moves
 * Now remove the max in each row
 * 
 * 1 2
 * 2 4
 * 3 5
 * 1 2
 * 
 * Max is 5. So 5 moves
 * 
 * Similary total count = 7 + 5 + 3 = 15
 * 
 */
public class SlotMachine2_0 {

	public int findCount(List<String> outcomes) {

		int count = 0;
		int wheels = outcomes.get(0).length();
		int mat[][] = new int[outcomes.size()][wheels];

		for (int i = 0; i < outcomes.size(); i++) {
			for (int j = 0; j < wheels; j++) {
				String number = outcomes.get(i);
				mat[i][j] = number.charAt(j) - '0';
			}
		}
		for (int i = 0; i < wheels; i++) {
			int maxNum = getMax(mat, wheels);
			count += maxNum;
			removeMax(mat, wheels);
		}
		return count;
	}

	private int getMax(int arr[][], int col) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < col; j++) {
				max = Math.max(max, arr[i][j]);
			}
		}
		return max;
	}

	private void removeMax(int arr[][], int col) {
		for (int i = 0; i < arr.length; i++) {
			int maxIndex = 0;
			int maxValue = arr[i][0];
			for (int j = 1; j < col; j++) {
				if (arr[i][j] > maxValue) {
					maxIndex = j;
					maxValue = arr[i][j];
				}
			}
			arr[i][maxIndex] = 0;
		}
	}

	public static void main(String[] args) {

		SlotMachine2_0 slotMachine2_0 = new SlotMachine2_0();
		List<String> outcomes = Arrays.asList("712", "246", "365", "312");

		System.out.println(slotMachine2_0.findCount(outcomes));
	}
}
