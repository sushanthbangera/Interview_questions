package com.ezetap.interview;

public class DeadlockSimulator {

	public static void main(String[] args) {

		final String resource1 = "lock1";

		final String resource2 = "lock2";

		Thread t1 = new Thread(() -> {

			synchronized (resource1) {
				System.out.println("Thread t1 blocked Resource 1");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}

				synchronized (resource2) {
					System.out.println("Thread t1 blocked Resource 2");
				}
			}

		});

		Thread t2 = new Thread(() -> {

			synchronized (resource2) {
				System.out.println("Thread t2 blocked Resource 2");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}

				synchronized (resource1) {
					System.out.println("Thread t2 blocked Resource 1");
				}
			}

		});
		
		t1.start();
		t2.start();

	}
}
