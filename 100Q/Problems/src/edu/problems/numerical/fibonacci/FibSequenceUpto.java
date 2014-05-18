package edu.problems.numerical.fibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to return the Fibonnaaci sequence numbers less than the input number
 * 
 * @author Shishir Kinkar
 * 
 */
public class FibSequenceUpto {

	public static List<Integer> FibSeq(int n) {

		List<Integer> list = new ArrayList<Integer>();

		if (n > 0) {
			list.add(0);
		}
		if (n > 1) {
			list.add(1);
		}
		int a = 0, b = 1, nextNumber;
		nextNumber = a + b;
		while (nextNumber < n) {
			list.add(nextNumber);
			a = b;
			b = nextNumber;
			nextNumber = a + b;
		}
		return list;
	}

}
