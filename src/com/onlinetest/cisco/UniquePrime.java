package com.onlinetest.cisco;

import java.util.HashMap;
import java.util.Map;

/*
 * Find the unique prime number
 */
public class UniquePrime {

	public static void main(String[] args) {

		String s = "12,3,2,2,4,23,21,40,7,10,3,7";
		UniquePrime up = new UniquePrime();
		up.uniquePrime(s);
	}

	public void uniquePrime(String s) {

		String[] strNums = s.split(",");
		Map<Integer, Integer> freqMap = new HashMap<>();

		for (String str : strNums) {
			Integer n = Integer.parseInt(str);
			freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
		}

		freqMap.entrySet().stream().filter(item -> item.getValue() == 1).forEach(num -> {
			if (isPrime(num.getKey())) {
				System.out.print(num.getKey());
			}
		});
	}

	private boolean isPrime(Integer num) {

		if (num <= 1)
			return false;
		boolean isPrime = true;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
