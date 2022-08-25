package com.leetcode.easy.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    25/08/22, Time:    7:36 AM
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

  public static void main(String[] args) {
    RansomNote ransomNote = new RansomNote();
    System.out.println("canConstruct: " + ransomNote.canConstruct("aa", "ab"));
  }

  private boolean canConstruct(String ransomNote, String magazine) {
    int[] charArray = new int[26];
    int lenOfMag = magazine.length();
    for (int i = 0; i < lenOfMag; i++) {
      charArray[magazine.charAt(i) - 'a']++;
    }
    int lenOfNote = ransomNote.length();
    for (int i = 0; i < lenOfNote; i++) {
      if (charArray[ransomNote.charAt(i)-'a'] == 0) {
        return false;
      } else {
        charArray[ransomNote.charAt(i)-'a']--;
      }
    }
    return true;
  }

  private boolean canConstruct2(String ransomNote, String magazine) {
    Map<Character, Integer> countMap = new HashMap<>();
    int len = magazine.length();
    for (int i = 0; i < len; i++) {
      Character ch = magazine.charAt(i);
      if (countMap.containsKey(ch)) {
        countMap.put(ch, countMap.get(ch) + 1);
      } else {
        countMap.put(ch, 1);
      }
    }
    int noteLen = ransomNote.length();
    for (int i = 0; i < noteLen; i++) {
      Character ch = ransomNote.charAt(i);
      if (countMap.containsKey(ch)) {
        int count = countMap.get(ch);
        if (count == 0) {
          return false;
        } else {
          countMap.put(ch, --count);
        }
      } else {
        return false;
      }
    }
    return true;
  }
}