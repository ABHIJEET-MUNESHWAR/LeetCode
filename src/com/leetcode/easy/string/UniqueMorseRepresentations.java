package com.leetcode.easy.string;

import java.util.HashSet;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    04/04/23, Time:    12:10 pm
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */
public class UniqueMorseRepresentations {

  public static void main(String[] args) {
    UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
    String[] words = {"gin", "zen", "gig", "msg"};
    System.out.println(uniqueMorseRepresentations.uniqueMorseRepresentations(words));
  }

  private int uniqueMorseRepresentations(String[] words) {
    String[] morseWords = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--",
        "-..-", "-.--", "--.."};
    HashSet<String> uniqueWords = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        sb.append(morseWords[word.charAt(i) - 'a']);
      }
      uniqueWords.add(sb.toString());
    }
    return uniqueWords.size();
  }
}