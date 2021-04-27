package com.ai24_7.interview;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

	private static Map<Integer, Integer> cache;

	private static Deque<Integer> cacheKeys;

	private static int cacheSize;

	public LRUCache(int capacity) {
		cache = new HashMap<>(capacity);
		cacheKeys = new LinkedList<>();
		cacheSize = capacity;
	}

	public Integer get(Integer key) {
		if (cache.containsKey(key)) {
			cacheKeys.remove(key);
			cacheKeys.add(key);
			return cache.get(key);
		}
		return -1;
	}

	public void put(Integer key, Integer value) {
		if (!cache.containsKey(key)) {
			if (cache.size() == cacheSize) {
				Integer leastUsed = cacheKeys.removeLast();
				cache.remove(leastUsed);
			}
		} else {
			cache.remove(key);
		}
		cache.put(key, value);
		cacheKeys.add(key);
	}
}
