package com.leetcode.medium.greedy;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   26-06-2025
    Time:   09:16 pm
    🟠 2311. Longest Binary Subsequence Less Than or Equal to K
    https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/description/?envType=daily-question&envId=2025-06-26
*/

public class LongestSubsequence {
    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        String             s                  = "1001010";
        int                k                  = 5;
        System.out.println("Length of longest subsequence: " + longestSubsequence.longestSubsequence(s, k));
    }

    public int longestSubsequence(String s, int k) {
        int  n          = s.length();
        int  maxLength  = 0;
        long powerValue = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                maxLength++;
            } else if (powerValue <= k) {
                maxLength++;
                k -= powerValue;
            }
            if (powerValue <= k) {
                powerValue <<= 1;// powerValue *= 2
            }
        }
        return maxLength;
    }
}
