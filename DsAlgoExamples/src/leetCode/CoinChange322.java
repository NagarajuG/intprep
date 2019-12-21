package leetCode;

import java.util.Arrays;

/*
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.

	Example 1:
	
		Input: coins = [1, 2, 5], amount = 11
		Output: 3 
		Explanation: 11 = 5 + 5 + 1
		
	Example 2:
	
		Input: coins = [2], amount = 3
		Output: -1
	Note:
	You may assume that you have an infinite number of each kind of coin.
 * 
 */

public class CoinChange322 {

	public int coinChange(int[] coins, int amount) {
		if (amount <= 0 || coins.length == 0)
			return 0;

		int[] result = new int[amount + 1];

		Arrays.fill(result, amount + 1);
		result[0] = 0;

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i >= coins[j]) {
					result[i] = Math.min(result[i], 1 + result[i - coins[j]]);
				}

			}

		}

		return result[amount] > amount ? -1 : result[amount];

	}

	public static void main(String[] args) {

		CoinChange322 coinChange322 = new CoinChange322();
		int[] coins = new int[] { 186, 419, 83, 408 };
		int amount = 6249;

		System.out.println("The result is ....\t" + coinChange322.coinChange(coins, amount));

	}

}
