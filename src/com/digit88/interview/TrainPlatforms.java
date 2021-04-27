package com.digit88.interview;

import java.util.Arrays;

/*
 * Given the arrival and departure times of the train find the minimum platforms required
 */
public class TrainPlatforms {

	public int getMinimumPlatforms(double arrival[], double departure[]) {

		Arrays.sort(arrival);
		Arrays.sort(departure);

		Train[] trains = new Train[arrival.length + departure.length];

		int i = 0, j = 0, k = 0;
		Train train = null;

		while (i < arrival.length && j < departure.length) {
			if (arrival[i] < departure[j]) {
				train = new Train(Tag.ARRIVAL, arrival[i]);
				i++;
			} else {
				train = new Train(Tag.DEPARTURE, arrival[i]);
				j++;
			}
			trains[k] = train;
			k++;
		}

		while (i < arrival.length) {
			train = new Train(Tag.ARRIVAL, arrival[i]);
			trains[k] = train;
			i++;
			k++;
		}

		while (j < departure.length) {
			train = new Train(Tag.DEPARTURE, arrival[j]);
			trains[k] = train;
			j++;
			k++;
		}

		int minPlatforms = Integer.MIN_VALUE;
		int platformCount = 0;

		for (Train t : trains) {
			if (t.tag.equals(Tag.ARRIVAL)) {
				platformCount++;
				minPlatforms = Math.max(minPlatforms, platformCount);
			} else {
				platformCount--;
			}
		}

		return minPlatforms;
	}

	public static void main(String[] args) {

		double arr[] = new double[] { 11.00, 11.30, 11.39 };
		double dep[] = new double[] { 11.40, 12.00, 11.55 };

		TrainPlatforms tp = new TrainPlatforms();
		System.out.println(tp.getMinimumPlatforms(arr, dep));
	}

}

class Train {

	Tag tag;

	double time;

	public Train(Tag tag, double time) {
		super();
		this.tag = tag;
		this.time = time;
	}
}

enum Tag {
	ARRIVAL, DEPARTURE;
}
