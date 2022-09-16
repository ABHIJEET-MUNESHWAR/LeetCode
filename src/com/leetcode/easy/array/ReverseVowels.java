package com.leetcode.easy.array;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    16/09/22, Time:    7:54 AM
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {

  public static void main(String[] args) {
    ReverseVowels reverseVowels = new ReverseVowels();
    System.out.println(reverseVowels.reverseVowels("Euston saw I was not Sue."));
  }

  private String reverseVowels(String str) {
    int size = str.length();
    char[] strArray = str.toCharArray();
    String vowels = "aeiouAEIOU";
    int start = 0;
    int end = size - 1;
    while (start < end) {
      while (start < end && !vowels.contains(strArray[start] + "")) {
        start++;
      }
      while (start < end && !vowels.contains(strArray[end] + "")) {
        end--;
      }
      char temp = strArray[start];
      strArray[start] = strArray[end];
      strArray[end] = temp;
      start++;
      end--;
    }
    return String.valueOf(strArray);
  }
}