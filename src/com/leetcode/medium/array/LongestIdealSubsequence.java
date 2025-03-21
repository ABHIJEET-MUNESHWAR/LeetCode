package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/04/24,
 * Time:    8:45 am
 * 2370. Longest Ideal Subsequence
 * https://leetcode.com/problems/longest-ideal-subsequence/description/?envType=daily-question&envId=2024-04-25
 */
public class LongestIdealSubsequence {
  public static void main(String[] args) {
    LongestIdealSubsequence longestIdealSubsequence = new LongestIdealSubsequence();
    String s = "acfgbd";
    int k = 2;
    System.out.println(longestIdealSubsequence.longestIdealString(s, k));
  }

  private int longestIdealString(String s, int k) {
    int[] maxArray = new int[26];
    int size = s.length();
    maxArray[s.charAt(size - 1) - 'a'] = 1;
    for (int i = size - 2; i >= 0; i--) {
      int lb = Math.max(0, (s.charAt(i) - 'a') - k);
      int ub = Math.min(25, (s.charAt(i) - 'a') + k);
      int max = 0;
      for (int j = lb; j <= ub; j++) {
        max = Math.max(max, maxArray[j]);
      }
      maxArray[s.charAt(i) - 'a'] = Math.max(maxArray[s.charAt(i) - 'a'], max + 1);
    }
    int longest = 0;
    for (int i = 0; i < 26; i++) {
      longest = Math.max(longest, maxArray[i]);
    }
    return longest;
  }
}