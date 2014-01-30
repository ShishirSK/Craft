/*
 * A simple implementation of a singly linked list.
 * @author: Shishir Kinkar
 */

class Node{
	
	Node next = null;
	int nodeData;

	public Node(int d){
		nodeData = d;
	}

	void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;

		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}

/*
 * A method to delete a specific node from the linked list
 * Points to remember: 
 * 1. Check for null nodes
 * 2. Update head and tail nodes
 */

	Node deleteNode(Node head, int d){

		Node n = head;

		if (n.nodeData == d) {
			head = n.next;
			return head;
		}

		while (n.next != null){
			if (n.next.nodeData == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}

		return head;
	}

/*
 * A method to insert a node at the head of the linked list
 *
 */

	void insertNodeAtHead(Node head, int d){

		Node n = new Node(d);
		n.next = head;		

	}


}









