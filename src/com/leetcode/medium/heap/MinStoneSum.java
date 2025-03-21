package com.leetcode.medium.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    25/07/24,
 * Time:    9:51 pm
 * 1962. Remove Stones to Minimize the Total
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/
 */
public class MinStoneSum {
    public static void main(String[] args) {
        MinStoneSum minStoneSum = new MinStoneSum();
        int[] piles = {5, 4, 9};
        int k = 2;
        System.out.println(minStoneSum.minStoneSum(piles, k));
    }

    private int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (Integer pile : piles) {
            minHeap.add(pile);
            sum += pile;
        }
        while (k-- > 0) {
            int pile = minHeap.poll();
            int remove = pile / 2;
            sum -= remove;
            int remaining = pile - remove;
            minHeap.add(remaining);
        }
        return sum;
    }
}