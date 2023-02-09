package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    09/02/23, Time:    10:29 pm
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 */
public class CreateTargetArray {

  public static void main(String[] args) {
    CreateTargetArray createTargetArray = new CreateTargetArray();
    int[] nums = new int[]{0, 1, 2, 3, 4};
    int[] index = new int[]{0, 1, 2, 2, 1};
    int[] targetArray = createTargetArray.createTargetArray(nums, index);
    ArrayUtils.printArray(targetArray);
  }

  private int[] createTargetArray(int[] nums, int[] index) {
    ArrayList<Integer> ansArray = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      ansArray.add(index[i], nums[i]);
    }
    int[] targetArray = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      targetArray[i] = ansArray.get(i);
    }
    return targetArray;
  }
}