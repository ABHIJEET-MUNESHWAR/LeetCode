class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
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
}