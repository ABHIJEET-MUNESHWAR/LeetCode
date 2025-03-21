package com.leetcode.medium.slidingwindow;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    29/05/24,
 * Time:    11:18 pm
 * 2090. K Radius Subarray Averages
 * https://leetcode.com/problems/k-radius-subarray-averages/description/
 */
public class KRadiusSubarrayAverages {
  public static void main(String[] args) {
    KRadiusSubarrayAverages kRadiusSubarrayAverages = new KRadiusSubarrayAverages();
    int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
    int k = 3;
    ArrayUtils.printArray(kRadiusSubarrayAverages.getAverages(nums, k));
  }

  private int[] getAverages(int[] nums, int k) {
    int size = nums.length;
    long windowSize = 2 * k + 1;
    int[] result = new int[size];
    Arrays.fill(result, -1);
    if (windowSize > size) {
      return result;
    }
    int left = 0;
    int right = 0;
    long currentSum = 0;
    while (right < size) {
      currentSum += nums[right];
      if ((right - left + 1) == (windowSize)) {
        result[left + k] = (int) (currentSum / windowSize);
        currentSum -= nums[left];
        left++;
      }
      right++;
    }
    return result;
  }
}