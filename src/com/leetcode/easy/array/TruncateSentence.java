package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/04/23, Time:    12:36 pm
 * https://leetcode.com/problems/truncate-sentence/
 */
public class TruncateSentence {

  public static void main(String[] args) {
    TruncateSentence truncateSentence = new TruncateSentence();
    String s = "Hello how are you Contestant";
    int k = 4;
    System.out.println(truncateSentence.truncateSentence(s, k));
  }

  private String truncateSentence(String s, int k) {
    String[] strArray = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    for (; i < k - 1; i++) {
      stringBuilder.append(strArray[i]);
      stringBuilder.append(" ");
    }
    stringBuilder.append(strArray[i]);
    return stringBuilder.toString();
  }
}