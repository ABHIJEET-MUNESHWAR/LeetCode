package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/12/23,
 * Time:    1:34 pm
 */
public class ReplaceElementsWithGreatestElementsToRight {
  public static void main(String[] args) {
    ReplaceElementsWithGreatestElementsToRight replaceElementsWithGreatestElementsToRight =
        new ReplaceElementsWithGreatestElementsToRight();
    int[] arr = {17, 18, 5, 4, 6, 1};
    ArrayUtils.printArray(replaceElementsWithGreatestElementsToRight.replaceElements(arr));
  }

  private int[] replaceElements(int[] arr) {
    int size = arr.length;
    int answer[] = new int[size];
    answer[size - 1] = -1;
    int max = Integer.MIN_VALUE;
    for (int i = size - 1; i > 0; i--) {
      if (max < arr[i]) {
        max = arr[i];
      }
      answer[i-1] = max;
    }
    return answer;
  }
}