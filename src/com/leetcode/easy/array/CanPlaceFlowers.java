package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    20/03/23, Time:    7:03 pm
 * https://leetcode.com/problems/can-place-flowers/
 */
public class CanPlaceFlowers {

  public static void main(String[] args) {
    CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
    int[] flowerbed = new int[]{0, 0, 1, 0, 0};
    int n = 1;
    System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, n));
  }

  private boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0) {
      return true;
    }
    int size = flowerbed.length;
    for (int i = 0; i < size; i++) {
      if ((i == 0 || flowerbed[i - 1] == 0)
          && flowerbed[i] == 0
          && (i == size - 1 || flowerbed[i + 1] == 0)) {
        --n;
        if (n == 0) {
          return true;
        }
        flowerbed[i] = 1;
      }
    }
    return false;
  }

}