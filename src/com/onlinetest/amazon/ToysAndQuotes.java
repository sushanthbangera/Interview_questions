package com.onlinetest.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 *  Online Test May 2020
 */
public class ToysAndQuotes {

	public ArrayList<String> getTopToys(List<String> toys, int toysCount, int TopToys, List<String> quotes,
			int qoutesCount) {

		// {toy1:2, toy2:5, toy3:1, toy4:5}
		HashMap<String, Integer> toyFreqMap = new HashMap<>();

		toys.forEach((toy) -> {
			quotes.stream().map((quote) -> quote.replace("[^a-zA-Z]", " ").toLowerCase())
					.filter((quotesInLowerCase) -> (quotesInLowerCase.indexOf(toy) > 0)).forEachOrdered((_item) -> {
						toyFreqMap.put(toy, toyFreqMap.getOrDefault(toy, 0) + 1);
					});
		});
 
		// sort based on frequency, if frequency is equal sort on toy string
		Comparator<Map.Entry<String, Integer>> mapComparator = (entry1, entry2) -> {
			int valueCompare = entry2.getValue() - entry1.getValue();
			if (valueCompare == 0) {
				return entry1.getKey().compareTo(entry2.getKey());
			}
			return valueCompare;
		};

		Map<String, Integer> sortedMap = new LinkedHashMap<>();

		toyFreqMap.entrySet().stream().sorted(mapComparator).limit(TopToys)
				.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));


		return new ArrayList<>(sortedMap.keySet());
	}
}
