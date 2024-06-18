package com.leetcode.medium.dynamicprogramming;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/06/24,
 * Time:    11:05 pm
 */
public class FindLongestChain {
  public static void main(String[] args) {
    FindLongestChain findLongestChain = new FindLongestChain();
    int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
    System.out.println(findLongestChain.findLongestChain(pairs));
  }

  private int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs);
    return 0;
  }
}