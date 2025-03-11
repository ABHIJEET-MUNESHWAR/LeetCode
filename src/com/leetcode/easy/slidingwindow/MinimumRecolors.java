package com.leetcode.easy.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   11-03-2025
    Time:   10:40 am
    2379. Minimum Recolors to Get K Consecutive Black Blocks
    https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/?envType=daily-question&envId=2025-03-08
*/

public class MinimumRecolors {
    public static void main(String[] args) {
        MinimumRecolors minimumRecolors = new MinimumRecolors();
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolors.minimumRecolors(blocks, k));
    }

    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int minLength = k;
        int left = 0, right = 0;
        int whites = 0;
        while (right < n) {
            char ch = blocks.charAt(right);
            if (ch == 'W') {
                whites++;
            }
            if ((right - left + 1) == k) {
                minLength = Math.min(minLength, whites);
                if (blocks.charAt(left) == 'W') {
                    whites--;
                }
                left++;
            }
            right++;
        }
        return minLength;
    }
}
