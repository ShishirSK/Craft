package edu.tree.balanced;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced. For this problem, a
 * height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class BalancedTree {

	/**
	 * Method to return the height of the tree and tell if it is unbalanced.
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		int height = 0;
		height = getHeight(root);
		if (height == -1)
			return false;
		else
			return true;
	}

	/**
	 * Method to return the height of the tree 
	 * 
	 * @param x
	 *            - Node
	 * @return - int - Height or -1
	 */
	private int getHeight(TreeNode x) {

		if (x == null)
			return 0;

		// Left branch
		int lHeight = getHeight(x.left);
		if (lHeight == -1)
			return lHeight;

		// Right branch
		int rHeight = getHeight(x.right);
		if (rHeight == -1)
			return rHeight;

		int heightDiff = lHeight - rHeight;
		// Parameter to control allowed difference
		if (Math.abs(heightDiff) > 1) {
			System.out.println("Height Difference: " + heightDiff);
			return -1;
		} else {
			return Math.max(lHeight, rHeight) + 1;
		}
	}
}
