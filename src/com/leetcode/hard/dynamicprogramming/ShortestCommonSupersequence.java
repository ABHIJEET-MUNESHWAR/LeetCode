package com.leetcode.hard.dynamicprogramming;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   28-02-2025
    Time:   10:20 pm
    1092. Shortest Common Supersequence
    https://leetcode.com/problems/shortest-common-supersequence/description/?envType=daily-question&envId=2025-02-28
*/

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        ShortestCommonSupersequence shortestCommonSupersequence = new ShortestCommonSupersequence();
        String str1 = "abac";
        String str2 = "cab";
        System.out.println(shortestCommonSupersequence.shortestCommonSupersequence(str1, str2));
    }

    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = 1 + Math.min(t[i - 1][j], t[i][j - 1]);
            }
        }

        StringBuilder scsBuilder = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                scsBuilder.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] < t[i][j - 1]) {
                    scsBuilder.append(s1.charAt(i - 1));
                    i--;
                } else {
                    scsBuilder.append(s2.charAt(j - 1));
                    j--;
                }
            }
        }

        // add remaining characters from both s1 and s2
        while (i > 0) {
            scsBuilder.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scsBuilder.append(s2.charAt(j - 1));
            j--;
        }
        return scsBuilder.reverse().toString();
    }
}
