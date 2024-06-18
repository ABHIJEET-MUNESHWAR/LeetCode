class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int workerSize = worker.length;
        int difficultySize = difficulty.length;
        int totalProfit = 0;
        // Create an array of pairs to hold difficulty and profit
        int[][] jobs = new int[difficultySize][2];
        for (int i = 0; i < difficultySize; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        // Sort the vector based on difficulty
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        // Sort the worker array
        Arrays.sort(worker);
        int j = 0; // Pointer to vec array
        int maxProfit = 0;
        for (int i = 0; i < workerSize; i++) {
            while (j < difficultySize && worker[i] >= jobs[j][0]) {
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}