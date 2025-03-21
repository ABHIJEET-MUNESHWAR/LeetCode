package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/07/22, Time:    5:57 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
    String[] strs = new String[]{"flower", "flow", "flight"};
    System.out.println("Longest common prefix: " + longestCommonPrefix.longestCommonPrefix(strs));
  }

  private String longestCommonPrefix(String[] strs) {
    String pre = strs[0];
    int len = strs.length;
    for (int i = 1; i < len; i++) {
      while (!strs[i].startsWith(pre)) {
        pre = pre.substring(0, pre.length() - 1);
      }
    }
    return pre;
  }
}