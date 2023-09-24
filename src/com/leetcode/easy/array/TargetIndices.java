package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/09/23,
 * Time:    4:46 pm
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 */
public class TargetIndices {
  public static void main(String[] args) {
    TargetIndices targetIndices = new TargetIndices();
    int[] nums = {1, 2, 5, 2, 3};
    int target = 2;
    ArrayUtils.printIntArray(targetIndices.targetIndices(nums, target));
  }

  private List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> answer = new ArrayList<>();
    int size = nums.length;
    int lesser=0;
    int count=0;
    for (int i = 0; i < size; i++) {
      if(nums[i]<target){
        lesser++;
      }
      if(nums[i]==target){
        count++;
      }
    }
    for (int i = 0; i < count; i++) {
      answer.add(lesser++);
    }
    return answer;
  }
}