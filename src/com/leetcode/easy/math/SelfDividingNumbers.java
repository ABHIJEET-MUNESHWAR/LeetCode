package com.leetcode.easy.math;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/09/23,
 * Time:    4:42 pm
 * https://leetcode.com/problems/self-dividing-numbers/
 */
public class SelfDividingNumbers {
  public static void main(String[] args) {
    SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
    List<Integer> nums = selfDividingNumbers.selfDividingNumbers(302, 304);
    ArrayUtils.printIntArray(nums);
  }

  private List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> nums = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      int num = i;
      int n = i;
      if (num % 10 == 0) {
        continue;
      }
      boolean isFound = true;
      while (n > 0) {
        int mod = n % 10;
        if (mod == 0) {
          isFound = false;
          break;
        }
        if (num % mod != 0) {
          isFound = false;
          break;
        }
        n = n / 10;
      }
      if (isFound) {
        nums.add(num);
      }
    }
    return nums;
  }
}