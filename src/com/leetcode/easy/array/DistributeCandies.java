package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/12/22, Time:    10:50 pm
 * https://leetcode.com/problems/distribute-candies/
 */
public class DistributeCandies {

  public static void main(String[] args) {
    DistributeCandies distributeCandies = new DistributeCandies();
    int[] candyType = new int[]{1, 1, 2, 2, 3, 3};
    System.out.println(distributeCandies.distributeCandies(candyType));
  }

  private int distributeCandies(int[] candyType) {
    Set<Integer> set = new HashSet<>();
    for (int i : candyType) {
      set.add(i);
    }
    return set.size() < candyType.length / 2 ? set.size() : candyType.length / 2;
  }
}