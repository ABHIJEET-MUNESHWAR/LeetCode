class Solution {
    int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length + 1];
        Arrays.fill(dp, -1);
        return solveRecursionMemoization(days, costs, 0);
    }

    private int solveRecursionMemoization(int[] days, int[] costs, int index) {
        if (index >= days.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int costOfOneDayPass = costs[0] + solveRecursionMemoization(days, costs, index + 1);
        int costOfSevenDayPass = costs[1]
                + solveRecursionMemoization(days, costs, getIndexOfNextDay(days, index, days[index] + 7));
        int costOfThirtyDayPass = costs[2]
                + solveRecursionMemoization(days, costs, getIndexOfNextDay(days, index, days[index] + 30));
        return dp[index] = Math.min(costOfOneDayPass, Math.min(costOfSevenDayPass, costOfThirtyDayPass));
    }

    private int getIndexOfNextDay(int[] days, int index, int totalDaysCanBeCovered) {
        while (index < days.length && days[index] < totalDaysCanBeCovered) {
            index++;
        }
        return index;
    }
}