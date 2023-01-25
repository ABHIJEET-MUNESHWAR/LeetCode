package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    23/01/23, Time:    8:12 am
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class KidsWithCandies {

  public static void main(String[] args) {
    KidsWithCandies kidsWithCandies = new KidsWithCandies();
    int[] candies = new int[]{2, 3, 5, 1, 3};
    int extraCandies = 3;
    List<Boolean> maxCandies = kidsWithCandies.kidsWithCandies(candies, extraCandies);
    ArrayUtils.printArray(maxCandies);
  }

  private List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int size = candies.length;
    for (int i = 0; i < size; i++) {
      int candy = candies[i];
      if (max < candy) {
        max = candy;
      }
    }
    for (int i = 0; i < size; i++) {
      if ((candies[i] + extraCandies) >= max) {
        result.add(true);
      } else {
        result.add(false);
      }
    }
    return result;
  }
}