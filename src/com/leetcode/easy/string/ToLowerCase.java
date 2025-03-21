package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    04/04/23, Time:    12:23 pm
 * https://leetcode.com/problems/to-lower-case/description/
 */
public class ToLowerCase {

  public static void main(String[] args) {
    ToLowerCase toLowerCase = new ToLowerCase();
    System.out.println(toLowerCase.toLowerCase("Hello"));
  }

  private String toLowerCase(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        chars[i] = (char) (chars[i] - 'A' + 'a');
      }
    }
    return new String(chars);
  }
}