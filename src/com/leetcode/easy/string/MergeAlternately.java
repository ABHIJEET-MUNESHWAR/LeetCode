package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    18/04/23, Time:    12:49 pm
 * https://leetcode.com/problems/merge-strings-alternately/
 */
public class MergeAlternately {

  public static void main(String[] args) {
    MergeAlternately mergeAlternately = new MergeAlternately();
    String word1 = "ab", word2 = "pqrs";
    System.out.println(mergeAlternately.mergeAlternately(word1, word2));
  }

  private String mergeAlternately(String word1, String word2) {
    char[] chars1 = word1.toCharArray();
    char[] chars2 = word2.toCharArray();
    int len1 = word1.length();
    int len2 = word2.length();
    char[] chars3 = new char[len1 + len2];
    int i = 0, j = 0, k = 0;
    while (i < len1 && j < len2) {
      chars3[k++] = chars1[i++];
      chars3[k++] = chars2[j++];
    }
    while (i < len1) {
      chars3[k++] = chars1[i++];
    }
    while (j < len2) {
      chars3[k++] = chars2[j++];
    }
    return new String(chars3);
  }
}