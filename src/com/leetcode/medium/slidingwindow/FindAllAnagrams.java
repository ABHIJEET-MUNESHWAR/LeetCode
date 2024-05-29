package com.leetcode.medium.slidingwindow;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/05/24,
 * Time:    10:56 pm
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
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
    int[] frequencyMap = new int[26];
    for (int i = 0; i < patternSize; i++) {
      frequencyMap[p.charAt(i) - 'a']++;
    }
    int left = 0, right = 0;
    while (right < sourceSize) {
      frequencyMap[s.charAt(right) - 'a']--;
      if ((right - left + 1) == patternSize) {
        if (isAllZero(frequencyMap)) {
          answer.add(left);
        }
        frequencyMap[s.charAt(left) - 'a']++;
        left++;
      }
      right++;
    }
    return answer;
  }

  private boolean isAllZero(int[] frequencyMap) {
    int size = frequencyMap.length;
    for (int i = 0; i < size; i++) {
      if (frequencyMap[i] != 0) {
        return false;
      }
    }
    return true;
  }
}