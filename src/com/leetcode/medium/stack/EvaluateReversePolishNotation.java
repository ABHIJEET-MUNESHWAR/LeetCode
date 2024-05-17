package com.leetcode.medium.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/05/24,
 * Time:    9:46 am
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {
  public static void main(String[] args) {
    EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
    String[] tokens = {"2", "1", "+", "3", "*"};
    System.out.println(evaluateReversePolishNotation.evaluateReversePolishNotation(tokens));
  }

  private int evaluateReversePolishNotation(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    int num1 = 0;
    int num2 = 0;
    for (String token : tokens) {
      switch (token) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          num1 = stack.pop();
          num2 = stack.pop();
          stack.push(num2 - num1);
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          num1 = stack.pop();
          num2 = stack.pop();
          stack.push(num2 / num1);
          break;
        default:
          stack.push(Integer.parseInt(token));
          break;
      }
    }
    return stack.pop();
  }
}