package edu.ds.linkedlist;

/**
 * A linked list node
 * 
 * @author Shishir Kinkar
 */
public class Node<AnyType> {

	AnyType data;
	Node<AnyType> next;

	public Node(AnyType data) {
		this.data = data;

	}
}