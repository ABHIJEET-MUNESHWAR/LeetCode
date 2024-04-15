package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/04/24,
 * Time:    9:05 am
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {
  int low, maxLength;

  public static void main(String[] args) {
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    String s = "babad";
    System.out.println(longestPalindrome.longestPalindrome(s));
  }

  private String longestPalindrome(String s) {
    int size = s.length();
    if (size < 2) {
      return s;
    }
    for (int i = 0; i < size; i++) {
      expandPalindrome(s, i, i);
      expandPalindrome(s, i, i + 1);
    }
    return s.substring(low, low + maxLength);
  }

  private void expandPalindrome(String s, int left, int right) {
    int size = s.length();
    while (left >= 0 && right < size && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    if (maxLength < (right - left - 1)) {
      low = left + 1;
      maxLength = right - left - 1;
    }
  }
}