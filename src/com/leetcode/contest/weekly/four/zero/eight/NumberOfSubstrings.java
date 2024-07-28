package com.leetcode.contest.weekly.four.zero.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    28/07/24,
 * Time:    9:11 am
 * Q3. Count the Number of Substrings With Dominant Ones
 * https://leetcode.com/contest/weekly-contest-408/problems/count-the-number-of-substrings-with-dominant-ones/description/
 */
public class NumberOfSubstrings {
    public static void main(String[] args) {
        NumberOfSubstrings numberOfSubstrings = new NumberOfSubstrings();
        //String s = "00011";
        String s = "101101";
        System.out.println(numberOfSubstrings.numberOfSubstrings(s));
    }

    private int numberOfSubstrings(String s) {
        int dominantOnce = 0;
        int n = s.length();
        int[] prefixOnce = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                prefixOnce[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            prefixOnce[i] += prefixOnce[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int zeros = 0, once = 0;
            for (int j = i; j < n; j++) {
                once = prefixOnce[j];
                if (i != 0) {
                    once -= prefixOnce[i - 1];
                }
                zeros = j - i + 1 - once;
                // if condition is false
                if (zeros * zeros > once) {
                    j += (zeros * zeros) - once - 1;
                }
                // if condition is true
                if (zeros * zeros <= once) {
                    dominantOnce++;
                    // check for other substring starting from i
                    if (zeros * zeros < once) {
                        int diff = (int) Math.sqrt(once) - (zeros);
                        int nextJ = j + diff;
                        if (nextJ >= n) {
                            dominantOnce += (n - j - 1);
                        } else {
                            dominantOnce += diff;
                        }
                        j = nextJ;
                    }
                }
            }
        }
        return dominantOnce;
    }
}