package edu.linkedlist.common;

public class Node<AnyType> {

	@SuppressWarnings("rawtypes")
	Node next = null;
	public AnyType data;
	
	public Node(AnyType d){
		this.data = d;
	}
}
