package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    19/01/23, Time:    10:37 am
 * https://leetcode.com/problems/shuffle-the-array/
 */
public class ShuffleArray {

  public static void main(String[] args) {
    ShuffleArray shuffleArray = new ShuffleArray();
    int[] nums = new int[]{2, 5, 1, 3, 4, 7};
    int n = 3;
    nums = shuffleArray.shuffle(nums, n);
    ArrayUtils.printArray(nums);
  }

  private int[] shuffle(int[] nums, int n) {
    int size = nums.length;
    int j = 0;
    for (int i = n; i < size; i++) {
      nums[i] = nums[j++] * 10000 + nums[i];
    }
    j = 0;
    for (int i = n; i < size; i++) {
      int rem = nums[i] % 10000;
      int div = nums[i] / 10000;
      nums[j] = div;
      nums[j + 1] = rem;
      j += 2;
    }
    return nums;
  }
}