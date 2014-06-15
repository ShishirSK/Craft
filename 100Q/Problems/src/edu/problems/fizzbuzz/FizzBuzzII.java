package edu.problems.fizzbuzz;

/**
 * A number is fizz if it is divisible by 3 or if it has a 3 in it A number is
 * buzz if it is divisible by 5 or if it has a 5 in it A number is FizzBuzz if
 * it is divisible by 5 and 3 or if it has a 5 and a 3 in it.
 * http://craftsmanship.sv.cmu.edu/katas/fizzbuzz
 * 
 * @author Shishir Kinkar
 * 
 */
public class FizzBuzzII {

	public void fizzBuzz(int n) {

		boolean contains3 = false, contains5 = false;

		for (int i = 1; i < n; i++) {

			int num = i, digit;
			while (num > 0) {
				digit = num % 10;
				if (digit == 3) {
					contains3 = true;
				} else if (digit == 5) {
					contains5 = true;
				}
				num /= 10;
			}

			if (i % 3 == 0 && i % 5 == 0 || contains3 && contains5) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0 || contains3) {
				System.out.println("Fizz");
			} else if (i % 5 == 0 || contains5) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
			contains3 = false;
			contains5 = false;
		}
	}
}