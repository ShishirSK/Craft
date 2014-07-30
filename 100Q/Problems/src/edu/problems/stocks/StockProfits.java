package edu.problems.stocks;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit. #LeetCode
 * 
 * @author Shishir Kinkar
 * 
 */
public class StockProfits {

	public int maxProfit(int[] prices) {

		if (prices.length == 0 || prices.length == 1)
			return 0;

		int maxProfit = 0;
		int lowest = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {

			// Keep tab of lowest value
			lowest = lowest < prices[i] ? lowest : prices[i];
			// Check profit
			profit = prices[i] - lowest;
			// Keep tab of max profit
			maxProfit = profit > maxProfit ? profit : maxProfit;

		}

		return maxProfit;
	}
}