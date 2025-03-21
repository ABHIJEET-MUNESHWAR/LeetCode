package com.leetcode.medium.greedy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/07/24,
 * Time:    9:29 pm
 * 1328. Break a Palindrome
 * https://leetcode.com/problems/break-a-palindrome/description/
 */
public class BreakPalindrome {
  public static void main(String[] args) {
    BreakPalindrome breakPalindrome = new BreakPalindrome();
    String palindrome = "abccba";
    System.out.println(breakPalindrome.breakPalindrome(palindrome));
  }

  private String breakPalindrome(String palindrome) {
    int n = palindrome.length();
    char[] palindromeChars = palindrome.toCharArray();
    for (int i = 0; i < n / 2; i++) {
      if (palindromeChars[i] != 'a') {
        palindromeChars[i] = 'a';
        return String.valueOf(palindromeChars);
      }
    }
    palindromeChars[n - 1] = 'b';
    return n < 2 ? "" : String.valueOf(palindromeChars);
  }
}