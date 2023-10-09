package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    09/10/23,
 * Time:    4:55 pm
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/
 */
public class MergeArrays {
  public static void main(String[] args) {
    MergeArrays mergeArrays = new MergeArrays();
    int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
    int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
    ArrayUtils.printMatrix(mergeArrays.mergeArrays(nums1, nums2));
  }

  private int[][] mergeArrays(int[][] nums1, int[][] nums2) {
    int num1Size = nums1.length;
    int num2Size = nums2.length;
    List<List<Integer>> answersList = new ArrayList<>();
    int i = 0, j = 0;
    while (i < num1Size && j < num2Size) {
      if (nums1[i][0] == nums2[j][0]) {
        List<Integer> answerList = new ArrayList<>();
        answerList.add(nums1[i][0]);
        answerList.add(nums1[i][1] + nums2[j][1]);
        answersList.add(answerList);
        i++;
        j++;
      } else if (nums1[i][0] < nums2[j][0]) {
        List<Integer> answerList = new ArrayList<>();
        answerList.add(nums1[i][0]);
        answerList.add(nums1[i][1]);
        answersList.add(answerList);
        i++;
      } else {
        List<Integer> answerList = new ArrayList<>();
        answerList.add(nums2[j][0]);
        answerList.add(nums2[j][1]);
        answersList.add(answerList);
        j++;
      }
    }
    while (i < num1Size) {
      List<Integer> answerList = new ArrayList<>();
      answerList.add(nums1[i][0]);
      answerList.add(nums1[i][1]);
      answersList.add(answerList);
      i++;
    }
    while (j < num2Size) {
      List<Integer> answerList = new ArrayList<>();
      answerList.add(nums2[j][0]);
      answerList.add(nums2[j][1]);
      answersList.add(answerList);
      j++;
    }
    int[][] answer = new int[answersList.size()][2];
    int k = 0;
    for (List<Integer> answerList : answersList) {
      answer[k][0] = answerList.get(0);
      answer[k][1] = answerList.get(1);
      k++;
    }
    return answer;
  }
}