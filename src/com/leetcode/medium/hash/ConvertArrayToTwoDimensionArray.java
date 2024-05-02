package com.leetcode.medium.hash;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/05/24,
 * Time:    2:50 pm
 * 2610. Convert an Array Into a 2D Array With Conditions
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/
 */
public class ConvertArrayToTwoDimensionArray {
  public static void main(String[] args) {
    ConvertArrayToTwoDimensionArray convertArrayToTwoDimensionArray = new ConvertArrayToTwoDimensionArray();
    int[] nums = {1, 3, 4, 1, 2, 3, 1};
    ListUtils.printLists(convertArrayToTwoDimensionArray.findMatrix(nums));
  }

  private List<List<Integer>> findMatrix(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int size = nums.length;
    int[] count = new int[size + 1];
    for (int num : nums) {
      int frequency = count[num];
      if (frequency == result.size()) {
        result.add(new ArrayList<>());
      }
      result.get(frequency).add(num);
      count[num]++;
    }
    return result;
  }
}