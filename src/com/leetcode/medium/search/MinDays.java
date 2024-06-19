package com.leetcode.medium.search;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/06/24,
 * Time:    7:45 am
 * 1482. Minimum Number of Days to Make m Bouquets
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/?envType=daily-question&envId=2024-06-19
 */
public class MinDays {
  public static void main(String[] args) {
    MinDays minDays = new MinDays();
    /*int[] bloomDay = {1, 10, 3, 10, 2};
    int m = 3, k = 1;*/
    int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
    int m = 2, k = 3;
    System.out.println(minDays.minDays(bloomDay, m, k));
  }

  private int minDays(int[] bloomDay, int m, int k) {
    int totalFlowers = bloomDay.length;
    int totalRequiredFlowers = m * k;
    if (totalFlowers < totalRequiredFlowers) {
      return -1;
    }
    int totalRequiredDays = -1;
    int maximumDaysToWait = 0;
    for (int i = 0; i < totalFlowers; i++) {
      maximumDaysToWait = Math.max(maximumDaysToWait, bloomDay[i]);
    }
    int low = 0, high = maximumDaysToWait;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (canMakeMBouquets(bloomDay, mid, k, m)) {
        totalRequiredDays = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return totalRequiredDays;
  }

  private boolean canMakeMBouquets(int[] bloomDay, int mid, int k, int m) {
    int size = bloomDay.length;
    int totalBouquetsDone = 0;
    int totalFlowersPlucked = 0;
    for (int i = 0; i < size; i++) {
      int day = bloomDay[i];
      if (day <= mid) {
        totalFlowersPlucked++;
        if (totalFlowersPlucked == k) {
          totalBouquetsDone++;
          totalFlowersPlucked = 0;
        }
      } else {
        totalFlowersPlucked = 0;
      }
    }
    return totalBouquetsDone >= m;
  }
}