package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    07/02/23, Time:    8:32 am
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class SmallerNoThanCurrent {

  public static void main(String[] args) {
    SmallerNoThanCurrent smallerNoThanCurrent = new SmallerNoThanCurrent();
    int[] nums = new int[]{7,7,7,7};
    ArrayUtils.printArray(smallerNoThanCurrent.smallerNumbersThanCurrent(nums));
  }

  private int[] smallerNumbersThanCurrent(int[] nums) {
    int size = nums.length;
    int[] orriginalArray = new int[size];
    for (int i = 0; i < nums.length; i++) {
      orriginalArray[i] = nums[i];
    }
    Arrays.sort(nums);
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (i != 0 && nums[i - 1] == nums[i]) {
        map.put(nums[i], map.get(nums[i - 1]));
      } else {
        map.put(nums[i], i);
      }
    }
    for (int i = 0; i < orriginalArray.length; i++) {
      orriginalArray[i] = map.get(orriginalArray[i]);
    }
    return orriginalArray;
  }
}