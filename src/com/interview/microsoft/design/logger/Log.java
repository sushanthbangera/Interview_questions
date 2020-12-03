package com.interview.microsoft.design.logger;

public class Log {

	private String pid;

	private long startTime;

	private long endTime;

	public Log(String pid, long startTime, long endTime) {
		this.pid = pid;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Log [pid=" + pid + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

}
