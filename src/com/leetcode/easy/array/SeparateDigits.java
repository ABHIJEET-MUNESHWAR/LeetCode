package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/09/23,
 * Time:    3:18 pm
 * https://leetcode.com/problems/separate-the-digits-in-an-array/
 * 123
 */
public class SeparateDigits {
  public static void main(String[] args) {
    SeparateDigits separateDigits = new SeparateDigits();
    int[] nums = {13, 25, 83, 77};
    ArrayUtils.printArray(separateDigits.separateDigits(nums));
  }

  private int[] separateDigits(int[] nums) {
    ArrayList<Integer> digits = new ArrayList<>();
    for (int num : nums) {
      if (num > 9) {
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
          stack.push(num % 10);
          num = num / 10;
        }
        while (!stack.isEmpty()) {
          digits.add(stack.pop());
        }
      } else {
        digits.add(num);
      }
    }
    return digits.stream().mapToInt(i -> i).toArray();
  }
}