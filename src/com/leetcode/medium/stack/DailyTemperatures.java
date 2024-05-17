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
    int size = temperatures.length;
    int[] result = new int[size];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < size; i++) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        int index = stack.pop();
        result[index] = i - index;
      }
      stack.push(i);
    }
    return result;
  }
}