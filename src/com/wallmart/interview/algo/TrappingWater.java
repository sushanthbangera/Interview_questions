package com.wallmart.interview.algo;

/*
 * 	ar = {0,1,0,2,1,0,1,3,2,1,2,1}

	ar = {4,2,0,3,2,5}
	
	Given array with the heights of the buildings. Find the units of water trapped between the buildings
 */
public class TrappingWater {

	public int getWaterUnits(int arr[]) {

		int[] left = new int[arr.length];
		int[] right = new int[arr.length];

		int maxLeft = Integer.MIN_VALUE;
		int maxRight = Integer.MIN_VALUE;

		int n = arr.length - 1;

		// max values
		for (int i = 0; i < arr.length; i++) {

			maxRight = Math.max(arr[n - i], maxRight);
			maxLeft = Math.max(arr[i], maxLeft);

			// {0,1,0,2,1,0,1,3,2,1,2,1} //height ( units)

			// {3,3,3,3,3,3,3,3,2,2,2,1}// right

			// {0,1,1,2,2,2,2,3,3,3,3,3} //left
			right[n - i] = maxRight;
			left[i] = maxLeft;
		}

		int waterUnits = 0;
		// units of water
		for (int i = 1; i < arr.length - 1; i++) {

			int curUnits = Math.min(right[i + 1], left[i - 1]) - arr[i];

			if (curUnits > 0) {
				waterUnits += curUnits;
			}
		}

		return waterUnits;
	}
}
