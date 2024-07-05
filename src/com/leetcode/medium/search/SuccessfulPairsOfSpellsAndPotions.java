package com.leetcode.medium.search;

import com.leetcode.utils.ArrayUtils;
import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/07/24,
 * Time:    2:56 pm
 * 2300. Successful Pairs of Spells and Potions
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
 */
public class SuccessfulPairsOfSpellsAndPotions {
  public static void main(String[] args) {
    SuccessfulPairsOfSpellsAndPotions solution = new SuccessfulPairsOfSpellsAndPotions();
    int[] spells = {5, 1, 3};
    int[] potions = {1, 2, 3, 4, 5};
    long success = 7;
    ArrayUtils.printArray(solution.successfulPairs(spells, potions, success));
  }

  private int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int sizeOfSpells = spells.length;
    int[] result = new int[sizeOfSpells];
    for (int i = 0; i < sizeOfSpells; i++) {
      result[i] = eligiblePotionsUsingBinarySearch(potions, success, spells[i]);
    }
    return result;
  }

  private int eligiblePotionsUsingBinarySearch(int[] potions, long success, int spell) {
    int size = potions.length;
    int left = 0;
    int right = size - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      long searchKey = (long) potions[mid] * spell;
      if (searchKey < success) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return (size - left);
  }
}