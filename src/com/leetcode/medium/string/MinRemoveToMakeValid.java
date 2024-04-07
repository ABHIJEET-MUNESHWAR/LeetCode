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
    String s = "lee(t(c)o)de)";
    System.out.println(minRemoveToMakeValid.minRemoveToMakeValid(s));
  }

  private String minRemoveToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();
    int stackIterator = 0;
    for (char ch: s.toCharArray()) {
      stackIterator++;
    }
    return s;
  }
}