package com.leetcode.companies.meta.practice.stack;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-04-2025
    Time:   07:53 pm
    1249. Minimum Remove to Make Valid Parentheses
    https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
*/

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        MinRemoveToMakeValid minRemoveToMakeValid = new MinRemoveToMakeValid();
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid.minRemoveToMakeValid(s));
    }

    private String minRemoveToMakeValid(String s) {
        int n = s.length();
        int open = 0;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else if (ch == ')') {
                if (open == 0) {
                    continue;
                }
                open--;
            }
            temp.append(ch);
        }
        StringBuilder result = new StringBuilder();
        for (int i = temp.length() - 1; i >= 0; i--) {
            char ch = temp.charAt(i);
            if (ch == '(' && open-- > 0) {
                continue;
            }
            result.insert(0, ch);
        }
        return result.toString();
    }
}
