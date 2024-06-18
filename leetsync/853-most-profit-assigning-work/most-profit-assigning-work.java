class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int workerSize = worker.length;
        int difficultySize = difficulty.length;
        int totalProfit = 0;
        List<int[]> jobsList = new ArrayList<>();
        for (int i = 0; i < difficultySize; i++) {
            jobsList.add(new int[] { difficulty[i], profit[i] });
        }
        // Sort the vector based on difficulty
        Collections.sort(jobsList, (a, b) -> Integer.compare(a[0], b[0]));
        // Pre-processing to find the maximum profit till index i at constant time
        for (int i = 1; i < difficultySize; i++) {
            jobsList.get(i)[1] = Math.max(jobsList.get(i)[1], jobsList.get(i - 1)[1]);
        }
        for (int i = 0; i < workerSize; i++) {
            int workerDifficulty = worker[i];
            // Apply binary search on vec
            int low = 0;
            int high = difficultySize - 1;
            int maxProfit = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (jobsList.get(mid)[0] <= workerDifficulty) {
                    maxProfit = Math.max(maxProfit, jobsList.get(mid)[1]);
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}