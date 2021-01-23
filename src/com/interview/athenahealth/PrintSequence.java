package com.interview.athenahealth;

public class PrintSequence implements Runnable {

	private int number;

	private int lastNumber = 100;

	private static int count = 1;

	private final int mod;
	
	private static Object lock = new Object();

	public PrintSequence(int number, int mod) {
		this.number = number;
		this.mod = mod;
	}

	@Override
	public void run() {

		// wait till lock is released (if other than 1) 

		while (count <= lastNumber - mod) {
			synchronized (lock) {
				//1 % 10 != 1
				while (count % mod != number) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// writes
				System.out.print("Tread: " + Thread.currentThread().getName());
				System.out.println(" The num: " + count);
				count++;

				// release lock -> notify
				lock.notifyAll();
			}
		}
	}

}
