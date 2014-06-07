package edu.tree.flatten;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place. #LeetCode
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * @author Shishir Kinkar
 * 
 */
public class FlattenTree {
	public void flatten(TreeNode root) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}

		if (root.left != null) {
			flatten(root.left);
		}

		if (root.right != null) {
			flatten(root.right);
		}

		TreeNode nextLink;
		if (root.left != null) {
			if (root.right == null) {
				nextLink = null;
			} else {
				nextLink = root.right;
			}

			root.right = root.left;
			root.left = null;
			// Consideration for a flattened sub-tree
			while (root.right != null) {
				root = root.right;
			}
			root.right = nextLink;
		}
	}
}