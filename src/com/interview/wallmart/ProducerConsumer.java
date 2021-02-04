package com.interview.wallmart;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

	private Queue<Integer> queue = new LinkedList<>();

	private final int capacity;

	public ProducerConsumer(int capacity) {
		this.capacity = capacity;
	}

	public void produce() throws InterruptedException {

		int value = 0;

		synchronized (this) {

			while (queue.size() == capacity) {//
				wait();
			}

			queue.add(value++);
			
			notify();
		}

		Thread.interrupted();
	}

	public void consume() throws InterruptedException {

		synchronized (this) {

			while (queue.size() == 0) {
				wait();
			}

			queue.remove();
			
			notify();
		}
	}
}
