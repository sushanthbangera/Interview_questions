package com.interview.wallmart;

public class PrintString {

	private int limit = 10;

	private static Object lock = new Object();

	private final int threadId;

	private static int currentId = 1;

	private final String str;

	private static int counter = 0;

	public PrintString(int threadId, String str) {
		this.threadId = threadId;
		this.str = str;
	}

	public void run() {

		while (counter < limit) {

			// wait
			while (currentId != threadId) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// print value
			System.out.println(this.str);

			currentId = (currentId == 1) ? 2 : 1;

			counter++;

			lock.notifyAll();

		}
	}
}
