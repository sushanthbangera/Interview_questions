package com.onlinetest.twillio;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxOfSegmentMin {

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

	public static void main(String[] args) {

		List<Integer> space = Arrays.asList(new Integer[] { 1, 3, 7, 2, 5, 6, 4 });
		int k = 3;

		MaxOfSegmentMin maxOfMin = new MaxOfSegmentMin();
		System.out.println(maxOfMin.segment(k, space));
	}
}
