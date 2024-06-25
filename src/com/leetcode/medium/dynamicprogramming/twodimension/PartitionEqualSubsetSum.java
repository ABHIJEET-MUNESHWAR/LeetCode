package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/05/24,
 * Time:    7:22 am
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class PartitionEqualSubsetSum {
  public static void main(String[] args) {
    PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
    int[] nums = {1, 5, 11, 5};
    System.out.println(partitionEqualSubsetSum.canPartition(nums));
  }

  private boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    int target = sum / 2;
    return canPartition(nums, target);
  }

  private boolean canPartition(int[] nums, int target) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      Set<Integer> tempSet = new HashSet<>();
      for (int setItem : set) {
        if ((setItem + nums[i]) == target) {
          return true;
        }
        tempSet.add(setItem + nums[i]);
        tempSet.add(setItem);
      }
      set = tempSet;
    }
    return set.contains(target);
  }
}