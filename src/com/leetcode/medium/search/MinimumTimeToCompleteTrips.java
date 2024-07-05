package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/07/24,
 * Time:    9:35 am
 * 2187. Minimum Time to Complete Trips
 * https://leetcode.com/problems/minimum-time-to-complete-trips/description/
 */
public class MinimumTimeToCompleteTrips {
  public static void main(String[] args) {
    MinimumTimeToCompleteTrips minimumTimeToCompleteTrips = new MinimumTimeToCompleteTrips();
    int[] time = {1, 2, 3};
    int totalTrips = 5;
    System.out.println(minimumTimeToCompleteTrips.minimumTimeBinarySearch(time, totalTrips));
  }

  private long minimumTimeBinarySearch(int[] time, int totalTrips) {
    long left = 0, right = 100000000000000L;
    while (left < right) {
      long mid = left + (right - left) / 2;
      boolean canCompleteTrips = canCompleteTrips(time, mid, totalTrips);
      if (canCompleteTrips) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  private boolean canCompleteTrips(int[] time, long mid, int totalTrips) {
    int n = time.length;
    long completedTrips = 0;
    for (int i = 0; i < n; i++) {
      completedTrips += mid / time[i];
    }
    return completedTrips >= totalTrips;
  }
}