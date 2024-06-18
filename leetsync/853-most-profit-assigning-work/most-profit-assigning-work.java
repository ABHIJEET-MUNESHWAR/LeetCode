class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int profitSize = profit.length;
        int workerSize = worker.length;
        // Create a max-heap using a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap by profit

        for (int i = 0; i < profitSize; i++) {
            pq.offer(new int[] { profit[i], difficulty[i] });
        }
        int totalProfit = 0;
        Arrays.sort(worker);
        for (int i = 0; i < workerSize / 2; i++) {
            int temp = worker[i];
            worker[i] = worker[workerSize - i - 1];
            worker[workerSize - i - 1] = temp;
        }
        int i = 0;
        while (i < workerSize && !pq.isEmpty()) {
            if (pq.peek()[1] > worker[i]) {
                pq.poll();
            } else {
                totalProfit += pq.peek()[0];
                i++;
            }
        }
        return totalProfit;
    }
}