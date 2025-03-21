package com.leetcode.companies.groupon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/07/24,
 * Time:    7:38 pm
 */
public class SmartSale {
    public static void main(String[] args) {
        SmartSale smartSale = new SmartSale();
        List<Integer> ids = new ArrayList<>();
        int m = 6;
        System.out.println(smartSale.smartSale(ids, m));
    }

    private int smartSale(List<Integer> ids, int m) {
        Map<Integer, Integer> numToFrequencyMap = new HashMap<>();
        for (int num : ids) {
            numToFrequencyMap.put(num, numToFrequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(numToFrequencyMap.values());
        int removedElements = 0;
        while (!minHeap.isEmpty()) {
            removedElements += minHeap.peek();
            if (removedElements > m) {
                return minHeap.size();
            }
            minHeap.poll();
        }
        return 0; // All were removed
    }
}