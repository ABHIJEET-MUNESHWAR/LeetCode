package com.leetcode.easy.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/10/23,
 * Time:    3:21pm
 */
public class BaseballGame {
  public static void main(String[] args) {
    BaseballGame baseballGame = new BaseballGame();
    String[] operations = {"5", "2", "C", "D", "+"};
    System.out.println(baseballGame.calPoints(operations));
  }

  private int calPoints(String[] operations) {
    int sum = 0;
    Stack<Integer> stack = new Stack<>();
    for (String operation : operations) {
      switch (operation) {
        case "C":
          stack.pop();
          break;
        case "D":
          int top = stack.peek();
          stack.add(top * 2);
          break;
        case "+":
          int firstTop = stack.pop();
          int secondTop = stack.pop();
          stack.add(secondTop);
          stack.add(firstTop);
          stack.add(firstTop + secondTop);
          break;
        default:
          stack.add(Integer.parseInt(operation));
      }
    }
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }
}