package com.leetcode.medium.search;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    15/08/24,
 * Time:    7:29 pm
 * 719. Find K-th Smallest Pair Distance
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
 */
public class SmallestDistancePair {
    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        int[] nums = {1, 3, 1};
        int k = 1;
        System.out.println(smallestDistancePair.smallestDistancePair(nums, k));
        System.out.println(smallestDistancePair.smallestDistancePairBinarySearch(nums, k));
    }

    private int smallestDistancePairBinarySearch(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = nums[n - 1] - nums[0];
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int countPair = slidingWindowCount(nums, mid);
            if (countPair < k) {
                left = mid + 1;
            } else {
                // Store mid as possible result
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }

    private int slidingWindowCount(int[] nums, int distance) {
        int n = nums.length;
        int left = 0, right = 1;
        int pairCount = 0;
        while (right < n) {
            while ((nums[right] - nums[left]) > distance) {
                left++;
            }
            pairCount += (right - left);
            right++;
        }
        return pairCount;
    }

    private int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] temp = new int[max + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(nums[i] - nums[j]);
                temp[d]++;
            }
        }
        for (int distance = 0; distance < max; distance++) {
            k -= temp[distance];
            if (k <= 0) {
                return distance; // Returning kth smallest distance
            }
        }
        return -1;
    }
}