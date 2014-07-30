package edu.problems.stocks;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author Shishir Kinkar
 * 
 */
public class StockProfitsII {

	public int maxProfit(int[] prices) {

		int total = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			// Below condition means that the stock price tomorrow is going to
			// be greater than today. It is an opportunity for profit if you buy
			// a unit of stock today and sell tomorrow
			// Assume one unit of stock for transactions.
			if (prices[i + 1] > prices[i])
				total += prices[i + 1] - prices[i];
		}

		return total;
	}
}
