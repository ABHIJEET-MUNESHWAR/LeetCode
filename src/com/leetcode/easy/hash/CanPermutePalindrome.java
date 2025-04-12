package com.leetcode.easy.hash;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   12-04-2025
    Time:   08:38 pm
    https://leetcode.com/problems/palindrome-permutation/description/
    266. Palindrome Permutation
*/

import java.util.HashMap;
import java.util.Map;

public class CanPermutePalindrome {
    public static void main(String[] args) {
        CanPermutePalindrome canPermutePalindrome = new CanPermutePalindrome();
        String s = "aabb";
        System.out.println(canPermutePalindrome.canPermutePalindrome(s));
    }

    private boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int oddCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
