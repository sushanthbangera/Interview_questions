package com.interview.zopsmart;

import java.util.PriorityQueue;

public class KthLargestElement {

	public int getKthLargest(int arr[], int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(k);

		for (int a : arr) {

			pq.add(a); //   3, 7, 5, 8, 9

			while (pq.size() > k) {
				pq.poll();
			}
		}

		return pq.poll();
	}
}
