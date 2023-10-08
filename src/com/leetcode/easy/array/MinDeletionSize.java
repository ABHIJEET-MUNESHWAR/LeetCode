package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    4:43 pm
 */
public class MinDeletionSize {
  public static void main(String[] args) {
    MinDeletionSize minDeletionSize = new MinDeletionSize();
    String[] strs = {"rrjk", "furt", "guzm"};
    System.out.println(minDeletionSize.minDeletionSize(strs));
  }

  private int minDeletionSize(String[] strs) {
    int deleted = 0;
    int row = strs.length;
    int col = strs[0].length();
    for (int i = 0; i < col; i++) {
      for (int j = 1; j < row; j++) {
        if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
          deleted++;
          break;
        }
      }
    }
    return deleted;
  }
}