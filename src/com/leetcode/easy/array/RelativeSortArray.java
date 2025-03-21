package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/06/24,
 * Time:    8:35 pm
 * 1122. Relative Sort Array
 * https://leetcode.com/problems/relative-sort-array/description/?envType=daily-question&envId=2024-06-11
 */
public class RelativeSortArray {
  public static void main(String[] args) {
    RelativeSortArray relativeSortArray = new RelativeSortArray();
    /*int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    int[] arr2 = {2, 1, 4, 3, 9, 6};*/
    int[] arr1 = {28, 6, 22, 8, 44, 17};
    int[] arr2 = {22, 28, 8, 6};
    ArrayUtils.printArray(relativeSortArray.relativeSortArray(arr1, arr2));
  }

  private int[] relativeSortArray(int[] arr1, int[] arr2) {
    int size1 = arr1.length;
    int size2 = arr2.length;
    int[] result = new int[size1];
    int[] frequencyMap = new int[1001];
    for (int i = 0; i < size1; i++) {
      frequencyMap[arr1[i]]++;
    }
    int j = 0;
    for (int i = 0; i < size2; i++) {
      while (frequencyMap[arr2[i]] > 0) {
        result[j++] = arr2[i];
        frequencyMap[arr2[i]]--;
      }
    }
    for (int i = 0; i < 1001; i++) {
      while (frequencyMap[i] > 0) {
        result[j++] = i;
        frequencyMap[i]--;
      }
    }
    return result;
  }
}