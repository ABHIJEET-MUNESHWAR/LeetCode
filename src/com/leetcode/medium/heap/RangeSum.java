package com.leetcode.medium.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    04/08/24,
 * Time:    7:45 pm
 * 1508. Range Sum of Sorted Subarray Sums
 */
public class RangeSum {
    public static void main(String[] args) {
        RangeSum rangeSum = new RangeSum();
        int[] nums = {1, 2, 3, 4};
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum.rangeSumBruteForce(nums, n, left, right));
        System.out.println(rangeSum.rangeSumPriorityQueue(nums, n, left, right));
    }

    int mod = 1000000007;

    //Approach-1 (Brute Force)
    //T.C : O(n^2 * logN) - we have total n^2 elements in temp
    //S.C : O(n)
    private int rangeSumBruteForce(int[] nums, int n, int left, int right) {
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                tempList.add(sum);
            }
        }
        Collections.sort(tempList);
        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + tempList.get(i)) % mod;
        }
        return result;
    }

    //Approach-2 (How to find sorted subarray sums using Heap)
    //T.C : O(n^2 *n logN)
    //S.C : O(n)
    private int rangeSumPriorityQueue(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            queue.add(new int[] {nums[i], i});
        }
        int result = 0;
        for (int i = 1; i <= right; i++) {
            int[] current = queue.poll();
            // If the current index is within the desired range, add the value to the result
            if (i >= left) {
                result = (result + current[0]) % mod;
            }
            // If index is less than the last index, increment it and add the new subarray sum to the queue
            if (current[1] < n - 1) {
                int nextIndex = current[1] + 1;
                queue.add(new int[] {current[0] + nums[nextIndex], nextIndex});
            }
        }
        return result;
    }
}