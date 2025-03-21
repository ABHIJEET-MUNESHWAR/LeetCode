package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/04/23, Time:    3:54 pm
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class MaxDepthOfParentheses {

  public static void main(String[] args) {
    MaxDepthOfParentheses maxDepthOfParentheses = new MaxDepthOfParentheses();
    String s = "(1+(2*3)+((8)/4))+1";
    System.out.println(maxDepthOfParentheses.maxDepthOfParentheses(s));
  }

  private int maxDepthOfParentheses(String s) {
    int maxDepth = Integer.MIN_VALUE;
    int currCount = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        currCount++;
      }
      if (ch == ')') {
        currCount--;
      }
      if (maxDepth < currCount) {
        maxDepth = currCount;
      }
    }
    return maxDepth;
  }
}