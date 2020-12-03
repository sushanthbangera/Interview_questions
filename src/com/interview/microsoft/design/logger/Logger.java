package com.interview.microsoft.design.logger;

public interface Logger {

	/**
	 * When a process starts, it calls 'start' with processId and startTime.
	 */
	void start(String processId, long startTime);

	/**
	 * When the same process ends, it calls 'end' with processId and endTime.
	 */
	void end(String processId, long endTime);

	/**
	 * Prints the logs of this system sorted by the start time of processes in the
	 * below format {processId} started at {startTime} and ended at {endTime}
	 */
	void print();

}
