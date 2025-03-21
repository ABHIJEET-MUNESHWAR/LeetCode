class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 0, right = 100000000000000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            boolean canCompleteTrips = canCompleteTrips(time, mid, totalTrips);
            if (canCompleteTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canCompleteTrips(int[] time, long mid, int totalTrips) {
        int n = time.length;
        long completedTrips = 0;
        for (int i = 0; i < n; i++) {
            completedTrips += mid / time[i];
        }
        return completedTrips >= totalTrips;
    }
}