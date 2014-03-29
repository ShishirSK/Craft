package edu.linkedlist.duplicates;

import edu.linkedlist.common.*;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class RemoveDuplicates {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		List<Node> list = new LinkedList<Node>();
		createLinkedList(list);
		// Original list
		System.out.println("Original list: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + list.get(i).data + " ");
		}
		System.out.println();
		removeDuplicates(list);

		// List after removing duplicates, if any
		System.out.println("Result: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" " + list.get(i).data + " ");
		}
		System.out.println();
	}

	/*
	 * Method to add nodes to a linked list.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void createLinkedList(List<Node> list) {
		list.add(new Node('1'));
		list.add(new Node('2'));
		list.add(new Node('3'));
		list.add(new Node('4'));
		list.add(new Node('5'));
		list.add(new Node('3'));
		list.add(new Node('7'));
	}

	/*
	 * Method to remove duplicates from the linked list Uses iterator. Checks
	 * for presence of the key in a Hashtable
	 */
	@SuppressWarnings("rawtypes")
	private static void removeDuplicates(List<Node> dupList) {

		Hashtable<Object, Integer> nodeMap = new Hashtable<Object, Integer>();
		ListIterator<Node> itr = dupList.listIterator();
		boolean flagAsDuplicate = false;
		int nextIndex = 0;

		// Iterate through the list
		while (itr.hasNext()) {
			nextIndex = itr.nextIndex();

			// Index and values of list elements
			// System.out.println("Next Index is: " + nextIndex);
			// System.out.println("Next Element is: "
			// + dupList.get(itr.nextIndex()).data);

			// Check if the value has been flagged as duplicate
			if (flagAsDuplicate) {
				itr.remove();
				flagAsDuplicate = false;
			}
			// As long as the index is less than the list size, check
			// for value being present in the hashtable. If not, insert it.
			if (nextIndex < dupList.size()) {
				if (nodeMap.containsKey(dupList.get(nextIndex).data)) {
					flagAsDuplicate = true;
				} else {
					nodeMap.put(dupList.get(nextIndex).data, nextIndex);
				}
			}
			itr.next();
		}
	}
}
