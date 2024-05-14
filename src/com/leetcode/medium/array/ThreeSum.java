package com.leetcode.medium.array;

import com.leetcode.utils.ArrayUtils;
import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/05/24,
 * Time:    9:48 pm
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 */
public class ThreeSum {
  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    int[] nums = {-1, 0, 1, 2, -1, -4};
    ListUtils.printLists(threeSum.threeSum(nums));
  }

  private List<List<Integer>> threeSum(int[] nums) {
    int size = nums.length;
    Set<List<Integer>> set = new HashSet<>();
    if (size == 0) {
      return new ArrayList<>(set);
    }
    Arrays.sort(nums);
    for (int i = 0; i < size - 2; i++) {
      int j = i + 1;
      int k = size - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
        } else if (sum > 0) {
          k--;
        } else if (sum < 0) {
          j++;
        }
      }
    }
    return new ArrayList<>(set);
  }
}