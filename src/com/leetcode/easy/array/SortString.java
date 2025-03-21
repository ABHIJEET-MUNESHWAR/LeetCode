package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    1:11 pm
 * https://leetcode.com/problems/increasing-decreasing-string/description/
 */
public class SortString {
  public static void main(String[] args) {
    SortString sortString = new SortString();
    System.out.println(sortString.sortString("aaaabbbbcccc"));
  }

  private String sortString(String s) {
    StringBuilder sb = new StringBuilder();
    int[] freq = new int[26];
    int size = s.length();
    for (int i = 0; i < size; i++) {
      freq[s.charAt(i) - 'a']++;
    }
    while (sb.length() < s.length()) {
      for (int i = 0; i < 26; i++) {
        if (freq[i] != 0) {
          sb.append((char) (i + 'a'));
          freq[i]--;
        }
      }
      for (int i = 25; i >= 0; i--) {
        if (freq[i] != 0) {
          sb.append((char) (i + 'a'));
          freq[i]--;
        }
      }
    }
    return sb.toString();
  }
}