package edu.tree.traversal.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.ds.tree.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level). #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class LevelOrder {

	// Stack with nodes of next level with left node at bottom and right at top
	// - in reverse sequence of what is needed. Pop into mainStack for proper
	// sequence
	Stack<TreeNode> bufferStack = new Stack<TreeNode>();

	// Stack with nodes of current level - after popping from bufferStack into
	// this stack
	Stack<TreeNode> mainStack = new Stack<TreeNode>();
	List<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> currentList = null;

	public List<ArrayList<Integer>> levelOrder(TreeNode root) {

		TreeNode current;
		if (root == null) {
			return retList;
		} else {
			bufferStack.push(root);
		}

		while (!(mainStack.isEmpty() && bufferStack.isEmpty())) {

			if (!(mainStack.isEmpty())) {
				current = mainStack.pop();
				currentList.add(current.val);
				if (current.left != null)
					bufferStack.push(current.left);
				if (current.right != null)
					bufferStack.push(current.right);
			}

			if (mainStack.isEmpty() && currentList != null) {
				retList.add(currentList);
				currentList = null;
			}

			if (mainStack.isEmpty() && !bufferStack.isEmpty()) {
				currentList = new ArrayList<Integer>();
				while (!(bufferStack.isEmpty())) {
					mainStack.push(bufferStack.pop());
				}
			}
		}
		return retList;
	}
}