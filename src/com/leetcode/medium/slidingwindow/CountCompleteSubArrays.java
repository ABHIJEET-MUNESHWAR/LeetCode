package com.leetcode.medium.slidingwindow;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   24-04-2025
    Time:   10:35 am
    🟠 2799. Count Complete SubArrays in an Array
    https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/?envType=daily-question&envId=2025-04-24
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubArrays {
    public static void main(String[] args) {
        CountCompleteSubArrays countCompleteSubArrays = new CountCompleteSubArrays();
        int nums[] = {1, 3, 1, 2, 2};
        System.out.println(countCompleteSubArrays.countCompleteSubArrays(nums));
    }

    public int countCompleteSubArrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int num : nums) {
            set.add(num);
        }
        int totalUniqueElements = set.size();
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        int result = 0;
        int left = 0, right = 0;
        while (right < n) {
            numToFreqMap.put(nums[right], numToFreqMap.getOrDefault(nums[right], 0) + 1);
            while (numToFreqMap.size() == totalUniqueElements) {
                result += n - right;
                numToFreqMap.put(nums[left], numToFreqMap.get(nums[left]) - 1);
                if (numToFreqMap.get(nums[left]) == 0) {
                    numToFreqMap.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
