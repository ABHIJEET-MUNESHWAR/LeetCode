package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/03/24,
 * Time:    7:27 am
 * https://leetcode.com/problems/contiguous-array/description/?envType=daily-question&envId=2024-03-16
 */
public class FindMaxLengthOfBinaryArray {
  public static void main(String[] args) {
    FindMaxLengthOfBinaryArray findMaxLengthOfBinaryArray = new FindMaxLengthOfBinaryArray();
    int[] nums = {0, 1};
    System.out.println(findMaxLengthOfBinaryArray.findMaxLengthOfBinaryArray(nums));
  }

  private int findMaxLengthOfBinaryArray(int[] nums) {
    int maxLength = 0;
    int size = nums.length;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
      sum += nums[i] == 0 ? -1 : 1;
      int length = 0;
      if (sum == 0) {
        length = i + 1;
      } else if (map.containsKey(sum)) {
        length = i - map.get(sum);
      } else {
        map.put(sum, i);
      }
      maxLength = Math.max(maxLength, length);
    }
    return maxLength;
  }
}