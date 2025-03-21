package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    25/11/22, Time:    7:40 AM
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseString2 {

  public static void main(String[] args) {
    ReverseString2 reverseString2 = new ReverseString2();
    System.out.println(reverseString2.reverseStr("abcdefg", 2));
  }

  private String reverseStr(String s, int k) {
    int len = s.length();
    char[] str = s.toCharArray();
    int i = 0;
    while (i < len) {
      int j = Math.min(i + k - 1, len - 1);
      swap(str, i, j);
      i += 2 * k;
    }
    return String.valueOf(str);
  }

  private void swap(char[] s, int l, int r) {
    while (l < r) {
      char t = s[l];
      s[l++] = s[r];
      s[r--] = t;
    }
  }
}