class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int totalDays = days.length;
        int lastDay = days[totalDays - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isTravelDayMap = new boolean[lastDay + 1];
        for (int day : days) {
            isTravelDayMap[day] = true;
        }
        dp[0] = 0;
        for (int i = 1; i <= lastDay; i++) {
            if (!isTravelDayMap[i]) { // no need to buy ticket if it is not a travel day
                dp[i] = dp[i - 1];
                continue;
            }
            int costOfOneDayPass = costs[0] + dp[Math.max(i - 1, 0)];
            int costOfSevenDayPass = costs[1] + dp[Math.max(i - 7, 0)];
            int costOfThirtyDayPass = costs[2] + dp[Math.max(i - 30, 0)];
            dp[i] = Math.min(costOfOneDayPass, Math.min(costOfSevenDayPass, costOfThirtyDayPass));
        }
        return dp[lastDay];
    }
}