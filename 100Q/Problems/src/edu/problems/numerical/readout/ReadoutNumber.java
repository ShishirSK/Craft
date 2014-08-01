package edu.problems.numerical.readout;

/**
 * Given an integer, generate the next number in Morris Number Sequence.
 * 
 * Ref: http://en.wikipedia.org/wiki/Look-and-say_sequence
 * 
 * @author Shishir Kinkar
 * 
 */
public class ReadoutNumber {

	// Generalised solution to generate the next number in the sequence.
	public String countAndSay(int n) {

		if (n >= 0 && n < 10) {
			return ("1" + Integer.toString(n));
		}

		StringBuilder strB = new StringBuilder();
		int currCharCount = 1;

		String number = Integer.toString(n);

		int i = 1;
		for (; i < number.length(); i++) { // Keep count of repeat digits
			if (number.charAt(i - 1) == number.charAt(i)) {
				currCharCount++;
			} else { // Construct part of the sequence
				strB.append(currCharCount);
				strB.append(number.charAt(i - 1));
				currCharCount = 1;
			}
		}
		// Construct end part of the sequence
		strB.append(currCharCount);
		strB.append(number.charAt(--i));

		return strB.toString();
	}
}
