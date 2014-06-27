package edu.linkedlist.rotate;

import edu.ds.linkedlist.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {

		if (head == null)
			return null;
		else if (head.next == null || n == 0) // n = 0 > no rotation
			return head;

		ListNode start;
		if (head.next.next == null) {
			if (n % 2 == 0) { // Same list
				return head;
			} else { // Swapped list
				start = head.next;
				start.next = head;
				head.next = null;
				return start;
			}
		}

		ListNode lead = head;
		ListNode rear = head;

		// Create a linked list loop and get the number of nodes.
		int nodes = 1;
		while (lead.next != null) {
			lead = lead.next;
			nodes++;
		}
		lead.next = head;

		// Even if n is greater than the number of nodes, the number of
		// rotations = n % nodes. Create that gap between runners.
		lead = head;
		for (int i = 0; i < n % nodes; i++) {
			lead = lead.next;
		}

		// With the gap in runners, when the next node is head again, the
		// elements after rear are to be rotated.
		while (lead.next != head) {
			lead = lead.next;
			rear = rear.next;
		}

		// List ends at rear, rotated list starts from rear.next
		start = rear.next;
		rear.next = null;
		return start;
	}
}
