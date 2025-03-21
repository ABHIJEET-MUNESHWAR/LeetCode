package com.leetcode.easy.string;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    06/03/24,
 * Time:    9:40 am
 * https://leetcode.com/problems/split-strings-by-separator/description/
 */
public class SplitWordsBySeparator {
  public static void main(String[] args) {
    SplitWordsBySeparator splitWordsBySeparator = new SplitWordsBySeparator();
    List<String> words = Arrays.asList("one.two.three", "four.five", "six");
    char separator = '.';
    ArrayUtils.printStrArray(splitWordsBySeparator.splitWordsBySeparator(words, separator));
  }

  private List<String> splitWordsBySeparator(List<String> wordList, char separator) {
    List<String> answer = new ArrayList<>();
    for (String word : wordList) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) != separator) {
          sb.append(word.charAt(i));
        } else {
          if (sb.length() > 0) {
            answer.add(sb.toString());
            sb.setLength(0);
          }
        }
      }
      if (sb.length() > 0) {
        answer.add(sb.toString());
      }
    }
    return answer;
  }
}