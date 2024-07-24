package com.leetcode.medium.sorting;

import com.leetcode.utils.ArrayUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    24/07/24,
 * Time:    4:57 pm
 * 2191. Sort the Jumbled Numbers
 * https://leetcode.com/problems/sort-the-jumbled-numbers/description/?envType=daily-question&envId=2024-07-24
 */
public class SortJumbled {
    public static void main(String[] args) {
        SortJumbled sortJumbled = new SortJumbled();
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        ArrayUtils.printArray(sortJumbled.sortJumbled(mapping, nums));
    }

    class Pair {
        int mappedNumber;
        int originalIndex;

        public Pair(int mappedNumber, int originalIndex) {
            this.mappedNumber = mappedNumber;
            this.originalIndex = originalIndex;
        }
    }

    private int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String numberString = Integer.toString(nums[i]);
            String mappedString = getMappedNumber(numberString, mapping);
            int mappedNumber = Integer.parseInt(mappedString);
            pairs.add(new Pair(mappedNumber, i));
        }
        Collections.sort(pairs, (a, b) -> a.mappedNumber - b.mappedNumber);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = pairs.get(i).originalIndex;
            result[i] = nums[originalIndex];
        }
        return result;
    }

    private String getMappedNumber(String numberString, int[] mapping) {
        StringBuilder mappedNumber = new StringBuilder();
        for (char ch : numberString.toCharArray()) {
            mappedNumber.append(mapping[ch - '0']);
        }
        return mappedNumber.toString();
    }
}