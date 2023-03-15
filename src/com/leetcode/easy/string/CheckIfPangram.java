package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    15/03/23, Time:    12:00 pm
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class CheckIfPangram {

  public static void main(String[] args) {
    CheckIfPangram checkIfPangram = new CheckIfPangram();
    System.out.println(checkIfPangram.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
  }

  private boolean checkIfPangram(String sentence) {
    int seen = 0;
    for (char c : sentence.toCharArray()) {
      int ci = c - 'a';
      seen = seen | (1 << ci);
    }
    return seen == ((1 << 26) - 1);
  }
}