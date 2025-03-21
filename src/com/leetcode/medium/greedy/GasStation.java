package com.leetcode.medium.greedy;

/**
 * Created using IntelliJ IDEA.
 * Author:  abhijeet,
 * Date:    14/07/24,
 * Time:    7:26 am
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/description/
 */
public class GasStation {
    public static void main(String[] args) {
        GasStation station = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(station.canCompleteCircuit(gas, cost));
        System.out.println(station.canCompleteCircuitGreedy(gas, cost));
    }

    private int canCompleteCircuitGreedy(int[] gas, int[] cost) {
        int n = gas.length;
        int totalCost = 0;
        int totalGas = 0;
        for (int i = 0; i < n; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        int result = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                result = i + 1;
                total = 0;
            }
        }
        return result;
    }

    private int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int startIndex = i;
            int currentGas = gas[i];
            int totalVisitedStations = 1;
            while (currentGas >= cost[i]) {
                if (totalVisitedStations == n) {
                    return i;
                }
                startIndex++;
                startIndex = startIndex % n;
                currentGas += gas[startIndex];
                currentGas -= cost[startIndex];
                totalVisitedStations++;
            }
        }
        return -1;
    }
}