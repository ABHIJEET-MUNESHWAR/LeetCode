package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/09/23,
 * Time:    10:33pm
 * https://leetcode.com/problems/monotonic-array/?envType=daily-question&envId=2023-09-29
 */
public class IsMonotonic {
  public static void main(String[] args) {
    IsMonotonic isMonotonic = new IsMonotonic();
    int[] nums = {1,3,2};
    System.out.println(isMonotonic.isMonotonic(nums));
  }

  private boolean isMonotonic(int[] nums) {
    boolean isMonotoneAscending = true;
    boolean isMonotoneDescending = true;
    int size = nums.length;
    for (int i = 1; i < size; i++) {
      if(nums[i - 1] != nums[i]){
        if (nums[i - 1] <= nums[i]) {
          isMonotoneDescending = false;
        } else {
          isMonotoneAscending = false;
        }
      }
    }
    return (isMonotoneAscending || isMonotoneDescending);
  }
}