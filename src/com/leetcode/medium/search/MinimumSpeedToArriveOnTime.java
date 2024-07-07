package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/24,
 * Time:    3:37 pm
 * 1870. Minimum Speed to Arrive on Time
 * https://leetcode.com/problems/minimum-speed-to-arrive-on-time/description/
 */
public class MinimumSpeedToArriveOnTime {
  public static void main(String[] args) {
    MinimumSpeedToArriveOnTime minSpeedOnTime = new MinimumSpeedToArriveOnTime();
    int[] dist = {1, 3, 2};
    double hour = 2.7;
    System.out.println(minSpeedOnTime.minSpeedOnTime(dist, hour));
  }

  private int minSpeedOnTime(int[] dist, double hour) {
    int n = dist.length;
    int left = 1;
    int right = 10000000;
    int minimumSpeed = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (isPossible(dist, hour, mid)) {
        minimumSpeed = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return minimumSpeed;
  }

  private boolean isPossible(int[] dist, double hour, int speed) {
    double totalTime = 0;
    int n = dist.length;
    for (int i = 0; i < n - 1; i++) {
      totalTime += Math.ceil((double) (dist[i]) / speed);
    }
    totalTime += ((double) (dist[n - 1]) / speed);
    return totalTime <= hour;
  }
}