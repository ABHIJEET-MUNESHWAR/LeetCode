package com.leetcode.medium.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    30/07/24,
 * Time:    5:59 pm
 * 1653. Minimum Deletions to Make String Balanced
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/?envType=daily-question&envId=2024-07-30
 */
public class MinimumDeletions {
    public static void main(String[] args) {
        MinimumDeletions minimumDeletions = new MinimumDeletions();
        String s = "aababbab";
        System.out.println(minimumDeletions.minimumDeletionsStack(s));
        System.out.println(minimumDeletions.minimumDeletionsTwoArray(s));
        System.out.println(minimumDeletions.minimumDeletionsOneArray(s));
        System.out.println(minimumDeletions.minimumDeletionsOptimised(s));
    }

    private int minimumDeletionsOptimised(String s) {
        int n = s.length();
        int leftBCount = 0;
        int rightACount = 0;
        int result = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'a') {
                rightACount++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightACount--;
            }
            result = Math.min(result, leftBCount + rightACount);
            if (s.charAt(i) == 'b') {
                leftBCount++;
            }
        }
        return result;
    }

    private int minimumDeletionsOneArray(String s) {
        int n = s.length();
        int[] rightA = new int[n];
        int leftBCount = 0;
        int rightACount = 0;
        int result = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            rightA[i] = rightACount;
            if (c == 'a') {
                rightACount++;
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.min(result, leftBCount + rightA[i]);
            if (s.charAt(i) == 'b') {
                leftBCount++;
            }
        }
        return result;
    }

    private int minimumDeletionsTwoArray(String s) {
        int n = s.length();
        int[] leftB = new int[n];
        int[] rightA = new int[n];
        int leftBCount = 0;
        int rightACount = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            leftB[i] = leftBCount;
            if (c == 'b') {
                leftBCount++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            rightA[i] = rightACount;
            if (c == 'a') {
                rightACount++;
            }
        }
        for (int i = 0; i < n; i++) {
            result = Math.min(result, leftB[i] + rightA[i]);
        }
        return result;
    }

    private int minimumDeletionsStack(String s) {
        Stack<Character> stack = new Stack<>();
        int deletedCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == 'b') {
                    deletedCount++;
                    stack.pop();
                }
            }
        }
        return deletedCount;
    }
}