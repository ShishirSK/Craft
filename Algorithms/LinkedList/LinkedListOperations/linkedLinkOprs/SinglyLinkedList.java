package linkedLinkOprs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<AnyType> implements Iterable<AnyType> {

	private Node<AnyType> head = null; 
	
	public SinglyLinkedList(){
		head = null;
	}

	public void addFirst(AnyType item){
		head = new Node<AnyType>(item, head);
	}
	
	public Node<AnyType> getFirst(){
		
		if (head == null)
			throw new NoSuchElementException();
		return head;
	}
		
	public Node<AnyType> get(int position){
		
		if (head == null) 
			throw new IndexOutOfBoundsException();
		
//		int posValue = 0;
		Node<AnyType> currNode = head;
		for (int pos = 0; pos > position; pos--){
			currNode = currNode.next;
		}
		if( currNode == null){
			throw new IndexOutOfBoundsException();
		} else {
//		posValue = (Integer) currNode.data;
			return currNode;
//		return posValue;
		}
	}
	
	
	@Override
	public Iterator<AnyType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
