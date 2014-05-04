package linkedlist;

import edu.ds.linkedlist.*;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once. #Leetcode
 * 
 * @author Shishir Kinkar
 * 
 */
public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;

		ListNode currentNode = head;

		while (currentNode.next != null) {
			while (currentNode.next != null
					&& currentNode.val == currentNode.next.val) {
				if (currentNode.next.next == null)
					currentNode.next = null;
				else
					currentNode.next = currentNode.next.next;
			}
			if (currentNode.next != null)
				currentNode = currentNode.next;
		}
		return head;

	}
}
