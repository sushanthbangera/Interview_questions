package com.interview.microsoft.design.logger;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Time Complexity: O(Log N) and Space: O(N)
 */
public class MSLogger implements Logger {

	private PriorityQueue<Log> minHeap = new PriorityQueue<>(
			(log1, log2) -> Long.compare(log1.getStartTime(), log2.getStartTime()));

	private Map<String, Long> processMap = new HashMap<>();

	@Override
	public void start(String processId, long startTime) {
		processMap.put(processId, startTime);
	}

	@Override
	public void end(String processId, long endTime) {

		if (!processMap.containsKey(processId)) {
			throw new IllegalArgumentException("You can end process which has not started");
		}
		
		Log newLog = new Log(processId, processMap.get(processId), endTime);
		
		// remove from hashmap
		processMap.remove(processId);
		
		minHeap.offer(newLog);
	}

	@Override
	public void print() {
		while (!minHeap.isEmpty()) {
			Log log = minHeap.poll();
			System.out.println(log.toString());
		}
	}

}
