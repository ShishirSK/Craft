package edu.linkedlist.swappairs;

import edu.ds.linkedlist.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class SwapPairs {

	public ListNode swapPairs(ListNode head) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode firstNode = null, secondNode = null, start = null;
		start = head.next;

		while (head != null && head.next != null) { // ***//
			firstNode = head.next;
			secondNode = head;
			head = firstNode.next;
			firstNode.next = secondNode;
			if (head != null && head.next != null) { // ***//
				secondNode.next = head.next;
			} else {
				secondNode.next = head;
			}
		}
		return start;
	}
}