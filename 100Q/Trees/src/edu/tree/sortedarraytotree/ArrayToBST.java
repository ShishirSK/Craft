package edu.tree.sortedarraytotree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class ArrayToBST {

	public TreeNode sortedArrayToBST(int[] array) {
		TreeNode root = sortedArrayToBST(array, 0, array.length - 1);
		return root;
	}

	private TreeNode sortedArrayToBST(int[] arr, int start, int end) {

		if (end < start)
			return null;

		int mid = (int) (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = sortedArrayToBST(arr, start, mid - 1);
		n.right = sortedArrayToBST(arr, mid + 1, end);
		return n;
	}
}
