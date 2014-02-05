import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * A program to perform various string manipulation operations
 * @author 	- Shishir Kinkar 
 * @version - 0.1 	- Initial commit
 *			  0.2 	- String Reversal
 */
public class StringOperations{
	
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

		int inputOption = 0;

		System.out.println("Enter a string:");
		BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
		String string = str.readLine();

		System.out.println("Choose operation to perform: \n 1. String reversal \n 2. All permutations ");
		BufferedReader opr = new BufferedReader(new InputStreamReader(System.in));

		try{
            inputOption = Integer.parseInt(opr.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }

        // Perform operation based on user input
		switch (inputOption){
			case 1: strReversal(string);
				break;
			case 2: strPermutations(string);
				break;
			default: System.out.println("Choose another operation.");
		}
	}


/*
 * Takes a string, reverses it and returns
 * 
 * @param 	- inputstream 	- A string given by the user
 * @return 	- void 			
 */
	void strReversal(String inputString){

		StringBuffer reverseString = new StringBuffer();
		String[] strArray = new String[inputString.length()];
		
		strArray = inputString.split("");

		for (int strIndex = strArray.length - 1; strIndex >= 0; strIndex--)
		{
			reverseString.append(strArray[strIndex]);
		}

		System.out.println("The reversed string is: " + reverseString.toString());
	}


/*
 * Returns all the permutations of a string
 * 
 * @param 	- inputstream 	- A string given by the user
 * @return 	- void
 */	

	void strPermutations(String inputString){



	}
}