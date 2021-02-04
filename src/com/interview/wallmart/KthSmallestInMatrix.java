package com.interview.wallmart;

import java.util.PriorityQueue;

/*
 * [1,5,9],
 * [10,11,13],
 * [12,13,15]
 */
public class KthSmallestInMatrix {

	public int kthMin(int mat[][], int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

		for (int i = 0; i < mat.length; i++) {

			for (int j = 0; j < mat[i].length; j++) {

				pq.add(mat[i][j]); // 3, 2, 1

				if (pq.size() > k) {

					pq.poll(); // 2, 1
				}
			}
		}
		return pq.poll();
	}
}
