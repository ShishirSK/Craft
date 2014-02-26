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
 *			  1.0   - Refactored
 */

public class PotterBooks {

	private static int setsOf5 = 0, setsOf4 = 0, setsOf3 = 0;
	private static int bookCost = 8;

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

		System.out
				.println("Enter the number of copies for each of the 5 books:");
		BufferedReader bookCount = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			bookArray[0] = Integer.parseInt(bookCount.readLine());
			bookArray[1] = Integer.parseInt(bookCount.readLine());
			bookArray[2] = Integer.parseInt(bookCount.readLine());
			bookArray[3] = Integer.parseInt(bookCount.readLine());
			bookArray[4] = Integer.parseInt(bookCount.readLine());
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid Format!");
		}

		// Sort the array
		Arrays.sort(bookArray);
		// Make sets of books
		originalSetsOfBooks = makeBookSets(bookArray);
		// Optimize sets for max discount if sets of 5 and 3 are present in the
		// set
		if (originalSetsOfBooks[0] != 0 && originalSetsOfBooks[2] != 0) {
			optimizedSetsOfBooks = optimizeBookSets(originalSetsOfBooks);
		} else {
			optimizedSetsOfBooks = originalSetsOfBooks;
		}

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

		for (int i = 4; i >= 0; i--) {
			if (i > 0) {
				setsOfBooks[i] = bookCopies[i] - bookCopies[i - 1];
			} else {
				setsOfBooks[i] = bookCopies[i];
			}
		}
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
		double[] discountRate = { 0.75, 0.8, 0.9, 0.95, 1.0 };
		int bookCount = 5;

		for (int i = 0; i < 5; i++) {
			amount = amount + optimizedSetsOfBooks[i] * bookCount * bookCost
					* discountRate[i];
			bookCount--;
		}

		return amount;
	}

}
