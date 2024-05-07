package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/05/24,
 * Time:    2:58 pm
 * 1630. Arithmetic SubArrays
 * https://leetcode.com/problems/arithmetic-subarrays/description/
 */
public class ArithmeticSubArrays {
  public static void main(String[] args) {
    ArithmeticSubArrays arithmeticSubArrays = new ArithmeticSubArrays();
    int[] nums = {4, 6, 5, 9, 3, 7};
    int[] l = {0, 0, 2};
    int[] r = {2, 3, 5};
    ListUtils.printBooleanList(arithmeticSubArrays.arithmeticSubArrays(nums, l, r));
  }

  private List<Boolean> arithmeticSubArrays(int[] nums, int[] l, int[] r) {
    List<Boolean> result = new ArrayList<>();
    for (int i = 0; i < l.length; i++) {
      int[] extractedNums = Arrays.copyOfRange(nums, l[i], r[i]+1);
      Arrays.sort(extractedNums);
      int diff = extractedNums[1] - extractedNums[0];
      boolean isDiffSame = true;
      for (int j = 1; j < extractedNums.length; j++) {
        int intermediateDiff = extractedNums[j] - extractedNums[j - 1];
        if(intermediateDiff != diff){
          isDiffSame = false;
          break;
        }
      }
      result.add(isDiffSame);
    }
    return result;
  }
}