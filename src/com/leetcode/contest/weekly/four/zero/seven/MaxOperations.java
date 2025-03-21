package com.leetcode.contest.weekly.four.zero.seven;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    2:29 pm
 * 3228. Maximum Number of Operations to Move Ones to the End
 * https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/
 */
public class MaxOperations {
    public static void main(String[] args) {
        MaxOperations maxOperations = new MaxOperations();
        String s = "1001101";
        System.out.println(maxOperations.maxOperations(s));
    }

    private int maxOperations(String s) {
        int n = s.length();
        int result = 0;
        int once = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                result += once;
                while (i < n && s.charAt(i) != '1') {
                    i++;
                }
            }
            once++;
        }
        return result;
    }
}