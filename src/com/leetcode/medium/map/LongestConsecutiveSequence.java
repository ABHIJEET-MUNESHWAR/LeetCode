package com.leetcode.medium.map;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/05/24,
 * Time:    10:30 am
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
    int[] nums = {100, 4, 200, 1, 3, 2};
    System.out.println(longestConsecutiveSequence.longestConsecutiveSequence(nums));
  }

  private int longestConsecutiveSequence(int[] nums) {
    int max = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int currentMax = 1;
        int currentNum = num;
        while (set.contains(currentNum + 1)) {
          currentMax++;
          currentNum++;
        }
        max = Math.max(max, currentMax);
      }
    }
    return max;
  }
}