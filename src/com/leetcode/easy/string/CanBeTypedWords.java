package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/10/23,
 * Time:    3:02pm
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type/
 */
public class CanBeTypedWords {
  public static void main(String[] args) {
    CanBeTypedWords canBeTypedWords = new CanBeTypedWords();
    String text = "hello world", brokenLetters = "ad";
    System.out.println(canBeTypedWords.canBeTypedWords(text, brokenLetters));
  }

  private int canBeTypedWords(String text, String brokenLetters) {
    int count = 0;
    String[] words = text.split(" ");
    for (String word : words) {
      boolean isNotFound = true;
      for (char ch : brokenLetters.toCharArray()) {
        if (word.contains(ch + "")) {
          isNotFound = false;
        }
      }
      if (isNotFound) {
        count++;
      }
    }
    return count;
  }
}