package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/09/23,
 * Time:    11:01 am
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 */
public class FirstPalindrome {
  public static void main(String[] args) {
    FirstPalindrome firstPalindrome = new FirstPalindrome();
    String[] words = {"po", "p1", "zs2"};
    System.out.println(firstPalindrome.firstPalindrome(words));
  }

  private String firstPalindrome(String[] words) {
    for (String word : words) {
      char[] chars = word.toCharArray();
      int size = chars.length;
      int i = 0, j = size - 1;
      boolean isPalindrome = true;
      while (i < j) {
        if (chars[i] == chars[j]) {
          i++;
          j--;
        } else {
          isPalindrome = false;
          break;
        }
      }
      if (isPalindrome) {
        return word;
      }
    }
    return "";
  }
}