package edu.tree.equal;

import java.util.ArrayList;
import edu.ds.tree.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class SameTreeOne {

	ArrayList<Boolean> treeOne = new ArrayList<Boolean>();
	ArrayList<Boolean> treeTwo = new ArrayList<Boolean>();
	ArrayList<Object> treeOneVal = new ArrayList<Object>();
	ArrayList<Object> treeTwoVal = new ArrayList<Object>();

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		mapTree(p, treeOne, treeOneVal);
		mapTree(q, treeTwo, treeTwoVal);

		if (treeOneVal.size() != treeTwoVal.size()
				|| treeOne.size() != treeTwo.size())
			return false;

		for (int i = 0; i < treeOne.size(); i++) {
			if (treeOne.get(i) != treeTwo.get(i))
				return false;
		}
		for (int j = 0; j < treeOneVal.size(); j++) {
			if (treeOneVal.get(j).equals(treeTwoVal.get(j)))
				continue;
			else
				return false;
		}
		return true;
	}

	/**
	 * @param n
	 *            - Tree node
	 * @param bList
	 *            - Boolean list representing children
	 * @param valList
	 *            - Object list with node values
	 */
	private void mapTree(TreeNode n, ArrayList<Boolean> bList,
			ArrayList<Object> valList) {

		valList.add(n.val);
		bList.add(true);

		if (n.left != null) {
			mapTree(n.left, bList, valList);
		} else {
			bList.add(false);
		}

		if (n.right != null) {
			mapTree(n.right, bList, valList);
		} else {
			bList.add(false);
		}
	}
}
