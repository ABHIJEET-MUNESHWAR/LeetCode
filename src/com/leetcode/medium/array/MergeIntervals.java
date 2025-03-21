package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    10/07/24,
 * Time:    10:01 am
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class MergeIntervals {
  public static void main(String[] args) {
    MergeIntervals mergeIntervals = new MergeIntervals();
    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    ArrayUtils.printMatrix(mergeIntervals.merge(intervals));
  }

  private int[][] merge(int[][] intervals) {
    int n = intervals.length;
    if (n <= 1) {
      return intervals;
    }
    Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
    List<int[]> result = new ArrayList<>();
    int[] newInterval = intervals[0];
    result.add(newInterval);
    for (int[] interval : intervals) {
      if (interval[0] <= newInterval[1]) {
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      } else {
        newInterval = interval;
        result.add(newInterval);
      }
    }
    return result.toArray(new int[result.size()][]);
  }
}