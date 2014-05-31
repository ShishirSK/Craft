package edu.linkedlist.merge;

import edu.ds.linkedlist.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class MergeSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		// Initial Cases
		if (l1 == null && l2 != null)
			return l2;
		else if (l2 == null && l1 != null)
			return l1;
		if (l1 == null && l2 == null)
			return null;

		ListNode current = null;

		// Populate the start of the list
		if (l1.val < l2.val) {
			current = l1;
			l1 = l1.next;
		} else {
			current = l2;
			l2 = l2.next;
		}

		// The node to be returned
		ListNode head = current;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null) { // No list null
				if (l1.val < l2.val) {
					current.next = l1;
					l1 = l1.next;
					current = current.next;
				} else {
					current.next = l2;
					l2 = l2.next;
					current = current.next;
				}
			} else if (l2 == null && l1 != null) { // One null
				current.next = l1;
				l1 = l1.next;
				current = current.next;
			} else if (l1 == null && l2 != null) { // Other null
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}
		}
		return head;
	}
}