package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/01/24,
 * Time:    1:11am
 * https://leetcode.com/problems/minimum-number-game/
 */
public class NumberGame {
  public static void main(String[] args) {
    NumberGame numberGame = new NumberGame();
    int[] nums = {5, 4, 2, 3};
    ArrayUtils.printArray(numberGame.numberGame(nums));
  }

  private int[] numberGame(int[] nums) {
    int size = nums.length;
    int[] output = new int[size];
    Arrays.sort(nums);
    for (int i = 0; i < size-1; i+=2) {
      output[i + 1] = nums[i];
      output[i] = nums[i + 1];
    }
    return output;
  }
}