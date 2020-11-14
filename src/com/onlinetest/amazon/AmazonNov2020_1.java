package com.onlinetest.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonNov2020_1 {

	public static void main(String[] args) {

//		String s = "|**|*|*|";
//		List<Integer> startIndices = Arrays.asList(new Integer[] { 1, 1 });
//		List<Integer> endIndices = Arrays.asList(new Integer[] { 5, 6 });

		String s = "*|*|";
		List<Integer> startIndices = Arrays.asList(new Integer[] {1, 1});
		List<Integer> endIndices = Arrays.asList(new Integer[] {2, 4});

		System.out.println(numberOfItems2(s, startIndices, endIndices));
	}

	public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {

		int size = startIndices.size();
		List<Integer> result = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {

			int start = startIndices.get(i);
			int end = endIndices.get(i);

			String sub = s.substring(start - 1, end);

			int totalItems = 0;
			int curItems = 0;
			int j = 0;

			while (j < sub.length()) {
				int ascii = sub.charAt(j);
				if (ascii == 124) {
					break;
				}
				j++;
			}

			for (j = j + 1; j < sub.length(); j++) {
				int ascii = sub.charAt(j);

				if (ascii == 42) {
					curItems++;
				} else if (ascii == 124) {
					totalItems += curItems;
					curItems = 0;
				}
			}
			if (totalItems > 0) {
				result.add(totalItems);
				totalItems = 0;
			}
		}
		if (result.size() == 0) {
			result.add(0);
		}
		return result;
	}

	public static List<Integer> numberOfItems2(String s, List<Integer> startIndices, List<Integer> endIndices) {

		int size = startIndices.size();
		List<Integer> result = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {

			int start = startIndices.get(i);
			int end = endIndices.get(i);

			String sub = s.substring(start - 1, end);

			int totalItems = 0;

			int first = sub.indexOf('|');
			int last = sub.lastIndexOf('|');

			if (first > -1 && last > 0 && first != last) {
				for (int j = first + 1; j < last; j++) {
					if (sub.charAt(j) == 42) {
						totalItems++;
					}
				}
				if (totalItems > 0) {
					result.add(totalItems);
				}
			}
		}
		if (result.size() == 0) {
			result.add(0);
		}
		return result;
	}
}
