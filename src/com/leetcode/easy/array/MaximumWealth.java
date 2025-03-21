package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    20/01/23, Time:    7:51 am
 * https://leetcode.com/problems/richest-customer-wealth/
 */
public class MaximumWealth {

  public static void main(String[] args) {
    MaximumWealth maximumWealth = new MaximumWealth();
    int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
    System.out.println(maximumWealth.maximumWealth(accounts));
  }

  private int maximumWealth(int[][] accounts) {
    int max = 0;
    int rows = accounts.length;
    int cols = accounts[0].length;
    for (int i = 0; i < rows; i++) {
      int sum = 0;
      for (int j = 0; j < cols; j++) {
        sum += accounts[i][j];
      }
      if (max < sum) {
        max = sum;
      }
    }
    return max;
  }
}