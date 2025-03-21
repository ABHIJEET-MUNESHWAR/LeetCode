package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/03/24,
 * Time:    9:23 am
 * https://leetcode.com/problems/insert-interval/description/?envType=daily-question&envId=2024-03-17
 */
public class InsertInterval {
  public static void main(String[] args) {
    InsertInterval insertInterval = new InsertInterval();
    int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int[] newInterval = {4, 8};
    ArrayUtils.printMatrix(insertInterval.insertInterval(intervals, newInterval));
  }

  private int[][] insertInterval(int[][] intervals, int[] newInterval) {
    int totalIntervals = intervals.length;
    List<int[]> answer = new ArrayList<>();
    for (int i = 0; i < totalIntervals; i++) {
      if (newInterval[1] < intervals[i][0]) {
        answer.add(newInterval);
        newInterval = intervals[i];
      } else if (newInterval[0] > intervals[i][1]) {
        answer.add(intervals[i]);
      } else {
        newInterval = new int[] {Math.min(newInterval[0], intervals[i][0]),
            Math.max(newInterval[1], intervals[i][1])};
      }
    }
    answer.add(newInterval);
    return answer.toArray(new int[answer.size()][2]);
  }
}