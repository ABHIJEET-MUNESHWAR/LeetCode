package com.leetcode.medium.search;


/*
    Created using IntelliJ IDEA
    Author: Abhijeet Ashok Muneshwar
    Date:   16-03-2025
    Time:   02:13 pm
    2594. Minimum Time to Repair Cars
    https://leetcode.com/problems/minimum-time-to-repair-cars/description/?envType=daily-question&envId=2025-03-16
*/

public class RepairCars {
    public static void main(String[] args) {
        int[] ranks = {4, 2, 3, 1};
        int cars = 10;
        RepairCars repairCars = new RepairCars();
        System.out.println(repairCars.repairCars(ranks, cars));
    }

    public boolean isPossibleToRepair(int[] ranks, int cars, long mid) {
        long repairdCars = 0L;
        int n = ranks.length;
        for (int rank : ranks) {
            repairdCars += Math.sqrt(mid / rank);
        }
        return repairdCars >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        int maxRank = Integer.MIN_VALUE;
        for (int rank : ranks) {
            maxRank = Math.max(rank, maxRank);
        }
        long start = 1, end = 1L * maxRank * cars * cars, result = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (isPossibleToRepair(ranks, cars, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
