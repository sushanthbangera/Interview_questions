package com.vmware.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given list of Integers print the number of odd elements and even elements
 */
public class EvenOddCollectors {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 3, 4, 5, 8, 9);

		Map<String, Long> mapCount = list.stream().collect(
				Collectors.groupingBy(n -> n % 2 == 0 ? "EVEN" : "ODD", java.util.stream.Collectors.counting()));

		mapCount.entrySet().forEach(System.out::println);
	}
}
