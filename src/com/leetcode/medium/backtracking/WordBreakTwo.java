package com.leetcode.medium.backtracking;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    26/05/24,
 * Time:    10:21 pm
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/description/?envType=daily-question&envId=2024-05-25
 */
public class WordBreakTwo {
  public static void main(String[] args) {
    WordBreakTwo wordBreakTwo = new WordBreakTwo();
    String s = "catsanddog";
    List<String> wordDict = new ArrayList<>();
    wordDict.add("cat");
    wordDict.add("cats");
    wordDict.add("and");
    wordDict.add("sand");
    wordDict.add("dog");
    ListUtils.printStringList(wordBreakTwo.wordBreak(s, wordDict));
    ListUtils.printStringList(wordBreakTwo.wordBreakTwo(s, wordDict));
  }

  Set<String> set = new HashSet<>();
  Map<String, List<String>> dpMap = new HashMap<>();

  private List<String> wordBreakTwo(String s, List<String> wordDict) {
    set.addAll(wordDict);
    return solveWordBreakTwo(s);
  }

  private List<String> solveWordBreakTwo(String s) {
    if (s.isEmpty()) {
      return Arrays.asList("");
    }
    if (dpMap.containsKey(s)) {
      return dpMap.get(s);
    }
    List<String> result = new ArrayList<>();
    for (int l = 1; l <= s.length(); l++) {
      String currentWord = s.substring(0, l);
      if (set.contains(currentWord)) {
        String remainingWord = s.substring(l);
        List<String> remainingResult = solveWordBreakTwo(remainingWord);
        for (String word : remainingResult) {
          String toAdd = currentWord + (word.isEmpty() ? "" : " ") + word;
          result.add(toAdd);
        }
      }
    }
    dpMap.put(s, result);
    return result;
  }

  private List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> set = new HashSet<>();
    set.addAll(wordDict);
    List<String> result = new ArrayList<>();
    solve(s, 0, "", set, result);
    return result;
  }

  private void solve(String s, int index, String currentSentence, Set<String> set, List<String> result) {
    if (index >= s.length()) {
      result.add(currentSentence);
      return;
    }
    for (int endIndex = index; endIndex < s.length(); endIndex++) {
      String subString = s.substring(index, endIndex + 1);
      if (set.contains(subString)) {
        String tempSentence = currentSentence;
        if (!currentSentence.isEmpty()) {
          currentSentence += " ";
        }
        currentSentence += subString;
        solve(s, endIndex + 1, currentSentence, set, result);
        currentSentence = tempSentence;
      }
    }
  }
}