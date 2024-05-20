package com.leetcode.medium.search;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/05/24,
 * Time:    10:15 pm
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/description/
 */
public class KokoEatingBananas {
  public static void main(String[] args) {
    KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
    int[] piles = {3, 6, 7, 11};
    int h = 8;
    System.out.println(kokoEatingBananas.kokoEatingBananas(piles, h));
  }

  private int kokoEatingBananas(int[] piles, int h) {
    Arrays.sort(piles);
    int size = piles.length;
    int low = 1;
    int high = piles[size - 1];
    while (low < high) {
      int mid = (low + high) / 2;
      if (canEatAllBanana(piles, mid, h)) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  private boolean canEatAllBanana(int[] piles, int mid, int h) {
    int totalHours = 0;
    for (int pile : piles) {
      totalHours += pile / mid;
      if (pile % mid != 0) {
        totalHours++;
      }
    }
    return totalHours <= h;
  }
}