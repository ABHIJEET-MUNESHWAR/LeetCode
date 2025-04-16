package com.leetcode.easy.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   16-04-2025
    Time:   10:54 am
    🟠 2537. Count the Number of Good Subarrays
    https://leetcode.com/problems/count-the-number-of-good-subarrays/description/?envType=daily-question&envId=2025-04-16
*/

import java.util.HashMap;
import java.util.Map;

public class CountGood {
    public static void main(String[] args) {
        CountGood countGood = new CountGood();
        int[] nums = {3,1,4,3,2,2,4};
        int k = 2;
        System.out.println(countGood.countGood(nums, k));
    }

    public long countGood(int[] nums, int k) {
        long pairs = 0;
        long result = 0;
        int n = nums.length;
        int left = 0, right = 0;
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        while (right < n) {
            pairs += numToFreqMap.getOrDefault(nums[right], 0);
            numToFreqMap.put(nums[right], numToFreqMap.getOrDefault(nums[right], 0) + 1);
            while (pairs >= k) {
                result += (n - right);
                numToFreqMap.put(nums[left], numToFreqMap.get(nums[left]) - 1);
                pairs -= numToFreqMap.get(nums[left]);
                left++;
            }
            right++;
        }
        return result;
    }
}
