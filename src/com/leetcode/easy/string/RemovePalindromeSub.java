package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    2:52 pm
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */
public class RemovePalindromeSub {
  public static void main(String[] args) {
    RemovePalindromeSub removePalindromeSub = new RemovePalindromeSub();
    System.out.println(removePalindromeSub.removePalindromeSub("ababa"));
  }

  private int removePalindromeSub(String s) {
    if (isPalindrome(s)) {
      return 1;
    } else {
      return 2;
    }
  }

  private boolean isPalindrome(String s) {
    int size = s.length();
    for (int i = 0, j = size - 1; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}