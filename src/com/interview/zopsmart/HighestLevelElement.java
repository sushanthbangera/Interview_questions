package com.interview.zopsmart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/*
 * Level order traversal of a tree and print the highest element in each level
 */

public class HighestLevelElement {

	public void printHighestElementInLevels(Node root) {

		Queue<Node> queue = new LinkedList<>();
		TreeSet<Integer> levelData = new TreeSet<>();

		queue.add(root);
		levelData.add(root.data);

		while (!queue.isEmpty()) {

			int size = queue.size();
			System.out.println(levelData.last());
			levelData.clear();

			while (size-- > 0) {

				Node curNode = queue.poll();

				if (curNode.left != null) {
					queue.add(curNode.left);
					levelData.add(curNode.left.data);
				}

				if (curNode.right != null) {
					queue.add(curNode.right);
					levelData.add(curNode.right.data);
				}
			}

		}
		System.out.println(levelData.last());
		levelData.clear();

	}

	class Node {
		int data;
		Node left;
		Node right;
	}
}
