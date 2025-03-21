package com.leetcode.medium.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    17/07/24,
 * Time:    8:17 am
 * 1481. Least Number of Unique Integers after K Removals
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
 */
public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        FindLeastNumOfUniqueInts findLeastNumOfUniqueInts = new FindLeastNumOfUniqueInts();
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        System.out.println(findLeastNumOfUniqueInts.findLeastNumOfUniqueInts(arr, k));
        System.out.println(findLeastNumOfUniqueInts.findLeastNumOfUniqueIntsUsingPriorityQueue(arr, k));
    }

    private int findLeastNumOfUniqueIntsUsingPriorityQueue(int[] arr, int k) {
        Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
        for (int num : arr) {
            numToFrequencyMap.put(num, numToFrequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(numToFrequencyMap.values());
        int removedElements = 0;
        while (!minHeap.isEmpty()) {
            removedElements += minHeap.peek();
            if (removedElements > k) {
                return minHeap.size();
            }
            minHeap.poll();
        }
        return 0; // All were removed
    }

    private int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
        for (int num : arr) {
            numToFrequencyMap.put(num, numToFrequencyMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> frequencyList = new ArrayList<>();
        frequencyList.addAll(numToFrequencyMap.values());
        Collections.sort(frequencyList);
        int size = frequencyList.size();
        for (int i = 0; i < size; i++) {
            k -= frequencyList.get(i);
            if (k < 0) {
                return size - i;
            }
        }
        return 0; // All were removed
    }
}