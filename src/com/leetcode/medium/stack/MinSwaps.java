package com.leetcode.medium.stack;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/07/24,
 * Time:    11:41 am
 * 1963. Minimum Number of Swaps to Make the String Balanced
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 */
public class MinSwaps {
    public static void main(String[] args) {
        MinSwaps minSwaps = new MinSwaps();
        String s = "][][";
        System.out.println(minSwaps.minSwaps(s));
    }

    private int minSwaps(String s) {
        int n = s.length();
        int extraClose = 0;
        int maxExtraClose = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ']') {
                extraClose++;
            } else {
                extraClose--;
            }
            maxExtraClose = Math.max(maxExtraClose, extraClose);
        }
        int result = (maxExtraClose + 1) / 2;
        return result;
    }
}