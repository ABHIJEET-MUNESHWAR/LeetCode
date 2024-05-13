package com.leetcode.medium.math;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/05/24,
 * Time:    6:31 pm
 * 131. Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning {
  public static void main(String[] args) {
    PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
    String s = "aab";
    ListUtils.printStringLists(palindromePartitioning.palindromePartitioning(s));
  }

  private List<List<String>> palindromePartitioning(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(result, new ArrayList<String>(), s, 0);
    return result;
  }

  private void backtrack(List<List<String>> result, ArrayList<String> tempList, String s, int start) {
    if (start == s.length()) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = start; i < s.length(); i++) {
        if (isPalindrome(s, start, i)) {
          tempList.add(s.substring(start, i + 1));
          backtrack(result, tempList, s, i + 1);
          tempList.remove(tempList.size() - 1);
        }
      }
    }
  }

  private boolean isPalindrome(String s, int low, int high) {
    while (low < high) {
      if (s.charAt(low++) != s.charAt(high--)) {
        return false;
      }
    }
    return true;
  }
}