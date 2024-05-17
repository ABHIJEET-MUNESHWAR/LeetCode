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