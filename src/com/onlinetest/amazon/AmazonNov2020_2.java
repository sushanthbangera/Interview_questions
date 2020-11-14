package com.onlinetest.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/discuss/interview-question/854110/amazon-oa-2020-five-star-sellers
 */
public class AmazonNov2020_2 {

	public static void main(String[] args) {

		List<List<Integer>> productRatings = new ArrayList<>();
		int ratingThreshold = 77;

		List<Integer> rating1 = new ArrayList<>(Arrays.asList(new Integer[] { 4, 4 }));
		productRatings.add(rating1);

		List<Integer> rating2 = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2 }));
		productRatings.add(rating2);

		List<Integer> rating3 = new ArrayList<>(Arrays.asList(new Integer[] { 3, 6 }));
		productRatings.add(rating3);

		System.out.println(fiveStartReviews(productRatings, ratingThreshold));
	}

	public static int fiveStartReviews(List<List<Integer>> productRatings, int ratingThreshold) {
		int result = 0;

		// The max percentage incrementing product is maintained this queue
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> percChange(l2) - percChange(l1)); // max-heap.
		for (List<Integer> rating : productRatings) {
			pq.offer(rating); // initialize PriorityQueue.
		}

		double curRating = 0;
		for (List<Integer> rating : productRatings) {
			curRating += 100.0 * rating.get(0) / rating.get(1); // initialize curRating.
		}

		while (curRating < ratingThreshold * productRatings.size()) {
			result++;

			List<Integer> rating = pq.poll();
			List<Integer> newRating = Arrays.asList(rating.get(0) + 1, rating.get(1) + 1);

			// remove the older rating and Add the updated rating
			curRating = curRating + (100.0 * newRating.get(0) / newRating.get(1)) - (100 * rating.get(0) / rating.get(1)); // keep
			pq.offer(newRating);
		}
		return result;
	}

	/*
	 * when u add 1 rating whats the percentage increment u get.
	 */
	private static int percChange(List<Integer> p) {
		double currRating = 100.0 * p.get(0) / p.get(1);
		double newRating = 100.0 * (p.get(0) + 1) / (p.get(1) + 1);
		return (int) (newRating - currRating);
	}
}
