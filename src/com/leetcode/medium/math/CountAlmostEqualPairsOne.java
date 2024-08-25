package com.leetcode.medium.math;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/08/24,
 * Time:    6:54 pm
 */
public class CountAlmostEqualPairsOne {
    public static void main(String[] args) {
        CountAlmostEqualPairsOne countAlmostEqualPairsOne = new CountAlmostEqualPairsOne();
        int[] nums = {3, 12, 30, 17, 21};
        System.out.println(countAlmostEqualPairsOne.countPairs(nums));
    }

    private int countPairs(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isEqual(nums[i], nums[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isEqual(int x, int y) {
        int[] a1 = buildArray(x);
        int[] a2 = buildArray(y);
        int a = -1;
        int b = -1;
        int c = 0;
        for (int k = 0; k < 7; k++) {
            if (a1[k] != a2[k]) {
                b = a;
                a = k;
                c++;
            }
        }
        if (c == 0) {
            return true;
        }
        if (c == 1) {
            return false;
        }
        if (c > 2) {
            return false;
        }
        if (a1[a] == a2[b] && a1[b] == a2[a]) {
            return true;
        }
        return false;
    }

    private int[] buildArray(int num) {
        int[] count = new int[7];
        int i = 0;
        while (num > 0) {
            count[i] = num % 10;
            num = num / 10;
            i++;
        }
        return count;
    }
}