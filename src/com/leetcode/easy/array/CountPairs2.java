package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/08/23,
 * Time:    12:07 pm
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 */
public class CountPairs2 {
  public static void main(String[] args) {
    CountPairs2 countPairs2 = new CountPairs2();
    List<Integer> nums = Arrays.asList(-1,1,2,3,1);
    int target = 2;
    System.out.println(countPairs2.countPairs2(nums, target));
  }

  private int countPairs2(List<Integer> nums, int target) {
    int count = 0;
    int size = nums.size();
    int left = 0;
    int right = size - 1;
    Collections.sort(nums);
    while (left < right) {
      int sum = nums.get(left) + nums.get(right);
      if (sum < target) {
        count += right - left;
        left++;
      } else {
        right--;
      }
    }
    return count;
  }
}