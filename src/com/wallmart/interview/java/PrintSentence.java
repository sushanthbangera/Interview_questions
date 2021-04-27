package com.wallmart.interview.java;

/*
 *  Using n number of thread print the parts of the sentences sequentially
 */
public class PrintSentence extends Thread {

	private static Object lock = new Object();

	private final int limit;

	private final int threadId;

	private final int threadName;

	private static int index = 0;

	private static String[] words;

	public PrintSentence(String sentence, int threadId) {
		words = sentence.split("\\s+");
		this.threadId = threadId % 3;
		this.threadName = threadId;
		limit = words.length;
	}

	public void run() {
		while (index < limit) {
			synchronized (lock) {
				// wait
				while ((index + 1) % 3 != threadId) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// notify
				if (index < limit) {
					System.out.println(this.threadName + ":" + words[index]);
					index++;
					lock.notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) {
		
		String sentence = "This is a sentence to be used for display";
		PrintSentence a = new PrintSentence(sentence, 1);
		PrintSentence b = new PrintSentence(sentence, 2);
		PrintSentence c = new PrintSentence(sentence, 3);
		
		a.start();
		b.start();
		c.start();
	}
}
