package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/07/22, Time:    7:26 PM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
 */
public class FirstUniqueChar {

  public static void main(String[] args) {
    FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
//    String str = "leetcode";
//    String str = "loveleetcode";
//    String str = "aabb";
    String str = "aadadaad";
    System.out.println(
        "Index of first unique character is: " + firstUniqueChar.firstUniqueChar(str));
  }

  private int firstUniqueChar(String str) {
    int index = -1;
    int len = str.length();
    int[] freq = new int[26];
    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);
      freq[ch - 'a']++;
    }
    for (int i = 0; i < len; i++) {
      char ch = str.charAt(i);
      if (freq[ch - 'a'] == 1) {
        return i;
      }
    }
    return index;
  }
}