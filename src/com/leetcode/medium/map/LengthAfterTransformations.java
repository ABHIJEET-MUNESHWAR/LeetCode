package com.leetcode.medium.map;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   14-05-2025
    Time:   10:13 am
    🟠 3335. Total Characters in String After Transformations I
    https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/?envType=daily-question&envId=2025-05-13
*/

public class LengthAfterTransformations {
    public static void main(String[] args) {
        LengthAfterTransformations lengthAfterTransformations = new LengthAfterTransformations();
        String                     s                          = "abcyy";
        int                        t                          = 2;
        System.out.println(lengthAfterTransformations.lengthAfterTransformations(s, t));
    }

    public int lengthAfterTransformations(String s, int t) {
        int   mod = 1_000_000_007;
        int[] map = new int[26];
        int   n   = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map[ch - 'a']++;
        }
        for (int c = 0; c < t; c++) {
            int[] temp = new int[26];
            for (int i = 0; i < 26; i++) {
                char ch   = (char) (i + 'a');
                int  freq = map[i];
                if (ch != 'z') {
                    temp[(ch + 1) - 'a'] = (temp[(ch + 1) - 'a'] + freq) % mod;
                } else {
                    temp['a' - 'a'] = (temp['a' - 'a'] + freq) % mod;
                    temp['b' - 'a'] = (temp['b' - 'a'] + freq) % mod;
                }
            }
            map = temp;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + map[i]) % mod;
        }
        return result;
    }
}
