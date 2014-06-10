package edu.linkedlist.cycle;

import edu.ds.linkedlist.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null || head.next.next == null) {
			return false;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}