class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int left = 1;
        int right = 10000000;
        int minimumSpeed = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(dist, hour, mid)) {
                minimumSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minimumSpeed;
    }

    private boolean isPossible(int[] dist, double hour, int speed) {
        double totalTime = 0;
        int n = dist.length;
        for (int i = 0; i < n - 1; i++) {
            totalTime += Math.ceil((double) (dist[i]) / speed);
        }
        totalTime += ((double) (dist[n - 1]) / speed);
        return totalTime <= hour;
    }
}