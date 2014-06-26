package edu.linkedlist.add;

import edu.ds.linkedlist.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class AddLists {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null && l2 == null)
			return l2;
		else if (l1 != null && l2 == null)
			return l1;
		else if (l2 != null && l1 == null)
			return l2;

		ListNode sum = doSum(l1, l2, 0);
		return sum;
	}

	private ListNode doSum(ListNode first, ListNode second, int carry) {

		if (first == null && second == null && carry == 0) {
			return null;
		} else if (first == null && second == null && carry == 1) {
			return new ListNode(1);
		}

		int value = carry;

		if (first != null)
			value += first.val;
		if (second != null)
			value += second.val;

		ListNode result = new ListNode(value % 10);

		// Good way to check conditions and pass values
		ListNode nextNode = doSum(first == null ? null : first.next,
				second == null ? null : second.next, value > 9 ? 1 : 0);

		result.next = nextNode;
		return result;
	}

}
