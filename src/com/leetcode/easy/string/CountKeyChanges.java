package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/01/24,
 * Time:    8:32 am
 * https://leetcode.com/problems/number-of-changing-keys/
 */
public class CountKeyChanges {
  public static void main(String[] args) {
    CountKeyChanges countKeyChanges = new CountKeyChanges();
    String s = "mDVD";
    System.out.println(countKeyChanges.countKeyChanges(s));
  }

  private int countKeyChanges(String s) {
    int diff = 0;
    int size = s.length();
    for (int i = 1; i < size; i++) {
      if (isChanged(s.charAt(i - 1), s.charAt(i))) {
        diff++;
      }
    }
    return diff;
  }

  private boolean isChanged(char a, char b) {
    if (Character.toLowerCase(a) == Character.toLowerCase(b)) {
      return false;
    }
    return true;
  }
}