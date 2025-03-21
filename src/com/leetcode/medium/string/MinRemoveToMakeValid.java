package com.leetcode.medium.string;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/04/24,
 * Time:    7:52 am
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/?envType=daily-question&envId=2024-04-06
 */
public class MinRemoveToMakeValid {
  public static void main(String[] args) {
    MinRemoveToMakeValid minRemoveToMakeValid = new MinRemoveToMakeValid();
    String s = "a)b(c)d";
    System.out.println(minRemoveToMakeValid.minRemoveToMakeValid(s));
  }

  private String minRemoveToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder(s);
    int size = s.length();
    for (int i = 0; i < size; i++) {
      char ch = sb.charAt(i);
      if (ch == '(') {
        stack.push(ch);
      }
      if (ch == ')') {
        if (!stack.isEmpty()) {
          stack.pop();
        } else {
          sb.setCharAt(i, '*');
        }
      }
    }
    while (!stack.isEmpty()) {
      sb.setCharAt(stack.pop(), '*');
    }
    return sb.toString().replaceAll("\\*", "");
  }
}