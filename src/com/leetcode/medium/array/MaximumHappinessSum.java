package com.leetcode.medium.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 *
 * Author:  abhijeet,
 * Date:    09/05/24,
 * Time:    9:02 am
 * 3075. Maximize Happiness of Selected Children
 * https://leetcode.com/problems/maximize-happiness-of-selected-children/description/?envType=daily-question&envId=2024-05-09
 */
public class MaximumHappinessSum {
  public static void main(String[] args) {
    MaximumHappinessSum maximumHappinessSum = new MaximumHappinessSum();
    //int[] happiness = {1, 2, 3};
    int[] happiness = {2, 23, 97};
    int k = 2;
    System.out.println(maximumHappinessSum.maximumHappinessSum(happiness, k));
  }

  private long maximumHappinessSum(int[] happiness, int k) {
    Arrays.sort(happiness);
    long answer = 0;
    int dec = 0;
    int size = happiness.length;
    for (int i = size - 1; i >= size - k; i--) {
      answer += Math.max(0, happiness[i] - dec);
      dec++;
    }
    return answer;
  }
}