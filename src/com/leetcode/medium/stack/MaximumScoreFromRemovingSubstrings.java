package com.leetcode.medium.stack;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    12/07/24,
 * Time:    7:16 pm
 * 1717. Maximum Score From Removing Substrings
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/description/?envType=daily-question&envId=2024-07-12
 */
public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings maximumScoreFromRemovingSubstrings = new MaximumScoreFromRemovingSubstrings();
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
        System.out.println(maximumScoreFromRemovingSubstrings.maximumGainUsingStack(s, x, y));
        System.out.println(maximumScoreFromRemovingSubstrings.maximumGainWithoutUsingStack(s, x, y));
    }

    private int maximumGainWithoutUsingStack(String s, int x, int y) {
        int result = 0;
        String maxSubString = x > y ? "ab" : "ba";
        String minSubString = x < y ? "ab" : "ba";
        String firstFilteredString = removeSubStringWithoutStack(s, maxSubString);
        result += ((s.length() - firstFilteredString.length()) / 2) * (Math.max(x, y));
        String secondFilteredString = removeSubStringWithoutStack(firstFilteredString, minSubString);
        result += ((firstFilteredString.length() - secondFilteredString.length()) / 2) * (Math.min(x, y));
        return result;
    }

    private String removeSubStringWithoutStack(String s, String subString) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            j++;
            if (j > 1 && sb.charAt(j - 2) == subString.charAt(0) && sb.charAt(j - 1) == subString.charAt(1)) {
                sb.delete(j - 2, j);
                j -= 2;
            }
        }
        return sb.toString();
    }

    private int maximumGainUsingStack(String s, int x, int y) {
        int result = 0;
        String maxSubString = x > y ? "ab" : "ba";
        String minSubString = x < y ? "ab" : "ba";
        String firstFilteredString = removeSubString(s, maxSubString);
        result += ((s.length() - firstFilteredString.length()) / 2) * (Math.max(x, y));
        String secondFilteredString = removeSubString(firstFilteredString, minSubString);
        result += ((firstFilteredString.length() - secondFilteredString.length()) / 2) * (Math.min(x, y));
        return result;
    }

    private String removeSubString(String s, String subString) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && ch == subString.charAt(1) && stack.peek() == subString.charAt(0)) {
                stack.pop();
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