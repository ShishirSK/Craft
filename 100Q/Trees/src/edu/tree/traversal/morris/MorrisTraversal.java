package edu.tree.traversal.morris;

import java.util.ArrayList;
import java.util.List;

import edu.tree.sortedarraytotree.TreeNode;

/**
 * Inorder tree traversal without recursion or stack - Morris Traversal
 * 
 * Ref:
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and
 * -without-stack/
 * 
 * Tested on: https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author Shishir Kinkar
 */
public class MorrisTraversal {

	public List<Integer> inOrder(TreeNode root) {

		List<Integer> inList = new ArrayList<Integer>();
		if (root == null)
			return inList;

		TreeNode current = root;
		while (current != null) {

			// If no left node, add the current node to list and move right
			if (current.left == null) {
				inList.add(current.val);
				current = current.right;
			} else {
				// Find the predecessor
				TreeNode pre = current.left;
				// Predecessor is right most node in current's left tree
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}

				// If right is null, create a link to current
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
					// If it is already current, add its value, reset the link
					// and move current
				} else if (pre.right == current) {
					inList.add(current.val);
					pre.right = null;
					current = current.right;
				}
			}
		}

		return inList;
	}

}
