package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    03/05/24,
 * Time:    9:17 am
 * 1769. Minimum Number of Operations to Move All Balls to Each Box
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/
 */
public class MinOperations {
  public static void main(String[] args) {
    MinOperations minOperations = new MinOperations();
    String boxes = "001011";
    ArrayUtils.printArray(minOperations.minOperations(boxes));
  }

  private int[] minOperations(String boxes) {
    int[] result = new int[boxes.length()];
    int[] leftSum = new int[boxes.length()];
    int[] rightSum = new int[boxes.length()];
    leftSum[0] = 0;
    int count = boxes.charAt(0) - '0';
    for (int i = 1; i < boxes.length(); i++) {
      leftSum[i] = leftSum[i - 1] + count;
      count += boxes.charAt(i) - '0';
    }
    rightSum[boxes.length() - 1] = 0;
    count = boxes.charAt(boxes.length() - 1) - '0';
    for (int i = boxes.length() - 2; i >= 0; i--) {
      rightSum[i] = rightSum[i + 1] + count;
      count += boxes.charAt(i) - '0';
    }
    for (int i = 0; i < boxes.length(); i++) {
      result[i] = leftSum[i] + rightSum[i];
    }
    return result;
  }
}