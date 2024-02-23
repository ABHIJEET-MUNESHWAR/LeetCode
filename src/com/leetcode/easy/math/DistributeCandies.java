package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/02/24,
 * Time:    9:56 am
 * https://leetcode.com/problems/distribute-candies-among-children-i/description/
 */
public class DistributeCandies {
  public static void main(String[] args) {
    DistributeCandies distributeCandies = new DistributeCandies();
    int n = 5, limit = 2;
    System.out.println(distributeCandies.distributeCandies(n, limit));
  }

  private int distributeCandies(int n, int limit) {
    int count = 0;
    for (int i = 0; i <= limit; i++) {
      for (int j = 0; j <= limit; j++) {
        int k = n - i - j;
        if (k >= 0 && k <= limit) {
          count++;
        }
      }
    }
    return count;
  }
}