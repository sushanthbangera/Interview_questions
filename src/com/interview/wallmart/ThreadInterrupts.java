package com.interview.wallmart;

public class ThreadInterrupts extends Thread {

	private volatile boolean process = true;

	public void run() {

		while (process) {

			if (!Thread.interrupted()) {
				// do the task
			}
		}
	}
	
	public static void main(String[] args) {
		
		ThreadInterrupts a = new ThreadInterrupts();
		a.interrupt();
	}

}
