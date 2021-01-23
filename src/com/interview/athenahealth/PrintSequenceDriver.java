package com.interview.athenahealth;

public class PrintSequenceDriver {

	public static void main(String[] args) {
		
		int numThreads = 15;
		int mod = 15;
		
		for (int i = 1; i <= numThreads; i++) {
			PrintSequence printSeq = new PrintSequence(i % mod, mod);
			Thread a = new Thread(printSeq);
			a.start();
		}
	}
}
