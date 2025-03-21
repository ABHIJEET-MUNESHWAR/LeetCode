package com.leetcode.easy.string;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/09/23,
 * Time:    3:13 pm
 */
public class DiStringMatch {
  public static void main(String[] args) {
    DiStringMatch diStringMatch = new DiStringMatch();
    int[] answer = diStringMatch.diStringMatch("IDID");
    ArrayUtils.printArray(answer);
  }

  private int[] diStringMatch(String s) {
    int size = s.length();
    int[] answer = new int[size + 1];
    int low = 0;
    int high = size;
    for (int i = 0; i < size; i++) {
      if (s.charAt(i) == 'I') {
        answer[i] = low++;
      } else {
        answer[i] = high--;
      }
    }
    answer[size] = low;
    return answer;
  }
}