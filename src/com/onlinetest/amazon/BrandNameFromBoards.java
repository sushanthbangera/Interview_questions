package com.onlinetest.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * Given N boards where the few letters of a brand name got wiped off from the board due to rain.
 * 
 * Find the Brand name
 */
public class BrandNameFromBoards {

	public static void main(String[] args) {
		String[] wordsArray = { "nk", "ike", "ke" };
		List<String> words = Arrays.asList(wordsArray);

		BrandNameFromBoards wd = new BrandNameFromBoards();
		String brand = wd.getBrandName(words);
		System.out.print("The Brand is: " + brand);
	}

	public String getBrandName(List<String> boards) {
		Map<Character, List<Character>> graph = new HashMap<>();
		buildGraph(boards, graph);

		Set<Character> vertexKeys = graph.keySet();
		Character[] vertices = vertexKeys.toArray(new Character[vertexKeys.size()]);

		return toplogicalSort(graph, vertices);
	}

	private String toplogicalSort(Map<Character, List<Character>> graph, Character[] vertices) {
		Map<Character, Boolean> visited = new HashMap<>();
		Stack<Character> stack = new Stack<>();

		for (Character vertice : vertices) {
			if (!visited.getOrDefault(vertice, Boolean.FALSE)) {
				toplogicalSortUtil(graph, visited, vertice, stack);
			}
		}

		StringBuilder str = new StringBuilder();
		while (!stack.isEmpty()) {
			str.append(stack.pop());
		}
		return str.toString();
	}

	private void toplogicalSortUtil(Map<Character, List<Character>> graph, Map<Character, Boolean> visited, char vertex,
			Stack<Character> stack) {

		if (visited.getOrDefault(vertex, false)) {
			return;
		}

		List<Character> destList = graph.get(vertex);

		if (destList != null && !destList.isEmpty()) {
			for (char dest : destList) {
				if (!visited.getOrDefault(dest, Boolean.FALSE)) {
					toplogicalSortUtil(graph, visited, dest, stack);
				}
			}
		}

		visited.put(vertex, Boolean.TRUE);
		stack.push(vertex);
	}

	private void buildGraph(List<String> words, Map<Character, List<Character>> graph) {
		words.stream().map((word) -> word.toCharArray()).forEachOrdered((letters) -> {
			int wordLength = letters.length;

			for (int i = 0; i < wordLength - 1; i++) {
				char src = letters[i];
				for (int j = i + 1; j < wordLength; j++) {
					List<Character> destList = graph.getOrDefault(src, new ArrayList<>());
					destList.add(letters[j]);
					graph.put(src, destList);
				}
			}
		});
	}
}
