package com.vmware.onlinetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramSentenceCounter {

	public static List<Long> getSentenceCount(List<String> wordList, List<String> sentences) {

		List<Long> countList = new ArrayList<>();

		Map<String, Integer> anagramCount = new HashMap<>();

		for (int i = 0; i < wordList.size() - 1; i++) {

			for (int j = i + 1; j < wordList.size(); j++) {

				if (isAnagram(wordList.get(i), wordList.get(j))) {
					anagramCount.put(wordList.get(i), anagramCount.getOrDefault(wordList.get(i), 0) + 1);
					anagramCount.put(wordList.get(j), anagramCount.getOrDefault(wordList.get(j), 0) + 1);
				}
			}
		}
		
		for (String sentence : sentences) {

			String[] words = sentence.split("\\s+");
			Long count = 1L;

			for (String word : words) {

				if (anagramCount.containsKey(word)) {
					
					count *= (anagramCount.get(word) + 1);
				}
			}
			countList.add(count);
		}
		return countList;
	}

	private static boolean isAnagram(String a, String b) {

		if (a.length() != b.length()) {
			return false;
		}

		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		Arrays.sort(aChar);
		Arrays.sort(bChar);

		return Arrays.equals(aChar, bChar);
	}

	public static void main(String[] args) {

		List<String> words = Arrays
				.asList(new String[] { "star", "tars", "stay", "tay", "seed", "dees", "eesd", "rast", "date", "ate" });
		List<String> sentences = Arrays.asList(
				new String[] { "ate date stay", "rast tay star", "tay stay tars", "seed dees star", "ate seed rast" });

		List<Long> counts = getSentenceCount(words, sentences);
		System.out.println(counts);

	}
}
