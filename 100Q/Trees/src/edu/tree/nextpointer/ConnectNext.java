package edu.tree.nextpointer;

import java.util.Stack;

/**
 * Given a binary tree, Populate each next pointer to point to its next right
 * node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL. #LeetCode
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author Shishir Kinkar
 * 
 */
public class ConnectNext {

	static Stack<TreeLinkNode> leftBranch = new Stack<TreeLinkNode>();
	static Stack<TreeLinkNode> rightBranch = new Stack<TreeLinkNode>();

	public void connect(TreeLinkNode root) {

		if (root == null)
			return; // Edge case > Root == null

		if (root.left != null) {
			root.left.next = root.right;
			leftBranch.push(root.left);
			rightBranch.push(root.right);
			connect(root.left);
		} else {
			if (!leftBranch.empty()) {
				leftBranch.pop();
				rightBranch.pop();
			}
			return;
		}

		if (root.right != null) {
			if (!rightBranch.empty()) {
				root.right.next = rightBranch.peek().left;
				leftBranch.push(root.right);
				rightBranch.push(rightBranch.peek().left);
			}
			connect(root.right);
		} else {
			if (!rightBranch.empty()) {
				leftBranch.pop();
				rightBranch.pop();
			}
			return;
		}
		if (!rightBranch.empty()) {
			leftBranch.pop();
			rightBranch.pop();
		}
		return;
	}
}
