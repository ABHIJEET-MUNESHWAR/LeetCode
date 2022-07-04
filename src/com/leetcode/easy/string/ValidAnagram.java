package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    03/07/22, Time:    9:05 PM
 */
public class ValidAnagram {

  public static void main(String[] args) {
    ValidAnagram validAnagram = new ValidAnagram();
    String s = "anagram";
    String t = "nagaram";
    /*String s = "rat";
    String t = "car";*/
    System.out.println(validAnagram.validAnagram(s, t) ? "Yes" : "No");
  }

  private boolean validAnagram(String s, String t) {
    boolean isValidAnagram = true;
    int len1 = s.length();
    int len2 = t.length();
    if (len1 != len2) {
      return false;
    }
    int[] alphabet = new int[26];
    for (int i = 0; i < len1; i++) {
      Character ch = s.charAt(i);
      alphabet[ch - 'a']++;
    }
    for (int i = 0; i < len1; i++) {
      Character ch = t.charAt(i);
      alphabet[ch - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (alphabet[i] != 0) {
        return false;
      }
    }
    return isValidAnagram;
  }
}