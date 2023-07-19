package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/07/23,
 * Time:    11:15 am
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */
public class DecryptString {
  public static void main(String[] args) {
    DecryptString decryptString = new DecryptString();
    System.out.println(decryptString.freqAlphabets("10#11#12"));
    System.out.println(decryptString.freqAlphabets("1326#"));
  }

  private String freqAlphabets(String s) {
    StringBuilder answer = new StringBuilder();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      int firstDigit = Character.getNumericValue(s.charAt(i));
      if (i < length - 2 && s.charAt(i + 2) == '#') {
        int secondDigit = Character.getNumericValue(s.charAt(i + 1));
        answer.append((char) ('j' + firstDigit * 10 + secondDigit - 10));
        i += 2;
      } else {
        answer.append((char) ('a' + firstDigit - 1));
      }
    }
    return answer.toString();
  }
}