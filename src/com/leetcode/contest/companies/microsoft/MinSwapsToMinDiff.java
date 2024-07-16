package com.leetcode.contest.companies.microsoft;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    16/07/24,
 * Time:    7:34 am
 */
public class MinSwapsToMinDiff {
    public static void main(String[] args) {
        MinSwapsToMinDiff minSwapsToMinDiff = new MinSwapsToMinDiff();
        String s = "29162";
        String t = "10524";
        // answer : 2 swaps with numbers as 20122 & 19564
        System.out.println(minSwapsToMinDiff.minSwapsToMinDiff(s, t));
    }

    private int minSwapsToMinDiff(String s, String t) {
        if (s.equals(t)) {
            return 0;
        }
        int n = s.length();
        int minSwaps = n;
        int minDiff = Integer.MAX_VALUE;
        int[][] pairs = new int[n][]; // 0: diff, 1: index
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - '0';
            int b = t.charAt(i) - '0';
            int diff = Math.abs(a - b);
            pairs[i] = new int[] {diff, i};
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int i = 1;
        while (i < n) {
            int j = 0;
            int totalSwaps = 0;
            while (j < i) {
                int swappingIndex = pairs[j][1];
                if (Character.valueOf(a[swappingIndex]) > Character.valueOf(b[swappingIndex])) {
                    char temp = a[swappingIndex];
                    a[swappingIndex] = b[swappingIndex];
                    b[swappingIndex] = temp;
                    totalSwaps++;
                }
                j++;
            }
            int diff = Math.abs(Integer.parseInt(subtract(new String(a), new String(b))));
            if (minDiff > diff) {
                minDiff = diff;
                minSwaps = totalSwaps;
            }
            a = s.toCharArray();
            b = t.toCharArray();
            i++;
        }
        return minSwaps;
    }

    private String subtract(String num1, String num2) {
        // Ensure num1 is greater than or equal to num2
        if (num1.length() < num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) < 0)) {
            return "-" + subtract(num2, num1);
        }
        StringBuilder result = new StringBuilder();
        int borrow = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int diff = digit1 - digit2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
            i--;
            j--;
        }
        // Remove leading zeros
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.reverse().toString();
    }
}