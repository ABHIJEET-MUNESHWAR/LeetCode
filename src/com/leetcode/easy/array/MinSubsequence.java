package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    1:41pm
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/description/
 */
public class MinSubsequence {
  public static void main(String[] args) {
    MinSubsequence minSubsequence = new MinSubsequence();
    int[] nums = {4, 3, 10, 9, 8};
    ArrayUtils.printIntArray(minSubsequence.minSubsequence(nums));
  }

  private List<Integer> minSubsequence(int[] nums) {
    List<Integer> answer = new ArrayList<>();
    int totalSum = 0;
    int[] count = new int[101];
    for (int num : nums) {
      totalSum += num;
      count[num]++;
    }
    int currentSum = 0;
    for (int i = 100; i >= 0; i--) {
      while (count[i] > 0) {
        answer.add(i);
        currentSum += i;
        totalSum -= i;
        count[i]--;
        if (currentSum > (totalSum)) {
          i = -1;
          break;
        }
      }
    }
    return answer;
  }
}