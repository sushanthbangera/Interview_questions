package com.interview.ola;

import java.util.PriorityQueue;

/*
 *  pos, 0 , neg
 *  
 *  -2, -1, 0, -3, 2
 *  
 *  
 */
public class KthLargestElement {

	public int kthLargest(int arr[], int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int a : arr) {

			pq.add(a);

			if (pq.size() > k) {
				pq.poll();
			}
		}

		return pq.poll();
	}

	
}
