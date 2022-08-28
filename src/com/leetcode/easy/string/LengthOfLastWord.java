package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    27/08/22, Time:    9:43 PM
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

  public static void main(String[] args) {
    LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
    System.out.println(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
    System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
    System.out.println(lengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
    System.out.println(lengthOfLastWord.lengthOfLastWord("    day"));
  }

  private int lengthOfLastWord(String s) {
    int size = 0;
    int len = s.length();
    for (int i = len - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        size++;
      } else {
        if (size > 0) {
          return size;
        }
      }
    }
    return size;
  }
}