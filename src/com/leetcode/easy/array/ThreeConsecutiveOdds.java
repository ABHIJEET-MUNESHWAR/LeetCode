package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/07/24,
 * Time:    8:51 am
 * 1550. Three Consecutive Odds
 * https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2024-07-01
 */
public class ThreeConsecutiveOdds {
  public static void main(String[] args) {
    ThreeConsecutiveOdds threeConsecutiveOdds = new ThreeConsecutiveOdds();
    int[] arr = {2, 6, 4, 1};
    System.out.println(threeConsecutiveOdds.threeConsecutiveOdds(arr));
  }

  private boolean threeConsecutiveOdds(int[] arr) {
    int size = arr.length;
    if (size < 3) {
      return false;
    }
    int i = 0, j = 1, k = 2;
    while (i < size && j < size && k < size) {
      if (arr[i] % 2 == 1 && arr[j] % 2 == 1 && arr[k] % 2 == 1) {
        return true;
      }
      i++;
      j++;
      k++;
    }
    return false;
  }
}