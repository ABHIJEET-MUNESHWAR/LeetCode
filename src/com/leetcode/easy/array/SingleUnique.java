package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    21/02/23, Time:    10:28 am
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleUnique {

  public static void main(String[] args) {
    SingleUnique singleUnique = new SingleUnique();
    int[] nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
    System.out.println(singleUnique.singleNonDuplicate(nums));
    System.out.println(singleUnique.singleUniqueDuplicate(nums));
  }

  private int singleUniqueDuplicate(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if ((mid % 2 == 0 && nums[mid] == nums[mid + 1])
          || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }

  private int singleNonDuplicate(int[] nums) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = (high + low) / 2;
      if (mid % 2 == 1) {
        mid--;
      }
      if (nums[mid] != nums[mid + 1]) {
        high = mid;
      } else {
        low = mid + 2;
      }
    }
    return nums[low];
  }
}