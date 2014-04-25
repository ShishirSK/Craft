package edu.tree.maxdepth;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, find its maximum depth. The maximum depth is the number
 * of nodes along the longest path from the root node down to the farthest leaf
 * node. #LeetCode
 * 
 * @author Shishir
 * 
 */

public class MaximumDepth {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int maximumDepth = maxDepth(root, 1);
		return maximumDepth;
	}

	private int maxDepth(TreeNode n, int depth) {
		int depthLeft = depth;
		int depthRight = depth;

		if (n.left != null) {
			depthLeft++;
			depthLeft = maxDepth(n.left, depthLeft);
		}

		if (n.right != null) {
			depthRight++;
			depthRight = maxDepth(n.right, depthRight);
		}

		if (depthLeft == depthRight)
			return depthLeft;

		return (depthLeft > depthRight) ? depthLeft : depthRight;
	}
}