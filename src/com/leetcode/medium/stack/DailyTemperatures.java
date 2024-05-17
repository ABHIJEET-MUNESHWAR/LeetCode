package com.leetcode.medium.stack;

import com.leetcode.utils.ArrayUtils;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/05/24,
 * Time:    10:35 pm
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
 */
public class DailyTemperatures {
  public static void main(String[] args) {
    DailyTemperatures dailyTemperatures = new DailyTemperatures();
    int[] temperatures = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
    ArrayUtils.printArray(dailyTemperatures.dailyTemperatures(temperatures));
  }

  private int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> stack = new Stack<>();
    int size = temperatures.length;
    int[] result = new int[size];
    for (int i = size - 1; i >= 0; i--) {
      while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        result[i] = 0;
      } else {
        result[i] = stack.peek() - i;
      }
      stack.push(i);
    }
    return result;
  }
}