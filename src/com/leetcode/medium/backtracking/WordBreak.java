package com.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/05/24,
 * Time:    2:27 pm
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 */
public class WordBreak {
  public static void main(String[] args) {
    WordBreak wb = new WordBreak();
    String s = "leetcode";
    List<String> wordDict = new ArrayList<String>();
    wordDict.add("leet");
    wordDict.add("code");
    System.out.println(wb.wordBreak(s, wordDict));
    System.out.println(wb.wordBreakBottomUp(s, wordDict));
  }

  HashSet<String> set = new HashSet<String>();
  Boolean[] dp = new Boolean[301];

  private boolean wordBreakBottomUp(String s, List<String> wordDict) {
    set.addAll(wordDict);
    return solveBottomUp(s);
  }

  private boolean solveBottomUp(String s) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    int size = s.length();
    for (int i = 1; i <= size; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  private boolean wordBreak(String s, List<String> wordDict) {
    set.addAll(wordDict);
    return solve(s, 0);
  }

  private boolean solve(String s, int index) {
    if (index >= s.length()) {
      return true;
    }
    if (dp[index] != null) {
      return dp[index];
    }
    for (int endIndex = index + 1; endIndex <= s.length(); endIndex++) {
      String sub = s.substring(index, endIndex);
      if (set.contains(sub) && solve(s, endIndex)) {
        dp[index] = true;
        return true;
      }
    }
    dp[index] = false;
    return false;
  }
}