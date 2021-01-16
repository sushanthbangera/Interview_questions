package com.interview.netcracker;

import java.util.LinkedList;

public class ProducerConsumer {

	private LinkedList<Integer> list = new LinkedList<>();

	private int capacity = 3;

	public void produce() throws InterruptedException {
		int value = 0;
		synchronized (this) {

			while (list.size() == capacity) {
				wait();
			}

			list.add(value++);
		}
	}

	public void consumer() throws InterruptedException {
		synchronized (this) {

			while (list.size() == 0) {
				wait();
			}

			list.remove();
		}
	}

	public static void main(String[] args) {

		ProducerConsumer pc = new ProducerConsumer();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
	}
}
