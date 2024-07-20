package com.leetcode.contest.biweekly.onethreefive;

import java.util.HashMap;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    20/07/24,
 * Time:    8:37 pm
 * 100365. Minimum Array Changes to Make Differences Equal
 * 3224. Minimum Array Changes to Make Differences Equal
 */
public class MinChanges {
    public static void main(String[] args) {
        MinChanges minChanges = new MinChanges();
        int[] nums = {1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0};
        int k = 1;//4
        /*int[] nums = {1, 0, 1, 2, 4, 3};
        int k = 4;//2*/
        /*int[] nums = {0, 1, 2, 3, 3, 6, 5, 4};
        int k = 6;//2*/
        System.out.println(minChanges.minChanges(nums, k));
    }

    private int minChanges(int[] nums, int k) {
        Map<Integer, Integer> s = new HashMap<>();
        int n = nums.length;
        int[] f = new int[k + 1];
        for (int i = 0; i < n / 2; i++) {
            int diff = Math.abs(nums[i] - nums[n - 1 - i]);
            s.put(diff, s.getOrDefault(diff, 0) + 1);
            int min = Math.min(nums[i], nums[n - i - 1]);
            int max = Math.max(nums[i], nums[n - i - 1]);
            f[Math.max(k - min, max)]++;
        }
        for (int i = k - 1; i >= 0; i--) {
            f[i] += f[i + 1];
        }
        int ans = n;

        for (int x : s.keySet()) {
            int one = f[x] - s.get(x);
            int two = n / 2 - f[x];
            ans = Math.min(ans, one + two * 2);
        }
        return ans;
    }
}