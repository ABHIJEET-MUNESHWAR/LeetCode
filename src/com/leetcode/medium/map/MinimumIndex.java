package com.leetcode.medium.map;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   27-03-2025
    Time:   12:26 pm
    2780. Minimum Index of a Valid Split
    https://leetcode.com/problems/minimum-index-of-a-valid-split/description/?envType=daily-question&envId=2025-03-27
*/

import java.util.Arrays;
import java.util.List;

public class MinimumIndex {
    public static void main(String[] args) {
        MinimumIndex minimumIndex = new MinimumIndex();
        List<Integer> nums = Arrays.asList(1, 2, 2, 2);
        System.out.println(minimumIndex.minimumIndex(nums));
    }

    public int findMajorityElement(List<Integer> nums) {
        int counter = 0;
        int majorityElement = -1;
        for (Integer num : nums) {
            if (counter == 0) {
                majorityElement = num;
                counter = 1;
            } else if (majorityElement == num) {
                counter++;
            } else {
                counter--;
            }
        }
        return majorityElement;
    }

    public int minimumIndex(List<Integer> nums) {

        // Step 1: Find majority element using Boyer-Moore Voting Algorithm
        int majorityElement = findMajorityElement(nums);

        // Step 2: Count how many times majority element occurs
        int majorityElementCount = 0;
        for (Integer num : nums) {
            if (num == majorityElement) {
                majorityElementCount++;
            }
        }

        int n = nums.size();

        // Step 3: Try splitting at every index to check conditions
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            if (num == majorityElement) {
                count++;
            }
            int remainingCount = majorityElementCount - count;
            int n1 = i + 1;
            int n2 = n - i - 1;
            if (count > (n1 / 2) && remainingCount > (n2 / 2)) {
                return i;
            }
        }
        return -1;
    }
}
