package com.ai24_7.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 *  3 -   >   3
   / \
  9   20
  /\  /  \
12 13 15   7
   
   
   3
   20, 9
   15, 7
 */
public class ZigZagTraversal {

	class Node {

		int val;

		Node left;

		Node right;
	}

	public List<List<Integer>> zigzagTraversal(Node root) {

		List<List<Integer>> result = new ArrayList<>();

		boolean isRightToLeft = false;

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		stack1.push(root);

		List<Integer> rootLevel = new ArrayList<>();
		rootLevel.add(root.val);

		result.add(rootLevel);

		while (!stack1.isEmpty()) {

			int size = stack1.size();

			List<Integer> level = new ArrayList<>();

			while (size-- > 0) {

				Node curNode = stack1.pop();

				if (isRightToLeft) {
					if (curNode.right != null) {
						stack2.push(curNode.right);
						level.add(curNode.right.val);
					}

					if (curNode.left != null) {
						stack2.push(curNode.left);
						level.add(curNode.left.val);
					}

				} else {
					if (curNode.left != null) {
						stack2.push(curNode.left);
						level.add(curNode.left.val);
					}

					if (curNode.right != null) {
						stack2.push(curNode.right);
						level.add(curNode.right.val);
					}
				}
			}

			result.add(level);

			Stack<Node> temp = stack1;
			stack1 = stack2;
			stack2 = temp;
			isRightToLeft = !isRightToLeft;
		}
		return result;
	}
}
