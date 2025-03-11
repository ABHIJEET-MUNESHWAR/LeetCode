package com.leetcode.medium.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   11-03-2025
    Time:   10:29 am
    1358. Number of Substrings Containing All Three Characters
    https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2025-03-11
*/

public class NumberOfSubstrings {
    public static void main(String[] args) {
        NumberOfSubstrings numberOfSubstrings = new NumberOfSubstrings();
        String s = "aaaabc";
        System.out.println(numberOfSubstrings.numberOfSubstrings(s));
    }

    private int numberOfSubstrings(String s) {
        int n = s.length();
        int[] charToFreqMap = new int[3];
        int left = 0, right = 0, count = 0;
        while (right < n) {
            char ch = s.charAt(right);
            charToFreqMap[ch - 'a']++;
            while (charToFreqMap[0] > 0 && charToFreqMap[1] > 0 && charToFreqMap[2] > 0) {
                count += (n - right);
                charToFreqMap[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
}
