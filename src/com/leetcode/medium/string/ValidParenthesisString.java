package com.leetcode.medium.string;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    18/04/24,
 * Time:    10:08 am
 * https://leetcode.com/problems/valid-parenthesis-string/description/?envType=daily-question&envId=2024-04-07
 * 678. Valid Parenthesis String
 */
public class ValidParenthesisString {
  public static void main(String[] args) {
    ValidParenthesisString validParenthesisString = new ValidParenthesisString();
    System.out.println(validParenthesisString.checkValidString(
        "(((((()*)(*)*))())())(()())())))((**)))))(()())()"));
  }

  private boolean checkValidString(String s) {
    Stack<Integer> openingStack = new Stack<>();
    Stack<Integer> starStack = new Stack<>();
    int size = s.length();
    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      switch (ch) {
        case '*':
          starStack.push(i);
          break;
        case '(':
          openingStack.push(i);
          break;
        case ')':
          if (!openingStack.isEmpty()) {
            openingStack.pop();
          } else if (!starStack.isEmpty()) {
            starStack.pop();
          } else {
            return false;
          }
          break;
      }
    }
    while (!openingStack.isEmpty()) {
      if (starStack.isEmpty()) {
        return false;
      }
      if (openingStack.pop() > starStack.pop()) {
        return false;
      }
    }
    return openingStack.isEmpty();
  }
}