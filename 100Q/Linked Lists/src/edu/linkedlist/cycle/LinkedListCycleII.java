package edu.linkedlist.cycle;

import java.util.HashSet;
import java.util.Set;

import edu.ds.linkedlist.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class LinkedListCycleII {
	Set<ListNode> nodes = new HashSet<ListNode>();
	ListNode tracker;

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null) {
			return null;
		}
		tracker = head;
		nodes.add(tracker);
		while (tracker.next != null) {
			tracker = tracker.next;
			if (!nodes.contains(tracker)) {
				nodes.add(tracker);
			} else {
				return tracker;
			}
		}
		return null;
	}
}