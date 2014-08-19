package edu.tree.maxpathsum;

import edu.tree.sortedarraytotree.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * @author Shishir Kinkar
 * 
 */
public class MaxPathSum {

	// Keeps track of the max path at any node in the tree
	int maxPathYet;

	public int maxPathSum(TreeNode root) {

		if (root == null) {
			return 0;
		}

		// Only one node
		if (root.left == null && root.right == null) {
			return root.val;
		}
		maxPathYet = Integer.MIN_VALUE; // Edge case: Can have negative max values

		// Get max path at the root node
		int maxChildSum = getMaxPath(root);

		// Either the path at root, or somewhere in the tree is max one. Return that.
		return maxPathYet > maxChildSum ? maxPathYet : maxChildSum;
	}

	private int getMaxPath(TreeNode root) {

		if (root == null) {
			return 0;
		}

		// Max path on left
		int leftPath = getMaxPath(root.left);
		// Max path on right
		int rightPath = getMaxPath(root.right);
		// Current node value
		int currentVal = root.val;

		int currentMaxSum = 0, currentMaxPath = 0;

		// If value at root >= values at root + child paths
		if (currentVal >= (currentVal + leftPath) && currentVal >= (currentVal + rightPath)) {
			currentMaxSum = currentVal;
			currentMaxPath = currentVal;
		} 
		// If root + left child path > just root or root + right child
		else if ((currentVal + leftPath) > currentVal && (currentVal + leftPath) >= (currentVal + rightPath)) {
			currentMaxSum = currentVal + leftPath;
			currentMaxPath = currentVal + leftPath;
		} 
		// If root + right child path > just root or root + left child
		else if ((currentVal + rightPath) > currentVal && (currentVal + rightPath) >= (currentVal + leftPath)) {
			currentMaxSum = currentVal + rightPath;
			currentMaxPath = currentVal + rightPath;
		}

		// If max path is root + left + right
		if ((currentVal + leftPath + rightPath) > currentMaxPath) {
			currentMaxPath = currentVal + leftPath + rightPath;
		}

		// If path at current node > any max path yet
		if (currentMaxPath > maxPathYet) {
			maxPathYet = currentMaxPath;
		}

		// Return path for this child side
		return currentMaxSum;
	}
}