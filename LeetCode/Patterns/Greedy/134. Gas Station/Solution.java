class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }
        totalGas = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i] - cost[i];
            if (totalGas < 0) {
                startIndex = i + 1;
                totalGas = 0;
            }
        }
        return startIndex;
    }
}