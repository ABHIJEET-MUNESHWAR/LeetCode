package com.leetcode.easy.string;

import com.leetcode.utils.ArrayUtils;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    13/03/24,
 * Time:    4:03 pm
 */
public class ShortestToChar {
  public static void main(String[] args) {
    ShortestToChar shortestToChar = new ShortestToChar();
    String s = "loveleetcode";
    char c = 'e';
    ArrayUtils.printArray(shortestToChar.shortestToCharTwoInnerLoops(s, c));
    ArrayUtils.printArray(shortestToChar.shortestToCharOneLoop(s, c));
  }

  private int[] shortestToCharOneLoop(String s, char c) {
    int size = s.length();
    int[] answer = new int[size];
    int pos = -size;
    for (int i = 0; i < size; i++) {
      if (s.charAt(i) == c) {
        pos = i;
      }
      answer[i] = i - pos;
    }
    for (int i = pos - 1; i >= 0; i--) {
      if (s.charAt(i) == c) {
        pos = i;
      }
      answer[i] = Math.min(answer[i], pos - i);
    }
    return answer;
  }

  private int[] shortestToCharTwoInnerLoops(String s, char c) {
    int size = s.length();
    int[] answer = new int[size];
    for (int i = 0; i < size; i++) {
      char ch = s.charAt(i);
      if (ch == c) {
        answer[i] = 0;
      } else {
        int a = i, b = i;
        while (a >= 0 || b <= size) {
          if ((a >= 0) && (s.charAt(a) == c)) {
            answer[i] = i - a;
            break;
          }
          if ((b < size) && (s.charAt(b) == c)) {
            answer[i] = b - i;
            break;
          }
          a--;
          b++;
        }
      }
    }
    return answer;
  }
}