package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    05/07/22, Time:    8:29 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/885/
 */
public class StrStr {

  public static void main(String[] args) {
    StrStr strStr = new StrStr();
//    String haystack = "hello", needle = "ll";
//    String haystack = "aaaaa", needle = "bba";
//    String haystack = "aaa", needle = "aaaa";
//    String haystack = "mississippi", needle = "mississippi";
    String haystack = "mississippi", needle = "issipi";
    System.out.println(strStr.strStr(haystack, needle));
  }

  private int strStr(String haystack, String needle) {
    int index = -1;
    int len2 = needle.length();
    if (len2 == 0) {
      return 0;
    }
    int len1 = haystack.length();
    if (len2 > len1) {
      return -1;
    }
    for (int i = 0; i < len1; i++) {
      int j = 0;
      for (j = 0; j < len2; j++) {
        if (len1 == (i + j)) {
          return -1;
        }
        char ch1 = haystack.charAt(i + j);
        char ch2 = needle.charAt(j);
        if (ch1 != ch2) {
          break;
        }
      }
      if (j == len2) {
        return i;
      }
    }
    return index;
  }
}