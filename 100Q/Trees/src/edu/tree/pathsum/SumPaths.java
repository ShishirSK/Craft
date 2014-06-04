package edu.tree.pathsum;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number. An example is the root-to-leaf path 1->2->3 which
 * represents the number 123. Find the total sum of all root-to-leaf numbers.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class SumPaths {
	static int mul = 10;

	public int sumNumbers(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int value = 0;
		if (root.left == null && root.right == null) {
			value = root.val;
		} else {
			value = sumNumbers(root, 0);
		}

		return value;
	}

	private int sumNumbers(TreeNode root, int num) {

		if (root.left == null && root.right == null) {
			return num + root.val;
		}

		int numLeft = 0, numRight = 0;
		int currentNodeVal = (num + root.val) * 10;

		if (root.left != null) {
			numLeft = sumNumbers(root.left, currentNodeVal);
		}

		if (root.right != null) {
			numRight = sumNumbers(root.right, currentNodeVal);
		}

		return numLeft + numRight;
	}
}