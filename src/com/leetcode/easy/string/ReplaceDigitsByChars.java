package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/07/23,
 * Time:    8:31 am
 * https://leetcode.com/problems/replace-all-digits-with-characters/
 */
public class ReplaceDigitsByChars {
  public static void main(String[] args) {
    ReplaceDigitsByChars replaceDigitsByChars = new ReplaceDigitsByChars();
    System.out.println(replaceDigitsByChars.replaceDigits("a1b2c3d4e"));
  }

  private String replaceDigits(String s) {
    char[] chars = s.toCharArray();
    int length = s.length();
    for (int i = 1; i < length; i += 2) {
      chars[i] = (char) (chars[i - 1] + chars[i] - '0');
    }
    return String.valueOf(chars);
  }
}