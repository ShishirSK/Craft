package linkedLinkOprs;

public class Node<AnyType> {

		AnyType data;
	    Node<AnyType> next; 
		
		public Node(AnyType data, Node<AnyType> next){
			this.data = data;
			this.next = next;
		
	}
}
