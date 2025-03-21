package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    23/09/22, Time:    11:41 AM
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class DisappearedNumbers {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 1};
    DisappearedNumbers disappearedNumbers = new DisappearedNumbers();
    List<Integer> missedNums = disappearedNumbers.findDisappearedNumbers(nums);
    System.out.println(missedNums);
  }

  private List<Integer> findDisappearedNumbers(int[] nums) {
    int size = nums.length;
    int[] buffer = new int[size + 1];
    List<Integer> answer = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      buffer[nums[i]] = 1;
    }
    for (int i = 1; i <= size; i++) {
      if (buffer[i] == 0) {
        answer.add(i);
      }
    }
    return answer;
  }
}