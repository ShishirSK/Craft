import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * A program to perform various string manipulation operations
 * @author 	- Shishir Kinkar 
 * @version - 0.1 	- Initial commit
 */
public class StringOperations{
	
	private String reversedString = null;
	private String[] permutedStrings = null;

/*
 * Gives the menu for the program 
 * 
 * @throws	- IOException
 */
	public static void main(String[] args) throws IOException {

		StringOperations allOps = new StringOperations();
		allOps.menu();

	}

/*
 * Promts the user to enter a string, displays a menu of operations that can be performed,
 * and asks the user to choose an operation
 * 
 * @param 	- none
 * @return 	- void
 * @throws	- IOException
 */
	void menu() throws IOException {

		String string = null;
		int inputOption = 0;

		System.out.println("Enter a string:");
		BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
		string = str.readLine();

		System.out.println("Choose operation to perform: \n 1. String reversal \n 2. All permutations ");
		BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

		try{
            inputOption = Integer.parseInt(opr.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }

        // Perform operation based on user input
		switch (inputOption){
			case 1: reversedString = strReversal(string);
				break;
			case 2: permutedStrings = strPermutations(string);
				break;
			default: System.out.println("Choose another operation.");
		}

	}


/*
 * Takes a string, reverses it and returns
 * 
 * @param 	- none
 * @return 	- void
 */
	String strReversal(String inputString){
		String returnString = null;


		return returnString;
	}


/*
 * Returns all the permutations of a string
 * 
 * @param 	- none
 * @return 	- void
 */	

	String[] strPermutations(String inputString){
		String[] strPermutations = null;


		return strPermutations;
	}
}