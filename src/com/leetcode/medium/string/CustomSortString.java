package com.leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    11/03/24,
 * Time:    7:26 am
 * https://leetcode.com/problems/custom-sort-string/description/?envType=daily-question&envId=2024-03-11
 */
public class CustomSortString {
  public static void main(String[] args) {
    CustomSortString customSortString = new CustomSortString();
    String order = "kqep", s = "pekeq";
    System.out.println(customSortString.customSortStringUsingString(order, s));
    System.out.println(customSortString.customSortStringUsingHashMap(order, s));
  }

  private String customSortStringUsingHashMap(String order, String s) {
    String answer = "";
    Map<Character, Integer> map = new HashMap<>();
    int orderSize = order.length();
    int strSize = s.length();
    for (int i = 0; i < strSize; i++) {
      Character ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < orderSize; i++) {
      Character ch = order.charAt(i);
      if (map.containsKey(ch)) {
        int frequency = map.get(ch);
        for (int j = 0; j < frequency; j++) {
          answer += ch;
        }
        map.remove(ch);
      }
    }
    for (Character ch : map.keySet()) {
      int frequency = map.get(ch);
      for (int j = 0; j < frequency; j++) {
        answer += ch;
      }
    }
    return answer;
  }

  private String customSortStringUsingString(String order, String s) {
    int orderSize = order.length();
    String answer = "";
    for (int i = 0; i < orderSize; i++) {
      char ch = order.charAt(i);
      String chStr = String.valueOf(ch);
      if (s.contains(String.valueOf(ch))) {
        int count = s.length() - s.replace(chStr, "").length();
        s = s.replaceAll(chStr, "");
        for (int j = 0; j < count; j++) {
          answer = answer + chStr;
        }
      }
    }
    answer += s;
    return answer;
  }

}