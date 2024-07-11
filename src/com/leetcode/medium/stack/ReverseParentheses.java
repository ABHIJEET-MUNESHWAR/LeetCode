package com.leetcode.medium.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/07/24,
 * Time:    8:31 am
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/?envType=daily-question&envId=2024-07-11
 */
public class ReverseParentheses {
  public static void main(String[] args) {
    ReverseParentheses reverseParentheses = new ReverseParentheses();
    String s = "(ed(et(oc))el)";
    System.out.println(reverseParentheses.reverseParentheses(s));
    System.out.println(reverseParentheses.reverseParenthesesOptimised(s));
  }

  private String reverseParenthesesOptimised(String s) {
    Stack<Integer> openBracketIndex = new Stack<>();
    int n = s.length();
    int[] door = new int[n];
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == '(') {
        openBracketIndex.push(i);
      } else if (c == ')') {
        int openBracket = openBracketIndex.pop();
        door[i] = openBracket;
        door[openBracket] = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    int flag = 1;
    for (int i = 0; i < n; i += flag) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        i = door[i];
        flag = -flag;
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }

  private String reverseParentheses(String s) {
    Stack<Integer> startParenthesesStack = new Stack<>();
    char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
      char ch = chars[i];
      switch (ch) {
        case '(':
          startParenthesesStack.push(i);
          break;
        case ')':
          int startIndex = startParenthesesStack.pop();
          s = reverseString(s, startIndex + 1, i - 1);
          break;
      }
    }
    chars = s.toCharArray();
    for (char c : chars) {
      if (c != ')' && c != '(') {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  private String reverseString(String s, int start, Integer end) {
    int i = start;
    int j = end;
    char[] chars = s.toCharArray();
    while (i < j) {
      char temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
      i++;
      j--;
    }
    return new String(chars);
  }
}