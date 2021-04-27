package com.twillio.onlinecoding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ItemSorting {

	public static List<Integer> itemsSort(List<Integer> items) {

		Map<Integer, Integer> freqMap = new HashMap<>();

		// Get frequency
		for (Integer item : items) {
			freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
			int valueCompare = a.getValue() - b.getValue();
			if (valueCompare == 0) {
				return a.getKey() - b.getKey();
			}
			return valueCompare;
		});

		freqMap.entrySet().forEach(pq::add);

		List<Integer> resulList = new ArrayList<>();
		while (!pq.isEmpty()) {
			Map.Entry<Integer, Integer> m = pq.poll();
			for (int i = 0; i < m.getValue(); i++) {
				resulList.add(m.getKey());
			}
		}
		return resulList;
	}

	/*
	 * 
	 * Using Comparator and sorted map
	 */
	public static List<Integer> itemsSort1(List<Integer> items) {

		Map<Integer, Integer> freqMap = new HashMap<>();

		// Get frequency
		for (Integer item : items) {
			freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
		}

		Comparator<Map.Entry<Integer, Integer>> freqComp = (entry1, entry2) -> {
			int valueCompare = entry1.getValue() - entry2.getValue();
			if (valueCompare == 0) {
				return entry1.getKey() - entry2.getKey();
			}
			return valueCompare;
		};

		Map<Integer, Integer> sortedMap = new LinkedHashMap<>();

		freqMap.entrySet().stream().sorted(freqComp)
				.forEachOrdered(item -> sortedMap.put(item.getKey(), item.getValue()));

		List<Integer> resulList = new ArrayList<>();

		for (Integer item : sortedMap.keySet()) {
			for (int i = 0; i < sortedMap.get(item); i++) {
				resulList.add(item);
			}
		}
		return resulList;
	}
}
