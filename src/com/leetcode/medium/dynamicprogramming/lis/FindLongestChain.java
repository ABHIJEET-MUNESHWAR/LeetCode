package com.leetcode.medium.dynamicprogramming.lis;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/06/24,
 * Time:    11:05 pm
 */
public class FindLongestChain {
  public static void main(String[] args) {
    FindLongestChain findLongestChain = new FindLongestChain();
    int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
    System.out.println(findLongestChain.findLongestChainRecursion(pairs));
    System.out.println(findLongestChain.findLongestChainRecursionMemoization(pairs));
    System.out.println(findLongestChain.findLongestChainBottomUp(pairs));
  }

  private int findLongestChainBottomUp(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
    int size = pairs.length;
    int[] dp = new int[1001];
    for (int i = 0; i < 1001; i++) {
      Arrays.fill(dp, 1);
    }
    int maxLength = 1;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < i; j++) {
        if (pairs[j][1] < pairs[i][0]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          maxLength = Math.max(maxLength, dp[i]);
        }
      }
    }
    return maxLength;
  }

  private int findLongestChainRecursionMemoization(int[][] pairs) {
    dp = new int[1001][1001];
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
    for (int i = 0; i < 1001; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(pairs, -1, 0);
  }

  private int solveRecursionMemoization(int[][] pairs, int previousIndex, int currentIndex) {
    if (currentIndex >= pairs.length) {
      return 0;
    }
    if (previousIndex != -1 && dp[previousIndex][currentIndex] != -1) {
      return dp[previousIndex][currentIndex];
    }
    int take = 0;
    if (previousIndex == -1 || pairs[previousIndex][1] < pairs[currentIndex][0]) {
      take = 1 + solveRecursionMemoization(pairs, currentIndex, currentIndex + 1);
    }
    int skip = solveRecursionMemoization(pairs, previousIndex, currentIndex + 1);
    if (previousIndex != -1) {
      dp[previousIndex][currentIndex] = Math.max(take, skip);
    }
    return Math.max(take, skip);
  }

  int dp[][];

  private int findLongestChainRecursion(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
    return findLongestChainRecursion(pairs, -1, 0);
  }

  private int findLongestChainRecursion(int[][] pairs, int previousIndex, int currentIndex) {
    if (currentIndex >= pairs.length) {
      return 0;
    }
    int take = 0;
    if (previousIndex == -1 || pairs[previousIndex][1] < pairs[currentIndex][0]) {
      take = 1 + findLongestChainRecursion(pairs, currentIndex, currentIndex + 1);
    }
    int skip = findLongestChainRecursion(pairs, previousIndex, currentIndex + 1);
    return Math.max(take, skip);
  }
}