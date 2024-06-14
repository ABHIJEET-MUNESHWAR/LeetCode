package com.leetcode.hard.graph;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/06/24,
 * Time:    6:13 pm
 * 839. Similar String Groups
 * https://leetcode.com/problems/similar-string-groups/description/
 */
public class SimilarStringGroups {
  public static void main(String[] args) {
    SimilarStringGroups similarStringGroups = new SimilarStringGroups();
    String[] strs = {"tars", "rats", "arts", "star"};
    System.out.println(similarStringGroups.numSimilarGroups(strs));
  }

  private int numSimilarGroups(String[] strs) {
    int n = strs.length;
    int groups = n;
    int[] parent = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (isSimilar(strs[i], strs[j]) && find(i, parent) != find(j, parent)) {
          union(i, j, parent, rank);
          groups--;
        }
      }
    }
    return groups;
  }

  private boolean isSimilar(String s1, String s2) {
    int n = s1.length();
    int diff = 0;
    for (int i = 0; i < n; i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        diff++;
      }
    }
    return diff == 2 || diff == 0;
  }

  public int find(int i, int[] parent) {
    if (parent[i] == i) {
      return i;
    }
    return parent[i] = find(parent[i], parent);
  }

  public void union(int i, int j, int[] parent, int[] rank) {
    int parentOfI = find(i, parent);
    int parentOfJ = find(j, parent);
    if (parentOfI == parentOfJ) {
      return;
    }
    if (rank[parentOfI] > rank[parentOfJ]) {
      parent[parentOfJ] = parentOfI;
    } else if (rank[parentOfI] < rank[parentOfJ]) {
      parent[parentOfI] = parentOfJ;
    } else {
      parent[parentOfI] = parentOfJ;
      rank[parentOfJ]++;
    }
  }
}