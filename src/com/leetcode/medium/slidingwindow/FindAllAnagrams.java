package com.leetcode.medium.slidingwindow;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/05/24,
 * Time:    10:56 pm
 */
public class FindAllAnagrams {
  public static void main(String[] args) {
    FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
    String s = "cbaebabacd", p = "abc";
    ListUtils.printList(findAllAnagrams.findAnagrams(s, p));
  }

  private List<Integer> findAnagrams(String s, String p) {
    List<Integer> answer = new ArrayList<>();
    int sourceSize = s.length();
    int patternSize = p.length();
    int[] patternFrequency = new int[26];
    for (char c : p.toCharArray()) {
      patternFrequency[c - 'a']++;
    }
    return answer;
  }
}