package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/05/24,
 * Time:    9:42 pm
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSum {
  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
    int[] numbers = {2, 7, 11, 15};
    int target = 9;
    ArrayUtils.printArray(twoSum.twoSum(numbers, target));
  }

  private int[] twoSum(int[] numbers, int target) {
    int size = numbers.length;
    int[] result = new int[2];
    int left = 0;
    int right = size - 1;
    while (left <= right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        result[0] = left + 1;
        result[1] = right + 1;
        break;
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
    return result;
  }
}