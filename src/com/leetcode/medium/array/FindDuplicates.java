package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/03/24,
 * Time:    8:52 am
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/?envType=daily-question&envId=2024-03-25
 */
public class FindDuplicates {
  public static void main(String[] args) {
    FindDuplicates findDuplicates = new FindDuplicates();
    int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
    ArrayUtils.printIntArray(findDuplicates.findDuplicates(nums));
  }

  private List<Integer> findDuplicates(int[] nums) {
    List<Integer> answer = new ArrayList<>();
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] < 0) {
        answer.add(Math.abs(index + 1));
      }
      nums[index] *= -1;
    }
    return answer;
  }
}