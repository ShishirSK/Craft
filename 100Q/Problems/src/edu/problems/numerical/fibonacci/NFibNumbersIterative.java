package edu.problems.numerical.fibonacci;

/**
 * Print out N numbers of the Fibonnaci series iteratively
 * 
 * @author Shishir Kinkar
 * 
 */
public class NFibNumbersIterative {

	public static void printNFibNumbers(int n) {

		if (n == 0)
			System.out.println("0");
		else if (n == 1)
			System.out.println("0 1");
		else {
			System.out.print("0 1 ");
			int a = 0, b = 1;
			int nextNumber = 0;
			for (int i = 1; i < n - 1; i++) {
				nextNumber = a + b;
				a = b;
				b = nextNumber;
				System.out.print(nextNumber + " ");
			}
		}
	}

}
