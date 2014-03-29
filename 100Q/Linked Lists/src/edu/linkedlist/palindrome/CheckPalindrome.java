package edu.linkedlist.palindrome;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
 * Program to check whether a linked list is a palindrome.
 * Note: Uses inbuilt LinkedList 
 * 
 */
public class CheckPalindrome {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		List<Node> list = new LinkedList<Node>();
		createLinkedList(list);
		boolean isPalindrome = checkForPalindrome(list);

		if (isPalindrome) {
			System.out.println("It is a palindrome");
		} else {
			System.out.println("It is not a palindrome");
		}
	}

	/*
	 * Method to generate a linked list.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void createLinkedList(List<Node> list) {

		list.add(new Node('a'));
		list.add(new Node('b'));
		list.add(new Node('c'));
		list.add(new Node('d'));
		list.add(new Node('c'));
		list.add(new Node('b'));
		list.add(new Node('a'));

	}

	/*
	 * Method to check whether the linked list is a palindrome
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean checkForPalindrome(List<Node> list) {

		ListIterator<Node> itr = list.listIterator();
		List aList1 = new ArrayList();
		List aList2 = new ArrayList();

		// Forward array
		while (itr.hasNext()) {
			if (itr.nextIndex() < list.size()) {
				aList1.add(list.get(itr.nextIndex()).data);
			}
			itr.next();
		}

		// Backward array
		while (itr.hasPrevious()) {
			if (itr.previousIndex() >= 0) {
				aList2.add(list.get(itr.previousIndex()).data);
			}
			itr.previous();
		}

		// Compare values of array elements
		for (int i = 0; i < aList1.size(); i++) {
			if (aList1.get(i) != aList2.get(i)) {
				return false;
			}
		}

		return true;
	}

}
