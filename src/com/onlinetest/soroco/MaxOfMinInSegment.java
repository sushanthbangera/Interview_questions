package com.onlinetest.soroco;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.onlinetest.twillio.MaxOfSegmentMin;

public class MaxOfMinInSegment {

	/*
	 * Time: O(n)
	 */
	public int segment(int k, List<Integer> space) {

		int n = space.size();

		int maxOfMin = Integer.MIN_VALUE;

		Deque<Integer> dq = new LinkedList<>();

		int i;

		for (i = 0; i < k; i++) {
			while (!dq.isEmpty() && space.get(dq.peekLast()) >= space.get(i)) {
				dq.removeLast();
			}
			dq.addLast(i);
		}

		while (i < n) {
			maxOfMin = Math.max(space.get(dq.peekFirst()), maxOfMin);

			while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
				dq.removeFirst();
			}

			while (!dq.isEmpty() && space.get(dq.peekLast()) >= space.get(i)) {
				dq.removeLast();
			}
			dq.addLast(i);
			i++;
		}

		maxOfMin = Math.max(space.get(dq.peekFirst()), maxOfMin);
		return maxOfMin;
	}

	/*
	 * Time: O(n*n)
	 */
	public int segment_BruteForce(int k, List<Integer> space) {

		int maxOfMin = Integer.MIN_VALUE;
		int currentMin = Integer.MAX_VALUE;

		for (int i = 0; i <= space.size() - k; i++) {

			currentMin = Integer.MAX_VALUE;

			for (int j = i; j < i + k; j++) {
				currentMin = Math.min(currentMin, space.get(j));
			}

			maxOfMin = Math.max(maxOfMin, currentMin);
		}

		return maxOfMin;
	}

	public static void main(String[] args) {

		List<Integer> space = Arrays.asList(new Integer[] { 1, 2, 3, 1, 2 });
		int k = 5;

		MaxOfSegmentMin maxOfMin = new MaxOfSegmentMin();
		System.out.println(maxOfMin.segment(k, space));
		System.out.println(maxOfMin.segment_BruteForce(k, space));
	}
}
