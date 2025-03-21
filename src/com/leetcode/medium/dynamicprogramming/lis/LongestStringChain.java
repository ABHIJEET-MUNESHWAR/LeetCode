package com.leetcode.medium.dynamicprogramming.lis;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/06/24,
 * Time:    11:23 am
 * 1048. Longest String Chain
 * https://leetcode.com/problems/longest-string-chain/description/
 */
public class LongestStringChain {
  public static void main(String[] args) {
    LongestStringChain longestStringChain = new LongestStringChain();
    String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
    System.out.println(longestStringChain.longestStringChainRecursion(words));
    System.out.println(longestStringChain.longestStringChainRecursionMemoization(words));
    System.out.println(longestStringChain.longestStringChainBottomUp(words));
  }

  private int longestStringChainBottomUp(String[] words) {
    Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
    int size = words.length;
    int[] dp = new int[size];
    for (int i = 0; i < size; i++) {
      dp[i] = 1;
    }
    int maxLength = 1;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < i; j++) {
        if (isPredecessor(words[j], words[i])) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          maxLength = Math.max(maxLength, dp[i]);
        }
      }
    }
    return maxLength;
  }

  int[][] dp;

  private int longestStringChainRecursionMemoization(String[] words) {
    Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
    dp = new int[1001][1001];
    for (int i = 0; i < 1001; i++) {
      Arrays.fill(dp[i], -1);
    }
    return solveRecursionMemoization(words, -1, 0);
  }

  private int solveRecursionMemoization(String[] words, int previousIndex, int currentIndex) {
    if (currentIndex >= words.length) {
      return 0;
    }
    if (previousIndex != -1 && dp[previousIndex][currentIndex] != -1) {
      return dp[previousIndex][currentIndex];
    }
    int take = 0;
    if (previousIndex == -1 || isPredecessor(words[previousIndex], words[currentIndex])) {
      take = 1 + solveRecursionMemoization(words, currentIndex, currentIndex + 1);
    }
    int skip = solveRecursionMemoization(words, previousIndex, currentIndex + 1);
    if (previousIndex != -1) {
      dp[previousIndex][currentIndex] = Math.max(take, skip);
    }
    return Math.max(take, skip);
  }

  private int longestStringChainRecursion(String[] words) {
    Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
    return solveRecursion(words, -1, 0);
  }

  private int solveRecursion(String[] words, int previousIndex, int currentIndex) {
    if (currentIndex >= words.length) {
      return 0;
    }
    int take = 0;
    if (previousIndex == -1 || isPredecessor(words[previousIndex], words[currentIndex])) {
      take = 1 + solveRecursion(words, currentIndex, currentIndex + 1);
    }
    int skip = solveRecursion(words, previousIndex, currentIndex + 1);
    return Math.max(take, skip);
  }

  private boolean isPredecessor(String word1, String word2) {
    int size1 = word1.length();
    int size2 = word2.length();
    if ((size1 >= size2) || ((size2 - size1) > 1)) {
      return false;
    }
    int i = 0, j = 0;
    while (i < size1 && j < size2) {
      if (word1.charAt(i) == word2.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == size1;
  }
}