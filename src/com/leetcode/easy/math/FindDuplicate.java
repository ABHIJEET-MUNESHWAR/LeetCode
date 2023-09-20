package com.leetcode.easy.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/09/23,
 * Time:    9:22 pm
 * https://leetcode.com/problems/find-the-duplicate-number/description/?envType=daily-question&envId=2023-09-19
 */
public class FindDuplicate {
  public static void main(String[] args) {
    FindDuplicate findDuplicate = new FindDuplicate();
    int[] nums = {1, 3, 4, 3, 2};
    System.out.println(findDuplicate.findDuplicate(nums));
  }

  private int findDuplicate(int[] nums) {
    int slow = nums[0], fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);
    fast = nums[0];
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return fast;
  }
}