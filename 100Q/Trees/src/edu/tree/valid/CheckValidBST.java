package edu.tree.valid;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows: The left subtree of a node contains only
 * nodes with keys less than the node's key. The right subtree of a node
 * contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class CheckValidBST {

	public boolean isValidBST(TreeNode root) {

		if (root == null) {
			return true;
		}

		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private static boolean isValidBST(TreeNode n, int min, int max) {

		if (n == null) {
			return true;
		}

		if (n.val <= min || n.val >= max) {
			return false;
		}

		if (!isValidBST(n.left, min, n.val) || !isValidBST(n.right, n.val, max)) {
			return false;
		}
		return true;
	}
}