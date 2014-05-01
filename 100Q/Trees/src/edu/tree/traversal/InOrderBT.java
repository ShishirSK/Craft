package edu.tree.traversal;

import java.util.ArrayList;
import java.util.Stack;
import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * Iterative solution #LeetCode
 * 
 * @author Shishir Kinkar
 */

public class InOrderBT {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {

		ArrayList<Integer> valList = new ArrayList<Integer>();
		Stack<TreeNode> tNodes = new Stack<TreeNode>();
		TreeNode n = root;

		while (true) {
			if (n != null) {
				tNodes.push(n);
				n = n.left;
			} else if (n == null && !tNodes.empty()) {
				n = tNodes.pop();
				valList.add(n.val);
				n = n.right;
			} else if (n == null && tNodes.empty()) {
				break;
			}
		}
		return valList;
	}
}
