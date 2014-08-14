package edu.tree.sortedlisttotree;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */

public class SLLToBST {

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) { // Null case
			return null;
		}

		// Return treenode if it is a single node linked list
		TreeNode root;
		if (head.next == null) {
			root = new TreeNode(head.val);
			return root;
		}

		// LeftFirst - Keeps track of the start of left half of linked list
		// RightFirst - Keeps track of the start of right half of linked list
		ListNode leftFirst, rightFirst;
		leftFirst = head;

		// LeftLast - Always keeps track of the end of left half of linked list
		ListNode leftLast = new ListNode(0);
		leftLast.next = head;

		// Slow and fast runners to split the list in almost equal halves
		ListNode slow = head, fast = head;

		// Traverse to split
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			leftLast = leftLast.next;
		}

		rightFirst = slow.next; // Start of right half
		slow.next = null;
		leftLast.next = null;
		root = new TreeNode(slow.val); // Current tree node

		root.left = sortedListToBST(leftFirst); // Left half
		root.right = sortedListToBST(rightFirst); // Right half

		return root;
	}
}
