import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * A program to perform various LinkedList operations
 * @author 	- Shishir Kinkar 
 * @version - 0.1 	- Initial commit
 *			  0.2   - Add Node
 */

public class LinkedListOperations {

	static LinkedList<Integer> defaultList = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException{	
	
		// Create a default list
		System.out.println("The default list elements are: ");
		for	(int i = 1; i < 6; i++)	{
			defaultList.add(i);
			System.out.print(i + " ");	
		}
		System.out.println();

		LinkedListOperations starter = new LinkedListOperations();
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

		System.out.println("Linked List operations: \n 1. Add nodes to the list"); 
		System.out.println(" 2. Remove Duplicates (with buffer)");
		System.out.println(" 3. Remove Duplicates (without buffer)"); 
		System.out.println(" 4. Find Kth to last element \n 5. Delete a node in the middle of a SLL ");
		System.out.print("Choose operation to perform: ");
		BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

		try{
            inputOption = Integer.parseInt(opr.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }

        // Perform operation based on user input
		switch (inputOption){
			case 1: addNode();
				break;
			case 2: removeDuplicateWB();
				break;
			case 3: removeDuplicateWOB();
				break;
			case 4: findKthToLast();
				break;
			case 5: deleteMiddleNode();
				break;
			default: System.out.println("Choose another operation.");
		}

	}

	void addNode() throws IOException {

		int nodeValue = 0;
		System.out.println(defaultList.size());
		System.out.print("Add a value of node to be added: ");

		BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

		try{
            nodeValue = Integer.parseInt(opr.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            return;
        }

		defaultList.add(nodeValue);
		System.out.println(defaultList.size());
	}


/*
 * Program to remove duplicates from a linked list with buffer
 * 
 * @return 	- void 			
 */
	void removeDuplicateWB(){



	}

/*
 * Program to remove duplicates from a linked list without buffer
 * 
 * @return 	- void 			
 */
	void removeDuplicateWOB(){



	}

/*
 * Find Kth element in a linked list
 * 
 * @return 	- void 			
 */
	void findKthToLast(){

	}

/*
 * Delete a middle node
 * 
 * @return 	- void 			
 */
	void deleteMiddleNode(){

	}
}

