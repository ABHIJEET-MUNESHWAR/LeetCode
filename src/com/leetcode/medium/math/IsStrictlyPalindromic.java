package com.leetcode.medium.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/05/24,
 * Time:    2:09 pm
 * 2396. Strictly Palindromic Number
 * https://leetcode.com/problems/strictly-palindromic-number/description/
 */
public class IsStrictlyPalindromic {
  public static void main(String[] args) {
    IsStrictlyPalindromic isStrictlyPalindromic = new IsStrictlyPalindromic();
    System.out.println(isStrictlyPalindromic.isStrictlyPalindromic(9));
  }

  private boolean isStrictlyPalindromic(int n) {
    for (int base = 2; base < n - 1; base++) {
      int num = n;
      String baseStr = "";
      while (num > 0) {
        baseStr = baseStr + num % base;
        num /= base;
      }
      if (!isPalindrome(baseStr)) {
        return false;
      }
    }
    return true;
  }

  private boolean isPalindrome(String baseStr) {
    int size = baseStr.length();
    int i = 0, j = size - 1;
    while (i < j) {
      if (baseStr.charAt(i) != baseStr.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}