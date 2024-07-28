package com.leetcode.contest.weekly.four.zero.two;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/06/24,
 * Time:    8:02 am
 * 100304. Count Pairs That Form a Complete Day I
 * https://leetcode.com/contest/weekly-contest-402/problems/count-pairs-that-form-a-complete-day-i/
 */
public class CountCompleteDayPairs {
  public static void main(String[] args) {
    CountCompleteDayPairs countCompleteDayPairs = new CountCompleteDayPairs();
    int[] hours = {12, 12, 30, 24, 24};
    System.out.println(countCompleteDayPairs.countCompleteDayPairs(hours));
    System.out.println(countCompleteDayPairs.countCompleteDayPairsOptimised(hours));
  }

  private long countCompleteDayPairsOptimised(int[] hours) {
    int size = hours.length;
    long[] frequencyMap = new long[24];
    long totalPairs = 0;
    for (int i = 0; i < size; i++) {
      int remainder = hours[i] % 24;
      if (remainder == 0) {
        totalPairs += frequencyMap[remainder];
      } else {
        totalPairs += frequencyMap[24 - remainder];
      }
      frequencyMap[remainder]++;
    }
    return totalPairs;
  }

  private int countCompleteDayPairs(int[] hours) {
    int pairs = 0;
    int size = hours.length;
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        int totalHours = hours[i] + hours[j];
        if (totalHours % 24 == 0) {
          pairs++;
        }
      }
    }
    return pairs;
  }
}