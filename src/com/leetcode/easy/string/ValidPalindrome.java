package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/07/22, Time:    9:22 PM
 */
public class ValidPalindrome {

  public static void main(String[] args) {
    ValidPalindrome validPalindrome = new ValidPalindrome();
    String s = "A man, a plan, a canal: Panama";
//    String s = "race a car";
//    String s = " ";
    System.out.println("isPalindrome: " + validPalindrome.isPalindrome(s));
  }

  private boolean isPalindrome(String s) {
    boolean isPalindrome = true;
    s = s.toLowerCase();
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      char leftChar = s.charAt(l);
      char rightChar = s.charAt(r);
      if (!Character.isLetterOrDigit(s.charAt(l))) {
        l++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(r))) {
        r--;
        continue;
      }
      if (s.charAt(l) == s.charAt(r)) {
        l++;
        r--;
      } else {
        return false;
      }
    }
    return isPalindrome;
  }
}