package com.leetcode.medium.search;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/07/24,
 * Time:    2:45 pm
 * 1802. Maximum Value at a Given Index in a Bounded Array
 * https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/
 */
public class MaximumValueAtGivenIndexInBoundedArray {
  public static void main(String[] args) {
    MaximumValueAtGivenIndexInBoundedArray maximumValueAtGivenIndexInBoundedArray = new MaximumValueAtGivenIndexInBoundedArray();
    int n = 4, index = 2, maxSum = 6;
    System.out.println(maximumValueAtGivenIndexInBoundedArray.maxValue(n, index, maxSum));
  }

  private long getSumElements(long count, long value) {
    return value * count - (count * (count + 1)) / 2;
  }

  private int maxValue(int n, int index, int maxSum) {
    long left = 1;
    long right = maxSum;
    int result = 0;
    while (left <= right) {

      long mid = left + (right - left) / 2;

      long leftCount = Math.min((long) index, mid - 1);
      long leftSum = getSumElements(leftCount, mid);
      leftSum += Math.max(0, index - mid + 1);

      long rightCount = Math.min((long) n - index - 1, mid - 1);
      long rightSum = getSumElements(rightCount, mid);
      rightSum += Math.max(0, n - index - 1 - mid + 1);

      if ((leftSum + rightSum + mid) <= maxSum) {
        result = (int) Math.max(result, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }
}