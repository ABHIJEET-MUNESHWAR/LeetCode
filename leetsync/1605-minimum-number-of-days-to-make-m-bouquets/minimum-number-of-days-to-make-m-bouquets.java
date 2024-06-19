class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int totalFlowers = bloomDay.length;
        int totalRequiredFlowers = m * k;
        if (totalFlowers < totalRequiredFlowers) {
            return -1;
        }
        int totalRequiredDays = -1;
        int maximumDaysToWait = 0;
        for (int i = 0; i < totalFlowers; i++) {
            maximumDaysToWait = Math.max(maximumDaysToWait, bloomDay[i]);
        }
        int low = 0, high = maximumDaysToWait;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeMBouquets(bloomDay, mid, k, m)) {
                totalRequiredDays = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return totalRequiredDays;
    }

    private boolean canMakeMBouquets(int[] bloomDay, int mid, int k, int m) {
        int size = bloomDay.length;
        int totalBouquetsDone = 0;
        int totalFlowersPlucked = 0;
        for (int i = 0; i < size; i++) {
            int day = bloomDay[i];
            if (day <= mid) {
                totalFlowersPlucked++;
                if (totalFlowersPlucked == k) {
                    totalBouquetsDone++;
                    totalFlowersPlucked = 0;
                }
            } else {
                totalFlowersPlucked = 0;
            }
        }
        return totalBouquetsDone >= m;
    }
}