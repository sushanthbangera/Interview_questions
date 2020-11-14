package com.onlinetest.zycus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1/?company[]=Zycus&page=1&query=company[]Zycuspage1
 */
public class ArraySortOnFrequency {

	public static void main(String[] args) {

		int arr[] = {1, 6, 5, 1, 6, 3}; // 1, 1, 6, 6, 3, 5
		System.out.print(sortArray(arr).toString());
		
		int arr1[] = {1, 2, 3, 4, 5}; // 1
		System.out.print(sortArray(arr1).toString());
	}

	public static List<Integer> sortArray(int arr[]) {

		List<Integer> result = new ArrayList<>();

		Map<Integer, Integer> freqMap = new HashMap<>();

		for (int a : arr) {
			freqMap.put(a, freqMap.getOrDefault(a, 0) + 1);
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
				(x, y) -> (freqMap.get(x) == freqMap.get(y) ? (x - y) : freqMap.get(y) - freqMap.get(x)));
	
		freqMap.entrySet().forEach(item -> {
			minHeap.offer(item.getKey());
		});
		
		while (!minHeap.isEmpty()) {
			int val = minHeap.poll();
			int freq = freqMap.get(val);
			
			while (freq-- > 0) {
				result.add(val);
			}
		}
		
		return result;
	}
}
