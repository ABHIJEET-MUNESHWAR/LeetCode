package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/24,
 * Time:    7:51 am
 * 945. Minimum Increment to Make Array Unique
 * https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/?envType=daily-question&envId=2024-06-14
 */
public class MinIncrementForUnique {
  public static void main(String[] args) {
    MinIncrementForUnique minIncrementForUnique = new MinIncrementForUnique();
    int[] nums = {3, 2, 1, 2, 1, 7};
    System.out.println(minIncrementForUnique.minIncrementForUniqueSort(nums));
    System.out.println(minIncrementForUnique.minIncrementForUnique(nums));
  }

  private int minIncrementForUniqueSort(int[] nums) {
    Arrays.sort(nums);
    int moves = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] <= nums[i - 1]) {
        moves += nums[i - 1] - nums[i] + 1;
        nums[i] = nums[i - 1] + 1;
      }
    }
    return moves;
  }

  private int minIncrementForUnique(int[] nums) {
    int moves = 0;
    int[] frequencyMap = new int[1000000];
    for (int num : nums) {
      frequencyMap[num]++;
    }
    for (int i = 0; i < frequencyMap.length - 1; i++) {
      if (frequencyMap[i] <= 1) {
        continue;
      }
      int remainingMoves = frequencyMap[i] - 1;
      moves += remainingMoves;
      frequencyMap[i + 1] += remainingMoves;
    }
    return moves;
  }
}