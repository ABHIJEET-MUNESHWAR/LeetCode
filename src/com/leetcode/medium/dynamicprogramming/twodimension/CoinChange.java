package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/05/24,
 * Time:    10:50 pm
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange {
  public static void main(String[] args) {
    CoinChange coinChange = new CoinChange();
    int[] coins = {1, 2, 5};
    int amount = 11;
    System.out.println(coinChange.coinChangeRecursion(coins, amount));
    System.out.println(coinChange.coinChangeRecursionMemoization(coins, amount));
    System.out.println(coinChange.coinChangeBottomUp(coins, amount));
  }

  private int coinChangeBottomUp(int[] coins, int amount) {
    dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
  }

  int[] dp;

  private int coinChangeRecursionMemoization(int[] coins, int amount) {
    dp = new int[amount + 1];
    Arrays.fill(dp, -1);
    int answer = coinCountDP(coins, amount);
    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

  private int coinCountDP(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return Integer.MAX_VALUE;
    }
    if (dp[amount] != -1) {
      return dp[amount];
    }
    int minCoins = Integer.MAX_VALUE;
    int size = coins.length;
    for (int i = 0; i < size; i++) {
      int ans = coinCountDP(coins, amount - coins[i]);
      if (ans != Integer.MAX_VALUE) {
        minCoins = Math.min(minCoins, 1 + ans);
      }
    }
    dp[amount] = minCoins;
    return minCoins;
  }

  private int coinChangeRecursion(int[] coins, int amount) {
    int answer = coinCount(coins, amount);
    return answer == Integer.MAX_VALUE ? -1 : answer;
  }

  private int coinCount(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    if (amount < 0) {
      return Integer.MAX_VALUE;
    }
    int minCoins = Integer.MAX_VALUE;
    int size = coins.length;
    for (int i = 0; i < size; i++) {
      int ans = coinCount(coins, amount - coins[i]);
      if (ans != Integer.MAX_VALUE) {
        minCoins = Math.min(minCoins, 1 + ans);
      }
    }
    return minCoins;
  }
}