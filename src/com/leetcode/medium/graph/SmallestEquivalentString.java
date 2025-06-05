package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    07/06/24,
 * Time:    10:17 pm
 * 🟠 1061. Lexicographically Smallest Equivalent String
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
 */
public class SmallestEquivalentString {
    public static void main(String[] args) {
        SmallestEquivalentString smallestEquivalentString = new SmallestEquivalentString();
        String                   s1                       = "parker", s2 = "morris", baseStr = "parser";
        System.out.println(smallestEquivalentString.smallestEquivalentStringUnionFind(s1, s2, baseStr));
        System.out.println(smallestEquivalentString.smallestEquivalentStringDfs(s1, s2, baseStr));
    }

    private String smallestEquivalentStringDfs(String s1, String s2, String baseStr) {
        int                             n          = s1.length();
        Map<Character, List<Character>> adjListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            adjListMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjListMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            boolean[] visited = new boolean[26];
            result.append(dfsToFindMin(adjListMap, ch, visited));
        }
        return result.toString();
    }

    public char dfsToFindMin(Map<Character, List<Character>> adjListMap, char current, boolean[] visited) {
        visited[current - 'a'] = true;
        char            minChar    = current;
        List<Character> neighbours = adjListMap.getOrDefault(current, new ArrayList<>());
        for (char neighbour : neighbours) {
            if (!visited[neighbour - 'a']) {
                char nextChar = dfsToFindMin(adjListMap, neighbour, visited);
                if (minChar > nextChar) {
                    minChar = nextChar;
                }
            }
        }
        return minChar;
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

    private String smallestEquivalentStringUnionFind(String s1, String s2, String baseStr) {
        int   size   = s1.length();
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < size; i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a', parent);
        }
        String result         = "";
        int    baseStringSize = baseStr.length();
        for (int i = 0; i < baseStringSize; i++) {
            int  parentIntegerValue = find(baseStr.charAt(i) - 'a', parent);
            char a                  = 'a';
            a += parentIntegerValue;
            result += String.valueOf(a);
        }
        return result;
    }
}