package com.leetcode.medium.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/04/24,
 * Time:    8:25 am
 * https://leetcode.com/problems/remove-k-digits/description/?envType=daily-question&envId=2024-04-11
 */
public class RemoveKDigits {
  public static void main(String[] args) {
    RemoveKDigits removeKDigits = new RemoveKDigits();
    String num = "1432219";
    int k = 3;
    System.out.println(removeKDigits.removeKDigits(num, k));
  }

  private String removeKDigits(String num, int k) {
    Stack<Character> stack = new Stack<>();
    int size = num.length();
    for (int i = 0; i < size; i++) {
      Character ch = num.charAt(i);
      while ((k > 0) && (!stack.isEmpty()) && (stack.peek() > ch)) {
        stack.pop();
        k--;
      }
      if (ch != '0' || !stack.isEmpty()) {
        stack.push(ch);
      }
    }
    // Now remove larger values from top of stack
    // e.g. num = 123 & k=2
    while (k-- > 0 && !stack.isEmpty()) {
      stack.pop();
    }
    if (stack.isEmpty()) {
      return "0";
    }
    String answer = "";
    while (!stack.isEmpty()) {
      answer = stack.pop() + answer;
    }
    return answer;
  }
}