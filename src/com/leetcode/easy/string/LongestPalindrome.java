package com.leetcode.easy.string;

import java.util.HashSet;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    17/09/22, Time:    8:22 PM
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome {

  public static void main(String[] args) {
    LongestPalindrome longestPalindrome = new LongestPalindrome();
    System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
  }

  private int longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    HashSet<Character> hashSet = new HashSet<>();
    int size = s.length();
    int count = 0;
    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (hashSet.contains(ch)) {
        hashSet.remove(ch);
        count++;
      } else {
        hashSet.add(ch);
      }
    }
    if (hashSet.isEmpty()) {
      return count * 2;
    } else {
      return count * 2 + 1;
    }
  }
}