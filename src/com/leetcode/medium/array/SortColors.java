package com.leetcode.medium.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/06/24,
 * Time:    7:02 am
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/?envType=daily-question&envId=2024-06-12
 */
public class SortColors {
  public static void main(String[] args) {
    SortColors sortColors = new SortColors();
    int[] nums = {2, 0, 2, 1, 1, 0};
    sortColors.sortColors(nums);
  }

  private void sortColors(int[] nums) {
    int size = nums.length;
    int i = 0, j = 0, k = size - 1;
    while (j <= k) {
      if (nums[j] == 2) {
        swap(nums, j, k);
        k--;
      } else if (nums[j] == 0) {
        swap(nums, i, j);
        i++;
        j++;
      } else { // (nums[j] == 1)
        j++;
      }
    }
  }

  private void swap(int[] nums, int j, int k) {
    int temp = nums[j];
    nums[j] = nums[k];
    nums[k] = temp;
  }
}