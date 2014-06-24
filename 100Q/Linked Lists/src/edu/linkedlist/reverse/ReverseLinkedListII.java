package edu.linkedlist.reverse;

import edu.ds.linkedlist.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null) {
			return null;
		}

		if (head.next == null)
			return head;

		int current = 1;
		ListNode temp = new ListNode(0);
		ListNode node, before;
		ListNode start = head;

		if (m == 1) {
			before = null;
			temp.next = head;
			node = head;
		} else {

			while (head != null) {

				if (m == current + 1) {
					break;
				} else {
					head = head.next;
					current += 1;
				}
			}

			before = head;
			head = head.next;
			temp.next = head;
			before.next = temp;
			node = temp.next;

		}

		current = m;

		while (head.next != null) {
			if (current >= m && current < n) {
				temp.next = head.next;
				head.next = temp.next.next;
				temp.next.next = node;
				current++;
				node = temp.next;
			} else if (current >= n) {
				head = head.next;
			}
		}

		if (!(before == null)) {
			before.next = temp.next;
			return start;
		} else {
			temp.next = null;
			return node;
		}
	}
}