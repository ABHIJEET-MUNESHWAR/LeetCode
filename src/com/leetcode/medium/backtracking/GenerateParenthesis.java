package com.leetcode.medium.backtracking;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/05/24,
 * Time:    10:20 pm
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParenthesis {
  public static void main(String[] args) {
    GenerateParenthesis generateParenthesis = new GenerateParenthesis();
    ListUtils.printStringList(generateParenthesis.generateParenthesis(3));
    System.out.println();
    ListUtils.printStringList(generateParenthesis.generateParenthesisOne(3));
    System.out.println();
    ListUtils.printStringList(generateParenthesis.generateParenthesisOptimised(3));
  }

  private List<String> generateParenthesisOptimised(int n) {
    List<String> result = new ArrayList<>();
    solveOptimised("", n, result, 0, 0);
    return result;
  }

  private void solveOptimised(String str, int n, List<String> result, int open, int close) {
    if (str.length() == 2 * n) {
      result.add(str);
      return;
    }
    if (open < n) {
      str += "(";
      solveOptimised(str, n, result, open + 1, close);
      str = str.substring(0, str.length() - 1);
    }
    if (close < open) {
      str += ")";
      solveOptimised(str, n, result, open, close + 1);
      str = str.substring(0, str.length() - 1);
    }
  }

  private List<String> generateParenthesisOne(int n) {
    List<String> result = new ArrayList<>();
    solveOne("", n, result);
    return result;
  }

  private void solveOne(String str, int n, List<String> result) {
    if (str.length() == 2 * n) {
      if (isValid(str)) {
        result.add(str);
      }
      return;
    }
    str += "(";                               // Do
    solveOne(str, n, result);                 // Recursion
    str = str.substring(0, str.length() - 1); // Undo

    str += ")";                               // Do
    solveOne(str, n, result);                 // Recursion
  }

  private boolean isValid(String str) {
    int count = 0;
    int length = str.length();
    for (int i = 0; i < length; i++) {
      if (str.charAt(i) == '(') {
        count++;
      } else {
        count--;
      }
      if (count < 0) {
        return false;
      }
    }
    return count == 0;
  }

  private List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generateParenthesis(result, 0, 0, "", n);
    return result;
  }

  private void generateParenthesis(List<String> result, int left, int right, String s, int n) {
    if (s.length() == n * 2) {
      result.add(s);
      return;
    }
    if (left < n) {
      generateParenthesis(result, left + 1, right, s + "(", n);
    }
    if (right < left) {
      generateParenthesis(result, left, right + 1, s + ")", n);
    }
  }
}