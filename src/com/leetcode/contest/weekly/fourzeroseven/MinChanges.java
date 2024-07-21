package com.leetcode.contest.weekly.fourzeroseven;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    21/07/24,
 * Time:    8:06 am
 * 100372. Number of Bit Changes to Make Two Integers Equal
 * https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/
 */
public class MinChanges {
    public static void main(String[] args) {
        MinChanges minChanges = new MinChanges();
        //int n = 13, k = 4;     // 2
        //int n = 21, k = 21; // 0
        //int n = 14, k = 13; // -1
        //int n = 44, k = 2; // -1
        int n = 54, k = 4;     // 3
        System.out.println(minChanges.minChanges(n, k));
    }

    private int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        }
        String a = Integer.toBinaryString(n);
        String b = Integer.toBinaryString(k);
        int result = 0;
        int diff = Math.abs(a.length() - b.length());
        if (a.length() > b.length()) {
            while (diff-- > 0) {
                b = "0" + b;
            }
        } else {
            while (diff-- > 0) {
                a = "0" + a;
            }
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            char x = a.charAt(i);
            char y = b.charAt(j);
            if (x == '0' && y == '1') {
                return -1;
            }
            if (x != y) {
                result++;
            }
            i--;
            j--;
        }
        return result;
    }
}