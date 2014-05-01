package edu.tree.traversal;

import java.util.ArrayList;
import java.util.Stack;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, return the pre-order traversal of its nodes' values.
 * Iterative solution #LeetCode
 * 
 * @author Shishir Kinkar
 */

public class PreOrderBT {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {

		ArrayList<Integer> valList = new ArrayList<Integer>();
		Stack<TreeNode> tNodes = new Stack<TreeNode>();
		TreeNode n = root;

		while (true) {
			if (n != null) {
				valList.add(n.val);
				tNodes.push(n);
				n = n.left;
			} else if (n == null && !tNodes.empty()) {
				n = tNodes.pop();
				n = n.right;
			} else if (n == null && tNodes.empty()) {
				break;
			}
		}
		return valList;
	}
}
