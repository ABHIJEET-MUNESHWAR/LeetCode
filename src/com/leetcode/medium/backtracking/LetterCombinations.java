package com.leetcode.medium.backtracking;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    27/05/24,
 * Time:    11:14 pm
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinations {
  public static void main(String[] args) {
    LetterCombinations letterCombinations = new LetterCombinations();
    String digits = "23";
    ListUtils.printStringList(letterCombinations.letterCombinations(digits));
  }

  List<String> result = new ArrayList<>();
  String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  private List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return result;
    }
    solve(digits, 0, "");
    return result;
  }

  private void solve(String digits, int index, String temp) {
    if (index >= digits.length()) {
      result.add(temp);
      return;
    }
    char ch = digits.charAt(index);
    String str = mapping[ch - '0'];
    for (int i = 0; i < str.length(); i++) {
      String tmp = temp;
      temp += str.charAt(i);                // Do
      solve(digits, index + 1, temp); // Explore
      temp = tmp;                           // Undo
    }
  }
}