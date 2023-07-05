package com.leetcode.easy.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/07/23,
 * Time:    11:47 am
 * https://leetcode.com/problems/find-maximum-number-of-string-pairs/
 */
public class MaxNoOfStringPairs {
  public static void main(String[] args) {
    MaxNoOfStringPairs maxNoOfStringPairs = new MaxNoOfStringPairs();
    String[] words = {"cd", "ac", "dc", "ca", "zz"};
    System.out.println(maxNoOfStringPairs.maxNoOfStringPairs(words));
  }

  private int maxNoOfStringPairs(String[] words) {
    int count = 0;
    Set<String> wordsSet = new HashSet<>();
    for (String word : words) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = String.valueOf(chars);
      if (wordsSet.contains(sortedWord)) {
        count++;
      } else {
        wordsSet.add(sortedWord);
      }
    }
    return count;
  }
}