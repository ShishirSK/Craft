package edu.tree.symmetric;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center). #Leetcode
 * 
 * @author Shishir Kinkar
 * 
 */
public class IsTreeSymmetric {

	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		else if (root.left == null && root.right == null)
			return true;
		else
			return isSymmetric(root.left, root.right);
	}

	// Method to recursively check symmetry for left and right node trees
	private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {

		if (leftNode == null && rightNode == null) {
			return true;
		} else if ((leftNode == null && rightNode != null)
				|| (leftNode != null && rightNode == null))
			return false;

		if (leftNode.val == rightNode.val)
			return isSymmetric(leftNode.left, rightNode.right)
					&& isSymmetric(leftNode.right, rightNode.left);
		else
			return false;
	}
}