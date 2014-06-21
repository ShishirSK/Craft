package edu.linkedlist.reverse;

import edu.ds.linkedlist.ListNode;

/**
 * Reverse a Singly Linked List
 * 
 * @author Shishir Kinkar
 * 
 */
public class ReverseSLL {

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = new ListNode(0);
		ListNode node = head;

		while (head.next != null) {
			temp.next = head.next;
			head.next = temp.next.next;
			temp.next.next = node;
			node = temp.next;
		}
		return node;
	}
}
