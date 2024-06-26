package com.leetcode.medium.dynamicprogramming.digit;

import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/06/24,
 * Time:    7:35 pm
 * 935. Knight Dialer
 * https://leetcode.com/problems/knight-dialer/description/
 */
public class KnightDialer {
  public static void main(String[] args) {
    KnightDialer knightDialer = new KnightDialer();
    int n = 2;
    System.out.println(knightDialer.knightDialerRecursion(n));
    System.out.println(knightDialer.knightDialerRecursionMemoization(n));
    System.out.println(knightDialer.knightDialerBottomUp(n));
  }

  int[][] dp;
  int mod = 1000000007;
  List<List<Integer>> adj = Arrays.asList(
      Arrays.asList(4, 6),
      Arrays.asList(6, 8),
      Arrays.asList(7, 9),
      Arrays.asList(4, 8),
      Arrays.asList(3, 9, 0),
      Arrays.asList(),
      Arrays.asList(1, 7, 0),
      Arrays.asList(2, 6),
      Arrays.asList(1, 3),
      Arrays.asList(2, 4)
  );


  private int knightDialerBottomUp(int n) {
    int result = 0;
    int[][] dp = new int[n][10];
    // State definition: dp[i][j] = Total number of distinct phone numbers of length i when we start from cell j
    for (int i = 0; i <= 9; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int cell = 0; cell <= 9; cell++) {
        int answer = 0;
        for (int neighbour : adj.get(cell)) {
          answer = (answer + dp[i - 1][neighbour]) % mod;
        }
        dp[i][cell] = answer;
      }
    }
    for (int cell = 0; cell <= 9; cell++) {
      result = (result + dp[n - 1][cell]) % mod;
    }
    return result;
  }

  private int knightDialerRecursionMemoization(int n) {
    int result = 0;
    dp = new int[5001][10];
    for (int i = 0; i < 5001; i++) {
      Arrays.fill(dp[i], -1);
    }
    for (int cell = 0; cell <= 9; cell++) {
      result = (result + solveRecursionMemoization(n - 1, cell)) % mod;
    }
    return result;
  }

  private int solveRecursionMemoization(int n, int cell) {
    if (n <= 0) {
      return 1;
    }
    if (dp[n][cell] != -1) {
      return dp[n][cell];
    }
    int result = 0;
    for (int neighbor : adj.get(cell)) {
      result = (result + solveRecursionMemoization(n - 1, neighbor)) % mod;
    }
    return dp[n][cell] = result;
  }

  private int knightDialerRecursion(int n) {
    int result = 0;
    for (int cell = 0; cell <= 9; cell++) {
      result = (result + solveRecursion(n - 1, cell)) % mod;
    }
    return result;
  }

  private int solveRecursion(int n, int cell) {
    if (n <= 0) {
      return 1;
    }
    int result = 0;
    for (int neighbor : adj.get(cell)) {
      result = (result + solveRecursion(n - 1, neighbor)) % mod;
    }
    return result;
  }
}