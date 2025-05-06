package com.leetcode.companies.meta.rounds.two;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   04-05-2025
    Time:   06:09 pm
*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent.topKFrequent(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreqMap = new HashMap<>();
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        for (int num : nums) {
            numToFreqMap.put(num, numToFreqMap.getOrDefault(num, 0) + 1);
        }
        // PQ elements: {frequency, number}
        // Initalize PQ by frequency in descending order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : numToFreqMap.entrySet()) {
            int number = entry.getKey();
            int freq = entry.getValue();
            pq.offer(new int[]{freq, number});
        }
        int pointer = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            result[pointer++] = current[1];
        }
        return result;
    }
}
