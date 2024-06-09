package com.leetcode.medium.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/24,
 * Time:    10:17 pm
 * 1061. Lexicographically Smallest Equivalent String
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
 */
public class SmallestEquivalentString {
  public static void main(String[] args) {
    SmallestEquivalentString smallestEquivalentString = new SmallestEquivalentString();
    String s1 = "parker", s2 = "morris", baseStr = "parser";
    System.out.println(smallestEquivalentString.smallestEquivalentString(s1, s2, baseStr));
  }

  public int find(int i, int[] parent) {
    if (parent[i] == i) {
      return i;
    }
    return parent[i] = find(parent[i], parent);
  }

  public void union(int i, int j, int[] parent) {
    int parentOfI = find(i, parent);
    int parentOfJ = find(j, parent);
    if (parentOfI < parentOfJ) {
      parent[parentOfJ] = parentOfI;
    } else {
      parent[parentOfI] = parentOfJ;
    }
  }

  private String smallestEquivalentString(String s1, String s2, String baseStr) {
    int size = s1.length();
    int[] parent = new int[26];
    for (int i = 0; i < 26; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < size; i++) {
      union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', parent);
    }
    String result = "";
    int baseStringSize = baseStr.length();
    for (int i = 0; i < baseStringSize; i++) {
      int parentIntegerValue = find(baseStr.charAt(i) - 'a', parent);
      char a = 'a';
      a += parentIntegerValue;
      result += String.valueOf(a);
    }
    return result;
  }
}