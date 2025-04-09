package com.leetcode.companies.meta.practice.stack;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-04-2025
    Time:   06:59 pm
    1047. Remove All Adjacent Duplicates In String
    https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
*/

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        String s = "abbaca";
        System.out.println(removeDuplicates.removeDuplicates(s));
    }

    private String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }

        }
        s = "";
        while (!stack.isEmpty()) {
            s = stack.pop() + s;
        }
        return s;
    }
}
