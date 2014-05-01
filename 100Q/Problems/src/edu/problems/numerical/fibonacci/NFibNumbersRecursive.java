package edu.problems.numerical.fibonacci;

/**
 * Print out N numbers of the Fibonnaci series recursively
 * 
 * @author Shishir Kinkar
 * 
 */

public class NFibNumbersRecursive {

	public static void printNFibNumbers(int a) {

		for (int i = 0; i < a; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}

	private static int fibonacci(int n) {

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
