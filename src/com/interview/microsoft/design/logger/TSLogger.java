package com.interview.microsoft.design.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * Time Complexity: O(Log N) and Space: O(N)
 */
public class TSLogger implements Logger {

	// to sort the process based on start time
	private Map<Long, String> startMap = new TreeMap<>();

	private Map<String, Long> endMap = new HashMap<>();

	@Override
	public void start(String processId, long startTime) {
		startMap.put(startTime, processId);
	}

	@Override
	public void end(String processId, long endTime) {
		endMap.put(processId, endTime);
	}

	@Override
	public void print() {

		startMap.entrySet().stream().forEach(item -> {
			if (endMap.containsKey(item.getValue())) {
				System.out.println("Log [pid=" + item.getValue() + ", startTime=" + item.getKey() + ", endTime="
						+ endMap.get(item.getValue()) + "]");
			}
		});

	}

}
