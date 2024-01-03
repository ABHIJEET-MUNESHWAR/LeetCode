package com.leetcode.easy.array;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/01/24,
 * Time:    1:19am
 * https://leetcode.com/problems/find-words-containing-character/
 */
public class FindWordsContaining {
  public static void main(String[] args) {
    FindWordsContaining findWordsContaining = new FindWordsContaining();
    String[] words = {"abc", "bcd", "aaaa", "cbc"};
    char x = 'a';
    ArrayUtils.printIntArray(findWordsContaining.findWordsContaining(words, x));
  }

  private List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> answer = new ArrayList<>();
    int size = words.length;
    for (int i = 0; i < size; i++) {
      String word = words[i];
      int len = word.length();
      for (int j = 0; j < len; j++) {
        if (word.charAt(j) == x) {
          answer.add(i);
          break;
        }
      }
    }
    return answer;
  }
}