package com.leetcode.medium.dynamicprogramming.twodimension;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/05/24,
 * Time:    3:13 pm
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/description/
 */
public class DecodeWays {
  public static void main(String[] args) {
    DecodeWays decodeWays = new DecodeWays();
    String s = "226";
    System.out.println(decodeWays.decodeWays(s));
  }

  private int decodeWays(String s) {
    int size = s.length();
    for (int i = 0; i < 101; i++) {
      dp[i] = -1;
    }
    return solve(s, 0, size);
  }

  int[] dp = new int[101];

  private int solve(String s, int index, int size) {
    if (dp[index] != -1) {
      return dp[index];
    }
    if (index == size) {
      dp[index] = 1;
      return 1; // Found 1 valid split
    }
    if (s.charAt(index) == '0') {
      dp[index] = 0;
      return 0; // Not possible to split
    }
    int onlyIthChar = solve(s, index + 1, size);
    int ithAndIthPlusOneChar = 0;
    if ((index + 1) < size) {
      if (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
        ithAndIthPlusOneChar = solve(s, index + 2, size);
      }
    }
    dp[index] = ithAndIthPlusOneChar + onlyIthChar;
    return dp[index];
  }
}