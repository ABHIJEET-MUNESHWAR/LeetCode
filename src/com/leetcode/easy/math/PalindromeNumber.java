package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    6:44 PM
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

  public static void main(String[] args) {
    PalindromeNumber palindromeNumber = new PalindromeNumber();
    System.out.println(palindromeNumber.isPalindrome(121));
    System.out.println(palindromeNumber.isPalindrome2(121));
  }

  private boolean isPalindrome2(int x) {
    // compare with reverse number
    if (x < 0 || (x != 0 && x % 10 == 0)) {
      return false;
    }
    int rev = 0;
    int num = x;
    while (num > 0) {
      rev = rev * 10 + num % 10;
      num = num / 10;
    }
    return rev == x;
  }

  private boolean isPalindrome(int x) {
    String str = String.valueOf(x);
    int len = str.length();
    for (int i = 0, j = len - 1; i <= j; i++, j--) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
    }
    return true;
  }
}