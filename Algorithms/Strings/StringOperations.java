import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
	public static void main(String args[]) throws IOException {

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

		System.out.println("Choose operation to perform: \n 1. String reversal \n 2. Check for all uniques"); 
		System.out.println(" 3. Check if one is permutation of other");
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
			case 2: checkForAllUniques(string);
				break;
			case 3: checkForOnePermOfOther(string);
				break;	
			case 4: strPermutations(string);
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
 * Checks if an entered string is composed of all unique characters
 * 
 * @param 	- inputstream 	- A string given by the user
 * @return 	- void
 */	
	void checkForAllUniques(String inputString){

		int strLength = inputString.length();

		for (int i = 1; i < strLength; i++) {

			char currentChar = inputString.charAt(i);
			if (inputString.substring(i + 1).contains(String.valueOf(currentChar))) {
				System.out.println("String does not contain all unique characters.");
				return;
			}
		}
		System.out.println("String contains all unique characters.");
	}


/*
 * Checks if an entered string is permutation of other string
 * 
 * @param 	- inputstream 	- A string given by the user
 * @return 	- void
 */	

	void checkForOnePermOfOther(String inputString) throws IOException {

		System.out.println("Enter the second string:");
		BufferedReader str2 = new BufferedReader(new InputStreamReader(System.in));
		String inputString2 = str2.readLine();

		if (inputString == inputString2)
			System.out.println("They are same strings!");
		else if (inputString.length() != inputString2.length())
			System.out.println("The strings are not valid permutations.");
		else {

			for (int i = 0; i < inputString.length(); i++) {

				char currentChar = inputString.charAt(i);
				if (!inputString2.contains(String.valueOf(currentChar))) {
					System.out.println("Second string is not a permutation of the first.");
					return;
				}
			}
			System.out.println("Second string is a permutation of the first.");
		}
	}

/*
 * Returns all the permutations of a string - To be implemented
 * 
 * @param 	- inputstream 	- A string given by the user
 * @return 	- void
 */	

	void strPermutations(String inputString){

	}
}