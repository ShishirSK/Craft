import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * A program to perform various LinkedList operations
 * @author 	- Shishir Kinkar 
 * @version - 0.1 	- Initial commit
 *
 */

public class LinkedListOperations {

	public static void main(String[] args) throws IOException{

		LinkedList<Integer> defaultList = new LinkedList<Integer>();
	
		// Create a default list
		System.out.println("The default list elements are: ");
		for	(int i = 1; i < 6; i++)	{
			defaultList.add(i);
			System.out.println(i + " ");	
		}
	
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

		// System.out.print("Enter a string: ");
		// BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
		// String string = str.readLine();

		System.out.println("Linked List operations: \n 1. Remove Duplicates (with buffer)"); 
		System.out.println(" 2. Remove Duplicates (without buffer)"); 
		System.out.println(" 3. Find Kth to last element \n 4. Delete a node in the middle of a SLL ");
		System.out.print("Choose operation to perform: ");
		BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

		try{
            inputOption = Integer.parseInt(opr.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }

        // Perform operation based on user input
		switch (inputOption){
			case 1: removeDuplicateWB();
				break;
			case 2: removeDuplicateNB();
				break;
			case 3: findKthToLast();
				break;
			case 4: deleteMiddleNode();
				break;
			default: System.out.println("Choose another operation.");
		}

	}

/*
 * Program to remove duplicates from a linked list with buffer
 * 
 * @return 	- void 			
 */
	void removeDuplicateNB(){

	}

/*
 * Program to remove duplicates from a linked list without buffer
 * 
 * @return 	- void 			
 */
	void removeDuplicateWB(){

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

