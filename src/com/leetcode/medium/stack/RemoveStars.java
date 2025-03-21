package com.leetcode.medium.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    01/06/24,
 * Time:    1:12 am
 * 2390. Removing Stars From a String
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 */
public class RemoveStars {
  public static void main(String[] args) {
    RemoveStars removeStars = new RemoveStars();
    String s = "leet**cod*e";
    System.out.println(removeStars.removeStarsTwoPointers(s));
    System.out.println(removeStars.removeStarsStringBuilder(s));
    System.out.println(removeStars.removeStarsUsingStack(s));
  }

  private String removeStarsTwoPointers(String s) {
    int size = s.length();
    int i = 0, j = 0;
    char[] chars = new char[size];
    for (i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == '*') {
        j--;
      } else {
        chars[j++] = ch;
      }
    }
    String result = "";
    for (i = 0; i < j; i++) {
      result += chars[i];
    }
    return result;
  }

  private String removeStarsStringBuilder(String s) {
    StringBuilder result = new StringBuilder();
    int size = s.length();
    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == '*') {
        result.deleteCharAt(result.length() - 1);
      } else {
        result.append(ch);
      }
    }
    return result.toString();
  }

  private String removeStarsUsingStack(String s) {
    Stack<Character> stack = new Stack<>();
    int size = s.length();
    for (int i = 0; i < size; i++) {
      char c = s.charAt(i);
      if (!stack.isEmpty() && c == '*') {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    String result = "";
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      result = stack.pop() + result;
    }
    return result;
  }
}