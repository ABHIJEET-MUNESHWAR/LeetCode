package com.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    10/09/22, Time:    6:33 PM
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPattern {

  public static void main(String[] args) {
    WordPattern wordPattern = new WordPattern();
//    String pattern = "abba";
//    String s = "dog cat cat dog";
//    String pattern = "abba";
//    String s = "dog cat cat fish";
    String pattern = "abba";
    String s = "dog dog dog dog";
    System.out.println(wordPattern.wordPattern(pattern, s));
  }

  private boolean wordPattern(String pattern, String s) {
    char[] charArray = pattern.toCharArray();
    String[] wordArray = s.split(" ");
    Map<Character, String> map = new HashMap<>();
    int size = charArray.length;
    if (size != wordArray.length) {
      return false;
    }
    for (int i = 0; i < size; i++) {
      if (map.containsKey(charArray[i])) {
        String wordFound = map.get(charArray[i]);
        if (!wordFound.equals(wordArray[i])) {
          return false;
        }
      } else {
        if (map.containsValue(wordArray[i])) {
          return false;
        }
        map.put(charArray[i], wordArray[i]);
      }
    }
    return true;
  }
}