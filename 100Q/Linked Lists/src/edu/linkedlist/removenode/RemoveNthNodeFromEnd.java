package edu.linkedlist.removenode;

import edu.ds.linkedlist.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return null;
		}

		ListNode indexNode = head;
		ListNode traceNode = head;
		int index = 0;

		// When indexNode has next as null, next of traceNode is Nth node
		while (index < n) {
			indexNode = indexNode.next;
			index++;
		}

		// indexNode as null = need to remove the first node
		if (indexNode != null) {
			while (indexNode.next != null) {
				traceNode = traceNode.next;
				indexNode = indexNode.next;
			}
		} else {
			head = head.next;
			return head;
		}
		ListNode node = traceNode.next;
		traceNode.next = node.next;

		return head;
	}
}