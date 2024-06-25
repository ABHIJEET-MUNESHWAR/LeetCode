package com.leetcode.medium.dynamicprogramming.twodimension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    19/06/24,
 * Time:    7:37 pm
 * 1239. Maximum Length of a Concatenated String with Unique Characters
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
 */
public class MaxLengthOfUniqueConcatenatedString {
  public static void main(String[] args) {
    MaxLengthOfUniqueConcatenatedString obj = new MaxLengthOfUniqueConcatenatedString();
    List<String> arr = new ArrayList<>(Arrays.asList("un", "iq", "ue"));
    //List<String> arr = new ArrayList<>(Arrays.asList("aa", "bb"));
    System.out.println(obj.maxLengthRecursion(arr));
    System.out.println(obj.maxLengthRecursionMemoization(arr));
  }

  private int maxLengthRecursionMemoization(List<String> arr) {
    return solveRecursionMemoization(arr, "", 0, new HashMap<String, Integer>());
  }

  private int solveRecursionMemoization(List<String> arr, String temp, int index, HashMap<String, Integer> map) {
    if (index >= arr.size()) {
      return temp.length();
    }
    if (map.containsKey(temp)) {
      return map.get(temp);
    }
    int includeLength = 0;
    int excludeLength = 0;
    if (isUnique(arr.get(index), temp)) {
      // Either Include OR Exclude
      // Include
      String originalTemp = temp;
      temp += arr.get(index);
      includeLength += solveRecursionMemoization(arr, temp, index + 1, map);
      temp = originalTemp;
    }
    // Exclude
    excludeLength += solveRecursionMemoization(arr, temp, index + 1, map);
    int result = Math.max(includeLength, excludeLength);
    map.put(temp, result);
    return result;
  }


  private int maxLengthRecursion(List<String> arr) {
    return solveRecursion(arr, "", 0);
  }

  private int solveRecursion(List<String> arr, String temp, int index) {
    if (index >= arr.size()) {
      return temp.length();
    }
    int includeLength = 0;
    int excludeLength = 0;
    if (isUnique(arr.get(index), temp)) {
      // Either Include OR Exclude
      // Include
      String originalTemp = temp;
      temp += arr.get(index);
      includeLength += solveRecursion(arr, temp, index + 1);
      temp = originalTemp;
    }
    // Exclude
    excludeLength += solveRecursion(arr, temp, index + 1);
    int result = Math.max(includeLength, excludeLength);
    return result;
  }

  private boolean isUnique(String string1, String string2) {
    int[] frequencyMap = new int[26];
    for (char c : string1.toCharArray()) {
      int ch = c - 'a';
      if (frequencyMap[ch] > 0) {
        return false;
      }
      frequencyMap[ch]++;
    }
    for (char c : string2.toCharArray()) {
      if (frequencyMap[c - 'a'] > 0) {
        return false;
      }
    }
    return true;
  }
}