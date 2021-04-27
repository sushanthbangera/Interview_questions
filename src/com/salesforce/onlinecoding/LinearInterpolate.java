package com.salesforce.onlinecoding;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LinearInterpolate {

	public static String interpolate(int x, List<Integer> instances, List<Float> price) {

		int size = instances.size();

		int index = Collections.binarySearch(instances, x);

		System.out.println(index);

		if (index > -1) {
			// Case 1: If given instance is present
			return price.get(index).toString();
		}

		Pair pair1 = null;
		Pair pair2 = null;

		// case 2: if instances are all smaller than the instance x provided
		if (x > instances.get(size - 1)) {
			if (size >= 2) {
				pair1 = new Pair(instances.get(size - 1), price.get(size - 1));
				pair2 = new Pair(instances.get(size - 2), price.get(size - 2));
			} else {
				return price.get(0).toString();
			}
		} else {
			// Case 3: When x is between the instances we have to get a smaller and a
			// greater instance
			index = (index + 1) * -1;

			if (index > 0) {
				pair1 = new Pair(instances.get(index), price.get(index));
				pair2 = new Pair(instances.get(index - 1), price.get(index - 1));
			}
		}
		return interpolate(pair1, pair2, x);

	}

	private static String interpolate(Pair a, Pair b, int x) {

		double m = (a.y - b.y) / (a.x - b.x);

		// y = y1 + m * (x - x1);

		double y = a.y + m * (x - a.x);

		DecimalFormat fm = new DecimalFormat("###.##");
		String formatted = fm.format(y);

		return formatted;
	}

	public static void main(String[] args) {

		List<Integer> instances = Arrays.asList(10, 25, 50, 100, 500);
		List<Float> price = Arrays.asList(27.52f, 23.13f, 21.25f, 18.00f, 15.50f);

		System.out.println(interpolate(1999, instances, price));

		System.out.println(interpolate(100, instances, price));

		System.out.println(interpolate(30, instances, price));
	}

}

class Pair {

	int x;

	float y;

	Pair(int x, float y) {
		this.x = x;
		this.y = y;
	}

}