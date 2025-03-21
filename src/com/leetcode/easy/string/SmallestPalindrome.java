package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/05/23,
 * Time:    8:09 am
 * https://leetcode.com/problems/lexicographically-smallest-palindrome/
 */
public class SmallestPalindrome {
  public static void main(String[] args) {
    SmallestPalindrome smallestPalindrome = new SmallestPalindrome();
    System.out.println(smallestPalindrome.makeSmallestPalindrome("egcfe"));
    System.out.println(smallestPalindrome.makeSmallestPalindrome2("egcfe"));
    System.out.println(smallestPalindrome.makeSmallestPalindrome("abcd"));
    System.out.println(smallestPalindrome.makeSmallestPalindrome2("abcd"));
  }

  private String makeSmallestPalindrome(String s) {
    int len = s.length();
    int isOdd = len % 2;
    char[] chars = s.toCharArray();
    if (isOdd == 1) {
      int mid = len / 2;
      for (int i = mid - 1, j = mid + 1; i >= 0 && j < len; i--, j++) {
        if (chars[i] < chars[j]) {
          chars[j] = chars[i];
        } else {
          chars[i] = chars[j];
        }
      }
    } else {
      int mid = len / 2 - 1;
      for (int i = mid, j = mid + 1; i >= 0 && j < len; i--, j++) {
        if (chars[i] < chars[j]) {
          chars[j] = chars[i];
        } else {
          chars[i] = chars[j];
        }
      }
    }
    return new String(chars);
  }

  private String makeSmallestPalindrome2(String s) {
    int len = s.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      char first = s.charAt(i);
      char second = s.charAt(len - i - 1);
      sb.append(Character.toString(first < second ? first : second));
    }
    return sb.toString();
  }
}