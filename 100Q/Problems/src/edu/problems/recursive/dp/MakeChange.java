package edu.problems.recursive.dp;

/**
 * Given an infinite number of quarters, dimes, nickles and pennies, write
 * method to calculate the number of ways of representing "amount" cents
 * 
 * @author Shishir Kinkar
 * 
 */
public class MakeChange {

	public static void main(String[] args) {
		MakeChange coins = new MakeChange();
		int waysOfChange = coins.getWays(11, 10);
		System.out.println(waysOfChange);
	}

	public int getWays(int amount, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}

		int ways = 0;
		for (int i = 0; i * denom <= amount; i++) {
			ways += getWays(amount - i * denom, next_denom);
		}
		return ways;
	}

}
