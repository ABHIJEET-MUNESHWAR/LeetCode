package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/05/24,
 * Time:    9:54 am
 * 1561. Maximum Number of Coins You Can Get
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/
 */
public class MaxCoins {
  public static void main(String[] args) {
    MaxCoins maxCoins = new MaxCoins();
    //int[] piles = {9, 8, 7, 6, 5, 1, 2, 3, 4};
    int[] piles = {2, 4, 1, 2, 7, 8};
    System.out.println(maxCoins.maxCoins(piles));
  }

  private int maxCoins(int[] piles) {
    int size = piles.length;
    Arrays.sort(piles);
    int answer = 0;
    for (int i = size - 2; i >= size/3; i -= 2) {
      answer += piles[i];
    }
    return answer;
  }
}