package com.leetcode.medium.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   11-03-2025
    Time:   10:37 am
    3208. Alternating Groups II
    https://leetcode.com/problems/alternating-groups-ii/description/?envType=daily-question&envId=2025-03-09
*/

public class NumberOfAlternatingGroups {
    public static void main(String[] args) {
        NumberOfAlternatingGroups numberOfAlternatingGroups = new NumberOfAlternatingGroups();
        int[] colors = {0, 1, 0, 1, 0};
        int k = 3;
        System.out.println(numberOfAlternatingGroups.numberOfAlternatingGroups(colors, k));
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int N = n + k - 1;
        int[] extended = new int[N];
        System.arraycopy(colors, 0, extended, 0, n);
        for (int i = 0; i < k - 1; i++) {
            extended[n + i] = colors[i]; // to handle wrap-around (circular array)
        }
        int result = 0;
        int left = 0, right = 1; // because we have to check index right-1 for checking alternate
        while (right < N) {
            if (extended[right] == extended[right - 1]) {
                left = right;
                right++;
                continue;
            }
            if (right - left + 1 == k) {
                result++;
                left++;
            }
            right++;
        }
        return result;
    }
}
