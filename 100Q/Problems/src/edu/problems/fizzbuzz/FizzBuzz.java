package edu.problems.fizzbuzz;

/**
 * Write a program that prints n numbers. For multiples of three print "Fizz"
 * instead of the number and for the multiples of five print "Buzz". For numbers
 * which are multiples of both three and five print "FizzBuzz"
 * http://craftsmanship.sv.cmu.edu/katas/fizzbuzz
 * 
 * @author Shishir Kinkar
 * 
 */
public class FizzBuzz {

	public void fizzBuzz(int n) {

		for (int i = 1; i < n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}