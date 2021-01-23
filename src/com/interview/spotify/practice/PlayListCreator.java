package com.interview.spotify.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * You have access to ranked lists of songs for various users. Each song is represented as an integer, and more 
 * preferred songs appear earlier in each list. For example, the list [4, 1, 7] indicates that a user likes
 *  song 4 the best, followed by songs 1 and 7.

Given a set of these ranked lists, interleave them to create a playlist that satisfies everyone's priorities.

For example, suppose your input is {[1, 7, 3], [2, 1, 6, 7, 9], [3, 9, 5]}. 
In this case a satisfactory playlist could be [2, 1, 6, 7, 3, 9, 5].
 */

public class PlayListCreator {

	public static void main(String[] args) {

		List<Integer[]> lists = new ArrayList<>();
		Integer[] a = { 1, 7, 3 };
		Integer[] b = { 2, 1, 6, 7, 9 };
		Integer[] c = { 3, 9, 5 };
		lists.add(a);
		lists.add(b);
		lists.add(c);

		PlayListCreator pl = new PlayListCreator();
		System.out.println(pl.playListCreator(lists).toString());
	}

	private List<Integer> playListCreator(List<Integer[]> lists) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		buildGraph(lists, graph);

		Set<Integer> sourceNodes = graph.keySet();
		Integer[] vertices = sourceNodes.toArray(new Integer[sourceNodes.size()]);

		Stack<Integer> sortedList = topologicalSort(graph, vertices);

		List<Integer> playList = new ArrayList<>();
		while (!sortedList.isEmpty()) {
			playList.add(sortedList.pop());
		}
		return playList;
	}

	private Stack<Integer> topologicalSort(Map<Integer, List<Integer>> graph, Integer[] vertices) {
		Map<Integer, Boolean> visited = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < vertices.length; i++) {
			if (!visited.getOrDefault(vertices[i], false)) {
				topologicalSortVisit(graph, visited, stack, vertices[i]);
			}
		}

		return stack;
	}

	private void topologicalSortVisit(Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited,
			Stack<Integer> stack, int source) {

		// If its already visited, need not check again
		if (visited.getOrDefault(source, false)) {
			return;
		}

		List<Integer> destList = graph.get(source);

		if (destList != null && !destList.isEmpty()) {

			/*
			 * Using functional operations
			 * 
			 * destList.stream().filter((dest) -> !visited.getOrDefault(dest,
			 * Boolean.FALSE)).forEachOrdered((dest) -> { topologicalSortVisit(graph,
			 * visited, stack, dest); });
			 * 
			 */

			for (int dest : destList) {
				if (!visited.getOrDefault(dest, false)) {
					topologicalSortVisit(graph, visited, stack, dest);
				}
			}
		}

		visited.put(source, true);
		stack.push(source);
	}

	private void buildGraph(List<Integer[]> lists, Map<Integer, List<Integer>> graph) {
		for (Integer[] arr : lists) {
			for (int i = 0; i < arr.length - 1; i++) {
				Integer source = arr[i];
				for (int j = i + 1; j < arr.length; j++) {
					List<Integer> destList = graph.getOrDefault(source, new ArrayList<>());
					destList.add(arr[j]);
					graph.put(source, destList);
				}
			}
		}
	}
}
