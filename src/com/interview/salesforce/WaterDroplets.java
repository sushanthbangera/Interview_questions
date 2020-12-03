package com.interview.salesforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.interview.utils.Pair;

/*
 * https://www.geeksforgeeks.org/water-drop-problem/
 * 
 * Approach: for each drop find the time required to reach the end of the pipe
 * 
 * if the time taken by the drop closer to the end is greater than the time take by the drop away from it,
 * the drops combine
 */
public class WaterDroplets {

	// Function to find the number
	// of the drops that come out of the pipe
	public int drops(int length, int position[], int speed[], int n) {

		// stores position and time taken by a single
		// drop to reach the end as a pair
		List<Pair<Integer, Double>> list = new ArrayList<>(n);
		int i;

		for (i = 0; i < n; i++) {
			// distance left to cover
			int distLeft = length - position[i];

			// speed = dist / time => time = dist / speed
			Double timeRequired = distLeft * 1.0 / speed[i];

			list.add(Pair.of(position[i], timeRequired));
		}

		// sorts the pair according to increasing
		// order of their positions
		// [(0, 12), (3, 3), (5, 7), (8, 1), (10, 1)]
		Collections.sort(list, (a, b) -> a.first - b.first);

		int k = 1; // counter for no of final drops, 1 for 1st drop

		Double curr_max = list.get(n - 1).second;

		// we traverse the array demo right to left
		// to determine the slower drop
		for (i = n - 2; i >= 0; i--) {

			// checks for next slower drop
			if (list.get(i).second > curr_max) {
				k++;
				curr_max = list.get(i).second;
			}
		}
		
		return k;
	}

	public static void main(String[] args) {
		// length of pipe
		int length = 12;

		// position of droplets
		int position[] = { 10, 8, 0, 5, 3 };

		// speed of each droplets
		int speed[] = { 2, 4, 1, 1, 3 };
		// int n = sizeof(speed)/sizeof(speed[0]);

		WaterDroplets wd = new WaterDroplets();

		System.out.println("drops: " + wd.drops(length, position, speed, 5));
	}
}
