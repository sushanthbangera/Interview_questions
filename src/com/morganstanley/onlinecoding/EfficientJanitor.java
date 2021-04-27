package com.morganstanley.onlinecoding;

import java.util.Collections;
import java.util.List;

/*
 * 
 * The weights of the Janitor bags are between 1.00 to 3.00
 * 
 * the bags that can be transferred at a time should be less then 3.00 weigh
 * 
 * Find the number of trips required.
 * 
 * ip: [1.99, 1.01, 2.5, 1.5, 1.01]  - op: 3  (2.5, (1.99, 1.01), (1.5, 1.01));
 */
public class EfficientJanitor {

	public int getMinimumTrips(List<Integer> weights) {
		
		int trips = 0;
		Collections.sort(weights);
		
		int right = weights.size() - 1;
		int left = 0;
		
		while (left <= right) {
			if (weights.get(left) + weights.get(right) <= 3) {
				left++;
				right--;
			} else {
				right--;
			}
			trips++;
		}
		
		return trips;
	}
}
