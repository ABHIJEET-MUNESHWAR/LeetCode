package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    24/02/23, Time:    11:55 am
 */
public class SortSentence {

  public static void main(String[] args) {
    SortSentence sortSentence = new SortSentence();
    System.out.println(sortSentence.sortSentence("is2 sentence4 This1 a3"));
  }

  private String sortSentence(String s) {
    String[] words = s.split(" ");
    int size = words.length;
    String[] ans = new String[size];
    for (String word : words) {
      int i = word.length() - 1;
      ans[word.charAt(i) - '1'] = word.substring(0, i);
    }
    return String.join(" ", ans);
  }

}