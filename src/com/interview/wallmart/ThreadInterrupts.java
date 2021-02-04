package com.interview.wallmart;

/*
 * 
 * How to stop a thread. Implement the code for stopping a thread
 */
public class ThreadInterrupts extends Thread {

	private volatile boolean process = true;

	public void run() {

		while (process) {

			if (Thread.interrupted()) {
				// stop the process
			} else {
				// continue the process
			}
		}
	}

	public static void main(String[] args) {

		ThreadInterrupts t = new ThreadInterrupts();
		t.start();
		t.interrupt();
	}

}
