package com.interview.oracle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/*
 *  19 Nov 2020
 */
public class MergeIntervals {
	
	/*
	 * Reference: https://leetcode.com/problems/merge-intervals/
	 */
	public static List<Point> getMergedPairs2(List<Point> input) {

		Collections.sort(input, (a, b) -> a.x - b.x);
		
		// if array
		// Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
	
		LinkedList<Point> mergedList = new LinkedList<>();
		
		// {1,5}, {2, 4}, {3, 6}, {7, 11}, {10, 13}, {20, 25}
		
		input.forEach(point -> {
			if (mergedList.isEmpty() || mergedList.getLast().y < point.x) {
				mergedList.add(point);
			} else {
				mergedList.getLast().y = Math.max(mergedList.getLast().y , point.y);
			}
		});
		
		return mergedList;
	}

	/*
	 * Implemented during interview
	 */
	public static List<Point> getMergedPairs(List<Point> input) {

		List<Point> results = new ArrayList<>();

		PriorityQueue<Point> sortedInput = new PriorityQueue<>((a, b) -> (a.x - b.x));

		for (Point p : input) {
			sortedInput.offer(p);
		}

		// {1,5}, {2, 4}, {3, 6}, {7, 11}, {10, 13}, {20, 25}

		Point curPoint = null;

		Point temp = null;

		while (!sortedInput.isEmpty()) {

			curPoint = sortedInput.poll();

			if (temp == null) {
				temp = curPoint;
			} else {
				// comparision
				// 1, 5 .... 3, 6....7, 11
				if (temp.x < curPoint.x && temp.y > curPoint.y) {
					continue;
				} else if (temp.y > curPoint.x && temp.x < curPoint.x && temp.y < curPoint.y) {
					// 1, 5 .... 3, 6
					temp.y = curPoint.y;
				} else {
					results.add(temp);
					temp = curPoint;
				}
			}
		}

		results.add(temp);
		return results;
	}

	public static void main(String[] args) {

		// {2,4},{1,5},{3,7},{20,25},{7,11},{10,13}

		List<Point> input = new ArrayList<>();
		input.add(new Point(2, 4));
		input.add(new Point(1, 5));
		input.add(new Point(3, 7));
		input.add(new Point(12, 15));
		input.add(new Point(8, 11));
		input.add(new Point(10, 13));
		input.add(new Point(20, 23));
		input.add(new Point(21, 24));

		List<Point> result = getMergedPairs2(input);

		System.out.println(result.toString());
	}

	static class Point {

		int x;

		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + this.x + " , " + this.y + ")";
		}
	}
}
