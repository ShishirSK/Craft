package linkedLinkOprs;

import java.util.Hashtable;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * A program to perform various Singly LinkedList operations.
 * This program resumes from where LinkedListOperations.java left off.
 *  
 * @author 	- Shishir Kinkar 
 * @version - 0.1 	- Initial commit
 *			  0.2 	- Create SinglyLinkedList class and Node class
 *					- Delete duplicates with buffer
 *			  0.3	- Delete duplicates without buffer, Find Kth to last
 *					  and delete a middle node 
 */

public class SLLOperations {

		static SinglyLinkedList<Integer> defaultList = new SinglyLinkedList<Integer>();

		public static void main(String[] args) throws IOException{	
					
			// Create a default list
			for	(int i = 1; i < 6; i++)	{
				defaultList.addLast(i);
			}
			
			SLLOperations starter = new SLLOperations();
			starter.menu();
		}


	/*
	 * Displays a menu of operations that can be performed, and asks the user
	 * to choose an operation
	 * 
	 * @param 	- none
	 * @return 	- void
	 * @throws	- IOException
	 */
		void menu() throws IOException {

			int inputOption = 0;
			// Create menu
			System.out.println("Linked List operations: \n 1. Add node at the beginning of the list");
			System.out.println(" 2. Add node at the end of the list");
			System.out.println(" 3. Remove Duplicates (with buffer)");
			System.out.println(" 4. Remove Duplicates (without buffer)"); 
			System.out.println(" 5. Find Kth to last element \n 6. Delete a node in the middle of a SLL ");
			System.out.print("Current list is:");
			
			defaultList.showCurrentList();
			
			System.out.print("Choose operation to perform: ");
			
			BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));
			try{
	            inputOption = Integer.parseInt(opr.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	        }

	        // Perform operation based on user input
			switch (inputOption){
				case 1: addFirstNode();
					break;
				case 2: addLastNode();
					break;
				case 3: removeDuplicateWB();
					break;
				case 4: removeDuplicateWOB();
					break;
				case 5: findKthToLast();
					break;
				case 6: deleteAMiddleNode();
					break;
				default: System.out.println("Choose another operation.");
			}
		}

	/*
	 * Method to add node at the beginning of the list
	 * 
	 * @return 	- void 			
	 */
		void addFirstNode() throws IOException {

			int nodeValue = 0;
			System.out.print("Add a value of node to be added: ");

			BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

			try{
	            nodeValue = Integer.parseInt(opr.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	            return;
	        }

			defaultList.addFirst(nodeValue);
			// Go back to the menu
			menu();
		}

	/*
	 * Method to add node at the end of the list
	 * 
	 * @return 	- void 			
	 */
		void addLastNode() throws IOException {

			int nodeValue = 0;
			System.out.print("Add a value of node to be added: ");

			BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

			try{
	            nodeValue = Integer.parseInt(opr.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	            return;
	        }

			defaultList.addLast(nodeValue);
			// Go back to the menu
			menu();
		}
			
	/*
	 * Program to remove duplicates from a linked list with buffer
	 * 
	 * @return 	- void 			
	 */
		void removeDuplicateWB(){
			
			defaultList.showCurrentList();
			Hashtable<Integer, Boolean> refTable = new Hashtable<Integer, Boolean>();
			Node<Integer> currentNode = defaultList.getFirst();
			Node<Integer> previous = null;
			while (currentNode != null){
				if (refTable.containsKey(currentNode.data)){
					System.out.println("Duplicate found: " + currentNode.data); // Show duplicate value
					previous.next = currentNode.next;
				} else {
					refTable.put((Integer) currentNode.data, true);
					previous = currentNode;
				}	
				currentNode = currentNode.next;
			}
			defaultList.showCurrentList();
		}

	/*
	 * Program to remove duplicates from a linked list without buffer
	 * 
	 * @return 	- void 			
	 */
		void removeDuplicateWOB(){

			Node<Integer> refNode = defaultList.getFirst();
			Node<Integer> currentNode = refNode.next;
			Node<Integer> previous  = refNode;
			previous.next = currentNode;
		// refNode is static for each iteration, while checking for duplicate values in the 
		// remainder of the list. 
			defaultList.showCurrentList();
			
			while (refNode != null) {
				previous  = refNode;
				currentNode = refNode.next;

				while (currentNode != null) {
					if (currentNode.data == refNode.data){
						previous.next = currentNode.next;
					} else {
						previous = currentNode;
					}
					currentNode = currentNode.next;
				}
				refNode = refNode.next;
			}
			defaultList.showCurrentList();
		}

	/*
	 * Find Kth element in a linked list
	 * 
	 * @return 	- void 			
	 */
		void findKthToLast() throws IOException{

			int nodePosition = 0;
			
			// Get the position from the user
			System.out.print("Add the position to find, from the last one: ");
			BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

			try{
	            nodePosition = Integer.parseInt(opr.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	            return;
	        }
			
			// One pointer stays behind the other one by K - 1 locations
			Node<Integer> leadPosition = defaultList.getFirst();
			Node<Integer> kthPosition = defaultList.getFirst();
			
			for (int i = 1; i < nodePosition; i++)
				leadPosition = leadPosition.next;
			
			while(leadPosition.next != null){
				leadPosition = leadPosition.next;
				kthPosition  = kthPosition.next;
			}
			System.out.print("The current list is: ");
			defaultList.showCurrentList();
			System.out.println("Position " + nodePosition + " from last is: " + kthPosition.data);
			
		}

	/*
	 * Delete a middle node
	 * 
	 * @return 	- void 			
	 */
		void deleteAMiddleNode() throws IOException{

			int nodePosition = 0;
			Node<Integer> nodeToDelete = null;
			
			// Get the position from the user
			System.out.print("Add the node position to delete: ");
			BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

			try{
	            nodePosition = Integer.parseInt(opr.readLine());
	        }catch(NumberFormatException nfe){
	            System.err.println("Invalid Format!");
	            return;
	        }
			
			System.out.print("The original list was: ");
			defaultList.showCurrentList();
			
			// Move next node to node to be deleted and delete the next one
			nodeToDelete = defaultList.get(nodePosition);
			System.out.println("Node To Delete: " + nodeToDelete.data);
			nodeToDelete.data = nodeToDelete.next.data;
			nodeToDelete.next = nodeToDelete.next.next;
			
			System.out.println("The list after deleting the node is:");
			defaultList.showCurrentList();
		}
}



