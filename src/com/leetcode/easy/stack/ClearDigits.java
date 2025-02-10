package com.leetcode.easy.stack;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   10-02-2025
    Time:   09:33 pm
    3174. Clear Digits
    https://leetcode.com/problems/clear-digits/description/?envType=daily-question&envId=2025-02-10
*/

import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        ClearDigits clearDigits = new ClearDigits();
        String s = "abc";
        System.out.println(clearDigits.clearDigits(s));
    }

    private String clearDigits(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
