class Solution {
    public long gridGame(int[][] grid) {
        long n = grid[0].length;
        long firstRowRemainingSum = 0;
        for (int num : grid[0]) {
            firstRowRemainingSum += num;  // O(col)
        }
        long secondRowRemainingSum = 0;
        long minimisedRobot2Sum = Long.MAX_VALUE;
        for (int robot1Col = 0; robot1Col < n; robot1Col++) {
            // Robot1 took this strategy
            firstRowRemainingSum -= grid[0][robot1Col];
            // Robot2 will try to do best after Robot1 has taken the above strategy
            long bestOfRobot2 = Math.max(firstRowRemainingSum, secondRowRemainingSum);
            minimisedRobot2Sum = Math.min(minimisedRobot2Sum, bestOfRobot2);
            secondRowRemainingSum += grid[1][robot1Col];
        }
        return minimisedRobot2Sum;
    }
}