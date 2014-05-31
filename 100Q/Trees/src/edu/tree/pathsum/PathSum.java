package edu.tree.pathsum;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null)
			return false;

		sum -= root.val;

		if (root.left == null && root.right == null && sum == 0)
			return true;

		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	}
}
