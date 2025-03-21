package com.leetcode.medium.backtracking;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/05/24,
 * Time:    3:17 pm
 * 518. Coin Change II
 * https://leetcode.com/problems/coin-change-ii/description/
 */
public class CoinChangeTwo {
  public static void main(String[] args) {
    CoinChangeTwo coinChangeTwo = new CoinChangeTwo();
    int amount = 5;
    int[] coins = {1, 2, 5};
    System.out.println(coinChangeTwo.change(amount, coins));
  }

  int[][] dp = new int[301][5001]; // index / coins , amount

  private int change(int amount, int[] coins) {
    for (int i = 0; i < 301; i++) {
      for (int j = 0; j < 5001; j++) {
        dp[i][j] = -1;
      }
    }
    return solve(coins, 0, amount);
  }

  private int solve(int[] coins, int index, int amount) {
    if (dp[index][amount] != -1) {
      return dp[index][amount];
    }
    if (index >= coins.length) {
      return 0;
    }
    if (amount == 0) {
      return 1;
    }
    if (amount < coins[index]) {
      return solve(coins, index + 1, amount);
    }
    // Take
    int take = solve(coins, index, amount - coins[index]);
    // Skip
    int skip = solve(coins, index + 1, amount);
    dp[index][amount] = take + skip;
    return take + skip;
  }
}