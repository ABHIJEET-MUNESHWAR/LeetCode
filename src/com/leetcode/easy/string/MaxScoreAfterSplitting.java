package com.leetcode.easy.string;

/**
 * Created using IntelliJ IDEA. Author:  abhijeet, Date:    31/08/22, Time:    10:38 PM
 * 1422. Maximum Score After Splitting a String
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2025-01-01
 */
public class MaxScoreAfterSplitting {
    public static void main(String[] args) {
        MaxScoreAfterSplitting obj = new MaxScoreAfterSplitting();
        String s = "011101";
        //String s = "00";
        System.out.println(obj.maxScore(s));
        System.out.println(obj.maxScoreOnePass(s));
    }

    private int maxScoreOnePass(String s) {
        int n = s.length();
        int result = Integer.MIN_VALUE;
        int zeros = 0, ones = 0;
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeros++;
            } else {
                ones++;
            }
            result = Math.max(result, zeros - ones);
        }
        if (s.charAt(n - 1) == '1') {
            ones++;
        }
        return result + ones;
    }

    private int maxScore(String s) {
        int n = s.length();
        int result = Integer.MIN_VALUE;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                ones++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0') {
                zeros++;
            } else {
                ones--;
            }
            result = Math.max(result, zeros + ones);
        }
        return result;
    }
}
