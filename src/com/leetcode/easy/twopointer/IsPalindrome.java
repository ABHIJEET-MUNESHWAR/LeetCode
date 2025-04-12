package com.leetcode.easy.twopointer;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   12-04-2025
    Time:   08:07 pm
    125. Valid Palindrome
    https://leetcode.com/problems/valid-palindrome/description/
*/

public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome.isPalindrome(s));
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        boolean isPalindrome = true;
        s = s.toLowerCase();
        int l = 0, r = n - 1;
        while (l < r) {
            if (l < n && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return isPalindrome;
    }
}
