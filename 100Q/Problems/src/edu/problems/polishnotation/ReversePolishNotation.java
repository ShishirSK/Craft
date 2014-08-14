package edu.problems.polishnotation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, / or *. Each operand may be an integer or another
 * expression. #LeetCode
 * 
 * @author Shishir Kinkar 
 * 
 */
public class ReversePolishNotation {

	public int evalRPN(String[] tokens) {

		// A single string expression
		if (tokens.length == 1) {
			return Integer.parseInt(tokens[0]);
		}

		// If not 1, length has to be at least 3 to be a valid, calculable
		// notation
		if (tokens.length < 3) {
			return -1;
		}

		// Flexible data structure to manipulate the notation
		ArrayList<String> expr = new ArrayList<String>();

		// Operations that can be performed
		Set<String> operations = new HashSet<String>();
		operations.add("+");
		operations.add("-");
		operations.add("*");
		operations.add("/");

		// Move array contents to arraylist
		for (int i = 0; i < tokens.length; i++) {
			expr.add(tokens[i]);
		}

		// Traverse the list and evaluate the expressions
		for (int j = 0; j < expr.size() - 2; j++) {

			// base condition > this will the last expression to evaluate
			if (expr.size() == 3) {
				break;
			}

			// If it is an operation at j + 2 position, evaluate. Else move on
			// to the next index.
			if (operations.contains(expr.get(j + 2))) {
				int current = calculate(expr.get(j), expr.get(j + 1),
						expr.get(j + 2));
				// Remove strings at j, j + 1 and j + 2
				expr.remove(j);
				expr.remove(j);
				expr.remove(j);
				// Replace by new calculated value
				expr.add(j, Integer.toString(current));
				// Adjust the index for continued evaluation
				j -= 2;
			} else {
				continue;
			}

		}

		return calculate(expr.get(0), expr.get(1), expr.get(2));
	}

	// Calculate result value of the expression.
	private int calculate(String num1, String num2, String opr) {
		int first = Integer.parseInt(num1);
		int second = Integer.parseInt(num2);

		switch (opr) {
		case "+":
			return first + second;
		case "-":
			return first - second;
		case "/":
			return first / second;
		case "*":
			return first * second;
		}
		return 0;
	}
} 