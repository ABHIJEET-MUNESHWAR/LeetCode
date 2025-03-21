package com.leetcode.easy.hash;

import com.leetcode.utils.ListUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    05/06/24,
 * Time:    7:29 am
 * 1002. Find Common Characters
 * https://leetcode.com/problems/find-common-characters/description/?envType=daily-question&envId=2024-06-05
 */
public class CommonChars {
  public static void main(String[] args) {
    CommonChars commonChars = new CommonChars();
    //String[] words = {"bella", "label", "roller"};
    String[] words = {"cool", "lock", "cook"};
    ListUtils.printStringList(commonChars.commonChars(words));
  }

  private List<String> commonChars(String[] words) {
    List<String> list = new ArrayList<>();
    int[] count = new int[26];
    count = count(words[0]);
    for (int i = 1; i < words.length; i++) {
      count = intersection(count, count(words[i]));
    }
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        while (count[i] > 0) {
          char a = 'a';
          a += i;
          String s = String.valueOf(a);
          list.add(s);
          count[i]--;
        }
      }
    }
    return list;
  }

  private int[] intersection(int[] a, int[] b) {
    int[] temp = new int[26];
    for (int i = 0; i < 26; i++) {
      temp[i] = Math.min(a[i], b[i]);
    }
    return temp;
  }

  private int[] count(String word) {
    int[] count = new int[26];
    for (int i = 0; i < word.length(); i++) {
      count[word.charAt(i) - 'a']++;
    }
    return count;
  }
}