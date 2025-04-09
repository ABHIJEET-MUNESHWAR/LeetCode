package com.leetcode.companies.meta.practice.stack;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   09-04-2025
    Time:   06:37 pm
    227. Basic Calculator II
    https://leetcode.com/problems/basic-calculator-ii/description/
*/

import java.util.Stack;

public class CalculatorTwo {
    public static void main(String[] args) {
        CalculatorTwo calculatorTwo = new CalculatorTwo();
        String s = "3+2*2";
        System.out.println(calculatorTwo.calculate(s));
    }

    private int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int number = 0;
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            if (isOperator(ch) || i == n - 1) {
                switch (operator) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }
                number = 0;
                operator = ch;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';
    }
}
