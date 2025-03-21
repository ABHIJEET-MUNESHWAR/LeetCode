package com.leetcode.easy.string;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/04/24,
 * Time:    7:20 am
 * https://leetcode.com/problems/make-the-string-great/?envType=daily-question&envId=2024-04-05
 */
public class MakeGood {
  public static void main(String[] args) {
    MakeGood makeGood = new MakeGood();
    String s = "abBAcC";
    System.out.println(makeGood.makeGoodUsingRecursion(s));
    System.out.println(makeGood.makeGoodUsingStack("leEeetcode"));
  }

  private String makeGoodUsingStack(String s) {
    int size = s.length();
    Stack<Character> stack = new Stack<>();
    stack.add(s.charAt(0));
    for (int i = 1; i < size; i++) {
      if (!stack.isEmpty() && Math.abs(stack.peek() - s.charAt(i)) == 32) {
        stack.pop();
      } else {
        stack.add(s.charAt(i));
      }
    }
    s = "";
    while (!stack.isEmpty()) {
      s = stack.pop() + s;
    }
    return s;
  }

  private String makeGoodUsingRecursion(String s) {
    int size = s.length();
    for (int i = 0; i < size - 1; i++) {
      if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
        return makeGoodUsingRecursion(s.substring(0, i) + s.substring(i + 2));
      }
    }
    return s;
  }
}