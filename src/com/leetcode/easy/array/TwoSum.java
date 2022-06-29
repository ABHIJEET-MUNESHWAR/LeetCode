package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    23/06/22, Time:    8:04 AM
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
 */
public class TwoSum {

  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
//    int[] nums = new int[]{3, 3};
//    int target = 6;
//    int[] nums = new int[]{2,7,11,15};
//    int target = 9;
    int[] nums = new int[]{3,2,4};
    int target = 6;
    System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
  }

  public int[] twoSum(int[] nums, int target) {
    int[] ans = new int[2];
    int len = nums.length;
    Map<Integer, Integer> locationMap = new HashMap<>();
    for (int i = 0; i < len; i++) {
      int diff = target - nums[i];
      if (locationMap.containsKey(diff)) {
        ans[1] = i;
        ans[0] = locationMap.get(diff);
      }
      locationMap.put(nums[i], i);
    }
    return ans;
  }

}