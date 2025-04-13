package com.leetcode.companies.meta.practice.heap;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   13-04-2025
    Time:   04:00 pm
    347. Top K Frequent Elements
    https://leetcode.com/problems/top-k-frequent-elements/description/
*/

import com.leetcode.utils.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        ArrayUtils.printArray(topKFrequent.topKFrequent(nums, k));
    }

    private int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        for (int num : nums) {
            numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(numToFreqMap.entrySet());
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            result[i] = entry.getKey();
        }
        return result;
    }
}
