package com.vmware.interview;

/*
 * remove the nodes which are less than min value and greater than the max value
 */
public class TrimBST {

	public TreeNode trimBST(TreeNode root, int min, int max) {

		if (root == null)
			return null;

		root.left = trimBST(root.left, min, max);

		root.right = trimBST(root.right, min, max);

		if (root.val < min) {
			TreeNode child = root.right;
			root = null;
			return child;
		}

		if (root.val > max) {
			TreeNode child = root.left;
			root = null;
			return child;
		}

		return root;
	}
}

class TreeNode {

	int val;

	TreeNode left;

	TreeNode right;
}
