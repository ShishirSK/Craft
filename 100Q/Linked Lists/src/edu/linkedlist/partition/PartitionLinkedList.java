package edu.linkedlist.partition;

import edu.ds.linkedlist.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x. You should preserve the
 * original relative order of the nodes in each of the two partitions. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class PartitionLinkedList {

	public ListNode partition(ListNode head, int x) {

		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode start, slow, fast;

		if (head.val >= x) {
			slow = new ListNode(0);
			slow.next = head;
			fast = head;
			start = slow;
		} else {
			slow = head;
			fast = head;
			start = head;
		}

		while (slow.next != null && slow.next.val < x) {
			slow = slow.next;
		}

		// Important check - to ensure that the pivot value is within the list
		if (slow.next == null)
			return head;

		ListNode pivot = slow.next;

		// Important - Update the reference of fast to start from next value of
		// slow.
		fast = slow.next;

		while (fast.next != null) {

			if (fast.next.val < x) {
				slow.next = fast.next;
				fast.next = fast.next.next;
				slow.next.next = pivot;
				slow = slow.next;
			} else {
				fast = fast.next;
			}
		}

		if (head.val >= x)
			return start.next;
		else
			return start;
	}
}