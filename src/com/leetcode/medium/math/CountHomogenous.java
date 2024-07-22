package com.leetcode.medium.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    22/07/24,
 * Time:    8:26 pm
 * 1759. Count Number of Homogenous Substrings
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/description/
 */
public class CountHomogenous {
    public static void main(String[] args) {
        CountHomogenous countHomogenous = new CountHomogenous();
        String s = "abbcccaa";
        System.out.println(countHomogenous.countHomogenous(s));
    }

    private int countHomogenous(String s) {
        int mod = 1000000007;
        int n = s.length();
        int result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((i > 0) && (s.charAt(i) == s.charAt(i - 1))) {
                count++;
            } else {
                count = 1;
            }
            result = (result + count) % mod;
        }
        return result % mod;
    }
}