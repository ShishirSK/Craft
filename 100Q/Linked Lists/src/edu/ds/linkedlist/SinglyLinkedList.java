package edu.ds.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a singlt linked list
 * 
 * @author Shishir Kinkar
 */
public class SinglyLinkedList<AnyType> implements Iterable<AnyType> {

	private Node<AnyType> head = null;
	private Node<AnyType> first = null;
	private Node<AnyType> last = null;

	public SinglyLinkedList() {
		head = null;
	}

	/*
	 * Method to add node at the beginning of the list
	 * 
	 * @return - void
	 * 
	 * @param - item - Value of the node
	 */
	public void addFirst(AnyType item) {
		if (head == null) {
			head = new Node<AnyType>(item);
			head.next = null;
		} else {
			first = new Node<AnyType>(item);
			first.next = head;
			head = first;
		}
	}

	/*
	 * Method to add node at the end of the list
	 * 
	 * @return - void
	 * 
	 * @param - item - Value of the node
	 */
	public void addLast(AnyType item) {
		if (head == null) {
			head = new Node<AnyType>(item);
			head.next = null;
		} else {
			last = new Node<AnyType>(item);
			Node<AnyType> n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = last;
			last.next = null;
		}
	}

	/*
	 * Method to get the the beginning node of the list
	 * 
	 * @return - void
	 */
	public Node<AnyType> getFirst() {

		if (head == null)
			throw new NoSuchElementException();
		return head;
	}

	/*
	 * Method to get node at the given position in the list
	 * 
	 * @return - Node - Node at the specific position
	 * 
	 * @param - position - position of the node
	 */
	public Node<AnyType> get(int position) {

		if (head == null)
			throw new IndexOutOfBoundsException();

		Node<AnyType> currNode = head;
		for (int pos = 1; pos < position; pos++) {
			currNode = currNode.next;
		}
		if (currNode == null) {
			throw new IndexOutOfBoundsException();
		} else {
			return currNode;
		}
	}

	/*
	 * Method to show the current linked list
	 * 
	 * @return - void
	 */
	public void showCurrentList() {

		Node<AnyType> n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	@Override
	public Iterator<AnyType> iterator() {
		// TODO
		return null;
	}

}
