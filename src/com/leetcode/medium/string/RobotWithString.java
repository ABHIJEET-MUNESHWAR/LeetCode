package com.leetcode.medium.string;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   07-06-2025
    Time:   10:14 am
    🟠 2434. Using a Robot to Print the Lexicographically Smallest String
    https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/description/?envType=daily-question&envId=2025-06-06
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class RobotWithString {
    public static void main(String[] args) {
        RobotWithString robotWithString = new RobotWithString();
        String          s               = "bac";
        System.out.println(robotWithString.robotWithString(s));
    }

    public String robotWithString(String s) {

        int n = s.length();
        // Array to store the smallest character from index i to the end
        char[] minCharToRight = new char[n];
        minCharToRight[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minCharToRight[i] = (char) Math.min(s.charAt(i), minCharToRight[i + 1]);
        }

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder    paper = new StringBuilder();
        int              i     = 0;
        while (i < n) {
            stack.push(s.charAt(i));

            char minChar = (i + 1 < n) ? minCharToRight[i + 1] : s.charAt(i);

            while (!stack.isEmpty() && stack.peek() <= minChar) {
                paper.append(stack.pop());
            }
            i++;
        }

        // Empty the remaining characters from the stack
        while (!stack.isEmpty()) {
            paper.append(stack.pop());
        }

        return paper.toString();
    }
}