package com.leetcode.easy.sorting;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    23/07/24,
 * Time:    6:59 am
 * 1636. Sort Array by Increasing Frequency
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/description/?envType=daily-question&envId=2024-07-23
 */
public class FrequencySort {
    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        int[] nums = {2, 3, 1, 3, 2};
        ArrayUtils.printArray(frequencySort.frequencySort(nums));
    }

    private int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> noToFreqMap = new HashMap<>();
        for (int num : nums) {
            noToFreqMap.put(num, noToFreqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(noToFreqMap.keySet());
        Collections.sort(keys, (a, b) -> {
            return (noToFreqMap.get(a) == noToFreqMap.get(b)) ? b - a : noToFreqMap.get(a) - noToFreqMap.get(b);
        });
        int[] result = new int[n];
        int i = 0;
        for (int num : keys) {
            for (int j = 0; j < noToFreqMap.get(num); j++) {
                result[i++] = num;
            }
        }
        return result;
    }
}