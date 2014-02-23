package potterBooksKata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * Solution of the Potter Kata
 *  
 * @author 	- Shishir Kinkar 
 * 
 * @version - 0.1 	- Initial commit
 *			  0.2 	- Necessary methods + comments
 */

public class PotterBooks {

	private static int setsOf5 = 0, setsOf4 = 0, setsOf3 = 0;

	public static void main(String[] args) throws IOException {

		PotterBooks bookSets = new PotterBooks();
		bookSets.menu();
	}

	/*
	 * Get the number of copies of each book being bought
	 * 
	 * @param - none
	 * 
	 * @return - void
	 * 
	 * @throws - IOException
	 */

	private void menu() throws IOException {

		int[] bookArray = new int[5];
		int[] originalSetsOfBooks;
		int[] optimizedSetsOfBooks;
		double totalAmount;

		System.out.println("Enter the number of copies for each books:");
		BufferedReader bookCount = new BufferedReader(new InputStreamReader(
				System.in));
		// Book 1
		System.out.print("Book 1: ");
		try {
			bookArray[0] = Integer.parseInt(bookCount.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}
		// Book 2
		System.out.print("Book 2: ");
		try {
			bookArray[1] = Integer.parseInt(bookCount.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}
		// Book 3
		System.out.print("Book 3: ");
		try {
			bookArray[2] = Integer.parseInt(bookCount.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}
		// Book 4
		System.out.print("Book 4: ");
		try {
			bookArray[3] = Integer.parseInt(bookCount.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}
		// Book 5
		System.out.print("Book 5: ");
		try {
			bookArray[4] = Integer.parseInt(bookCount.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}

		// Sort the array
		Arrays.sort(bookArray);
		// Make sets of books
		originalSetsOfBooks = makeBookSets(bookArray);
		// Optimize sets for max discount
		optimizedSetsOfBooks = optimizeBookSets(originalSetsOfBooks);
		// Calculate amount
		totalAmount = calculateTotalAmount(optimizedSetsOfBooks);

		System.out.println("The total amount for these books is: "
				+ totalAmount);
	}

	/*
	 * Make sets of 5,4,3,2 books or 1 book as per the entered number of books
	 * 
	 * @param - bookCopies - array with number of copies of each book
	 * 
	 * @return - int[] - number of sets of books
	 */
	private int[] makeBookSets(int[] bookCopies) {

		int[] setsOfBooks = new int[5];

		setsOfBooks[0] = bookCopies[0];
		setsOfBooks[1] = bookCopies[1] - setsOfBooks[0];
		setsOfBooks[2] = bookCopies[2] - setsOfBooks[1] - setsOfBooks[0];
		setsOfBooks[3] = bookCopies[3] - setsOfBooks[2] - setsOfBooks[1]
				- setsOfBooks[0];
		setsOfBooks[4] = bookCopies[4] - setsOfBooks[3] - setsOfBooks[2]
				- setsOfBooks[1] - setsOfBooks[0];

		return setsOfBooks;
	}

	/*
	 * Optimize the sets of 3 and 5 books to create sets of 4 books. This
	 * conversion saves more money as discount on 2 sets of 4 books is more than
	 * that on 1 set of 2 and 5 books each.
	 * 
	 * @param - optimizedSetsOfBooks - sets of books to be optimized
	 * 
	 * @return - int[] - array of optimized sets
	 */
	private int[] optimizeBookSets(int[] optimizedSetsOfBooks) {

		setsOf5 = optimizedSetsOfBooks[0];
		setsOf4 = optimizedSetsOfBooks[1];
		setsOf3 = optimizedSetsOfBooks[2];

		// 1 each of 5 books and 3 books = 2 sets of 4 books
		while (setsOf5 != 0 && setsOf3 != 0) {
			setsOf3--;
			setsOf4 = setsOf4 + 2;
			setsOf5--;
		}

		optimizedSetsOfBooks[0] = setsOf5;
		optimizedSetsOfBooks[1] = setsOf4;
		optimizedSetsOfBooks[2] = setsOf3;

		return optimizedSetsOfBooks;
	}

	/*
	 * Calculate the total amount due for the books
	 * 
	 * @param - optimizedSetsOfBooks - an array with optimized sets of books
	 * 
	 * @return - double - amount due for the books
	 */
	private double calculateTotalAmount(int[] optimizedSetsOfBooks) {

		double amount = 0.0;

		amount = amount + optimizedSetsOfBooks[0] * 5 * 8 * 0.75;
		amount = amount + optimizedSetsOfBooks[1] * 4 * 8 * 0.80;
		amount = amount + optimizedSetsOfBooks[2] * 3 * 8 * 0.90;
		amount = amount + optimizedSetsOfBooks[3] * 2 * 8 * 0.95;
		amount = amount + optimizedSetsOfBooks[4] * 1 * 8 * 1;

		return amount;
	}

}
