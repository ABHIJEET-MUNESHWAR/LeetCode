package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/09/22, Time:    1:21 PM
 * https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {

  public static void main(String[] args) {
    SummaryRanges summaryRanges = new SummaryRanges();
    //int[] nums = new int[]{0, 1, 2, 4, 5, 7};
    int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
    List<String> ranges = summaryRanges.summaryRanges(nums);
    System.out.println(ranges.toArray());
  }

  private List<String> summaryRanges(int[] nums) {
    List<String> ranges = new ArrayList<>();
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int start = nums[i];
      while ((i + 1 < size) && (nums[i] + 1 == nums[i + 1])) {
        i++;
      }
      if (start == nums[i]) {
        ranges.add("" + start);
      } else {
        ranges.add(start + "->" + nums[i]);
      }
    }
    return ranges;
  }
}