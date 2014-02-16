package linkedLinkOprs;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Shishir Kinkar
 *
 */
public class SinglyLinkedList<AnyType> implements Iterable<AnyType> {

	private Node<AnyType> head = null; 
	private Node<AnyType> first = null;
	public SinglyLinkedList(){
		head = null;
	}

	/*
	 * Method to add node at the beginning of the list
	 * 
	 * @return 	- void 			
	 * @param	- item	- Value of the node
	 */
	public void addFirst(AnyType item){
		if (head == null){
			head = new Node<AnyType>(item);
			head.next = null;
		}
		else {
			first = new Node<AnyType>(item);
			first.next = head;
			head = first;
		}
	}

	/*
	 * Method to get the the beginning node of the list
	 * 
	 * @return 	- void 			
	 */
	public Node<AnyType> getFirst(){

		if (head == null)
			throw new NoSuchElementException();
		return head;
	}

	/*
	 * Method to add node at the given position in the list
	 * 
	 * @return 	- void 			
	 * @param	- position	- position of the node
	 */	
	public Node<AnyType> get(int position){

		if (head == null) 
			throw new IndexOutOfBoundsException();

		Node<AnyType> currNode = head;
		for (int pos = 0; pos > position; pos--){
			currNode = currNode.next;
		}
		if( currNode == null){
			throw new IndexOutOfBoundsException();
		} else {
			return currNode;
		}
	}


	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


}
