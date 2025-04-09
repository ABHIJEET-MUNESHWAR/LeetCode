package com.leetcode.companies.meta.practice.stack;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-04-2025
    Time:   06:13 pm
    224. Basic Calculator
    https://leetcode.com/problems/basic-calculator/description/
*/

import java.util.Stack;

public class Calculate {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate.calculate(s));
    }

    private int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0, number = 0, sign = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                // We push the result first and then sign
                stack.push(result);
                stack.push(sign);
                // Reset the result and sign for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // this is the sign before the parenthesis
                result += stack.pop(); // this is the result calculated before the parenthesis
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}
