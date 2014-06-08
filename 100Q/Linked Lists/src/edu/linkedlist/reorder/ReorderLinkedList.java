package edu.linkedlist.reorder;

import edu.ds.linkedlist.ListNode;

/**
 * Given a singly linked list L: L0 > L1 > ... > Ln-1 > Ln, reorder it to: L0 >
 * Ln > L1 > Ln-1 > L2 > Ln-2 > ... You must do this in-place without altering
 * the nodes' values. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class ReorderLinkedList {

	public void reorderList(ListNode head) {

		if (head == null || head.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode reverseHead = slow.next; // find the second half of list
		slow.next = null; // make first half end point to null
		reverseHead = reverse(reverseHead); // reverse second half
		ListNode cur = head;
		while (reverseHead != null) { // link together
			ListNode tmp = reverseHead.next;
			reverseHead.next = cur.next;
			cur.next = reverseHead;
			cur = cur.next.next;
			reverseHead = tmp;
		}
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = new ListNode(0);
		prev.next = head;
		head = prev;
		ListNode cur = prev.next;
		while (cur.next != null) {
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = prev.next;
			prev.next = tmp;
		}
		return prev.next;
	}
}