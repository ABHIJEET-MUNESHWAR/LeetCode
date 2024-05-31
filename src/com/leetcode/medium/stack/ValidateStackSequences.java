package com.leetcode.medium.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/06/24,
 * Time:    2:24 am
 * 946. Validate Stack Sequences
 * https://leetcode.com/problems/validate-stack-sequences/description/
 */
public class ValidateStackSequences {
  public static void main(String[] args) {
    ValidateStackSequences validateStackSequences = new ValidateStackSequences();
    int[] pushed = {1, 2, 3, 4, 5};
    int[] popped = {4, 5, 3, 2, 1};
    System.out.println(validateStackSequences.validateStackSequences(pushed, popped));
  }

  private boolean validateStackSequences(int[] pushed, int[] popped) {
    Stack<Integer> stack = new Stack<>();
    int size = pushed.length;
    int i = 0, j = 0;
    while (i < size && j < size) {
      stack.push(pushed[i]);
      while (!stack.isEmpty() && j < size && stack.peek() == popped[j]) {
        stack.pop();
        j++;
      }
      i++;
    }
    return stack.isEmpty();
  }
}