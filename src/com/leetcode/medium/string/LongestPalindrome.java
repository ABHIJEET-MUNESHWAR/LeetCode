package com.leetcode.medium.string;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/04/24,
 * Time:    9:05 am
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindrome {
    int low, maxLength;

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "babad";
        System.out.println(longestPalindrome.longestPalindrome(s));
        System.out.println(longestPalindrome.longestPalindromeBottomUp(s));
        System.out.println(longestPalindrome.longestPalindromeRecursionMemo(s));
    }

    private String longestPalindromeBottomUp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || l == 2)) {
                    dp[i][j] = true;
                    if (maxLength < l) {
                        maxLength = l;
                        startIndex = i;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    int[][] dp = new int[1001][1001];

    private String longestPalindromeRecursionMemo(String s) {
        int size = s.length();
        int maxLength = 0;
        int startingIndex = 0;
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (isPalindrome(s, i, j)) {
                    if (maxLength < (j - i + 1)) {
                        maxLength = j - i + 1;
                        startingIndex = i;
                    }
                }
            }
        }
        return s.substring(startingIndex, startingIndex + maxLength);
    }

    private boolean isPalindrome(String s, int l, int r) {
        if (l >= r) {
            return true;
        }
        if (dp[l][r] != -1) {
            return dp[l][r] == 1;
        }
        if (s.charAt(l) == s.charAt(r)) {
            dp[l][r] = isPalindrome(s, l + 1, r - 1) ? 1 : 0;
        } else {
            dp[l][r] = 0;
        }
        return dp[l][r] == 1;
    }

    private String longestPalindrome(String s) {
        int size = s.length();
        if (size < 2) {
            return s;
        }
        for (int i = 0; i < size; i++) {
            expandPalindrome(s, i, i);
            expandPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + maxLength);
    }

    private void expandPalindrome(String s, int left, int right) {
        int size = s.length();
        while (left >= 0 && right < size && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLength < (right - left - 1)) {
            low = left + 1;
            maxLength = right - left - 1;
        }
    }
}